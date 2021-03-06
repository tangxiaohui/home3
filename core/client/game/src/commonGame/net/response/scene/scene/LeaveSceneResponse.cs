using ShineEngine;

/// <summary>
/// 离开场景消息(generated by shine)
/// </summary>
public class LeaveSceneResponse:GameResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.LeaveScene;
	
	/// <summary>
	/// 是否还要进下一个场景
	/// </summary>
	public bool hasNextScene;
	
	public LeaveSceneResponse()
	{
		_dataID=GameResponseType.LeaveScene;
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		GameC.scene.onLeaveScene(hasNextScene);
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "LeaveSceneResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.hasNextScene=stream.readBoolean();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.hasNextScene=stream.readBoolean();
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("hasNextScene");
		writer.sb.Append(':');
		writer.sb.Append(this.hasNextScene);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.hasNextScene=false;
	}
	
}
