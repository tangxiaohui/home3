package com.home.commonBase.data.social;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.role.RoleShowChangeData;
import com.home.commonBase.data.system.PlayerWorkData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 刷新部分角色数据在线事务数据(generated by shine) */
public class RefreshPartRoleShowDataWData extends PlayerWorkData
{
	/** 角色ID */
	public long playerID;
	
	/** 改变数据 */
	public RoleShowChangeData data;
	
	/** 数据类型ID */
	public static final int dataID=BaseDataType.RefreshPartRoleShowDataW;
	
	public RefreshPartRoleShowDataWData()
	{
		_dataID=BaseDataType.RefreshPartRoleShowDataW;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "RefreshPartRoleShowDataWData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.playerID=stream.readLong();
		
		BaseData dataT=stream.readDataFullNotNull();
		if(dataT!=null)
		{
			if(dataT instanceof RoleShowChangeData)
			{
				this.data=(RoleShowChangeData)dataT;
			}
			else
			{
				this.data=new RoleShowChangeData();
				if(!(dataT.getClass().isAssignableFrom(RoleShowChangeData.class)))
				{
					stream.throwTypeReadError(RoleShowChangeData.class,dataT.getClass());
				}
				this.data.shadowCopy(dataT);
			}
		}
		else
		{
			this.data=null;
		}
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeLong(this.playerID);
		
		if(this.data!=null)
		{
			stream.writeDataFullNotNull(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.playerID=stream.readLong();
		
		this.data=(RoleShowChangeData)stream.readDataSimpleNotNull();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeLong(this.playerID);
		
		if(this.data!=null)
		{
			stream.writeDataSimpleNotNull(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof RefreshPartRoleShowDataWData))
			return;
		
		RefreshPartRoleShowDataWData mData=(RefreshPartRoleShowDataWData)data;
		
		this.playerID=mData.playerID;
		this.data=mData.data;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof RefreshPartRoleShowDataWData))
			return;
		
		RefreshPartRoleShowDataWData mData=(RefreshPartRoleShowDataWData)data;
		
		this.playerID=mData.playerID;
		
		if(mData.data!=null)
		{
			this.data=(RoleShowChangeData)mData.data.clone();
		}
		else
		{
			this.data=null;
			nullObjError("data");
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		RefreshPartRoleShowDataWData mData=(RefreshPartRoleShowDataWData)data;
		if(this.playerID!=mData.playerID)
			return false;
		
		if(mData.data!=null)
		{
			if(this.data==null)
				return false;
			if(!this.data.dataEquals(mData.data))
				return false;
		}
		else
		{
			if(this.data!=null)
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
		writer.sb.append("playerID");
		writer.sb.append(':');
		writer.sb.append(this.playerID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("data");
		writer.sb.append(':');
		if(this.data!=null)
		{
			this.data.writeDataString(writer);
		}
		else
		{
			writer.sb.append("RoleShowChangeData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		super.initDefault();
		
		this.data=new RoleShowChangeData();
		this.data.initDefault();
	}
	
	public static RefreshPartRoleShowDataWData create(long playerID,RoleShowChangeData data)
	{
		RefreshPartRoleShowDataWData re=new RefreshPartRoleShowDataWData();
		re.playerID=playerID;
		re.data=data;
		return re;
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.playerID=0L;
		this.data=null;
	}
	
}
