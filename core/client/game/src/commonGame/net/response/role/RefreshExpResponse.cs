using ShineEngine;

/// <summary>
/// 刷经验消息(generated by shine)
/// </summary>
public class RefreshExpResponse:GameResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.RefreshExp;
	
	/// <summary>
	/// 经验值
	/// </summary>
	public long exp;
	
	public RefreshExpResponse()
	{
		_dataID=GameResponseType.RefreshExp;
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		me.role.onRefreshExp(exp);
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "RefreshExpResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.exp=stream.readLong();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.exp=stream.readLong();
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("exp");
		writer.sb.Append(':');
		writer.sb.Append(this.exp);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.exp=0L;
	}
	
}
