using ShineEngine;

/// <summary>
/// 单位通用数据(generated by shine)
/// </summary>
public class UnitNormalData:BaseData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.UnitNormal;
	
	/// <summary>
	/// 归属角色
	/// </summary>
	public long belongPlayerID=-1L;
	
	public UnitNormalData()
	{
		_dataID=BaseDataType.UnitNormal;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "UnitNormalData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.belongPlayerID=stream.readLong();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeLong(this.belongPlayerID);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		this.belongPlayerID=stream.readLong();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeLong(this.belongPlayerID);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is UnitNormalData))
			return;
		
		UnitNormalData mData=(UnitNormalData)data;
		
		this.belongPlayerID=mData.belongPlayerID;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is UnitNormalData))
			return;
		
		UnitNormalData mData=(UnitNormalData)data;
		
		this.belongPlayerID=mData.belongPlayerID;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		UnitNormalData mData=(UnitNormalData)data;
		if(this.belongPlayerID!=mData.belongPlayerID)
			return false;
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.Append("belongPlayerID");
		writer.sb.Append(':');
		writer.sb.Append(this.belongPlayerID);
		
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
		this.belongPlayerID=0L;
	}
	
}