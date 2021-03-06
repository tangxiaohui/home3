package com.home.commonClient.net.response.social.chat;
import com.home.commonBase.data.social.chat.RoleChatData;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.base.GameResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送角色聊天(generated by shine) */
public class SendPlayerChatResponse extends GameResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.SendPlayerChat;
	
	/** 聊天数据 */
	public RoleChatData chatData;
	
	/** 频道 */
	public int channel;
	
	/** 二级索引 */
	public long key;
	
	public SendPlayerChatResponse()
	{
		_dataID=GameResponseType.SendPlayerChat;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "SendPlayerChatResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		BaseData chatDataT=stream.readDataFullNotNull();
		if(chatDataT!=null)
		{
			if(chatDataT instanceof RoleChatData)
			{
				this.chatData=(RoleChatData)chatDataT;
			}
			else
			{
				this.chatData=new RoleChatData();
				if(!(chatDataT.getClass().isAssignableFrom(RoleChatData.class)))
				{
					stream.throwTypeReadError(RoleChatData.class,chatDataT.getClass());
				}
				this.chatData.shadowCopy(chatDataT);
			}
		}
		else
		{
			this.chatData=null;
		}
		
		this.channel=stream.readInt();
		
		this.key=stream.readLong();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.chatData=(RoleChatData)stream.readDataSimpleNotNull();
		
		this.channel=stream.readInt();
		
		this.key=stream.readLong();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("chatData");
		writer.sb.append(':');
		if(this.chatData!=null)
		{
			this.chatData.writeDataString(writer);
		}
		else
		{
			writer.sb.append("RoleChatData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("channel");
		writer.sb.append(':');
		writer.sb.append(this.channel);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("key");
		writer.sb.append(':');
		writer.sb.append(this.key);
		
		writer.writeEnter();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.chatData=null;
		this.channel=0;
		this.key=0L;
	}
	
}
