namespace Shine
{
	/** 联系人数据(generated by shine) */
	export class ContactData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.Contact;
		
		/** 角色ID(现在这个是多出来的) */
		public playerID:number;
		
		/** 社交数据 */
		public data:RoleSocialData;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.Contact;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "ContactData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.playerID=stream.readLong();
			
			this.data=stream.readDataSimpleNotNull() as RoleSocialData;
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeLong(this.playerID);
			
			stream.writeDataSimpleNotNull(this.data);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof ContactData))
				return;
			
			var mData:ContactData=data as ContactData;
			
			this.playerID=mData.playerID;
			this.data=mData.data;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof ContactData))
				return;
			
			var mData:ContactData=data as ContactData;
			
			this.playerID=mData.playerID;
			
			this.data=mData.data.clone() as RoleSocialData;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			this.data=new RoleSocialData();
			this.data.initDefault();
		}
		
	}
}
