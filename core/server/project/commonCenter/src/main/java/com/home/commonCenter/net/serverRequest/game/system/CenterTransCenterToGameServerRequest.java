package com.home.commonCenter.net.serverRequest.game.system;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonCenter.net.base.CenterRequest;
import com.home.commonCenter.net.serverRequest.game.base.CenterToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;

/** 中心服转发消息(generated by shine) */
public class CenterTransCenterToGameServerRequest extends CenterToGameServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.CenterTransCenterToGame;
	
	private long _playerID;
	
	private CenterRequest _request;
	
	public CenterTransCenterToGameServerRequest()
	{
		_dataID=ServerMessageType.CenterTransCenterToGame;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
	}
	
	@Override
	protected void doWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeLong(_playerID);
		_request.writeToStream(stream);
	}
	
	/** 绑定数据 */
	public void setData(long playerID,CenterRequest request)
	{
		_playerID=playerID;
		_request=request;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CenterTransCenterToGameServerRequest";
	}
	
	/** 创建实例 */
	public static CenterTransCenterToGameServerRequest create()
	{
		CenterTransCenterToGameServerRequest re=(CenterTransCenterToGameServerRequest)BytesControl.createRequest(dataID);
		return re;
	}
	
}
