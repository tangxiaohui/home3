package com.home.commonBase.config.game;
import com.home.commonBase.config.base.BaseConfig;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;

/** 聊天频道表(generated by shine) */
public class ChatChannelConfig extends BaseConfig
{
	/** 存储集合 */
	private static ChatChannelConfig[] _dic;
	
	/** id */
	public int id;
	
	/** 发言cd(ms) */
	public int cd;
	
	/** 使用条件 */
	public int[][] useConditions;
	
	/** 是否为多实例 */
	public boolean isMulti;
	
	/** 是否可离线接收 */
	public boolean offlineReceive;
	
	/** 保留数目 */
	public int keepNum;
	
	/** 保留时间(小时) */
	public int keepHour;
	
	/** 发言开销 */
	public int costID;
	
	/** 获取 */
	public static ChatChannelConfig get(int id)
	{
		return id>=0 && id<_dic.length ? _dic[id] : null;
	}
	
	/** 设置字典 */
	public static void setDic(ChatChannelConfig[] dic)
	{
		_dic=dic;
	}
	
	/** 获取全部 */
	public static ChatChannelConfig[] getDic()
	{
		return _dic;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.cd=stream.readInt();
		
		int useConditionsLen=stream.readLen();
		if(this.useConditions==null || this.useConditions.length!=useConditionsLen)
		{
			this.useConditions=new int[useConditionsLen][];
		}
		int[][] useConditionsT=this.useConditions;
		for(int useConditionsI=0;useConditionsI<useConditionsLen;++useConditionsI)
		{
			int[] useConditionsV;
			int useConditionsVLen=stream.readLen();
			useConditionsV=new int[useConditionsVLen];
			int[] useConditionsVT=useConditionsV;
			for(int useConditionsVI=0;useConditionsVI<useConditionsVLen;++useConditionsVI)
			{
				int useConditionsVV;
				useConditionsVV=stream.readInt();
				
				useConditionsVT[useConditionsVI]=useConditionsVV;
			}
			
			useConditionsT[useConditionsI]=useConditionsV;
		}
		
		this.costID=stream.readInt();
		
		this.keepHour=stream.readInt();
		
		this.keepNum=stream.readInt();
		
		this.offlineReceive=stream.readBoolean();
		
		this.isMulti=stream.readBoolean();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.cd);
		
		if(this.useConditions!=null)
		{
			int[][] useConditionsT=this.useConditions;
			stream.writeLen(useConditionsT.length);
			for(int useConditionsVI=0,useConditionsVLen=useConditionsT.length;useConditionsVI<useConditionsVLen;++useConditionsVI)
			{
				int[] useConditionsV=useConditionsT[useConditionsVI];
				if(useConditionsV!=null)
				{
					int[] useConditionsVT=useConditionsV;
					stream.writeLen(useConditionsVT.length);
					for(int useConditionsVVI=0,useConditionsVVLen=useConditionsVT.length;useConditionsVVI<useConditionsVVLen;++useConditionsVVI)
					{
						int useConditionsVV=useConditionsVT[useConditionsVVI];
						stream.writeInt(useConditionsVV);
						
					}
				}
				else
				{
					nullObjError("useConditionsV");
				}
				
			}
		}
		else
		{
			nullObjError("useConditions");
		}
		
		stream.writeInt(this.costID);
		
		stream.writeInt(this.keepHour);
		
		stream.writeInt(this.keepNum);
		
		stream.writeBoolean(this.offlineReceive);
		
		stream.writeBoolean(this.isMulti);
		
	}
	
	/** 读完所有表后处理 */
	public static void afterReadConfigAll()
	{
		
	}
	
}
