namespace Shine
{
	/** 随机物品组配置(generated by shine) */
	export class RandomItemListConfig extends BaseConfig
	{
		/** 存储集合 */
		private static _dic:SMap<number,RandomItemListConfig>;
		
		/** id */
		public id:number;
		
		/** 类型 */
		public type:number;
		
		/** 参数组 */
		public args:number[][];
		
		/** 展示物品组 */
		public showItems:DIntData[];
		
		/** 获取 */
		public static get(id:number):RandomItemListConfig
		{
			return this._dic.get(id);
		}
		
		/** 设置字典 */
		public static setDic(dic:SMap<number,RandomItemListConfig>):void
		{
			this._dic=dic;
		}
		
		/** 添加字典(热更用) */
		public static addDic(dic:SMap<number,RandomItemListConfig>):void
		{
			this._dic.putAll(dic);
		}
		
		/** 获取全部 */
		public static getDic():SMap<number,RandomItemListConfig>
		{
			return this._dic;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.id=stream.readInt();
			
			this.type=stream.readInt();
			
			var argsLen:number=stream.readLen();
			this.args=new Array<number[]>(argsLen);
			var argsT:number[][]=this.args;
			for(var argsI:number=0;argsI<argsLen;++argsI)
			{
				var argsV:number[];
				var argsVLen:number=stream.readLen();
				argsV=new Array<number>(argsVLen);
				var argsVT:number[]=argsV;
				for(var argsVI:number=0;argsVI<argsVLen;++argsVI)
				{
					var argsVV:number;
					argsVV=stream.readInt();
					
					argsVT[argsVI]=argsVV;
				}
				
				argsT[argsI]=argsV;
			}
			
			var showItemsLen:number=stream.readLen();
			this.showItems=new Array<DIntData>(showItemsLen);
			var showItemsT:DIntData[]=this.showItems;
			for(var showItemsI:number=0;showItemsI<showItemsLen;++showItemsI)
			{
				var showItemsV:DIntData;
				showItemsV=new DIntData();
				showItemsV.readBytesSimple(stream);
				
				showItemsT[showItemsI]=showItemsV;
			}
			
		}
		
		/** 读完所有表后处理 */
		public static afterReadConfigAll():void
		{
			
		}
		
	}
}
