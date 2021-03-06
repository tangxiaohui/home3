using ShineEngine;

/// <summary>
/// (generated by shine)
/// </summary>
public class FuncResetRoleGroupRankResponse:FuncSResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.FuncResetRoleGroupRank;
	
	/// <summary>
	/// 玩家群功能ID
	/// </summary>
	public int roleGroupFuncID;
	
	/// <summary>
	/// 玩家群ID
	/// </summary>
	public long groupID;
	
	public FuncResetRoleGroupRankResponse()
	{
		_dataID=GameResponseType.FuncResetRoleGroupRank;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "FuncResetRoleGroupRankResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.roleGroupFuncID=stream.readInt();
		
		this.groupID=stream.readLong();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.roleGroupFuncID=stream.readInt();
		
		this.groupID=stream.readLong();
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("roleGroupFuncID");
		writer.sb.Append(':');
		writer.sb.Append(this.roleGroupFuncID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("groupID");
		writer.sb.Append(':');
		writer.sb.Append(this.groupID);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		me.func.getRoleGroupRankTool(funcID).onResetRank();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.roleGroupFuncID=0;
		this.groupID=0L;
	}
	
}
