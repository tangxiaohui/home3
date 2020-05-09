using ShineEngine;

/// <summary>
/// 拍卖行表(generated by shine)
/// </summary>
public class AuctionConfig:BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<AuctionConfig> _dic;
	
	/// <summary>
	/// id
	/// </summary>
	public int id;
	
	/// <summary>
	/// 每个玩家可上架数目
	/// </summary>
	public int maxSaleNum;
	
	/// <summary>
	/// 每页显示数目
	/// </summary>
	public int eachPageShowNum;
	
	/// <summary>
	/// 上架保留时间(天)
	/// </summary>
	public int keepDay;
	
	/// <summary>
	/// 最近判定时间(s)
	/// </summary>
	public int recentlyTime;
	
	/// <summary>
	/// 手续费比率(千分位)
	/// </summary>
	public int commissionRatio;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static AuctionConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(IntObjectMap<AuctionConfig> dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(IntObjectMap<AuctionConfig> dic)
	{
		_dic.putAll(dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static IntObjectMap<AuctionConfig> getDic()
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
		
		this.maxSaleNum=stream.readInt();
		
		this.eachPageShowNum=stream.readInt();
		
		this.keepDay=stream.readInt();
		
		this.commissionRatio=stream.readInt();
		
		this.recentlyTime=stream.readInt();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.maxSaleNum);
		
		stream.writeInt(this.eachPageShowNum);
		
		stream.writeInt(this.keepDay);
		
		stream.writeInt(this.commissionRatio);
		
		stream.writeInt(this.recentlyTime);
		
	}
	
	/// <summary>
	/// 读完所有表后处理
	/// </summary>
	public static void afterReadConfigAll()
	{
		
	}
	
}