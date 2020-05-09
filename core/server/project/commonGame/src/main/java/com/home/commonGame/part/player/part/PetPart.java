package com.home.commonGame.part.player.part;
import com.home.commonBase.baseData.BaseClientPartData;
import com.home.commonBase.constlist.generate.InfoCodeType;
import com.home.commonBase.data.role.PetSaveData;
import com.home.commonBase.data.role.PetUseData;
import com.home.commonBase.global.BaseC;
import com.home.commonBase.global.CommonSetting;
import com.home.commonBase.global.Global;
import com.home.commonBase.part.player.clientData.PetClientPartData;
import com.home.commonBase.part.player.data.PetPartData;
import com.home.commonBase.scene.base.Unit;
import com.home.commonGame.global.GameC;
import com.home.commonGame.logic.unit.PetUseLogic;
import com.home.commonGame.net.request.role.pet.AddPetRequest;
import com.home.commonGame.net.request.role.pet.RefreshPetIsWorkingRequest;
import com.home.commonGame.net.request.role.pet.RemovePetRequest;
import com.home.commonGame.part.player.base.PlayerBasePart;
import com.home.commonGame.scene.base.GameScene;
import com.home.shine.ctrl.Ctrl;
import com.home.shine.data.BaseData;
import com.home.shine.support.collection.IntObjectMap;
import com.home.shine.support.pool.ObjectPool;

/** 宠物(generated by shine) */
public class PetPart extends PlayerBasePart
{
	/** 数据 */
	private PetPartData _d;
	
	private ObjectPool<PetUseLogic> _petUseLogicPool;
	
	private IntObjectMap<PetUseLogic> _petDic=new IntObjectMap<>(PetUseLogic[]::new);
	
	private IntObjectMap<PetUseLogic> _petDicByID;
	
	@Override
	public void setData(BaseData data)
	{
		super.setData(data);
		
		_d=(PetPartData)data;
	}
	
	/** 获取数据 */
	public PetPartData getPartData()
	{
		return _d;
	}
	
	@Override
	protected BaseData createPartData()
	{
		return new PetPartData();
	}
	
	@Override
	protected BaseClientPartData createClientData()
	{
		return new PetClientPartData();
	}
	
	/** 写客户端数据(copyServer过后的) */
	@Override
	protected void writeClientData(BaseClientPartData data)
	{
		toWriteClientData((PetClientPartData)data);
	}
	
	/** 写客户端数据具体执行(已执行过copyServer了,就是说CPO中与SPO同名同类型的属性无需再赋值) */
	private void toWriteClientData(PetClientPartData data)
	{
		PetUseLogic[] values;
		PetUseLogic v;
		
		for(int i=(values=_petDic.getValues()).length-1;i>=0;--i)
		{
			if((v=values[i])!=null)
			{
				data.petDic.put(v.index,(PetUseData)v.createSendClientData());
			}
		}
	}
	
	public void afterSendClientListData()
	{
		PetUseLogic[] values;
		PetUseLogic v;
		
		for(int i=(values=_petDic.getValues()).length-1;i>=0;--i)
		{
			if((v=values[i])!=null)
			{
				v.endSendClientData();
			}
		}
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
		_petDic.forEachValueAndClear(v->
		{
			v.dispose();
			_petUseLogicPool.back(v);
		});
		
		if(Global.isPetUnique)
		{
			_petDicByID.clear();
		}
	}
	
	/** 从库中读完数据后(做数据的补充解析)(onNewCreate后也会调用一次)(主线程) */
	@Override
	public void afterReadData()
	{
		if(_d.petDic==null)
			_d.petDic=new IntObjectMap<>(PetSaveData[]::new);
		
		PetSaveData[] values;
		PetSaveData v;
		
		for(int i=(values=_d.petDic.getValues()).length-1;i>=0;--i)
		{
			if((v=values[i])!=null)
			{
				PetUseLogic logic=_petUseLogicPool.getOne();
				initPetUseLogicBySaveData(logic,v);
			}
		}
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
		_petUseLogicPool=new ObjectPool<>(PetUseLogic::new);
		_petUseLogicPool.setEnable(CommonSetting.playerUsePool);
		
		if(Global.isPetUnique)
		{
			_petDicByID=new IntObjectMap<>(PetUseLogic[]::new);
		}
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
	
	/** 创建宠物保存数据 */
	protected PetSaveData createPetSaveData(int id,int level)
	{
		PetSaveData saveData=BaseC.factory.createPetSaveData();
		
		saveData.id=id;
		saveData.level=level;
		saveData.isWorking=false;
		
		me.character.newCreateSaveData(saveData);
		
		//添加到组
		_d.petDic.put(saveData.mIndex,saveData);
		
		return saveData;
	}
	
	/** 通过保存数据，创建使用数据 */
	public PetUseData createPetUseDataBySaveData(PetSaveData saveData)
	{
		PetUseData data=BaseC.factory.createPetUseData();
		data.initDefault();
		
		data.level=saveData.level;
		
		me.character.initMUnitUseBySave(data,saveData);
		initPetUseBySave(data,saveData);
		
		return data;
	}
	
	protected void initPetUseBySave(PetUseData data,PetSaveData saveData)
	{
	
	}
	
	/** 通过保存数据初始化 */
	public void initPetUseLogicBySaveData(PetUseLogic logic,PetSaveData saveData)
	{
		PetUseData useData=createPetUseDataBySaveData(saveData);
		
		me.character.initUseLogicByUseData(logic,useData,saveData,Global.isPetNeedEquip,true);
		
		_petDic.put(logic.index,logic);
		
		if(Global.isPetUnique)
		{
			if(_petDicByID.contains(saveData.id))
			{
				me.errorLog("已存在的宠物数据");
			}
			
			_petDicByID.put(saveData.id,logic);
		}
	}
	
	/** 获取宠物 */
	public PetUseLogic getPet(int mIndex)
	{
		return _petDic.get(mIndex);
	}
	
	/** 添加宠物 */
	protected void addPet(PetSaveData saveData)
	{
		PetUseLogic logic=_petUseLogicPool.getOne();
		initPetUseLogicBySaveData(logic,saveData);
		
		me.send(AddPetRequest.create((PetUseData)logic.getData()));
		
		Ctrl.print("添加宠物",logic.index);
	}
	
	/** 移除宠物 */
	public void removePet(int index)
	{
		PetUseLogic logic=getPet(index);
		
		if(logic==null)
		{
			me.warningInfoCode(InfoCodeType.RemovePet_notExist,index);
			return;
		}
		
		GameScene scene=me.scene.getScene();
		
		if(scene!=null)
		{
			if(logic.isWorking())
			{
				logic.setIsWorking(false);
				scene.removeUnit(logic.unit.instanceID);
				logic.unit=null;
			}
		}
		
		int id=logic.getData().id;
		
		logic.dispose();
		
		_d.petDic.remove(index);
		_petDic.remove(index);
		
		if(Global.isPetUnique)
		{
			_petDicByID.remove(id);
		}
		
		_petUseLogicPool.back(logic);
		
		me.send(RemovePetRequest.create(index));
	}
	
	/** 添加宠物通过GM */
	public void addPetByGM(int id)
	{
		PetSaveData saveData=createPetSaveData(id,1);
		addPet(saveData);
	}
	
	/** 检查当前是否可出战 */
	protected boolean checkCanWork(PetUseLogic logic)
	{
		return true;
	}
	
	/** 宠物出战 */
	public void petWork(int mIndex)
	{
		PetUseLogic logic=getPet(mIndex);
		
		if(logic==null)
		{
			me.warningInfoCode(InfoCodeType.PetWork_notExist,mIndex);
			return;
		}
		
		if(logic.isWorking())
		{
			me.warningInfoCode(InfoCodeType.PetWork_isWorkingNow,mIndex);
			return;
		}
		
		if(!checkCanWork(logic))
		{
			me.warningInfoCode(InfoCodeType.PetWork_cantWork,mIndex);
			return;
		}
		
		Unit unit=me.scene.getUnit();
		
		if(unit==null)
		{
			me.warningInfoCode(InfoCodeType.PetWork_sceneNotExist,mIndex);
			return;
		}
		
		logic.setIsWorking(true);
		me.scene.getScene().gameInOut.addMUnitByMaster(unit,logic,true);
		
		me.send(RefreshPetIsWorkingRequest.create(logic.index,true));
	}
	
	/** 宠物休息 */
	public void petRest(int mIndex)
	{
		PetUseLogic logic=getPet(mIndex);
		
		if(logic==null)
		{
			me.warningInfoCode(InfoCodeType.PetReset_notExist,mIndex);
			return;
		}
		
		if(!logic.isWorking())
		{
			me.warningInfoCode(InfoCodeType.PetReset_isNotWorkingNow,mIndex);
			return;
		}
		
		logic.setIsWorking(false);
		
		Unit unit=logic.unit;
		
		if(unit!=null)
		{
			GameScene scene=me.scene.getScene();
			
			if(scene!=null)
			{
				scene.removeUnit(logic.unit.instanceID);
				logic.unit=null;
			}
			else
			{
				me.errorLog("宠物休息时，不改找不到场景");
			}
		}
		
		me.send(RefreshPetIsWorkingRequest.create(logic.index,false));
	}
	
}