package com.home.commonBase.data.social.roleGroup.work;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.social.roleGroup.RoleGroupSimpleData;
import com.home.commonBase.data.system.CenterGlobalWorkData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 创建玩家群到中心服事务(generated by shine) */
public class CreateRoleGroupToCenterWData extends CenterGlobalWorkData
{
	/** 玩家群简版数据 */
	public RoleGroupSimpleData simpleData;
	
	/** 功能id */
	public int funcID;
	
	/** 数据类型ID */
	public static final int dataID=BaseDataType.CreateRoleGroupToCenterW;
	
	public CreateRoleGroupToCenterWData()
	{
		_dataID=BaseDataType.CreateRoleGroupToCenterW;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CreateRoleGroupToCenterWData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.funcID=stream.readInt();
		
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
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.funcID);
		
		if(this.simpleData!=null)
		{
			stream.writeDataFullNotNull(this.simpleData);
		}
		else
		{
			nullObjError("simpleData");
		}
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.funcID=stream.readInt();
		
		this.simpleData=(RoleGroupSimpleData)stream.readDataSimpleNotNull();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.funcID);
		
		if(this.simpleData!=null)
		{
			stream.writeDataSimpleNotNull(this.simpleData);
		}
		else
		{
			nullObjError("simpleData");
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof CreateRoleGroupToCenterWData))
			return;
		
		CreateRoleGroupToCenterWData mData=(CreateRoleGroupToCenterWData)data;
		
		this.funcID=mData.funcID;
		this.simpleData=mData.simpleData;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof CreateRoleGroupToCenterWData))
			return;
		
		CreateRoleGroupToCenterWData mData=(CreateRoleGroupToCenterWData)data;
		
		this.funcID=mData.funcID;
		
		if(mData.simpleData!=null)
		{
			this.simpleData=(RoleGroupSimpleData)mData.simpleData.clone();
		}
		else
		{
			this.simpleData=null;
			nullObjError("simpleData");
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		CreateRoleGroupToCenterWData mData=(CreateRoleGroupToCenterWData)data;
		if(this.funcID!=mData.funcID)
			return false;
		
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
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("funcID");
		writer.sb.append(':');
		writer.sb.append(this.funcID);
		
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
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		super.initDefault();
		
		this.simpleData=new RoleGroupSimpleData();
		this.simpleData.initDefault();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.funcID=0;
		this.simpleData=null;
	}
	
}
