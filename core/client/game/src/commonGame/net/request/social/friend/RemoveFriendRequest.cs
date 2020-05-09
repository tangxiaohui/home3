using ShineEngine;

/// <summary>
/// 移除好友消息(generated by shine)
/// </summary>
public class RemoveFriendRequest:GameRequest
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameRequestType.RemoveFriend;
	
	/// <summary>
	/// 角色ID
	/// </summary>
	public long playerID;
	
	public RemoveFriendRequest()
	{
		_dataID=GameRequestType.RemoveFriend;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "RemoveFriendRequest";
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("playerID");
		writer.sb.Append(':');
		writer.sb.Append(this.playerID);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeLong(this.playerID);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeLong(this.playerID);
		
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.playerID=0L;
	}
	
	protected override void copyData()
	{
		base.copyData();
	}
	
	/// <summary>
	/// 创建实例
	/// </summary>
	public static RemoveFriendRequest create(long playerID)
	{
		RemoveFriendRequest re=(RemoveFriendRequest)BytesControl.createRequest(dataID);
		re.playerID=playerID;
		return re;
	}
	
}