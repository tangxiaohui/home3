package com.home.commonGame.part.player.part;
import com.home.commonBase.baseData.BaseClientPartData;
import com.home.commonBase.config.game.CharacterConfig;
import com.home.commonBase.config.game.enumT.EquipSlotTypeConfig;
import com.home.commonBase.data.item.EquipContainerData;
import com.home.commonBase.data.role.CharacterSaveData;
import com.home.commonBase.data.role.CharacterUseData;
import com.home.commonBase.global.BaseC;
import com.home.commonBase.part.player.clientData.SingleCharacterClientPartData;
import com.home.commonBase.part.player.data.SingleCharacterPartData;
import com.home.commonGame.global.GameC;
import com.home.commonGame.logic.unit.CharacterUseLogic;
import com.home.commonGame.logic.unit.MUnitUseLogic;
import com.home.commonGame.part.player.part.CharacterPart;
import com.home.shine.ctrl.Ctrl;
import com.home.shine.data.BaseData;

/** 单一角色模块(generated by shine) */
public class SingleCharacterPart extends CharacterPart
{
	/** 数据 */
	private SingleCharacterPartData _d;
	
	/** 主角色 */
	private CharacterUseLogic _hero;
	
	@Override
	public void setData(BaseData data)
	{
		super.setData(data);
		
		_d=(SingleCharacterPartData)data;
	}
	
	/** 获取数据 */
	public SingleCharacterPartData getPartData()
	{
		return _d;
	}
	
	@Override
	protected BaseData createPartData()
	{
		return new SingleCharacterPartData();
	}
	
	@Override
	protected BaseClientPartData createClientData()
	{
		return new SingleCharacterClientPartData();
	}
	
	/** 写客户端数据(copyServer过后的) */
	@Override
	protected void writeClientData(BaseClientPartData data)
	{
		super.writeClientData(data);
		
		toWriteClientData((SingleCharacterClientPartData)data);
	}
	
	/** 写客户端数据具体执行(已执行过copyServer了,就是说CPO中与SPO同名同类型的属性无需再赋值) */
	private void toWriteClientData(SingleCharacterClientPartData data)
	{
		data.hero=(CharacterUseData)_hero.createSendClientData();
	}
	
	/** 推送完客户端数据后 */
	@Override
	public void afterSendClientListData()
	{
		_hero.endSendClientData();
	}
	
	/** 构造函数(只在new后调用一次,再次从池中取出不会调用) */
	@Override
	public void construct()
	{
		super.construct();
		
		_hero=GameC.factory.createCharacterUseLogic();
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
		
		_hero.dispose();
	}
	
	/** 从库中读完数据后(做数据的补充解析)(onNewCreate后也会调用一次)(主线程) */
	@Override
	public void afterReadData()
	{
		super.afterReadData();
		
		initCharacterUseLogicBySaveData(_hero,_d.hero,true,true);
		//主角默认标记上阵
		_hero.setIsWorking(true);
	}
	
	/** 新创建时(该主对象在服务器上第一次被创建时的动作(一生只一次),(只对数据赋值就好,自定义数据构造的部分写到afterReadData里,因为这个完事儿就会回调到)) */
	@Override
	public void onNewCreate()
	{
		super.onNewCreate();
		
		onNewCreateHero(_d.hero=BaseC.factory.createCharacterSaveData());
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
	
	@Override
	public CharacterUseLogic getCurrentCharacterUseLogic()
	{
		return _hero;
	}
	
	@Override
	public void onLevelUp(int oldLevel)
	{
		_hero.onLevelUp(me.role.getLevel());
	}
	
	/** 新创建主角 */
	protected void onNewCreateHero(CharacterSaveData saveData)
	{
		CharacterConfig cConfig=CharacterConfig.getCharacterConfigByVocationAndSex(me.role.getVocation(),me.role.getSex());
		
		if(cConfig==null)
		{
			Ctrl.errorLog("找不到单角色配置",me.role.getVocation(),me.role.getSex());
			return;
		}
		
		saveData.id=cConfig.id;
		
		newCreateSaveData(saveData);
	}
	
}