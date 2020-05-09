using ShineEngine;

/// <summary>
/// 技能行为类型(generated by shine)
/// </summary>
public class SkillActionType
{
	/// <summary>
	/// 特殊移动 arg1:移动类型 arg2:移动参数
	/// </summary>
	public const int SpecialMove=1;
	
	/// <summary>
	/// 直接给自身加buff arg1:buffID arg2:buffLevel
	/// </summary>
	public const int SelfAddBuff=2;
	
	/// <summary>
	/// 在目标点创建傀儡 arg1:傀儡ID arg2:傀儡等级 [arg3:存在时间(ms)(0为无限)]
	/// </summary>
	public const int AddPuppetAtTarget=3;
	
	/// <summary>
	/// 直接给自身加固定属性 arg1:属性类型 arg2:属性值
	/// </summary>
	public const int SelfAddAttribute=4;
	
	/// <summary>
	/// 直接给自身加变量属性 arg1:属性类型 arg2:变量ID
	/// </summary>
	public const int SelfAddAttributeVar=5;
	
	/// <summary>
	/// 自杀
	/// </summary>
	public const int KillSelf=6;
	
	/// <summary>
	/// 自身增加当前组CD时间经过 arg1:组ID arg2:时间(ms)
	/// </summary>
	public const int AddGroupTimePass=7;
	
	/// <summary>
	/// 自身移除组CD arg1:组ID
	/// </summary>
	public const int RemoveGroupCD=8;
	
	/// <summary>
	/// 创建选择的建筑(从SkillTargetData的arg读建筑id) [arg1:是否直接就绪]
	/// </summary>
	public const int CreateSelectBuilding=9;
	
	/// <summary>
	/// 直接移除某组buff arg1:组ID
	/// </summary>
	public const int SelfRemoveGroupBuff=10;
	
	/// <summary>
	/// 拾取掉落物品(目标为掉落物品时)
	/// </summary>
	public const int PickFieldItem=11;
	
	/// <summary>
	/// 使用操作体(目标为操作体时)
	/// </summary>
	public const int Operate=12;
	
	/// <summary>
	/// 长度
	/// </summary>
	public static int size=0;
	
}