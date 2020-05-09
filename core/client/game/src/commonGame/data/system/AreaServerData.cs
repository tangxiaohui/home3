using ShineEngine;

/// <summary>
/// 区服服务器数据(generated by shine)
/// </summary>
public class AreaServerData:BaseData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.AreaServer;
	
	/// <summary>
	/// 区服ID
	/// </summary>
	public int areaID;
	
	/// <summary>
	/// 负载值
	/// </summary>
	public int load;
	
	/// <summary>
	/// 区服名
	/// </summary>
	public string name;
	
	/// <summary>
	/// 是否限制注册
	/// </summary>
	public bool isLimitRegist;
	
	public AreaServerData()
	{
		_dataID=BaseDataType.AreaServer;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "AreaServerData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.areaID=stream.readInt();
		
		this.load=stream.readInt();
		
		this.isLimitRegist=stream.readBoolean();
		
		this.name=stream.readUTF();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.areaID);
		
		stream.writeInt(this.load);
		
		stream.writeBoolean(this.isLimitRegist);
		
		stream.writeUTF(this.name);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		this.areaID=stream.readInt();
		
		this.load=stream.readInt();
		
		this.isLimitRegist=stream.readBoolean();
		
		this.name=stream.readUTF();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.areaID);
		
		stream.writeInt(this.load);
		
		stream.writeBoolean(this.isLimitRegist);
		
		stream.writeUTF(this.name);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is AreaServerData))
			return;
		
		AreaServerData mData=(AreaServerData)data;
		
		this.areaID=mData.areaID;
		this.load=mData.load;
		this.isLimitRegist=mData.isLimitRegist;
		this.name=mData.name;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is AreaServerData))
			return;
		
		AreaServerData mData=(AreaServerData)data;
		
		this.areaID=mData.areaID;
		
		this.load=mData.load;
		
		this.isLimitRegist=mData.isLimitRegist;
		
		this.name=mData.name;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		AreaServerData mData=(AreaServerData)data;
		if(this.areaID!=mData.areaID)
			return false;
		
		if(this.load!=mData.load)
			return false;
		
		if(this.isLimitRegist!=mData.isLimitRegist)
			return false;
		
		if(this.name!=mData.name)
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
		writer.sb.Append("load");
		writer.sb.Append(':');
		writer.sb.Append(this.load);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("isLimitRegist");
		writer.sb.Append(':');
		writer.sb.Append(this.isLimitRegist);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("name");
		writer.sb.Append(':');
		writer.sb.Append(this.name);
		
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
		this.areaID=0;
		this.load=0;
		this.isLimitRegist=false;
		this.name="";
	}
	
}