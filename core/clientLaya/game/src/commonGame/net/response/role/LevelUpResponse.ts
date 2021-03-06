namespace Shine
{
	/** 升级消息(generated by shine) */
	export class LevelUpResponse extends GameResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.LevelUp;
		
		/** 升到多少级 */
		public level:number;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.LevelUp;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "LevelUpResponse";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.level=stream.readInt();
			
		}
		
		/** 执行 */
		protected execute():void
		{
			this.me.role.levelUpByServer(this.level);
		}
		
	}
}
