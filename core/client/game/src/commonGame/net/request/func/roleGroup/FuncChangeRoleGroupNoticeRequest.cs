using ShineEngine;

/// <summary>
/// 修改群公告消息(generated by shine)
/// </summary>
public class FuncChangeRoleGroupNoticeRequest:FuncPlayerRoleGroupRRequest
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameRequestType.FuncChangeRoleGroupNotice;
	
	public string notice;
	
	public FuncChangeRoleGroupNoticeRequest()
	{
		_dataID=GameRequestType.FuncChangeRoleGroupNotice;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "FuncChangeRoleGroupNoticeRequest";
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeUTF(this.notice);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeUTF(this.notice);
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("notice");
		writer.sb.Append(':');
		writer.sb.Append(this.notice);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.notice="";
	}
	
	protected override void copyData()
	{
		base.copyData();
	}
	
	/// <summary>
	/// 创建实例
	/// </summary>
	public static FuncChangeRoleGroupNoticeRequest create(int funcID,long groupID,string notice)
	{
		FuncChangeRoleGroupNoticeRequest re=(FuncChangeRoleGroupNoticeRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.groupID=groupID;
		re.notice=notice;
		return re;
	}
	
}
