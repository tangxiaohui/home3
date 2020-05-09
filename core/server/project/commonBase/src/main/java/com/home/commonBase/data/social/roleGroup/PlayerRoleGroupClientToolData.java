package com.home.commonBase.data.social.roleGroup;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.func.FuncToolData;
import com.home.commonBase.data.social.roleGroup.InviteRoleGroupReceiveData;
import com.home.commonBase.data.social.roleGroup.PlayerApplyRoleGroupSelfData;
import com.home.commonBase.data.social.roleGroup.PlayerRoleGroupData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.LongObjectMap;
import com.home.shine.support.collection.SList;
import com.home.shine.support.pool.DataPool;

/** 玩家群客户端工具数据(generated by shine) */
public class PlayerRoleGroupClientToolData extends FuncToolData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.PlayerRoleGroupClientTool;
	
	/** 群数据组 */
	public LongObjectMap<PlayerRoleGroupData> groups;
	
	/** 被邀请时是否可直接入群(无需同意) */
	public boolean canInviteInAbs;
	
	/** 被邀请记录字典 */
	public SList<InviteRoleGroupReceiveData> inviteList;
	
	/** 申请记录字典 */
	public LongObjectMap<PlayerApplyRoleGroupSelfData> applyDic;
	
	public PlayerRoleGroupClientToolData()
	{
		_dataID=BaseDataType.PlayerRoleGroupClientTool;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "PlayerRoleGroupClientToolData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		int groupsLen=stream.readLen();
		if(this.groups!=null)
		{
			this.groups.clear();
			this.groups.ensureCapacity(groupsLen);
		}
		else
		{
			this.groups=new LongObjectMap<PlayerRoleGroupData>(PlayerRoleGroupData[]::new,groupsLen);
		}
		
		LongObjectMap<PlayerRoleGroupData> groupsT=this.groups;
		for(int groupsI=groupsLen-1;groupsI>=0;--groupsI)
		{
			PlayerRoleGroupData groupsV;
			BaseData groupsVT=stream.readDataFullNotNull();
			if(groupsVT!=null)
			{
				if(groupsVT instanceof PlayerRoleGroupData)
				{
					groupsV=(PlayerRoleGroupData)groupsVT;
				}
				else
				{
					groupsV=new PlayerRoleGroupData();
					if(!(groupsVT.getClass().isAssignableFrom(PlayerRoleGroupData.class)))
					{
						stream.throwTypeReadError(PlayerRoleGroupData.class,groupsVT.getClass());
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
		
		int applyDicLen=stream.readLen();
		if(this.applyDic!=null)
		{
			this.applyDic.clear();
			this.applyDic.ensureCapacity(applyDicLen);
		}
		else
		{
			this.applyDic=new LongObjectMap<PlayerApplyRoleGroupSelfData>(PlayerApplyRoleGroupSelfData[]::new,applyDicLen);
		}
		
		LongObjectMap<PlayerApplyRoleGroupSelfData> applyDicT=this.applyDic;
		for(int applyDicI=applyDicLen-1;applyDicI>=0;--applyDicI)
		{
			PlayerApplyRoleGroupSelfData applyDicV;
			BaseData applyDicVT=stream.readDataFullNotNull();
			if(applyDicVT!=null)
			{
				if(applyDicVT instanceof PlayerApplyRoleGroupSelfData)
				{
					applyDicV=(PlayerApplyRoleGroupSelfData)applyDicVT;
				}
				else
				{
					applyDicV=new PlayerApplyRoleGroupSelfData();
					if(!(applyDicVT.getClass().isAssignableFrom(PlayerApplyRoleGroupSelfData.class)))
					{
						stream.throwTypeReadError(PlayerApplyRoleGroupSelfData.class,applyDicVT.getClass());
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
		
		int inviteListLen=stream.readLen();
		if(this.inviteList!=null)
		{
			this.inviteList.clear();
			this.inviteList.ensureCapacity(inviteListLen);
		}
		else
		{
			this.inviteList=new SList<InviteRoleGroupReceiveData>(InviteRoleGroupReceiveData[]::new,inviteListLen);
		}
		
		SList<InviteRoleGroupReceiveData> inviteListT=this.inviteList;
		for(int inviteListI=inviteListLen-1;inviteListI>=0;--inviteListI)
		{
			InviteRoleGroupReceiveData inviteListV;
			BaseData inviteListVT=stream.readDataFullNotNull();
			if(inviteListVT!=null)
			{
				if(inviteListVT instanceof InviteRoleGroupReceiveData)
				{
					inviteListV=(InviteRoleGroupReceiveData)inviteListVT;
				}
				else
				{
					inviteListV=new InviteRoleGroupReceiveData();
					if(!(inviteListVT.getClass().isAssignableFrom(InviteRoleGroupReceiveData.class)))
					{
						stream.throwTypeReadError(InviteRoleGroupReceiveData.class,inviteListVT.getClass());
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
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.groups!=null)
		{
			stream.writeLen(this.groups.size());
			if(!this.groups.isEmpty())
			{
				Object[] groupsVValues=this.groups.getValues();
				for(int groupsVI=groupsVValues.length-1;groupsVI>=0;--groupsVI)
				{
					if(groupsVValues[groupsVI]!=null)
					{
						PlayerRoleGroupData groupsV=(PlayerRoleGroupData)groupsVValues[groupsVI];
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
						PlayerApplyRoleGroupSelfData applyDicV=(PlayerApplyRoleGroupSelfData)applyDicVValues[applyDicVI];
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
		
		if(this.inviteList!=null)
		{
			stream.writeLen(this.inviteList.size());
			if(!this.inviteList.isEmpty())
			{
				Object[] inviteListVValues=this.inviteList.getValues();
				for(int inviteListVI=0,inviteListVLen=this.inviteList.length();inviteListVI<inviteListVLen;++inviteListVI)
				{
					InviteRoleGroupReceiveData inviteListV=(InviteRoleGroupReceiveData)inviteListVValues[inviteListVI];
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
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		int groupsLen=stream.readLen();
		if(this.groups!=null)
		{
			this.groups.clear();
			this.groups.ensureCapacity(groupsLen);
		}
		else
		{
			this.groups=new LongObjectMap<PlayerRoleGroupData>(PlayerRoleGroupData[]::new,groupsLen);
		}
		
		LongObjectMap<PlayerRoleGroupData> groupsT=this.groups;
		for(int groupsI=groupsLen-1;groupsI>=0;--groupsI)
		{
			PlayerRoleGroupData groupsV;
			groupsV=(PlayerRoleGroupData)stream.readDataSimpleNotNull();
			
			groupsT.put(groupsV.groupID,groupsV);
		}
		
		int applyDicLen=stream.readLen();
		if(this.applyDic!=null)
		{
			this.applyDic.clear();
			this.applyDic.ensureCapacity(applyDicLen);
		}
		else
		{
			this.applyDic=new LongObjectMap<PlayerApplyRoleGroupSelfData>(PlayerApplyRoleGroupSelfData[]::new,applyDicLen);
		}
		
		LongObjectMap<PlayerApplyRoleGroupSelfData> applyDicT=this.applyDic;
		for(int applyDicI=applyDicLen-1;applyDicI>=0;--applyDicI)
		{
			PlayerApplyRoleGroupSelfData applyDicV;
			applyDicV=(PlayerApplyRoleGroupSelfData)stream.readDataSimpleNotNull();
			
			applyDicT.put(applyDicV.data.groupID,applyDicV);
		}
		
		this.canInviteInAbs=stream.readBoolean();
		
		int inviteListLen=stream.readLen();
		if(this.inviteList!=null)
		{
			this.inviteList.clear();
			this.inviteList.ensureCapacity(inviteListLen);
		}
		else
		{
			this.inviteList=new SList<InviteRoleGroupReceiveData>(InviteRoleGroupReceiveData[]::new,inviteListLen);
		}
		
		SList<InviteRoleGroupReceiveData> inviteListT=this.inviteList;
		for(int inviteListI=inviteListLen-1;inviteListI>=0;--inviteListI)
		{
			InviteRoleGroupReceiveData inviteListV;
			inviteListV=(InviteRoleGroupReceiveData)stream.readDataSimpleNotNull();
			
			inviteListT.add(inviteListV);
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.groups!=null)
		{
			stream.writeLen(this.groups.size());
			if(!this.groups.isEmpty())
			{
				Object[] groupsVValues=this.groups.getValues();
				for(int groupsVI=groupsVValues.length-1;groupsVI>=0;--groupsVI)
				{
					if(groupsVValues[groupsVI]!=null)
					{
						PlayerRoleGroupData groupsV=(PlayerRoleGroupData)groupsVValues[groupsVI];
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
						PlayerApplyRoleGroupSelfData applyDicV=(PlayerApplyRoleGroupSelfData)applyDicVValues[applyDicVI];
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
		
		if(this.inviteList!=null)
		{
			stream.writeLen(this.inviteList.size());
			if(!this.inviteList.isEmpty())
			{
				Object[] inviteListVValues=this.inviteList.getValues();
				for(int inviteListVI=0,inviteListVLen=this.inviteList.length();inviteListVI<inviteListVLen;++inviteListVI)
				{
					InviteRoleGroupReceiveData inviteListV=(InviteRoleGroupReceiveData)inviteListVValues[inviteListVI];
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
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof PlayerRoleGroupClientToolData))
			return;
		
		PlayerRoleGroupClientToolData mData=(PlayerRoleGroupClientToolData)data;
		
		this.groups=mData.groups;
		this.applyDic=mData.applyDic;
		this.canInviteInAbs=mData.canInviteInAbs;
		this.inviteList=mData.inviteList;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof PlayerRoleGroupClientToolData))
			return;
		
		PlayerRoleGroupClientToolData mData=(PlayerRoleGroupClientToolData)data;
		
		if(mData.groups!=null)
		{
			if(this.groups!=null)
			{
				this.groups.clear();
				this.groups.ensureCapacity(mData.groups.size());
			}
			else
			{
				this.groups=new LongObjectMap<PlayerRoleGroupData>(PlayerRoleGroupData[]::new,mData.groups.size());
			}
			
			LongObjectMap<PlayerRoleGroupData> groupsT=this.groups;
			if(!mData.groups.isEmpty())
			{
				Object[] groupsVValues=mData.groups.getValues();
				for(int groupsVI=groupsVValues.length-1;groupsVI>=0;--groupsVI)
				{
					if(groupsVValues[groupsVI]!=null)
					{
						PlayerRoleGroupData groupsV=(PlayerRoleGroupData)groupsVValues[groupsVI];
						PlayerRoleGroupData groupsU;
						if(groupsV!=null)
						{
							groupsU=(PlayerRoleGroupData)groupsV.clone();
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
		
		if(mData.applyDic!=null)
		{
			if(this.applyDic!=null)
			{
				this.applyDic.clear();
				this.applyDic.ensureCapacity(mData.applyDic.size());
			}
			else
			{
				this.applyDic=new LongObjectMap<PlayerApplyRoleGroupSelfData>(PlayerApplyRoleGroupSelfData[]::new,mData.applyDic.size());
			}
			
			LongObjectMap<PlayerApplyRoleGroupSelfData> applyDicT=this.applyDic;
			if(!mData.applyDic.isEmpty())
			{
				Object[] applyDicVValues=mData.applyDic.getValues();
				for(int applyDicVI=applyDicVValues.length-1;applyDicVI>=0;--applyDicVI)
				{
					if(applyDicVValues[applyDicVI]!=null)
					{
						PlayerApplyRoleGroupSelfData applyDicV=(PlayerApplyRoleGroupSelfData)applyDicVValues[applyDicVI];
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
		
		if(mData.inviteList!=null)
		{
			if(this.inviteList!=null)
			{
				this.inviteList.clear();
				this.inviteList.ensureCapacity(mData.inviteList.size());
			}
			else
			{
				this.inviteList=new SList<InviteRoleGroupReceiveData>(InviteRoleGroupReceiveData[]::new,mData.inviteList.size());
			}
			
			SList<InviteRoleGroupReceiveData> inviteListT=this.inviteList;
			if(!mData.inviteList.isEmpty())
			{
				Object[] inviteListVValues=mData.inviteList.getValues();
				for(int inviteListVI=0,inviteListVLen=mData.inviteList.length();inviteListVI<inviteListVLen;++inviteListVI)
				{
					InviteRoleGroupReceiveData inviteListV=(InviteRoleGroupReceiveData)inviteListVValues[inviteListVI];
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
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		PlayerRoleGroupClientToolData mData=(PlayerRoleGroupClientToolData)data;
		if(mData.groups!=null)
		{
			if(this.groups==null)
				return false;
			if(this.groups.size()!=mData.groups.size())
				return false;
			LongObjectMap<PlayerRoleGroupData> groupsR=mData.groups;
			if(!this.groups.isEmpty())
			{
				long groupsKFreeValue=this.groups.getFreeValue();
				long[] groupsKKeys=this.groups.getKeys();
				Object[] groupsVValues=this.groups.getValues();
				for(int groupsKI=groupsKKeys.length-1;groupsKI>=0;--groupsKI)
				{
					long groupsK=groupsKKeys[groupsKI];
					if(groupsK!=groupsKFreeValue)
					{
						PlayerRoleGroupData groupsV=(PlayerRoleGroupData)groupsVValues[groupsKI];
						PlayerRoleGroupData groupsU=groupsR.get(groupsK);
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
				Object[] applyDicVValues=this.applyDic.getValues();
				for(int applyDicKI=applyDicKKeys.length-1;applyDicKI>=0;--applyDicKI)
				{
					long applyDicK=applyDicKKeys[applyDicKI];
					if(applyDicK!=applyDicKFreeValue)
					{
						PlayerApplyRoleGroupSelfData applyDicV=(PlayerApplyRoleGroupSelfData)applyDicVValues[applyDicKI];
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
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("groups");
		writer.sb.append(':');
		writer.sb.append("Map<long,PlayerRoleGroupData>");
		if(this.groups!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.groups.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.groups.isEmpty())
			{
				long groupsKFreeValue=this.groups.getFreeValue();
				long[] groupsKKeys=this.groups.getKeys();
				Object[] groupsVValues=this.groups.getValues();
				for(int groupsKI=groupsKKeys.length-1;groupsKI>=0;--groupsKI)
				{
					long groupsK=groupsKKeys[groupsKI];
					if(groupsK!=groupsKFreeValue)
					{
						PlayerRoleGroupData groupsV=(PlayerRoleGroupData)groupsVValues[groupsKI];
						writer.writeTabs();
						writer.sb.append(groupsK);
						
						writer.sb.append(':');
						if(groupsV!=null)
						{
							groupsV.writeDataString(writer);
						}
						else
						{
							writer.sb.append("PlayerRoleGroupData=null");
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
		writer.sb.append("applyDic");
		writer.sb.append(':');
		writer.sb.append("Map<long,PlayerApplyRoleGroupSelfData>");
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
						PlayerApplyRoleGroupSelfData applyDicV=(PlayerApplyRoleGroupSelfData)applyDicVValues[applyDicKI];
						writer.writeTabs();
						writer.sb.append(applyDicK);
						
						writer.sb.append(':');
						if(applyDicV!=null)
						{
							applyDicV.writeDataString(writer);
						}
						else
						{
							writer.sb.append("PlayerApplyRoleGroupSelfData=null");
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
		writer.sb.append("canInviteInAbs");
		writer.sb.append(':');
		writer.sb.append(this.canInviteInAbs);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("inviteList");
		writer.sb.append(':');
		writer.sb.append("List<InviteRoleGroupReceiveData>");
		if(this.inviteList!=null)
		{
			SList<InviteRoleGroupReceiveData> inviteListT=this.inviteList;
			int inviteListLen=inviteListT.size();
			writer.sb.append('(');
			writer.sb.append(inviteListLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int inviteListI=0;inviteListI<inviteListLen;++inviteListI)
			{
				InviteRoleGroupReceiveData inviteListV=inviteListT.get(inviteListI);
				writer.writeTabs();
				writer.sb.append(inviteListI);
				writer.sb.append(':');
				if(inviteListV!=null)
				{
					inviteListV.writeDataString(writer);
				}
				else
				{
					writer.sb.append("InviteRoleGroupReceiveData=null");
				}
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		super.initDefault();
		
		this.groups=new LongObjectMap<PlayerRoleGroupData>(PlayerRoleGroupData[]::new);
		this.applyDic=new LongObjectMap<PlayerApplyRoleGroupSelfData>(PlayerApplyRoleGroupSelfData[]::new);
		this.inviteList=new SList<InviteRoleGroupReceiveData>(InviteRoleGroupReceiveData[]::new);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.groups=null;
		this.applyDic=null;
		this.canInviteInAbs=false;
		this.inviteList=null;
	}
	
}