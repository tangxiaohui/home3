using ShineEngine;

/// <summary>
/// 冷却数据(generated by shine)
/// </summary>
public class CDData:BaseData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.CD;
	
	/// <summary>
	/// id
	/// </summary>
	public int id;
	
	/// <summary>
	/// 时间上限
	/// </summary>
	public int timeMax;
	
	/// <summary>
	/// 经过时间
	/// </summary>
	public int timePass;
	
	/// <summary>
	/// 配置
	/// </summary>
	public CDConfig config;
	
	public CDData()
	{
		_dataID=BaseDataType.CD;
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		this.id=stream.readInt();
		
		this.timePass=stream.readInt();
		
		this.timeMax=stream.readInt();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.id);
		
		stream.writeInt(this.timePass);
		
		stream.writeInt(this.timeMax);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is CDData))
			return;
		
		CDData mData=(CDData)data;
		
		this.id=mData.id;
		this.timePass=mData.timePass;
		this.timeMax=mData.timeMax;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is CDData))
			return;
		
		CDData mData=(CDData)data;
		
		this.id=mData.id;
		
		this.timePass=mData.timePass;
		
		this.timeMax=mData.timeMax;
		
	}
	
	public int getLastTime()
	{
		int re=timeMax - timePass;
		return re<0 ? 0 : re;
	}
	
	public static CDData create(int timeMax)
	{
		CDData re=new CDData();
		re.timeMax=timeMax;
		return re;
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		CDData mData=(CDData)data;
		if(this.id!=mData.id)
			return false;
		
		if(this.timePass!=mData.timePass)
			return false;
		
		if(this.timeMax!=mData.timeMax)
			return false;
		
		return true;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "CDData";
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.Append("id");
		writer.sb.Append(':');
		writer.sb.Append(this.id);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("timePass");
		writer.sb.Append(':');
		writer.sb.Append(this.timePass);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("timeMax");
		writer.sb.Append(':');
		writer.sb.Append(this.timeMax);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		
	}
	
	public override void clear()
	{
		config=null;
	}
	
	public void reloadConfig()
	{
		config=CDConfig.get(id);
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.id=stream.readInt();
		
		this.timePass=stream.readInt();
		
		this.timeMax=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.timePass);
		
		stream.writeInt(this.timeMax);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		this.id=0;
		this.timePass=0;
		this.timeMax=0;
	}
	
}
