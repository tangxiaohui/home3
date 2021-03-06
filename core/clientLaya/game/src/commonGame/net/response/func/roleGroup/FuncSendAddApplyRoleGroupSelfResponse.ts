namespace Shine
{
	/** 添加申请玩家群到自身消息(generated by shine) */
	export class FuncSendAddApplyRoleGroupSelfResponse extends FuncSResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.FuncSendAddApplyRoleGroupSelf;
		
		/** 数据 */
		public data:PlayerApplyRoleGroupSelfData;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.FuncSendAddApplyRoleGroupSelf;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.data=stream.readDataSimpleNotNull() as PlayerApplyRoleGroupSelfData;
			
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
	}
}
