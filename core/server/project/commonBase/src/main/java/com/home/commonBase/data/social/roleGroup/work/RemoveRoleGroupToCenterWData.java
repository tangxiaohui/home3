package com.home.commonBase.data.social.roleGroup.work;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.system.CenterGlobalWorkData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 移除玩家群到中心服事务(generated by shine) */
public class RemoveRoleGroupToCenterWData extends CenterGlobalWorkData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.RemoveRoleGroupToCenterW;
	
	/** 功能id */
	public int funcID;
	
	public long groupID;
	
	public RemoveRoleGroupToCenterWData()
	{
		_dataID=BaseDataType.RemoveRoleGroupToCenterW;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "RemoveRoleGroupToCenterWData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.funcID=stream.readInt();
		
		this.groupID=stream.readLong();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.funcID);
		
		stream.writeLong(this.groupID);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.funcID=stream.readInt();
		
		this.groupID=stream.readLong();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.funcID);
		
		stream.writeLong(this.groupID);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof RemoveRoleGroupToCenterWData))
			return;
		
		RemoveRoleGroupToCenterWData mData=(RemoveRoleGroupToCenterWData)data;
		
		this.funcID=mData.funcID;
		this.groupID=mData.groupID;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof RemoveRoleGroupToCenterWData))
			return;
		
		RemoveRoleGroupToCenterWData mData=(RemoveRoleGroupToCenterWData)data;
		
		this.funcID=mData.funcID;
		
		this.groupID=mData.groupID;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		RemoveRoleGroupToCenterWData mData=(RemoveRoleGroupToCenterWData)data;
		if(this.funcID!=mData.funcID)
			return false;
		
		if(this.groupID!=mData.groupID)
			return false;
		
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
		writer.sb.append("groupID");
		writer.sb.append(':');
		writer.sb.append(this.groupID);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		super.initDefault();
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.funcID=0;
		this.groupID=0L;
	}
	
}
