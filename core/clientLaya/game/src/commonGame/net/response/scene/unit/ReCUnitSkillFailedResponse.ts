namespace Shine
{
	/** 回复C单位技能失败(generated by shine) */
	export class ReCUnitSkillFailedResponse extends UnitSResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.ReCUnitSkillFailed;
		
		/** 技能ID */
		public skillID:number;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.ReCUnitSkillFailed;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "ReCUnitSkillFailedResponse";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.skillID=stream.readInt();
			
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
	}
}