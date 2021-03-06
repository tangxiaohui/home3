using ShineEngine;

/// <summary>
/// 区服客户端数据(generated by shine)
/// </summary>
public class AreaClientData:BaseData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.AreaClient;
	
	/// <summary>
	/// 游戏服ID
	/// </summary>
	public int areaID;
	
	/// <summary>
	/// 名字
	/// </summary>
	public string name;
	
	/// <summary>
	/// 存在标记
	/// </summary>
	public bool mark;
	
	/// <summary>
	/// 负载值
	/// </summary>
	public int load=0;
	
	public AreaClientData()
	{
		_dataID=BaseDataType.AreaClient;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "AreaClientData";
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		this.areaID=stream.readInt();
		
		this.name=stream.readUTF();
		
		this.load=stream.readInt();
		
		this.mark=stream.readBoolean();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.areaID);
		
		stream.writeUTF(this.name);
		
		stream.writeInt(this.load);
		
		stream.writeBoolean(this.mark);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is AreaClientData))
			return;
		
		AreaClientData mData=(AreaClientData)data;
		
		this.areaID=mData.areaID;
		this.name=mData.name;
		this.load=mData.load;
		this.mark=mData.mark;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is AreaClientData))
			return;
		
		AreaClientData mData=(AreaClientData)data;
		
		this.areaID=mData.areaID;
		
		this.name=mData.name;
		
		this.load=mData.load;
		
		this.mark=mData.mark;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		AreaClientData mData=(AreaClientData)data;
		if(this.areaID!=mData.areaID)
			return false;
		
		if(this.name!=mData.name)
			return false;
		
		if(this.load!=mData.load)
			return false;
		
		if(this.mark!=mData.mark)
			return false;
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.Append("areaID");
		writer.sb.Append(':');
		writer.sb.Append(this.areaID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("name");
		writer.sb.Append(':');
		writer.sb.Append(this.name);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("load");
		writer.sb.Append(':');
		writer.sb.Append(this.load);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("mark");
		writer.sb.Append(':');
		writer.sb.Append(this.mark);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.areaID=stream.readInt();
		
		this.name=stream.readUTF();
		
		this.load=stream.readInt();
		
		this.mark=stream.readBoolean();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.areaID);
		
		stream.writeUTF(this.name);
		
		stream.writeInt(this.load);
		
		stream.writeBoolean(this.mark);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		this.areaID=0;
		this.name="";
		this.load=0;
		this.mark=false;
	}
	
}
