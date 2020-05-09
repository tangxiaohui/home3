package com.home.commonCenter.net.serverRequest.game.system;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonCenter.net.serverRequest.game.base.CenterToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送事务执行失败(找不到game服)(generated by shine) */
public class SendWorkFailedServerRequest extends CenterToGameServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.SendWorkFailed;
	
	/** 发送者序号 */
	public int senderIndex;
	
	/** 实例ID */
	public long instanceID;
	
	public SendWorkFailedServerRequest()
	{
		_dataID=ServerMessageType.SendWorkFailed;
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
		return "SendWorkFailedServerRequest";
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.senderIndex);
		
		stream.writeLong(this.instanceID);
		
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
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.senderIndex=0;
		this.instanceID=0L;
	}
	
	/** 创建实例 */
	public static SendWorkFailedServerRequest create(int senderIndex,long instanceID)
	{
		SendWorkFailedServerRequest re=(SendWorkFailedServerRequest)BytesControl.createRequest(dataID);
		re.senderIndex=senderIndex;
		re.instanceID=instanceID;
		return re;
	}
	
}