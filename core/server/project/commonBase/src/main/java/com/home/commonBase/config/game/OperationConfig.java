package com.home.commonBase.config.game;
import com.home.commonBase.config.base.BaseConfig;
import com.home.commonBase.config.game.LanguageConfig;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.support.collection.IntObjectMap;

/** 操作体表(generated by shine) */
public class OperationConfig extends BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<OperationConfig> _dic;
	
	/** id */
	public int id;
	
	/** 名字 */
	public String name="";
	
	/** 是否一次性 */
	public boolean isOnce;
	
	/** 可操作半径 */
	public float radius;
	
	/** 操作动作 */
	public int[][] operateActions;
	
	/** 操作条件 */
	public int[][] operateConditions;
	
	/** 名字原值 */
	private String _name;
	
	/** 获取 */
	public static OperationConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/** 设置字典 */
	public static void setDic(IntObjectMap<OperationConfig> dic)
	{
		_dic=dic;
	}
	
	/** 获取全部 */
	public static IntObjectMap<OperationConfig> getDic()
	{
		return _dic;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.name=stream.readUTF();
		
		int operateConditionsLen=stream.readLen();
		if(this.operateConditions==null || this.operateConditions.length!=operateConditionsLen)
		{
			this.operateConditions=new int[operateConditionsLen][];
		}
		int[][] operateConditionsT=this.operateConditions;
		for(int operateConditionsI=0;operateConditionsI<operateConditionsLen;++operateConditionsI)
		{
			int[] operateConditionsV;
			int operateConditionsVLen=stream.readLen();
			operateConditionsV=new int[operateConditionsVLen];
			int[] operateConditionsVT=operateConditionsV;
			for(int operateConditionsVI=0;operateConditionsVI<operateConditionsVLen;++operateConditionsVI)
			{
				int operateConditionsVV;
				operateConditionsVV=stream.readInt();
				
				operateConditionsVT[operateConditionsVI]=operateConditionsVV;
			}
			
			operateConditionsT[operateConditionsI]=operateConditionsV;
		}
		
		int operateActionsLen=stream.readLen();
		if(this.operateActions==null || this.operateActions.length!=operateActionsLen)
		{
			this.operateActions=new int[operateActionsLen][];
		}
		int[][] operateActionsT=this.operateActions;
		for(int operateActionsI=0;operateActionsI<operateActionsLen;++operateActionsI)
		{
			int[] operateActionsV;
			int operateActionsVLen=stream.readLen();
			operateActionsV=new int[operateActionsVLen];
			int[] operateActionsVT=operateActionsV;
			for(int operateActionsVI=0;operateActionsVI<operateActionsVLen;++operateActionsVI)
			{
				int operateActionsVV;
				operateActionsVV=stream.readInt();
				
				operateActionsVT[operateActionsVI]=operateActionsVV;
			}
			
			operateActionsT[operateActionsI]=operateActionsV;
		}
		
		this.radius=stream.readFloat();
		
		this.isOnce=stream.readBoolean();
		
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
		
		stream.writeUTF(this.name);
		
		if(this.operateConditions!=null)
		{
			int[][] operateConditionsT=this.operateConditions;
			stream.writeLen(operateConditionsT.length);
			for(int operateConditionsVI=0,operateConditionsVLen=operateConditionsT.length;operateConditionsVI<operateConditionsVLen;++operateConditionsVI)
			{
				int[] operateConditionsV=operateConditionsT[operateConditionsVI];
				if(operateConditionsV!=null)
				{
					int[] operateConditionsVT=operateConditionsV;
					stream.writeLen(operateConditionsVT.length);
					for(int operateConditionsVVI=0,operateConditionsVVLen=operateConditionsVT.length;operateConditionsVVI<operateConditionsVVLen;++operateConditionsVVI)
					{
						int operateConditionsVV=operateConditionsVT[operateConditionsVVI];
						stream.writeInt(operateConditionsVV);
						
					}
				}
				else
				{
					nullObjError("operateConditionsV");
				}
				
			}
		}
		else
		{
			nullObjError("operateConditions");
		}
		
		if(this.operateActions!=null)
		{
			int[][] operateActionsT=this.operateActions;
			stream.writeLen(operateActionsT.length);
			for(int operateActionsVI=0,operateActionsVLen=operateActionsT.length;operateActionsVI<operateActionsVLen;++operateActionsVI)
			{
				int[] operateActionsV=operateActionsT[operateActionsVI];
				if(operateActionsV!=null)
				{
					int[] operateActionsVT=operateActionsV;
					stream.writeLen(operateActionsVT.length);
					for(int operateActionsVVI=0,operateActionsVVLen=operateActionsVT.length;operateActionsVVI<operateActionsVVLen;++operateActionsVVI)
					{
						int operateActionsVV=operateActionsVT[operateActionsVVI];
						stream.writeInt(operateActionsVV);
						
					}
				}
				else
				{
					nullObjError("operateActionsV");
				}
				
			}
		}
		else
		{
			nullObjError("operateActions");
		}
		
		stream.writeFloat(this.radius);
		
		stream.writeBoolean(this.isOnce);
		
	}
	
	/** 生成刷新配置 */
	@Override
	protected void generateRefresh()
	{
		if(_name==null)
			_name=name;
		name=LanguageConfig.getText(_name);
		
	}
	
}