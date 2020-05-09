using ShineEngine;

/// <summary>
/// 申请离开当前场景(generated by shine)
/// </summary>
public class ApplyLeaveSceneRequest:GameRequest
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameRequestType.ApplyLeaveScene;
	
	public ApplyLeaveSceneRequest()
	{
		_dataID=GameRequestType.ApplyLeaveScene;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "ApplyLeaveSceneRequest";
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
	public static ApplyLeaveSceneRequest create()
	{
		ApplyLeaveSceneRequest re=(ApplyLeaveSceneRequest)BytesControl.createRequest(dataID);
		return re;
	}
	
}