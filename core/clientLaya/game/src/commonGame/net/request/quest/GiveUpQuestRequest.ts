namespace Shine
{
	/** 放弃任务消息(generated by shine) */
	export class GiveUpQuestRequest extends GameRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.GiveUpQuest;
		
		/** 任务id */
		public id:number;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.GiveUpQuest;
		}
		
		protected copyData():void
		{
			super.copyData();
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "GiveUpQuestRequest";
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.id);
			
		}
		
		/** 创建实例 */
		public static createGiveUpQuest(id:number):GiveUpQuestRequest
		{
			var re:GiveUpQuestRequest=new GiveUpQuestRequest();
			re.id=id;
			return re;
		}
		
	}
}