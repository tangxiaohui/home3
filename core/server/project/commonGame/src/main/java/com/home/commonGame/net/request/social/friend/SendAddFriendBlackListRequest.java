package com.home.commonGame.net.request.social.friend;
import com.home.commonBase.data.social.friend.ContactData;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送添加好友黑名单(generated by shine) */
public class SendAddFriendBlackListRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.SendAddFriendBlackList;
	
	/** 联系人数据 */
	public ContactData data;
	
	public SendAddFriendBlackListRequest()
	{
		_dataID=GameRequestType.SendAddFriendBlackList;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		ContactData dataTemp=data;
		if(dataTemp!=null)
		{
			this.data=(ContactData)dataTemp.clone();
		}
		else
		{
			this.data=null;
			nullObjError("data");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "SendAddFriendBlackListRequest";
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
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.data!=null)
		{
			stream.writeDataFullNotNull(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.data!=null)
		{
			stream.writeDataSimpleNotNull(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.data.release(pool);
		this.data=null;
	}
	
	/** 创建实例 */
	public static SendAddFriendBlackListRequest create(ContactData data)
	{
		SendAddFriendBlackListRequest re=(SendAddFriendBlackListRequest)BytesControl.createRequest(dataID);
		re.data=data;
		return re;
	}
	
}
