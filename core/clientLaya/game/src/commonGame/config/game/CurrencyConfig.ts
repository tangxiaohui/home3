namespace Shine
{
	/** 货币表(generated by shine) */
	export class CurrencyConfig extends BaseConfig
	{
		/** 存储集合 */
		private static _dic:CurrencyConfig[];
		
		/** id */
		public id:number;
		
		/** 说明 */
		public explain:string;
		
		/** 关联物品ID */
		public bindItemID:number;
		
		/** 图标 */
		public icon:string;
		
		/** 图标(资源转) */
		public iconT:number;
		
		/** 是否需要记录累计获得的货币 */
		public needAddRecord:boolean;
		
		/** 说明原值 */
		private _explain:string;
		
		/** 是否可在addAbs时突破上限 */
		public canOverMaxByAbs:boolean;
		
		/** 获取 */
		public static get(id:number):CurrencyConfig
		{
			return id>=0 && id<this._dic.length ? this._dic[id] : null;
		}
		
		/** 设置字典 */
		public static setDic(dic:CurrencyConfig[]):void
		{
			this._dic=dic;
		}
		
		/** 添加字典(热更用) */
		public static addDic(dic:CurrencyConfig[]):void
		{
			ObjectUtils.arrayPutAll(this._dic,dic);
		}
		
		/** 获取全部 */
		public static getDic():CurrencyConfig[]
		{
			return this._dic;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.id=stream.readInt();
			
			this.explain=stream.readUTF();
			
			this.bindItemID=stream.readInt();
			
			this.icon=stream.readUTF();
			
			this.needAddRecord=stream.readBoolean();
			
			this.canOverMaxByAbs=stream.readBoolean();
			
		}
		
		/** 生成刷新配置 */
		protected generateRefresh():void
		{
			if(this._explain==null)
				this._explain=this.explain;
			this.explain=LanguageConfig.getText(this._explain);
			
			this.iconT=LoadControl.getResourceIDByName(this.icon);
		}
		
		/** 读完所有表后处理 */
		public static afterReadConfigAll():void
		{
			
		}
		
	}
}