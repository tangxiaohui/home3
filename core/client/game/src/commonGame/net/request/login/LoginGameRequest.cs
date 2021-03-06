using ShineEngine;

/// <summary>
/// 客户端登录逻辑服(generated by shine)
/// </summary>
public class LoginGameRequest:LoginRequest
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameRequestType.LoginGame;
	
	/// <summary>
	/// 令牌
	/// </summary>
	public int token;
	
	/// <summary>
	/// c层msg版本号
	/// </summary>
	public int cMsgVersion;
	
	/// <summary>
	/// g层msg版本号
	/// </summary>
	public int gMsgVersion;
	
	/// <summary>
	/// 资源版本号
	/// </summary>
	public int resourceVersion;
	
	public LoginGameRequest()
	{
		_dataID=GameRequestType.LoginGame;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "LoginGameRequest";
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("token");
		writer.sb.Append(':');
		writer.sb.Append(this.token);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("cMsgVersion");
		writer.sb.Append(':');
		writer.sb.Append(this.cMsgVersion);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("gMsgVersion");
		writer.sb.Append(':');
		writer.sb.Append(this.gMsgVersion);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("resourceVersion");
		writer.sb.Append(':');
		writer.sb.Append(this.resourceVersion);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.token);
		
		stream.writeInt(this.cMsgVersion);
		
		stream.writeInt(this.gMsgVersion);
		
		stream.writeInt(this.resourceVersion);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.token);
		
		stream.writeInt(this.cMsgVersion);
		
		stream.writeInt(this.gMsgVersion);
		
		stream.writeInt(this.resourceVersion);
		
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.token=0;
		this.cMsgVersion=0;
		this.gMsgVersion=0;
		this.resourceVersion=0;
	}
	
	protected override void copyData()
	{
		base.copyData();
	}
	
	/// <summary>
	/// 创建实例
	/// </summary>
	public static LoginGameRequest create(int token,int cMsgVersion,int gMsgVersion,int resourceVersion)
	{
		LoginGameRequest re=(LoginGameRequest)BytesControl.createRequest(dataID);
		re.token=token;
		re.cMsgVersion=cMsgVersion;
		re.gMsgVersion=gMsgVersion;
		re.resourceVersion=resourceVersion;
		return re;
	}
	
}
