namespace Shine
{
	/** 刷新简版单位位置消息(generated by shine) */
	export class RefreshSimpleUnitPosResponse extends SceneSResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.RefreshSimpleUnitPos;
		
		public instanceID:number;
		
		public pos:PosData;
		
		public dir:DirData;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.RefreshSimpleUnitPos;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.instanceID=stream.readInt();
			
			this.pos=new PosData();
			this.pos.readBytesSimple(stream);
			
			this.dir=new DirData();
			this.dir.readBytesSimple(stream);
			
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
	}
}