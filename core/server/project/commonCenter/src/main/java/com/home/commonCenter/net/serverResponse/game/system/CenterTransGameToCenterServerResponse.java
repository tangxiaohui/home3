package com.home.commonCenter.net.serverResponse.game.system;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonCenter.net.base.CenterResponse;
import com.home.commonCenter.net.serverResponse.game.base.GameToCenterServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.ctrl.Ctrl;
import com.home.shine.global.ShineSetting;
import com.home.shine.net.base.BaseResponse;
import com.home.shine.server.BaseServer;

/** 中心服转发消息到中心服(generated by shine) */
public class CenterTransGameToCenterServerResponse extends GameToCenterServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.CenterTransGameToCenter;
	
	public CenterTransGameToCenterServerResponse()
	{
		_dataID=ServerMessageType.CenterTransGameToCenter;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		
	}
	
	@Override
	public BaseResponse readFromStream(BytesReadStream stream,BaseServer server)
	{
		long playerID=stream.readLong();
		
		int mid=stream.natureReadUnsignedShort();
		
		CenterResponse response=(CenterResponse)server.createClientResponse(mid);
		
		if(response==null)
		{
			if(ShineSetting.needMessageExistCheck)
			{
				Ctrl.errorLog("未解析mid为" + mid + "的协议");
			}
			
			return null;
		}
		
		response.playerID=playerID;
		response.setSocket(socket);
		//从流读取
		return response.readFromStream(stream, server);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CenterTransGameToCenterServerResponse";
	}
	
}