namespace Shine
{
	/** 怪物身份数据(generated by shine) */
	export class MonsterIdentityData extends FightUnitIdentityData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.MonsterIdentity;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.MonsterIdentity;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "MonsterIdentityData";
		}
		
	}
}
