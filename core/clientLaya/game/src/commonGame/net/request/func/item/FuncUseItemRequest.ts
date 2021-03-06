namespace Shine
{
	/** 使用物品消息(generated by shine) */
	export class FuncUseItemRequest extends FuncRRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.FuncUseItem;
		
		/** 格子序号 */
		public index:number;
		
		/** 数目 */
		public num:number;
		
		/** 道具ID(检验用) */
		public itemID:number;
		
		/** 额外使用参数 */
		public arg:UseItemArgData;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.FuncUseItem;
		}
		
		protected copyData():void
		{
			super.copyData();
			var argTemp:UseItemArgData=this.arg;
			if(argTemp!=null)
			{
				this.arg=argTemp.clone() as UseItemArgData;
			}
			else
			{
				this.arg=null;
			}
			
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "FuncUseItemRequest";
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.index);
			
			stream.writeInt(this.num);
			
			stream.writeInt(this.itemID);
			
			if(this.arg!=null)
			{
				stream.writeBoolean(true);
				stream.writeDataSimpleNotNull(this.arg);
			}
			else
			{
				stream.writeBoolean(false);
			}
			
		}
		
		/** 创建实例 */
		public static createFuncUseItem(funcID:number,index:number,num:number,itemID:number,arg:UseItemArgData):FuncUseItemRequest
		{
			var re:FuncUseItemRequest=new FuncUseItemRequest();
			re.funcID=funcID;
			re.index=index;
			re.num=num;
			re.itemID=itemID;
			re.arg=arg;
			return re;
		}
		
	}
}
