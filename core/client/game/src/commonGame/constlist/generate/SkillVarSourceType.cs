using ShineEngine;

/// <summary>
/// 技能变量源类型(generated by shine)
/// </summary>
public class SkillVarSourceType
{
	/// <summary>
	/// 常量 (arg1:常量值)
	/// </summary>
	public const int ConstValue=0;
	
	/// <summary>
	/// 自身属性(arg1:属性类型)
	/// </summary>
	public const int SelfAttribute=1;
	
	/// <summary>
	/// 目标属性(arg1:属性类型)
	/// </summary>
	public const int TargetAttribute=2;
	
	/// <summary>
	/// 自身等级
	/// </summary>
	public const int SelfLevel=3;
	
	/// <summary>
	/// 目标等级
	/// </summary>
	public const int TargetLevel=4;
	
	/// <summary>
	/// 自身货币(arg1:货币类型)
	/// </summary>
	public const int SelfCurrency=5;
	
	/// <summary>
	/// 自身当前属性千分比(arg1:当前属性类型)
	/// </summary>
	public const int SelfCurrentAttributePercent=7;
	
	/// <summary>
	/// 目标当前属性千分比(arg1:当前属性类型)
	/// </summary>
	public const int TargetCurrentAttributePercent=8;
	
	/// <summary>
	/// 自身当前属性损失千分比(arg1:当前属性类型)
	/// </summary>
	public const int SelfCurrentAttributeLostPercent=9;
	
	/// <summary>
	/// 目标当前属性损失千分比(arg1:当前属性类型)
	/// </summary>
	public const int TargetCurrentAttributeLostPercent=10;
	
	/// <summary>
	/// 自身buff层数(arg1:buffID)
	/// </summary>
	public const int SelfBuffFloor=11;
	
	/// <summary>
	/// 目标buff层数(arg1:buffID)
	/// </summary>
	public const int TargetBuffFloor=12;
	
	/// <summary>
	/// 自身上个技能步经过时间(ms)
	/// </summary>
	public const int SelfLastSkillStepTime=13;
	
	/// <summary>
	/// 自身上个技能步经过时间千分比
	/// </summary>
	public const int SelfLastSkillStepTimePercent=14;
	
	/// <summary>
	/// 长度
	/// </summary>
	public static int size=15;
	
}