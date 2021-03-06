namespace Shine
{
	/** 收到客户端离线事务消息(generated by shine) */
	export class ReceiveClientOfflineWorkResponse extends GameResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.ReceiveClientOfflineWork;
		
		/** 收到的序号 */
		public receiveIndex:number;
		
		/** 是否执行成功 */
		public success:boolean;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.ReceiveClientOfflineWork;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "ReceiveClientOfflineWorkResponse";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.receiveIndex=stream.readInt();
			
			this.success=stream.readBoolean();
			
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
	}
}
