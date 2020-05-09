package com.home.commonGame.net.request.system;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送Game服息回执(generated by shine) */
public class SendGameReceiptToClientRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.SendGameReceiptToClient;
	
	/** 对应的requestID */
	public int requestID;
	
	public SendGameReceiptToClientRequest()
	{
		_dataID=GameRequestType.SendGameReceiptToClient;
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
		return "SendGameReceiptToClientRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.requestID);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.requestID);
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("requestID");
		writer.sb.append(':');
		writer.sb.append(this.requestID);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.requestID=0;
	}
	
	/** 创建实例 */
	public static SendGameReceiptToClientRequest create(int requestID)
	{
		SendGameReceiptToClientRequest re=(SendGameReceiptToClientRequest)BytesControl.createRequest(dataID);
		re.requestID=requestID;
		return re;
	}
	
}