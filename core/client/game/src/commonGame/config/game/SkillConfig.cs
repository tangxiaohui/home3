using ShineEngine;

/// <summary>
/// 技能表(generated by shine)
/// </summary>
public class SkillConfig:BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<SkillConfig> _dic;
	
	/// <summary>
	/// 技能id
	/// </summary>
	public int id;
	
	/// <summary>
	/// 技能描述
	/// </summary>
	public string explain;
	
	/// <summary>
	/// 名字
	/// </summary>
	public string name;
	
	/// <summary>
	/// 等级上限
	/// </summary>
	public int levelMax;
	
	/// <summary>
	/// 释放方式
	/// </summary>
	public int useType;
	
	/// <summary>
	/// 是否可移动施法
	/// </summary>
	public bool canMove;
	
	/// <summary>
	/// 攻击方式
	/// </summary>
	public int attackType;
	
	/// <summary>
	/// 目标类型
	/// </summary>
	public int targetType;
	
	/// <summary>
	/// 所属组号
	/// </summary>
	public int[] groups;
	
	/// <summary>
	/// 所在冷却组
	/// </summary>
	public int[] underGroupCDs;
	
	/// <summary>
	/// 限制释放冷却组ID
	/// </summary>
	public int inGroupCD;
	
	/// <summary>
	/// 可强制技能组
	/// </summary>
	public int[] canCancelSkillGroups;
	
	/// <summary>
	/// 目标影响类型
	/// </summary>
	public int[] influenceType;
	
	/// <summary>
	/// 影响类型(转)
	/// </summary>
	public bool[] influenceTypeT;
	
	/// <summary>
	/// AI使用优先级
	/// </summary>
	public int aiPriority;
	
	/// <summary>
	/// 释放条件组
	/// </summary>
	public int[][] useConditions;
	
	/// <summary>
	/// 图标
	/// </summary>
	public string icon;
	
	/// <summary>
	/// 图标(资源转)
	/// </summary>
	public int iconT;
	
	/** 名字原值 */
	private string _name;
	
	/** 技能描述原值 */
	private string _explain;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static SkillConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(IntObjectMap<SkillConfig> dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(IntObjectMap<SkillConfig> dic)
	{
		_dic.putAll(dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static IntObjectMap<SkillConfig> getDic()
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
		
		this.explain=stream.readUTF();
		
		this.levelMax=stream.readInt();
		
		this.useType=stream.readInt();
		
		this.attackType=stream.readInt();
		
		this.canMove=stream.readBoolean();
		
		this.targetType=stream.readInt();
		
		int influenceTypeLen=stream.readLen();
		if(this.influenceType==null || this.influenceType.Length!=influenceTypeLen)
		{
			this.influenceType=new int[influenceTypeLen];
		}
		int[] influenceTypeT=this.influenceType;
		for(int influenceTypeI=0;influenceTypeI<influenceTypeLen;++influenceTypeI)
		{
			int influenceTypeV;
			influenceTypeV=stream.readInt();
			
			influenceTypeT[influenceTypeI]=influenceTypeV;
		}
		
		int groupsLen=stream.readLen();
		if(this.groups==null || this.groups.Length!=groupsLen)
		{
			this.groups=new int[groupsLen];
		}
		int[] groupsT=this.groups;
		for(int groupsI=0;groupsI<groupsLen;++groupsI)
		{
			int groupsV;
			groupsV=stream.readInt();
			
			groupsT[groupsI]=groupsV;
		}
		
		int underGroupCDsLen=stream.readLen();
		if(this.underGroupCDs==null || this.underGroupCDs.Length!=underGroupCDsLen)
		{
			this.underGroupCDs=new int[underGroupCDsLen];
		}
		int[] underGroupCDsT=this.underGroupCDs;
		for(int underGroupCDsI=0;underGroupCDsI<underGroupCDsLen;++underGroupCDsI)
		{
			int underGroupCDsV;
			underGroupCDsV=stream.readInt();
			
			underGroupCDsT[underGroupCDsI]=underGroupCDsV;
		}
		
		this.inGroupCD=stream.readInt();
		
		int canCancelSkillGroupsLen=stream.readLen();
		if(this.canCancelSkillGroups==null || this.canCancelSkillGroups.Length!=canCancelSkillGroupsLen)
		{
			this.canCancelSkillGroups=new int[canCancelSkillGroupsLen];
		}
		int[] canCancelSkillGroupsT=this.canCancelSkillGroups;
		for(int canCancelSkillGroupsI=0;canCancelSkillGroupsI<canCancelSkillGroupsLen;++canCancelSkillGroupsI)
		{
			int canCancelSkillGroupsV;
			canCancelSkillGroupsV=stream.readInt();
			
			canCancelSkillGroupsT[canCancelSkillGroupsI]=canCancelSkillGroupsV;
		}
		
		this.aiPriority=stream.readInt();
		
		int useConditionsLen=stream.readLen();
		if(this.useConditions==null || this.useConditions.Length!=useConditionsLen)
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
		
		this.icon=stream.readUTF();
		
	}
	
	/// <summary>
	/// 读完表后处理
	/// </summary>
	protected override void afterReadConfig()
	{
		base.afterReadConfig();

		influenceTypeT=SkillInfluenceTypeConfig.getInfluenceSet(influenceType);
	}
	
	/// <summary>
	/// 读完所有表后处理
	/// </summary>
	public static void afterReadConfigAll()
	{

	}
	
	/// <summary>
	/// 是否包含某组
	/// </summary>
	public bool hasGroup(int groupID)
	{
		int[] groups;

		for(int i=(groups=this.groups).Length-1;i>=0;--i)
		{
			if(groups[i]==groupID)
				return true;
		}

		return false;
	}
	
	/// <summary>
	/// 生成刷新配置
	/// </summary>
	protected override void generateRefresh()
	{
		if(_name==null)
			_name=name;
		name=LanguageConfig.getText(_name);
		
		if(_explain==null)
			_explain=explain;
		explain=LanguageConfig.getText(_explain);
		
		iconT=LoadControl.getResourceIDByName(icon);
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeUTF(this.name);
		
		stream.writeUTF(this.explain);
		
		stream.writeInt(this.levelMax);
		
		stream.writeInt(this.useType);
		
		stream.writeInt(this.attackType);
		
		stream.writeBoolean(this.canMove);
		
		stream.writeInt(this.targetType);
		
		if(this.influenceType!=null)
		{
			int[] influenceTypeT=this.influenceType;
			stream.writeLen(influenceTypeT.Length);
			for(int influenceTypeVI=0,influenceTypeVLen=influenceTypeT.Length;influenceTypeVI<influenceTypeVLen;++influenceTypeVI)
			{
				int influenceTypeV=influenceTypeT[influenceTypeVI];
				stream.writeInt(influenceTypeV);
				
			}
		}
		else
		{
			nullObjError("influenceType");
		}
		
		if(this.groups!=null)
		{
			int[] groupsT=this.groups;
			stream.writeLen(groupsT.Length);
			for(int groupsVI=0,groupsVLen=groupsT.Length;groupsVI<groupsVLen;++groupsVI)
			{
				int groupsV=groupsT[groupsVI];
				stream.writeInt(groupsV);
				
			}
		}
		else
		{
			nullObjError("groups");
		}
		
		if(this.underGroupCDs!=null)
		{
			int[] underGroupCDsT=this.underGroupCDs;
			stream.writeLen(underGroupCDsT.Length);
			for(int underGroupCDsVI=0,underGroupCDsVLen=underGroupCDsT.Length;underGroupCDsVI<underGroupCDsVLen;++underGroupCDsVI)
			{
				int underGroupCDsV=underGroupCDsT[underGroupCDsVI];
				stream.writeInt(underGroupCDsV);
				
			}
		}
		else
		{
			nullObjError("underGroupCDs");
		}
		
		stream.writeInt(this.inGroupCD);
		
		if(this.canCancelSkillGroups!=null)
		{
			int[] canCancelSkillGroupsT=this.canCancelSkillGroups;
			stream.writeLen(canCancelSkillGroupsT.Length);
			for(int canCancelSkillGroupsVI=0,canCancelSkillGroupsVLen=canCancelSkillGroupsT.Length;canCancelSkillGroupsVI<canCancelSkillGroupsVLen;++canCancelSkillGroupsVI)
			{
				int canCancelSkillGroupsV=canCancelSkillGroupsT[canCancelSkillGroupsVI];
				stream.writeInt(canCancelSkillGroupsV);
				
			}
		}
		else
		{
			nullObjError("canCancelSkillGroups");
		}
		
		stream.writeInt(this.aiPriority);
		
		if(this.useConditions!=null)
		{
			int[][] useConditionsT=this.useConditions;
			stream.writeLen(useConditionsT.Length);
			for(int useConditionsVI=0,useConditionsVLen=useConditionsT.Length;useConditionsVI<useConditionsVLen;++useConditionsVI)
			{
				int[] useConditionsV=useConditionsT[useConditionsVI];
				if(useConditionsV!=null)
				{
					int[] useConditionsVT=useConditionsV;
					stream.writeLen(useConditionsVT.Length);
					for(int useConditionsVVI=0,useConditionsVVLen=useConditionsVT.Length;useConditionsVVI<useConditionsVVLen;++useConditionsVVI)
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
		
		stream.writeUTF(this.icon);
		
	}
	
}