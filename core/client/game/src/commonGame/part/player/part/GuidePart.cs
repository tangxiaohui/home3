using ShineEngine;

/// <summary>
/// 引导(generated by shine)
/// </summary>
public class GuidePart:PlayerBasePart
{
	/** 数据 */
	private GuidePartData _d;
	
	public override void setData(BaseData data)
	{
		base.setData(data);
		
		_d=(GuidePartData)data;
	}
	
	/// <summary>
	/// 获取数据
	/// </summary>
	public GuidePartData getPartData()
	{
		return _d;
	}
	
	protected override BaseData createPartData()
	{
		return new GuidePartData();
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
	/// 构造函数(只在new后调用一次,再次从池中取出不会调用)
	/// </summary>
	public override void construct()
	{
		
	}
	
	/// <summary>
	/// 构造数据前
	/// </summary>
	protected override void beforeMakeData()
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
	/// 获取主引导步
	/// </summary>
	public int getMainStep()
	{
		return _d.mainStep;
	}
	
	/// <summary>
	/// 设置主引导步(客户端主动)
	/// </summary>
	public virtual void setMainStep(int value)
	{
		_d.mainStep=value;

		SetMainGuideStepRequest.create(value).send();

	}
	
	/// <summary>
	/// 更新引导步
	/// </summary>
	public void onRefreshMainStep(int value)
	{
		_d.mainStep=value;
	}
	
}