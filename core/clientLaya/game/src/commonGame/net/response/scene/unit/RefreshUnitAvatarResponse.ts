namespace Shine
{
	/** 刷新单位造型消息(generated by shine) */
	export class RefreshUnitAvatarResponse extends UnitSResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.RefreshUnitAvatar;
		
		/** 模型ID */
		public modelID:number;
		
		/** 改变组 */
		public parts:SMap<number,number>;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.RefreshUnitAvatar;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "RefreshUnitAvatarResponse";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.modelID=stream.readInt();
			
			var partsLen:number=stream.readLen();
			if(this.parts!=null)
			{
				this.parts.clear();
				this.parts.ensureCapacity(partsLen);
			}
			else
			{
				this.parts=new SMap<number,number>(partsLen);
			}
			
			var partsT:SMap<number,number>=this.parts;
			for(var partsI:number=partsLen-1;partsI>=0;--partsI)
			{
				var partsK:number;
				var partsV:number;
				partsK=stream.readInt();
				
				partsV=stream.readInt();
				
				partsT.put(partsK,partsV);
			}
			
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
	}
}
