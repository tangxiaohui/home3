package com.home.commonBase.config.game;
import com.home.commonBase.config.base.BaseConfig;
import com.home.commonBase.constlist.generate.LanguageType;
import com.home.commonBase.global.CommonSetting;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.ctrl.Ctrl;
import com.home.shine.support.collection.SMap;

/** 国际化表(generated by shine) */
public class LanguageConfig extends BaseConfig
{
	/** 存储集合 */
	private static SMap<String,LanguageConfig> _dic;
	
	/** 美国英语 */
	public String en_US="";
	
	/** 简体中文 */
	public String zh_CN="";
	
	/** 键 */
	public String key="";
	
	/** 获取全部 */
	public static SMap<String,LanguageConfig> getDic()
	{
		return _dic;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.key=stream.readUTF();
		
		this.zh_CN=stream.readUTF();
		
		this.en_US=stream.readUTF();
		
	}
	
	/** 读完所有表后处理 */
	public static void afterReadConfigAll()
	{
		
	}
	
	protected String getStr(int type)
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
	
	/** 获取文字 */
	public static String getText(String key)
	{
		if(key.isEmpty())
			return key;
		
		LanguageConfig config;
		String re;
		
		if((config=get(key))!=null && (re=config.getStr(CommonSetting.languageType))!=null)
			return re;
		
		if(CommonSetting.useMultiLanguage)
		{
			Ctrl.throwError("找不到LanguageConfig",key);
		}
		
		return key;
	}
	
	/** 获取 */
	public static LanguageConfig get(String key)
	{
		return _dic.get(key);
	}
	
	/** 设置字典 */
	public static void setDic(SMap<String,LanguageConfig> dic)
	{
		_dic=dic;
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeUTF(this.key);
		
		stream.writeUTF(this.zh_CN);
		
		stream.writeUTF(this.en_US);
		
	}
	
}
