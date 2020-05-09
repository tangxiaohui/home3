namespace Shine
{
	/** 操作体身份数据(generated by shine) */
	export class OperationIdentityData extends UnitIdentityData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.OperationIdentity;
		
		/** 操作体状态(见OperationStateType) */
		public state:number;
		
		/** id */
		public id:number;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.OperationIdentity;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "OperationIdentityData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.id=stream.readInt();
			
			this.state=stream.readInt();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.id);
			
			stream.writeInt(this.state);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			super.toShadowCopy(data);
			
			if(!(data instanceof OperationIdentityData))
				return;
			
			var mData:OperationIdentityData=data as OperationIdentityData;
			
			this.id=mData.id;
			this.state=mData.state;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			super.toCopy(data);
			
			if(!(data instanceof OperationIdentityData))
				return;
			
			var mData:OperationIdentityData=data as OperationIdentityData;
			
			this.id=mData.id;
			
			this.state=mData.state;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			super.initDefault();
			
		}
		
	}
}