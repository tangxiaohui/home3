package com.home.commonClient.net.centerResponse.func.base;
import com.home.commonClient.constlist.generate.CenterResponseType;
import com.home.commonClient.net.base.CenterResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class FuncFromCenterSResponse extends CenterResponse
{
	/** 数据类型ID */
	public static final int dataID=CenterResponseType.FuncFromCenterS;
	
	/** 功能ID */
	public int funcID;
	
	public FuncFromCenterSResponse()
	{
		_dataID=CenterResponseType.FuncFromCenterS;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncFromCenterSResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.funcID=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.funcID=stream.readInt();
		
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
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.funcID=0;
	}
	
}