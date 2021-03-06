using ShineEngine;

/// <summary>
/// 角色简版外显数据(聊天等使用)(generated by shine)
/// </summary>
public class RoleSimpleShowData:BaseData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.RoleSimpleShow;
	
	/// <summary>
	/// 角色ID
	/// </summary>
	public long playerID;
	
	/// <summary>
	/// 创建区服
	/// </summary>
	public int createAreaID;
	
	/// <summary>
	/// 名字
	/// </summary>
	public string name;
	
	/// <summary>
	/// 性别
	/// </summary>
	public int sex;
	
	/// <summary>
	/// 职业
	/// </summary>
	public int vocation;
	
	public RoleSimpleShowData()
	{
		_dataID=BaseDataType.RoleSimpleShow;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "RoleSimpleShowData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.playerID=stream.readLong();
		
		this.createAreaID=stream.readInt();
		
		this.name=stream.readUTF();
		
		this.sex=stream.readInt();
		
		this.vocation=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeLong(this.playerID);
		
		stream.writeInt(this.createAreaID);
		
		stream.writeUTF(this.name);
		
		stream.writeInt(this.sex);
		
		stream.writeInt(this.vocation);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		this.playerID=stream.readLong();
		
		this.createAreaID=stream.readInt();
		
		this.name=stream.readUTF();
		
		this.sex=stream.readInt();
		
		this.vocation=stream.readInt();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeLong(this.playerID);
		
		stream.writeInt(this.createAreaID);
		
		stream.writeUTF(this.name);
		
		stream.writeInt(this.sex);
		
		stream.writeInt(this.vocation);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is RoleSimpleShowData))
			return;
		
		RoleSimpleShowData mData=(RoleSimpleShowData)data;
		
		this.playerID=mData.playerID;
		this.createAreaID=mData.createAreaID;
		this.name=mData.name;
		this.sex=mData.sex;
		this.vocation=mData.vocation;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is RoleSimpleShowData))
			return;
		
		RoleSimpleShowData mData=(RoleSimpleShowData)data;
		
		this.playerID=mData.playerID;
		
		this.createAreaID=mData.createAreaID;
		
		this.name=mData.name;
		
		this.sex=mData.sex;
		
		this.vocation=mData.vocation;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		RoleSimpleShowData mData=(RoleSimpleShowData)data;
		if(this.playerID!=mData.playerID)
			return false;
		
		if(this.createAreaID!=mData.createAreaID)
			return false;
		
		if(this.name!=mData.name)
			return false;
		
		if(this.sex!=mData.sex)
			return false;
		
		if(this.vocation!=mData.vocation)
			return false;
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.Append("playerID");
		writer.sb.Append(':');
		writer.sb.Append(this.playerID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("createAreaID");
		writer.sb.Append(':');
		writer.sb.Append(this.createAreaID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("name");
		writer.sb.Append(':');
		writer.sb.Append(this.name);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("sex");
		writer.sb.Append(':');
		writer.sb.Append(this.sex);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("vocation");
		writer.sb.Append(':');
		writer.sb.Append(this.vocation);
		
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
		this.playerID=0L;
		this.createAreaID=0;
		this.name="";
		this.sex=0;
		this.vocation=0;
	}
	
}
