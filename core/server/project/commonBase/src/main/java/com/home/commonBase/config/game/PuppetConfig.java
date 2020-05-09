package com.home.commonBase.config.game;
import com.home.commonBase.config.base.BaseConfig;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.support.collection.IntObjectMap;
import com.home.shine.support.collection.SMap;

/** 傀儡表(generated by shine) */
public class PuppetConfig extends BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<PuppetConfig> _dic;
	
	/** 战斗单位ID */
	public int fightUnitID;
	
	/** id */
	public int id;
	
	/** AI行为方式 */
	public int aiType;
	
	/** 是否独立攻击者 */
	public boolean isIndependentAttacker;
	
	/** 是否客户端驱动 */
	public boolean isClientDrive;
	
	/** 获取 */
	public static PuppetConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/** 设置字典 */
	public static void setDic(IntObjectMap<PuppetConfig> dic)
	{
		_dic=dic;
	}
	
	/** 获取全部 */
	public static IntObjectMap<PuppetConfig> getDic()
	{
		return _dic;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.fightUnitID=stream.readInt();
		
		this.aiType=stream.readInt();
		
		this.isClientDrive=stream.readBoolean();
		
		this.isIndependentAttacker=stream.readBoolean();
		
	}
	
	/** 读完所有表后处理 */
	public static void afterReadConfigAll()
	{
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.fightUnitID);
		
		stream.writeInt(this.aiType);
		
		stream.writeBoolean(this.isClientDrive);
		
		stream.writeBoolean(this.isIndependentAttacker);
		
	}
	
}