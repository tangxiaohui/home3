using ShineEngine;

/// <summary>
/// 任务目标类型(generated by shine)
/// </summary>
public class TaskTypeConfig:BaseConfig
{
	/** 存储集合 */
	private static TaskTypeConfig[] _dic;
	
	/// <summary>
	/// id
	/// </summary>
	public int id;
	
	/// <summary>
	/// 是否客户端驱动
	/// </summary>
	public bool isClientDrive;
	
	/// <summary>
	/// 是否需要自定义数据结构
	/// </summary>
	public bool needCustomTask;
	
	/// <summary>
	/// 是否需要二号第二索引
	/// </summary>
	public bool needSecondKey2;
	
	/// <summary>
	/// 是否需要第二索引
	/// </summary>
	public bool needSecondKey;
	
	/// <summary>
	/// 是否刷新式目标
	/// </summary>
	public bool needUpdate;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static TaskTypeConfig get(int id)
	{
		return id>=0 && id<_dic.Length ? _dic[id] : null;
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(TaskTypeConfig[] dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(TaskTypeConfig[] dic)
	{
		ObjectUtils.arrayPutAll(_dic,dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static TaskTypeConfig[] getDic()
	{
		return _dic;
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.isClientDrive=stream.readBoolean();
		
		this.needUpdate=stream.readBoolean();
		
		this.needSecondKey=stream.readBoolean();
		
		this.needSecondKey2=stream.readBoolean();
		
		this.needCustomTask=stream.readBoolean();
		
	}
	
	/// <summary>
	/// 读完所有表后处理
	/// </summary>
	public static void afterReadConfigAll()
	{
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeBoolean(this.isClientDrive);
		
		stream.writeBoolean(this.needUpdate);
		
		stream.writeBoolean(this.needSecondKey);
		
		stream.writeBoolean(this.needSecondKey2);
		
		stream.writeBoolean(this.needCustomTask);
		
	}
	
}