using ShineEngine;

/// <summary>
/// 场景实例类型(generated by shine)
/// </summary>
public class SceneInstanceType
{
	/// <summary>
	/// 单例场景(主城)
	/// </summary>
	public const int SingleInstance=1;
	
	/// <summary>
	/// 单人副本(可随时出，与player绑定,mmo多用)
	/// </summary>
	public const int SinglePlayerBattle=2;
	
	/// <summary>
	/// 多人副本(可随时出，与player绑定,mmo多用)
	/// </summary>
	public const int MultiPlayerBattle=3;
	
	/// <summary>
	/// 副本预进入场景(限定进入,与player绑定,moba准备场景用)
	/// </summary>
	public const int PreBattle=4;
	
	/// <summary>
	/// 限定多人副本(不可随时出，不与player绑定)
	/// </summary>
	public const int FiniteBattle=5;
	
	/// <summary>
	/// 限定多人副本(不可随时出，不与player绑定,帧同步)
	/// </summary>
	public const int FiniteBattleWithFrameSync=6;
	
	/// <summary>
	/// 分线单例场景(主城)
	/// </summary>
	public const int LinedSingleInstance=7;
	
	/// <summary>
	/// 客户端驱动的单人副本
	/// </summary>
	public const int ClientDriveSinglePlayerBattle=8;
	
	/// <summary>
	/// 自动分线的单例场景(主城类)
	/// </summary>
	public const int AutoLinedScene=9;
	
	/// <summary>
	/// 玩家群独立场景
	/// </summary>
	public const int RoleGroupScene=10;
	
	/// <summary>
	/// 长度
	/// </summary>
	public static int size=11;
	
}