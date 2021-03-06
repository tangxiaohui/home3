package com.home.commonBase.config.game;
import com.home.commonBase.config.base.BaseConfig;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.dataEx.TimeExpression;
import com.home.shine.support.collection.IntObjectMap;

/** 激活码表(generated by shine) */
public class ActivationCodeConfig extends BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<ActivationCodeConfig> _dic;
	
	/** id */
	public int id;
	
	/** 可使用人次 */
	public int useNum;
	
	/** 失效时间 */
	public String disableTime="";
	
	/** 描述 */
	public String describe="";
	
	/** 奖励id */
	public int reward;
	
	/** 失效时间(时间表达式) */
	public TimeExpression disableTimeT;
	
	/** 获取 */
	public static ActivationCodeConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/** 设置字典 */
	public static void setDic(IntObjectMap<ActivationCodeConfig> dic)
	{
		_dic=dic;
	}
	
	/** 获取全部 */
	public static IntObjectMap<ActivationCodeConfig> getDic()
	{
		return _dic;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.useNum=stream.readInt();
		
		this.disableTime=stream.readUTF();
		
		this.reward=stream.readInt();
		
		this.describe=stream.readUTF();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.useNum);
		
		stream.writeUTF(this.disableTime);
		
		stream.writeInt(this.reward);
		
		stream.writeUTF(this.describe);
		
	}
	
	/** 生成刷新配置 */
	@Override
	protected void generateRefresh()
	{
		disableTimeT=new TimeExpression(disableTime);
		
	}
	
	/** 读完所有表后处理 */
	public static void afterReadConfigAll()
	{
		
	}
	
}
