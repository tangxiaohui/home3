package com.home.commonCenter.net.serverResponse.game.system;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.system.PlayerWorkData;
import com.home.commonCenter.global.CenterC;
import com.home.commonCenter.net.serverResponse.game.base.GameToCenterServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送角色事务到中心服(generated by shine) */
public class SendPlayerWorkToCenterServerResponse extends GameToCenterServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.SendPlayerWorkToCenter;
	
	/** 事务 */
	public PlayerWorkData data;
	
	public SendPlayerWorkToCenterServerResponse()
	{
		_dataID=ServerMessageType.SendPlayerWorkToCenter;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.data=(PlayerWorkData)stream.readDataSimpleNotNull();
		
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		CenterC.main.onAddPlayerWorkForGame(data);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "SendPlayerWorkToCenterServerResponse";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("data");
		writer.sb.append(':');
		if(this.data!=null)
		{
			this.data.writeDataString(writer);
		}
		else
		{
			writer.sb.append("PlayerWorkData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.data=null;
	}
	
}
