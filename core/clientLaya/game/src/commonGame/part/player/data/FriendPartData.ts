namespace Shine
{
	/** (generated by shine) */
	export class FriendPartData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=PlayerPartDataType.Friend;
		
		/** 好友组(存库为了离线) */
		public friends:SMap<number,FriendData>;
		
		/** 黑名单组 */
		public blackList:SMap<number,ContactData>;
		
		/** 申请添加好友字典 */
		public applyDic:SMap<number,ApplyAddFriendData>;
		
		constructor()
		{
			super();
			this._dataID=PlayerPartDataType.Friend;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "FriendPartData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			var friendsLen:number=stream.readLen();
			if(this.friends!=null)
			{
				this.friends.clear();
				this.friends.ensureCapacity(friendsLen);
			}
			else
			{
				this.friends=new SMap<number,FriendData>(friendsLen);
			}
			
			var friendsT:SMap<number,FriendData>=this.friends;
			for(var friendsI:number=friendsLen-1;friendsI>=0;--friendsI)
			{
				var friendsV:FriendData;
				friendsV=stream.readDataSimpleNotNull() as FriendData;
				
				friendsT.put(friendsV.playerID,friendsV);
			}
			
			var blackListLen:number=stream.readLen();
			if(this.blackList!=null)
			{
				this.blackList.clear();
				this.blackList.ensureCapacity(blackListLen);
			}
			else
			{
				this.blackList=new SMap<number,ContactData>(blackListLen);
			}
			
			var blackListT:SMap<number,ContactData>=this.blackList;
			for(var blackListI:number=blackListLen-1;blackListI>=0;--blackListI)
			{
				var blackListV:ContactData;
				blackListV=stream.readDataSimpleNotNull() as ContactData;
				
				blackListT.put(blackListV.playerID,blackListV);
			}
			
			var applyDicLen:number=stream.readLen();
			if(this.applyDic!=null)
			{
				this.applyDic.clear();
				this.applyDic.ensureCapacity(applyDicLen);
			}
			else
			{
				this.applyDic=new SMap<number,ApplyAddFriendData>(applyDicLen);
			}
			
			var applyDicT:SMap<number,ApplyAddFriendData>=this.applyDic;
			for(var applyDicI:number=applyDicLen-1;applyDicI>=0;--applyDicI)
			{
				var applyDicV:ApplyAddFriendData;
				applyDicV=stream.readDataSimpleNotNull() as ApplyAddFriendData;
				
				applyDicT.put(applyDicV.playerID,applyDicV);
			}
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeLen(this.friends.size());
			if(!this.friends.isEmpty())
			{
				for(var friendsV of this.friends.getValues())
				{
					stream.writeDataSimpleNotNull(friendsV);
					
				}
			}
			
			stream.writeLen(this.blackList.size());
			if(!this.blackList.isEmpty())
			{
				for(var blackListV of this.blackList.getValues())
				{
					stream.writeDataSimpleNotNull(blackListV);
					
				}
			}
			
			stream.writeLen(this.applyDic.size());
			if(!this.applyDic.isEmpty())
			{
				for(var applyDicV of this.applyDic.getValues())
				{
					stream.writeDataSimpleNotNull(applyDicV);
					
				}
			}
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof FriendPartData))
				return;
			
			var mData:FriendPartData=data as FriendPartData;
			
			this.friends=mData.friends;
			this.blackList=mData.blackList;
			this.applyDic=mData.applyDic;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof FriendPartData))
				return;
			
			var mData:FriendPartData=data as FriendPartData;
			
			if(this.friends!=null)
			{
				this.friends.clear();
				this.friends.ensureCapacity(mData.friends.size());
			}
			else
			{
				this.friends=new SMap<number,FriendData>(mData.friends.size());
			}
			
			var friendsT:SMap<number,FriendData>=this.friends;
			if(!mData.friends.isEmpty())
			{
				for(var friendsV of mData.friends.getValues())
				{
					var friendsU:FriendData;
					friendsU=friendsV.clone() as FriendData;
					
					friendsT.put(friendsU.playerID,friendsU);
				}
			}
			
			if(this.blackList!=null)
			{
				this.blackList.clear();
				this.blackList.ensureCapacity(mData.blackList.size());
			}
			else
			{
				this.blackList=new SMap<number,ContactData>(mData.blackList.size());
			}
			
			var blackListT:SMap<number,ContactData>=this.blackList;
			if(!mData.blackList.isEmpty())
			{
				for(var blackListV of mData.blackList.getValues())
				{
					var blackListU:ContactData;
					blackListU=blackListV.clone() as ContactData;
					
					blackListT.put(blackListU.playerID,blackListU);
				}
			}
			
			if(this.applyDic!=null)
			{
				this.applyDic.clear();
				this.applyDic.ensureCapacity(mData.applyDic.size());
			}
			else
			{
				this.applyDic=new SMap<number,ApplyAddFriendData>(mData.applyDic.size());
			}
			
			var applyDicT:SMap<number,ApplyAddFriendData>=this.applyDic;
			if(!mData.applyDic.isEmpty())
			{
				for(var applyDicV of mData.applyDic.getValues())
				{
					var applyDicU:ApplyAddFriendData;
					applyDicU=applyDicV.clone() as ApplyAddFriendData;
					
					applyDicT.put(applyDicU.playerID,applyDicU);
				}
			}
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			this.friends=new SMap<number,FriendData>();
			this.blackList=new SMap<number,ContactData>();
			this.applyDic=new SMap<number,ApplyAddFriendData>();
		}
		
		/** 读取字节流(完整版) */
		protected toReadBytesFull(stream:BytesReadStream):void
		{
			var position:number=BytesReadStream.getReadBytes(stream);
			
			var friendsLen:number=stream.readLen();
			if(this.friends!=null)
			{
				this.friends.clear();
				this.friends.ensureCapacity(friendsLen);
			}
			else
			{
				this.friends=new SMap<number,FriendData>(friendsLen);
			}
			
			var friendsT:SMap<number,FriendData>=this.friends;
			for(var friendsI:number=friendsLen-1;friendsI>=0;--friendsI)
			{
				var friendsV:FriendData;
				friendsV=stream.readDataFullNotNull() as FriendData;
				
				friendsT.put(friendsV.playerID,friendsV);
			}
			
			var blackListLen:number=stream.readLen();
			if(this.blackList!=null)
			{
				this.blackList.clear();
				this.blackList.ensureCapacity(blackListLen);
			}
			else
			{
				this.blackList=new SMap<number,ContactData>(blackListLen);
			}
			
			var blackListT:SMap<number,ContactData>=this.blackList;
			for(var blackListI:number=blackListLen-1;blackListI>=0;--blackListI)
			{
				var blackListV:ContactData;
				blackListV=stream.readDataFullNotNull() as ContactData;
				
				blackListT.put(blackListV.playerID,blackListV);
			}
			
			var applyDicLen:number=stream.readLen();
			if(this.applyDic!=null)
			{
				this.applyDic.clear();
				this.applyDic.ensureCapacity(applyDicLen);
			}
			else
			{
				this.applyDic=new SMap<number,ApplyAddFriendData>(applyDicLen);
			}
			
			var applyDicT:SMap<number,ApplyAddFriendData>=this.applyDic;
			for(var applyDicI:number=applyDicLen-1;applyDicI>=0;--applyDicI)
			{
				var applyDicV:ApplyAddFriendData;
				applyDicV=stream.readDataFullNotNull() as ApplyAddFriendData;
				
				applyDicT.put(applyDicV.playerID,applyDicV);
			}
			
			BytesReadStream.disReadBytes(stream,position);
		}
		
		/** 写入字节流(完整版) */
		protected toWriteBytesFull(stream:BytesWriteStream):void
		{
			var position:number=BytesWriteStream.getWriteBytes(stream);
			
			stream.writeLen(this.friends.size());
			if(!this.friends.isEmpty())
			{
				for(var friendsV of this.friends.getValues())
				{
					stream.writeDataFullNotNull(friendsV);
					
				}
			}
			
			stream.writeLen(this.blackList.size());
			if(!this.blackList.isEmpty())
			{
				for(var blackListV of this.blackList.getValues())
				{
					stream.writeDataFullNotNull(blackListV);
					
				}
			}
			
			stream.writeLen(this.applyDic.size());
			if(!this.applyDic.isEmpty())
			{
				for(var applyDicV of this.applyDic.getValues())
				{
					stream.writeDataFullNotNull(applyDicV);
					
				}
			}
			
			BytesWriteStream.disWriteBytes(stream,position);
		}
		
		/** 是否数据一致 */
		protected toDataEquals(data:BaseData):boolean
		{
			var mData:FriendPartData=data as FriendPartData;
			if(this.friends==null)
				return false;
			if(this.friends.size()!=mData.friends.size())
				return false;
			var friendsR:SMap<number,FriendData>=mData.friends;
			if(!this.friends.isEmpty())
			{
				for(var friendsK of this.friends.getKeys())
				{
					var friendsV:FriendData=this.friends.get(friendsK);
					var friendsU:FriendData=friendsR.get(friendsK);
					if(friendsV==null)
						return false;
					if(!friendsV.dataEquals(friendsU))
						return false;
					
				}
			}
			
			if(this.blackList==null)
				return false;
			if(this.blackList.size()!=mData.blackList.size())
				return false;
			var blackListR:SMap<number,ContactData>=mData.blackList;
			if(!this.blackList.isEmpty())
			{
				for(var blackListK of this.blackList.getKeys())
				{
					var blackListV:ContactData=this.blackList.get(blackListK);
					var blackListU:ContactData=blackListR.get(blackListK);
					if(blackListV==null)
						return false;
					if(!blackListV.dataEquals(blackListU))
						return false;
					
				}
			}
			
			if(this.applyDic==null)
				return false;
			if(this.applyDic.size()!=mData.applyDic.size())
				return false;
			var applyDicR:SMap<number,ApplyAddFriendData>=mData.applyDic;
			if(!this.applyDic.isEmpty())
			{
				for(var applyDicK of this.applyDic.getKeys())
				{
					var applyDicV:ApplyAddFriendData=this.applyDic.get(applyDicK);
					var applyDicU:ApplyAddFriendData=applyDicR.get(applyDicK);
					if(applyDicV==null)
						return false;
					if(!applyDicV.dataEquals(applyDicU))
						return false;
					
				}
			}
			
			return true;
		}
		
		/** 转文本输出 */
		protected toWriteDataString(writer:DataWriter):void
		{
			writer.writeTabs();
			writer.sb.append("friends");
			writer.sb.append(':');
			writer.sb.append("Map<number,FriendData>");
			writer.sb.append('(');
			writer.sb.append(this.friends.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.friends.isEmpty())
			{
				for(var friendsK of this.friends.getKeys())
				{
					var friendsV:FriendData=this.friends.get(friendsK);
					writer.writeTabs();
					writer.sb.append(friendsK);
					
					writer.sb.append(':');
					friendsV.writeDataString(writer);
					
					writer.writeEnter();
				}
			}
			writer.writeRightBrace();
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("blackList");
			writer.sb.append(':');
			writer.sb.append("Map<number,ContactData>");
			writer.sb.append('(');
			writer.sb.append(this.blackList.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.blackList.isEmpty())
			{
				for(var blackListK of this.blackList.getKeys())
				{
					var blackListV:ContactData=this.blackList.get(blackListK);
					writer.writeTabs();
					writer.sb.append(blackListK);
					
					writer.sb.append(':');
					blackListV.writeDataString(writer);
					
					writer.writeEnter();
				}
			}
			writer.writeRightBrace();
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("applyDic");
			writer.sb.append(':');
			writer.sb.append("Map<number,ApplyAddFriendData>");
			writer.sb.append('(');
			writer.sb.append(this.applyDic.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.applyDic.isEmpty())
			{
				for(var applyDicK of this.applyDic.getKeys())
				{
					var applyDicV:ApplyAddFriendData=this.applyDic.get(applyDicK);
					writer.writeTabs();
					writer.sb.append(applyDicK);
					
					writer.sb.append(':');
					applyDicV.writeDataString(writer);
					
					writer.writeEnter();
				}
			}
			writer.writeRightBrace();
			
			writer.writeEnter();
		}
		
	}
}