package com.home.commonCenter.net.serverRequest.game.system;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonCenter.net.serverRequest.game.base.CenterToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;

/** 游戏服重新加载配置消息(generated by shine) */
public class GameReloadConfigServerRequest extends CenterToGameServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.GameReloadConfig;
	
	public GameReloadConfigServerRequest()
	{
		_dataID=ServerMessageType.GameReloadConfig;
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
		return "GameReloadConfigServerRequest";
	}
	
	/** 创建实例 */
	public static GameReloadConfigServerRequest create()
	{
		GameReloadConfigServerRequest re=(GameReloadConfigServerRequest)BytesControl.createRequest(dataID);
		return re;
	}
	
}
