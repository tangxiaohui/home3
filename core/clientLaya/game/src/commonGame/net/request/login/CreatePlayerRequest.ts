namespace Shine
{
	/** 创建角色消息(generated by shine) */
	export class CreatePlayerRequest extends LoginRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.CreatePlayer;
		
		/** 数据 */
		public data:CreatePlayerData;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.CreatePlayer;
		}
		
		protected copyData():void
		{
			super.copyData();
			var dataTemp:CreatePlayerData=this.data;
			this.data=dataTemp.clone() as CreatePlayerData;
			
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "CreatePlayerRequest";
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeDataSimpleNotNull(this.data);
			
		}
		
		/** 创建实例 */
		public static createCreatePlayer(data:CreatePlayerData):CreatePlayerRequest
		{
			var re:CreatePlayerRequest=new CreatePlayerRequest();
			re.data=data;
			return re;
		}
		
	}
}