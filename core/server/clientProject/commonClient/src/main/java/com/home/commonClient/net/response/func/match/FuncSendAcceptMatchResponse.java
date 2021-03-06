package com.home.commonClient.net.response.func.match;
import com.home.commonBase.constlist.generate.GameEventType;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.response.func.base.FuncSResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送接受匹配(generated by shine) */
public class FuncSendAcceptMatchResponse extends FuncSResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.FuncSendAcceptMatch;
	
	/** 角色ID */
	public long playerID;
	
	public FuncSendAcceptMatchResponse()
	{
		_dataID=GameResponseType.FuncSendAcceptMatch;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.dispatch(GameEventType.PlayerAcceptMatch,playerID);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncSendAcceptMatchResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.playerID=stream.readLong();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.playerID=stream.readLong();
		
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
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.playerID=0L;
	}
	
}
