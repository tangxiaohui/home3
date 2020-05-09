namespace Shine
{
	/** 掉落包身份数据(generated by shine) */
	export class FieldItemBagIdentityData extends UnitIdentityData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.FieldItemBagIdentity;
		
		/** 来源怪物id */
		public fromMonsterID:number;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.FieldItemBagIdentity;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.fromMonsterID=stream.readInt();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.fromMonsterID);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			super.toShadowCopy(data);
			
			if(!(data instanceof FieldItemBagIdentityData))
				return;
			
			var mData:FieldItemBagIdentityData=data as FieldItemBagIdentityData;
			
			this.fromMonsterID=mData.fromMonsterID;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			super.toCopy(data);
			
			if(!(data instanceof FieldItemBagIdentityData))
				return;
			
			var mData:FieldItemBagIdentityData=data as FieldItemBagIdentityData;
			
			this.fromMonsterID=mData.fromMonsterID;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			super.initDefault();
			
		}
		
	}
}