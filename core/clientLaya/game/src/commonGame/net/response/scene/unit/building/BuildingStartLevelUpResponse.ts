namespace Shine
{
	/** 建筑开始升级(generated by shine) */
	export class BuildingStartLevelUpResponse extends UnitSResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.BuildingStartLevelUp;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.BuildingStartLevelUp;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "BuildingStartLevelUpResponse";
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
	}
}
