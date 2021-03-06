using ShineEngine;

/// <summary>
/// 改变格子数(generated by shine)
/// </summary>
public class FuncRefreshItemGridNumResponse:FuncSResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.FuncRefreshItemGridNum;
	
	/// <summary>
	/// 格子数
	/// </summary>
	public int gridNum;
	
	public FuncRefreshItemGridNumResponse()
	{
		_dataID=GameResponseType.FuncRefreshItemGridNum;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "FuncRefreshItemGridNumResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.gridNum=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.gridNum=stream.readInt();
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("gridNum");
		writer.sb.Append(':');
		writer.sb.Append(this.gridNum);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		me.func.getItemContainerTool(funcID).onRefreshGridNumByServer(gridNum);
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.gridNum=0;
	}
	
}
