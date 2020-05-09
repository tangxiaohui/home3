package com.home.commonGame.net.serverResponse.game.login;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.global.GameC;
import com.home.commonGame.net.serverResponse.game.base.GameToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 角色切换game服数据接收结果到源服(generated by shine) */
public class PlayerSwitchGameReceiveResultToSourceServerResponse extends GameToGameServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.PlayerSwitchGameReceiveResultToSource;
	
	/** 角色ID */
	public long playerID;
	
	/** 是否成功切换 */
	public boolean isSuccess;
	
	public PlayerSwitchGameReceiveResultToSourceServerResponse()
	{
		_dataID=ServerMessageType.PlayerSwitchGameReceiveResultToSource;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "PlayerSwitchGameReceiveResultToSourceServerResponse";
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.playerID=stream.readLong();
		
		this.isSuccess=stream.readBoolean();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("playerID");
		writer.sb.append(':');
		writer.sb.append(this.playerID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("isSuccess");
		writer.sb.append(':');
		writer.sb.append(this.isSuccess);
		
		writer.writeEnter();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		GameC.gameSwitch.sourcePlayerSwitchReceiveResult(playerID,fromGameID,isSuccess);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.playerID=0L;
		this.isSuccess=false;
	}
	
}