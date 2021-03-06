using ShineEngine;

/// <summary>
/// 装备容器数据(generated by shine)
/// </summary>
public class EquipContainerData:FuncToolData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.EquipContainer;
	
	/// <summary>
	/// 装备数据组(key:slot)
	/// </summary>
	public IntObjectMap<ItemData> equips;
	
	/// <summary>
	/// 开启的格子组
	/// </summary>
	public IntSet openSlots;
	
	public EquipContainerData()
	{
		_dataID=BaseDataType.EquipContainer;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "EquipContainerData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		int equipsLen=stream.readLen();
		if(this.equips!=null)
		{
			this.equips.clear();
			this.equips.ensureCapacity(equipsLen);
		}
		else
		{
			this.equips=new IntObjectMap<ItemData>(equipsLen);
		}
		
		IntObjectMap<ItemData> equipsT=this.equips;
		for(int equipsI=equipsLen-1;equipsI>=0;--equipsI)
		{
			int equipsK;
			ItemData equipsV;
			equipsK=stream.readInt();
			
			BaseData equipsVT=stream.readDataFullNotNull();
			if(equipsVT!=null)
			{
				if(equipsVT is ItemData)
				{
					equipsV=(ItemData)equipsVT;
				}
				else
				{
					equipsV=new ItemData();
					if(!(equipsVT.GetType().IsAssignableFrom(typeof(ItemData))))
					{
						stream.throwTypeReadError(typeof(ItemData),equipsVT.GetType());
					}
					equipsV.shadowCopy(equipsVT);
				}
			}
			else
			{
				equipsV=null;
			}
			
			equipsT.put(equipsK,equipsV);
		}
		
		int openSlotsLen=stream.readLen();
		if(this.openSlots!=null)
		{
			this.openSlots.clear();
			this.openSlots.ensureCapacity(openSlotsLen);
		}
		else
		{
			this.openSlots=new IntSet();
		}
		
		IntSet openSlotsT=this.openSlots;
		for(int openSlotsI=openSlotsLen-1;openSlotsI>=0;--openSlotsI)
		{
			int openSlotsV;
			openSlotsV=stream.readInt();
			
			openSlotsT.add(openSlotsV);
		}
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.equips!=null)
		{
			stream.writeLen(this.equips.size());
			if(!this.equips.isEmpty())
			{
				int equipsKFreeValue=this.equips.getFreeValue();
				int[] equipsKKeys=this.equips.getKeys();
				ItemData[] equipsVValues=this.equips.getValues();
				for(int equipsKI=equipsKKeys.Length-1;equipsKI>=0;--equipsKI)
				{
					int equipsK=equipsKKeys[equipsKI];
					if(equipsK!=equipsKFreeValue)
					{
						ItemData equipsV=equipsVValues[equipsKI];
						stream.writeInt(equipsK);
						
						if(equipsV!=null)
						{
							stream.writeDataFullNotNull(equipsV);
						}
						else
						{
							nullObjError("equipsV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("equips");
		}
		
		if(this.openSlots!=null)
		{
			stream.writeLen(this.openSlots.size());
			if(!this.openSlots.isEmpty())
			{
				int openSlotsVFreeValue=this.openSlots.getFreeValue();
				int[] openSlotsVKeys=this.openSlots.getKeys();
				for(int openSlotsVI=openSlotsVKeys.Length-1;openSlotsVI>=0;--openSlotsVI)
				{
					int openSlotsV=openSlotsVKeys[openSlotsVI];
					if(openSlotsV!=openSlotsVFreeValue)
					{
						stream.writeInt(openSlotsV);
						
					}
				}
			}
		}
		else
		{
			nullObjError("openSlots");
		}
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		int equipsLen=stream.readLen();
		if(this.equips!=null)
		{
			this.equips.clear();
			this.equips.ensureCapacity(equipsLen);
		}
		else
		{
			this.equips=new IntObjectMap<ItemData>(equipsLen);
		}
		
		IntObjectMap<ItemData> equipsT=this.equips;
		for(int equipsI=equipsLen-1;equipsI>=0;--equipsI)
		{
			int equipsK;
			ItemData equipsV;
			equipsK=stream.readInt();
			
			equipsV=(ItemData)stream.readDataSimpleNotNull();
			
			equipsT.put(equipsK,equipsV);
		}
		
		int openSlotsLen=stream.readLen();
		if(this.openSlots!=null)
		{
			this.openSlots.clear();
			this.openSlots.ensureCapacity(openSlotsLen);
		}
		else
		{
			this.openSlots=new IntSet();
		}
		
		IntSet openSlotsT=this.openSlots;
		for(int openSlotsI=openSlotsLen-1;openSlotsI>=0;--openSlotsI)
		{
			int openSlotsV;
			openSlotsV=stream.readInt();
			
			openSlotsT.add(openSlotsV);
		}
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		if(this.equips!=null)
		{
			stream.writeLen(this.equips.size());
			if(!this.equips.isEmpty())
			{
				int equipsKFreeValue=this.equips.getFreeValue();
				int[] equipsKKeys=this.equips.getKeys();
				ItemData[] equipsVValues=this.equips.getValues();
				for(int equipsKI=equipsKKeys.Length-1;equipsKI>=0;--equipsKI)
				{
					int equipsK=equipsKKeys[equipsKI];
					if(equipsK!=equipsKFreeValue)
					{
						ItemData equipsV=equipsVValues[equipsKI];
						stream.writeInt(equipsK);
						
						if(equipsV!=null)
						{
							stream.writeDataSimpleNotNull(equipsV);
						}
						else
						{
							nullObjError("equipsV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("equips");
		}
		
		if(this.openSlots!=null)
		{
			stream.writeLen(this.openSlots.size());
			if(!this.openSlots.isEmpty())
			{
				int openSlotsVFreeValue=this.openSlots.getFreeValue();
				int[] openSlotsVKeys=this.openSlots.getKeys();
				for(int openSlotsVI=openSlotsVKeys.Length-1;openSlotsVI>=0;--openSlotsVI)
				{
					int openSlotsV=openSlotsVKeys[openSlotsVI];
					if(openSlotsV!=openSlotsVFreeValue)
					{
						stream.writeInt(openSlotsV);
						
					}
				}
			}
		}
		else
		{
			nullObjError("openSlots");
		}
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		base.toShadowCopy(data);
		
		if(!(data is EquipContainerData))
			return;
		
		EquipContainerData mData=(EquipContainerData)data;
		
		this.equips=mData.equips;
		this.openSlots=mData.openSlots;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		base.toCopy(data);
		
		if(!(data is EquipContainerData))
			return;
		
		EquipContainerData mData=(EquipContainerData)data;
		
		if(mData.equips!=null)
		{
			if(this.equips!=null)
			{
				this.equips.clear();
				this.equips.ensureCapacity(mData.equips.size());
			}
			else
			{
				this.equips=new IntObjectMap<ItemData>(mData.equips.size());
			}
			
			IntObjectMap<ItemData> equipsT=this.equips;
			if(!mData.equips.isEmpty())
			{
				int equipsKFreeValue=mData.equips.getFreeValue();
				int[] equipsKKeys=mData.equips.getKeys();
				ItemData[] equipsVValues=mData.equips.getValues();
				for(int equipsKI=equipsKKeys.Length-1;equipsKI>=0;--equipsKI)
				{
					int equipsK=equipsKKeys[equipsKI];
					if(equipsK!=equipsKFreeValue)
					{
						ItemData equipsV=equipsVValues[equipsKI];
						int equipsW;
						ItemData equipsU;
						equipsW=equipsK;
						
						if(equipsV!=null)
						{
							equipsU=(ItemData)equipsV.clone();
						}
						else
						{
							equipsU=null;
							nullObjError("equipsU");
						}
						
						equipsT.put(equipsW,equipsU);
					}
				}
			}
		}
		else
		{
			this.equips=null;
			nullObjError("equips");
		}
		
		if(mData.openSlots!=null)
		{
			if(this.openSlots!=null)
			{
				this.openSlots.clear();
				this.openSlots.ensureCapacity(mData.openSlots.size());
			}
			else
			{
				this.openSlots=new IntSet();
			}
			
			IntSet openSlotsT=this.openSlots;
			if(!mData.openSlots.isEmpty())
			{
				int openSlotsVFreeValue=mData.openSlots.getFreeValue();
				int[] openSlotsVKeys=mData.openSlots.getKeys();
				for(int openSlotsVI=openSlotsVKeys.Length-1;openSlotsVI>=0;--openSlotsVI)
				{
					int openSlotsV=openSlotsVKeys[openSlotsVI];
					if(openSlotsV!=openSlotsVFreeValue)
					{
						int openSlotsU;
						openSlotsU=openSlotsV;
						
						openSlotsT.add(openSlotsU);
					}
				}
			}
		}
		else
		{
			this.openSlots=null;
			nullObjError("openSlots");
		}
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		if(!base.toDataEquals(data))
			return false;
		
		EquipContainerData mData=(EquipContainerData)data;
		if(mData.equips!=null)
		{
			if(this.equips==null)
				return false;
			if(this.equips.size()!=mData.equips.size())
				return false;
			IntObjectMap<ItemData> equipsR=mData.equips;
			if(!this.equips.isEmpty())
			{
				int equipsKFreeValue=this.equips.getFreeValue();
				int[] equipsKKeys=this.equips.getKeys();
				ItemData[] equipsVValues=this.equips.getValues();
				for(int equipsKI=equipsKKeys.Length-1;equipsKI>=0;--equipsKI)
				{
					int equipsK=equipsKKeys[equipsKI];
					if(equipsK!=equipsKFreeValue)
					{
						ItemData equipsV=equipsVValues[equipsKI];
						ItemData equipsU=equipsR.get(equipsK);
						if(equipsU!=null)
						{
							if(equipsV==null)
								return false;
							if(!equipsV.dataEquals(equipsU))
								return false;
						}
						else
						{
							if(equipsV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.equips!=null)
				return false;
		}
		
		if(mData.openSlots!=null)
		{
			if(this.openSlots==null)
				return false;
			if(this.openSlots.size()!=mData.openSlots.size())
				return false;
			IntSet openSlotsR=mData.openSlots;
			if(!this.openSlots.isEmpty())
			{
				int openSlotsVFreeValue=this.openSlots.getFreeValue();
				int[] openSlotsVKeys=this.openSlots.getKeys();
				for(int openSlotsVI=openSlotsVKeys.Length-1;openSlotsVI>=0;--openSlotsVI)
				{
					int openSlotsV=openSlotsVKeys[openSlotsVI];
					if(openSlotsV!=openSlotsVFreeValue)
					{
						if(!openSlotsR.contains(openSlotsV))
							return false;
					}
				}
			}
		}
		else
		{
			if(this.openSlots!=null)
				return false;
		}
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("equips");
		writer.sb.Append(':');
		writer.sb.Append("Map<int,ItemData>");
		if(this.equips!=null)
		{
			writer.sb.Append('(');
			writer.sb.Append(this.equips.size());
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.equips.isEmpty())
			{
				int equipsKFreeValue=this.equips.getFreeValue();
				int[] equipsKKeys=this.equips.getKeys();
				ItemData[] equipsVValues=this.equips.getValues();
				for(int equipsKI=equipsKKeys.Length-1;equipsKI>=0;--equipsKI)
				{
					int equipsK=equipsKKeys[equipsKI];
					if(equipsK!=equipsKFreeValue)
					{
						ItemData equipsV=equipsVValues[equipsKI];
						writer.writeTabs();
						writer.sb.Append(equipsK);
						
						writer.sb.Append(':');
						if(equipsV!=null)
						{
							equipsV.writeDataString(writer);
						}
						else
						{
							writer.sb.Append("ItemData=null");
						}
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.Append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("openSlots");
		writer.sb.Append(':');
		writer.sb.Append("Set<int>");
		if(this.openSlots!=null)
		{
			writer.sb.Append('(');
			writer.sb.Append(this.openSlots.size());
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.openSlots.isEmpty())
			{
				int openSlotsVFreeValue=this.openSlots.getFreeValue();
				int[] openSlotsVKeys=this.openSlots.getKeys();
				for(int openSlotsVI=openSlotsVKeys.Length-1;openSlotsVI>=0;--openSlotsVI)
				{
					int openSlotsV=openSlotsVKeys[openSlotsVI];
					if(openSlotsV!=openSlotsVFreeValue)
					{
						writer.writeTabs();
						writer.sb.Append(openSlotsV);
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.Append("=null");
		}
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		base.initDefault();
		
		this.equips=new IntObjectMap<ItemData>();
		this.openSlots=new IntSet();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.equips=null;
		this.openSlots=null;
	}
	
}
