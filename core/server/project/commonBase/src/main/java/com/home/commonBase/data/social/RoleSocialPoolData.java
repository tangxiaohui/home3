package com.home.commonBase.data.social;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.social.RoleSocialData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 角色社交池数据(generated by shine) */
public class RoleSocialPoolData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.RoleSocialPool;
	
	/** 数据 */
	public RoleSocialData data;
	
	/** 入池时间 */
	public long inTime;
	
	public RoleSocialPoolData()
	{
		_dataID=BaseDataType.RoleSocialPool;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "RoleSocialPoolData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		BaseData dataT=stream.readDataFullNotNull();
		if(dataT!=null)
		{
			if(dataT instanceof RoleSocialData)
			{
				this.data=(RoleSocialData)dataT;
			}
			else
			{
				this.data=new RoleSocialData();
				if(!(dataT.getClass().isAssignableFrom(RoleSocialData.class)))
				{
					stream.throwTypeReadError(RoleSocialData.class,dataT.getClass());
				}
				this.data.shadowCopy(dataT);
			}
		}
		else
		{
			this.data=null;
		}
		
		this.inTime=stream.readLong();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.data!=null)
		{
			stream.writeDataFullNotNull(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
		stream.writeLong(this.inTime);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.data=(RoleSocialData)stream.readDataSimpleNotNull();
		
		this.inTime=stream.readLong();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.data!=null)
		{
			stream.writeDataSimpleNotNull(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
		stream.writeLong(this.inTime);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof RoleSocialPoolData))
			return;
		
		RoleSocialPoolData mData=(RoleSocialPoolData)data;
		
		this.data=mData.data;
		this.inTime=mData.inTime;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof RoleSocialPoolData))
			return;
		
		RoleSocialPoolData mData=(RoleSocialPoolData)data;
		
		if(mData.data!=null)
		{
			this.data=(RoleSocialData)mData.data.clone();
		}
		else
		{
			this.data=null;
			nullObjError("data");
		}
		
		this.inTime=mData.inTime;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		RoleSocialPoolData mData=(RoleSocialPoolData)data;
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
		
		if(this.inTime!=mData.inTime)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("data");
		writer.sb.append(':');
		if(this.data!=null)
		{
			this.data.writeDataString(writer);
		}
		else
		{
			writer.sb.append("RoleSocialData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("inTime");
		writer.sb.append(':');
		writer.sb.append(this.inTime);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		this.data=new RoleSocialData();
		this.data.initDefault();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.data=null;
		this.inTime=0L;
	}
	
}
