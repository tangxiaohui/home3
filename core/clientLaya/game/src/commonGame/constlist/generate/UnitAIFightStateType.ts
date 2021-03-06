namespace Shine
{
	/** 单位AI状态类型(generated by shine) */
	export class UnitAIFightStateType
	{
		/** 无 */
		public static None:number=0;
		
		/** 待机 */
		public static Idle:number=1;
		
		/** 移动中(指定指令) */
		public static Move:number=2;
		
		/** 追击中 */
		public static Pursue:number=3;
		
		/** 攻击中 */
		public static Attack:number=4;
		
		/** 回位 */
		public static Back:number=5;
		
		/** 长度 */
		public static size:number=6;
		
	}
}
