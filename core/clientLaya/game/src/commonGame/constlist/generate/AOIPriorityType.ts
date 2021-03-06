namespace Shine
{
	/** aoi优先级类型(generated by shine) */
	export class AOIPriorityType
	{
		/** 最高优先级(自己的单位,组队成员) */
		public static Self:number=0;
		
		/** 优先级高(好友,工会,boss,服务器npc) */
		public static High:number=1;
		
		/** 怪物 */
		public static Normal:number=2;
		
		/** 辅助单位 */
		public static Low:number=3;
		
		/** 长度 */
		public static size:number=4;
		
	}
}
