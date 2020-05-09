namespace Shine
{
	/** 群里有权限成员通知处理申请结果(generated by shine) */
	export class FuncSendHandleApplyResultToMemberResponse extends FuncPlayerRoleGroupSResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.FuncSendHandleApplyResultToMember;
		
		/** 目标id */
		public targetID:number;
		
		/** 结果 */
		public result:number;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.FuncSendHandleApplyResultToMember;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.targetID=stream.readLong();
			
			this.result=stream.readInt();
			
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
	}
}