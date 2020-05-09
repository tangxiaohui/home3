package com.home.commonBase.part.player.data;
import com.home.commonBase.constlist.generate.PlayerPartDataType;
import com.home.commonBase.data.social.friend.ApplyAddFriendData;
import com.home.commonBase.data.social.friend.ContactData;
import com.home.commonBase.data.social.friend.FriendData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.LongObjectMap;
import com.home.shine.support.collection.LongSet;
import com.home.shine.support.pool.DataPool;

/** 好友数据(generated by shine) */
public class FriendPartData extends BaseData
{
	/** 黑名单组 */
	public LongObjectMap<ContactData> blackList;
	
	/** 被好友组 */
	public LongSet beFriends;
	
	/** 好友组(存库为了离线) */
	public LongObjectMap<FriendData> friends;
	
	/** 申请添加好友字典 */
	public LongObjectMap<ApplyAddFriendData> applyDic;
	
	/** 机器人好友序号 */
	public int robotIndex;
	
	/** 数据类型ID */
	public static final int dataID=PlayerPartDataType.Friend;
	
	public FriendPartData()
	{
		_dataID=PlayerPartDataType.Friend;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FriendPartData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		int friendsLen=stream.readLen();
		if(this.friends!=null)
		{
			this.friends.clear();
			this.friends.ensureCapacity(friendsLen);
		}
		else
		{
			this.friends=new LongObjectMap<FriendData>(FriendData[]::new,friendsLen);
		}
		
		LongObjectMap<FriendData> friendsT=this.friends;
		for(int friendsI=friendsLen-1;friendsI>=0;--friendsI)
		{
			FriendData friendsV;
			BaseData friendsVT=stream.readDataFullNotNull();
			if(friendsVT!=null)
			{
				if(friendsVT instanceof FriendData)
				{
					friendsV=(FriendData)friendsVT;
				}
				else
				{
					friendsV=new FriendData();
					if(!(friendsVT.getClass().isAssignableFrom(FriendData.class)))
					{
						stream.throwTypeReadError(FriendData.class,friendsVT.getClass());
					}
					friendsV.shadowCopy(friendsVT);
				}
			}
			else
			{
				friendsV=null;
			}
			
			friendsT.put(friendsV.playerID,friendsV);
		}
		
		int blackListLen=stream.readLen();
		if(this.blackList!=null)
		{
			this.blackList.clear();
			this.blackList.ensureCapacity(blackListLen);
		}
		else
		{
			this.blackList=new LongObjectMap<ContactData>(ContactData[]::new,blackListLen);
		}
		
		LongObjectMap<ContactData> blackListT=this.blackList;
		for(int blackListI=blackListLen-1;blackListI>=0;--blackListI)
		{
			ContactData blackListV;
			BaseData blackListVT=stream.readDataFullNotNull();
			if(blackListVT!=null)
			{
				if(blackListVT instanceof ContactData)
				{
					blackListV=(ContactData)blackListVT;
				}
				else
				{
					blackListV=new ContactData();
					if(!(blackListVT.getClass().isAssignableFrom(ContactData.class)))
					{
						stream.throwTypeReadError(ContactData.class,blackListVT.getClass());
					}
					blackListV.shadowCopy(blackListVT);
				}
			}
			else
			{
				blackListV=null;
			}
			
			blackListT.put(blackListV.playerID,blackListV);
		}
		
		int beFriendsLen=stream.readLen();
		if(this.beFriends!=null)
		{
			this.beFriends.clear();
			this.beFriends.ensureCapacity(beFriendsLen);
		}
		else
		{
			this.beFriends=new LongSet(beFriendsLen);
		}
		
		LongSet beFriendsT=this.beFriends;
		for(int beFriendsI=beFriendsLen-1;beFriendsI>=0;--beFriendsI)
		{
			long beFriendsV;
			beFriendsV=stream.readLong();
			
			beFriendsT.add(beFriendsV);
		}
		
		int applyDicLen=stream.readLen();
		if(this.applyDic!=null)
		{
			this.applyDic.clear();
			this.applyDic.ensureCapacity(applyDicLen);
		}
		else
		{
			this.applyDic=new LongObjectMap<ApplyAddFriendData>(ApplyAddFriendData[]::new,applyDicLen);
		}
		
		LongObjectMap<ApplyAddFriendData> applyDicT=this.applyDic;
		for(int applyDicI=applyDicLen-1;applyDicI>=0;--applyDicI)
		{
			ApplyAddFriendData applyDicV;
			BaseData applyDicVT=stream.readDataFullNotNull();
			if(applyDicVT!=null)
			{
				if(applyDicVT instanceof ApplyAddFriendData)
				{
					applyDicV=(ApplyAddFriendData)applyDicVT;
				}
				else
				{
					applyDicV=new ApplyAddFriendData();
					if(!(applyDicVT.getClass().isAssignableFrom(ApplyAddFriendData.class)))
					{
						stream.throwTypeReadError(ApplyAddFriendData.class,applyDicVT.getClass());
					}
					applyDicV.shadowCopy(applyDicVT);
				}
			}
			else
			{
				applyDicV=null;
			}
			
			applyDicT.put(applyDicV.playerID,applyDicV);
		}
		
		this.robotIndex=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.friends!=null)
		{
			stream.writeLen(this.friends.size());
			if(!this.friends.isEmpty())
			{
				Object[] friendsVValues=this.friends.getValues();
				for(int friendsVI=friendsVValues.length-1;friendsVI>=0;--friendsVI)
				{
					if(friendsVValues[friendsVI]!=null)
					{
						FriendData friendsV=(FriendData)friendsVValues[friendsVI];
						if(friendsV!=null)
						{
							stream.writeDataFullNotNull(friendsV);
						}
						else
						{
							nullObjError("friendsV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("friends");
		}
		
		if(this.blackList!=null)
		{
			stream.writeLen(this.blackList.size());
			if(!this.blackList.isEmpty())
			{
				Object[] blackListVValues=this.blackList.getValues();
				for(int blackListVI=blackListVValues.length-1;blackListVI>=0;--blackListVI)
				{
					if(blackListVValues[blackListVI]!=null)
					{
						ContactData blackListV=(ContactData)blackListVValues[blackListVI];
						if(blackListV!=null)
						{
							stream.writeDataFullNotNull(blackListV);
						}
						else
						{
							nullObjError("blackListV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("blackList");
		}
		
		if(this.beFriends!=null)
		{
			stream.writeLen(this.beFriends.size());
			if(!this.beFriends.isEmpty())
			{
				long beFriendsVFreeValue=this.beFriends.getFreeValue();
				long[] beFriendsVKeys=this.beFriends.getKeys();
				for(int beFriendsVI=beFriendsVKeys.length-1;beFriendsVI>=0;--beFriendsVI)
				{
					long beFriendsV=beFriendsVKeys[beFriendsVI];
					if(beFriendsV!=beFriendsVFreeValue)
					{
						stream.writeLong(beFriendsV);
						
					}
				}
			}
		}
		else
		{
			nullObjError("beFriends");
		}
		
		if(this.applyDic!=null)
		{
			stream.writeLen(this.applyDic.size());
			if(!this.applyDic.isEmpty())
			{
				Object[] applyDicVValues=this.applyDic.getValues();
				for(int applyDicVI=applyDicVValues.length-1;applyDicVI>=0;--applyDicVI)
				{
					if(applyDicVValues[applyDicVI]!=null)
					{
						ApplyAddFriendData applyDicV=(ApplyAddFriendData)applyDicVValues[applyDicVI];
						if(applyDicV!=null)
						{
							stream.writeDataFullNotNull(applyDicV);
						}
						else
						{
							nullObjError("applyDicV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("applyDic");
		}
		
		stream.writeInt(this.robotIndex);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		int friendsLen=stream.readLen();
		if(this.friends!=null)
		{
			this.friends.clear();
			this.friends.ensureCapacity(friendsLen);
		}
		else
		{
			this.friends=new LongObjectMap<FriendData>(FriendData[]::new,friendsLen);
		}
		
		LongObjectMap<FriendData> friendsT=this.friends;
		for(int friendsI=friendsLen-1;friendsI>=0;--friendsI)
		{
			FriendData friendsV;
			friendsV=(FriendData)stream.readDataSimpleNotNull();
			
			friendsT.put(friendsV.playerID,friendsV);
		}
		
		int blackListLen=stream.readLen();
		if(this.blackList!=null)
		{
			this.blackList.clear();
			this.blackList.ensureCapacity(blackListLen);
		}
		else
		{
			this.blackList=new LongObjectMap<ContactData>(ContactData[]::new,blackListLen);
		}
		
		LongObjectMap<ContactData> blackListT=this.blackList;
		for(int blackListI=blackListLen-1;blackListI>=0;--blackListI)
		{
			ContactData blackListV;
			blackListV=(ContactData)stream.readDataSimpleNotNull();
			
			blackListT.put(blackListV.playerID,blackListV);
		}
		
		int beFriendsLen=stream.readLen();
		if(this.beFriends!=null)
		{
			this.beFriends.clear();
			this.beFriends.ensureCapacity(beFriendsLen);
		}
		else
		{
			this.beFriends=new LongSet(beFriendsLen);
		}
		
		LongSet beFriendsT=this.beFriends;
		for(int beFriendsI=beFriendsLen-1;beFriendsI>=0;--beFriendsI)
		{
			long beFriendsV;
			beFriendsV=stream.readLong();
			
			beFriendsT.add(beFriendsV);
		}
		
		int applyDicLen=stream.readLen();
		if(this.applyDic!=null)
		{
			this.applyDic.clear();
			this.applyDic.ensureCapacity(applyDicLen);
		}
		else
		{
			this.applyDic=new LongObjectMap<ApplyAddFriendData>(ApplyAddFriendData[]::new,applyDicLen);
		}
		
		LongObjectMap<ApplyAddFriendData> applyDicT=this.applyDic;
		for(int applyDicI=applyDicLen-1;applyDicI>=0;--applyDicI)
		{
			ApplyAddFriendData applyDicV;
			applyDicV=(ApplyAddFriendData)stream.readDataSimpleNotNull();
			
			applyDicT.put(applyDicV.playerID,applyDicV);
		}
		
		this.robotIndex=stream.readInt();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.friends!=null)
		{
			stream.writeLen(this.friends.size());
			if(!this.friends.isEmpty())
			{
				Object[] friendsVValues=this.friends.getValues();
				for(int friendsVI=friendsVValues.length-1;friendsVI>=0;--friendsVI)
				{
					if(friendsVValues[friendsVI]!=null)
					{
						FriendData friendsV=(FriendData)friendsVValues[friendsVI];
						if(friendsV!=null)
						{
							stream.writeDataSimpleNotNull(friendsV);
						}
						else
						{
							nullObjError("friendsV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("friends");
		}
		
		if(this.blackList!=null)
		{
			stream.writeLen(this.blackList.size());
			if(!this.blackList.isEmpty())
			{
				Object[] blackListVValues=this.blackList.getValues();
				for(int blackListVI=blackListVValues.length-1;blackListVI>=0;--blackListVI)
				{
					if(blackListVValues[blackListVI]!=null)
					{
						ContactData blackListV=(ContactData)blackListVValues[blackListVI];
						if(blackListV!=null)
						{
							stream.writeDataSimpleNotNull(blackListV);
						}
						else
						{
							nullObjError("blackListV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("blackList");
		}
		
		if(this.beFriends!=null)
		{
			stream.writeLen(this.beFriends.size());
			if(!this.beFriends.isEmpty())
			{
				long beFriendsVFreeValue=this.beFriends.getFreeValue();
				long[] beFriendsVKeys=this.beFriends.getKeys();
				for(int beFriendsVI=beFriendsVKeys.length-1;beFriendsVI>=0;--beFriendsVI)
				{
					long beFriendsV=beFriendsVKeys[beFriendsVI];
					if(beFriendsV!=beFriendsVFreeValue)
					{
						stream.writeLong(beFriendsV);
						
					}
				}
			}
		}
		else
		{
			nullObjError("beFriends");
		}
		
		if(this.applyDic!=null)
		{
			stream.writeLen(this.applyDic.size());
			if(!this.applyDic.isEmpty())
			{
				Object[] applyDicVValues=this.applyDic.getValues();
				for(int applyDicVI=applyDicVValues.length-1;applyDicVI>=0;--applyDicVI)
				{
					if(applyDicVValues[applyDicVI]!=null)
					{
						ApplyAddFriendData applyDicV=(ApplyAddFriendData)applyDicVValues[applyDicVI];
						if(applyDicV!=null)
						{
							stream.writeDataSimpleNotNull(applyDicV);
						}
						else
						{
							nullObjError("applyDicV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("applyDic");
		}
		
		stream.writeInt(this.robotIndex);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof FriendPartData))
			return;
		
		FriendPartData mData=(FriendPartData)data;
		
		this.friends=mData.friends;
		this.blackList=mData.blackList;
		this.beFriends=mData.beFriends;
		this.applyDic=mData.applyDic;
		this.robotIndex=mData.robotIndex;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof FriendPartData))
			return;
		
		FriendPartData mData=(FriendPartData)data;
		
		if(mData.friends!=null)
		{
			if(this.friends!=null)
			{
				this.friends.clear();
				this.friends.ensureCapacity(mData.friends.size());
			}
			else
			{
				this.friends=new LongObjectMap<FriendData>(FriendData[]::new,mData.friends.size());
			}
			
			LongObjectMap<FriendData> friendsT=this.friends;
			if(!mData.friends.isEmpty())
			{
				Object[] friendsVValues=mData.friends.getValues();
				for(int friendsVI=friendsVValues.length-1;friendsVI>=0;--friendsVI)
				{
					if(friendsVValues[friendsVI]!=null)
					{
						FriendData friendsV=(FriendData)friendsVValues[friendsVI];
						FriendData friendsU;
						if(friendsV!=null)
						{
							friendsU=(FriendData)friendsV.clone();
						}
						else
						{
							friendsU=null;
							nullObjError("friendsU");
						}
						
						friendsT.put(friendsU.playerID,friendsU);
					}
				}
			}
		}
		else
		{
			this.friends=null;
			nullObjError("friends");
		}
		
		if(mData.blackList!=null)
		{
			if(this.blackList!=null)
			{
				this.blackList.clear();
				this.blackList.ensureCapacity(mData.blackList.size());
			}
			else
			{
				this.blackList=new LongObjectMap<ContactData>(ContactData[]::new,mData.blackList.size());
			}
			
			LongObjectMap<ContactData> blackListT=this.blackList;
			if(!mData.blackList.isEmpty())
			{
				Object[] blackListVValues=mData.blackList.getValues();
				for(int blackListVI=blackListVValues.length-1;blackListVI>=0;--blackListVI)
				{
					if(blackListVValues[blackListVI]!=null)
					{
						ContactData blackListV=(ContactData)blackListVValues[blackListVI];
						ContactData blackListU;
						if(blackListV!=null)
						{
							blackListU=(ContactData)blackListV.clone();
						}
						else
						{
							blackListU=null;
							nullObjError("blackListU");
						}
						
						blackListT.put(blackListU.playerID,blackListU);
					}
				}
			}
		}
		else
		{
			this.blackList=null;
			nullObjError("blackList");
		}
		
		if(mData.beFriends!=null)
		{
			if(this.beFriends!=null)
			{
				this.beFriends.clear();
				this.beFriends.ensureCapacity(mData.beFriends.size());
			}
			else
			{
				this.beFriends=new LongSet(mData.beFriends.size());
			}
			
			LongSet beFriendsT=this.beFriends;
			if(!mData.beFriends.isEmpty())
			{
				long beFriendsVFreeValue=mData.beFriends.getFreeValue();
				long[] beFriendsVKeys=mData.beFriends.getKeys();
				for(int beFriendsVI=beFriendsVKeys.length-1;beFriendsVI>=0;--beFriendsVI)
				{
					long beFriendsV=beFriendsVKeys[beFriendsVI];
					if(beFriendsV!=beFriendsVFreeValue)
					{
						long beFriendsU;
						beFriendsU=beFriendsV;
						
						beFriendsT.add(beFriendsU);
					}
				}
			}
		}
		else
		{
			this.beFriends=null;
			nullObjError("beFriends");
		}
		
		if(mData.applyDic!=null)
		{
			if(this.applyDic!=null)
			{
				this.applyDic.clear();
				this.applyDic.ensureCapacity(mData.applyDic.size());
			}
			else
			{
				this.applyDic=new LongObjectMap<ApplyAddFriendData>(ApplyAddFriendData[]::new,mData.applyDic.size());
			}
			
			LongObjectMap<ApplyAddFriendData> applyDicT=this.applyDic;
			if(!mData.applyDic.isEmpty())
			{
				Object[] applyDicVValues=mData.applyDic.getValues();
				for(int applyDicVI=applyDicVValues.length-1;applyDicVI>=0;--applyDicVI)
				{
					if(applyDicVValues[applyDicVI]!=null)
					{
						ApplyAddFriendData applyDicV=(ApplyAddFriendData)applyDicVValues[applyDicVI];
						ApplyAddFriendData applyDicU;
						if(applyDicV!=null)
						{
							applyDicU=(ApplyAddFriendData)applyDicV.clone();
						}
						else
						{
							applyDicU=null;
							nullObjError("applyDicU");
						}
						
						applyDicT.put(applyDicU.playerID,applyDicU);
					}
				}
			}
		}
		else
		{
			this.applyDic=null;
			nullObjError("applyDic");
		}
		
		this.robotIndex=mData.robotIndex;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		FriendPartData mData=(FriendPartData)data;
		if(mData.friends!=null)
		{
			if(this.friends==null)
				return false;
			if(this.friends.size()!=mData.friends.size())
				return false;
			LongObjectMap<FriendData> friendsR=mData.friends;
			if(!this.friends.isEmpty())
			{
				long friendsKFreeValue=this.friends.getFreeValue();
				long[] friendsKKeys=this.friends.getKeys();
				Object[] friendsVValues=this.friends.getValues();
				for(int friendsKI=friendsKKeys.length-1;friendsKI>=0;--friendsKI)
				{
					long friendsK=friendsKKeys[friendsKI];
					if(friendsK!=friendsKFreeValue)
					{
						FriendData friendsV=(FriendData)friendsVValues[friendsKI];
						FriendData friendsU=friendsR.get(friendsK);
						if(friendsU!=null)
						{
							if(friendsV==null)
								return false;
							if(!friendsV.dataEquals(friendsU))
								return false;
						}
						else
						{
							if(friendsV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.friends!=null)
				return false;
		}
		
		if(mData.blackList!=null)
		{
			if(this.blackList==null)
				return false;
			if(this.blackList.size()!=mData.blackList.size())
				return false;
			LongObjectMap<ContactData> blackListR=mData.blackList;
			if(!this.blackList.isEmpty())
			{
				long blackListKFreeValue=this.blackList.getFreeValue();
				long[] blackListKKeys=this.blackList.getKeys();
				Object[] blackListVValues=this.blackList.getValues();
				for(int blackListKI=blackListKKeys.length-1;blackListKI>=0;--blackListKI)
				{
					long blackListK=blackListKKeys[blackListKI];
					if(blackListK!=blackListKFreeValue)
					{
						ContactData blackListV=(ContactData)blackListVValues[blackListKI];
						ContactData blackListU=blackListR.get(blackListK);
						if(blackListU!=null)
						{
							if(blackListV==null)
								return false;
							if(!blackListV.dataEquals(blackListU))
								return false;
						}
						else
						{
							if(blackListV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.blackList!=null)
				return false;
		}
		
		if(mData.beFriends!=null)
		{
			if(this.beFriends==null)
				return false;
			if(this.beFriends.size()!=mData.beFriends.size())
				return false;
			LongSet beFriendsR=mData.beFriends;
			if(!this.beFriends.isEmpty())
			{
				long beFriendsVFreeValue=this.beFriends.getFreeValue();
				long[] beFriendsVKeys=this.beFriends.getKeys();
				for(int beFriendsVI=beFriendsVKeys.length-1;beFriendsVI>=0;--beFriendsVI)
				{
					long beFriendsV=beFriendsVKeys[beFriendsVI];
					if(beFriendsV!=beFriendsVFreeValue)
					{
						if(!beFriendsR.contains(beFriendsV))
							return false;
					}
				}
			}
		}
		else
		{
			if(this.beFriends!=null)
				return false;
		}
		
		if(mData.applyDic!=null)
		{
			if(this.applyDic==null)
				return false;
			if(this.applyDic.size()!=mData.applyDic.size())
				return false;
			LongObjectMap<ApplyAddFriendData> applyDicR=mData.applyDic;
			if(!this.applyDic.isEmpty())
			{
				long applyDicKFreeValue=this.applyDic.getFreeValue();
				long[] applyDicKKeys=this.applyDic.getKeys();
				Object[] applyDicVValues=this.applyDic.getValues();
				for(int applyDicKI=applyDicKKeys.length-1;applyDicKI>=0;--applyDicKI)
				{
					long applyDicK=applyDicKKeys[applyDicKI];
					if(applyDicK!=applyDicKFreeValue)
					{
						ApplyAddFriendData applyDicV=(ApplyAddFriendData)applyDicVValues[applyDicKI];
						ApplyAddFriendData applyDicU=applyDicR.get(applyDicK);
						if(applyDicU!=null)
						{
							if(applyDicV==null)
								return false;
							if(!applyDicV.dataEquals(applyDicU))
								return false;
						}
						else
						{
							if(applyDicV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.applyDic!=null)
				return false;
		}
		
		if(this.robotIndex!=mData.robotIndex)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("friends");
		writer.sb.append(':');
		writer.sb.append("Map<long,FriendData>");
		if(this.friends!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.friends.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.friends.isEmpty())
			{
				long friendsKFreeValue=this.friends.getFreeValue();
				long[] friendsKKeys=this.friends.getKeys();
				Object[] friendsVValues=this.friends.getValues();
				for(int friendsKI=friendsKKeys.length-1;friendsKI>=0;--friendsKI)
				{
					long friendsK=friendsKKeys[friendsKI];
					if(friendsK!=friendsKFreeValue)
					{
						FriendData friendsV=(FriendData)friendsVValues[friendsKI];
						writer.writeTabs();
						writer.sb.append(friendsK);
						
						writer.sb.append(':');
						if(friendsV!=null)
						{
							friendsV.writeDataString(writer);
						}
						else
						{
							writer.sb.append("FriendData=null");
						}
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("blackList");
		writer.sb.append(':');
		writer.sb.append("Map<long,ContactData>");
		if(this.blackList!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.blackList.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.blackList.isEmpty())
			{
				long blackListKFreeValue=this.blackList.getFreeValue();
				long[] blackListKKeys=this.blackList.getKeys();
				Object[] blackListVValues=this.blackList.getValues();
				for(int blackListKI=blackListKKeys.length-1;blackListKI>=0;--blackListKI)
				{
					long blackListK=blackListKKeys[blackListKI];
					if(blackListK!=blackListKFreeValue)
					{
						ContactData blackListV=(ContactData)blackListVValues[blackListKI];
						writer.writeTabs();
						writer.sb.append(blackListK);
						
						writer.sb.append(':');
						if(blackListV!=null)
						{
							blackListV.writeDataString(writer);
						}
						else
						{
							writer.sb.append("ContactData=null");
						}
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("beFriends");
		writer.sb.append(':');
		writer.sb.append("Set<long>");
		if(this.beFriends!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.beFriends.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.beFriends.isEmpty())
			{
				long beFriendsVFreeValue=this.beFriends.getFreeValue();
				long[] beFriendsVKeys=this.beFriends.getKeys();
				for(int beFriendsVI=beFriendsVKeys.length-1;beFriendsVI>=0;--beFriendsVI)
				{
					long beFriendsV=beFriendsVKeys[beFriendsVI];
					if(beFriendsV!=beFriendsVFreeValue)
					{
						writer.writeTabs();
						writer.sb.append(beFriendsV);
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("applyDic");
		writer.sb.append(':');
		writer.sb.append("Map<long,ApplyAddFriendData>");
		if(this.applyDic!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.applyDic.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.applyDic.isEmpty())
			{
				long applyDicKFreeValue=this.applyDic.getFreeValue();
				long[] applyDicKKeys=this.applyDic.getKeys();
				Object[] applyDicVValues=this.applyDic.getValues();
				for(int applyDicKI=applyDicKKeys.length-1;applyDicKI>=0;--applyDicKI)
				{
					long applyDicK=applyDicKKeys[applyDicKI];
					if(applyDicK!=applyDicKFreeValue)
					{
						ApplyAddFriendData applyDicV=(ApplyAddFriendData)applyDicVValues[applyDicKI];
						writer.writeTabs();
						writer.sb.append(applyDicK);
						
						writer.sb.append(':');
						if(applyDicV!=null)
						{
							applyDicV.writeDataString(writer);
						}
						else
						{
							writer.sb.append("ApplyAddFriendData=null");
						}
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("robotIndex");
		writer.sb.append(':');
		writer.sb.append(this.robotIndex);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		this.friends=new LongObjectMap<FriendData>(FriendData[]::new);
		this.blackList=new LongObjectMap<ContactData>(ContactData[]::new);
		this.beFriends=new LongSet();
		this.applyDic=new LongObjectMap<ApplyAddFriendData>(ApplyAddFriendData[]::new);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.friends=null;
		this.blackList=null;
		this.beFriends=null;
		this.applyDic=null;
		this.robotIndex=0;
	}
	
}