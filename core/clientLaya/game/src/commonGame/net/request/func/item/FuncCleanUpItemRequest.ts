namespace Shine
{
	/** 整理物品容器消息(generated by shine) */
	export class FuncCleanUpItemRequest extends FuncRRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.FuncCleanUpItem;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.FuncCleanUpItem;
		}
		
		protected copyData():void
		{
			super.copyData();
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "FuncCleanUpItemRequest";
		}
		
		/** 创建实例 */
		public static createFuncCleanUpItem(funcID:number):FuncCleanUpItemRequest
		{
			var re:FuncCleanUpItemRequest=new FuncCleanUpItemRequest();
			re.funcID=funcID;
			return re;
		}
		
	}
}
