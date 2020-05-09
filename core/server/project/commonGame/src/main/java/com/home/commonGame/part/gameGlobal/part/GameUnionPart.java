package com.home.commonGame.part.gameGlobal.part;
import com.home.commonBase.constlist.generate.FunctionType;
import com.home.commonBase.global.Global;
import com.home.commonBase.part.gameGlobal.data.GameUnionPartData;
import com.home.commonGame.global.GameC;
import com.home.commonGame.logic.union.Union;
import com.home.commonGame.logic.union.UnionTool;
import com.home.commonGame.part.gameGlobal.base.GameGlobalBasePart;
import com.home.shine.data.BaseData;

/** 工会数据(generated by shine) */
public class GameUnionPart extends GameGlobalBasePart
{
	/** 数据 */
	private GameUnionPartData _d;
	
	/** 工会工具 */
	private UnionTool _tool;
	
	@Override
	public void setData(BaseData data)
	{
		super.setData(data);
		
		_d=(GameUnionPartData)data;
	}
	
	/** 获取数据 */
	public GameUnionPartData getPartData()
	{
		return _d;
	}
	
	@Override
	protected BaseData createPartData()
	{
		return new GameUnionPartData();
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
			me.func.registFuncTool(_tool=GameC.factory.createUnionTool());
		}
	}
	
	/** 构造数据前 */
	@Override
	protected void beforeMakeData()
	{
		
	}
	
	public UnionTool getUnionTool()
	{
		return _tool;
	}
	
}