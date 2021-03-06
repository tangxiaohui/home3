package com.home.commonGame.net.serverResponse.center.system;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.system.PlayerWorkData;
import com.home.commonGame.global.GameC;
import com.home.commonGame.net.serverResponse.center.base.CenterToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送角色事务(generated by shine) */
public class SendPlayerWorkServerResponse extends CenterToGameServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.SendPlayerWork;
	
	/** 在线事务 */
	public PlayerWorkData data;
	
	public SendPlayerWorkServerResponse()
	{
		_dataID=ServerMessageType.SendPlayerWork;
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
		GameC.main.onAddPlayerWork(data);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "SendPlayerWorkServerResponse";
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
