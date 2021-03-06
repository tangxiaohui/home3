package com.home.shine.data.trigger;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.constlist.generate.ShineDataType;
import com.home.shine.data.BaseData;
import com.home.shine.data.trigger.TriggerObjData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class TriggerFloatData extends TriggerObjData
{
	/** 数据类型ID */
	public static final int dataID=ShineDataType.TriggerFloat;
	
	public float value;
	
	public TriggerFloatData()
	{
		_dataID=ShineDataType.TriggerFloat;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "TriggerFloatData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.value=stream.readFloat();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeFloat(this.value);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.value=stream.readFloat();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeFloat(this.value);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof TriggerFloatData))
			return;
		
		TriggerFloatData mData=(TriggerFloatData)data;
		
		this.value=mData.value;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof TriggerFloatData))
			return;
		
		TriggerFloatData mData=(TriggerFloatData)data;
		
		this.value=mData.value;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		TriggerFloatData mData=(TriggerFloatData)data;
		if(this.value!=mData.value)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("value");
		writer.sb.append(':');
		writer.sb.append(this.value);
		
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
		
		this.value=0f;
	}
	
}
