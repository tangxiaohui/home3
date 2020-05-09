using ShineEngine;

/// <summary>
/// 玩家身上的玩家群工具数据(generated by shine)
/// </summary>
public class PlayerRoleGroupToolData:FuncToolData
{
	/// <summary>
	/// 群数据组
	/// </summary>
	public LongObjectMap<PlayerRoleGroupSaveData> groups;
	
	/// <summary>
	/// 操作中占位数(废弃)
	/// </summary>
	public int operateNum;
	
	/// <summary>
	/// 申请记录字典
	/// </summary>
	public LongObjectMap<PlayerApplyRoleGroupSelfData> applyDic;
	
	/// <summary>
	/// 被邀请时是否可直接入群(无需同意)
	/// </summary>
	public bool canInviteInAbs;
	
	/// <summary>
	/// 创建玩家群操作计数
	/// </summary>
	public LongQueue createOperateNums;
	
	/// <summary>
	/// 被邀请记录字典
	/// </summary>
	public SList<InviteRoleGroupReceiveData> inviteList;
	
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.PlayerRoleGroupTool;
	
	public PlayerRoleGroupToolData()
	{
		_dataID=BaseDataType.PlayerRoleGroupTool;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "PlayerRoleGroupToolData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		int groupsLen=stream.readLen();
		if(this.groups!=null)
		{
			this.groups.clear();
			this.groups.ensureCapacity(groupsLen);
		}
		else
		{
			this.groups=new LongObjectMap<PlayerRoleGroupSaveData>(groupsLen);
		}
		
		LongObjectMap<PlayerRoleGroupSaveData> groupsT=this.groups;
		for(int groupsI=groupsLen-1;groupsI>=0;--groupsI)
		{
			PlayerRoleGroupSaveData groupsV;
			BaseData groupsVT=stream.readDataFullNotNull();
			if(groupsVT!=null)
			{
				if(groupsVT is PlayerRoleGroupSaveData)
				{
					groupsV=(PlayerRoleGroupSaveData)groupsVT;
				}
				else
				{
					groupsV=new PlayerRoleGroupSaveData();
					if(!(groupsVT.GetType().IsAssignableFrom(typeof(PlayerRoleGroupSaveData))))
					{
						stream.throwTypeReadError(typeof(PlayerRoleGroupSaveData),groupsVT.GetType());
					}
					groupsV.shadowCopy(groupsVT);
				}
			}
			else
			{
				groupsV=null;
			}
			
			groupsT.put(groupsV.groupID,groupsV);
		}
		
		this.operateNum=stream.readInt();
		
		int applyDicLen=stream.readLen();
		if(this.applyDic!=null)
		{
			this.applyDic.clear();
			this.applyDic.ensureCapacity(applyDicLen);
		}
		else
		{
			this.applyDic=new LongObjectMap<PlayerApplyRoleGroupSelfData>(applyDicLen);
		}
		
		LongObjectMap<PlayerApplyRoleGroupSelfData> applyDicT=this.applyDic;
		for(int applyDicI=applyDicLen-1;applyDicI>=0;--applyDicI)
		{
			PlayerApplyRoleGroupSelfData applyDicV;
			BaseData applyDicVT=stream.readDataFullNotNull();
			if(applyDicVT!=null)
			{
				if(applyDicVT is PlayerApplyRoleGroupSelfData)
				{
					applyDicV=(PlayerApplyRoleGroupSelfData)applyDicVT;
				}
				else
				{
					applyDicV=new PlayerApplyRoleGroupSelfData();
					if(!(applyDicVT.GetType().IsAssignableFrom(typeof(PlayerApplyRoleGroupSelfData))))
					{
						stream.throwTypeReadError(typeof(PlayerApplyRoleGroupSelfData),applyDicVT.GetType());
					}
					applyDicV.shadowCopy(applyDicVT);
				}
			}
			else
			{
				applyDicV=null;
			}
			
			applyDicT.put(applyDicV.data.groupID,applyDicV);
		}
		
		this.canInviteInAbs=stream.readBoolean();
		
		int createOperateNumsLen=stream.readLen();
		if(this.createOperateNums!=null)
		{
			this.createOperateNums.clear();
			this.createOperateNums.ensureCapacity(createOperateNumsLen);
		}
		else
		{
			this.createOperateNums=new LongQueue();
		}
		
		LongQueue createOperateNumsT=this.createOperateNums;
		for(int createOperateNumsI=createOperateNumsLen-1;createOperateNumsI>=0;--createOperateNumsI)
		{
			long createOperateNumsV;
			createOperateNumsV=stream.readLong();
			
			createOperateNumsT.offer(createOperateNumsV);
		}
		
		int inviteListLen=stream.readLen();
		if(this.inviteList!=null)
		{
			this.inviteList.clear();
			this.inviteList.ensureCapacity(inviteListLen);
		}
		else
		{
			this.inviteList=new SList<InviteRoleGroupReceiveData>();
		}
		
		SList<InviteRoleGroupReceiveData> inviteListT=this.inviteList;
		for(int inviteListI=inviteListLen-1;inviteListI>=0;--inviteListI)
		{
			InviteRoleGroupReceiveData inviteListV;
			BaseData inviteListVT=stream.readDataFullNotNull();
			if(inviteListVT!=null)
			{
				if(inviteListVT is InviteRoleGroupReceiveData)
				{
					inviteListV=(InviteRoleGroupReceiveData)inviteListVT;
				}
				else
				{
					inviteListV=new InviteRoleGroupReceiveData();
					if(!(inviteListVT.GetType().IsAssignableFrom(typeof(InviteRoleGroupReceiveData))))
					{
						stream.throwTypeReadError(typeof(InviteRoleGroupReceiveData),inviteListVT.GetType());
					}
					inviteListV.shadowCopy(inviteListVT);
				}
			}
			else
			{
				inviteListV=null;
			}
			
			inviteListT.add(inviteListV);
		}
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.groups!=null)
		{
			stream.writeLen(this.groups.size());
			if(!this.groups.isEmpty())
			{
				PlayerRoleGroupSaveData[] groupsVValues=this.groups.getValues();
				for(int groupsVI=groupsVValues.Length-1;groupsVI>=0;--groupsVI)
				{
					PlayerRoleGroupSaveData groupsV=groupsVValues[groupsVI];
					if(groupsV!=null)
					{
						if(groupsV!=null)
						{
							stream.writeDataFullNotNull(groupsV);
						}
						else
						{
							nullObjError("groupsV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("groups");
		}
		
		stream.writeInt(this.operateNum);
		
		if(this.applyDic!=null)
		{
			stream.writeLen(this.applyDic.size());
			if(!this.applyDic.isEmpty())
			{
				PlayerApplyRoleGroupSelfData[] applyDicVValues=this.applyDic.getValues();
				for(int applyDicVI=applyDicVValues.Length-1;applyDicVI>=0;--applyDicVI)
				{
					PlayerApplyRoleGroupSelfData applyDicV=applyDicVValues[applyDicVI];
					if(applyDicV!=null)
					{
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
		
		stream.writeBoolean(this.canInviteInAbs);
		
		if(this.createOperateNums!=null)
		{
			stream.writeLen(this.createOperateNums.size());
			if(!this.createOperateNums.isEmpty())
			{
				long[] createOperateNumsVValues=this.createOperateNums.getValues();
				int createOperateNumsVMark=this.createOperateNums.getMark();
				int createOperateNumsVStart=this.createOperateNums.getStart();
				for(int createOperateNumsVI=0,createOperateNumsVLen=this.createOperateNums.length();createOperateNumsVI<createOperateNumsVLen;++createOperateNumsVI)
				{
					long createOperateNumsV=createOperateNumsVValues[(createOperateNumsVI+createOperateNumsVStart)&createOperateNumsVMark];
					stream.writeLong(createOperateNumsV);
					
				}
			}
		}
		else
		{
			nullObjError("createOperateNums");
		}
		
		if(this.inviteList!=null)
		{
			stream.writeLen(this.inviteList.size());
			if(!this.inviteList.isEmpty())
			{
				InviteRoleGroupReceiveData[] inviteListVValues=this.inviteList.getValues();
				for(int inviteListVI=0,inviteListVLen=this.inviteList.length();inviteListVI<inviteListVLen;++inviteListVI)
				{
					InviteRoleGroupReceiveData inviteListV=inviteListVValues[inviteListVI];
					if(inviteListV!=null)
					{
						stream.writeDataFullNotNull(inviteListV);
					}
					else
					{
						nullObjError("inviteListV");
					}
					
				}
			}
		}
		else
		{
			nullObjError("inviteList");
		}
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		int groupsLen=stream.readLen();
		if(this.groups!=null)
		{
			this.groups.clear();
			this.groups.ensureCapacity(groupsLen);
		}
		else
		{
			this.groups=new LongObjectMap<PlayerRoleGroupSaveData>(groupsLen);
		}
		
		LongObjectMap<PlayerRoleGroupSaveData> groupsT=this.groups;
		for(int groupsI=groupsLen-1;groupsI>=0;--groupsI)
		{
			PlayerRoleGroupSaveData groupsV;
			groupsV=(PlayerRoleGroupSaveData)stream.readDataSimpleNotNull();
			
			groupsT.put(groupsV.groupID,groupsV);
		}
		
		this.operateNum=stream.readInt();
		
		int applyDicLen=stream.readLen();
		if(this.applyDic!=null)
		{
			this.applyDic.clear();
			this.applyDic.ensureCapacity(applyDicLen);
		}
		else
		{
			this.applyDic=new LongObjectMap<PlayerApplyRoleGroupSelfData>(applyDicLen);
		}
		
		LongObjectMap<PlayerApplyRoleGroupSelfData> applyDicT=this.applyDic;
		for(int applyDicI=applyDicLen-1;applyDicI>=0;--applyDicI)
		{
			PlayerApplyRoleGroupSelfData applyDicV;
			applyDicV=(PlayerApplyRoleGroupSelfData)stream.readDataSimpleNotNull();
			
			applyDicT.put(applyDicV.data.groupID,applyDicV);
		}
		
		this.canInviteInAbs=stream.readBoolean();
		
		int createOperateNumsLen=stream.readLen();
		if(this.createOperateNums!=null)
		{
			this.createOperateNums.clear();
			this.createOperateNums.ensureCapacity(createOperateNumsLen);
		}
		else
		{
			this.createOperateNums=new LongQueue();
		}
		
		LongQueue createOperateNumsT=this.createOperateNums;
		for(int createOperateNumsI=createOperateNumsLen-1;createOperateNumsI>=0;--createOperateNumsI)
		{
			long createOperateNumsV;
			createOperateNumsV=stream.readLong();
			
			createOperateNumsT.offer(createOperateNumsV);
		}
		
		int inviteListLen=stream.readLen();
		if(this.inviteList!=null)
		{
			this.inviteList.clear();
			this.inviteList.ensureCapacity(inviteListLen);
		}
		else
		{
			this.inviteList=new SList<InviteRoleGroupReceiveData>();
		}
		
		SList<InviteRoleGroupReceiveData> inviteListT=this.inviteList;
		for(int inviteListI=inviteListLen-1;inviteListI>=0;--inviteListI)
		{
			InviteRoleGroupReceiveData inviteListV;
			inviteListV=(InviteRoleGroupReceiveData)stream.readDataSimpleNotNull();
			
			inviteListT.add(inviteListV);
		}
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		if(this.groups!=null)
		{
			stream.writeLen(this.groups.size());
			if(!this.groups.isEmpty())
			{
				PlayerRoleGroupSaveData[] groupsVValues=this.groups.getValues();
				for(int groupsVI=groupsVValues.Length-1;groupsVI>=0;--groupsVI)
				{
					PlayerRoleGroupSaveData groupsV=groupsVValues[groupsVI];
					if(groupsV!=null)
					{
						if(groupsV!=null)
						{
							stream.writeDataSimpleNotNull(groupsV);
						}
						else
						{
							nullObjError("groupsV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("groups");
		}
		
		stream.writeInt(this.operateNum);
		
		if(this.applyDic!=null)
		{
			stream.writeLen(this.applyDic.size());
			if(!this.applyDic.isEmpty())
			{
				PlayerApplyRoleGroupSelfData[] applyDicVValues=this.applyDic.getValues();
				for(int applyDicVI=applyDicVValues.Length-1;applyDicVI>=0;--applyDicVI)
				{
					PlayerApplyRoleGroupSelfData applyDicV=applyDicVValues[applyDicVI];
					if(applyDicV!=null)
					{
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
		
		stream.writeBoolean(this.canInviteInAbs);
		
		if(this.createOperateNums!=null)
		{
			stream.writeLen(this.createOperateNums.size());
			if(!this.createOperateNums.isEmpty())
			{
				long[] createOperateNumsVValues=this.createOperateNums.getValues();
				int createOperateNumsVMark=this.createOperateNums.getMark();
				int createOperateNumsVStart=this.createOperateNums.getStart();
				for(int createOperateNumsVI=0,createOperateNumsVLen=this.createOperateNums.length();createOperateNumsVI<createOperateNumsVLen;++createOperateNumsVI)
				{
					long createOperateNumsV=createOperateNumsVValues[(createOperateNumsVI+createOperateNumsVStart)&createOperateNumsVMark];
					stream.writeLong(createOperateNumsV);
					
				}
			}
		}
		else
		{
			nullObjError("createOperateNums");
		}
		
		if(this.inviteList!=null)
		{
			stream.writeLen(this.inviteList.size());
			if(!this.inviteList.isEmpty())
			{
				InviteRoleGroupReceiveData[] inviteListVValues=this.inviteList.getValues();
				for(int inviteListVI=0,inviteListVLen=this.inviteList.length();inviteListVI<inviteListVLen;++inviteListVI)
				{
					InviteRoleGroupReceiveData inviteListV=inviteListVValues[inviteListVI];
					if(inviteListV!=null)
					{
						stream.writeDataSimpleNotNull(inviteListV);
					}
					else
					{
						nullObjError("inviteListV");
					}
					
				}
			}
		}
		else
		{
			nullObjError("inviteList");
		}
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		base.toShadowCopy(data);
		
		if(!(data is PlayerRoleGroupToolData))
			return;
		
		PlayerRoleGroupToolData mData=(PlayerRoleGroupToolData)data;
		
		this.groups=mData.groups;
		this.operateNum=mData.operateNum;
		this.applyDic=mData.applyDic;
		this.canInviteInAbs=mData.canInviteInAbs;
		this.createOperateNums=mData.createOperateNums;
		this.inviteList=mData.inviteList;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		base.toCopy(data);
		
		if(!(data is PlayerRoleGroupToolData))
			return;
		
		PlayerRoleGroupToolData mData=(PlayerRoleGroupToolData)data;
		
		if(mData.groups!=null)
		{
			if(this.groups!=null)
			{
				this.groups.clear();
				this.groups.ensureCapacity(mData.groups.size());
			}
			else
			{
				this.groups=new LongObjectMap<PlayerRoleGroupSaveData>(mData.groups.size());
			}
			
			LongObjectMap<PlayerRoleGroupSaveData> groupsT=this.groups;
			if(!mData.groups.isEmpty())
			{
				PlayerRoleGroupSaveData[] groupsVValues=mData.groups.getValues();
				for(int groupsVI=groupsVValues.Length-1;groupsVI>=0;--groupsVI)
				{
					PlayerRoleGroupSaveData groupsV=groupsVValues[groupsVI];
					if(groupsV!=null)
					{
						PlayerRoleGroupSaveData groupsU;
						if(groupsV!=null)
						{
							groupsU=(PlayerRoleGroupSaveData)groupsV.clone();
						}
						else
						{
							groupsU=null;
							nullObjError("groupsU");
						}
						
						groupsT.put(groupsU.groupID,groupsU);
					}
				}
			}
		}
		else
		{
			this.groups=null;
			nullObjError("groups");
		}
		
		this.operateNum=mData.operateNum;
		
		if(mData.applyDic!=null)
		{
			if(this.applyDic!=null)
			{
				this.applyDic.clear();
				this.applyDic.ensureCapacity(mData.applyDic.size());
			}
			else
			{
				this.applyDic=new LongObjectMap<PlayerApplyRoleGroupSelfData>(mData.applyDic.size());
			}
			
			LongObjectMap<PlayerApplyRoleGroupSelfData> applyDicT=this.applyDic;
			if(!mData.applyDic.isEmpty())
			{
				PlayerApplyRoleGroupSelfData[] applyDicVValues=mData.applyDic.getValues();
				for(int applyDicVI=applyDicVValues.Length-1;applyDicVI>=0;--applyDicVI)
				{
					PlayerApplyRoleGroupSelfData applyDicV=applyDicVValues[applyDicVI];
					if(applyDicV!=null)
					{
						PlayerApplyRoleGroupSelfData applyDicU;
						if(applyDicV!=null)
						{
							applyDicU=(PlayerApplyRoleGroupSelfData)applyDicV.clone();
						}
						else
						{
							applyDicU=null;
							nullObjError("applyDicU");
						}
						
						applyDicT.put(applyDicU.data.groupID,applyDicU);
					}
				}
			}
		}
		else
		{
			this.applyDic=null;
			nullObjError("applyDic");
		}
		
		this.canInviteInAbs=mData.canInviteInAbs;
		
		if(mData.createOperateNums!=null)
		{
			if(this.createOperateNums!=null)
			{
				this.createOperateNums.clear();
				this.createOperateNums.ensureCapacity(mData.createOperateNums.size());
			}
			else
			{
				this.createOperateNums=new LongQueue();
			}
			
			LongQueue createOperateNumsT=this.createOperateNums;
			if(!mData.createOperateNums.isEmpty())
			{
				long[] createOperateNumsVValues=mData.createOperateNums.getValues();
				int createOperateNumsVMark=mData.createOperateNums.getMark();
				int createOperateNumsVStart=mData.createOperateNums.getStart();
				for(int createOperateNumsVI=0,createOperateNumsVLen=mData.createOperateNums.length();createOperateNumsVI<createOperateNumsVLen;++createOperateNumsVI)
				{
					long createOperateNumsV=createOperateNumsVValues[(createOperateNumsVI+createOperateNumsVStart)&createOperateNumsVMark];
					long createOperateNumsU;
					createOperateNumsU=createOperateNumsV;
					
					createOperateNumsT.offer(createOperateNumsU);
				}
			}
		}
		else
		{
			this.createOperateNums=null;
			nullObjError("createOperateNums");
		}
		
		if(mData.inviteList!=null)
		{
			if(this.inviteList!=null)
			{
				this.inviteList.clear();
				this.inviteList.ensureCapacity(mData.inviteList.size());
			}
			else
			{
				this.inviteList=new SList<InviteRoleGroupReceiveData>();
			}
			
			SList<InviteRoleGroupReceiveData> inviteListT=this.inviteList;
			if(!mData.inviteList.isEmpty())
			{
				InviteRoleGroupReceiveData[] inviteListVValues=mData.inviteList.getValues();
				for(int inviteListVI=0,inviteListVLen=mData.inviteList.length();inviteListVI<inviteListVLen;++inviteListVI)
				{
					InviteRoleGroupReceiveData inviteListV=inviteListVValues[inviteListVI];
					InviteRoleGroupReceiveData inviteListU;
					if(inviteListV!=null)
					{
						inviteListU=(InviteRoleGroupReceiveData)inviteListV.clone();
					}
					else
					{
						inviteListU=null;
						nullObjError("inviteListU");
					}
					
					inviteListT.add(inviteListU);
				}
			}
		}
		else
		{
			this.inviteList=null;
			nullObjError("inviteList");
		}
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		if(!base.toDataEquals(data))
			return false;
		
		PlayerRoleGroupToolData mData=(PlayerRoleGroupToolData)data;
		if(mData.groups!=null)
		{
			if(this.groups==null)
				return false;
			if(this.groups.size()!=mData.groups.size())
				return false;
			LongObjectMap<PlayerRoleGroupSaveData> groupsR=mData.groups;
			if(!this.groups.isEmpty())
			{
				long groupsKFreeValue=this.groups.getFreeValue();
				long[] groupsKKeys=this.groups.getKeys();
				PlayerRoleGroupSaveData[] groupsVValues=this.groups.getValues();
				for(int groupsKI=groupsKKeys.Length-1;groupsKI>=0;--groupsKI)
				{
					long groupsK=groupsKKeys[groupsKI];
					if(groupsK!=groupsKFreeValue)
					{
						PlayerRoleGroupSaveData groupsV=groupsVValues[groupsKI];
						PlayerRoleGroupSaveData groupsU=groupsR.get(groupsK);
						if(groupsU!=null)
						{
							if(groupsV==null)
								return false;
							if(!groupsV.dataEquals(groupsU))
								return false;
						}
						else
						{
							if(groupsV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.groups!=null)
				return false;
		}
		
		if(this.operateNum!=mData.operateNum)
			return false;
		
		if(mData.applyDic!=null)
		{
			if(this.applyDic==null)
				return false;
			if(this.applyDic.size()!=mData.applyDic.size())
				return false;
			LongObjectMap<PlayerApplyRoleGroupSelfData> applyDicR=mData.applyDic;
			if(!this.applyDic.isEmpty())
			{
				long applyDicKFreeValue=this.applyDic.getFreeValue();
				long[] applyDicKKeys=this.applyDic.getKeys();
				PlayerApplyRoleGroupSelfData[] applyDicVValues=this.applyDic.getValues();
				for(int applyDicKI=applyDicKKeys.Length-1;applyDicKI>=0;--applyDicKI)
				{
					long applyDicK=applyDicKKeys[applyDicKI];
					if(applyDicK!=applyDicKFreeValue)
					{
						PlayerApplyRoleGroupSelfData applyDicV=applyDicVValues[applyDicKI];
						PlayerApplyRoleGroupSelfData applyDicU=applyDicR.get(applyDicK);
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
		
		if(this.canInviteInAbs!=mData.canInviteInAbs)
			return false;
		
		if(mData.createOperateNums!=null)
		{
			if(this.createOperateNums==null)
				return false;
			if(this.createOperateNums.size()!=mData.createOperateNums.size())
				return false;
			LongQueue createOperateNumsT=this.createOperateNums;
			LongQueue createOperateNumsR=mData.createOperateNums;
			int createOperateNumsLen=createOperateNumsT.size();
			for(int createOperateNumsI=0;createOperateNumsI<createOperateNumsLen;++createOperateNumsI)
			{
				long createOperateNumsU=createOperateNumsT.get(createOperateNumsI);
				long createOperateNumsV=createOperateNumsR.get(createOperateNumsI);
				if(createOperateNumsU!=createOperateNumsV)
					return false;
				
			}
		}
		else
		{
			if(this.createOperateNums!=null)
				return false;
		}
		
		if(mData.inviteList!=null)
		{
			if(this.inviteList==null)
				return false;
			if(this.inviteList.size()!=mData.inviteList.size())
				return false;
			SList<InviteRoleGroupReceiveData> inviteListT=this.inviteList;
			SList<InviteRoleGroupReceiveData> inviteListR=mData.inviteList;
			int inviteListLen=inviteListT.size();
			for(int inviteListI=0;inviteListI<inviteListLen;++inviteListI)
			{
				InviteRoleGroupReceiveData inviteListU=inviteListT.get(inviteListI);
				InviteRoleGroupReceiveData inviteListV=inviteListR.get(inviteListI);
				if(inviteListV!=null)
				{
					if(inviteListU==null)
						return false;
					if(!inviteListU.dataEquals(inviteListV))
						return false;
				}
				else
				{
					if(inviteListU!=null)
						return false;
				}
				
			}
		}
		else
		{
			if(this.inviteList!=null)
				return false;
		}
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("groups");
		writer.sb.Append(':');
		writer.sb.Append("Map<long,PlayerRoleGroupSaveData>");
		if(this.groups!=null)
		{
			writer.sb.Append('(');
			writer.sb.Append(this.groups.size());
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.groups.isEmpty())
			{
				long groupsKFreeValue=this.groups.getFreeValue();
				long[] groupsKKeys=this.groups.getKeys();
				PlayerRoleGroupSaveData[] groupsVValues=this.groups.getValues();
				for(int groupsKI=groupsKKeys.Length-1;groupsKI>=0;--groupsKI)
				{
					long groupsK=groupsKKeys[groupsKI];
					if(groupsK!=groupsKFreeValue)
					{
						PlayerRoleGroupSaveData groupsV=groupsVValues[groupsKI];
						writer.writeTabs();
						writer.sb.Append(groupsK);
						
						writer.sb.Append(':');
						if(groupsV!=null)
						{
							groupsV.writeDataString(writer);
						}
						else
						{
							writer.sb.Append("PlayerRoleGroupSaveData=null");
						}
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.Append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("operateNum");
		writer.sb.Append(':');
		writer.sb.Append(this.operateNum);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("applyDic");
		writer.sb.Append(':');
		writer.sb.Append("Map<long,PlayerApplyRoleGroupSelfData>");
		if(this.applyDic!=null)
		{
			writer.sb.Append('(');
			writer.sb.Append(this.applyDic.size());
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.applyDic.isEmpty())
			{
				long applyDicKFreeValue=this.applyDic.getFreeValue();
				long[] applyDicKKeys=this.applyDic.getKeys();
				PlayerApplyRoleGroupSelfData[] applyDicVValues=this.applyDic.getValues();
				for(int applyDicKI=applyDicKKeys.Length-1;applyDicKI>=0;--applyDicKI)
				{
					long applyDicK=applyDicKKeys[applyDicKI];
					if(applyDicK!=applyDicKFreeValue)
					{
						PlayerApplyRoleGroupSelfData applyDicV=applyDicVValues[applyDicKI];
						writer.writeTabs();
						writer.sb.Append(applyDicK);
						
						writer.sb.Append(':');
						if(applyDicV!=null)
						{
							applyDicV.writeDataString(writer);
						}
						else
						{
							writer.sb.Append("PlayerApplyRoleGroupSelfData=null");
						}
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.Append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("canInviteInAbs");
		writer.sb.Append(':');
		writer.sb.Append(this.canInviteInAbs);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("createOperateNums");
		writer.sb.Append(':');
		writer.sb.Append("Queue<long>");
		if(this.createOperateNums!=null)
		{
			LongQueue createOperateNumsT=this.createOperateNums;
			int createOperateNumsLen=createOperateNumsT.size();
			writer.sb.Append('(');
			writer.sb.Append(createOperateNumsLen);
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int createOperateNumsI=0;createOperateNumsI<createOperateNumsLen;++createOperateNumsI)
			{
				long createOperateNumsV=createOperateNumsT.get(createOperateNumsI);
				writer.writeTabs();
				writer.sb.Append(createOperateNumsI);
				writer.sb.Append(':');
				writer.sb.Append(createOperateNumsV);
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.Append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("inviteList");
		writer.sb.Append(':');
		writer.sb.Append("List<InviteRoleGroupReceiveData>");
		if(this.inviteList!=null)
		{
			SList<InviteRoleGroupReceiveData> inviteListT=this.inviteList;
			int inviteListLen=inviteListT.size();
			writer.sb.Append('(');
			writer.sb.Append(inviteListLen);
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int inviteListI=0;inviteListI<inviteListLen;++inviteListI)
			{
				InviteRoleGroupReceiveData inviteListV=inviteListT.get(inviteListI);
				writer.writeTabs();
				writer.sb.Append(inviteListI);
				writer.sb.Append(':');
				if(inviteListV!=null)
				{
					inviteListV.writeDataString(writer);
				}
				else
				{
					writer.sb.Append("InviteRoleGroupReceiveData=null");
				}
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.Append("=null");
		}
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		base.initDefault();
		
		this.groups=new LongObjectMap<PlayerRoleGroupSaveData>();
		this.applyDic=new LongObjectMap<PlayerApplyRoleGroupSelfData>();
		this.createOperateNums=new LongQueue();
		this.inviteList=new SList<InviteRoleGroupReceiveData>();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.groups=null;
		this.operateNum=0;
		this.applyDic=null;
		this.canInviteInAbs=false;
		this.createOperateNums=null;
		this.inviteList=null;
	}
	
}