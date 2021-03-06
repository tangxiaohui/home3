using ShineEngine;

/// <summary>
/// 场景表(generated by shine)
/// </summary>
public class SceneConfig:BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<SceneConfig> _dic;
	
	/// <summary>
	/// id
	/// </summary>
	public int id;
	
	/// <summary>
	/// 名字
	/// </summary>
	public string name;
	
	/// <summary>
	/// 所属副本ID
	/// </summary>
	public int battleID;
	
	/// <summary>
	/// 类型
	/// </summary>
	public int type;
	
	/// <summary>
	/// 实例类型
	/// </summary>
	public int instanceType;
	
	/// <summary>
	/// 是否上线继续进入
	/// </summary>
	public bool isLoginEnter;
	
	/// <summary>
	/// 场景切入策略
	/// </summary>
	public int switchType;
	
	/// <summary>
	/// 默认进入位置
	/// </summary>
	public int defaultEnterPos;
	
	/// <summary>
	/// 触发器组ID
	/// </summary>
	public int triggerID;
	
	/// <summary>
	/// 所属地图id
	/// </summary>
	public int mapID;
	
	/// <summary>
	/// 进入位置组
	/// </summary>
	public int[] enterPosList;
	
	/// <summary>
	/// 进入条件
	/// </summary>
	public int[][] enterConditions;
	
	/** 名字原值 */
	private string _name;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static SceneConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(IntObjectMap<SceneConfig> dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(IntObjectMap<SceneConfig> dic)
	{
		_dic.putAll(dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static IntObjectMap<SceneConfig> getDic()
	{
		return _dic;
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.name=stream.readUTF();
		
		this.battleID=stream.readInt();
		
		int enterConditionsLen=stream.readLen();
		if(this.enterConditions==null || this.enterConditions.Length!=enterConditionsLen)
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
		
		this.switchType=stream.readInt();
		
		int enterPosListLen=stream.readLen();
		if(this.enterPosList==null || this.enterPosList.Length!=enterPosListLen)
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
	
	/// <summary>
	/// 读完所有表后处理
	/// </summary>
	public static void afterReadConfigAll()
	{
		foreach(SceneConfig v in _dic)
		{
			v.instanceType=SceneType.getInstanceType(v.type);
		}
	}
	
	/// <summary>
	/// 生成刷新配置
	/// </summary>
	protected override void generateRefresh()
	{
		if(_name==null)
			_name=name;
		name=LanguageConfig.getText(_name);
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeUTF(this.name);
		
		stream.writeInt(this.battleID);
		
		if(this.enterConditions!=null)
		{
			int[][] enterConditionsT=this.enterConditions;
			stream.writeLen(enterConditionsT.Length);
			for(int enterConditionsVI=0,enterConditionsVLen=enterConditionsT.Length;enterConditionsVI<enterConditionsVLen;++enterConditionsVI)
			{
				int[] enterConditionsV=enterConditionsT[enterConditionsVI];
				if(enterConditionsV!=null)
				{
					int[] enterConditionsVT=enterConditionsV;
					stream.writeLen(enterConditionsVT.Length);
					for(int enterConditionsVVI=0,enterConditionsVVLen=enterConditionsVT.Length;enterConditionsVVI<enterConditionsVVLen;++enterConditionsVVI)
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
		
		stream.writeInt(this.switchType);
		
		if(this.enterPosList!=null)
		{
			int[] enterPosListT=this.enterPosList;
			stream.writeLen(enterPosListT.Length);
			for(int enterPosListVI=0,enterPosListVLen=enterPosListT.Length;enterPosListVI<enterPosListVLen;++enterPosListVI)
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
	
}
