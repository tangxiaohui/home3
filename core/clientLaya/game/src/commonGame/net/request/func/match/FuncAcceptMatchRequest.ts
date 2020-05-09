namespace Shine
{
	/** 接受匹配(generated by shine) */
	export class FuncAcceptMatchRequest extends FuncRRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.FuncAcceptMatch;
		
		/** 序号 */
		public index:number;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.FuncAcceptMatch;
		}
		
		protected copyData():void
		{
			super.copyData();
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "FuncAcceptMatchRequest";
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.index);
			
		}
		
		/** 创建实例 */
		public static createFuncAcceptMatch(funcID:number,index:number):FuncAcceptMatchRequest
		{
			var re:FuncAcceptMatchRequest=new FuncAcceptMatchRequest();
			re.funcID=funcID;
			re.index=index;
			return re;
		}
		
	}
}