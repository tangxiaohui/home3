package com.home.commonClient.tool.func;

import com.home.commonBase.constlist.generate.FunctionType;
import com.home.commonBase.constlist.generate.GameEventType;
import com.home.commonBase.data.item.ItemData;
import com.home.commonBase.data.item.UseItemArgData;
import com.home.commonBase.tool.func.ItemDicContainerTool;
import com.home.commonClient.net.request.func.item.FuncUseItemRequest;
import com.home.commonClient.part.player.Player;
import com.home.shine.support.collection.SList;

public class PlayerItemDicContainerTool extends ItemDicContainerTool implements IPlayerFuncTool
{
	public Player me;
	
	public PlayerItemDicContainerTool(int funcID)
	{
		super(funcID);
	}
	
	public void setMe(Player player)
	{
		me=player;
	}
	
	@Override
	public void onEvent(int type,Object data)
	{
	
	}
	
	@Override
	public void onStart()
	{
	
	}
	
	@Override
	protected ItemData createItemByType(int type)
	{
		return me.bag.createItemByType(type);
	}
	
	@Override
	protected void releaseItem(ItemData data)
	{
		me.bag.releaseItem(data);
	}
	
	@Override
	public void afterReadData()
	{
		super.afterReadData();
		
	}
	
	
	@Override
	protected void onItemAdd(int index,ItemData data,int num,int way)
	{
		super.onItemAdd(index,data,num,way);
		
		
		me.dispatch(GameEventType.FuncItemContainerRefreshGrid,new int[]{_funcID,index});
		
		if(_funcID==FunctionType.MainBag)
		{
			me.dispatch(GameEventType.MainBagRefreshGrid,index);
			me.dispatch(GameEventType.MainBagItemChange,data.id);
		}
	}
	
	@Override
	protected void onItemRemove(int index,ItemData data,int num,int way)
	{
		super.onItemRemove(index,data,num,way);
		
		
		me.dispatch(GameEventType.FuncItemContainerRefreshGrid,new int[]{_funcID,index});
		
		if(_funcID==FunctionType.MainBag)
		{
			me.dispatch(GameEventType.MainBagRefreshGrid,index);
			me.dispatch(GameEventType.MainBagItemChange,data.id);
		}
	}
	
	@Override
	protected void onChanged()
	{
		super.onChanged();
		
		me.dispatch(GameEventType.FuncItemContainerChange,_funcID);
		
		if(_funcID==FunctionType.MainBag)
		{
			me.dispatch(GameEventType.MainBagChange);
		}
		
		//me.bag.printBag();
	}
	
	@Override
	public boolean checkCanUseItem(ItemData data,int num,UseItemArgData arg)
	{
		return me.bag.checkItemUseConditions(data,num,arg,false);
	}
	
	@Override
	protected void toSendUseItem(ItemData data,int index,int num,UseItemArgData arg)
	{
		me.send(FuncUseItemRequest.create(_funcID,index,num,data.id,arg));
	}
	
	@Override
	protected void toUseItem(ItemData data,int num,UseItemArgData arg)
	{
		me.bag.toUseItem(data,num,arg);
	}
	
	@Override
	protected void toUseItem(int id,int num,UseItemArgData arg,int way)
	{
		me.bag.toUseItem(id,num,arg,way);
	}
	
	@Override
	protected void doUseItemResult(int id,int num,Boolean result)
	{
		if(_funcID==FunctionType.MainBag)
		{
			me.bag.useItemResult(id,num,result);
		}
	}
	
	@Override
	protected void onAddItemNotice(SList<ItemData> list,int way)
	{
		me.dispatch(GameEventType.AddItemNotice,list);
	}
}