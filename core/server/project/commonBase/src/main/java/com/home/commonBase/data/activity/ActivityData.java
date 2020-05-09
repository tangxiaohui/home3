package com.home.commonBase.data.activity;
import com.home.commonBase.config.game.ActivityConfig;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 活动数据(个人)(与存库数据一致)(generated by shine) */
public class ActivityData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.Activity;
	
	/** id */
	public int id;
	
	/** 是否运行中(存库无效) */
	public boolean isRunning;
	
	/** 已参与次数 */
	public int joinTimes;
	
	/** 下次触发时间 */
	public long nextTurnTime;
	
	/** 上次触发时间 */
	public long lastTurnTime;
	
	/** 下个重置时间(0为未重置过) */
	public long nextResetTime;
	
	/** 是否强制关闭(临时) */
	public boolean isForceClosed;
	
	/** 配置 */
	public ActivityConfig config;
	
	public ActivityData()
	{
		_dataID=BaseDataType.Activity;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ActivityData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.id=stream.readInt();
		
		this.isRunning=stream.readBoolean();
		
		this.joinTimes=stream.readInt();
		
		this.nextResetTime=stream.readLong();
		
		this.lastTurnTime=stream.readLong();
		
		this.nextTurnTime=stream.readLong();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.id);
		
		stream.writeBoolean(this.isRunning);
		
		stream.writeInt(this.joinTimes);
		
		stream.writeLong(this.nextResetTime);
		
		stream.writeLong(this.lastTurnTime);
		
		stream.writeLong(this.nextTurnTime);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.id=stream.readInt();
		
		this.isRunning=stream.readBoolean();
		
		this.joinTimes=stream.readInt();
		
		this.nextResetTime=stream.readLong();
		
		this.lastTurnTime=stream.readLong();
		
		this.nextTurnTime=stream.readLong();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.id);
		
		stream.writeBoolean(this.isRunning);
		
		stream.writeInt(this.joinTimes);
		
		stream.writeLong(this.nextResetTime);
		
		stream.writeLong(this.lastTurnTime);
		
		stream.writeLong(this.nextTurnTime);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof ActivityData))
			return;
		
		ActivityData mData=(ActivityData)data;
		
		this.id=mData.id;
		this.isRunning=mData.isRunning;
		this.joinTimes=mData.joinTimes;
		this.nextResetTime=mData.nextResetTime;
		this.lastTurnTime=mData.lastTurnTime;
		this.nextTurnTime=mData.nextTurnTime;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof ActivityData))
			return;
		
		ActivityData mData=(ActivityData)data;
		
		this.id=mData.id;
		
		this.isRunning=mData.isRunning;
		
		this.joinTimes=mData.joinTimes;
		
		this.nextResetTime=mData.nextResetTime;
		
		this.lastTurnTime=mData.lastTurnTime;
		
		this.nextTurnTime=mData.nextTurnTime;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		ActivityData mData=(ActivityData)data;
		if(this.id!=mData.id)
			return false;
		
		if(this.isRunning!=mData.isRunning)
			return false;
		
		if(this.joinTimes!=mData.joinTimes)
			return false;
		
		if(this.nextResetTime!=mData.nextResetTime)
			return false;
		
		if(this.lastTurnTime!=mData.lastTurnTime)
			return false;
		
		if(this.nextTurnTime!=mData.nextTurnTime)
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
		writer.sb.append("isRunning");
		writer.sb.append(':');
		writer.sb.append(this.isRunning);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("joinTimes");
		writer.sb.append(':');
		writer.sb.append(this.joinTimes);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("nextResetTime");
		writer.sb.append(':');
		writer.sb.append(this.nextResetTime);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("lastTurnTime");
		writer.sb.append(':');
		writer.sb.append(this.lastTurnTime);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("nextTurnTime");
		writer.sb.append(':');
		writer.sb.append(this.nextTurnTime);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		
	}
	
	/** 构造配置(如果没有的话) */
	public void makeConfig()
	{
		if(config==null)
		{
			config=ActivityConfig.get(id);
		}
	}
	
	/** 重载配置 */
	public void reloadConfig()
	{
		config=ActivityConfig.get(id);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.id=0;
		this.isRunning=false;
		this.joinTimes=0;
		this.nextResetTime=0L;
		this.lastTurnTime=0L;
		this.nextTurnTime=0L;
	}
	
}