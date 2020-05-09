using ShineEngine;

/// <summary>
/// bullet表(generated by shine)
/// </summary>
public class BulletConfig:BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<BulletConfig> _dic;
	
	/// <summary>
	/// 子弹ID
	/// </summary>
	public int id;
	
	/// <summary>
	/// 名字
	/// </summary>
	public string name;
	
	/// <summary>
	/// 攻击ID
	/// </summary>
	public int attackID;
	
	/// <summary>
	/// 是否记录数值
	/// </summary>
	public bool needRecordValue;
	
	/// <summary>
	/// 达到最大影响目标后是否保留
	/// </summary>
	public bool keepAtMaxHit;
	
	/// <summary>
	/// 最大有效距离
	/// </summary>
	public float maxEnableDistance;
	
	/// <summary>
	/// 打击间隔(ms)
	/// </summary>
	public int hitDelay;
	
	/// <summary>
	/// 发射偏移(x,y)
	/// </summary>
	public float[] castOff;
	
	/// <summary>
	/// 释放点类型
	/// </summary>
	public int castPoint;
	
	/// <summary>
	/// 特效
	/// </summary>
	public int effectID;
	
	/// <summary>
	/// 是否不可被吸收
	/// </summary>
	public bool cantAbsorb;
	
	/** 名字原值 */
	private string _name;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static BulletConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(IntObjectMap<BulletConfig> dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(IntObjectMap<BulletConfig> dic)
	{
		_dic.putAll(dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static IntObjectMap<BulletConfig> getDic()
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
		
		this.attackID=stream.readInt();
		
		this.maxEnableDistance=stream.readFloat();
		
		this.needRecordValue=stream.readBoolean();
		
		this.keepAtMaxHit=stream.readBoolean();
		
		this.cantAbsorb=stream.readBoolean();
		
		this.hitDelay=stream.readInt();
		
		int castOffLen=stream.readLen();
		if(this.castOff==null || this.castOff.Length!=castOffLen)
		{
			this.castOff=new float[castOffLen];
		}
		float[] castOffT=this.castOff;
		for(int castOffI=0;castOffI<castOffLen;++castOffI)
		{
			float castOffV;
			castOffV=stream.readFloat();
			
			castOffT[castOffI]=castOffV;
		}
		
		this.castPoint=stream.readInt();
		
		this.effectID=stream.readInt();
		
	}
	
	/// <summary>
	/// 读完所有表后处理
	/// </summary>
	public static void afterReadConfigAll()
	{
		
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
		
		stream.writeInt(this.attackID);
		
		stream.writeFloat(this.maxEnableDistance);
		
		stream.writeBoolean(this.needRecordValue);
		
		stream.writeBoolean(this.keepAtMaxHit);
		
		stream.writeBoolean(this.cantAbsorb);
		
		stream.writeInt(this.hitDelay);
		
		if(this.castOff!=null)
		{
			float[] castOffT=this.castOff;
			stream.writeLen(castOffT.Length);
			for(int castOffVI=0,castOffVLen=castOffT.Length;castOffVI<castOffVLen;++castOffVI)
			{
				float castOffV=castOffT[castOffVI];
				stream.writeFloat(castOffV);
				
			}
		}
		else
		{
			nullObjError("castOff");
		}
		
		stream.writeInt(this.castPoint);
		
		stream.writeInt(this.effectID);
		
	}
	
}