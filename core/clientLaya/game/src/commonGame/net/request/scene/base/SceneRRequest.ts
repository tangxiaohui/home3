namespace Shine
{
	/** 场景接收基类(generated by shine) */
	export class SceneRRequest extends GameRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.SceneR;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.SceneR;
		}
		
		protected copyData():void
		{
			super.copyData();
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "SceneRRequest";
		}
		
		/** 创建实例 */
		public static createSceneR():SceneRRequest
		{
			var re:SceneRRequest=new SceneRRequest();
			return re;
		}
		
	}
}