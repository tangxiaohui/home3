using ShineEngine;

/// <summary>
/// 工会(generated by shine)
/// </summary>
public class UnionPart:PlayerBasePart
{
	/** 数据 */
	private UnionPartData _d;
	
	private PlayerUnionTool _tool;
	
	public override void setData(BaseData data)
	{
		base.setData(data);
		
		_d=(UnionPartData)data;
	}
	
	/// <summary>
	/// 获取数据
	/// </summary>
	public UnionPartData getPartData()
	{
		return _d;
	}
	
	/// <summary>
	/// 构造函数(只在new后调用一次,再次从池中取出不会调用)
	/// </summary>
	public override void construct()
	{
		if(Global.unionRoleGroupID>0)
		{
			me.func.registFuncTool(_tool=GameC.factory.createPlayerUnionTool());
		}
	}
	
	/// <summary>
	/// 构造数据前
	/// </summary>
	protected override void beforeMakeData()
	{
		
	}
	
	/// <summary>
	/// 初始化(创建后刚调用,与dispose成对)
	/// </summary>
	public override void init()
	{
		
	}
	
	/// <summary>
	/// 析构(回池前调用,与init成对)
	/// </summary>
	public override void dispose()
	{
		
	}
	
	/// <summary>
	/// 从库中读完数据后(做数据的补充解析)(onNewCreate后也会调用一次)(主线程)
	/// </summary>
	public override void afterReadData()
	{
		
	}
	
	/// <summary>
	/// 功能开启(id:功能ID)
	/// </summary>
	public override void onFunctionOpen(int id)
	{
		
	}
	
	/// <summary>
	/// 功能关闭(id:功能ID)
	/// </summary>
	public override void onFunctionClose(int id)
	{
		
	}
	
	/// <summary>
	/// 是否有工会
	/// </summary>
	public bool hasUnion()
	{
		return _tool.getOnlyOne()!=null;
	}
	
	protected override BaseData createPartData()
	{
		return new UnionPartData();
	}
	
}
