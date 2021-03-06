using ShineEngine;

/// <summary>
/// 奖励表(generated by shine)
/// </summary>
public class RewardConfig:BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<RewardConfig> _dic;
	
	/// <summary>
	/// id
	/// </summary>
	public int id;
	
	/// <summary>
	/// 奖励货币组等级公式
	/// </summary>
	public int[][] currencyLevelFormula;
	
	/// <summary>
	/// 奖励货币组(固定)
	/// </summary>
	public DIntData[] currency;
	
	/// <summary>
	/// 随机物品组
	/// </summary>
	public int randomListID;
	
	/// <summary>
	/// 奖励角色经验
	/// </summary>
	public long roleExp;
	
	/// <summary>
	/// 奖励角色经验等级公式
	/// </summary>
	public int[] roleExpLevelFormula;
	
	/// <summary>
	/// 奖励物品组(固定)
	/// </summary>
	public DIntData[] items;
	
	/// <summary>
	/// 是否需要等级适配
	/// </summary>
	public bool needLevelAdapter;
	
	/// <summary>
	/// 需要格子数(如果不填，则有程序计算长度)
	/// </summary>
	public int needGrid;
	
	/** 展示物品组 */
	private SList<ItemData> _showItems;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static RewardConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(IntObjectMap<RewardConfig> dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(IntObjectMap<RewardConfig> dic)
	{
		_dic.putAll(dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static IntObjectMap<RewardConfig> getDic()
	{
		return _dic;
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		int currencyLen=stream.readLen();
		if(this.currency==null || this.currency.Length!=currencyLen)
		{
			this.currency=new DIntData[currencyLen];
		}
		DIntData[] currencyT=this.currency;
		for(int currencyI=0;currencyI<currencyLen;++currencyI)
		{
			DIntData currencyV;
			currencyV=(DIntData)stream.createData(DIntData.dataID);
			currencyV.readBytesSimple(stream);
			
			currencyT[currencyI]=currencyV;
		}
		
		int currencyLevelFormulaLen=stream.readLen();
		if(this.currencyLevelFormula==null || this.currencyLevelFormula.Length!=currencyLevelFormulaLen)
		{
			this.currencyLevelFormula=new int[currencyLevelFormulaLen][];
		}
		int[][] currencyLevelFormulaT=this.currencyLevelFormula;
		for(int currencyLevelFormulaI=0;currencyLevelFormulaI<currencyLevelFormulaLen;++currencyLevelFormulaI)
		{
			int[] currencyLevelFormulaV;
			int currencyLevelFormulaVLen=stream.readLen();
			currencyLevelFormulaV=new int[currencyLevelFormulaVLen];
			int[] currencyLevelFormulaVT=currencyLevelFormulaV;
			for(int currencyLevelFormulaVI=0;currencyLevelFormulaVI<currencyLevelFormulaVLen;++currencyLevelFormulaVI)
			{
				int currencyLevelFormulaVV;
				currencyLevelFormulaVV=stream.readInt();
				
				currencyLevelFormulaVT[currencyLevelFormulaVI]=currencyLevelFormulaVV;
			}
			
			currencyLevelFormulaT[currencyLevelFormulaI]=currencyLevelFormulaV;
		}
		
		int itemsLen=stream.readLen();
		if(this.items==null || this.items.Length!=itemsLen)
		{
			this.items=new DIntData[itemsLen];
		}
		DIntData[] itemsT=this.items;
		for(int itemsI=0;itemsI<itemsLen;++itemsI)
		{
			DIntData itemsV;
			itemsV=(DIntData)stream.createData(DIntData.dataID);
			itemsV.readBytesSimple(stream);
			
			itemsT[itemsI]=itemsV;
		}
		
		this.randomListID=stream.readInt();
		
		this.roleExp=stream.readLong();
		
		int roleExpLevelFormulaLen=stream.readLen();
		if(this.roleExpLevelFormula==null || this.roleExpLevelFormula.Length!=roleExpLevelFormulaLen)
		{
			this.roleExpLevelFormula=new int[roleExpLevelFormulaLen];
		}
		int[] roleExpLevelFormulaT=this.roleExpLevelFormula;
		for(int roleExpLevelFormulaI=0;roleExpLevelFormulaI<roleExpLevelFormulaLen;++roleExpLevelFormulaI)
		{
			int roleExpLevelFormulaV;
			roleExpLevelFormulaV=stream.readInt();
			
			roleExpLevelFormulaT[roleExpLevelFormulaI]=roleExpLevelFormulaV;
		}
		
		this.needGrid=stream.readInt();
		
		this.needLevelAdapter=stream.readBoolean();
		
	}
	
	/// <summary>
	/// 读完所有表后处理
	/// </summary>
	public static void afterReadConfigAll()
	{
		if(_dic==null)
			return;

		RewardConfig[] values;
		RewardConfig v;

		for(int i=(values=_dic.getValues()).Length-1;i>=0;--i)
		{
			if((v=values[i])!=null)
			{
				if(v.needGrid>0)
				{
					continue;
				}
				
				v.needGrid=v.items.Length;
				
				if(v.randomListID>0)
				{
					v.needGrid+=RandomItemListConfig.get(v.randomListID).getNeedGridNum();
				}
			}
		}
	}
	
	/// <summary>
	/// 获取展示物品组
	/// </summary>
	public SList<ItemData> getShowItems()
	{
		if(_showItems==null)
		{
			_showItems=new SList<ItemData>();
			makeShowItems(_showItems);
		}

		return _showItems;
	}
	
	/// <summary>
	/// 构造显示数据
	/// </summary>
	protected virtual void makeShowItems(SList<ItemData> list)
	{
		foreach(DIntData v in items)
		{
			list.add(BaseC.logic.createItem(v));
		}

		if(randomListID>0)
		{
			RandomItemListConfig randomItemListConfig=RandomItemListConfig.get(randomListID);

			foreach(DIntData v in randomItemListConfig.showItems)
			{
				list.add(BaseC.logic.createItem(v));
			}
		}
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		if(this.currency!=null)
		{
			DIntData[] currencyT=this.currency;
			stream.writeLen(currencyT.Length);
			for(int currencyVI=0,currencyVLen=currencyT.Length;currencyVI<currencyVLen;++currencyVI)
			{
				DIntData currencyV=currencyT[currencyVI];
				if(currencyV!=null)
				{
					currencyV.writeBytesSimple(stream);
				}
				else
				{
					nullObjError("currencyV");
				}
				
			}
		}
		else
		{
			nullObjError("currency");
		}
		
		if(this.currencyLevelFormula!=null)
		{
			int[][] currencyLevelFormulaT=this.currencyLevelFormula;
			stream.writeLen(currencyLevelFormulaT.Length);
			for(int currencyLevelFormulaVI=0,currencyLevelFormulaVLen=currencyLevelFormulaT.Length;currencyLevelFormulaVI<currencyLevelFormulaVLen;++currencyLevelFormulaVI)
			{
				int[] currencyLevelFormulaV=currencyLevelFormulaT[currencyLevelFormulaVI];
				if(currencyLevelFormulaV!=null)
				{
					int[] currencyLevelFormulaVT=currencyLevelFormulaV;
					stream.writeLen(currencyLevelFormulaVT.Length);
					for(int currencyLevelFormulaVVI=0,currencyLevelFormulaVVLen=currencyLevelFormulaVT.Length;currencyLevelFormulaVVI<currencyLevelFormulaVVLen;++currencyLevelFormulaVVI)
					{
						int currencyLevelFormulaVV=currencyLevelFormulaVT[currencyLevelFormulaVVI];
						stream.writeInt(currencyLevelFormulaVV);
						
					}
				}
				else
				{
					nullObjError("currencyLevelFormulaV");
				}
				
			}
		}
		else
		{
			nullObjError("currencyLevelFormula");
		}
		
		if(this.items!=null)
		{
			DIntData[] itemsT=this.items;
			stream.writeLen(itemsT.Length);
			for(int itemsVI=0,itemsVLen=itemsT.Length;itemsVI<itemsVLen;++itemsVI)
			{
				DIntData itemsV=itemsT[itemsVI];
				if(itemsV!=null)
				{
					itemsV.writeBytesSimple(stream);
				}
				else
				{
					nullObjError("itemsV");
				}
				
			}
		}
		else
		{
			nullObjError("items");
		}
		
		stream.writeInt(this.randomListID);
		
		stream.writeLong(this.roleExp);
		
		if(this.roleExpLevelFormula!=null)
		{
			int[] roleExpLevelFormulaT=this.roleExpLevelFormula;
			stream.writeLen(roleExpLevelFormulaT.Length);
			for(int roleExpLevelFormulaVI=0,roleExpLevelFormulaVLen=roleExpLevelFormulaT.Length;roleExpLevelFormulaVI<roleExpLevelFormulaVLen;++roleExpLevelFormulaVI)
			{
				int roleExpLevelFormulaV=roleExpLevelFormulaT[roleExpLevelFormulaVI];
				stream.writeInt(roleExpLevelFormulaV);
				
			}
		}
		else
		{
			nullObjError("roleExpLevelFormula");
		}
		
		stream.writeInt(this.needGrid);
		
		stream.writeBoolean(this.needLevelAdapter);
		
	}
	
}
