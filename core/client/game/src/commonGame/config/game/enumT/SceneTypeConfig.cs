using ShineEngine;

/// <summary>
/// 场景类型(generated by shine)
/// </summary>
public class SceneTypeConfig:BaseConfig
{
	/** 存储集合 */
	private static SceneTypeConfig[] _dic;
	
	/// <summary>
	/// id
	/// </summary>
	public int id;
	
	/// <summary>
	/// 是否需要场景角色
	/// </summary>
	public bool needRole;
	
	/// <summary>
	/// 场景实例类型
	/// </summary>
	public int instanceType;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static SceneTypeConfig get(int id)
	{
		return id>=0 && id<_dic.Length ? _dic[id] : null;
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(SceneTypeConfig[] dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(SceneTypeConfig[] dic)
	{
		ObjectUtils.arrayPutAll(_dic,dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static SceneTypeConfig[] getDic()
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
		
		this.instanceType=stream.readInt();
		
		this.needRole=stream.readBoolean();
		
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
		
		stream.writeInt(this.instanceType);
		
		stream.writeBoolean(this.needRole);
		
	}
	
}