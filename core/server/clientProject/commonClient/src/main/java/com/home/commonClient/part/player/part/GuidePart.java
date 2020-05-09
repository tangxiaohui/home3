package com.home.commonClient.part.player.part;
import com.home.commonBase.part.player.clientData.GuideClientPartData;
import com.home.commonClient.part.player.base.PlayerBasePart;
import com.home.shine.data.BaseData;

/** 引导(generated by shine) */
public class GuidePart extends PlayerBasePart
{
	/** 数据 */
	private GuideClientPartData _d;
	
	@Override
	public void setData(BaseData data)
	{
		super.setData(data);
		
		_d=(GuideClientPartData)data;
	}
	
	/** 获取数据 */
	public GuideClientPartData getPartData()
	{
		return _d;
	}
	
	@Override
	protected BaseData createPartData()
	{
		return new GuideClientPartData();
	}
	
	/** 初始化(创建后刚调用,与dispose成对) */
	@Override
	public void init()
	{
		
	}
	
	/** 析构(回池前调用,与init成对) */
	@Override
	public void dispose()
	{
		
	}
	
	/** 从库中读完数据后(做数据的补充解析)(onNewCreate后也会调用一次)(主线程) */
	@Override
	public void afterReadData()
	{
		
	}
	
	/** 构造函数(只在new后调用一次,再次从池中取出不会调用) */
	@Override
	public void construct()
	{
		
	}
	
	/** 构造数据前 */
	@Override
	protected void beforeMakeData()
	{
		
	}
	
	/** 功能开启(id:功能ID) */
	@Override
	public void onFunctionOpen(int id)
	{
		
	}
	
	/** 功能关闭(id:功能ID) */
	@Override
	public void onFunctionClose(int id)
	{
		
	}
	
}