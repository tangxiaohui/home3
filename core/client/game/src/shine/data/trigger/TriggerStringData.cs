using ShineEngine;

/// <summary>
/// (generated by shine)
/// </summary>
public class TriggerStringData:TriggerObjData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=ShineDataType.TriggerString;
	
	public string value;
	
	public TriggerStringData()
	{
		_dataID=ShineDataType.TriggerString;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "TriggerStringData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.value=stream.readUTF();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeUTF(this.value);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.value=stream.readUTF();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeUTF(this.value);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		base.toShadowCopy(data);
		
		if(!(data is TriggerStringData))
			return;
		
		TriggerStringData mData=(TriggerStringData)data;
		
		this.value=mData.value;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		base.toCopy(data);
		
		if(!(data is TriggerStringData))
			return;
		
		TriggerStringData mData=(TriggerStringData)data;
		
		this.value=mData.value;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		if(!base.toDataEquals(data))
			return false;
		
		TriggerStringData mData=(TriggerStringData)data;
		if(this.value!=mData.value)
			return false;
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("value");
		writer.sb.Append(':');
		writer.sb.Append(this.value);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		base.initDefault();
		
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.value="";
	}
	
}