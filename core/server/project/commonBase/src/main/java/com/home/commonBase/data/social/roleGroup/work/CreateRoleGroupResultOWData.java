package com.home.commonBase.data.social.roleGroup.work;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.func.PlayerFuncWorkData;
import com.home.commonBase.data.system.PlayerWorkData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 创建玩家群结果消息(退回cost用)(generated by shine) */
public class CreateRoleGroupResultOWData extends PlayerFuncWorkData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.CreateRoleGroupResultOW;
	
	/** 是否成功 */
	public boolean success;
	
	public CreateRoleGroupResultOWData()
	{
		_dataID=BaseDataType.CreateRoleGroupResultOW;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CreateRoleGroupResultOWData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.success=stream.readBoolean();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeBoolean(this.success);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.success=stream.readBoolean();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeBoolean(this.success);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof CreateRoleGroupResultOWData))
			return;
		
		CreateRoleGroupResultOWData mData=(CreateRoleGroupResultOWData)data;
		
		this.success=mData.success;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof CreateRoleGroupResultOWData))
			return;
		
		CreateRoleGroupResultOWData mData=(CreateRoleGroupResultOWData)data;
		
		this.success=mData.success;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		CreateRoleGroupResultOWData mData=(CreateRoleGroupResultOWData)data;
		if(this.success!=mData.success)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("success");
		writer.sb.append(':');
		writer.sb.append(this.success);
		
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
		
		this.success=false;
	}
	
}
