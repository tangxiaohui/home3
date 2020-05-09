package com.home.commonGame.net.response.social.chat;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.net.base.GameResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 角色接收聊天序号(generated by shine) */
public class PlayerReceiveChatIndexResponse extends GameResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.PlayerReceiveChatIndex;
	
	public int index;
	
	public PlayerReceiveChatIndexResponse()
	{
		_dataID=GameResponseType.PlayerReceiveChatIndex;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "PlayerReceiveChatIndexResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.index=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.index=stream.readInt();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("index");
		writer.sb.append(':');
		writer.sb.append(this.index);
		
		writer.writeEnter();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.social.onChatReceiveIndex(index);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.index=0;
	}
	
}