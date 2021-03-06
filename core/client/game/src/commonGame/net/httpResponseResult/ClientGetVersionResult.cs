using ShineEngine;

/// <summary>
/// (generated by shine)
/// </summary>
public class ClientGetVersionResult:BaseData
{
	/// <summary>
	/// 版本数据(空为服务器并无此版本)
	/// </summary>
	public ClientVersionData version;
	
	/// <summary>
	/// 重定向的url
	/// </summary>
	public string redirectURL;
	
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=LoginHttpResponseResultType.ClientGetVersion;
	
	public ClientGetVersionResult()
	{
		_dataID=LoginHttpResponseResultType.ClientGetVersion;
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		if(stream.readBoolean())
		{
			this.version=(ClientVersionData)stream.createData(ClientVersionData.dataID);
			this.version.readBytesFull(stream);
		}
		else
		{
			this.version=null;
		}
		
		this.redirectURL=stream.readUTF();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.version!=null)
		{
			stream.writeBoolean(true);
			this.version.writeBytesFull(stream);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeUTF(this.redirectURL);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		if(stream.readBoolean())
		{
			this.version=(ClientVersionData)stream.createData(ClientVersionData.dataID);
			this.version.readBytesSimple(stream);
		}
		else
		{
			this.version=null;
		}
		
		this.redirectURL=stream.readUTF();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.version!=null)
		{
			stream.writeBoolean(true);
			this.version.writeBytesSimple(stream);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeUTF(this.redirectURL);
		
	}
	
}
