package com.home.commonGame.net.serverResponse.game.system;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.global.GameC;
import com.home.commonGame.net.serverResponse.game.base.GameToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 事务回执到game服(generated by shine) */
public class ReceiptWorkToGameServerResponse extends GameToGameServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.ReceiptWorkToGame;
	
	/** 发起者索引(type+id) */
	public int senderIndex;
	
	/** 结果 */
	public int result;
	
	/** 事务ID */
	public long instanceID;
	
	public ReceiptWorkToGameServerResponse()
	{
		_dataID=ServerMessageType.ReceiptWorkToGame;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ReceiptWorkToGameServerResponse";
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.senderIndex=stream.readInt();
		
		this.instanceID=stream.readLong();
		
		this.result=stream.readInt();
		
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		GameC.main.onReceiptWork(senderIndex,instanceID,result);
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
	
}
