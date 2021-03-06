using ShineEngine;
using System;

/// <summary>
/// 任务(generated by shine)
/// </summary>
public class QuestPart:PlayerBasePart
{
	/** 数据 */
	private QuestPartData _d;
	
	/** 运行中的任务目标 */
	private IntObjectMap<TaskData> _runningTaskDic=new IntObjectMap<TaskData>();
	
	/// <summary>
	/// 执行目标类型组(单键)
	/// </summary>
	protected IntObjectMap<IntObjectMap<TaskData>> _runningTaskTypeOneDic=new IntObjectMap<IntObjectMap<TaskData>>();
	
	/// <summary>
	/// 执行目标类型组(双键)
	/// </summary>
	protected LongObjectMap<IntObjectMap<TaskData>> _runningTaskTypeTwoDic=new LongObjectMap<IntObjectMap<TaskData>>();
	
	/// <summary>
	/// 执行目标类型组(双键)
	/// </summary>
	protected LongObjectMap<IntObjectMap<TaskData>> _runningTaskTypeTwoDic2=new LongObjectMap<IntObjectMap<TaskData>>();
	
	/** 刷新回调组 */
	private IntObjectMap<Action<TaskData>> _taskRefreshFuncDic=new IntObjectMap<Action<TaskData>>();
	
	/** 完成回调组 */
	private IntObjectMap<Action<TaskData>> _taskCompleteFuncDic=new IntObjectMap<Action<TaskData>>();
	
	/** 粗略可接组 */
	private IntObjectMap<QuestConfig> _waitAcceptQuests=new IntObjectMap<QuestConfig>();
	
	/** 可接任务列表 */
	private IntObjectMap<QuestConfig> _canAcceptQuests=new IntObjectMap<QuestConfig>();
	
	/** 可视任务列表 */
	private IntObjectMap<QuestConfig> _canSeeQuests=new IntObjectMap<QuestConfig>();
	
	private int[] _tempArr=new int[1];
	
	public override void setData(BaseData data)
	{
		base.setData(data);
		
		_d=(QuestPartData)data;
	}
	
	/// <summary>
	/// 获取数据
	/// </summary>
	public QuestPartData getPartData()
	{
		return _d;
	}
	
	/// <summary>
	/// 构造函数(只在new后调用一次,再次从池中取出不会调用)
	/// </summary>
	public override void construct()
	{
		registTaskRefreshFunc(FunctionType.Quest,taskRefreshForQuest);
		registTaskCompleteFunc(FunctionType.Quest,taskCompleteForQuest);
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
		clearOneRunning(_runningTaskTypeOneDic.getValues());
		clearOneRunning(_runningTaskTypeTwoDic.getValues());
	}
	
	private void clearOneRunning(IntObjectMap<TaskData>[] values)
	{
		IntObjectMap<TaskData> v;

		for(int i=values.Length-1;i>=0;--i)
		{
			if((v=values[i])!=null)
			{
				if(!v.isEmpty())
				{
					int[] keys2=v.getKeys();
					TaskData[] values2=v.getValues();
					int fv2=v.getFreeValue();
					TaskData v2;

					for(int i2=keys2.Length-1;i2>=0;--i2)
					{
						if((keys2[i2])!=fv2)
						{
							v2=values2[i2];

							releaseTask(v2);

							keys2[i2]=fv2;
							values2[i2]=null;
						}
					}

					v.justClearSize();
				}
			}
		}
	}
	
	/// <summary>
	/// 从库中读完数据后(做数据的补充解析)(onNewCreate后也会调用一次)(主线程)
	/// </summary>
	public override void afterReadData()
	{
		foreach(QuestData data in _d.accepts)
		{
			data.makeConfig();

			foreach(TaskData v in data.tasks)
			{
				reMakeTask(v,FunctionType.Quest,data.id);
			}

			addRunningQuest(data);
		}

		countWaitAcceptQuests();
		countCanAcceptAndCanSeeQuests();
	}
	
	/// <summary>
	/// 每秒调用
	/// </summary>
	public override void afterReadDataSecond()
	{
		foreach(QuestData v in _d.accepts)
		{
			if(v.isComplete())
			{
				preQuestComplete(v);
			}
		}

		foreach(IntObjectMap<TaskData> dic in _runningTaskTypeOneDic)
		{
			checkTaskDic(dic);
		}

		foreach(IntObjectMap<TaskData> dic in _runningTaskTypeTwoDic)
		{
			checkTaskDic(dic);
		}
	}
	
	/// <summary>
	/// 每秒调用
	/// </summary>
	public override void onSecond(int delay)
	{
		long now=me.getTimeMillis();

		QuestData[] values;
		QuestData v;

		for(int i=(values=_d.accepts.getValues()).Length-1;i>=0;--i)
		{
			if((v=values[i])!=null)
			{
				//有有效时间
				if(!v.isFailed && !v.config.failTimeT.isEmpty() && now>=v.enableTime)
				{
					preQuestFailed(v);
				}
			}
		}

		foreach(QuestCompleteData v1 in _d.completeQuestsDic)
		{
			//超时
			if(now>=v1.reTime)
			{
				//移除
				_d.completeQuestsDic.remove(v1.id);
			}
		}

	}
	
	/// <summary>
	/// 配置表更新后(配置替换)
	/// </summary>
	public override void onReloadConfig()
	{
		QuestData[] values;
		QuestData v;

		for(int i=(values=_d.accepts.getValues()).Length-1;i>=0;--i)
		{
			if((v=values[i])!=null)
			{
				foreach(TaskData tData in v.tasks)
				{
					tData.reloadConfig();
				}
			}
		}

		foreach(IntObjectMap<TaskData> v1 in _runningTaskTypeOneDic)
		{
			v1.forEachValue(v2=>v2.reloadConfig());
		}

		foreach(IntObjectMap<TaskData> v1 in _runningTaskTypeTwoDic)
		{
			v1.forEachValue(v2=>v2.reloadConfig());
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
	
	public override void onNewCreate()
	{
		_d.clientTaskInstanceIDIndex=ShineSetting.indexMaxHalf;

		//接取首次任务
		IntList list=QuestConfig.initQuests;

		if(!list.isEmpty())
		{
			int[] values=list.getValues();
			QuestConfig config;

			for(int i=0,len=list.size();i<len;++i)
			{
				config=QuestConfig.get(values[i]);

				if(me.role.checkRoleConditions(config.acceptConditions,false))
				{
					doAcceptQuest(config);
				}
			}
		}
	}
	
	private void checkTaskDic(IntObjectMap<TaskData> dic)
	{
		foreach(TaskData v2 in dic)
		{
			if(v2.isComplete())
			{
				taskComplete(v2);
			}
		}
	}
	
	/// <summary>
	/// 注册目标刷新回调(construct阶段用)
	/// </summary>
	public void registTaskRefreshFunc(int funcID,Action<TaskData> func)
	{
		if(ShineSetting.openCheck)
		{
			if(_taskRefreshFuncDic.contains(funcID))
			{
				Ctrl.throwError("registTaskRefreshFunc时,重复的功能ID",funcID);
			}
		}

		_taskRefreshFuncDic.put(funcID,func);
	}
	
	/// <summary>
	/// 注册目标完成回调(construct阶段用)
	/// </summary>
	public void registTaskCompleteFunc(int funcID,Action<TaskData> func)
	{
		if(ShineSetting.openCheck)
		{
			if(_taskCompleteFuncDic.contains(funcID))
			{
				Ctrl.throwError("registTaskCompleteFunc时,重复的功能ID",funcID);
			}
		}

		_taskCompleteFuncDic.put(funcID,func);
	}
	
	/// <summary>
	/// 创建任务目标数据(只创建类)
	/// </summary>
	protected virtual TaskData toCreateTaskData(int type)
	{
		return GameC.pool.createTaskData(type);
	}
	
	/// <summary>
	/// 回收任务目标
	/// </summary>
	public void releaseTask(TaskData data)
	{
		GameC.pool.releaseTaskData(data.config.type,data);
	}
	
	/** 回收任务数据 */
	private void releaseQuest(QuestData data)
	{
		foreach(TaskData v in data.tasks)
		{
			releaseTask(v);
		}

		data.clear();

		//TODO:QuestData回收
	}
	
	/// <summary>
	/// 获取任务目标(运行中的)
	/// </summary>
	public TaskData getTask(int instanceID)
	{
		return _runningTaskDic.get(instanceID);
	}
	
	/// <summary>
	/// 获取已接任务
	/// </summary>
	public QuestData getAcceptQuest(int id)
	{
		return _d.accepts.get(id);
	}
	
	/// <summary>
	/// 任务是否已接
	/// </summary>
	public bool isQuestAccept(int id)
	{
		return _d.accepts.contains(id);
	}
	
	/// <summary>
	/// 获取可接任务列表
	/// </summary>
	public IntObjectMap<QuestConfig> getCanAcceptQuests()
	{
		return _canAcceptQuests;
	}
	
	/// <summary>
	/// 获取可见任务列表
	/// </summary>
	public IntObjectMap<QuestConfig> getCanSeeQuests()
	{
		return _canSeeQuests;
	}
	
	/// <summary>
	/// 获取某任务是否完成
	/// </summary>
	public bool isQuestComplete(int id)
	{
		return isQuestComplete(QuestConfig.get(id));
	}
	
	/** 获取某任务是否完成 */
	private bool isQuestComplete(QuestConfig config)
	{
		if(_d.completeIDs.contains(config.id))
			return true;

		DIntData line;
		//有值
		if(!(line=config.questLine).isEmpty())
		{
			return line.value<=_d.completeLines.getOrDefault(line.key,-1);
		}

		QuestCompleteData cData;

		if((cData=_d.completeQuestsDic.get(config.id))!=null)
		{
			return cData.isSuccess;
		}

		return false;
	}
	
	/// <summary>
	/// 获取某任务是否失败
	/// </summary>
	public bool isQuestFailed(int id)
	{
		QuestData data;
		if((data=_d.accepts.get(id))!=null)
		{
			return data.isFailed;
		}

		QuestCompleteData cData;
		if((cData=_d.completeQuestsDic.get(id))!=null)
		{
			return !cData.isSuccess;
		}

		return false;
	}
	
	/// <summary>
	/// 通过id创建任务目标
	/// </summary>
	public TaskData createTaskByID(int id,int funcID,int mainID)
	{
		return createTaskByID(id,funcID,mainID,0);
	}
	
	/// <summary>
	/// 通过id创建任务目标
	/// </summary>
	public TaskData createTaskByID(int id,int funcID,int mainID,int num)
	{
		if(!CommonSetting.isClientDriveLogic)
			Ctrl.throwError("客户端不支持自行创建目标");

		TaskConfig config=TaskConfig.get(id);

		TaskData taskData=toCreateTaskData(config.type);
		taskData.id=config.id;
		taskData.config=config;
		taskData.funcID=funcID;
		taskData.mainID=mainID;
		taskData.num=num;

		//初始化给值
		if(num==0 && config.initNum>0)
		{
			taskData.num=config.initNum;
		}

		taskData.instanceID=++_d.clientTaskInstanceIDIndex;

		refreshTaskData(taskData);

		return taskData;
	}
	
	/// <summary>
	/// 重建任务目标数据(afterRead阶段)
	/// </summary>
	public void reMakeTask(TaskData data,int funcID,int mainID)
	{
		data.config=TaskConfig.get(data.id);
		data.funcID=funcID;
		data.mainID=mainID;

		refreshTaskData(data);
	}
	
	/// <summary>
	/// 预接任务
	/// </summary>
	protected void preDoAcceptQuest(QuestConfig config)
	{
		//TODO:找NPC
		doAcceptQuest(config);
	}
	
	/** 执行接取任务 */
	private void doAcceptQuest(QuestConfig config)
	{
		if(CommonSetting.isClientDriveLogic)
		{
			QuestData qData=GameC.factory.createQuestData();
			qData.id=config.id;
			qData.makeConfig();

			int[] list=config.tasks;

			TaskData[] tasks=qData.tasks=new TaskData[list.Length];

			for(int i=0;i<list.Length;i++)
			{
				tasks[i]=createTaskByID(list[i],FunctionType.Quest,config.id);
			}

			if(config.failTimeT!=null)
			{
				qData.enableTime=config.failTimeT.getNextTime();
			}
			else
			{
				qData.enableTime=0L;
			}

			//成功接取任务后 把任务道具给玩家
			DIntData[] questItem=config.questItem;
			if(questItem.Length>0)
			{
				me.bag.addItems(questItem,1,CallWayType.AcceptQuest);
			}

			doAcceptQuest(qData);
		}
		else
		{
			me.send(AcceptQuestRequest.create(config.id));
		}
	}
	
	/** 执行接取任务 */
	private void doAcceptQuest(QuestData data)
	{
		_d.accepts.put(data.id,data);

		bool isComplete=data.isComplete();

		if(!isComplete)
		{
			addRunningQuest(data);
		}

		_waitAcceptQuests.remove(data.id);
		_canAcceptQuests.remove(data.id);
		_canSeeQuests.remove(data.id);


		//推送
		me.dispatch(GameEventType.RefreshCanAcceptQuests);
		me.dispatch(GameEventType.RefreshCanSeeQuests);
		me.dispatch(GameEventType.AcceptQuest,data.id);

		if(isComplete)
		{
			preQuestComplete(data);
		}
	}
	
	private void addRunningQuest(QuestData data)
	{
		TaskData[] tasks=data.tasks;
		TaskData tData;

		//串行
		if(data.config.executeType==QuestExecuteType.Serial)
		{
			for(int i=0;i<tasks.Length;i++)
			{
				//未完成,或刷新式的
				if(!(tData=tasks[i]).isComplete())
				{
					//只加一次
					doAddRunningTask(tData);
					break;
				}
			}
		}
		//并行或任意
		else
		{
			for(int i=0;i<tasks.Length;i++)
			{
				//未完成,或刷新式的
				if(!(tData=tasks[i]).isComplete() || TaskTypeConfig.get(tData.config.type).needUpdate)
				{
					doAddRunningTask(tData);
				}
			}
		}
	}
	
	/// <summary>
	/// 添加执行目标
	/// </summary>
	public void addRunningTask(TaskData data)
	{
		refreshTaskData(data);

		doAddRunningTask(data);

		//直接完成
		if(data.isComplete())
		{
			taskComplete(data);
		}
	}
	
	/** 执行添加任务目标 */
	private void doAddRunningTask(TaskData data)
	{
		_runningTaskDic.put(data.instanceID,data);

		TaskTypeConfig tConfig;
		//双键
		if((tConfig=TaskTypeConfig.get(data.config.type)).needSecondKey)
		{
			_runningTaskTypeTwoDic.computeIfAbsent((long)data.config.type<<32 | data.config.args[1],k=>new IntObjectMap<TaskData>()).put(data.instanceID,data);

			if(tConfig.needSecondKey2)
			{
				_runningTaskTypeTwoDic2.computeIfAbsent((long)data.config.type<<32 | data.config.args[2],k=>new IntObjectMap<TaskData>()).put(data.instanceID,data);
			}
		}
		//单键
		else
		{
			_runningTaskTypeOneDic.computeIfAbsent(data.config.type,k=>new IntObjectMap<TaskData>()).put(data.instanceID,data);
		}
	}
	
	/// <summary>
	/// 移除执行目标
	/// </summary>
	public void removeRunningTask(TaskData data)
	{
		_runningTaskDic.remove(data.instanceID);

		TaskTypeConfig tConfig;

		IntObjectMap<TaskData> dic;
		//双键
		if((tConfig=TaskTypeConfig.get(data.config.type)).needSecondKey)
		{
			if((dic=_runningTaskTypeTwoDic.get((long)data.config.type << 32 | data.config.args[1]))!=null)
				dic.remove(data.instanceID);

			if(tConfig.needSecondKey2)
			{
				if((dic=_runningTaskTypeTwoDic2.get((long)data.config.type << 32 | data.config.args[2]))!=null)
					dic.remove(data.instanceID);
			}
		}
		//单键
		else
		{
			if((dic=_runningTaskTypeOneDic.get(data.config.type))!=null)
			{
				dic.remove(data.instanceID);
			}
		}
	}
	
	/** 目标刷新 */
	private void taskRefresh(TaskData data)
	{
		Action<TaskData> func;

		if((func=_taskRefreshFuncDic.get(data.funcID))==null)
			return;

		func(data);
	}
	
	/** 目标完成 */
	private void taskComplete(TaskData data)
	{
		//先移除
		if(!TaskTypeConfig.get(data.config.type).needUpdate)
		{
			removeRunningTask(data);
		}

		Action<TaskData> func;

		if((func=_taskCompleteFuncDic.get(data.funcID))==null)
		{
			Ctrl.throwError("找不到注册的task回调");
			return;
		}

		func(data);
	}
	
	/** 目标刷新 */
	private void taskRefreshForQuest(TaskData data)
	{
		QuestData qData=_d.accepts.get(data.mainID);

		if(qData==null)
		{
			Ctrl.throwError("不该找不到任务");
			return;
		}

		me.dispatch(GameEventType.RefreshOneQuest,qData.id);
	}
	
	/** 目标完成 */
	private void taskCompleteForQuest(TaskData data)
	{
		QuestData qData=_d.accepts.get(data.mainID);

		if(qData==null)
		{
			Ctrl.throwError("不该找不到任务");
			return;
		}

		//完成
		if(qData.isComplete())
		{
			preQuestComplete(qData);
		}
		else
		{
			//串行
			if(qData.config.executeType==QuestExecuteType.Serial)
			{
				removeRunningTask(data);

				int index=ObjectUtils.arrayIndexOf(qData.tasks,data);

				if(index==-1)
				{
					Ctrl.throwError("不该找不到任务目标索引");
				}

				//添加下一个
				addRunningTask(qData.tasks[index+1]);
			}
		}
	}
	
	/** 任务失败 */
	private void preQuestFailed(QuestData data)
	{
		if(CommonSetting.isClientDriveLogic)
		{
			toQuestFailed(data);
		}
		else
		{
			//等服务器推
		}
	}
	
	private void toQuestFailed(QuestData data)
	{
		data.isFailed=true;
		addCompleteRecord(data.config,false);
		me.dispatch(GameEventType.QuestFaied,data.id);
	}
	
	/** 任务预备完成 */
	private void preQuestComplete(QuestData data)
	{
		//TODO:客户端任务完成

		switch(data.config.commitType)
		{
			case QuestCommitType.Auto:
			{
				toCommitQuest(data,true);
			}
				break;
			case QuestCommitType.ByNPC:
			{
				toCommitQuest(data,true);
			}
				break;
		}
	}
	
	/** 添加完成记录 */
	private void addCompleteRecord(QuestConfig config,bool isSuccess)
	{
		switch(config.repeatType)
		{
			case QuestRepeatType.Once:
			{
				//胜利记录
				if(isSuccess)
				{
					DIntData questLine;
					if(!(questLine=config.questLine).isEmpty())
					{
						//更高
						if(questLine.value>_d.completeLines.getOrDefault(questLine.key,-1))
						{
							_d.completeLines.put(questLine.key,questLine.value);
						}
					}
					else
					{
						_d.completeIDs.add(config.id);
					}

					checkWaitAcceptQuestByComplete(config);
				}
			}
				break;
			case QuestRepeatType.Cycle:
			{
				QuestCompleteData cData=_d.completeQuestsDic.get(config.id);

				if(cData==null)
				{
					cData=new QuestCompleteData();
					cData.id=config.id;
					_d.completeQuestsDic.put(config.id,cData);
				}

				//下个时间
				cData.reTime=config.cycleTimeT.getNextTime();
				cData.isSuccess=isSuccess;
			}
				break;
		}
	}
	
	/// <summary>
	/// 移除配置记录
	/// </summary>
	public void removeCompleteRecord(QuestConfig config)
	{
		switch(config.repeatType)
		{
			case QuestRepeatType.Once:
			{
				if(!config.questLine.isEmpty())
				{
					Ctrl.throwError("不可删除链式任务结构数据");
				}
				else
				{
					_d.completeIDs.remove(config.id);
				}
			}
				break;
			case QuestRepeatType.Cycle:
			{
				_d.completeQuestsDic.remove(config.id);
			}
				break;
		}
	}
	
	/** 移除已接任务 */
	private void removeAcceptQuest(QuestData data)
	{
		_d.accepts.remove(data.id);

		//全部移除
		foreach(TaskData v in data.tasks)
		{
			removeRunningTask(v);
		}
	}
	
	/** 提交任务 */
	private void doCommitQuest(QuestData data)
	{
		QuestConfig config=data.config;

		removeAcceptQuest(data);

		addCompleteRecord(data.config,true);
		//回收
		releaseQuest(data);

		checkReAddWaitAccept(config);

		me.dispatch(GameEventType.CommitQuest,config.id);
	}
	
	/** 执行完成任务 */
	private void toCommitQuest(QuestData data,bool isAbs)
	{
		if(CommonSetting.isClientDriveLogic)
		{
			QuestConfig config=data.config;

			//删除任务道具
			DIntData[] questItemArr=config.questItem;
			if(questItemArr.Length>0)
			{
				//如果需要删除任务道具
				me.bag.removeItems(questItemArr,1,CallWayType.CommitQuest);
			}

			//执行任务完成动作组
			me.role.doRoleActions(config.completeActions,1,CallWayType.CommitQuest);

			//有奖励
			if(data.config.rewardID>0)
			{
				//奖励
				if(isAbs)
				{
					me.bag.addRewardAbs(data.config.rewardID,CallWayType.CommitQuest);
				}
				else
				{
					me.bag.addReward(data.config.rewardID,CallWayType.CommitQuest);
				}
			}

			doCommitQuest(data);
		}
		else
		{
			me.send(CommitQuestRequest.create(data.id));
		}
	}
	
	/// <summary>
	/// 任务目标事件
	/// </summary>
	public void taskEvent(int type)
	{
		taskEvent(type,null);
	}
	
	/// <summary>
	/// 任务目标事件
	/// </summary>
	public void taskEvent(int type,params int[] args)
	{
		TaskTypeConfig config=TaskTypeConfig.get(type);

		doTaskEvent(config,args,false,false);
	}
	
	/// <summary>
	/// 任务更新
	/// </summary>
	public void taskRefresh(int type)
	{
		taskRefresh(type,0,false);
	}
	
	/// <summary>
	/// 任务更新
	/// </summary>
	public void taskRefresh(int type,int secondKey)
	{
		taskRefresh(type,secondKey,false);
	}
	
	/// <summary>
	/// 任务更新
	/// </summary>
	public void taskRefresh(int type,int secondKey,bool useSecond2)
	{
		TaskTypeConfig config=TaskTypeConfig.get(type);

		_tempArr[0]=secondKey;
		doTaskEvent(config,_tempArr,true,useSecond2);
	}
	
	/// <summary>
	/// 执行taskEvent
	/// </summary>
	protected void doTaskEvent(TaskTypeConfig typeConfig,int[] args,bool onlyRefresh,bool useSecond2)
	{
		IntObjectMap<TaskData> dic;

		if((typeConfig=TaskTypeConfig.get(typeConfig.id)).needSecondKey)
		{
			if(useSecond2)
			{
				if((dic=_runningTaskTypeTwoDic2.get((long)typeConfig.id << 32 | args[0]))==null || dic.isEmpty())
					return;
			}
			else
			{
				if((dic=_runningTaskTypeTwoDic.get((long)typeConfig.id << 32 | args[0]))==null || dic.isEmpty())
					return;
			}
		}
		else
		{
			if((dic=_runningTaskTypeOneDic.get(typeConfig.id))==null || dic.isEmpty())
				return;
		}

		//不是客户端执行
		if(!typeConfig.isClientDrive && !CommonSetting.isClientDriveLogic)
		{
			return;
		}

		bool lastIsComplete;
		int lastNum;

		foreach(TaskData v in dic)
		{
			//未完成
			if(!(lastIsComplete=v.isComplete()) || typeConfig.needUpdate)
			{
				lastNum=v.num;

				if(onlyRefresh)
				{
					refreshTaskData(v);
				}
				else
				{
					toTaskEvent(v,args);
				}

				//有变化
				if(lastNum!=v.num)
				{
					taskRefresh(v);
				}

				//新的完成
				if(v.isComplete() && !lastIsComplete)
				{
					taskComplete(v);
				}
			}
		}
	}
	
	/** 检查任务可接基础条件 */
	private bool checkQuestCanAcceptFirst(QuestConfig config)
	{
		//已接
		if(_d.accepts.contains(config.id))
			return false;

		//完成
		if(_d.completeIDs.contains(config.id))
			return false;

		//周期完成
		if(_d.completeQuestsDic.contains(config.id))
			return false;

		DIntData line;
		//链完成
		if(!(line=config.questLine).isEmpty() && line.value<=_d.completeLines.getOrDefault(line.key,-1))
			return false;

		//前置未完成
		if(!checkQuestPreAllComplete(config))
		{
			return false;
		}

		return true;
	}
	
	/** 检查某任务的前置是否都完成 */
	private bool checkQuestPreAllComplete(QuestConfig config)
	{
		foreach(int v in config.preQuests)
		{
			if(!isQuestComplete(v))
			{
				return false;
			}
		}

		return true;
	}
	
	/// <summary>
	/// 检查任务是否可接
	/// </summary>
	public bool checkQuestCanAccept(QuestConfig config,bool needNotice)
	{
		if(!checkQuestCanAcceptFirst(config))
		{
			return false;
		}

		if(!checkAcceptConditions(config,needNotice))
		{
			return false;
		}

		return true;
	}
	
	/// <summary>
	/// 检查接受任务条件(只看条件部分)
	/// </summary>
	public bool checkAcceptConditions(QuestConfig config,bool needNotice)
	{
		return me.role.checkRoleConditions(config.acceptConditions,needNotice);
	}
	
	/// <summary>
	/// 检查可视任务条件(只看条件部分)
	/// </summary>
	public bool checkSeeConditions(QuestConfig config)
	{
		foreach(int[] v2 in config.acceptConditions)
		{
			if(!checkOneSeeCondition(v2))
			{
				return false;
			}
		}

		return true;
	}
	
	/// <summary>
	/// 接取任务(执行数据)
	/// </summary>
	public void acceptQuest(int id)
	{
		if(_d.accepts.contains(id))
		{
			me.warnLog("接任务时,任务已接",id);
			return;
		}

		if(isQuestComplete(id))
		{
			me.warnLog("接任务时,任务已完成",id);
			return;
		}

		QuestConfig config=QuestConfig.get(id);

		//任务失败了
		QuestCompleteData cData;
		if((cData=_d.completeQuestsDic.get(id))!=null && !cData.isSuccess)
		{
			//不可接取失败
			if(!config.cantAcceptFailed)
			{
				me.warnLog("接任务时,不可接取已失败的任务",id);
				return;
			}
		}

		foreach(int v in config.preQuests)
		{
			if(!isQuestComplete(v))
			{
				me.warnLog("接任务时,前置任务未完成",id,v);
				return;
			}
		}

		if(!checkAcceptConditions(config,true))
		{
			me.warnLog("接任务时,条件不满足",id);
			return;
		}

		//接任务给任务道具
		DIntData[] questItem=config.questItem;
		if(questItem.Length>0)
		{
			//检测是否有足够的格子放置任务道具
			if(!me.bag.hasItemPlace(questItem))
			{
				me.warnLog("背包没有足够的位置放任务道具",id);
				return;
			}
		}

		preDoAcceptQuest(config);
	}
	
	/// <summary>
	/// 放弃任务
	/// </summary>
	public void giveUpQuest(int id)
	{
		QuestData data=_d.accepts.get(id);

		if(data==null)
		{
			me.warnLog("放弃任务时,任务不存在");
			return;
		}

		//未失败的不可放弃任务
		if(!data.isFailed && !data.config.canGiveUp)
		{
			me.warnLog("放弃任务时,任务未失败并且不可放弃");
			return;
		}

		if(CommonSetting.isClientDriveLogic)
		{
			doGiveUpQuest(data);
		}
		else
		{
			me.send(GiveUpQuestRequest.create(id));
		}
	}
	
	private void doGiveUpQuest(QuestData data)
	{
		QuestConfig config=data.config;

		//没失败
		if(!data.isFailed)
		{
			data.isFailed=true;
			addCompleteRecord(config,false);
		}

		removeAcceptQuest(data);
		releaseQuest(data);

		checkReAddWaitAccept(config);

		me.dispatch(GameEventType.GiveUpQuest,config.id);
	}
	
	/** 检查重新添加到等待接取组 */
	private void checkReAddWaitAccept(QuestConfig config)
	{
		//可接
		if(checkQuestCanAcceptFirst(config))
		{
			_waitAcceptQuests.put(config.id,config);

			if(checkSeeConditions(config))
			{
				_canSeeQuests.put(config.id,config);

				me.dispatch(GameEventType.RefreshCanSeeQuests);
			}

			if(checkAcceptConditions(config,false))
			{
				_canAcceptQuests.put(config.id,config);

				me.dispatch(GameEventType.RefreshCanAcceptQuests);

				// 自动接
				if(config.acceptType==QuestAcceptType.Auto)
				{
					acceptQuest(config.id);
				}
			}
		}
	}
	
	/** 检查等待接取组受到完成任务的影响 */
	private void checkWaitAcceptQuestByComplete(QuestConfig config)
	{
		bool hasSee=false;
		bool hasAccept=false;

		int[] values=config.afterQuests.getValues();

		QuestConfig qConfig;

		for(int i=0,len=config.afterQuests.size();i<len;++i)
		{
			//可接
			if(checkQuestCanAcceptFirst(qConfig=QuestConfig.get(values[i])))
			{
				_waitAcceptQuests.put(qConfig.id,qConfig);

				if(checkSeeConditions(qConfig))
				{
					_canSeeQuests.put(qConfig.id,qConfig);

					hasSee=true;
				}

				if(checkAcceptConditions(qConfig,false))
				{
					_canAcceptQuests.put(qConfig.id,qConfig);

					hasAccept=true;
				}
			}
		}

		if(hasSee)
			me.dispatch(GameEventType.RefreshCanSeeQuests);

		if(hasAccept)
			me.dispatch(GameEventType.RefreshCanAcceptQuests);

		checkAutoAccept();
	}
	
	/// <summary>
	/// 提交任务
	/// </summary>
	public void commitQuest(int id)
	{
		QuestData data=_d.accepts.get(id);

		if(data==null)
		{
			me.warnLog("提交任务时,任务不存在");
			return;
		}

		if(data.isFailed)
		{
			me.warnLog("提交任务时,任务已失败");
			return;
		}

		if(!data.isComplete())
		{
			me.warnLog("提交任务时,任务未完成");
			return;
		}

		if(data.config.rewardID>0)
		{
			if(!me.bag.hasRewardPlace(data.config.rewardID))
			{
				me.warnLog("提交任务时,背包空间不足");

				//提交任务时背包空间不足
				GameC.info.showInfoCode(InfoCodeType.BagNotEnough);
				return;
			}
		}

		toCommitQuest(data,false);
	}
	
	/// <summary>
	/// 客户端任务目标事件
	/// </summary>
	public void clientTaskEvent(int type,params int[] args)
	{
		TaskTypeConfig typeConfig=TaskTypeConfig.get(type);

		if(typeConfig==null)
		{
			me.warnLog("clientTaskEvent时,找不到目标配置",type);
			return;
		}

		if(CommonSetting.isClientDriveLogic)
		{
			taskEvent(type,args);
		}
		else
		{
			if(!typeConfig.isClientDrive)
			{
				me.warnLog("clientTaskEvent时,不可客户端驱动",type);
				return;
			}

			me.send(ClientTaskEventRequest.create(type,args));
		}
	}
	
	/// <summary>
	/// 接任务(gm指令)(并完成所有前置)
	/// </summary>
	public void acceptQuestByGM(int id,bool needPre)
	{
		if(_d.accepts.contains(id))
		{
			me.warnLog("gm接任务时,任务已接",id);
			return;
		}

		if(isQuestComplete(id))
		{
			me.warnLog("gm接任务时,任务已完成",id);
			return;
		}

		if(needPre)
		{
			toCompleteQuestByGm(id);
		}

		doAcceptQuest(QuestConfig.get(id));
	}
	
	/// <summary>
	/// 完成任务(gm指令)(并完成所有前置)
	/// </summary>
	public void commitQuestByGM(int id)
	{
		toCompleteQuestByGm(id);
	}
	
	/// <summary>
	/// 清空所有任务
	/// </summary>
	public void clearAllQuestByGM()
	{
		onClearAllQuest();
	}
	
	/** 完成任务以及前置(gm) */
	private void toCompleteQuestByGm(int id)
	{
		if(isQuestComplete(id))
			return;

		QuestConfig config=QuestConfig.get(id);

		//前置任务
		foreach(int v in config.preQuests)
		{
			toCompleteQuestByGm(v);
		}

		//完成当前
		QuestData qData=_d.accepts.get(id);

		if(qData==null)
		{
			doAcceptQuest(config);

			qData=_d.accepts.get(id);

			//已自动完成
			if(qData==null)
				return;
		}

		toCommitQuest(qData,true);
	}
	
	/// <summary>
	/// 检查单个可视条件
	/// </summary>
	protected virtual bool checkOneSeeCondition(int[] args)
	{
		switch(args[0])
		{
			case RoleConditionType.Level:
			{
				if(me.role.getLevel()+Global.questCanSeeLevelD<args[1])
				{
					return false;
				}
			}
				break;
			case RoleConditionType.FunctionOpen:
			{
				if(!me.func.isFunctionOpen(args[1]))
				{
					return false;
				}
			}
				break;
			case RoleConditionType.NeedUnion:
			{
				if(!me.union.hasUnion())
				{
					return false;
				}
			}
				break;
		}

		return true;
	}
	
	/// <summary>
	/// 更新目标数据
	/// </summary>
	protected virtual void refreshTaskData(TaskData data)
	{
		if(!CommonSetting.isClientDriveLogic)
			return;

		int[] args;

		switch((args=data.config.args)[0])
		{
			case TaskType.Level:
			{
				if(me.role.getLevel()>=args[1])
					data.num=1;
			}
				break;
		}
	}
	
	/// <summary>
	/// 执行目标时间
	/// </summary>
	protected virtual void toTaskEvent(TaskData data,int[] vars)
	{
		int[] args=data.config.args;

		switch(data.config.type)
		{
			case TaskType.WinBattle:
			case TaskType.KillMonster:
			{
				data.num++;
			}
				break;
			case TaskType.Level:
			{
				if(me.role.getLevel()>=args[1])
					data.num=1;
			}
				break;
			case TaskType.FriendNum:
			{
				int num=vars[0];

				if(num>data.num)
				{
					data.num=num;
				}
			}
				break;
			case TaskType.TotalAddCurrency:
			case TaskType.TotalCostCurrency:
			{
				//类型相同
				if(args[1]==vars[0])
				{
					data.num=vars[1];
				}
			}
				break;
		}
	}
	
	/** 统计所有可接任务列表 */
	private void countWaitAcceptQuests()
	{
		IntObjectMap<QuestConfig> dic=QuestConfig.getDic();

		if(dic==null)
			return;

		IntObjectMap<QuestConfig> waitAcceptQuests=_waitAcceptQuests;
		waitAcceptQuests.clear();

		IntObjectMap<QuestData> accepts=_d.accepts;
		IntSet completeIDs=_d.completeIDs;
		IntObjectMap<QuestCompleteData> completeQuestsDic=_d.completeQuestsDic;
		IntIntMap completeLines=_d.completeLines;

		QuestConfig[] values;
		QuestConfig v;
		int questID;
		DIntData line;

		for(int i=(values=dic.getValues()).Length-1;i>=0;--i)
		{
			if((v=values[i])!=null)
			{
				//可主动接
				if(v.acceptType!=QuestAcceptType.Passive)
				{
					questID=v.id;

					//已接
					if(accepts.contains(questID))
						continue;

					//完成
					if(completeIDs.contains(questID))
						continue;

					//周期完成
					if(completeQuestsDic.contains(questID))
						continue;

					//链完成
					if(!(line=v.questLine).isEmpty() && line.value<=completeLines.getOrDefault(line.key,-1))
						continue;

					//前置未完成
					if(!checkQuestPreAllComplete(v))
					{
						continue;
					}

					waitAcceptQuests.put(v.id,v);
				}
			}
		}
	}
	
	/** 统计可接与可见任务列表 */
	private void countCanAcceptAndCanSeeQuests()
	{
		_canAcceptQuests.clear();
		_canSeeQuests.clear();

		QuestConfig[] values;
		QuestConfig v;

		for(int i=(values=_waitAcceptQuests.getValues()).Length-1;i>=0;--i)
		{
			if((v=values[i])!=null)
			{
				if(checkSeeConditions(v))
				{
					_canSeeQuests.put(v.id,v);
				}

				if(checkAcceptConditions(v,false))
				{
					_canAcceptQuests.put(v.id,v);
				}
			}
		}

		me.dispatch(GameEventType.RefreshCanAcceptQuests);
		me.dispatch(GameEventType.RefreshCanSeeQuests);

		checkAutoAccept();
	}
	
	/// <summary>
	/// 任务条件改变
	/// </summary>
	public void questConditionChanged()
	{
		countCanAcceptAndCanSeeQuests();
	}
	
	/// <summary>
	/// 刷新任务目标(服务器)
	/// </summary>
	public void onRefreshTask(int instanceID,int num)
	{
		TaskData data=getTask(instanceID);

		if(data==null)
		{
			me.warnLog("刷新任务目标时,找不到数据");
			return;
		}

		data.num=num;

		taskRefresh(data);
	}
	
	/// <summary>
	/// 接收任务
	/// </summary>
	public void onAcceptQuest(QuestData data)
	{
		data.makeConfig();

		foreach(TaskData v in data.tasks)
		{
			reMakeTask(v,FunctionType.Quest,data.id);
		}

		doAcceptQuest(data);
	}
	
	/// <summary>
	/// 提交任务
	/// </summary>
	public void onCommitQuest(int id)
	{
		QuestData data=_d.accepts.get(id);

		if(data==null)
		{
			me.warnLog("提交任务时,找不到已接任务");
			return;
		}

		doCommitQuest(data);
	}
	
	/// <summary>
	/// 放弃任务
	/// </summary>
	public void onGiveUpQuest(int id)
	{
		QuestData data=_d.accepts.get(id);

		if(data==null)
		{
			me.warnLog("放弃任务时,找不到已接任务");
			return;
		}

		doGiveUpQuest(data);
	}
	
	/// <summary>
	/// 任务失败
	/// </summary>
	public void onQuestFailed(int id)
	{
		QuestData data=_d.accepts.get(id);

		if(data==null)
		{
			me.warnLog("任务失败时,找不到已接任务");
			return;
		}

		toQuestFailed(data);
	}
	
	/// <summary>
	/// 清空所有任务回调(gm用)
	/// </summary>
	public void onClearAllQuest()
	{
		_d.accepts.forEachValueS(data=>
		{
			removeAcceptQuest(data);
		});

		_d.completeIDs.clear();
		_d.completeLines.clear();
		_d.completeQuestsDic.clear();

		countWaitAcceptQuests();
		countCanAcceptAndCanSeeQuests();

		me.dispatch(GameEventType.RefreshAllQuest);
	}
	
	/// <summary>
	/// 删除已接任务
	/// </summary>
	public void onRemoveAcceptQuest(int id)
	{
		QuestData data=_d.accepts.get(id);

		if(data==null)
			return;

		removeAcceptQuest(data);

		me.dispatch(GameEventType.RemoveAcceptQuest,data.id);
	}
	
	protected override BaseData createPartData()
	{
		return new QuestPartData();
	}
	
	private void checkAutoAccept()
	{
		foreach(QuestConfig v in _canAcceptQuests)
		{
			// 自动接
			if(v.acceptType==QuestAcceptType.Auto)
			{
				acceptQuest(v.id);
			}
		}
	}
	
}
