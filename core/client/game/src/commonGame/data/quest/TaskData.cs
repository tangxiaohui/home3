using ShineEngine;

/// <summary>
/// 任务目标数据(extends)(generated by shine)
/// </summary>
public class TaskData:BaseData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.Task;
	
	/// <summary>
	/// 实例ID
	/// </summary>
	public int instanceID;
	
	/// <summary>
	/// 目标id
	/// </summary>
	public int id;
	
	/// <summary>
	/// 完成数
	/// </summary>
	public int num;
	
	/// <summary>
	/// 配置
	/// </summary>
	public TaskConfig config;
	
	/// <summary>
	/// 功能ID
	/// </summary>
	public int funcID;
	
	/// <summary>
	/// 主ID
	/// </summary>
	public int mainID;
	
	public TaskData()
	{
		_dataID=BaseDataType.Task;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "TaskData";
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		this.instanceID=stream.readInt();
		
		this.id=stream.readInt();
		
		this.num=stream.readInt();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.instanceID);
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.num);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is TaskData))
			return;
		
		TaskData mData=(TaskData)data;
		
		this.instanceID=mData.instanceID;
		this.id=mData.id;
		this.num=mData.num;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is TaskData))
			return;
		
		TaskData mData=(TaskData)data;
		
		this.instanceID=mData.instanceID;
		
		this.id=mData.id;
		
		this.num=mData.num;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		TaskData mData=(TaskData)data;
		if(this.instanceID!=mData.instanceID)
			return false;
		
		if(this.id!=mData.id)
			return false;
		
		if(this.num!=mData.num)
			return false;
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.Append("instanceID");
		writer.sb.Append(':');
		writer.sb.Append(this.instanceID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("id");
		writer.sb.Append(':');
		writer.sb.Append(this.id);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("num");
		writer.sb.Append(':');
		writer.sb.Append(this.num);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		
	}
	
	public void reloadConfig()
	{
		config=TaskConfig.get(id);
	}
	
	public bool isComplete()
	{
		return num>=config.needNum;
	}
	
	/// <summary>
	/// 是否完成
	/// </summary>
	public override void clear()
	{
		num=0;
		config=null;
		funcID=0;
		mainID=0;
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.instanceID=stream.readInt();
		
		this.id=stream.readInt();
		
		this.num=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.instanceID);
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.num);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		this.instanceID=0;
		this.id=0;
		this.num=0;
	}
	
}
