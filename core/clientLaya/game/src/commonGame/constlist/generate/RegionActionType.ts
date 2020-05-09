namespace Shine
{
	/** 区域行为类型(generated by shine) */
	export class RegionActionType
	{
		/** 直接给自身加buff(离开的时候删) arg1:buffID arg2:buffLevel */
		public static SelfAddBuff:number=1;
		
		/** 进入某场景 arg1:sceneID arg2:是否需要提示 */
		public static EnterScene:number=2;
		
		/** 长度 */
		public static size:number=0;
		
	}
}