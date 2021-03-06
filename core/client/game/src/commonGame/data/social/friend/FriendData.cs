using ShineEngine;

/// <summary>
/// 好友数据(maybeExtends)(generated by shine)
/// </summary>
public class FriendData:ContactData
{
	/// <summary>
	/// 添加时间
	/// </summary>
	public long addTime;
	
	/// <summary>
	/// 是否是机器人好友
	/// </summary>
	public bool isRobot;
	
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.Friend;
	
	public FriendData()
	{
		_dataID=BaseDataType.Friend;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "FriendData";
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.addTime=stream.readLong();
		
		this.isRobot=stream.readBoolean();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeLong(this.addTime);
		
		stream.writeBoolean(this.isRobot);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		base.toShadowCopy(data);
		
		if(!(data is FriendData))
			return;
		
		FriendData mData=(FriendData)data;
		
		this.addTime=mData.addTime;
		this.isRobot=mData.isRobot;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		base.toCopy(data);
		
		if(!(data is FriendData))
			return;
		
		FriendData mData=(FriendData)data;
		
		this.addTime=mData.addTime;
		
		this.isRobot=mData.isRobot;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		if(!base.toDataEquals(data))
			return false;
		
		FriendData mData=(FriendData)data;
		if(this.addTime!=mData.addTime)
			return false;
		
		if(this.isRobot!=mData.isRobot)
			return false;
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("addTime");
		writer.sb.Append(':');
		writer.sb.Append(this.addTime);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("isRobot");
		writer.sb.Append(':');
		writer.sb.Append(this.isRobot);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		base.initDefault();
		
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.addTime=stream.readLong();
		
		this.isRobot=stream.readBoolean();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeLong(this.addTime);
		
		stream.writeBoolean(this.isRobot);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.addTime=0L;
		this.isRobot=false;
	}
	
}
