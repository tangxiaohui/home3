package com.home.commonBase.data.social.roleGroup;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.social.RoleSocialData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 玩家群成员数据(generated by shine) */
public class RoleGroupMemberData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.RoleGroupMember;
	
	/** 角色ID */
	public long playerID;
	
	/** 职位 */
	public int title;
	
	/** 加入时间戳 */
	public long joinTime;
	
	/** 社交数据 */
	public RoleSocialData socialData;
	
	public RoleGroupMemberData()
	{
		_dataID=BaseDataType.RoleGroupMember;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "RoleGroupMemberData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.playerID=stream.readLong();
		
		BaseData socialDataT=stream.readDataFullNotNull();
		if(socialDataT!=null)
		{
			if(socialDataT instanceof RoleSocialData)
			{
				this.socialData=(RoleSocialData)socialDataT;
			}
			else
			{
				this.socialData=new RoleSocialData();
				if(!(socialDataT.getClass().isAssignableFrom(RoleSocialData.class)))
				{
					stream.throwTypeReadError(RoleSocialData.class,socialDataT.getClass());
				}
				this.socialData.shadowCopy(socialDataT);
			}
		}
		else
		{
			this.socialData=null;
		}
		
		this.title=stream.readInt();
		
		this.joinTime=stream.readLong();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeLong(this.playerID);
		
		if(this.socialData!=null)
		{
			stream.writeDataFullNotNull(this.socialData);
		}
		else
		{
			nullObjError("socialData");
		}
		
		stream.writeInt(this.title);
		
		stream.writeLong(this.joinTime);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.playerID=stream.readLong();
		
		this.socialData=(RoleSocialData)stream.readDataSimpleNotNull();
		
		this.title=stream.readInt();
		
		this.joinTime=stream.readLong();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeLong(this.playerID);
		
		if(this.socialData!=null)
		{
			stream.writeDataSimpleNotNull(this.socialData);
		}
		else
		{
			nullObjError("socialData");
		}
		
		stream.writeInt(this.title);
		
		stream.writeLong(this.joinTime);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof RoleGroupMemberData))
			return;
		
		RoleGroupMemberData mData=(RoleGroupMemberData)data;
		
		this.playerID=mData.playerID;
		this.socialData=mData.socialData;
		this.title=mData.title;
		this.joinTime=mData.joinTime;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof RoleGroupMemberData))
			return;
		
		RoleGroupMemberData mData=(RoleGroupMemberData)data;
		
		this.playerID=mData.playerID;
		
		if(mData.socialData!=null)
		{
			this.socialData=(RoleSocialData)mData.socialData.clone();
		}
		else
		{
			this.socialData=null;
			nullObjError("socialData");
		}
		
		this.title=mData.title;
		
		this.joinTime=mData.joinTime;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		RoleGroupMemberData mData=(RoleGroupMemberData)data;
		if(this.playerID!=mData.playerID)
			return false;
		
		if(mData.socialData!=null)
		{
			if(this.socialData==null)
				return false;
			if(!this.socialData.dataEquals(mData.socialData))
				return false;
		}
		else
		{
			if(this.socialData!=null)
				return false;
		}
		
		if(this.title!=mData.title)
			return false;
		
		if(this.joinTime!=mData.joinTime)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("playerID");
		writer.sb.append(':');
		writer.sb.append(this.playerID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("socialData");
		writer.sb.append(':');
		if(this.socialData!=null)
		{
			this.socialData.writeDataString(writer);
		}
		else
		{
			writer.sb.append("RoleSocialData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("title");
		writer.sb.append(':');
		writer.sb.append(this.title);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("joinTime");
		writer.sb.append(':');
		writer.sb.append(this.joinTime);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		this.socialData=new RoleSocialData();
		this.socialData.initDefault();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.playerID=0L;
		this.socialData=null;
		this.title=0;
		this.joinTime=0L;
	}
	
}
