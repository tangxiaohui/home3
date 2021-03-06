namespace Shine
{
	/** 单位使用技能(generated by shine) */
	export class UnitUseSkillResponse extends UnitSResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.UnitUseSkill;
		
		/** 技能ID */
		public skillID:number;
		
		/** 技能等级 */
		public skillLevel:number;
		
		/** 目标数据 */
		public targetData:SkillTargetData;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.UnitUseSkill;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "UnitUseSkillResponse";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.skillID=stream.readInt();
			
			this.skillLevel=stream.readInt();
			
			this.targetData=stream.readDataSimpleNotNull() as SkillTargetData;
			
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
	}
}
