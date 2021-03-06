using ShineEngine;

/// <summary>
/// 单位身份数据(generated by shine)
/// </summary>
public class UnitIdentityData:BaseData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.UnitIdentity;
	
	/// <summary>
	/// 归属角色ID(角色的归属就是自身角色ID)(没有归属就是-1)
	/// </summary>
	public long playerID=-1L;
	
	/// <summary>
	/// 所属势力(playerID为-1时有意义)
	/// </summary>
	public int force=0;
	
	/// <summary>
	/// 类型(见UnitType)
	/// </summary>
	public int type;
	
	public UnitIdentityData()
	{
		_dataID=BaseDataType.UnitIdentity;
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		this.type=stream.readInt();
		
		this.playerID=stream.readLong();
		
		this.force=stream.readInt();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.type);
		
		stream.writeLong(this.playerID);
		
		stream.writeInt(this.force);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is UnitIdentityData))
			return;
		
		UnitIdentityData mData=(UnitIdentityData)data;
		
		this.type=mData.type;
		this.playerID=mData.playerID;
		this.force=mData.force;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is UnitIdentityData))
			return;
		
		UnitIdentityData mData=(UnitIdentityData)data;
		
		this.type=mData.type;
		
		this.playerID=mData.playerID;
		
		this.force=mData.force;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		UnitIdentityData mData=(UnitIdentityData)data;
		if(this.type!=mData.type)
			return false;
		
		if(this.playerID!=mData.playerID)
			return false;
		
		if(this.force!=mData.force)
			return false;
		
		return true;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "UnitIdentityData";
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.Append("type");
		writer.sb.Append(':');
		writer.sb.Append(this.type);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("playerID");
		writer.sb.Append(':');
		writer.sb.Append(this.playerID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("force");
		writer.sb.Append(':');
		writer.sb.Append(this.force);
		
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
		
		this.type=stream.readInt();
		
		this.playerID=stream.readLong();
		
		this.force=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.type);
		
		stream.writeLong(this.playerID);
		
		stream.writeInt(this.force);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		this.type=0;
		this.playerID=0L;
		this.force=0;
	}
	
}
