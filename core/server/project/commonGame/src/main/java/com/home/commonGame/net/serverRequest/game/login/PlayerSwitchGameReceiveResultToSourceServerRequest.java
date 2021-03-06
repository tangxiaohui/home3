package com.home.commonGame.net.serverRequest.game.login;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.net.serverRequest.game.base.GameToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 角色切换game服数据接收结果到源服(generated by shine) */
public class PlayerSwitchGameReceiveResultToSourceServerRequest extends GameToGameServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.PlayerSwitchGameReceiveResultToSource;
	
	/** 角色ID */
	public long playerID;
	
	/** 是否成功切换 */
	public boolean isSuccess;
	
	public PlayerSwitchGameReceiveResultToSourceServerRequest()
	{
		_dataID=ServerMessageType.PlayerSwitchGameReceiveResultToSource;
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
		return "PlayerSwitchGameReceiveResultToSourceServerRequest";
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeLong(this.playerID);
		
		stream.writeBoolean(this.isSuccess);
		
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
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.playerID=0L;
		this.isSuccess=false;
	}
	
	/** 创建实例 */
	public static PlayerSwitchGameReceiveResultToSourceServerRequest create(long playerID,boolean isSuccess)
	{
		PlayerSwitchGameReceiveResultToSourceServerRequest re=(PlayerSwitchGameReceiveResultToSourceServerRequest)BytesControl.createRequest(dataID);
		re.playerID=playerID;
		re.isSuccess=isSuccess;
		return re;
	}
	
}
