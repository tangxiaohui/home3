using ShineEngine;

/// <summary>
/// 傀儡单位身份数据(generated by shine)
/// </summary>
public class PuppetIdentityData:FightUnitIdentityData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.PuppetIdentity;
	
	/// <summary>
	/// 控制者实例ID
	/// </summary>
	public int masterInstanceID;
	
	/// <summary>
	/// 剩余时间
	/// </summary>
	public int lastTime;
	
	public PuppetIdentityData()
	{
		_dataID=BaseDataType.PuppetIdentity;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "PuppetIdentityData";
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.masterInstanceID=stream.readInt();
		
		this.lastTime=stream.readInt();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.masterInstanceID);
		
		stream.writeInt(this.lastTime);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		base.toShadowCopy(data);
		
		if(!(data is PuppetIdentityData))
			return;
		
		PuppetIdentityData mData=(PuppetIdentityData)data;
		
		this.masterInstanceID=mData.masterInstanceID;
		this.lastTime=mData.lastTime;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		base.toCopy(data);
		
		if(!(data is PuppetIdentityData))
			return;
		
		PuppetIdentityData mData=(PuppetIdentityData)data;
		
		this.masterInstanceID=mData.masterInstanceID;
		
		this.lastTime=mData.lastTime;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		if(!base.toDataEquals(data))
			return false;
		
		PuppetIdentityData mData=(PuppetIdentityData)data;
		if(this.masterInstanceID!=mData.masterInstanceID)
			return false;
		
		if(this.lastTime!=mData.lastTime)
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
		writer.sb.Append("masterInstanceID");
		writer.sb.Append(':');
		writer.sb.Append(this.masterInstanceID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("lastTime");
		writer.sb.Append(':');
		writer.sb.Append(this.lastTime);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		base.initDefault();
		
	}
	
	public override int getFightUnitID()
	{
		return PuppetConfig.get(id).fightUnitID;
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.masterInstanceID=stream.readInt();
		
		this.lastTime=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.masterInstanceID);
		
		stream.writeInt(this.lastTime);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.masterInstanceID=0;
		this.lastTime=0;
	}
	
}
