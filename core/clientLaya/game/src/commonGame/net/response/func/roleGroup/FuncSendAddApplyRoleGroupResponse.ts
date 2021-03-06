namespace Shine
{
	/** 添加申请消息(generated by shine) */
	export class FuncSendAddApplyRoleGroupResponse extends FuncPlayerRoleGroupSResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.FuncSendAddApplyRoleGroup;
		
		public data:PlayerApplyRoleGroupData;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.FuncSendAddApplyRoleGroup;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.data=stream.readDataSimpleNotNull() as PlayerApplyRoleGroupData;
			
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
	}
}
