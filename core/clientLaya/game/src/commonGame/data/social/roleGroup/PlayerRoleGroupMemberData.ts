namespace Shine
{
	/** 角色玩家群成员数据(generated by shine) */
	export class PlayerRoleGroupMemberData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.PlayerRoleGroupMember;
		
		/** 角色ID */
		public playerID:number;
		
		/** 社交数据 */
		public socialData:RoleSocialData;
		
		/** 职位 */
		public title:number;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.PlayerRoleGroupMember;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.playerID=stream.readLong();
			
			this.socialData=stream.readDataSimpleNotNull() as RoleSocialData;
			
			this.title=stream.readInt();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeLong(this.playerID);
			
			stream.writeDataSimpleNotNull(this.socialData);
			
			stream.writeInt(this.title);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof PlayerRoleGroupMemberData))
				return;
			
			var mData:PlayerRoleGroupMemberData=data as PlayerRoleGroupMemberData;
			
			this.playerID=mData.playerID;
			this.socialData=mData.socialData;
			this.title=mData.title;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof PlayerRoleGroupMemberData))
				return;
			
			var mData:PlayerRoleGroupMemberData=data as PlayerRoleGroupMemberData;
			
			this.playerID=mData.playerID;
			
			this.socialData=mData.socialData.clone() as RoleSocialData;
			
			this.title=mData.title;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			this.socialData=new RoleSocialData();
			this.socialData.initDefault();
		}
		
	}
}
