using ShineEngine;

/// <summary>
/// 创建角色消息(generated by shine)
/// </summary>
public class CreatePlayerRequest:LoginRequest
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameRequestType.CreatePlayer;
	
	/// <summary>
	/// 数据
	/// </summary>
	public CreatePlayerData data;
	
	public CreatePlayerRequest()
	{
		_dataID=GameRequestType.CreatePlayer;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "CreatePlayerRequest";
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("data");
		writer.sb.Append(':');
		if(this.data!=null)
		{
			this.data.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("CreatePlayerData=null");
		}
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.data!=null)
		{
			stream.writeDataFullNotNull(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		if(this.data!=null)
		{
			stream.writeDataSimpleNotNull(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.data.release(pool);
		this.data=null;
	}
	
	protected override void copyData()
	{
		base.copyData();
		CreatePlayerData dataTemp=data;
		if(dataTemp!=null)
		{
			this.data=(CreatePlayerData)dataTemp.clone();
		}
		else
		{
			this.data=null;
			nullObjError("data");
		}
		
	}
	
	/// <summary>
	/// 创建实例
	/// </summary>
	public static CreatePlayerRequest create(CreatePlayerData data)
	{
		CreatePlayerRequest re=(CreatePlayerRequest)BytesControl.createRequest(dataID);
		re.data=data;
		return re;
	}
	
}