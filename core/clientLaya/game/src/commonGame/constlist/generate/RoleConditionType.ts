namespace Shine
{
	/** 角色条件类型(generated by shine) */
	export class RoleConditionType
	{
		/** 等级要求(大于等于)(arg1:等级) */
		public static Level:number=1;
		
		/** 功能开启(arg1:功能ID) */
		public static FunctionOpen:number=2;
		
		/** 需要有工会 */
		public static NeedUnion:number=3;
		
		/** 任务已完成(arg1:任务ID) */
		public static QuestComplete:number=4;
		
		/** 主角在某状态下(arg1:状态ID) */
		public static OnStatus:number=5;
		
		/** 主角不在某状态下(arg1:状态ID) */
		public static OffStatus:number=6;
		
		/** 需要有组队 */
		public static NeedTeam:number=7;
		
		/** 长度 */
		public static size:number=8;
		
	}
}
