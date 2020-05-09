namespace Shine
{
	/** 刷新简版单位属性消息(generated by shine) */
	export class RefreshSimpleUnitAttributeResponse extends SceneSResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.RefreshSimpleUnitAttribute;
		
		public instanceID:number;
		
		/** 改变的属性组 */
		public attributes:SMap<number,number>;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.RefreshSimpleUnitAttribute;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.instanceID=stream.readInt();
			
			var attributesLen:number=stream.readLen();
			if(this.attributes!=null)
			{
				this.attributes.clear();
				this.attributes.ensureCapacity(attributesLen);
			}
			else
			{
				this.attributes=new SMap<number,number>(attributesLen);
			}
			
			var attributesT:SMap<number,number>=this.attributes;
			for(var attributesI:number=attributesLen-1;attributesI>=0;--attributesI)
			{
				var attributesK:number;
				var attributesV:number;
				attributesK=stream.readInt();
				
				attributesV=stream.readInt();
				
				attributesT.put(attributesK,attributesV);
			}
			
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
	}
}