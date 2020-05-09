namespace Shine
{
	/** 玩家群事务(generated by shine) */
	export class RoleGroupWorkData extends AreaGlobalWorkData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.RoleGroupWork;
		
		/** 功能id */
		public funcID:number;
		
		/** 群id */
		public groupID:number;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.RoleGroupWork;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.funcID=stream.readInt();
			
			this.groupID=stream.readLong();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.funcID);
			
			stream.writeLong(this.groupID);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			super.toShadowCopy(data);
			
			if(!(data instanceof RoleGroupWorkData))
				return;
			
			var mData:RoleGroupWorkData=data as RoleGroupWorkData;
			
			this.funcID=mData.funcID;
			this.groupID=mData.groupID;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			super.toCopy(data);
			
			if(!(data instanceof RoleGroupWorkData))
				return;
			
			var mData:RoleGroupWorkData=data as RoleGroupWorkData;
			
			this.funcID=mData.funcID;
			
			this.groupID=mData.groupID;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			super.initDefault();
			
		}
		
	}
}