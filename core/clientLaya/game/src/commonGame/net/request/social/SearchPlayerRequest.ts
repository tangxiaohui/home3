namespace Shine
{
	/** 通过id搜索玩家(generated by shine) */
	export class SearchPlayerRequest extends GameRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.SearchPlayer;
		
		public playerID:number;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.SearchPlayer;
		}
		
		protected copyData():void
		{
			super.copyData();
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "SearchPlayerRequest";
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeLong(this.playerID);
			
		}
		
		/** 创建实例 */
		public static createSearchPlayer(playerID:number):SearchPlayerRequest
		{
			var re:SearchPlayerRequest=new SearchPlayerRequest();
			re.playerID=playerID;
			return re;
		}
		
	}
}
