using ShineEngine;

/// <summary>
/// 客户端版本热更新消息(generated by shine)
/// </summary>
public class ClientHotfixResponse:GameResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.ClientHotfix;
	
	/// <summary>
	/// 客户端版本
	/// </summary>
	public ClientVersionData clientVersion;
	
	public ClientHotfixResponse()
	{
		_dataID=GameResponseType.ClientHotfix;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "ClientHotfixResponse";
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		GameC.mainLogin.clientHotfix(clientVersion);
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.clientVersion=(ClientVersionData)stream.createData(ClientVersionData.dataID);
		this.clientVersion.readBytesFull(stream);
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.clientVersion=(ClientVersionData)stream.createData(ClientVersionData.dataID);
		this.clientVersion.readBytesSimple(stream);
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("clientVersion");
		writer.sb.Append(':');
		if(this.clientVersion!=null)
		{
			this.clientVersion.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("ClientVersionData=null");
		}
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.clientVersion=null;
	}
	
}
