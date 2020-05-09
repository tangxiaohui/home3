package com.home.commonGame.net.serverResponse.game.system;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.global.GameC;
import com.home.commonGame.net.serverResponse.game.base.GameToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.net.base.BaseResponse;
import com.home.shine.server.BaseServer;

/** (generated by shine) */
public class PlayerToGameTransGameToGameServerResponse extends GameToGameServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.PlayerToGameTransGameToGame;
	
	private byte[] _data;
	
	private long _playerID;
	
	public PlayerToGameTransGameToGameServerResponse()
	{
		_dataID=ServerMessageType.PlayerToGameTransGameToGame;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "PlayerToGameTransGameToGameServerResponse";
	}
	
	@Override
	public BaseResponse readFromStream(BytesReadStream stream,BaseServer server)
	{
		_playerID=stream.readLong();
		_data=stream.getByteArrayFromPos();
		
		return this;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		GameC.gameSwitch.addPlayerToGameRequest(_playerID,_data);
	}
	
}