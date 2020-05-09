namespace Shine
{
	/** 功能发送消息(generated by shine) */
	export class FuncSResponse extends GameResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.FuncS;
		
		public funcID:number;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.FuncS;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "FuncSResponse";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.funcID=stream.readInt();
			
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
	}
}