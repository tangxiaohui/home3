using ShineEngine;

/// <summary>
/// 宠物存库数据(generated by shine)
/// </summary>
public class PetSaveData:MUnitSaveData
{
	/// <summary>
	/// 宠物经验
	/// </summary>
	public long exp;
	
	/// <summary>
	/// 宠物等级
	/// </summary>
	public int level;
	
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.PetSave;
	
	/// <summary>
	/// 是否出战中
	/// </summary>
	public bool isWorking;
	
	public PetSaveData()
	{
		_dataID=BaseDataType.PetSave;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "PetSaveData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.level=stream.readInt();
		
		this.exp=stream.readLong();
		
		this.isWorking=stream.readBoolean();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.level);
		
		stream.writeLong(this.exp);
		
		stream.writeBoolean(this.isWorking);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.level=stream.readInt();
		
		this.exp=stream.readLong();
		
		this.isWorking=stream.readBoolean();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.level);
		
		stream.writeLong(this.exp);
		
		stream.writeBoolean(this.isWorking);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		base.toShadowCopy(data);
		
		if(!(data is PetSaveData))
			return;
		
		PetSaveData mData=(PetSaveData)data;
		
		this.level=mData.level;
		this.exp=mData.exp;
		this.isWorking=mData.isWorking;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		base.toCopy(data);
		
		if(!(data is PetSaveData))
			return;
		
		PetSaveData mData=(PetSaveData)data;
		
		this.level=mData.level;
		
		this.exp=mData.exp;
		
		this.isWorking=mData.isWorking;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		if(!base.toDataEquals(data))
			return false;
		
		PetSaveData mData=(PetSaveData)data;
		if(this.level!=mData.level)
			return false;
		
		if(this.exp!=mData.exp)
			return false;
		
		if(this.isWorking!=mData.isWorking)
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
		writer.sb.Append("level");
		writer.sb.Append(':');
		writer.sb.Append(this.level);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("exp");
		writer.sb.Append(':');
		writer.sb.Append(this.exp);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("isWorking");
		writer.sb.Append(':');
		writer.sb.Append(this.isWorking);
		
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
		
		this.level=0;
		this.exp=0L;
		this.isWorking=false;
	}
	
}