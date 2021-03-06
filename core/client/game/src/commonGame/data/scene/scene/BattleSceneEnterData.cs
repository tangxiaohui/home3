using ShineEngine;

/// <summary>
/// 副本类场景进入数据(generated by shine)
/// </summary>
public class BattleSceneEnterData:SceneEnterData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.BattleSceneEnter;
	
	/// <summary>
	/// 副本当前状态
	/// </summary>
	public int state;
	
	/// <summary>
	/// 剩余tick时间(ms)(-1就是没在tick)
	/// </summary>
	public int timeTick;
	
	public BattleSceneEnterData()
	{
		_dataID=BaseDataType.BattleSceneEnter;
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.state=stream.readInt();
		
		this.timeTick=stream.readInt();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.state);
		
		stream.writeInt(this.timeTick);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		base.toShadowCopy(data);
		
		if(!(data is BattleSceneEnterData))
			return;
		
		BattleSceneEnterData mData=(BattleSceneEnterData)data;
		
		this.state=mData.state;
		this.timeTick=mData.timeTick;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		base.toCopy(data);
		
		if(!(data is BattleSceneEnterData))
			return;
		
		BattleSceneEnterData mData=(BattleSceneEnterData)data;
		
		this.state=mData.state;
		
		this.timeTick=mData.timeTick;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		if(!base.toDataEquals(data))
			return false;
		
		BattleSceneEnterData mData=(BattleSceneEnterData)data;
		if(this.state!=mData.state)
			return false;
		
		if(this.timeTick!=mData.timeTick)
			return false;
		
		return true;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "BattleSceneEnterData";
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("state");
		writer.sb.Append(':');
		writer.sb.Append(this.state);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("timeTick");
		writer.sb.Append(':');
		writer.sb.Append(this.timeTick);
		
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
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.state=stream.readInt();
		
		this.timeTick=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.state);
		
		stream.writeInt(this.timeTick);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.state=0;
		this.timeTick=0;
	}
	
}
