namespace Shine
{
	/** 玩家群成员数据(generated by shine) */
	export class RoleGroupMemberData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.RoleGroupMember;
		
		/** 角色ID */
		public playerID:number;
		
		/** 加入时间戳 */
		public joinTime:number;
		
		/** 社交数据 */
		public socialData:RoleSocialData;
		
		/** 职位 */
		public title:number;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.RoleGroupMember;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.playerID=stream.readLong();
			
			this.socialData=stream.readDataSimpleNotNull() as RoleSocialData;
			
			this.title=stream.readInt();
			
			this.joinTime=stream.readLong();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeLong(this.playerID);
			
			stream.writeDataSimpleNotNull(this.socialData);
			
			stream.writeInt(this.title);
			
			stream.writeLong(this.joinTime);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof RoleGroupMemberData))
				return;
			
			var mData:RoleGroupMemberData=data as RoleGroupMemberData;
			
			this.playerID=mData.playerID;
			this.socialData=mData.socialData;
			this.title=mData.title;
			this.joinTime=mData.joinTime;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof RoleGroupMemberData))
				return;
			
			var mData:RoleGroupMemberData=data as RoleGroupMemberData;
			
			this.playerID=mData.playerID;
			
			this.socialData=mData.socialData.clone() as RoleSocialData;
			
			this.title=mData.title;
			
			this.joinTime=mData.joinTime;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			this.socialData=new RoleSocialData();
			this.socialData.initDefault();
		}
		
	}
}