package com.home.commonClient.net.request.social.friend;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 移除好友黑名单(generated by shine) */
public class RemoveFriendBlackListRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.RemoveFriendBlackList;
	
	public long playerID;
	
	public RemoveFriendBlackListRequest()
	{
		_dataID=GameRequestType.RemoveFriendBlackList;
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
		return "RemoveFriendBlackListRequest";
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
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeLong(this.playerID);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeLong(this.playerID);
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.playerID=0L;
	}
	
	/** 创建实例 */
	public static RemoveFriendBlackListRequest create(long playerID)
	{
		RemoveFriendBlackListRequest re=(RemoveFriendBlackListRequest)BytesControl.createRequest(dataID);
		re.playerID=playerID;
		return re;
	}
	
}
