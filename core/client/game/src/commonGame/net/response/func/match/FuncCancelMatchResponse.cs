using ShineEngine;

/// <summary>
/// 取消匹配消息(generated by shine)
/// </summary>
public class FuncCancelMatchResponse:FuncSResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.FuncCancelMatch;
	
	public FuncCancelMatchResponse()
	{
		_dataID=GameResponseType.FuncCancelMatch;
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		me.scene.setMatchingFuncID(-1);
		me.dispatch(GameEventType.CancelMatch);
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "FuncCancelMatchResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		stream.endReadObj();
	}
	
}
