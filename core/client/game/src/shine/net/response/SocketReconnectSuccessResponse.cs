using ShineEngine;

/// <summary>
/// 重连成功(generated by shine)
/// </summary>
public class SocketReconnectSuccessResponse:ShineResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=ShineResponseType.SocketReconnectSuccess;
	
	/// <summary>
	/// 最后收包索引
	/// </summary>
	public int lastReceiveIndex;
	
	public SocketReconnectSuccessResponse()
	{
		_dataID=ShineResponseType.SocketReconnectSuccess;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "SocketReconnectSuccessResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.lastReceiveIndex=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.lastReceiveIndex=stream.readInt();
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
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
		socket.onReconnectSuccess(lastReceiveIndex);
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.lastReceiveIndex=0;
	}
	
}
