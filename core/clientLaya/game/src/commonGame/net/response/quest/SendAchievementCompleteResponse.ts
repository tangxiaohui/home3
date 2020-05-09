namespace Shine
{
	/** 推送成就完成消息(generated by shine) */
	export class SendAchievementCompleteResponse extends GameResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.SendAchievementComplete;
		
		/** id */
		public id:number;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.SendAchievementComplete;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "SendAchievementCompleteResponse";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.id=stream.readInt();
			
		}
		
		/** 执行 */
		protected execute():void
		{
			this.me.achievement.onAchievementCompleteByServer(this.id);
		}
		
	}
}