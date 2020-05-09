namespace Shine
{
	/** 推送角色聊天(generated by shine) */
	export class SendPlayerChatResponse extends GameResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.SendPlayerChat;
		
		/** 聊天数据 */
		public chatData:RoleChatData;
		
		/** 频道 */
		public channel:number;
		
		/** 二级索引 */
		public key:number;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.SendPlayerChat;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.chatData=stream.readDataSimpleNotNull() as RoleChatData;
			
			this.channel=stream.readInt();
			
			this.key=stream.readLong();
			
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
	}
}