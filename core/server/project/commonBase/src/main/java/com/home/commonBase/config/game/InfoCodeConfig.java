package com.home.commonBase.config.game;
import com.home.commonBase.config.base.BaseConfig;
import com.home.commonBase.config.game.LanguageConfig;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.support.collection.IntObjectMap;
import com.home.shine.support.collection.SMap;

/** 信息码类型表(generated by shine) */
public class InfoCodeConfig extends BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<InfoCodeConfig> _dic;
	
	/** 信息id */
	public int id;
	
	/** 文字 */
	public String text="";
	
	/** 文字原值 */
	private String _text;
	
	/** 获取 */
	public static InfoCodeConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/** 设置字典 */
	public static void setDic(IntObjectMap<InfoCodeConfig> dic)
	{
		_dic=dic;
	}
	
	/** 获取全部 */
	public static IntObjectMap<InfoCodeConfig> getDic()
	{
		return _dic;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.text=stream.readUTF();
		
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
		
		stream.writeUTF(this.text);
		
	}
	
	/** 生成刷新配置 */
	@Override
	protected void generateRefresh()
	{
		if(_text==null)
			_text=text;
		text=LanguageConfig.getText(_text);
		
	}
	
}
