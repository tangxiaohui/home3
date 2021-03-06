namespace Shine
{
	/** buff表(generated by shine) */
	export class BuffConfig extends BaseConfig
	{
		/** 存储集合 */
		private static _dic:SMap<number,BuffConfig>;
		
		/** buffID */
		public id:number;
		
		/** 名字 */
		public name:string;
		
		/** 组ID */
		public groups:number[];
		
		/** 影响类型 */
		public influenceType:number;
		
		/** 叠加方式 */
		public plusType:number;
		
		/** 叠加上限 */
		public plusMax:number;
		
		/** 保留类型 */
		public keepType:number;
		
		/** 是否死亡移除 */
		public removeAtDead:boolean;
		
		/** 次数消耗类型 */
		public subNums:number[];
		
		/** 特效 */
		public effect:number;
		
		/** 描述 */
		public explain:string;
		
		/** 名字原值 */
		private _name:string;
		
		/** 描述原值 */
		private _explain:string;
		
		/** 获取 */
		public static get(id:number):BuffConfig
		{
			return this._dic.get(id);
		}
		
		/** 设置字典 */
		public static setDic(dic:SMap<number,BuffConfig>):void
		{
			this._dic=dic;
		}
		
		/** 添加字典(热更用) */
		public static addDic(dic:SMap<number,BuffConfig>):void
		{
			this._dic.putAll(dic);
		}
		
		/** 获取全部 */
		public static getDic():SMap<number,BuffConfig>
		{
			return this._dic;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.id=stream.readInt();
			
			this.name=stream.readUTF();
			
			var groupsLen:number=stream.readLen();
			this.groups=new Array<number>(groupsLen);
			var groupsT:number[]=this.groups;
			for(var groupsI:number=0;groupsI<groupsLen;++groupsI)
			{
				var groupsV:number;
				groupsV=stream.readInt();
				
				groupsT[groupsI]=groupsV;
			}
			
			this.influenceType=stream.readInt();
			
			this.plusType=stream.readInt();
			
			this.plusMax=stream.readInt();
			
			this.keepType=stream.readInt();
			
			this.removeAtDead=stream.readBoolean();
			
			var subNumsLen:number=stream.readLen();
			this.subNums=new Array<number>(subNumsLen);
			var subNumsT:number[]=this.subNums;
			for(var subNumsI:number=0;subNumsI<subNumsLen;++subNumsI)
			{
				var subNumsV:number;
				subNumsV=stream.readInt();
				
				subNumsT[subNumsI]=subNumsV;
			}
			
			this.effect=stream.readInt();
			
			this.explain=stream.readUTF();
			
		}
		
		/** 生成刷新配置 */
		protected generateRefresh():void
		{
			if(this._name==null)
				this._name=this.name;
			this.name=LanguageConfig.getText(this._name);
			
			if(this._explain==null)
				this._explain=this.explain;
			this.explain=LanguageConfig.getText(this._explain);
			
		}
		
		/** 读完所有表后处理 */
		public static afterReadConfigAll():void
		{
			
		}
		
	}
}
