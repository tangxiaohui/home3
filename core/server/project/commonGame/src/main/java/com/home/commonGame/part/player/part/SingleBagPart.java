package com.home.commonGame.part.player.part;
import com.home.commonBase.baseData.BaseClientPartData;
import com.home.commonBase.constlist.generate.CallWayType;
import com.home.commonBase.constlist.generate.CurrencyType;
import com.home.commonBase.constlist.generate.FunctionType;
import com.home.commonBase.data.item.ItemContainerData;
import com.home.commonBase.data.item.ItemData;
import com.home.commonBase.data.item.UseItemArgData;
import com.home.commonBase.global.CommonSetting;
import com.home.commonBase.global.Global;
import com.home.commonBase.part.player.clientData.SingleBagClientPartData;
import com.home.commonBase.part.player.data.SingleBagPartData;
import com.home.commonBase.tool.func.BaseItemContainerTool;
import com.home.commonGame.part.player.part.BagPart;
import com.home.commonGame.tool.func.IPlayerFuncTool;
import com.home.commonGame.tool.func.PlayerItemContainerTool;
import com.home.commonGame.tool.func.PlayerItemDicContainerTool;
import com.home.shine.ctrl.Ctrl;
import com.home.shine.data.BaseData;
import com.home.shine.data.DIntData;
import com.home.shine.support.collection.SList;

/** 单一背包模块(generated by shine) */
public class SingleBagPart extends BagPart
{
	/** 数据 */
	private SingleBagPartData _d;
	
	/** 主背包 */
	private BaseItemContainerTool _mainBag;
	
	@Override
	public void setData(BaseData data)
	{
		super.setData(data);
		
		_d=(SingleBagPartData)data;
	}
	
	/** 获取数据 */
	public SingleBagPartData getPartData()
	{
		return _d;
	}
	
	@Override
	protected BaseData createPartData()
	{
		return new SingleBagPartData();
	}
	
	@Override
	protected BaseClientPartData createClientData()
	{
		return new SingleBagClientPartData();
	}
	
	/** 写客户端数据(copyServer过后的) */
	@Override
	protected void writeClientData(BaseClientPartData data)
	{
		super.writeClientData(data);
		
		toWriteClientData((SingleBagClientPartData)data);
	}
	
	/** 写客户端数据具体执行(已执行过copyServer了,就是说CPO中与SPO同名同类型的属性无需再赋值) */
	private void toWriteClientData(SingleBagClientPartData data)
	{
		
	}
	
	/** 构造函数(只在new后调用一次,再次从池中取出不会调用) */
	@Override
	public void construct()
	{
		super.construct();
		
		if(CommonSetting.useDicBag)
		{
			_mainBag=new PlayerItemDicContainerTool(FunctionType.MainBag);
		}
		else
		{
			_mainBag=new PlayerItemContainerTool(FunctionType.MainBag);
		}
		
		_mainBag.setIsBag(true);
		
		me.func.registFuncTool((IPlayerFuncTool)_mainBag);
	}
	
	/** 初始化(创建后刚调用,与dispose成对) */
	@Override
	public void init()
	{
		super.init();
		
	}
	
	/** 析构(回池前调用,与init成对) */
	@Override
	public void dispose()
	{
		super.dispose();
		
	}
	
	/** 从库中读完数据后(做数据的补充解析)(onNewCreate后也会调用一次)(主线程) */
	@Override
	public void afterReadData()
	{
		super.afterReadData();
		
	}
	
	/** 新创建时(该主对象在服务器上第一次被创建时的动作(一生只一次),(只对数据赋值就好,自定义数据构造的部分写到afterReadData里,因为这个完事儿就会回调到)) */
	@Override
	public void onNewCreate()
	{
		super.onNewCreate();
		
		//有格背包
		if(!CommonSetting.useDicBag)
		{
			//初始设置上限
			((ItemContainerData)_mainBag.getData()).gridNum=Global.mainBagGridNum;
		}
		
	}
	
	/** 构造数据前 */
	@Override
	protected void beforeMakeData()
	{
		super.beforeMakeData();
		
	}
	
	/** 功能开启(id:功能ID) */
	@Override
	public void onFunctionOpen(int id)
	{
		super.onFunctionOpen(id);
		
	}
	
	/** 功能关闭(id:功能ID) */
	@Override
	public void onFunctionClose(int id)
	{
		super.onFunctionClose(id);
		
	}
	
	/** 获取主容器 */
	public BaseItemContainerTool getContainer()
	{
		return _mainBag;
	}
	
	@Override
	public ItemData getItem(int index)
	{
		return _mainBag.getItem(index);
	}
	
	/** 获取某id的物品数量 */
	@Override
	public int getItemNum(int itemID)
	{
		return _mainBag.getItemNum(itemID);
	}
	
	@Override
	public boolean hasFreeGrid(int num)
	{
		return _mainBag.hasFreeGrid(num);
	}
	
	@Override
	public boolean hasItemPlace(ItemData data)
	{
		return _mainBag.hasItemPlace(data);
	}
	
	/** 是否有物品位置 */
	@Override
	public boolean hasItemPlace(DIntData[] dataArr)
	{
		return _mainBag.hasItemPlace(dataArr);
	}
	
	@Override
	public boolean hasItemPlace(int id,int num)
	{
		return _mainBag.hasItemPlace(id,num);
	}
	
	@Override
	public boolean hasItemPlace(SList<ItemData> list)
	{
		return _mainBag.hasItemPlace(list);
	}
	
	@Override
	protected boolean toAddItem(ItemData data,int way)
	{
		return _mainBag.addItem(data,way);
	}
	
	@Override
	protected boolean toAddItem(int id,int num,int way)
	{
		return _mainBag.addItem(id,num,way);
	}
	
	@Override
	protected boolean toAddItems(SList<ItemData> list,int way)
	{
		return _mainBag.addItems(list,way);
	}
	
	@Override
	protected boolean toAddItems(DIntData[] list,int num,int way)
	{
		return _mainBag.addItems(list,num,way);
	}
	
	@Override
	protected boolean toAddNewItemToIndex(int index,ItemData data,int way)
	{
		return _mainBag.addNewItemToIndex(index,data,way);
	}
	
	@Override
	public boolean containsItem(int id,int num)
	{
		return _mainBag.containsItem(id,num);
	}
	
	@Override
	protected boolean toRemoveItem(int id,int num,int way)
	{
		return _mainBag.removeItem(id,num,way);
	}
	
	@Override
	protected boolean toRemoveItems(DIntData[] items,int num,int way)
	{
		return _mainBag.removeItems(items,num,way);
	}
	
	@Override
	protected boolean toRemoveItemByIndex(int index,int num,int way)
	{
		return _mainBag.removeItemByIndex(index,num,way);
	}
	
	@Override
	public boolean useItemByID(int id,UseItemArgData arg)
	{
		return _mainBag.useItemByID(id,arg);
	}
	
	@Override
	public boolean useItemByIndex(int index,int num,UseItemArgData arg)
	{
		return _mainBag.useItemByIndex(index,num,arg);
	}
	
	@Override
	public void cleanUp()
	{
		if(!CommonSetting.useDicBag)
		{
			((PlayerItemContainerTool)_mainBag).cleanUp();
		}
	}
	
	@Override
	public void printBag()
	{
		_mainBag.printBag();
	}
	
}