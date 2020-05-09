using ShineEngine;

/// <summary>
/// 计数数据(generated by shine)
/// </summary>
public class CountData:BaseData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.Count;
	
	/// <summary>
	/// 数目
	/// </summary>
	public int num;
	
	/// <summary>
	/// 总数
	/// </summary>
	public long total;
	
	public CountData()
	{
		_dataID=BaseDataType.Count;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "CountData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.num=stream.readInt();
		
		this.total=stream.readLong();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.num);
		
		stream.writeLong(this.total);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		this.num=stream.readInt();
		
		this.total=stream.readLong();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.num);
		
		stream.writeLong(this.total);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is CountData))
			return;
		
		CountData mData=(CountData)data;
		
		this.num=mData.num;
		this.total=mData.total;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is CountData))
			return;
		
		CountData mData=(CountData)data;
		
		this.num=mData.num;
		
		this.total=mData.total;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		CountData mData=(CountData)data;
		if(this.num!=mData.num)
			return false;
		
		if(this.total!=mData.total)
			return false;
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.Append("num");
		writer.sb.Append(':');
		writer.sb.Append(this.num);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("total");
		writer.sb.Append(':');
		writer.sb.Append(this.total);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		this.num=0;
		this.total=0L;
	}
	
}