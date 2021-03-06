using ShineEngine;

/// <summary>
/// (generated by shine)
/// </summary>
public class FuncSendRoleGroupMemberRoleShowChangeResponse:FuncPlayerRoleGroupSResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.FuncSendRoleGroupMemberRoleShowChange;
	
	public long memberID;
	
	public RoleShowChangeData data;
	
	public FuncSendRoleGroupMemberRoleShowChangeResponse()
	{
		_dataID=GameResponseType.FuncSendRoleGroupMemberRoleShowChange;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "FuncSendRoleGroupMemberRoleShowChangeResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.memberID=stream.readLong();
		
		BaseData dataT=stream.readDataFullNotNull();
		if(dataT!=null)
		{
			if(dataT is RoleShowChangeData)
			{
				this.data=(RoleShowChangeData)dataT;
			}
			else
			{
				this.data=new RoleShowChangeData();
				if(!(dataT.GetType().IsAssignableFrom(typeof(RoleShowChangeData))))
				{
					stream.throwTypeReadError(typeof(RoleShowChangeData),dataT.GetType());
				}
				this.data.shadowCopy(dataT);
			}
		}
		else
		{
			this.data=null;
		}
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.memberID=stream.readLong();
		
		this.data=(RoleShowChangeData)stream.readDataSimpleNotNull();
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("memberID");
		writer.sb.Append(':');
		writer.sb.Append(this.memberID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("data");
		writer.sb.Append(':');
		if(this.data!=null)
		{
			this.data.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("RoleShowChangeData=null");
		}
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		roleGroup.onMemberRoleShowChange(memberID,data);
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.memberID=0L;
		this.data=null;
	}
	
}
