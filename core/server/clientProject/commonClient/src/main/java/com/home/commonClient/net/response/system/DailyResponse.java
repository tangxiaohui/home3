package com.home.commonClient.net.response.system;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.base.GameResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 每日消息(generated by shine) */
public class DailyResponse extends GameResponse
{
	/** 下个每日时间 */
	public long nextDailyTime;
	
	/** 数据类型ID */
	public static final int dataID=GameResponseType.Daily;
	
	public DailyResponse()
	{
		_dataID=GameResponseType.Daily;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.onDaily();
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "DailyResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.nextDailyTime=stream.readLong();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.nextDailyTime=stream.readLong();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("nextDailyTime");
		writer.sb.append(':');
		writer.sb.append(this.nextDailyTime);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.nextDailyTime=0L;
	}
	
}