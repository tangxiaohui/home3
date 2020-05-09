package com.home.commonGame.net.serverRequest.game.login;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.net.serverRequest.game.base.GameToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 角色预切换game到中心服(generated by shine) */
public class PlayerPreSwitchGameToGameServerRequest extends GameToGameServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.PlayerPreSwitchGameToGame;
	
	/** 角色ID */
	public long playerID;
	
	/** 目标gameID */
	public int targetGameID;
	
	public PlayerPreSwitchGameToGameServerRequest()
	{
		_dataID=ServerMessageType.PlayerPreSwitchGameToGame;
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
		return "PlayerPreSwitchGameToGameServerRequest";
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeLong(this.playerID);
		
		stream.writeInt(this.targetGameID);
		
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
		writer.sb.append("targetGameID");
		writer.sb.append(':');
		writer.sb.append(this.targetGameID);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.playerID=0L;
		this.targetGameID=0;
	}
	
	/** 创建实例 */
	public static PlayerPreSwitchGameToGameServerRequest create(long playerID,int targetGameID)
	{
		PlayerPreSwitchGameToGameServerRequest re=(PlayerPreSwitchGameToGameServerRequest)BytesControl.createRequest(dataID);
		re.playerID=playerID;
		re.targetGameID=targetGameID;
		return re;
	}
	
}