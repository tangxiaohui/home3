package com.home.commonBase.config.game;
import com.home.commonBase.config.base.BaseConfig;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.support.collection.IntObjectMap;
import com.home.shine.tool.SectionTool;

/** 区服负载值(generated by shine) */
public class AreaLoadConfig extends BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<AreaLoadConfig> _dic;
	
	/** 大值 */
	public int max;
	
	/** 小值 */
	public int min;
	
	/** id */
	public int id;
	
	private static SectionTool<AreaLoadConfig> _sTool;
	
	/** 获取 */
	public static AreaLoadConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/** 设置字典 */
	public static void setDic(IntObjectMap<AreaLoadConfig> dic)
	{
		_dic=dic;
	}
	
	/** 获取全部 */
	public static IntObjectMap<AreaLoadConfig> getDic()
	{
		return _dic;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.min=stream.readInt();
		
		this.max=stream.readInt();
		
	}
	
	/** 读完所有表后处理 */
	public static void afterReadConfigAll()
	{
		_sTool=new SectionTool<>();
		
		_dic.forEach((k,v) ->
		{
			_sTool.put(v.min,v.max,v);
		});
		
		_sTool.make();
	}
	
	/** 获取load值 */
	public static int getLoad(int value)
	{
		return _sTool.get(value).id;
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.min);
		
		stream.writeInt(this.max);
		
	}
	
}