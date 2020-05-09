namespace Shine
{
	/** 推送删除邮件消息(generated by shine) */
	export class SendDeleteMailResponse extends GameResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.SendDeleteMail;
		
		/** 邮件序号 */
		public index:number;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.SendDeleteMail;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "SendDeleteMailResponse";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.index=stream.readInt();
			
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
	}
}