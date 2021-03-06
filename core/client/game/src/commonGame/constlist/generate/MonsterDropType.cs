using ShineEngine;

/// <summary>
/// 怪物掉落类型(generated by shine)
/// </summary>
public class MonsterDropType
{
	/// <summary>
	/// 无掉落
	/// </summary>
	public const int None=0;
	
	/// <summary>
	/// 直接添加(包满无法再添加)
	/// </summary>
	public const int Add=1;
	
	/// <summary>
	/// 直接添加(包满邮件)
	/// </summary>
	public const int AddAbs=2;
	
	/// <summary>
	/// 物品类掉落(真)
	/// </summary>
	public const int Drop=3;
	
	/// <summary>
	/// 物品类走掉落包(真)
	/// </summary>
	public const int DropBag=4;
	
	/// <summary>
	/// 物品类掉落(仅自己可见)
	/// </summary>
	public const int SelfDrop=5;
	
	/// <summary>
	/// 物品类走掉落包(仅自己可见)
	/// </summary>
	public const int SelfDropBag=6;
	
	/// <summary>
	/// 仅自己可见掉落包，绑定单位(尸体)
	/// </summary>
	public const int SelfDropBagBindUnit=7;
	
	/// <summary>
	/// 长度
	/// </summary>
	public static int size=8;
	
}
