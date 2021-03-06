using ShineEngine;

/// <summary>
/// 匹配结束(成功结束)(generated by shine)
/// </summary>
public class FuncMatchOverResponse:FuncSResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.FuncMatchOver;
	
	public FuncMatchOverResponse()
	{
		_dataID=GameResponseType.FuncMatchOver;
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		me.scene.setMatchingFuncID(-1);
		me.dispatch(GameEventType.MatchOver);
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "FuncMatchOverResponse";
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
