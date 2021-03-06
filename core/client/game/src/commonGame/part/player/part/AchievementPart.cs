using ShineEngine;

/// <summary>
/// 成就(generated by shine)
/// </summary>
public class AchievementPart:PlayerBasePart
{
	/** 数据 */
	private AchievementPartData _d;
	
	public override void setData(BaseData data)
	{
		base.setData(data);
		
		_d=(AchievementPartData)data;
	}
	
	/// <summary>
	/// 获取数据
	/// </summary>
	public AchievementPartData getPartData()
	{
		return _d;
	}
	
	/// <summary>
	/// 构造函数(只在new后调用一次,再次从池中取出不会调用)
	/// </summary>
	public override void construct()
	{
		me.quest.registTaskRefreshFunc(FunctionType.Achievement,taskRefresh);
		me.quest.registTaskCompleteFunc(FunctionType.Achievement,taskComplete);
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
		AchievementData[] values;
		AchievementData v;

		for(int i=(values=_d.runningDatas.getValues()).Length-1;i>=0;--i)
		{
			if((v=values[i])!=null)
			{
				//重新构造
				me.quest.reMakeTask(v.task,FunctionType.Achievement,v.id);
				//添加执行目标
				me.quest.addRunningTask(v.task);
			}
		}
	}
	
	/// <summary>
	/// 配置表更新后(配置替换)
	/// </summary>
	public override void onReloadConfig()
	{
		foreach(AchievementData v in _d.runningDatas)
		{
			v.task.reloadConfig();
		}
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
	
	private AchievementData createAchievementData()
	{
		// LogicExecutor executor;
		//
		// if((executor=me.getExecutor())!=null)
		// {
		// 	return executor.achievementDataPool.getOne();
		// }

		return new AchievementData();
	}
	
	private void releaseAchievementData(AchievementData data)
	{
		//TODO:池化

		// LogicExecutor executor;
		//
		// if((executor=me.getExecutor())!=null)
		// {
		// 	executor.achievementDataPool.back(data);
		// }
	}
	
	/// <summary>
	/// 获取运行中成就
	/// </summary>
	public AchievementData getRunningAchievement(int id)
	{
		return _d.runningDatas.get(id);
	}
	
	/// <summary>
	/// 获取完成成就
	/// </summary>
	public AchievementCompleteData getCompleteAchievement(int id)
	{
		return _d.completeDatas.get(id);
	}
	
	/// <summary>
	/// 成就是否完成
	/// </summary>
	public bool isAchievementComplete(int id)
	{
		return _d.completeDatas.get(id)!=null;
	}
	
	/// <summary>
	/// 检查并添加成就
	/// </summary>
	protected void checkAndAccept(int id)
	{
		AchievementConfig config;

		if(checkCanAcceptAchievement(config=AchievementConfig.get(id)))
		{
			addRunningAchievement(config);
		}
	}
	
	/// <summary>
	/// 添加运行中成就
	/// </summary>
	protected void addRunningAchievement(AchievementConfig config)
	{
		AchievementData data=createAchievementData();
		data.id=config.id;
		data.task=me.quest.createTaskByID(config.taskID,FunctionType.Achievement,config.id,0);

		_d.runningDatas.put(data.id,data);

		me.quest.addRunningTask(data.task);
	}
	
	/// <summary>
	/// 检查是否可接成就
	/// </summary>
	protected bool checkCanAcceptAchievement(AchievementConfig config)
	{
		//已接
		if(_d.runningDatas.contains(config.id))
			return false;

		foreach(int v in config.pres)
		{
			if(!isAchievementComplete(v))
			{
				return false;
			}
		}

		return true;
	}
	
	private void taskRefresh(TaskData data)
	{
		AchievementData aData=_d.runningDatas.get(data.mainID);

		if(aData==null)
		{
			Ctrl.throwError("不该找不到成就",data.id,data.mainID);
			return;
		}

		me.dispatch(GameEventType.RefreshAchievement,aData.id);
	}
	
	private void taskComplete(TaskData data)
	{
		AchievementData aData=_d.runningDatas.get(data.mainID);

		if(aData==null)
		{
			Ctrl.throwError("不该找不到成就",data.id,data.mainID);
			return;
		}

		if(CommonSetting.isClientDriveLogic)
		{
			//回收
			me.quest.removeRunningTask(data);
			me.quest.releaseTask(data);

			toComplete(aData.id);
		}
	}
	
	private void toComplete(int id)
	{
		//双移除
		_d.runningDatas.remove(id);

		AchievementCompleteData cData=new AchievementCompleteData();
		cData.id=id;
		cData.hasGotReward=false;
		cData.time=me.getTimeMillis();

		_d.completeDatas.put(id,cData);

		me.dispatch(GameEventType.RefreshAchievement,id);
		me.dispatch(GameEventType.CompleteAchievement,id);

		onAchievementComplete(id);
	}
	
	/// <summary>
	/// 完成成就，g层可复写
	/// </summary>
	protected virtual void onAchievementComplete(int id)
	{
		if(CommonSetting.isClientDriveLogic)
		{
			AchievementConfig config=AchievementConfig.get(id);

			IntList list;
			if(!(list=config.afters).isEmpty())
			{
				int[] values=list.getValues();

				for(int i=0,len=list.size();i<len;++i)
				{
					checkAndAccept(values[i]);
				}
			}
		}

	}
	
	/// <summary>
	/// 成就完成
	/// </summary>
	public void onAchievementCompleteByServer(int id)
	{
		AchievementData aData=_d.runningDatas.get(id);

		if(aData==null)
		{
			return;
		}

		toComplete(id);
	}
	
	public void onAcceptAchievementByServer(AchievementData data)
	{
		_d.runningDatas.put(data.id,data);
		me.quest.reMakeTask(data.task,FunctionType.Achievement,data.id);
		data.task.reloadConfig();
		me.quest.addRunningTask(data.task);
	}
	
	/// <summary>
	/// 领取成就奖励
	/// </summary>
	public void getReward(int id)
	{
		AchievementCompleteData cData=_d.completeDatas.get(id);

		if(cData==null)
		{
			me.warnLog("领取成就奖励时,找不到完成成就",id);
			return;
		}

		if(cData.hasGotReward)
		{
			me.warnLog("领取成就奖励时,已经领过",id);
			return;
		}

		AchievementConfig config=AchievementConfig.get(id);

		if(config.rewardID>0)
		{
			if(!me.bag.hasRewardPlace(config.rewardID))
			{
				me.warnLog("领取成就奖励时,背包空间不足",id);
				return;
			}
		}

		me.send(GetAchievementRewardRequest.create(id));
	}
	
	/// <summary>
	/// 收到服务器领取成就奖励
	/// </summary>
	public void onGetReward(int id)
	{
		AchievementCompleteData cData=_d.completeDatas.get(id);

		if(cData==null)
		{
			me.warnLog("收到领取成就奖励时,找不到完成成就",id);
			return;
		}

		cData.hasGotReward=true;

		me.dispatch(GameEventType.RefreshAchievement,id);
		me.dispatch(GameEventType.GetAchievementReward,id);
	}
	
	protected override BaseData createPartData()
	{
		return new AchievementPartData();
	}
	
}
