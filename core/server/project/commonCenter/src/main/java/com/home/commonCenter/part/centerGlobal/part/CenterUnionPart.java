package com.home.commonCenter.part.centerGlobal.part;
import com.home.commonBase.config.game.RoleGroupConfig;
import com.home.commonBase.global.Global;
import com.home.commonBase.part.centerGlobal.data.CenterUnionPartData;
import com.home.commonCenter.global.CenterC;
import com.home.commonCenter.part.centerGlobal.base.CenterGlobalBasePart;
import com.home.commonCenter.tool.func.CenterUnionTool;
import com.home.shine.data.BaseData;

/** 中心服宗门数据(generated by shine) */
public class CenterUnionPart extends CenterGlobalBasePart
{
	/** 数据 */
	private CenterUnionPartData _d;
	
	/** 中心服工会工具 */
	protected CenterUnionTool _tool;
	
	@Override
	public void setData(BaseData data)
	{
		super.setData(data);
		
		_d=(CenterUnionPartData)data;
	}
	
	/** 获取数据 */
	public CenterUnionPartData getPartData()
	{
		return _d;
	}
	
	@Override
	protected BaseData createPartData()
	{
		return new CenterUnionPartData();
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
	
	/** 新创建时(该主对象在服务器上第一次被创建时的动作(一生只一次),(只对数据赋值就好,自定义数据构造的部分写到afterReadData里,因为这个完事儿就会回调到)) */
	@Override
	public void onNewCreate()
	{
		
	}
	
	/** 构造函数(只在new后调用一次,再次从池中取出不会调用) */
	@Override
	public void construct()
	{
		if(Global.unionRoleGroupID>0)
		{
			RoleGroupConfig config=RoleGroupConfig.get(Global.unionRoleGroupID);
			
			if(config.needCenterSaveRoleGroup)
			{
				me.func.registFuncTool(_tool=CenterC.factory.createCenterUnionTool());
			}
		}
	}
	
	/** 构造数据前 */
	@Override
	protected void beforeMakeData()
	{
		
	}
	
	/** 获取工会工具 */
	public CenterUnionTool getUnionTool()
	{
		return _tool;
	}
	
}