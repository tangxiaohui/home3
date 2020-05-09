namespace Shine
{
	/** 使用激活码(generated by shine) */
	export class UseActivationCodeRequest extends GameRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.UseActivationCode;
		
		public code:string;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.UseActivationCode;
		}
		
		protected copyData():void
		{
			super.copyData();
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeUTF(this.code);
			
		}
		
		/** 创建实例 */
		public static createUseActivationCode(code:string):UseActivationCodeRequest
		{
			var re:UseActivationCodeRequest=new UseActivationCodeRequest();
			re.code=code;
			return re;
		}
		
	}
}