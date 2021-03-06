package com.home.commonBase.data.social.roleGroup;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.role.RoleShowData;
import com.home.commonBase.data.social.roleGroup.RoleGroupSimpleData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 邀请玩家群接收数据(generated by shine) */
public class InviteRoleGroupReceiveData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.InviteRoleGroupReceive;
	
	/** 邀请者 */
	public RoleShowData inviter;
	
	/** 玩家群简版数据 */
	public RoleGroupSimpleData simpleData;
	
	/** 邀请时间 */
	public long time;
	
	public InviteRoleGroupReceiveData()
	{
		_dataID=BaseDataType.InviteRoleGroupReceive;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "InviteRoleGroupReceiveData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		BaseData inviterT=stream.readDataFullNotNull();
		if(inviterT!=null)
		{
			if(inviterT instanceof RoleShowData)
			{
				this.inviter=(RoleShowData)inviterT;
			}
			else
			{
				this.inviter=new RoleShowData();
				if(!(inviterT.getClass().isAssignableFrom(RoleShowData.class)))
				{
					stream.throwTypeReadError(RoleShowData.class,inviterT.getClass());
				}
				this.inviter.shadowCopy(inviterT);
			}
		}
		else
		{
			this.inviter=null;
		}
		
		if(stream.readBoolean())
		{
			BaseData simpleDataT=stream.readDataFullNotNull();
			if(simpleDataT!=null)
			{
				if(simpleDataT instanceof RoleGroupSimpleData)
				{
					this.simpleData=(RoleGroupSimpleData)simpleDataT;
				}
				else
				{
					this.simpleData=new RoleGroupSimpleData();
					if(!(simpleDataT.getClass().isAssignableFrom(RoleGroupSimpleData.class)))
					{
						stream.throwTypeReadError(RoleGroupSimpleData.class,simpleDataT.getClass());
					}
					this.simpleData.shadowCopy(simpleDataT);
				}
			}
			else
			{
				this.simpleData=null;
			}
		}
		else
		{
			this.simpleData=null;
		}
		
		this.time=stream.readLong();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.inviter!=null)
		{
			stream.writeDataFullNotNull(this.inviter);
		}
		else
		{
			nullObjError("inviter");
		}
		
		if(this.simpleData!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataFullNotNull(this.simpleData);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeLong(this.time);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.inviter=(RoleShowData)stream.readDataSimpleNotNull();
		
		if(stream.readBoolean())
		{
			this.simpleData=(RoleGroupSimpleData)stream.readDataSimpleNotNull();
		}
		else
		{
			this.simpleData=null;
		}
		
		this.time=stream.readLong();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.inviter!=null)
		{
			stream.writeDataSimpleNotNull(this.inviter);
		}
		else
		{
			nullObjError("inviter");
		}
		
		if(this.simpleData!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataSimpleNotNull(this.simpleData);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeLong(this.time);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof InviteRoleGroupReceiveData))
			return;
		
		InviteRoleGroupReceiveData mData=(InviteRoleGroupReceiveData)data;
		
		this.inviter=mData.inviter;
		this.simpleData=mData.simpleData;
		this.time=mData.time;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof InviteRoleGroupReceiveData))
			return;
		
		InviteRoleGroupReceiveData mData=(InviteRoleGroupReceiveData)data;
		
		if(mData.inviter!=null)
		{
			this.inviter=(RoleShowData)mData.inviter.clone();
		}
		else
		{
			this.inviter=null;
			nullObjError("inviter");
		}
		
		if(mData.simpleData!=null)
		{
			this.simpleData=(RoleGroupSimpleData)mData.simpleData.clone();
		}
		else
		{
			this.simpleData=null;
		}
		
		this.time=mData.time;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		InviteRoleGroupReceiveData mData=(InviteRoleGroupReceiveData)data;
		if(mData.inviter!=null)
		{
			if(this.inviter==null)
				return false;
			if(!this.inviter.dataEquals(mData.inviter))
				return false;
		}
		else
		{
			if(this.inviter!=null)
				return false;
		}
		
		if(mData.simpleData!=null)
		{
			if(this.simpleData==null)
				return false;
			if(!this.simpleData.dataEquals(mData.simpleData))
				return false;
		}
		else
		{
			if(this.simpleData!=null)
				return false;
		}
		
		if(this.time!=mData.time)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("inviter");
		writer.sb.append(':');
		if(this.inviter!=null)
		{
			this.inviter.writeDataString(writer);
		}
		else
		{
			writer.sb.append("RoleShowData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("simpleData");
		writer.sb.append(':');
		if(this.simpleData!=null)
		{
			this.simpleData.writeDataString(writer);
		}
		else
		{
			writer.sb.append("RoleGroupSimpleData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("time");
		writer.sb.append(':');
		writer.sb.append(this.time);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		this.inviter=new RoleShowData();
		this.inviter.initDefault();
	}
	
	/** 获取玩家群id */
	public long getGroupID()
	{
		return simpleData!=null ? simpleData.groupID : -1L;
	}
	
	public long getRoleGroupID()
	{
		return simpleData!=null ? simpleData.groupID : -1L;
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.inviter=null;
		this.simpleData=null;
		this.time=0L;
	}
	
}
