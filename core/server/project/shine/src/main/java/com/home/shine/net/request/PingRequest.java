package com.home.shine.net.request;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.constlist.generate.ShineRequestType;
import com.home.shine.control.BytesControl;
import com.home.shine.net.base.ShineRequest;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** ping包第一步(generated by shine) */
public class PingRequest extends ShineRequest
{
	/** 数据类型ID */
	public static final int dataID=ShineRequestType.Ping;
	
	public int index;
	
	public PingRequest()
	{
		_dataID=ShineRequestType.Ping;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "PingRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.index);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.index);
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("index");
		writer.sb.append(':');
		writer.sb.append(this.index);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.index=0;
	}
	
	/** 创建实例 */
	public static PingRequest create(int index)
	{
		PingRequest re=(PingRequest)BytesControl.createRequest(dataID);
		re.index=index;
		return re;
	}
	
}