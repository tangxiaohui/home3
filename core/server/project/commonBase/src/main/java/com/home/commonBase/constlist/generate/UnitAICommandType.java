package com.home.commonBase.constlist.generate;

/** 单位AI指令类型(generated by shine) */
public class UnitAICommandType
{
	/** 无 */
	public static final int None=0;
	
	/** 保护原地(怪物默认) */
	public static final int Protect=1;
	
	/** 原地(遇敌对逃跑) */
	public static final int Escape=2;
	
	/** 移动到(目标点) */
	public static final int MoveTo=3;
	
	/** 移动到(目标单位) */
	public static final int MoveToUnit=4;
	
	/** 特殊移动到(目标点) */
	public static final int SpecialMoveTo=5;
	
	/** 攻击到(目标单位) */
	public static final int AttackTo=6;
	
	/** 技能攻击到(目标单位) */
	public static final int SkillTo=7;
	
	/** 攻击移动到(目标点) */
	public static final int AttackMoveTo=8;
	
	/** 拾取物品 */
	public static final int PickUpItem=9;
	
	/** 朝向移动(目标朝向) */
	public static final int MoveDir=10;
	
	/** 跟随(目标单位) */
	public static final int Follow=11;
	
	/** 攻击跟随(目标单位) */
	public static final int FollowAttack=12;
	
	/** 长度 */
	public static int size=13;
	
}
