package com.home.commonClient.net.response.activity;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.base.GameResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 活动开启/关闭消息(generated by shine) */
public class ActivitySwitchResponse extends GameResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.ActivitySwitch;
	
	/** 活动ID */
	public int id;
	
	/** 是否开启 */
	public boolean isRunning;
	
	/** 上次触发时间 */
	public long lastTurnTime;
	
	/** 下次触发时间 */
	public long nextTurnTime;
	
	/** 是否到时间自然触发 */
	public boolean atTime;
	
	public ActivitySwitchResponse()
	{
		_dataID=GameResponseType.ActivitySwitch;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ActivitySwitchResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.id=stream.readInt();
		
		this.isRunning=stream.readBoolean();
		
		this.lastTurnTime=stream.readLong();
		
		this.nextTurnTime=stream.readLong();
		
		this.atTime=stream.readBoolean();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.isRunning=stream.readBoolean();
		
		this.lastTurnTime=stream.readLong();
		
		this.nextTurnTime=stream.readLong();
		
		this.atTime=stream.readBoolean();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
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
		writer.sb.append("lastTurnTime");
		writer.sb.append(':');
		writer.sb.append(this.lastTurnTime);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("nextTurnTime");
		writer.sb.append(':');
		writer.sb.append(this.nextTurnTime);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("atTime");
		writer.sb.append(':');
		writer.sb.append(this.atTime);
		
		writer.writeEnter();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.id=0;
		this.isRunning=false;
		this.lastTurnTime=0L;
		this.nextTurnTime=0L;
		this.atTime=false;
	}
	
}