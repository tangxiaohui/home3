package com.home.commonBase.constlist.generate;

/** 攻击判定阶段(generated by shine) */
public class AttackMomentType
{
	/** 攻击时命中前(无论是否命中)(每次attack触发一次) */
	public static final int AttackBeforeHit=1;
	
	/** 攻击时出伤害前(主目标执行一次) */
	public static final int AttackBeforeDamageMainTarget=2;
	
	/** 攻击时出伤害后(主目标执行一次)(此时能取到伤害值) */
	public static final int AttackAfterDamageMainTarget=3;
	
	/** 攻击时击中任意目标时(出伤害前)(每个attack触发一次) */
	public static final int AttackOnHitAnyTarget=4;
	
	/** 攻击时出伤害前(每个目标执行一次) */
	public static final int AttackBeforeDamageEachTarget=5;
	
	/** 攻击时出伤害后(每个目标执行一次)(此时能取到伤害值) */
	public static final int AttackAfterDamageEachTarget=6;
	
	/** 攻击时命中后(无论是否命中)(每次attack触发一次) */
	public static final int AttackAfterHit=7;
	
	/** 被攻击时出命中前 */
	public static final int BeAttackBeforeHit=8;
	
	/** 被攻击命中时出伤害前 */
	public static final int BeAttackBeforeDamage=9;
	
	/** 被攻击命中时出伤害后(此时能取到伤害值) */
	public static final int BeAttackAfterDamage=10;
	
	/** 击杀后(目标死亡但存在) */
	public static final int AfterKill=11;
	
	/** 被击杀前 */
	public static final int BeforeBeKill=12;
	
	/** 子弹攻击时命中前(无论是否命中)(子弹的attack命中第一个目标时) */
	public static final int AttackBeforeHitForBulletFirstHit=13;
	
	/** 长度 */
	public static int size=14;
	
}
