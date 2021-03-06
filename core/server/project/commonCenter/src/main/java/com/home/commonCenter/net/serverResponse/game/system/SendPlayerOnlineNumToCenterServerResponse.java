package com.home.commonCenter.net.serverResponse.game.system;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonCenter.global.CenterC;
import com.home.commonCenter.net.serverResponse.game.base.GameToCenterServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送在线角色数到中心服消息(generated by shine) */
public class SendPlayerOnlineNumToCenterServerResponse extends GameToCenterServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.SendPlayerOnlineNumToCenter;
	
	public int num;
	
	public SendPlayerOnlineNumToCenterServerResponse()
	{
		_dataID=ServerMessageType.SendPlayerOnlineNumToCenter;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "SendPlayerOnlineNumToCenterServerResponse";
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.num=stream.readInt();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("num");
		writer.sb.append(':');
		writer.sb.append(this.num);
		
		writer.writeEnter();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		CenterC.main.onRefreshGameOnlineNum(fromGameID,num);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.num=0;
	}
	
}
