namespace Shine
{
	/** 成就表(generated by shine) */
	export class AchievementConfig extends BaseConfig
	{
		/** 存储集合 */
		private static _dic:SMap<number,AchievementConfig>;
		
		/** id */
		public id:number;
		
		/** 名字 */
		public name:string;
		
		/** 类型 */
		public type:number;
		
		/** 前置成就组 */
		public pres:number[];
		
		/** 任务目标 */
		public taskID:number;
		
		/** 奖励id */
		public rewardID:number;
		
		/** 成就描述 */
		public explain:string;
		
		/** 名字原值 */
		private _name:string;
		
		/** 成就描述原值 */
		private _explain:string;
		
		/** 获取 */
		public static get(id:number):AchievementConfig
		{
			return this._dic.get(id);
		}
		
		/** 设置字典 */
		public static setDic(dic:SMap<number,AchievementConfig>):void
		{
			this._dic=dic;
		}
		
		/** 添加字典(热更用) */
		public static addDic(dic:SMap<number,AchievementConfig>):void
		{
			this._dic.putAll(dic);
		}
		
		/** 获取全部 */
		public static getDic():SMap<number,AchievementConfig>
		{
			return this._dic;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.id=stream.readInt();
			
			this.name=stream.readUTF();
			
			this.type=stream.readInt();
			
			this.taskID=stream.readInt();
			
			var presLen:number=stream.readLen();
			this.pres=new Array<number>(presLen);
			var presT:number[]=this.pres;
			for(var presI:number=0;presI<presLen;++presI)
			{
				var presV:number;
				presV=stream.readInt();
				
				presT[presI]=presV;
			}
			
			this.rewardID=stream.readInt();
			
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
