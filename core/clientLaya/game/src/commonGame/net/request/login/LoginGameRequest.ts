namespace Shine
{
	/** 客户端登录逻辑服(generated by shine) */
	export class LoginGameRequest extends LoginRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.LoginGame;
		
		/** 令牌 */
		public token:number;
		
		/** c层msg版本号 */
		public cMsgVersion:number;
		
		/** g层msg版本号 */
		public gMsgVersion:number;
		
		/** 资源版本号 */
		public resourceVersion:number;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.LoginGame;
		}
		
		protected copyData():void
		{
			super.copyData();
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "LoginGameRequest";
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.token);
			
			stream.writeInt(this.cMsgVersion);
			
			stream.writeInt(this.gMsgVersion);
			
			stream.writeInt(this.resourceVersion);
			
		}
		
		/** 创建实例 */
		public static createLoginGame(token:number,cMsgVersion:number,gMsgVersion:number,resourceVersion:number):LoginGameRequest
		{
			var re:LoginGameRequest=new LoginGameRequest();
			re.token=token;
			re.cMsgVersion=cMsgVersion;
			re.gMsgVersion=gMsgVersion;
			re.resourceVersion=resourceVersion;
			return re;
		}
		
	}
}
