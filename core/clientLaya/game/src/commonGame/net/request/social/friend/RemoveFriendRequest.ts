namespace Shine
{
	/** 移除好友消息(generated by shine) */
	export class RemoveFriendRequest extends GameRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.RemoveFriend;
		
		/** 角色ID */
		public playerID:number;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.RemoveFriend;
		}
		
		protected copyData():void
		{
			super.copyData();
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "RemoveFriendRequest";
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeLong(this.playerID);
			
		}
		
		/** 创建实例 */
		public static createRemoveFriend(playerID:number):RemoveFriendRequest
		{
			var re:RemoveFriendRequest=new RemoveFriendRequest();
			re.playerID=playerID;
			return re;
		}
		
	}
}
