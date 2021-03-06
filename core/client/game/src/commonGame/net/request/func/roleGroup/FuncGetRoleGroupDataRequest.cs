using ShineEngine;

/// <summary>
/// 获取玩家群数据消息(generated by shine)
/// </summary>
public class FuncGetRoleGroupDataRequest:FuncPlayerRoleGroupRRequest
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameRequestType.FuncGetRoleGroupData;
	
	public FuncGetRoleGroupDataRequest()
	{
		_dataID=GameRequestType.FuncGetRoleGroupData;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "FuncGetRoleGroupDataRequest";
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.endWriteObj();
	}
	
	protected override void copyData()
	{
		base.copyData();
	}
	
	/// <summary>
	/// 创建实例
	/// </summary>
	public static FuncGetRoleGroupDataRequest create(int funcID,long groupID)
	{
		FuncGetRoleGroupDataRequest re=(FuncGetRoleGroupDataRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.groupID=groupID;
		return re;
	}
	
}
