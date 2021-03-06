package com.home.commonBase.config.game;
import com.home.commonBase.config.base.BaseConfig;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.support.collection.IntObjectMap;

/** 技能读条表(generated by shine) */
public class SkillBarConfig extends BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<SkillBarConfig> _dic;
	
	/** 读条id */
	public int id;
	
	/** 读条类型 */
	public int type;
	
	/** 动作id */
	public int motionID;
	
	/** 读条时间(ms) */
	public int time;
	
	/** 获取 */
	public static SkillBarConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/** 设置字典 */
	public static void setDic(IntObjectMap<SkillBarConfig> dic)
	{
		_dic=dic;
	}
	
	/** 获取全部 */
	public static IntObjectMap<SkillBarConfig> getDic()
	{
		return _dic;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.type=stream.readInt();
		
		this.motionID=stream.readInt();
		
		this.time=stream.readInt();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.type);
		
		stream.writeInt(this.motionID);
		
		stream.writeInt(this.time);
		
	}
	
	/** 读完所有表后处理 */
	public static void afterReadConfigAll()
	{
		
	}
	
}
