using ShineEngine;
using UnityEngine;

/// <summary>
/// 通用功能(generated by shine)
/// </summary>
public class FuncPart:PlayerBasePart
{
	/** 数据 */
	private FuncPartData _d;
	
	/** 功能插件字典 */
	private IntObjectMap<FuncTool>[] _funcToolDic=new IntObjectMap<FuncTool>[FuncToolType.size];
	
	/** 功能插件列表 */
	private SList<FuncTool> _funcToolList=new SList<FuncTool>();
	
	/** 功能插件列表 */
	private SList<IPlayerFuncTool> _playerFuncToolList=new SList<IPlayerFuncTool>();
	
	public override void setData(BaseData data)
	{
		base.setData(data);
		
		_d=(FuncPartData)data;
	}
	
	/// <summary>
	/// 获取数据
	/// </summary>
	public FuncPartData getPartData()
	{
		return _d;
	}
	
	/// <summary>
	/// 构造函数(只在new后调用一次,再次从池中取出不会调用)
	/// </summary>
	public override void construct()
	{
		SubsectionRankConfig.getDic().forEachValue(v=>{

			PlayerFuncTool funcTool;

			funcTool=new PlayerSubsectionRankTool(v.id);

			registFuncTool(funcTool);

			if (v.needPageTool)
			{
				((PlayerSubsectionRankTool)funcTool).bindPageShowTool(v.eachPageShowNum);
			}
		});
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
		FuncTool[] values=_funcToolList.getValues();

		for(int i=0,len=_funcToolList.size();i<len;++i)
		{
			values[i].init();
		}
	}
	
	/// <summary>
	/// 析构(回池前调用,与init成对)
	/// </summary>
	public override void dispose()
	{
		FuncTool[] values=_funcToolList.getValues();
		FuncTool v;

		for(int i=0,len=_funcToolList.size();i<len;++i)
		{
			(v=values[i]).dispose();

			if(v.isAdded)
			{
				removeFuncTool(v);
			}
		}
	}
	
	/// <summary>
	/// 从库中读完数据后(做数据的补充解析)(onNewCreate后也会调用一次)(主线程)
	/// </summary>
	public override void afterReadData()
	{
		_d.funcTools.forEach((k,v)=>
		{
			if(v!=null)
			{
				v.forEach((k1,v1)=>
				{
					FuncTool funcTool=getFuncTool(k,k1);

					if(funcTool!=null)
					{
						funcTool.setData(v1);
					}
					else
					{
						Ctrl.errorLog("找不到功能插件type:",k,"funcID:",k1);
					}
				});
			}
		});
	}
	
	public override void afterReadDataSecond()
	{
		SList<IPlayerFuncTool> list;
		IPlayerFuncTool[] values=(list=_playerFuncToolList).getValues();

		for(int i=list.size()-1;i>=0;--i)
		{
			values[i].afterReadDataSecond();
		}
	}
	
	/// <summary>
	/// 每秒调用
	/// </summary>
	public override void onSecond(int delay)
	{
		FuncTool[] values=_funcToolList.getValues();

		for(int i=0,len=_funcToolList.size();i<len;++i)
		{
			values[i].onSecond(delay);
		}
	}
	
	/// <summary>
	/// 配置表更新后(配置替换)
	/// </summary>
	public override void onReloadConfig()
	{
		FuncTool[] values=_funcToolList.getValues();

		for(int i=0,len=_funcToolList.size();i<len;++i)
		{
			values[i].onReloadConfig();
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
	
	public override void onDaily()
	{
		IntObjectMap<FuncTool> dic=getFuncToolDic(FuncToolType.RoleGroup);

		dic.forEachValue(v=>
		{
			PlayerRoleGroupTool tool=(PlayerRoleGroupTool)v;

			tool.getRoleGroupDic().forEachValue(v2=>
			{
				v2.onDaily();
			});
		});

	}
	
	public override void onNewCreate()
	{
		_d.funcTools=new IntObjectMap<IntObjectMap<FuncToolData>>();

		SList<FuncTool> list;
		FuncTool[] values=(list=_funcToolList).getValues();
		FuncTool v;

		for(int i=list.size()-1;i>=0;--i)
		{
			v=values[i];

			FuncToolData toolData=v.getNewCreateData();

			if(toolData!=null)
			{
				_d.funcTools.computeIfAbsent(v.getType(),k=>new IntObjectMap<FuncToolData>()).put(v.getFuncID(),toolData);
			}
		}
	}
	
	/// <summary>
	/// 功能是否开启
	/// </summary>
	public bool isFunctionOpen(int id)
	{
		return _d.funcOpenSet.contains(id);
	}
	
	/// <summary>
	/// 获取功能插件组(没有就创建)
	/// </summary>
	public IntObjectMap<FuncTool> getFuncToolDic(int type)
	{
		IntObjectMap<FuncTool> dic=_funcToolDic[type];
		
		if(dic==null)
		{
			return _funcToolDic[type]=new IntObjectMap<FuncTool>();
		}
		else
		{
			return dic;
		}
	}
	
	/// <summary>
	/// 注册功能插件
	/// </summary>
	public FuncTool registFuncTool(IPlayerFuncTool tool)
	{
		toRegistFuncTool(tool);

		return (FuncTool) tool;
	}
	
	private void toRegistFuncTool(IPlayerFuncTool tool)
	{
		FuncTool fTool=(FuncTool)tool;

		IntObjectMap<FuncTool> dic=getFuncToolDic(fTool.getType());

		int funcID=fTool.getFuncID();

		if(ShineSetting.openCheck)
		{
			if(dic.contains(funcID))
			{
				Ctrl.throwError("已经存在功能插件:",fTool.getType(),funcID);
			}
		}

		//设置主角
		tool.setMe(me);

		dic.put(funcID,fTool);
		_funcToolList.add(fTool);
		_playerFuncToolList.add(tool);
		fTool.construct();
	}
	
	/// <summary>
	/// 添加功能插件(数据不在FuncTool存，而是自行维护,也需要funcID)
	/// </summary>
	public void addFuncTool(IPlayerFuncTool tool,FuncToolData data)
	{
		FuncTool fTool=(FuncTool)tool;

		fTool.isAdded=true;
		toRegistFuncTool(tool);
		fTool.setData(data);
		tool.afterReadDataSecond();
	}
	
	/// <summary>
	/// 移除功能插件
	/// </summary>
	public void removeFuncTool(FuncTool tool)
	{
		if(!tool.isAdded)
		{
			Ctrl.throwError("不可删除非added的FuncTool");
			return;
		}

		_funcToolList.removeObj(tool);
		_playerFuncToolList.removeObj((IPlayerFuncTool)tool);

		IntObjectMap<FuncTool> dic=getFuncToolDic(tool.getType());
		dic.remove(tool.getFuncID());
	}
	
	/// <summary>
	/// 获取功能拆件
	/// </summary>
	public FuncTool getFuncTool(int type,int funcID)
	{
		return getFuncToolDic(type).get(funcID);
	}
	
	/// <summary>
	/// 获取排行榜工具
	/// </summary>
	public PlayerRankTool getRankTool(int funcID)
	{
		return (PlayerRankTool)getFuncTool(FuncToolType.Rank,funcID);
	}
	
	/// <summary>
	/// 获取排行榜工具
	/// </summary>
	public PlayerSubsectionRankTool getSubsectionRankTool(int funcID)
	{
		return (PlayerSubsectionRankTool)getFuncTool(FuncToolType.SubsectionRank,funcID);
	}
	
	/// <summary>
	/// 获取玩集群排行榜工具
	/// </summary>
	public PlayerRoleGroupRankTool getRoleGroupRankTool(int funcID)
	{
		return (PlayerRoleGroupRankTool)getFuncTool(FuncToolType.Rank,funcID);
	}
	
	/// <summary>
	/// 获取翻页显示工具
	/// </summary>
	public PlayerPageShowTool getPageShowTool(int funcID)
	{
		return (PlayerPageShowTool)getFuncTool(FuncToolType.PageShow,funcID);
	}
	
	/// <summary>
	/// 获取分段翻页显示工具
	/// </summary>
	public PlayerSubsectionPageShowTool getSubsectionPageShowTool(int funcID)
	{
		return (PlayerSubsectionPageShowTool)getFuncTool(FuncToolType.SubsectionPageShow,funcID);
	}
	
	/// <summary>
	/// 获取物品容器工具
	/// </summary>
	public BaseItemContainerTool getBaseItemContainerTool(int funcID)
	{
		FuncTool funcTool=getFuncTool(FuncToolType.ItemContainer,funcID);

		if(funcTool==null)
			funcTool=getFuncTool(FuncToolType.ItemDicContainer,funcID);

		return (BaseItemContainerTool)funcTool;
	}
	
	protected override BaseData createPartData()
	{
		return new FuncPartData();
	}
	
	/// <summary>
	/// 获取物品容器工具
	/// </summary>
	public PlayerItemContainerTool getItemContainerTool(int funcID)
	{
		return (PlayerItemContainerTool)getFuncTool(FuncToolType.ItemContainer,funcID);
	}
	
	/// <summary>
	/// 获取物品字典容器工具
	/// </summary>
	public PlayerItemDicContainerTool getItemDicContainerTool(int funcID)
	{
		return (PlayerItemDicContainerTool)getFuncTool(FuncToolType.ItemDicContainer,funcID);
	}
	
	/// <summary>
	/// 获取装备容器工具
	/// </summary>
	public PlayerEquipContainerTool getEquipContainerTool(int funcID)
	{
		return (PlayerEquipContainerTool)getFuncTool(FuncToolType.EquipContainer,funcID);
	}
	
	/// <summary>
	/// 获取玩家群工具
	/// </summary>
	public PlayerRoleGroupTool getRoleGroupTool(int funcID)
	{
		return (PlayerRoleGroupTool)getFuncTool(FuncToolType.RoleGroup,funcID);
	}
	
	/// <summary>
	/// 检测某条件的功能开启
	/// </summary>
	public void checkFunctionsForCondition(int type)
	{
		IntObjectMap<FunctionConfig> dic=FunctionConfig.conditionDic.get(type);

		if(dic==null)
			return;

		toCheckDic(dic);
	}
	
	protected void toCheckDic(IntObjectMap<FunctionConfig> dic)
	{
		//不是客户端驱动
		if(!CommonSetting.isClientDriveLogic)
			return;

		FunctionConfig[] values;
		FunctionConfig v;

		for(int i=(values=dic.getValues()).Length-1;i>=0;--i)
		{
			if((v=values[i])!=null)
			{
				if(isFunctionOpen(v.id))
				{
					if(v.needClose && checkConditions(v.closeConditions))
					{
						closeFunction(v.id);
					}
				}
				else
				{
					if(checkConditions(v.openConditions))
					{
						openFunction(v.id);
					}
				}
			}
		}
	}
	
	protected bool checkConditions(int[][] arr)
	{
		foreach(int[] args in arr)
		{
			if(!checkOneFuncCondition(args))
				return false;
		}

		return true;
	}
	
	/// <summary>
	/// 检查单个功能条件
	/// </summary>
	protected virtual bool checkOneFuncCondition(int[] args)
	{
		switch(args[0])
		{
			case FunctionConditionType.Level:
			{
				return me.role.getLevel()>=args[1];
			}
			case FunctionConditionType.FunctionOpen:
			{
				return isFunctionOpen(args[1]);
			}
			case FunctionConditionType.NeedUnion:
			{
				return me.union!=null && me.union.hasUnion();
			}
			case FunctionConditionType.QuestComplete:
			{
				return me.quest.isQuestComplete(args[1]);
			}
		}

		return false;
	}
	
	/// <summary>
	/// 检测某条件的功能开启
	/// </summary>
	public void checkAllFunctions()
	{
		toCheckDic(FunctionConfig.getDic());
	}
	
	public void openFunction(int id)
	{
		if(_d.funcOpenSet.add(id))
		{
			me.dispatch(GameEventType.FunctionOpen,id);

			me.func.onFunctionOpen(id);
		}
	}
	
	public void closeFunction(int id)
	{
		if(_d.funcOpenSet.remove(id))
		{
			me.dispatch(GameEventType.FunctionClose,id);

			me.func.onFunctionClose(id);
		}
	}
	
}
