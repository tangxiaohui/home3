namespace Shine
{
	/** (generated by shine) */
	export class RePlayerLoginFromEachGameData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.RePlayerLoginFromEachGame;
		
		/** 玩家群组(key:funcID) */
		public roleGroups:SMap<number,SMap<number,PlayerRoleGroupData>>;
		
		/** 社交数据组 */
		public roleSocialDatas:SMap<number,RoleSocialData>;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.RePlayerLoginFromEachGame;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			var roleSocialDatasLen:number=stream.readLen();
			if(this.roleSocialDatas!=null)
			{
				this.roleSocialDatas.clear();
				this.roleSocialDatas.ensureCapacity(roleSocialDatasLen);
			}
			else
			{
				this.roleSocialDatas=new SMap<number,RoleSocialData>(roleSocialDatasLen);
			}
			
			var roleSocialDatasT:SMap<number,RoleSocialData>=this.roleSocialDatas;
			for(var roleSocialDatasI:number=roleSocialDatasLen-1;roleSocialDatasI>=0;--roleSocialDatasI)
			{
				var roleSocialDatasV:RoleSocialData;
				roleSocialDatasV=stream.readDataSimpleNotNull() as RoleSocialData;
				
				roleSocialDatasT.put(roleSocialDatasV.showData.playerID,roleSocialDatasV);
			}
			
			var roleGroupsLen:number=stream.readLen();
			if(this.roleGroups!=null)
			{
				this.roleGroups.clear();
				this.roleGroups.ensureCapacity(roleGroupsLen);
			}
			else
			{
				this.roleGroups=new SMap<number,SMap<number,PlayerRoleGroupData>>(roleGroupsLen);
			}
			
			var roleGroupsT:SMap<number,SMap<number,PlayerRoleGroupData>>=this.roleGroups;
			for(var roleGroupsI:number=roleGroupsLen-1;roleGroupsI>=0;--roleGroupsI)
			{
				var roleGroupsK:number;
				var roleGroupsV:SMap<number,PlayerRoleGroupData>;
				roleGroupsK=stream.readInt();
				
				var roleGroupsVLen:number=stream.readLen();
				roleGroupsV=new SMap<number,PlayerRoleGroupData>(roleGroupsVLen);
				var roleGroupsVT:SMap<number,PlayerRoleGroupData>=roleGroupsV;
				for(var roleGroupsVI:number=roleGroupsVLen-1;roleGroupsVI>=0;--roleGroupsVI)
				{
					var roleGroupsVK:number;
					var roleGroupsVV:PlayerRoleGroupData;
					roleGroupsVK=stream.readLong();
					
					roleGroupsVV=stream.readDataSimpleNotNull() as PlayerRoleGroupData;
					
					roleGroupsVT.put(roleGroupsVK,roleGroupsVV);
				}
				
				roleGroupsT.put(roleGroupsK,roleGroupsV);
			}
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeLen(this.roleSocialDatas.size());
			if(!this.roleSocialDatas.isEmpty())
			{
				for(var roleSocialDatasV of this.roleSocialDatas.getValues())
				{
					stream.writeDataSimpleNotNull(roleSocialDatasV);
					
				}
			}
			
			stream.writeLen(this.roleGroups.size());
			if(!this.roleGroups.isEmpty())
			{
				for(var roleGroupsK of this.roleGroups.getKeys())
				{
					var roleGroupsV:SMap<number,PlayerRoleGroupData>=this.roleGroups.get(roleGroupsK);
					stream.writeInt(roleGroupsK);
					
					stream.writeLen(roleGroupsV.size());
					if(!roleGroupsV.isEmpty())
					{
						for(var roleGroupsVK of roleGroupsV.getKeys())
						{
							var roleGroupsVV:PlayerRoleGroupData=roleGroupsV.get(roleGroupsVK);
							stream.writeLong(roleGroupsVK);
							
							stream.writeDataSimpleNotNull(roleGroupsVV);
							
						}
					}
					
				}
			}
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof RePlayerLoginFromEachGameData))
				return;
			
			var mData:RePlayerLoginFromEachGameData=data as RePlayerLoginFromEachGameData;
			
			this.roleSocialDatas=mData.roleSocialDatas;
			this.roleGroups=mData.roleGroups;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof RePlayerLoginFromEachGameData))
				return;
			
			var mData:RePlayerLoginFromEachGameData=data as RePlayerLoginFromEachGameData;
			
			if(this.roleSocialDatas!=null)
			{
				this.roleSocialDatas.clear();
				this.roleSocialDatas.ensureCapacity(mData.roleSocialDatas.size());
			}
			else
			{
				this.roleSocialDatas=new SMap<number,RoleSocialData>(mData.roleSocialDatas.size());
			}
			
			var roleSocialDatasT:SMap<number,RoleSocialData>=this.roleSocialDatas;
			if(!mData.roleSocialDatas.isEmpty())
			{
				for(var roleSocialDatasV of mData.roleSocialDatas.getValues())
				{
					var roleSocialDatasU:RoleSocialData;
					roleSocialDatasU=roleSocialDatasV.clone() as RoleSocialData;
					
					roleSocialDatasT.put(roleSocialDatasU.showData.playerID,roleSocialDatasU);
				}
			}
			
			if(this.roleGroups!=null)
			{
				this.roleGroups.clear();
				this.roleGroups.ensureCapacity(mData.roleGroups.size());
			}
			else
			{
				this.roleGroups=new SMap<number,SMap<number,PlayerRoleGroupData>>(mData.roleGroups.size());
			}
			
			var roleGroupsT:SMap<number,SMap<number,PlayerRoleGroupData>>=this.roleGroups;
			if(!mData.roleGroups.isEmpty())
			{
				for(var roleGroupsK of mData.roleGroups.getKeys())
				{
					var roleGroupsV:SMap<number,PlayerRoleGroupData>=mData.roleGroups.get(roleGroupsK);
					var roleGroupsW:number;
					var roleGroupsU:SMap<number,PlayerRoleGroupData>;
					roleGroupsW=roleGroupsK;
					
					roleGroupsU=new SMap<number,PlayerRoleGroupData>(roleGroupsV.size());
					var roleGroupsUT:SMap<number,PlayerRoleGroupData>=roleGroupsU;
					if(!roleGroupsV.isEmpty())
					{
						for(var roleGroupsUK of roleGroupsV.getKeys())
						{
							var roleGroupsUV:PlayerRoleGroupData=roleGroupsV.get(roleGroupsUK);
							var roleGroupsUW:number;
							var roleGroupsUU:PlayerRoleGroupData;
							roleGroupsUW=roleGroupsUK;
							
							roleGroupsUU=roleGroupsUV.clone() as PlayerRoleGroupData;
							
							roleGroupsUT.put(roleGroupsUW,roleGroupsUU);
						}
					}
					
					roleGroupsT.put(roleGroupsW,roleGroupsU);
				}
			}
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			this.roleSocialDatas=new SMap<number,RoleSocialData>();
			this.roleGroups=new SMap<number,SMap<number,PlayerRoleGroupData>>();
		}
		
	}
}