package com.home.commonBase.config.game;
import com.home.commonBase.config.base.BaseConfig;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.support.collection.IntObjectMap;
import com.home.shine.support.collection.SMap;

/** 技能变量表(generated by shine) */
public class SkillVarConfig extends BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<SkillVarConfig> _dic;
	
	/** 公式类型 */
	public int formulaType;
	
	/** 公式参数 */
	public int[][] args;
	
	/** 变量id */
	public int id;
	
	/** 获取 */
	public static SkillVarConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/** 设置字典 */
	public static void setDic(IntObjectMap<SkillVarConfig> dic)
	{
		_dic=dic;
	}
	
	/** 获取全部 */
	public static IntObjectMap<SkillVarConfig> getDic()
	{
		return _dic;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.formulaType=stream.readInt();
		
		int argsLen=stream.readLen();
		if(this.args==null || this.args.length!=argsLen)
		{
			this.args=new int[argsLen][];
		}
		int[][] argsT=this.args;
		for(int argsI=0;argsI<argsLen;++argsI)
		{
			int[] argsV;
			int argsVLen=stream.readLen();
			argsV=new int[argsVLen];
			int[] argsVT=argsV;
			for(int argsVI=0;argsVI<argsVLen;++argsVI)
			{
				int argsVV;
				argsVV=stream.readInt();
				
				argsVT[argsVI]=argsVV;
			}
			
			argsT[argsI]=argsV;
		}
		
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
		
		stream.writeInt(this.formulaType);
		
		if(this.args!=null)
		{
			int[][] argsT=this.args;
			stream.writeLen(argsT.length);
			for(int argsVI=0,argsVLen=argsT.length;argsVI<argsVLen;++argsVI)
			{
				int[] argsV=argsT[argsVI];
				if(argsV!=null)
				{
					int[] argsVT=argsV;
					stream.writeLen(argsVT.length);
					for(int argsVVI=0,argsVVLen=argsVT.length;argsVVI<argsVVLen;++argsVVI)
					{
						int argsVV=argsVT[argsVVI];
						stream.writeInt(argsVV);
						
					}
				}
				else
				{
					nullObjError("argsV");
				}
				
			}
		}
		else
		{
			nullObjError("args");
		}
		
	}
	
}
