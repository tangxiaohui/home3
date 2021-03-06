namespace Shine
{
	/** 更新自身所需角色社交数据到客户端(generated by shine) */
	export class UpdateRoleSocialDataRequest extends GameRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.UpdateRoleSocialData;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.UpdateRoleSocialData;
		}
		
		protected copyData():void
		{
			super.copyData();
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "UpdateRoleSocialDataRequest";
		}
		
		/** 创建实例 */
		public static createUpdateRoleSocialData():UpdateRoleSocialDataRequest
		{
			var re:UpdateRoleSocialDataRequest=new UpdateRoleSocialDataRequest();
			return re;
		}
		
	}
}
