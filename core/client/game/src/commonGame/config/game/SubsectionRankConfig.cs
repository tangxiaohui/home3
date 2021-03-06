using ShineEngine;

/// <summary>
/// 分段排行表(generated by shine)
/// </summary>
public class SubsectionRankConfig:BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<SubsectionRankConfig> _dic;
	
	/// <summary>
	/// 是否需要翻页插件
	/// </summary>
	public bool needPageTool;
	
	/// <summary>
	/// 每页显示人数
	/// </summary>
	public int eachPageShowNum;
	
	/// <summary>
	/// 功能id
	/// </summary>
	public int id;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static SubsectionRankConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(IntObjectMap<SubsectionRankConfig> dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(IntObjectMap<SubsectionRankConfig> dic)
	{
		_dic.putAll(dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static IntObjectMap<SubsectionRankConfig> getDic()
	{
		return _dic;
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.id=stream.readShort();
		
		this.needPageTool=stream.readBoolean();
		
		this.eachPageShowNum=stream.readInt();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeShort(this.id);
		
		stream.writeBoolean(this.needPageTool);
		
		stream.writeInt(this.eachPageShowNum);
		
	}
	
	/// <summary>
	/// 读完所有表后处理
	/// </summary>
	public static void afterReadConfigAll()
	{
		
	}
	
}
