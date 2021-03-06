package com.home.commonGame.part.player.part;
import com.home.commonBase.baseData.BaseClientPartData;
import com.home.commonBase.config.game.AchievementConfig;
import com.home.commonBase.constlist.generate.CallWayType;
import com.home.commonBase.constlist.generate.FunctionType;
import com.home.commonBase.constlist.generate.InfoCodeType;
import com.home.commonBase.data.quest.AchievementCompleteData;
import com.home.commonBase.data.quest.AchievementData;
import com.home.commonBase.data.quest.AchievementSaveData;
import com.home.commonBase.data.quest.TaskData;
import com.home.commonBase.part.player.clientData.AchievementClientPartData;
import com.home.commonBase.part.player.data.AchievementPartData;
import com.home.commonGame.control.LogicExecutor;
import com.home.commonGame.net.request.quest.SendAcceptAchievementRequest;
import com.home.commonGame.net.request.quest.SendAchievementCompleteRequest;
import com.home.commonGame.net.request.quest.SendGetAchievementRewardSuccessRequest;
import com.home.commonGame.part.player.base.PlayerBasePart;
import com.home.shine.ctrl.Ctrl;
import com.home.shine.data.BaseData;
import com.home.shine.support.collection.IntList;
import com.home.shine.support.collection.IntObjectMap;

/** 成就(generated by shine) */
public class AchievementPart extends PlayerBasePart
{
	/** 数据 */
	private AchievementPartData _d;
	
	/** 运行中的成就数据 */
	private IntObjectMap<AchievementData> _runningAchievementDic=new IntObjectMap<>(AchievementData[]::new);
	
	@Override
	public void setData(BaseData data)
	{
		super.setData(data);
		
		_d=(AchievementPartData)data;
	}
	
	/** 获取数据 */
	public AchievementPartData getPartData()
	{
		return _d;
	}
	
	@Override
	protected BaseData createPartData()
	{
		return new AchievementPartData();
	}
	
	@Override
	protected BaseClientPartData createClientData()
	{
		return new AchievementClientPartData();
	}
	
	/** 写客户端数据(copyServer过后的) */
	@Override
	protected void writeClientData(BaseClientPartData data)
	{
		toWriteClientData((AchievementClientPartData)data);
	}
	
	/** 写客户端数据具体执行(已执行过copyServer了,就是说CPO中与SPO同名同类型的属性无需再赋值) */
	private void toWriteClientData(AchievementClientPartData data)
	{
		data.runningDatas=_runningAchievementDic;
	}
	
	/** 构造函数(只在new后调用一次,再次从池中取出不会调用) */
	@Override
	public void construct()
	{
		
		me.quest.registTaskCompleteFunc(FunctionType.Achievement,this::taskComplete);
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
		IntObjectMap<AchievementData> runningAchievementDic=_runningAchievementDic;
		
		if(!runningAchievementDic.isEmpty())
		{
			runningAchievementDic.forEachValueAndClear(v->
			{
				releaseAchievementData(v);
			});
		}
	}
	
	/** 从库中读完数据后(做数据的补充解析)(onNewCreate后也会调用一次)(主线程) */
	@Override
	public void afterReadData()
	{
		IntObjectMap<AchievementSaveData> runningDatas=_d.runningDatas;
		IntObjectMap<AchievementCompleteData> completeDatas=_d.completeDatas;
		
		AchievementConfig.getDic().forEachValue(v->
		{
			AchievementSaveData sData;
			//在运行组中
			if((sData=runningDatas.get(v.id))!=null)
			{
				addRunningAchievement(v,sData.num,false);
			}
			else
			{
				//不在完成组中
				if(!completeDatas.contains(v.id) && checkCanAcceptAchievement(v))
				{
					addRunningAchievement(v,false);
				}
			}
		});
	}
	
	/** 配置表更新后(配置替换) */
	@Override
	public void onReloadConfig()
	{
		_runningAchievementDic.forEachValue(v->
		{
			v.task.reloadConfig();
		});
	}
	
	/** 新创建时(该主对象在服务器上第一次被创建时的动作(一生只一次),(只对数据赋值就好,自定义数据构造的部分写到afterReadData里,因为这个完事儿就会回调到)) */
	@Override
	public void onNewCreate()
	{
	
	}
	
	/** 构造数据前 */
	@Override
	protected void beforeMakeData()
	{
		IntObjectMap<AchievementSaveData> runningDatas=_d.runningDatas;
		
		_runningAchievementDic.forEachValue(v->
		{
			//开始了
			if(v.task.num>0)
			{
				AchievementSaveData sData;
				if((sData=runningDatas.get(v.id))==null)
				{
					sData=new AchievementSaveData();
					sData.id=v.id;
					runningDatas.put(sData.id,sData);
				}
				
				sData.num=v.task.num;
			}
		});
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
	
	private AchievementData createAchievementData()
	{
		LogicExecutor executor;
		
		if((executor=me.getExecutor())!=null)
		{
			return executor.achievementDataPool.getOne();
		}
		
		return new AchievementData();
	}
	
	private void releaseAchievementData(AchievementData data)
	{
		LogicExecutor executor;
		
		if((executor=me.getExecutor())!=null)
		{
			executor.achievementDataPool.back(data);
		}
	}
	
	/** 成就是否完成 */
	public boolean isAchievementComplete(int id)
	{
		return _d.completeDatas.get(id)!=null;
	}
	
	/** 检查并添加成就 */
	protected void checkAndAccept(int id,boolean needSend)
	{
		AchievementConfig config;
		
		if(checkCanAcceptAchievement(config=AchievementConfig.get(id)))
		{
			addRunningAchievement(config,needSend);
		}
	}
	
	protected boolean checkCanAcceptAchievement(AchievementConfig config)
	{
		//已接
		if(_d.runningDatas.contains(config.id))
			return false;
		
		for(int v : config.pres)
		{
			if(!isAchievementComplete(v))
			{
				return false;
			}
		}
		
		return true;
	}
	
	/** 检查是否可接成就 */
	protected void addRunningAchievement(AchievementConfig config,boolean needSend)
	{
		addRunningAchievement(config,0,needSend);
	}
	
	/** 添加运行中成就 */
	protected void addRunningAchievement(AchievementConfig config,int num,boolean needSend)
	{
		AchievementData data=createAchievementData();
		data.id=config.id;
		data.task=me.quest.createTaskByID(config.taskID,FunctionType.Achievement,config.id,num);
		
		_runningAchievementDic.put(data.id,data);
		
		if(needSend)
		{
			me.send(SendAcceptAchievementRequest.create(data));
		}
		
		me.quest.addRunningTask(data.task);
	}
	
	private void taskComplete(TaskData data)
	{
		AchievementData aData=_runningAchievementDic.get(data.mainID);
		
		if(aData==null)
		{
			Ctrl.throwError("不该找不到成就,任务id",data.id,"成就id",data.mainID);
			return;
		}
		
		int achievementID=aData.id;
		
		//回收
		me.quest.removeRunningTask(data);
		me.quest.releaseTask(data);
		
		//双移除
		_runningAchievementDic.remove(achievementID);
		_d.runningDatas.remove(achievementID);
		//回收
		releaseAchievementData(aData);
		
		AchievementCompleteData cData=new AchievementCompleteData();
		cData.id=achievementID;
		cData.hasGotReward=false;
		cData.time=me.getTimeMillis();
		
		_d.completeDatas.put(achievementID,cData);
		
		me.send(SendAchievementCompleteRequest.create(achievementID));
		
		onAchievementComplete(achievementID);
	}
	
	/** 完成成就 */
	protected void onAchievementComplete(int id)
	{
		AchievementConfig config=AchievementConfig.get(id);
		
		IntList list;
		if(!(list=config.afters).isEmpty())
		{
			int[] values=list.getValues();
			
			for(int i=0,len=list.size();i<len;++i)
			{
				checkAndAccept(values[i],true);
			}
		}
	}
	
	/** 领取奖励 */
	public void getReward(int id)
	{
		AchievementCompleteData cData=_d.completeDatas.get(id);
		
		if(cData==null)
		{
			me.warningInfoCode(InfoCodeType.Achievement_achievementNotExist,id);
			return;
		}
		
		if(cData.hasGotReward)
		{
			me.warningInfoCode(InfoCodeType.Achievement_alreadyGet);
			return;
		}
		
		AchievementConfig config=AchievementConfig.get(id);
		
		//有奖励
		if(config.rewardID>0)
		{
			if(!me.bag.addReward(config.rewardID,CallWayType.GetAchievementReward))
			{
				me.warningInfoCode(InfoCodeType.Achievement_bagNotEnough);
				return;
			}
		}
		
		cData.hasGotReward=true;
		
		//领取成功
		me.send(SendGetAchievementRewardSuccessRequest.create(id));
	}
	
}
