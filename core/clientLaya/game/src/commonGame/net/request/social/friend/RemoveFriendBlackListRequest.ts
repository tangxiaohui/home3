namespace Shine
{
	/** 移除好友黑名单(generated by shine) */
	export class RemoveFriendBlackListRequest extends GameRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.RemoveFriendBlackList;
		
		public playerID:number;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.RemoveFriendBlackList;
		}
		
		protected copyData():void
		{
			super.copyData();
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "RemoveFriendBlackListRequest";
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeLong(this.playerID);
			
		}
		
		/** 创建实例 */
		public static createRemoveFriendBlackList(playerID:number):RemoveFriendBlackListRequest
		{
			var re:RemoveFriendBlackListRequest=new RemoveFriendBlackListRequest();
			re.playerID=playerID;
			return re;
		}
		
	}
}