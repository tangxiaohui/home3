namespace Shine
{
	/** 单位AI数据(generated by shine) */
	export class UnitAIData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.UnitAI;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.UnitAI;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "UnitAIData";
		}
		
	}
}
