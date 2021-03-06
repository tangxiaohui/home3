using ShineEngine;

/// <summary>
/// 货币表(generated by shine)
/// </summary>
public class CurrencyConfig:BaseConfig
{
	/** 存储集合 */
	private static CurrencyConfig[] _dic;
	
	/// <summary>
	/// id
	/// </summary>
	public int id;
	
	/// <summary>
	/// 说明
	/// </summary>
	public string explain;
	
	/// <summary>
	/// 关联物品ID
	/// </summary>
	public int bindItemID;
	
	/// <summary>
	/// 是否需要记录累计获得的货币
	/// </summary>
	public bool needAddRecord;
	
	/// <summary>
	/// 是否可在addAbs时突破上限
	/// </summary>
	public bool canOverMaxByAbs;
	
	/// <summary>
	/// 图标
	/// </summary>
	public string icon;
	
	/// <summary>
	/// 图标(资源转)
	/// </summary>
	public int iconT;
	
	/** 说明原值 */
	private string _explain;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static CurrencyConfig get(int id)
	{
		return id>=0 && id<_dic.Length ? _dic[id] : null;
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(CurrencyConfig[] dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(CurrencyConfig[] dic)
	{
		ObjectUtils.arrayPutAll(_dic,dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static CurrencyConfig[] getDic()
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
		
		this.explain=stream.readUTF();
		
		this.bindItemID=stream.readInt();
		
		this.icon=stream.readUTF();
		
		this.needAddRecord=stream.readBoolean();
		
		this.canOverMaxByAbs=stream.readBoolean();
		
	}
	
	/// <summary>
	/// 读完所有表后处理
	/// </summary>
	public static void afterReadConfigAll()
	{
		
	}
	
	/// <summary>
	/// 生成刷新配置
	/// </summary>
	protected override void generateRefresh()
	{
		if(_explain==null)
			_explain=explain;
		explain=LanguageConfig.getText(_explain);
		
		iconT=LoadControl.getResourceIDByName(icon);
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeUTF(this.explain);
		
		stream.writeInt(this.bindItemID);
		
		stream.writeUTF(this.icon);
		
		stream.writeBoolean(this.needAddRecord);
		
		stream.writeBoolean(this.canOverMaxByAbs);
		
	}
	
}
