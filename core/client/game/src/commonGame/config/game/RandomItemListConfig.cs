using ShineEngine;

/// <summary>
/// 随机物品组配置(generated by shine)
/// </summary>
public class RandomItemListConfig:BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<RandomItemListConfig> _dic;
	
	/// <summary>
	/// id
	/// </summary>
	public int id;
	
	/// <summary>
	/// 类型
	/// </summary>
	public int type;
	
	/// <summary>
	/// 种子随机类型
	/// </summary>
	public int seedType;
	
	/// <summary>
	/// 展示物品组
	/// </summary>
	public DIntData[] showItems;
	
	/// <summary>
	/// 参数组
	/// </summary>
	public int[][] args;
	
	/** 权重随机插件 */
	private RandomWeightTool _weightTool;
	
	/** 是否统计过 */
	private bool _counted=false;
	
	/// <summary>
	/// 需要格子数
	/// </summary>
	protected int _needGridNum=0;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static RandomItemListConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(IntObjectMap<RandomItemListConfig> dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(IntObjectMap<RandomItemListConfig> dic)
	{
		_dic.putAll(dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static IntObjectMap<RandomItemListConfig> getDic()
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
		
		this.type=stream.readInt();
		
		int argsLen=stream.readLen();
		if(this.args==null || this.args.Length!=argsLen)
		{
			this.args=new int[argsLen][];
		}
		int[][] argsT=this.args;
		for(int argsI=0;argsI<argsLen;++argsI)
		{
			int[] argsV;
			int argsVLen=stream.readLen();
			argsV=new int[argsVLen];
			int[] argsVT=argsV;
			for(int argsVI=0;argsVI<argsVLen;++argsVI)
			{
				int argsVV;
				argsVV=stream.readInt();
				
				argsVT[argsVI]=argsVV;
			}
			
			argsT[argsI]=argsV;
		}
		
		this.seedType=stream.readInt();
		
		int showItemsLen=stream.readLen();
		if(this.showItems==null || this.showItems.Length!=showItemsLen)
		{
			this.showItems=new DIntData[showItemsLen];
		}
		DIntData[] showItemsT=this.showItems;
		for(int showItemsI=0;showItemsI<showItemsLen;++showItemsI)
		{
			DIntData showItemsV;
			showItemsV=(DIntData)stream.createData(DIntData.dataID);
			showItemsV.readBytesSimple(stream);
			
			showItemsT[showItemsI]=showItemsV;
		}
		
	}
	
	/// <summary>
	/// 读完表后处理
	/// </summary>
	protected override void afterReadConfig()
	{
		base.afterReadConfig();

		switch(type)
		{
			case RandomItemListType.WeightRandomList:
			{
				_weightTool=new RandomWeightTool(args);
			}
				break;
		}
	}
	
	/// <summary>
	/// 读完所有表后处理
	/// </summary>
	public static void afterReadConfigAll()
	{
		if(_dic==null)
			return;

		RandomItemListConfig[] values;
		RandomItemListConfig v;

		for(int i=(values=_dic.getValues()).Length-1;i>=0;--i)
		{
			if((v=values[i])!=null)
			{
				switch(v.type)
				{
					case RandomItemListType.SingleItem:
					{
						int itemID=v.args[0][0];
						if(itemID>0 && ItemConfig.get(itemID)==null)
						{
							Ctrl.throwError("找不到物品ID",itemID);
							return;
						}
					}
						break;
					case RandomItemListType.SingleRandomItem:
					{
						int randomItemID=v.args[0][0];

						if(randomItemID>0 && RandomItemConfig.get(randomItemID)==null)
						{
							Ctrl.throwError("找不到随机物品ID",randomItemID);
							return;
						}
					}
						break;
					case RandomItemListType.SumProbRandomItem:
					{
						foreach(int[] v2 in v.args)
						{
							if(v2[1]>0 && RandomItemConfig.get(v2[1])==null)
							{
								Ctrl.throwError("找不到随机物品ID",v2[1]);
								return;
							}
						}
					}
						break;
					case RandomItemListType.WeightRandomList:
					{
						foreach(int[] v2 in v.args)
						{
							if(v2[1]>0 && RandomItemListConfig.get(v2[1])==null)
							{
								Ctrl.throwError("找不到随机物品组ID",v2[1]);
								return;
							}
						}
					}
						break;
				}

				//直接算出统计
				v.getNeedGridNum();
			}
		}
	}
	
	/// <summary>
	/// 获取所占格子数
	/// </summary>
	public int getNeedGridNum()
	{
		if(!_counted)
		{
			_counted=true;

			toCountGridNum();
		}

		return _needGridNum;
	}
	
	/// <summary>
	/// 统计占用格子数目
	/// </summary>
	protected void toCountGridNum()
	{
		switch(type)
		{
			case RandomItemListType.SingleItem:
			{
				if(args[0][0]>0)
				{
					_needGridNum=1;
				}
			}
				break;
			case RandomItemListType.SingleRandomItem:
			{
				if(args[0][0]>0)
				{
					_needGridNum=1;
				}
			}
				break;
			case RandomItemListType.SumProbRandomItem:
			{
				_needGridNum=args.Length;
			}
				break;
			case RandomItemListType.WeightRandomList:
			{
				int max=0;
				int temp;

				foreach(int[] v in args)
				{
					if((temp=get(v[1]).getNeedGridNum())>max)
					{
						max=temp;
					}
				}

				_needGridNum=max;

			}
				break;
		}
	}
	
	/// <summary>
	/// 随机一组物品
	/// </summary>
	public void randomList(SList<ItemData> list,ILogicEntity entity)
	{
		//list 不需要在这里clear ，最外层调用者负责维护
		if (seedType == ClientRandomSeedType.Server)
		{
			Ctrl.throwError("此随机组不支持客户端随机");
			return;
		}
		
		if (seedType == ClientRandomSeedType.Seed && !CommonSetting.needClientRandomSeeds)
		{
			Ctrl.throwError("此随机组模式需要开启客户端随机种子模式");
			return;
		}
		
		switch(type)
		{
			case RandomItemListType.SingleItem:
			{
				int[] arr=args[0];

				if(arr[0]>0)
				{
					list.add(BaseC.logic.createItem(arr[0],arr.Length>1 ? arr[1] : 1));
				}
			}
				break;
			case RandomItemListType.SingleRandomItem:
			{
				int[] arr=args[0];

				if(arr[0]>0)
				{
					ItemData data=RandomItemConfig.get(arr[0]).randomOne(entity,seedType);

					if(data!=null)
					{
						data.num*=(arr.Length>1 ? arr[1] : 1);

						list.add(data);
					}
				}
			}
				break;
			case RandomItemListType.SumProbRandomItem:
			{
				foreach(int[] arr in args)
				{
					bool randomProb = false;
					
					//万分位
					if (seedType == ClientRandomSeedType.Client)
						randomProb = MathUtils.randomProb(arr[0], 10000);
					else
						randomProb = entity.randomProb(arr[0], 10000);

					if(randomProb)
					{
						ItemData data=RandomItemConfig.get(arr[1]).randomOne(entity,seedType);

						if(data!=null)
						{
							int min=arr.Length>2 ? arr[2] : 1;
							int max=arr.Length>3 ? arr[3] : min;

							if(min==max)
							{
								data.num*=min;
							}
							else
							{
								if (seedType == ClientRandomSeedType.Client)
									data.num*=MathUtils.randomRange2(min,max);
								else
									data.num*=entity.randomRange2(min,max);
							}

							list.add(data);
						}
					}
				}
			}
				break;
			case RandomItemListType.WeightRandomList:
			{
				int[] arr=_weightTool.randomForIntArr(entity,seedType);

				if(arr[1]>0)
				{
					get(arr[1]).randomList(list,entity);
				}
			}
				break;
		}
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.type);
		
		if(this.args!=null)
		{
			int[][] argsT=this.args;
			stream.writeLen(argsT.Length);
			for(int argsVI=0,argsVLen=argsT.Length;argsVI<argsVLen;++argsVI)
			{
				int[] argsV=argsT[argsVI];
				if(argsV!=null)
				{
					int[] argsVT=argsV;
					stream.writeLen(argsVT.Length);
					for(int argsVVI=0,argsVVLen=argsVT.Length;argsVVI<argsVVLen;++argsVVI)
					{
						int argsVV=argsVT[argsVVI];
						stream.writeInt(argsVV);
						
					}
				}
				else
				{
					nullObjError("argsV");
				}
				
			}
		}
		else
		{
			nullObjError("args");
		}
		
		stream.writeInt(this.seedType);
		
		if(this.showItems!=null)
		{
			DIntData[] showItemsT=this.showItems;
			stream.writeLen(showItemsT.Length);
			for(int showItemsVI=0,showItemsVLen=showItemsT.Length;showItemsVI<showItemsVLen;++showItemsVI)
			{
				DIntData showItemsV=showItemsT[showItemsVI];
				if(showItemsV!=null)
				{
					showItemsV.writeBytesSimple(stream);
				}
				else
				{
					nullObjError("showItemsV");
				}
				
			}
		}
		else
		{
			nullObjError("showItems");
		}
		
	}
	
}