namespace Shine
{
	/** (generated by shine) */
	export class RePingResponse extends ShineResponse
	{
		/** 数据类型ID */
		public static dataID:number=ShineResponseType.RePing;
		
		constructor()
		{
			super();
			this._dataID=ShineResponseType.RePing;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "RePingResponse";
		}
		
		/** 读取字节流(完整版) */
		protected toReadBytesFull(stream:BytesReadStream):void
		{
			super.toReadBytesFull(stream);
			
			var position:number=BytesReadStream.getReadBytes(stream);
			
			BytesReadStream.disReadBytes(stream,position);
		}
		
		/** 执行 */
		protected execute():void
		{
			this.socket.refreshPingTime();
		}
		
	}
}
