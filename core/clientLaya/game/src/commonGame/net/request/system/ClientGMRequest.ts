namespace Shine
{
	/** 客户端GM指令(generated by shine) */
	export class ClientGMRequest extends GameRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.ClientGM;
		
		/** 指令 */
		public cmd:string;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.ClientGM;
		}
		
		protected copyData():void
		{
			super.copyData();
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "ClientGMRequest";
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeUTF(this.cmd);
			
		}
		
		/** 创建实例 */
		public static createClientGM(cmd:string):ClientGMRequest
		{
			var re:ClientGMRequest=new ClientGMRequest();
			re.cmd=cmd;
			return re;
		}
		
	}
}
