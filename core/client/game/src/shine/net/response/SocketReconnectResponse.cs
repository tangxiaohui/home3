using ShineEngine;

/// <summary>
/// 重连消息(generated by shine)
/// </summary>
public class SocketReconnectResponse:ShineResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=ShineResponseType.SocketReconnect;
	
	/// <summary>
	/// 源socketID
	/// </summary>
	public int socketID;
	
	/// <summary>
	/// 令牌
	/// </summary>
	public int token;
	
	/// <summary>
	/// 最后收包索引
	/// </summary>
	public int lastReceiveIndex;
	
	public SocketReconnectResponse()
	{
		_dataID=ShineResponseType.SocketReconnect;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "SocketReconnectResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.socketID=stream.readInt();
		
		this.token=stream.readInt();
		
		this.lastReceiveIndex=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.socketID=stream.readInt();
		
		this.token=stream.readInt();
		
		this.lastReceiveIndex=stream.readInt();
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("socketID");
		writer.sb.Append(':');
		writer.sb.Append(this.socketID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("token");
		writer.sb.Append(':');
		writer.sb.Append(this.token);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("lastReceiveIndex");
		writer.sb.Append(':');
		writer.sb.Append(this.lastReceiveIndex);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		Ctrl.errorLog("客户端不该受到SocketReconnect消息");
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.socketID=0;
		this.token=0;
		this.lastReceiveIndex=0;
	}
	
}