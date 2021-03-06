namespace Shine
{
	/** 物品身份数据(extends)(generated by shine) */
	export class ItemIdentityData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.ItemIdentity;
		
		/** 类型(见ItemType) */
		public type:number;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.ItemIdentity;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "ItemIdentityData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.type=stream.readInt();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeInt(this.type);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof ItemIdentityData))
				return;
			
			var mData:ItemIdentityData=data as ItemIdentityData;
			
			this.type=mData.type;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof ItemIdentityData))
				return;
			
			var mData:ItemIdentityData=data as ItemIdentityData;
			
			this.type=mData.type;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			
		}
		
	}
}
