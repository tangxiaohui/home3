using ShineEngine;

/// <summary>
/// 进入空场景消息(为客户端显示)(generated by shine)
/// </summary>
public class EnterNoneSceneResponse:GameResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.EnterNoneScene;
	
	public EnterNoneSceneResponse()
	{
		_dataID=GameResponseType.EnterNoneScene;
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		GameC.scene.doEnterNoneScene();
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "EnterNoneSceneResponse";
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
