namespace Shine
{
	/** 推送带参信息码消息(generated by shine) */
	export class SendInfoCodeWithArgsResponse extends GameResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.SendInfoCodeWithArgs;
		
		/** 码 */
		public code:number;
		
		/** 参数组 */
		public args:string[];
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.SendInfoCodeWithArgs;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "SendInfoCodeWithArgsResponse";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.code=stream.readInt();
			
			var argsLen:number=stream.readLen();
			this.args=new Array<string>(argsLen);
			var argsT:string[]=this.args;
			for(var argsI:number=0;argsI<argsLen;++argsI)
			{
				var argsV:string;
				argsV=stream.readUTF();
				
				argsT[argsI]=argsV;
			}
			
		}
		
		/** 执行 */
		protected execute():void
		{
			GameC.info.toShowInfoCode(this.code,true,this.args);
		}
		
	}
}
