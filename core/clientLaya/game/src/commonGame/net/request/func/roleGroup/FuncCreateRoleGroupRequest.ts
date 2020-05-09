namespace Shine
{
	/** 创建玩家群消息(generated by shine) */
	export class FuncCreateRoleGroupRequest extends FuncRRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.FuncCreateRoleGroup;
		
		/** 创建数据 */
		public createData:CreateRoleGroupData;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.FuncCreateRoleGroup;
		}
		
		protected copyData():void
		{
			super.copyData();
			var createDataTemp:CreateRoleGroupData=this.createData;
			this.createData=createDataTemp.clone() as CreateRoleGroupData;
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeDataSimpleNotNull(this.createData);
			
		}
		
		/** 创建实例 */
		public static createFuncCreateRoleGroup(funcID:number,createData:CreateRoleGroupData):FuncCreateRoleGroupRequest
		{
			var re:FuncCreateRoleGroupRequest=new FuncCreateRoleGroupRequest();
			re.funcID=funcID;
			re.createData=createData;
			return re;
		}
		
	}
}