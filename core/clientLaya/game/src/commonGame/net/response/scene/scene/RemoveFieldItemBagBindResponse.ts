namespace Shine
{
	/** (generated by shine) */
	export class RemoveFieldItemBagBindResponse extends SceneSResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.RemoveFieldItemBagBind;
		
		/** 单位实例id */
		public instanceID:number;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.RemoveFieldItemBagBind;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.instanceID=stream.readInt();
			
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
	}
}