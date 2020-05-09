using ShineEngine;

/// <summary>
/// 技能步骤切换类型(generated by shine)
/// </summary>
public class SkillStepSwitchType
{
	/// <summary>
	/// 自动切换(动作结束后)(arg1:下个step)
	/// </summary>
	public const int Auto=1;
	
	/// <summary>
	/// 技能指令控制(arg1:下个step,[arg2:切换时间],[arg3:开始接收时间],[arg4:结束接收时间])
	/// </summary>
	public const int SkillCommand=2;
	
	/// <summary>
	/// 长度
	/// </summary>
	public static int size=3;
	
}