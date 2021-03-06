package com.home.commonBase.data.quest;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 任务完成数据(周期类用)(generated by shine) */
public class QuestCompleteData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.QuestComplete;
	
	/** 恢复时间戳 */
	public long reTime;
	
	/** 任务ID */
	public int id;
	
	/** 是否成功完成(否则是失败) */
	public boolean isSuccess;
	
	public QuestCompleteData()
	{
		_dataID=BaseDataType.QuestComplete;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "QuestCompleteData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.id=stream.readInt();
		
		this.reTime=stream.readLong();
		
		this.isSuccess=stream.readBoolean();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.id);
		
		stream.writeLong(this.reTime);
		
		stream.writeBoolean(this.isSuccess);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.id=stream.readInt();
		
		this.reTime=stream.readLong();
		
		this.isSuccess=stream.readBoolean();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.id);
		
		stream.writeLong(this.reTime);
		
		stream.writeBoolean(this.isSuccess);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof QuestCompleteData))
			return;
		
		QuestCompleteData mData=(QuestCompleteData)data;
		
		this.id=mData.id;
		this.reTime=mData.reTime;
		this.isSuccess=mData.isSuccess;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof QuestCompleteData))
			return;
		
		QuestCompleteData mData=(QuestCompleteData)data;
		
		this.id=mData.id;
		
		this.reTime=mData.reTime;
		
		this.isSuccess=mData.isSuccess;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		QuestCompleteData mData=(QuestCompleteData)data;
		if(this.id!=mData.id)
			return false;
		
		if(this.reTime!=mData.reTime)
			return false;
		
		if(this.isSuccess!=mData.isSuccess)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("id");
		writer.sb.append(':');
		writer.sb.append(this.id);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("reTime");
		writer.sb.append(':');
		writer.sb.append(this.reTime);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("isSuccess");
		writer.sb.append(':');
		writer.sb.append(this.isSuccess);
		
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
		this.id=0;
		this.reTime=0L;
		this.isSuccess=false;
	}
	
}
