package com.home.commonCenter.net.serverRequest.game.system;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonCenter.net.serverRequest.game.base.CenterToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class ReceiptWorkToGameFromCenterServerRequest extends CenterToGameServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.ReceiptWorkToGameFromCenter;
	
	/** 发起者索引(type+id) */
	public int senderIndex;
	
	/** 结果 */
	public int result;
	
	/** 事务ID */
	public long instanceID;
	
	public ReceiptWorkToGameFromCenterServerRequest()
	{
		_dataID=ServerMessageType.ReceiptWorkToGameFromCenter;
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
		return "ReceiptWorkToGameFromCenterServerRequest";
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.senderIndex);
		
		stream.writeLong(this.instanceID);
		
		stream.writeInt(this.result);
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("senderIndex");
		writer.sb.append(':');
		writer.sb.append(this.senderIndex);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("instanceID");
		writer.sb.append(':');
		writer.sb.append(this.instanceID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("result");
		writer.sb.append(':');
		writer.sb.append(this.result);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.senderIndex=0;
		this.instanceID=0L;
		this.result=0;
	}
	
	/** 创建实例 */
	public static ReceiptWorkToGameFromCenterServerRequest create(int senderIndex,long instanceID,int result)
	{
		ReceiptWorkToGameFromCenterServerRequest re=(ReceiptWorkToGameFromCenterServerRequest)BytesControl.createRequest(dataID);
		re.senderIndex=senderIndex;
		re.instanceID=instanceID;
		re.result=result;
		return re;
	}
	
}
