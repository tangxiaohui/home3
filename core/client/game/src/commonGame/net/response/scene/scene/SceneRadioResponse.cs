using ShineEngine;

/// <summary>
/// 推送场景广播消息(generated by shine)
/// </summary>
public class SceneRadioResponse:SceneSResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.SceneRadio;
	
	/// <summary>
	/// 数据
	/// </summary>
	public BaseData data;
	
	public SceneRadioResponse()
	{
		_dataID=GameResponseType.SceneRadio;
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		//TODO:暂时没用到
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "SceneRadioResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		BaseData dataT=stream.readDataFullNotNull();
		if(dataT!=null)
		{
			if(dataT is BaseData)
			{
				this.data=(BaseData)dataT;
			}
			else
			{
				this.data=new BaseData();
				if(!(dataT.GetType().IsAssignableFrom(typeof(BaseData))))
				{
					stream.throwTypeReadError(typeof(BaseData),dataT.GetType());
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
		
		this.data=(BaseData)stream.readDataSimpleNotNull();
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("data");
		writer.sb.Append(':');
		if(this.data!=null)
		{
			this.data.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("BaseData=null");
		}
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.data=null;
	}
	
}