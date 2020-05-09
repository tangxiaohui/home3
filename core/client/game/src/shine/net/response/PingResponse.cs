using ShineEngine;

/// <summary>
/// ping包第一步(generated by shine)
/// </summary>
public class PingResponse:ShineResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=ShineResponseType.Ping;
	
	public int index;
	
	public PingResponse()
	{
		_dataID=ShineResponseType.Ping;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "PingResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.index=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		Ctrl.errorLog("客户端不该受到ping消息");
		// socket.refreshPingTime();
		// socket.sendAbs(RePingRequest.create());
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.index=stream.readInt();
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("index");
		writer.sb.Append(':');
		writer.sb.Append(this.index);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.index=0;
	}
	
}