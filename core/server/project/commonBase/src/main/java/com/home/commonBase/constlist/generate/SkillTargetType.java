package com.home.commonBase.constlist.generate;

/** 技能目标类型(generated by shine) */
public class SkillTargetType
{
	/** 无目标(立即释放)(无视距离限制) */
	public static final int None=0;
	
	/** 任意目标(单体) */
	public static final int Single=1;
	
	/** 地面坐标 */
	public static final int Ground=2;
	
	/** 朝向 */
	public static final int Direction=3;
	
	/** 攻击范围判定(矩形)(但是先要符合距离限制) */
	public static final int AttackScope=4;
	
	/** 长度 */
	public static int size=5;
	
}
