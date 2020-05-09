package com.home.commonGame.net.request.system;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 收到客户端离线事务消息(generated by shine) */
public class ReceiveClientOfflineWorkRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.ReceiveClientOfflineWork;
	
	/** 收到的序号 */
	public int receiveIndex;
	
	/** 是否执行成功 */
	public boolean success;
	
	public ReceiveClientOfflineWorkRequest()
	{
		_dataID=GameRequestType.ReceiveClientOfflineWork;
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
		return "ReceiveClientOfflineWorkRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.receiveIndex);
		
		stream.writeBoolean(this.success);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.receiveIndex);
		
		stream.writeBoolean(this.success);
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("receiveIndex");
		writer.sb.append(':');
		writer.sb.append(this.receiveIndex);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("success");
		writer.sb.append(':');
		writer.sb.append(this.success);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.receiveIndex=0;
		this.success=false;
	}
	
	/** 创建实例 */
	public static ReceiveClientOfflineWorkRequest create(int receiveIndex,boolean success)
	{
		ReceiveClientOfflineWorkRequest re=(ReceiveClientOfflineWorkRequest)BytesControl.createRequest(dataID);
		re.receiveIndex=receiveIndex;
		re.success=success;
		return re;
	}
	
}