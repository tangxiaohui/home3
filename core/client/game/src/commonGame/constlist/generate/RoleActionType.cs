using ShineEngine;

/// <summary>
/// 角色行为类型(generated by shine)
/// </summary>
public class RoleActionType
{
	/// <summary>
	/// 主角添加固定属性 arg1:属性类型,arg2:属性值(当前属性)
	/// </summary>
	public const int HeroAddAttribute=1;
	
	/// <summary>
	/// 主角添加变量属性 arg1:属性类型,arg2:变量ID(当前属性)
	/// </summary>
	public const int HeroAddAttributeVar=2;
	
	/// <summary>
	/// 主角添加buff arg1:buffID arg2:buff等级
	/// </summary>
	public const int HeroAddBuff=3;
	
	/// <summary>
	/// 添加货币 arg1:货币类型 arg2:数目
	/// </summary>
	public const int AddCurrency=4;
	
	/// <summary>
	/// 添加奖励 arg1:奖励id
	/// </summary>
	public const int AddReward=5;
	
	/// <summary>
	/// 移除道具 arg1:道具id  arg2:道具数量
	/// </summary>
	public const int RemoveItem=6;
	
	/// <summary>
	/// 长度
	/// </summary>
	public static int size=7;
	
}