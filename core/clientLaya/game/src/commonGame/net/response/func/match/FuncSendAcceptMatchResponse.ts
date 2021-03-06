namespace Shine
{
	/** 推送接受匹配(generated by shine) */
	export class FuncSendAcceptMatchResponse extends FuncSResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.FuncSendAcceptMatch;
		
		/** 角色ID */
		public playerID:number;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.FuncSendAcceptMatch;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "FuncSendAcceptMatchResponse";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.playerID=stream.readLong();
			
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
	}
}
