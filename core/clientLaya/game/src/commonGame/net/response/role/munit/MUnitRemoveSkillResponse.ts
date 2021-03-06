namespace Shine
{
	/** 主角删技能消息(generated by shine) */
	export class MUnitRemoveSkillResponse extends GameResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.MUnitRemoveSkill;
		
		/** 单位序号 */
		public index:number;
		
		/** id */
		public id:number;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.MUnitRemoveSkill;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.index=stream.readInt();
			
			this.id=stream.readInt();
			
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
	}
}
