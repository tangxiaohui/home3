using ShineEngine;

/// <summary>
/// 客户端GM指令(generated by shine)
/// </summary>
public class ClientGMRequest:GameRequest
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameRequestType.ClientGM;
	
	/// <summary>
	/// 指令
	/// </summary>
	public string cmd;
	
	public ClientGMRequest()
	{
		_dataID=GameRequestType.ClientGM;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "ClientGMRequest";
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("cmd");
		writer.sb.Append(':');
		writer.sb.Append(this.cmd);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeUTF(this.cmd);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeUTF(this.cmd);
		
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.cmd="";
	}
	
	protected override void copyData()
	{
		base.copyData();
	}
	
	/// <summary>
	/// 创建实例
	/// </summary>
	public static ClientGMRequest create(string cmd)
	{
		ClientGMRequest re=(ClientGMRequest)BytesControl.createRequest(dataID);
		re.cmd=cmd;
		return re;
	}
	
}
