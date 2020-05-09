using ShineEngine;

/// <summary>
/// 创建玩家群消息(generated by shine)
/// </summary>
public class FuncCreateRoleGroupRequest:FuncRRequest
{
	/// <summary>
	/// 创建数据
	/// </summary>
	public CreateRoleGroupData createData;
	
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameRequestType.FuncCreateRoleGroup;
	
	public FuncCreateRoleGroupRequest()
	{
		_dataID=GameRequestType.FuncCreateRoleGroup;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "FuncCreateRoleGroupRequest";
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.createData!=null)
		{
			stream.writeDataFullNotNull(this.createData);
		}
		else
		{
			nullObjError("createData");
		}
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		if(this.createData!=null)
		{
			stream.writeDataSimpleNotNull(this.createData);
		}
		else
		{
			nullObjError("createData");
		}
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("createData");
		writer.sb.Append(':');
		if(this.createData!=null)
		{
			this.createData.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("CreateRoleGroupData=null");
		}
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.createData.release(pool);
		this.createData=null;
	}
	
	protected override void copyData()
	{
		base.copyData();
		CreateRoleGroupData createDataTemp=createData;
		if(createDataTemp!=null)
		{
			this.createData=(CreateRoleGroupData)createDataTemp.clone();
		}
		else
		{
			this.createData=null;
			nullObjError("createData");
		}
		
	}
	
	/// <summary>
	/// 创建实例
	/// </summary>
	public static FuncCreateRoleGroupRequest create(int funcID,CreateRoleGroupData createData)
	{
		FuncCreateRoleGroupRequest re=(FuncCreateRoleGroupRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.createData=createData;
		return re;
	}
	
}