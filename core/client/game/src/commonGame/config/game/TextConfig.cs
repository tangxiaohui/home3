using ShineEngine;

/// <summary>
/// 文本表(程序用)(需国际化)(generated by shine)
/// </summary>
public class TextConfig:BaseConfig
{
	/** 存储集合 */
	private static SMap<string,TextConfig> _dic;
	
	/// <summary>
	/// 美国英语
	/// </summary>
	public string en_US;
	
	/// <summary>
	/// 简体中文
	/// </summary>
	public string zh_CN;
	
	/// <summary>
	/// 键
	/// </summary>
	public string key;
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static SMap<string,TextConfig> getDic()
	{
		return _dic;
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.key=stream.readUTF();
		
		this.zh_CN=stream.readUTF();
		
		this.en_US=stream.readUTF();
		
	}
	
	/// <summary>
	/// 读完所有表后处理
	/// </summary>
	public static void afterReadConfigAll()
	{
		
	}
	
	protected virtual string getStr(int type)
	{
		switch(type)
		{
			case LanguageType.Zh_CN:
				return zh_CN;
			case LanguageType.En_US:
				return en_US;
		}

		return null;
	}
	
	public static string getText(string key)
	{
		TextConfig config;
		string re;

		if((config=get(key))!=null && (re=config.getStr(CommonSetting.languageType))!=null)
			return re;

		Ctrl.throwError("找不到TextConfig",key);

		return key;
	}
	
	/// <summary>
	/// 获取
	/// </summary>
	public static TextConfig get(string key)
	{
		return _dic.get(key);
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(SMap<string,TextConfig> dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(SMap<string,TextConfig> dic)
	{
		_dic.putAll(dic);
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeUTF(this.key);
		
		stream.writeUTF(this.zh_CN);
		
		stream.writeUTF(this.en_US);
		
	}
	
}