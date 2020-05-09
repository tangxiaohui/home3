namespace Shine
{
	/** 载具身份数据(generated by shine) */
	export class VehicleIdentityData extends FightUnitIdentityData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.VehicleIdentity;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.VehicleIdentity;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "VehicleIdentityData";
		}
		
	}
}