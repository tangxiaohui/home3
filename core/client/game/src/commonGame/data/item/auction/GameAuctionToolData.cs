using ShineEngine;

/// <summary>
/// (generated by shine)
/// </summary>
public class GameAuctionToolData:FuncToolData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.GameAuctionTool;
	
	/// <summary>
	/// 物品价格字典
	/// </summary>
	public IntIntMap itemPriceDic;
	
	public GameAuctionToolData()
	{
		_dataID=BaseDataType.GameAuctionTool;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "GameAuctionToolData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		int itemPriceDicLen=stream.readLen();
		if(this.itemPriceDic!=null)
		{
			this.itemPriceDic.clear();
			this.itemPriceDic.ensureCapacity(itemPriceDicLen);
		}
		else
		{
			this.itemPriceDic=new IntIntMap(itemPriceDicLen);
		}
		
		IntIntMap itemPriceDicT=this.itemPriceDic;
		for(int itemPriceDicI=itemPriceDicLen-1;itemPriceDicI>=0;--itemPriceDicI)
		{
			int itemPriceDicK;
			int itemPriceDicV;
			itemPriceDicK=stream.readInt();
			
			itemPriceDicV=stream.readInt();
			
			itemPriceDicT.put(itemPriceDicK,itemPriceDicV);
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
		
		if(this.itemPriceDic!=null)
		{
			stream.writeLen(this.itemPriceDic.size());
			if(!this.itemPriceDic.isEmpty())
			{
				int itemPriceDicKFreeValue=this.itemPriceDic.getFreeValue();
				int[] itemPriceDicKKeys=this.itemPriceDic.getKeys();
				int[] itemPriceDicVValues=this.itemPriceDic.getValues();
				for(int itemPriceDicKI=itemPriceDicKKeys.Length-1;itemPriceDicKI>=0;--itemPriceDicKI)
				{
					int itemPriceDicK=itemPriceDicKKeys[itemPriceDicKI];
					if(itemPriceDicK!=itemPriceDicKFreeValue)
					{
						int itemPriceDicV=itemPriceDicVValues[itemPriceDicKI];
						stream.writeInt(itemPriceDicK);
						
						stream.writeInt(itemPriceDicV);
						
					}
				}
			}
		}
		else
		{
			nullObjError("itemPriceDic");
		}
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		int itemPriceDicLen=stream.readLen();
		if(this.itemPriceDic!=null)
		{
			this.itemPriceDic.clear();
			this.itemPriceDic.ensureCapacity(itemPriceDicLen);
		}
		else
		{
			this.itemPriceDic=new IntIntMap(itemPriceDicLen);
		}
		
		IntIntMap itemPriceDicT=this.itemPriceDic;
		for(int itemPriceDicI=itemPriceDicLen-1;itemPriceDicI>=0;--itemPriceDicI)
		{
			int itemPriceDicK;
			int itemPriceDicV;
			itemPriceDicK=stream.readInt();
			
			itemPriceDicV=stream.readInt();
			
			itemPriceDicT.put(itemPriceDicK,itemPriceDicV);
		}
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		if(this.itemPriceDic!=null)
		{
			stream.writeLen(this.itemPriceDic.size());
			if(!this.itemPriceDic.isEmpty())
			{
				int itemPriceDicKFreeValue=this.itemPriceDic.getFreeValue();
				int[] itemPriceDicKKeys=this.itemPriceDic.getKeys();
				int[] itemPriceDicVValues=this.itemPriceDic.getValues();
				for(int itemPriceDicKI=itemPriceDicKKeys.Length-1;itemPriceDicKI>=0;--itemPriceDicKI)
				{
					int itemPriceDicK=itemPriceDicKKeys[itemPriceDicKI];
					if(itemPriceDicK!=itemPriceDicKFreeValue)
					{
						int itemPriceDicV=itemPriceDicVValues[itemPriceDicKI];
						stream.writeInt(itemPriceDicK);
						
						stream.writeInt(itemPriceDicV);
						
					}
				}
			}
		}
		else
		{
			nullObjError("itemPriceDic");
		}
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		base.toShadowCopy(data);
		
		if(!(data is GameAuctionToolData))
			return;
		
		GameAuctionToolData mData=(GameAuctionToolData)data;
		
		this.itemPriceDic=mData.itemPriceDic;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		base.toCopy(data);
		
		if(!(data is GameAuctionToolData))
			return;
		
		GameAuctionToolData mData=(GameAuctionToolData)data;
		
		if(mData.itemPriceDic!=null)
		{
			if(this.itemPriceDic!=null)
			{
				this.itemPriceDic.clear();
				this.itemPriceDic.ensureCapacity(mData.itemPriceDic.size());
			}
			else
			{
				this.itemPriceDic=new IntIntMap(mData.itemPriceDic.size());
			}
			
			IntIntMap itemPriceDicT=this.itemPriceDic;
			if(!mData.itemPriceDic.isEmpty())
			{
				int itemPriceDicKFreeValue=mData.itemPriceDic.getFreeValue();
				int[] itemPriceDicKKeys=mData.itemPriceDic.getKeys();
				int[] itemPriceDicVValues=mData.itemPriceDic.getValues();
				for(int itemPriceDicKI=itemPriceDicKKeys.Length-1;itemPriceDicKI>=0;--itemPriceDicKI)
				{
					int itemPriceDicK=itemPriceDicKKeys[itemPriceDicKI];
					if(itemPriceDicK!=itemPriceDicKFreeValue)
					{
						int itemPriceDicV=itemPriceDicVValues[itemPriceDicKI];
						int itemPriceDicW;
						int itemPriceDicU;
						itemPriceDicW=itemPriceDicK;
						
						itemPriceDicU=itemPriceDicV;
						
						itemPriceDicT.put(itemPriceDicW,itemPriceDicU);
					}
				}
			}
		}
		else
		{
			this.itemPriceDic=null;
			nullObjError("itemPriceDic");
		}
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		if(!base.toDataEquals(data))
			return false;
		
		GameAuctionToolData mData=(GameAuctionToolData)data;
		if(mData.itemPriceDic!=null)
		{
			if(this.itemPriceDic==null)
				return false;
			if(this.itemPriceDic.size()!=mData.itemPriceDic.size())
				return false;
			IntIntMap itemPriceDicR=mData.itemPriceDic;
			if(!this.itemPriceDic.isEmpty())
			{
				int itemPriceDicKFreeValue=this.itemPriceDic.getFreeValue();
				int[] itemPriceDicKKeys=this.itemPriceDic.getKeys();
				int[] itemPriceDicVValues=this.itemPriceDic.getValues();
				for(int itemPriceDicKI=itemPriceDicKKeys.Length-1;itemPriceDicKI>=0;--itemPriceDicKI)
				{
					int itemPriceDicK=itemPriceDicKKeys[itemPriceDicKI];
					if(itemPriceDicK!=itemPriceDicKFreeValue)
					{
						int itemPriceDicV=itemPriceDicVValues[itemPriceDicKI];
						int itemPriceDicU=itemPriceDicR.get(itemPriceDicK);
						if(itemPriceDicV!=itemPriceDicU)
							return false;
						
					}
				}
			}
		}
		else
		{
			if(this.itemPriceDic!=null)
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
		writer.sb.Append("itemPriceDic");
		writer.sb.Append(':');
		writer.sb.Append("Map<int,int>");
		if(this.itemPriceDic!=null)
		{
			writer.sb.Append('(');
			writer.sb.Append(this.itemPriceDic.size());
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.itemPriceDic.isEmpty())
			{
				int itemPriceDicKFreeValue=this.itemPriceDic.getFreeValue();
				int[] itemPriceDicKKeys=this.itemPriceDic.getKeys();
				int[] itemPriceDicVValues=this.itemPriceDic.getValues();
				for(int itemPriceDicKI=itemPriceDicKKeys.Length-1;itemPriceDicKI>=0;--itemPriceDicKI)
				{
					int itemPriceDicK=itemPriceDicKKeys[itemPriceDicKI];
					if(itemPriceDicK!=itemPriceDicKFreeValue)
					{
						int itemPriceDicV=itemPriceDicVValues[itemPriceDicKI];
						writer.writeTabs();
						writer.sb.Append(itemPriceDicK);
						
						writer.sb.Append(':');
						writer.sb.Append(itemPriceDicV);
						
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
		
		this.itemPriceDic=new IntIntMap();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.itemPriceDic=null;
	}
	
}