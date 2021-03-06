namespace Shine
{
	/** (generated by shine) */
	export class SingleBagPartData extends BagPartData
	{
		/** 数据类型ID */
		public static dataID:number=PlayerPartDataType.SingleBag;
		
		constructor()
		{
			super();
			this._dataID=PlayerPartDataType.SingleBag;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "SingleBagPartData";
		}
		
		/** 读取字节流(完整版) */
		protected toReadBytesFull(stream:BytesReadStream):void
		{
			super.toReadBytesFull(stream);
			
			var position:number=BytesReadStream.getReadBytes(stream);
			
			BytesReadStream.disReadBytes(stream,position);
		}
		
		/** 写入字节流(完整版) */
		protected toWriteBytesFull(stream:BytesWriteStream):void
		{
			super.toWriteBytesFull(stream);
			
			var position:number=BytesWriteStream.getWriteBytes(stream);
			
			BytesWriteStream.disWriteBytes(stream,position);
		}
		
	}
}
