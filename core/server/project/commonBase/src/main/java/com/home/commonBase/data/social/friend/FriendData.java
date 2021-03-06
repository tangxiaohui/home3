package com.home.commonBase.data.social.friend;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.social.friend.ContactData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 好友数据(maybeExtends)(generated by shine) */
public class FriendData extends ContactData
{
	/** 添加时间 */
	public long addTime;
	
	/** 是否是机器人好友 */
	public boolean isRobot;
	
	/** 数据类型ID */
	public static final int dataID=BaseDataType.Friend;
	
	public FriendData()
	{
		_dataID=BaseDataType.Friend;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FriendData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.addTime=stream.readLong();
		
		this.isRobot=stream.readBoolean();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeLong(this.addTime);
		
		stream.writeBoolean(this.isRobot);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.addTime=stream.readLong();
		
		this.isRobot=stream.readBoolean();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeLong(this.addTime);
		
		stream.writeBoolean(this.isRobot);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof FriendData))
			return;
		
		FriendData mData=(FriendData)data;
		
		this.addTime=mData.addTime;
		this.isRobot=mData.isRobot;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof FriendData))
			return;
		
		FriendData mData=(FriendData)data;
		
		this.addTime=mData.addTime;
		
		this.isRobot=mData.isRobot;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		FriendData mData=(FriendData)data;
		if(this.addTime!=mData.addTime)
			return false;
		
		if(this.isRobot!=mData.isRobot)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("addTime");
		writer.sb.append(':');
		writer.sb.append(this.addTime);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("isRobot");
		writer.sb.append(':');
		writer.sb.append(this.isRobot);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		super.initDefault();
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.addTime=0L;
		this.isRobot=false;
	}
	
}
