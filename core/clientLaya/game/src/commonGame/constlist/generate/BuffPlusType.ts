namespace Shine
{
	/** buff叠加类型(generated by shine) */
	export class BuffPlusType
	{
		/** 标准(高等级替换低等级,并刷新时间到高等级时间,低等级只是给高等级刷新时间,刷新到高等级的时间) */
		public static Normal:number=1;
		
		/** 替换(新的替换旧的) */
		public static Replace:number=2;
		
		/** 并存(同时生效)(各自独立计算冷却) */
		public static AllExist:number=3;
		
		/** 叠层(层数使用lastNum，每次加1,如果添加高等级的，继承旧的层数) */
		public static AddFloor:number=4;
		
		/** 长度 */
		public static size:number=5;
		
	}
}
