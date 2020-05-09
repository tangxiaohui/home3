namespace Shine
{
	/** 拾取物品消息(generated by shine) */
	export class CUnitPickUpItemRequest extends CUnitRRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.CUnitPickUpItem;
		
		/** 目标物品实例ID */
		public targetInstanceID:number;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.CUnitPickUpItem;
		}
		
		protected copyData():void
		{
			super.copyData();
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "CUnitPickUpItemRequest";
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.targetInstanceID);
			
		}
		
		/** 创建实例 */
		public static createCUnitPickUpItem(instanceID:number,targetInstanceID:number):CUnitPickUpItemRequest
		{
			var re:CUnitPickUpItemRequest=new CUnitPickUpItemRequest();
			re.instanceID=instanceID;
			re.targetInstanceID=targetInstanceID;
			return re;
		}
		
	}
}