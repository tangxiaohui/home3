using ShineEngine;

/// <summary>
/// 区域行为类型(generated by shine)
/// </summary>
public class RegionActionType
{
	/// <summary>
	/// 直接给自身加buff(离开的时候删) arg1:buffID arg2:buffLevel
	/// </summary>
	public const int SelfAddBuff=1;
	
	/// <summary>
	/// 进入某场景 arg1:sceneID arg2:是否需要提示
	/// </summary>
	public const int EnterScene=2;
	
	/// <summary>
	/// 长度
	/// </summary>
	public static int size=0;
	
}