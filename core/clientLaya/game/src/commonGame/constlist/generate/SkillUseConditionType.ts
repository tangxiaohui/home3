namespace Shine
{
	/** 技能使用条件类型(generated by shine) */
	export class SkillUseConditionType
	{
		/** 在某状态下(arg1:状态ID) */
		public static OnStatus:number=1;
		
		/** 不在某状态下(arg1:状态ID) */
		public static OffStatus:number=2;
		
		/** 属性小于(arg1:属性ID,arg2:属性值) */
		public static AttributeLessThan:number=3;
		
		/** 属性大于(arg1:属性ID,arg2:属性值) */
		public static AttributeMoreThan:number=4;
		
		/** 属性不大于(小于等于)(arg1:属性ID,arg2:属性值) */
		public static AttributeNotMoreThan:number=5;
		
		/** 属性不小于(大于等于)(arg1:属性ID,arg2:属性值) */
		public static AttributeNotLessThan:number=6;
		
		/** 长度 */
		public static size:number=7;
		
	}
}
