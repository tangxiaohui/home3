using ShineEngine;

/// <summary>
/// 系统(generated by shine)
/// </summary>
public class SystemPart:PlayerBasePart
{
	/** 数据 */
	private SystemPartData _d;
	
	/** 是否初始化好 */
	private bool _inited=false;
	
	/// <summary>
	/// 当前在线状态
	/// </summary>
	protected bool _isOnline=false;
	
	/// <summary>
	/// 临时计算变量
	/// </summary>
	protected IntList _tempClientRandomSeeds=new IntList();
	
	protected IntList _clientRandomSeeds=new IntList();
	
	public override void setData(BaseData data)
	{
		base.setData(data);
		
		_d=(SystemPartData)data;
	}
	
	/// <summary>
	/// 获取数据
	/// </summary>
	public SystemPartData getPartData()
	{
		return _d;
	}
	
	/// <summary>
	/// 构造函数(只在new后调用一次,再次从池中取出不会调用)
	/// </summary>
	public override void construct()
	{

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
		_inited=false;
		_isOnline=false;
	}
	
	/// <summary>
	/// 从库中读完数据后(做数据的补充解析)(onNewCreate后也会调用一次)(主线程)
	/// </summary>
	public override void afterReadData()
	{
		// if(!ShineSetting.isOfficial)
		// {
		// 	GameC.clientGm.setServerCmdSet(_d.gmCommandSet);
		// }

		if(isOnline())
		{
			DateControl.setCurrentTime(_d.serverTime);

			if(CommonSetting.useOfflineGame)
			{
				GameC.offline.getExData().serverOffTime=DateControl.getOffTime();
			}
		}
		else
		{
			if(CommonSetting.useOfflineGame)
			{
				DateControl.setOffTime(GameC.offline.getExData().serverOffTime);
			}
		}

		refreshGMType(_d.gmType);
	}
	
	public override void beforeLogin()
	{
		base.beforeLogin();
		
		if (CommonSetting.needClientRandomSeeds)
		{
			makeClientRandomSeeds();
		}
	}
	
	protected void makeClientRandomSeeds()
	{
		_tempClientRandomSeeds.clear();
		_clientRandomSeeds.clear();

		int len=Global.clientRandomSeedNum;

		for (int i = 0; i < len; ++i)
		{
			_tempClientRandomSeeds.add(i);
		}

		for (int i = len-1; i >=0; --i)
		{
			int index=(_d.clientRandomSeedKey^(len-6*i))&i;
			_clientRandomSeeds.add(_tempClientRandomSeeds.remove(index));
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
		long time=me.getTimeMillis();

		_d.loginDate=time;
		_d.logoutDate=time;
		_d.nextDailyTime=DateControl.getNextDailyTime();

		_d.clientRandomSeedIndex=0;
		_d.clientRandomSeeds=ObjectUtils.EmptyIntArr;
	}
	
	protected override BaseData createPartData()
	{
		return new SystemPartData();
	}
	
	public override void onSecond(int delay)
	{
		if(CommonSetting.useOfflineGame && isOfflineRunning())
		{
			//检测onDaily
			checkDaily();
		}
	}
	
	/// <summary>
	/// 检查是否到了每天间隔
	/// </summary>
	public void checkDaily()
	{
		if(me.getTimeMillis()>=_d.nextDailyTime)
		{
			long nextDailyTimeT=DateControl.getNextDailyTime();

			if(_d.nextDailyTime!=nextDailyTimeT)
			{
				_d.nextDailyTime=nextDailyTimeT;

				//每天调用
				me.onDaily();
			}
		}
	}
	
	/// <summary>
	/// 设置初始化
	/// </summary>
	public void setInited(bool value)
	{
		_inited=value;
	}
	
	/// <summary>
	/// 是否初始化过(数据)
	/// </summary>
	public bool inited()
	{
		return _inited;
	}
	
	/// <summary>
	/// 获取保存boolean值
	/// </summary>
	public bool getKeepBoolean(int key)
	{
		return _d.keepSave.booleanDic.get(key);
	}
	
	/// <summary>
	/// 获取保存int值
	/// </summary>
	public int getKeepInt(int key)
	{
		return _d.keepSave.intDic.get(key);
	}
	
	/// <summary>
	/// 获取保存long值
	/// </summary>
	public long getKeepLong(int key)
	{
		return _d.keepSave.longDic.get(key);
	}
	
	/// <summary>
	/// 获取保存string值
	/// </summary>
	public string getKeepString(string key)
	{
		return _d.keepSave.stringDic.get(key);
	}
	
	/// <summary>
	/// 保存baalean值
	/// </summary>
	public void saveKeepBoolean(int key,bool value)
	{
		_d.keepSave.booleanDic.put(key,value);

		SaveBooleanRequest.create(key,value).send();
	}
	
	/// <summary>
	/// 保存int值
	/// </summary>
	public void saveKeepInt(int key,int value)
	{
		_d.keepSave.intDic.put(key,value);

		SaveIntRequest.create(key,value).send();
	}
	
	/// <summary>
	/// 保存long值
	/// </summary>
	public void saveKeepLong(int key,long value)
	{
		_d.keepSave.longDic.put(key,value);

		SaveLongRequest.create(key,value).send();
	}
	
	/// <summary>
	/// 保存string值
	/// </summary>
	public void saveKeepString(string key,string value)
	{
		_d.keepSave.stringDic.put(key,value);

		SaveStringRequest.create(key,value).send();
	}
	
	/// <summary>
	/// 设置服务器时间
	/// </summary>
	public void serServerTime(long serveTime)
	{
		_d.serverTime=serveTime;
		DateControl.setCurrentTime(serveTime);

		me.dispatch(GameEventType.RefreshServerOffTime);
	}
	
	/// <summary>
	/// 获取种子序号
	/// </summary>
	public int getSeedIndex()
	{
		return _d.clientRandomSeedIndex;
	}
	
	/// <summary>
	/// 设置种子序号
	/// </summary>
	public void setSeedIndex(int v)
	{
		_d.clientRandomSeedIndex=v;
	}
	
	private int getNextSeed()
	{
		int seed=_clientRandomSeeds.get(_d.clientRandomSeedIndex);

		if(++_d.clientRandomSeedIndex>=_clientRandomSeeds.length())
		{
			_d.clientRandomSeedIndex=0;
		}

		return seed;
	}
	
	/// <summary>
	/// 获取下个客户端随机结果(ratio:千分位)
	/// </summary>
	public bool getClientRandom(int ratio)
	{
		return getNextSeed()/Global.clientRandomSeedNum*1000<ratio;
	}
	
	/// <summary>
	/// 客户端随机一个整形
	/// </summary>
	public int clientRandomInt(int range)
	{
		return getNextSeed()*range/Global.clientRandomSeedNum;
	}
	
	/// <summary>
	/// 客户端随机一个整形
	/// </summary>
	public bool clientRandomProb(int prob,int max)
	{
		if(prob >= max)
		{
			return true;
		}

		if(prob<=0)
		{
			return false;
		}

		int seed=getNextSeed();

		return (float)seed/Global.clientRandomSeedNum<(float)prob / max;
	}
	
	public virtual void setOnline(bool value)
	{
		if(_isOnline==value)
			return;

		_isOnline=value;

		onlineChanged();
	}
	
	protected virtual void onlineChanged()
	{

	}
	
	/// <summary>
	/// 是否当前处于在线游戏状态
	/// </summary>
	public bool isOnline()
	{
		return _isOnline;
	}
	
	/// <summary>
	/// 当前是否离线运行中
	/// </summary>
	public bool isOfflineRunning()
	{
		return !_isOnline && _inited;
	}
	
	public virtual void refreshGMType(int type)
	{
		_d.gmType = type;

		//非release，默认开启
		if (!ShineSetting.isRelease)
		{
			CommonSetting.useReporter = true;
		}
		else
		{
			GMTypeConfig gmTypeConfig = GMTypeConfig.get(_d.gmType);
			if (gmTypeConfig!=null)
			{
				CommonSetting.useReporter = gmTypeConfig.repoterAble;
			}
			else
			{
				CommonSetting.useReporter = false;
			}
		}
		
		GameC.nativeUI.refreshReporter();
	}
	
	/// <summary>
	/// 收到服务器添加信息码
	/// </summary>
	public void onAddInfoLog(InfoLogData data)
	{
		SQueue<InfoLogData> queue;
		(queue=_d.logQueue).offer(data);

		if(queue.size()>Global.infoLogKeepNum)
		{
			queue.poll();
		}

		me.dispatch(GameEventType.RefreshInfoLog,data);
	}
	
}