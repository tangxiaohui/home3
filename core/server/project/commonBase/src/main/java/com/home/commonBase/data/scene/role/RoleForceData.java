package com.home.commonBase.data.scene.role;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 角色势力数据(generated by shine) */
public class RoleForceData extends BaseData
{
	/** 势力 */
	public int force;
	
	/** 数据类型ID */
	public static final int dataID=BaseDataType.RoleForce;
	
	public RoleForceData()
	{
		_dataID=BaseDataType.RoleForce;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "RoleForceData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.force=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.force);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.force=stream.readInt();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.force);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof RoleForceData))
			return;
		
		RoleForceData mData=(RoleForceData)data;
		
		this.force=mData.force;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof RoleForceData))
			return;
		
		RoleForceData mData=(RoleForceData)data;
		
		this.force=mData.force;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		RoleForceData mData=(RoleForceData)data;
		if(this.force!=mData.force)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("force");
		writer.sb.append(':');
		writer.sb.append(this.force);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.force=0;
	}
	
}