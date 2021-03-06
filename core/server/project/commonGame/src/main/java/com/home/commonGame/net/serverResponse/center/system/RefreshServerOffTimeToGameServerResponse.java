package com.home.commonGame.net.serverResponse.center.system;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.global.GameC;
import com.home.commonGame.net.serverResponse.center.base.CenterToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 刷新服务器偏移时间到游戏服(generated by shine) */
public class RefreshServerOffTimeToGameServerResponse extends CenterToGameServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.RefreshServerOffTimeToGame;
	
	/** 偏移时间 */
	public long offTime;
	
	public RefreshServerOffTimeToGameServerResponse()
	{
		_dataID=ServerMessageType.RefreshServerOffTimeToGame;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.offTime=stream.readLong();
		
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		GameC.global.system.setOffTime(offTime);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "RefreshServerOffTimeToGameServerResponse";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("offTime");
		writer.sb.append(':');
		writer.sb.append(this.offTime);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.offTime=0L;
	}
	
}
