package com.home.commonGame.net.serverRequest.game.social;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.social.chat.RoleChatData;
import com.home.commonGame.net.serverRequest.game.base.PlayerGameToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送玩家聊天消息(generated by shine) */
public class SendPlayerChatToPlayerServerRequest extends PlayerGameToGameServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.SendPlayerChatToPlayer;
	
	/** 聊天数据 */
	public RoleChatData chatData;
	
	/** 频道 */
	public int channel;
	
	/** 第二索引 */
	public long key;
	
	public SendPlayerChatToPlayerServerRequest()
	{
		_dataID=ServerMessageType.SendPlayerChatToPlayer;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		RoleChatData chatDataTemp=chatData;
		if(chatDataTemp!=null)
		{
			this.chatData=(RoleChatData)chatDataTemp.clone();
		}
		else
		{
			this.chatData=null;
			nullObjError("chatData");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "SendPlayerChatToPlayerServerRequest";
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.chatData!=null)
		{
			stream.writeDataSimpleNotNull(this.chatData);
		}
		else
		{
			nullObjError("chatData");
		}
		
		stream.writeInt(this.channel);
		
		stream.writeLong(this.key);
		
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
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.chatData.release(pool);
		this.chatData=null;
		this.channel=0;
		this.key=0L;
	}
	
	/** 创建实例 */
	public static SendPlayerChatToPlayerServerRequest create(RoleChatData chatData,int channel,long key)
	{
		SendPlayerChatToPlayerServerRequest re=(SendPlayerChatToPlayerServerRequest)BytesControl.createRequest(dataID);
		re.chatData=chatData;
		re.channel=channel;
		re.key=key;
		return re;
	}
	
}