namespace Shine
{
	/** 活动完成一次消息(generated by shine) */
	export class ActivityCompleteOnceResponse extends GameResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.ActivityCompleteOnce;
		
		/** id */
		public id:number;
		
		/** 参与次数 */
		public joinTimes:number;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.ActivityCompleteOnce;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "ActivityCompleteOnceResponse";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.id=stream.readInt();
			
			this.joinTimes=stream.readInt();
			
		}
		
		/** 执行 */
		protected execute():void
		{
			this.me.activity.activityCompleteOnce(this.id,this.joinTimes);
		}
		
	}
}
