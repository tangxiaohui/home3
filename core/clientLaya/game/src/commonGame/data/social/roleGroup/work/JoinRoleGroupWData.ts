namespace Shine
{
	/** 加入玩家群事务(generated by shine) */
	export class JoinRoleGroupWData extends PlayerFuncWorkData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.JoinRoleGroupW;
		
		/** 数据 */
		public data:PlayerRoleGroupData;
		
		/** 方式 */
		public type:number;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.JoinRoleGroupW;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.data=stream.readDataSimpleNotNull() as PlayerRoleGroupData;
			
			this.type=stream.readInt();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeDataSimpleNotNull(this.data);
			
			stream.writeInt(this.type);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			super.toShadowCopy(data);
			
			if(!(data instanceof JoinRoleGroupWData))
				return;
			
			var mData:JoinRoleGroupWData=data as JoinRoleGroupWData;
			
			this.data=mData.data;
			this.type=mData.type;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			super.toCopy(data);
			
			if(!(data instanceof JoinRoleGroupWData))
				return;
			
			var mData:JoinRoleGroupWData=data as JoinRoleGroupWData;
			
			this.data=mData.data.clone() as PlayerRoleGroupData;
			
			this.type=mData.type;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			super.initDefault();
			
			this.data=new PlayerRoleGroupData();
			this.data.initDefault();
		}
		
	}
}
