using ShineEngine;

/// <summary>
/// 界面逻辑体表(generated by shine)
/// </summary>
public class UILogicConfig:BaseConfig
{
	/** 存储集合 */
	private static UILogicConfig[] _dic;
	
	/// <summary>
	/// 名字
	/// </summary>
	public string name;
	
	/// <summary>
	/// 是否跟随父项显示
	/// </summary>
	public bool isFollowParentShow;
	
	/// <summary>
	/// 逻辑id
	/// </summary>
	public int id;
	
	/// <summary>
	/// 包名
	/// </summary>
	public string packageName;
	
	/// <summary>
	/// 资源名(资源转)
	/// </summary>
	public int resourceNameT;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static UILogicConfig get(int id)
	{
		return id>=0 && id<_dic.Length ? _dic[id] : null;
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(UILogicConfig[] dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(UILogicConfig[] dic)
	{
		ObjectUtils.arrayPutAll(_dic,dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static UILogicConfig[] getDic()
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
		
		this.name=stream.readUTF();
		
		this.isFollowParentShow=stream.readBoolean();
		
		this.packageName=stream.readUTF();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeUTF(this.name);
		
		stream.writeBoolean(this.isFollowParentShow);
		
		stream.writeUTF(this.packageName);
		
	}
	
	protected override void afterReadConfig()
	{
		resourceNameT=BaseGameUtils.getUIModelResourceID(name + "UILogic",false);
	}
	
	/// <summary>
	/// 读完所有表后处理
	/// </summary>
	public static void afterReadConfigAll()
	{
		
	}
	
}