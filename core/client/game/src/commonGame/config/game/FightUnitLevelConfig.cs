using ShineEngine;

/// <summary>
/// 战斗单位等级表(generated by shine)
/// </summary>
public class FightUnitLevelConfig:BaseConfig
{
	/** 存储集合 */
	private static LongObjectMap<FightUnitLevelConfig> _dic;
	
	/// <summary>
	/// id
	/// </summary>
	public int id;
	
	/// <summary>
	/// 等级
	/// </summary>
	public int level;
	
	/// <summary>
	/// 属性组
	/// </summary>
	public DIntData[] attributes;
	
	/// <summary>
	/// 技能组
	/// </summary>
	public DIntData[] skills;
	
	/// <summary>
	/// buff组
	/// </summary>
	public DIntData[] buffs;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static FightUnitLevelConfig get(int id,int level)
	{
		return _dic.get((long)id << 16 | (long)level);
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(LongObjectMap<FightUnitLevelConfig> dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(LongObjectMap<FightUnitLevelConfig> dic)
	{
		_dic.putAll(dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static LongObjectMap<FightUnitLevelConfig> getDic()
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
		
		this.level=stream.readShort();
		
		int attributesLen=stream.readLen();
		if(this.attributes==null || this.attributes.Length!=attributesLen)
		{
			this.attributes=new DIntData[attributesLen];
		}
		DIntData[] attributesT=this.attributes;
		for(int attributesI=0;attributesI<attributesLen;++attributesI)
		{
			DIntData attributesV;
			attributesV=(DIntData)stream.createData(DIntData.dataID);
			attributesV.readBytesSimple(stream);
			
			attributesT[attributesI]=attributesV;
		}
		
		int skillsLen=stream.readLen();
		if(this.skills==null || this.skills.Length!=skillsLen)
		{
			this.skills=new DIntData[skillsLen];
		}
		DIntData[] skillsT=this.skills;
		for(int skillsI=0;skillsI<skillsLen;++skillsI)
		{
			DIntData skillsV;
			skillsV=(DIntData)stream.createData(DIntData.dataID);
			skillsV.readBytesSimple(stream);
			
			skillsT[skillsI]=skillsV;
		}
		
		int buffsLen=stream.readLen();
		if(this.buffs==null || this.buffs.Length!=buffsLen)
		{
			this.buffs=new DIntData[buffsLen];
		}
		DIntData[] buffsT=this.buffs;
		for(int buffsI=0;buffsI<buffsLen;++buffsI)
		{
			DIntData buffsV;
			buffsV=(DIntData)stream.createData(DIntData.dataID);
			buffsV.readBytesSimple(stream);
			
			buffsT[buffsI]=buffsV;
		}
		
	}
	
	/// <summary>
	/// 读完所有表后处理
	/// </summary>
	public static void afterReadConfigAll()
	{
		FightUnitConfig fConfig;

		FightUnitLevelConfig[] values;
		FightUnitLevelConfig v;

		for(int i=(values=_dic.getValues()).Length-1;i>=0;--i)
		{
			if((v=values[i])!=null)
			{
				if((fConfig=FightUnitConfig.get(v.id)).levelMax<v.level)
					fConfig.levelMax=v.level;
			}
		}
	}
	
	/// <summary>
	/// 获取
	/// </summary>
	public static FightUnitLevelConfig get(int id,short level)
	{
		return _dic.get((long)id << 16 | (long)level);
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeShort(this.level);
		
		if(this.attributes!=null)
		{
			DIntData[] attributesT=this.attributes;
			stream.writeLen(attributesT.Length);
			for(int attributesVI=0,attributesVLen=attributesT.Length;attributesVI<attributesVLen;++attributesVI)
			{
				DIntData attributesV=attributesT[attributesVI];
				if(attributesV!=null)
				{
					attributesV.writeBytesSimple(stream);
				}
				else
				{
					nullObjError("attributesV");
				}
				
			}
		}
		else
		{
			nullObjError("attributes");
		}
		
		if(this.skills!=null)
		{
			DIntData[] skillsT=this.skills;
			stream.writeLen(skillsT.Length);
			for(int skillsVI=0,skillsVLen=skillsT.Length;skillsVI<skillsVLen;++skillsVI)
			{
				DIntData skillsV=skillsT[skillsVI];
				if(skillsV!=null)
				{
					skillsV.writeBytesSimple(stream);
				}
				else
				{
					nullObjError("skillsV");
				}
				
			}
		}
		else
		{
			nullObjError("skills");
		}
		
		if(this.buffs!=null)
		{
			DIntData[] buffsT=this.buffs;
			stream.writeLen(buffsT.Length);
			for(int buffsVI=0,buffsVLen=buffsT.Length;buffsVI<buffsVLen;++buffsVI)
			{
				DIntData buffsV=buffsT[buffsVI];
				if(buffsV!=null)
				{
					buffsV.writeBytesSimple(stream);
				}
				else
				{
					nullObjError("buffsV");
				}
				
			}
		}
		else
		{
			nullObjError("buffs");
		}
		
	}
	
}