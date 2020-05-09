using ShineEngine;

/// <summary>
/// 主单位消息基类(generated by shine)
/// </summary>
public class MUnitSResponse:GameResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.MUnitS;
	
	/// <summary>
	/// 主单位序号
	/// </summary>
	public int mIndex;
	
	/// <summary>
	/// 主单位使用逻辑
	/// </summary>
	public MUnitUseLogic mLogic;
	
	public MUnitSResponse()
	{
		_dataID=GameResponseType.MUnitS;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "MUnitSResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.mIndex=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.mIndex=stream.readInt();
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("mIndex");
		writer.sb.Append(':');
		writer.sb.Append(this.mIndex);
		
		writer.writeEnter();
	}
	
	protected override void preExecute()
	{
		if((mLogic=me.character.getMUnitUseLogic(mIndex))==null)
		{
			Ctrl.warnLog("收到MUnit类消息时,主单位使用逻辑不存在");
			return;
		}

		execute();
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.mIndex=0;
	}
	
}