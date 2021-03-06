package com.home.commonBase.config.game;
import com.home.commonBase.config.base.BaseConfig;
import com.home.commonBase.config.game.LanguageConfig;
import com.home.commonBase.constlist.generate.SceneType;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.support.collection.IntObjectMap;

/** 场景表(generated by shine) */
public class SceneConfig extends BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<SceneConfig> _dic;
	
	/** id */
	public int id;
	
	/** 名字 */
	public String name="";
	
	/** 所属副本ID */
	public int battleID;
	
	/** 类型 */
	public int type;
	
	/** 实例类型 */
	public int instanceType;
	
	/** 是否上线继续进入 */
	public boolean isLoginEnter;
	
	/** 默认进入位置 */
	public int defaultEnterPos;
	
	/** 触发器组ID */
	public int triggerID;
	
	/** 所属地图id */
	public int mapID;
	
	/** 进入位置组 */
	public int[] enterPosList;
	
	/** 进入条件 */
	public int[][] enterConditions;
	
	/** 名字原值 */
	private String _name;
	
	/** 获取 */
	public static SceneConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/** 设置字典 */
	public static void setDic(IntObjectMap<SceneConfig> dic)
	{
		_dic=dic;
	}
	
	/** 获取全部 */
	public static IntObjectMap<SceneConfig> getDic()
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
		
		this.battleID=stream.readInt();
		
		int enterConditionsLen=stream.readLen();
		if(this.enterConditions==null || this.enterConditions.length!=enterConditionsLen)
		{
			this.enterConditions=new int[enterConditionsLen][];
		}
		int[][] enterConditionsT=this.enterConditions;
		for(int enterConditionsI=0;enterConditionsI<enterConditionsLen;++enterConditionsI)
		{
			int[] enterConditionsV;
			int enterConditionsVLen=stream.readLen();
			enterConditionsV=new int[enterConditionsVLen];
			int[] enterConditionsVT=enterConditionsV;
			for(int enterConditionsVI=0;enterConditionsVI<enterConditionsVLen;++enterConditionsVI)
			{
				int enterConditionsVV;
				enterConditionsVV=stream.readInt();
				
				enterConditionsVT[enterConditionsVI]=enterConditionsVV;
			}
			
			enterConditionsT[enterConditionsI]=enterConditionsV;
		}
		
		this.type=stream.readInt();
		
		this.isLoginEnter=stream.readBoolean();
		
		int enterPosListLen=stream.readLen();
		if(this.enterPosList==null || this.enterPosList.length!=enterPosListLen)
		{
			this.enterPosList=new int[enterPosListLen];
		}
		int[] enterPosListT=this.enterPosList;
		for(int enterPosListI=0;enterPosListI<enterPosListLen;++enterPosListI)
		{
			int enterPosListV;
			enterPosListV=stream.readInt();
			
			enterPosListT[enterPosListI]=enterPosListV;
		}
		
		this.defaultEnterPos=stream.readInt();
		
		this.triggerID=stream.readInt();
		
		this.mapID=stream.readInt();
		
	}
	
	/** 读完所有表后处理 */
	public static void afterReadConfigAll()
	{
		_dic.forEachValue(v->
		{
			v.instanceType=SceneType.getInstanceType(v.type);
		});
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeUTF(this.name);
		
		stream.writeInt(this.battleID);
		
		if(this.enterConditions!=null)
		{
			int[][] enterConditionsT=this.enterConditions;
			stream.writeLen(enterConditionsT.length);
			for(int enterConditionsVI=0,enterConditionsVLen=enterConditionsT.length;enterConditionsVI<enterConditionsVLen;++enterConditionsVI)
			{
				int[] enterConditionsV=enterConditionsT[enterConditionsVI];
				if(enterConditionsV!=null)
				{
					int[] enterConditionsVT=enterConditionsV;
					stream.writeLen(enterConditionsVT.length);
					for(int enterConditionsVVI=0,enterConditionsVVLen=enterConditionsVT.length;enterConditionsVVI<enterConditionsVVLen;++enterConditionsVVI)
					{
						int enterConditionsVV=enterConditionsVT[enterConditionsVVI];
						stream.writeInt(enterConditionsVV);
						
					}
				}
				else
				{
					nullObjError("enterConditionsV");
				}
				
			}
		}
		else
		{
			nullObjError("enterConditions");
		}
		
		stream.writeInt(this.type);
		
		stream.writeBoolean(this.isLoginEnter);
		
		if(this.enterPosList!=null)
		{
			int[] enterPosListT=this.enterPosList;
			stream.writeLen(enterPosListT.length);
			for(int enterPosListVI=0,enterPosListVLen=enterPosListT.length;enterPosListVI<enterPosListVLen;++enterPosListVI)
			{
				int enterPosListV=enterPosListT[enterPosListVI];
				stream.writeInt(enterPosListV);
				
			}
		}
		else
		{
			nullObjError("enterPosList");
		}
		
		stream.writeInt(this.defaultEnterPos);
		
		stream.writeInt(this.triggerID);
		
		stream.writeInt(this.mapID);
		
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
