package com.home.commonBase.config.game;
import com.home.commonBase.config.base.BaseConfig;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.DIntData;
import com.home.shine.support.collection.LongObjectMap;
import com.home.shine.support.collection.SMap;

/** 子弹等级表(generated by shine) */
public class BulletLevelConfig extends BaseConfig
{
	/** 存储集合 */
	private static LongObjectMap<BulletLevelConfig> _dic;
	
	/** 子弹id */
	public int id;
	
	/** 投掷类型 */
	public int castType;
	
	/** 投掷参数 */
	public float[] castArgs;
	
	/** 每个目标影响次数 */
	public int eachHitNum;
	
	/** 最大影响目标数 */
	public int maxInfluenceNum;
	
	/** 等级 */
	public int level;
	
	/** 获取 */
	public static BulletLevelConfig get(int id,int level)
	{
		return _dic.get((long)id << 16 | (long)level);
	}
	
	/** 设置字典 */
	public static void setDic(LongObjectMap<BulletLevelConfig> dic)
	{
		_dic=dic;
	}
	
	/** 获取全部 */
	public static LongObjectMap<BulletLevelConfig> getDic()
	{
		return _dic;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.level=stream.readShort();
		
		this.castType=stream.readInt();
		
		int castArgsLen=stream.readLen();
		if(this.castArgs==null || this.castArgs.length!=castArgsLen)
		{
			this.castArgs=new float[castArgsLen];
		}
		float[] castArgsT=this.castArgs;
		for(int castArgsI=0;castArgsI<castArgsLen;++castArgsI)
		{
			float castArgsV;
			castArgsV=stream.readFloat();
			
			castArgsT[castArgsI]=castArgsV;
		}
		
		this.eachHitNum=stream.readInt();
		
		this.maxInfluenceNum=stream.readInt();
		
	}
	
	/** 读完所有表后处理 */
	public static void afterReadConfigAll()
	{
		
	}
	
	/** 获取 */
	public static BulletLevelConfig get(int id,short level)
	{
		return _dic.get((long)id << 16 | (long)level);
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeShort(this.level);
		
		stream.writeInt(this.castType);
		
		if(this.castArgs!=null)
		{
			float[] castArgsT=this.castArgs;
			stream.writeLen(castArgsT.length);
			for(int castArgsVI=0,castArgsVLen=castArgsT.length;castArgsVI<castArgsVLen;++castArgsVI)
			{
				float castArgsV=castArgsT[castArgsVI];
				stream.writeFloat(castArgsV);
				
			}
		}
		else
		{
			nullObjError("castArgs");
		}
		
		stream.writeInt(this.eachHitNum);
		
		stream.writeInt(this.maxInfluenceNum);
		
	}
	
}
