package com.home.commonClient.net.response.social.friend;
import com.home.commonBase.data.social.friend.ContactData;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.base.GameResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送添加好友黑名单(generated by shine) */
public class SendAddFriendBlackListResponse extends GameResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.SendAddFriendBlackList;
	
	/** 联系人数据 */
	public ContactData data;
	
	public SendAddFriendBlackListResponse()
	{
		_dataID=GameResponseType.SendAddFriendBlackList;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.friend.onAddBlackList(data);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "SendAddFriendBlackListResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		BaseData dataT=stream.readDataFullNotNull();
		if(dataT!=null)
		{
			if(dataT instanceof ContactData)
			{
				this.data=(ContactData)dataT;
			}
			else
			{
				this.data=new ContactData();
				if(!(dataT.getClass().isAssignableFrom(ContactData.class)))
				{
					stream.throwTypeReadError(ContactData.class,dataT.getClass());
				}
				this.data.shadowCopy(dataT);
			}
		}
		else
		{
			this.data=null;
		}
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.data=(ContactData)stream.readDataSimpleNotNull();
		
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
			writer.sb.append("ContactData=null");
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