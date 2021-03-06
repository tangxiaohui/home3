using ShineEngine;

/// <summary>
/// 信息日志表(generated by shine)
/// </summary>
public class InfoLogConfig:BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<InfoLogConfig> _dic;
	
	/// <summary>
	/// 信息id
	/// </summary>
	public int id;
	
	/// <summary>
	/// 文字
	/// </summary>
	public string text;
	
	/** 文字原值 */
	private string _text;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static InfoLogConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(IntObjectMap<InfoLogConfig> dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(IntObjectMap<InfoLogConfig> dic)
	{
		_dic.putAll(dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static IntObjectMap<InfoLogConfig> getDic()
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
		
		this.text=stream.readUTF();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeUTF(this.text);
		
	}
	
	/// <summary>
	/// 生成刷新配置
	/// </summary>
	protected override void generateRefresh()
	{
		if(_text==null)
			_text=text;
		text=LanguageConfig.getText(_text);
		
	}
	
	/// <summary>
	/// 读完所有表后处理
	/// </summary>
	public static void afterReadConfigAll()
	{
		
	}
	
}
