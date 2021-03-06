namespace Shine
{
	/** 重连消息(generated by shine) */
	export class SocketReconnectResponse extends ShineResponse
	{
		/** 数据类型ID */
		public static dataID:number=ShineResponseType.SocketReconnect;
		
		/** 源socketID */
		public socketID:number;
		
		/** 令牌 */
		public token:number;
		
		/** 最后收包索引 */
		public lastReceiveIndex:number;
		
		constructor()
		{
			super();
			this._dataID=ShineResponseType.SocketReconnect;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "SocketReconnectResponse";
		}
		
		/** 读取字节流(完整版) */
		protected toReadBytesFull(stream:BytesReadStream):void
		{
			super.toReadBytesFull(stream);
			
			var position:number=BytesReadStream.getReadBytes(stream);
			
			this.socketID=stream.readInt();
			
			this.token=stream.readInt();
			
			this.lastReceiveIndex=stream.readInt();
			
			BytesReadStream.disReadBytes(stream,position);
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.socketID=stream.readInt();
			
			this.token=stream.readInt();
			
			this.lastReceiveIndex=stream.readInt();
			
		}
		
		/** 转文本输出 */
		protected toWriteDataString(writer:DataWriter):void
		{
			super.toWriteDataString(writer);
			
			writer.writeTabs();
			writer.sb.append("socketID");
			writer.sb.append(':');
			writer.sb.append(this.socketID);
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("token");
			writer.sb.append(':');
			writer.sb.append(this.token);
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("lastReceiveIndex");
			writer.sb.append(':');
			writer.sb.append(this.lastReceiveIndex);
			
			writer.writeEnter();
		}
		
		/** 执行 */
		protected execute():void
		{
			Ctrl.errorLog("客户端不该受到SocketReconnect消息");
		}
		
	}
}
