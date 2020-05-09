namespace Shine
{
	/** 中心服推送信息码(generated by shine) */
	export class SendInfoCodeFromCenterResponse extends CenterResponse
	{
		/** 数据类型ID */
		public static dataID:number=CenterResponseType.SendInfoCodeFromCenter;
		
		/** 错误码 */
		public code:number;
		
		constructor()
		{
			super();
			this._dataID=CenterResponseType.SendInfoCodeFromCenter;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "SendInfoCodeFromCenterResponse";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.code=stream.readInt();
			
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
	}
}