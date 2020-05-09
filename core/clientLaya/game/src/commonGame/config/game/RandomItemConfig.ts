namespace Shine
{
	/** 随机单个物品配置(generated by shine) */
	export class RandomItemConfig extends BaseConfig
	{
		/** 存储集合 */
		private static _dic:SMap<number,RandomItemConfig>;
		
		/** id */
		public id:number;
		
		/** 类型 */
		public type:number;
		
		/** 参数组 */
		public args:number[][];
		
		/** 获取 */
		public static get(id:number):RandomItemConfig
		{
			return this._dic.get(id);
		}
		
		/** 设置字典 */
		public static setDic(dic:SMap<number,RandomItemConfig>):void
		{
			this._dic=dic;
		}
		
		/** 添加字典(热更用) */
		public static addDic(dic:SMap<number,RandomItemConfig>):void
		{
			this._dic.putAll(dic);
		}
		
		/** 获取全部 */
		public static getDic():SMap<number,RandomItemConfig>
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
			
		}
		
		/** 读完所有表后处理 */
		public static afterReadConfigAll():void
		{
			
		}
		
		/** 随机一个物品(可能为空) */
		public randomOne(entity:ILogicEntity):ItemData
		{
		switch(this.type)
		{
			case RandomItemType.Single:
			{
				var arr:number[]=this.args[0];

				if(arr[0]<=0)
					return null;

				return GameC.logic.createItem(arr[0],arr.length>1 ? arr[1] : 1);
			}
			case RandomItemType.AverageItem:
			{
				var arr:number[]=this.args[entity.randomInt(this.args.length)];

				if(arr[0]<=0)
					return null;

				return GameC.logic.createItem(arr[0],arr.length>1 ? arr[1] : 1);
			}
			case RandomItemType.WeightItem:
			{
				// var arr:number[]=this._weightTool.randomForIntArr(entity);

				// if(arr[1]<=0)
				// 	return null;

				return GameC.logic.createItem(arr[1],arr.length>2 ? arr[2] : 1);
			}
			case RandomItemType.WeightCreateItem:
			{
				// var arr:number[] =this._weightTool.randomForIntArr(entity);

				// if(arr[1]<=0)
				// 	return null;

				var data:ItemData=GameC.logic.createItemByCreateID(arr[1]);
				data.num=arr.length>2 ? arr[2] : 1;
				return data;
			}
			case RandomItemType.WeightRandomItem:
			{
				// var arr:number[]=this._weightTool.randomForIntArr(entity);

				// if(arr[1]<=0)
				// 	return null;

				return RandomItemConfig.get(arr[1]).randomOne(entity);
			}
		}

		return null;
	}
		
	}
}