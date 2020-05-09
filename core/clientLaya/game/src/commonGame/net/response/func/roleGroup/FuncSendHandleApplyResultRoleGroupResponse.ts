namespace Shine
{
	/** 推送处理申请结果玩家群(generated by shine) */
	export class FuncSendHandleApplyResultRoleGroupResponse extends FuncSResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.FuncSendHandleApplyResultRoleGroup;
		
		/** 群id */
		public groupID:number;
		
		/** 结果 */
		public result:number;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.FuncSendHandleApplyResultRoleGroup;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.groupID=stream.readLong();
			
			this.result=stream.readInt();
			
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
	}
}