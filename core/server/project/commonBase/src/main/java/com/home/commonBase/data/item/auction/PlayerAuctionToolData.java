package com.home.commonBase.data.item.auction;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.func.FuncToolData;
import com.home.commonBase.data.item.auction.AuctionBuyItemData;
import com.home.commonBase.data.item.auction.AuctionItemData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.LongObjectMap;
import com.home.shine.support.pool.DataPool;

/** 玩家拍卖行工具数据(generated by shine) */
public class PlayerAuctionToolData extends FuncToolData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.PlayerAuctionTool;
	
	/** 上架中的物品组 */
	public LongObjectMap<AuctionItemData> preSellItems;
	
	/** 购买中的物品 */
	public LongObjectMap<AuctionBuyItemData> preBuyItems;
	
	/** 已上架的物品组 */
	public LongObjectMap<AuctionItemData> sellItems;
	
	public PlayerAuctionToolData()
	{
		_dataID=BaseDataType.PlayerAuctionTool;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "PlayerAuctionToolData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		int sellItemsLen=stream.readLen();
		if(this.sellItems!=null)
		{
			this.sellItems.clear();
			this.sellItems.ensureCapacity(sellItemsLen);
		}
		else
		{
			this.sellItems=new LongObjectMap<AuctionItemData>(AuctionItemData[]::new,sellItemsLen);
		}
		
		LongObjectMap<AuctionItemData> sellItemsT=this.sellItems;
		for(int sellItemsI=sellItemsLen-1;sellItemsI>=0;--sellItemsI)
		{
			AuctionItemData sellItemsV;
			BaseData sellItemsVT=stream.readDataFullNotNull();
			if(sellItemsVT!=null)
			{
				if(sellItemsVT instanceof AuctionItemData)
				{
					sellItemsV=(AuctionItemData)sellItemsVT;
				}
				else
				{
					sellItemsV=new AuctionItemData();
					if(!(sellItemsVT.getClass().isAssignableFrom(AuctionItemData.class)))
					{
						stream.throwTypeReadError(AuctionItemData.class,sellItemsVT.getClass());
					}
					sellItemsV.shadowCopy(sellItemsVT);
				}
			}
			else
			{
				sellItemsV=null;
			}
			
			sellItemsT.put(sellItemsV.instanceID,sellItemsV);
		}
		
		int preSellItemsLen=stream.readLen();
		if(this.preSellItems!=null)
		{
			this.preSellItems.clear();
			this.preSellItems.ensureCapacity(preSellItemsLen);
		}
		else
		{
			this.preSellItems=new LongObjectMap<AuctionItemData>(AuctionItemData[]::new,preSellItemsLen);
		}
		
		LongObjectMap<AuctionItemData> preSellItemsT=this.preSellItems;
		for(int preSellItemsI=preSellItemsLen-1;preSellItemsI>=0;--preSellItemsI)
		{
			AuctionItemData preSellItemsV;
			BaseData preSellItemsVT=stream.readDataFullNotNull();
			if(preSellItemsVT!=null)
			{
				if(preSellItemsVT instanceof AuctionItemData)
				{
					preSellItemsV=(AuctionItemData)preSellItemsVT;
				}
				else
				{
					preSellItemsV=new AuctionItemData();
					if(!(preSellItemsVT.getClass().isAssignableFrom(AuctionItemData.class)))
					{
						stream.throwTypeReadError(AuctionItemData.class,preSellItemsVT.getClass());
					}
					preSellItemsV.shadowCopy(preSellItemsVT);
				}
			}
			else
			{
				preSellItemsV=null;
			}
			
			preSellItemsT.put(preSellItemsV.instanceID,preSellItemsV);
		}
		
		int preBuyItemsLen=stream.readLen();
		if(this.preBuyItems!=null)
		{
			this.preBuyItems.clear();
			this.preBuyItems.ensureCapacity(preBuyItemsLen);
		}
		else
		{
			this.preBuyItems=new LongObjectMap<AuctionBuyItemData>(AuctionBuyItemData[]::new,preBuyItemsLen);
		}
		
		LongObjectMap<AuctionBuyItemData> preBuyItemsT=this.preBuyItems;
		for(int preBuyItemsI=preBuyItemsLen-1;preBuyItemsI>=0;--preBuyItemsI)
		{
			AuctionBuyItemData preBuyItemsV;
			BaseData preBuyItemsVT=stream.readDataFullNotNull();
			if(preBuyItemsVT!=null)
			{
				if(preBuyItemsVT instanceof AuctionBuyItemData)
				{
					preBuyItemsV=(AuctionBuyItemData)preBuyItemsVT;
				}
				else
				{
					preBuyItemsV=new AuctionBuyItemData();
					if(!(preBuyItemsVT.getClass().isAssignableFrom(AuctionBuyItemData.class)))
					{
						stream.throwTypeReadError(AuctionBuyItemData.class,preBuyItemsVT.getClass());
					}
					preBuyItemsV.shadowCopy(preBuyItemsVT);
				}
			}
			else
			{
				preBuyItemsV=null;
			}
			
			preBuyItemsT.put(preBuyItemsV.instanceID,preBuyItemsV);
		}
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.sellItems!=null)
		{
			stream.writeLen(this.sellItems.size());
			if(!this.sellItems.isEmpty())
			{
				Object[] sellItemsVValues=this.sellItems.getValues();
				for(int sellItemsVI=sellItemsVValues.length-1;sellItemsVI>=0;--sellItemsVI)
				{
					if(sellItemsVValues[sellItemsVI]!=null)
					{
						AuctionItemData sellItemsV=(AuctionItemData)sellItemsVValues[sellItemsVI];
						if(sellItemsV!=null)
						{
							stream.writeDataFullNotNull(sellItemsV);
						}
						else
						{
							nullObjError("sellItemsV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("sellItems");
		}
		
		if(this.preSellItems!=null)
		{
			stream.writeLen(this.preSellItems.size());
			if(!this.preSellItems.isEmpty())
			{
				Object[] preSellItemsVValues=this.preSellItems.getValues();
				for(int preSellItemsVI=preSellItemsVValues.length-1;preSellItemsVI>=0;--preSellItemsVI)
				{
					if(preSellItemsVValues[preSellItemsVI]!=null)
					{
						AuctionItemData preSellItemsV=(AuctionItemData)preSellItemsVValues[preSellItemsVI];
						if(preSellItemsV!=null)
						{
							stream.writeDataFullNotNull(preSellItemsV);
						}
						else
						{
							nullObjError("preSellItemsV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("preSellItems");
		}
		
		if(this.preBuyItems!=null)
		{
			stream.writeLen(this.preBuyItems.size());
			if(!this.preBuyItems.isEmpty())
			{
				Object[] preBuyItemsVValues=this.preBuyItems.getValues();
				for(int preBuyItemsVI=preBuyItemsVValues.length-1;preBuyItemsVI>=0;--preBuyItemsVI)
				{
					if(preBuyItemsVValues[preBuyItemsVI]!=null)
					{
						AuctionBuyItemData preBuyItemsV=(AuctionBuyItemData)preBuyItemsVValues[preBuyItemsVI];
						if(preBuyItemsV!=null)
						{
							stream.writeDataFullNotNull(preBuyItemsV);
						}
						else
						{
							nullObjError("preBuyItemsV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("preBuyItems");
		}
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		int sellItemsLen=stream.readLen();
		if(this.sellItems!=null)
		{
			this.sellItems.clear();
			this.sellItems.ensureCapacity(sellItemsLen);
		}
		else
		{
			this.sellItems=new LongObjectMap<AuctionItemData>(AuctionItemData[]::new,sellItemsLen);
		}
		
		LongObjectMap<AuctionItemData> sellItemsT=this.sellItems;
		for(int sellItemsI=sellItemsLen-1;sellItemsI>=0;--sellItemsI)
		{
			AuctionItemData sellItemsV;
			sellItemsV=(AuctionItemData)stream.readDataSimpleNotNull();
			
			sellItemsT.put(sellItemsV.instanceID,sellItemsV);
		}
		
		int preSellItemsLen=stream.readLen();
		if(this.preSellItems!=null)
		{
			this.preSellItems.clear();
			this.preSellItems.ensureCapacity(preSellItemsLen);
		}
		else
		{
			this.preSellItems=new LongObjectMap<AuctionItemData>(AuctionItemData[]::new,preSellItemsLen);
		}
		
		LongObjectMap<AuctionItemData> preSellItemsT=this.preSellItems;
		for(int preSellItemsI=preSellItemsLen-1;preSellItemsI>=0;--preSellItemsI)
		{
			AuctionItemData preSellItemsV;
			preSellItemsV=(AuctionItemData)stream.readDataSimpleNotNull();
			
			preSellItemsT.put(preSellItemsV.instanceID,preSellItemsV);
		}
		
		int preBuyItemsLen=stream.readLen();
		if(this.preBuyItems!=null)
		{
			this.preBuyItems.clear();
			this.preBuyItems.ensureCapacity(preBuyItemsLen);
		}
		else
		{
			this.preBuyItems=new LongObjectMap<AuctionBuyItemData>(AuctionBuyItemData[]::new,preBuyItemsLen);
		}
		
		LongObjectMap<AuctionBuyItemData> preBuyItemsT=this.preBuyItems;
		for(int preBuyItemsI=preBuyItemsLen-1;preBuyItemsI>=0;--preBuyItemsI)
		{
			AuctionBuyItemData preBuyItemsV;
			preBuyItemsV=(AuctionBuyItemData)stream.readDataSimpleNotNull();
			
			preBuyItemsT.put(preBuyItemsV.instanceID,preBuyItemsV);
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.sellItems!=null)
		{
			stream.writeLen(this.sellItems.size());
			if(!this.sellItems.isEmpty())
			{
				Object[] sellItemsVValues=this.sellItems.getValues();
				for(int sellItemsVI=sellItemsVValues.length-1;sellItemsVI>=0;--sellItemsVI)
				{
					if(sellItemsVValues[sellItemsVI]!=null)
					{
						AuctionItemData sellItemsV=(AuctionItemData)sellItemsVValues[sellItemsVI];
						if(sellItemsV!=null)
						{
							stream.writeDataSimpleNotNull(sellItemsV);
						}
						else
						{
							nullObjError("sellItemsV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("sellItems");
		}
		
		if(this.preSellItems!=null)
		{
			stream.writeLen(this.preSellItems.size());
			if(!this.preSellItems.isEmpty())
			{
				Object[] preSellItemsVValues=this.preSellItems.getValues();
				for(int preSellItemsVI=preSellItemsVValues.length-1;preSellItemsVI>=0;--preSellItemsVI)
				{
					if(preSellItemsVValues[preSellItemsVI]!=null)
					{
						AuctionItemData preSellItemsV=(AuctionItemData)preSellItemsVValues[preSellItemsVI];
						if(preSellItemsV!=null)
						{
							stream.writeDataSimpleNotNull(preSellItemsV);
						}
						else
						{
							nullObjError("preSellItemsV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("preSellItems");
		}
		
		if(this.preBuyItems!=null)
		{
			stream.writeLen(this.preBuyItems.size());
			if(!this.preBuyItems.isEmpty())
			{
				Object[] preBuyItemsVValues=this.preBuyItems.getValues();
				for(int preBuyItemsVI=preBuyItemsVValues.length-1;preBuyItemsVI>=0;--preBuyItemsVI)
				{
					if(preBuyItemsVValues[preBuyItemsVI]!=null)
					{
						AuctionBuyItemData preBuyItemsV=(AuctionBuyItemData)preBuyItemsVValues[preBuyItemsVI];
						if(preBuyItemsV!=null)
						{
							stream.writeDataSimpleNotNull(preBuyItemsV);
						}
						else
						{
							nullObjError("preBuyItemsV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("preBuyItems");
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof PlayerAuctionToolData))
			return;
		
		PlayerAuctionToolData mData=(PlayerAuctionToolData)data;
		
		this.sellItems=mData.sellItems;
		this.preSellItems=mData.preSellItems;
		this.preBuyItems=mData.preBuyItems;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof PlayerAuctionToolData))
			return;
		
		PlayerAuctionToolData mData=(PlayerAuctionToolData)data;
		
		if(mData.sellItems!=null)
		{
			if(this.sellItems!=null)
			{
				this.sellItems.clear();
				this.sellItems.ensureCapacity(mData.sellItems.size());
			}
			else
			{
				this.sellItems=new LongObjectMap<AuctionItemData>(AuctionItemData[]::new,mData.sellItems.size());
			}
			
			LongObjectMap<AuctionItemData> sellItemsT=this.sellItems;
			if(!mData.sellItems.isEmpty())
			{
				Object[] sellItemsVValues=mData.sellItems.getValues();
				for(int sellItemsVI=sellItemsVValues.length-1;sellItemsVI>=0;--sellItemsVI)
				{
					if(sellItemsVValues[sellItemsVI]!=null)
					{
						AuctionItemData sellItemsV=(AuctionItemData)sellItemsVValues[sellItemsVI];
						AuctionItemData sellItemsU;
						if(sellItemsV!=null)
						{
							sellItemsU=(AuctionItemData)sellItemsV.clone();
						}
						else
						{
							sellItemsU=null;
							nullObjError("sellItemsU");
						}
						
						sellItemsT.put(sellItemsU.instanceID,sellItemsU);
					}
				}
			}
		}
		else
		{
			this.sellItems=null;
			nullObjError("sellItems");
		}
		
		if(mData.preSellItems!=null)
		{
			if(this.preSellItems!=null)
			{
				this.preSellItems.clear();
				this.preSellItems.ensureCapacity(mData.preSellItems.size());
			}
			else
			{
				this.preSellItems=new LongObjectMap<AuctionItemData>(AuctionItemData[]::new,mData.preSellItems.size());
			}
			
			LongObjectMap<AuctionItemData> preSellItemsT=this.preSellItems;
			if(!mData.preSellItems.isEmpty())
			{
				Object[] preSellItemsVValues=mData.preSellItems.getValues();
				for(int preSellItemsVI=preSellItemsVValues.length-1;preSellItemsVI>=0;--preSellItemsVI)
				{
					if(preSellItemsVValues[preSellItemsVI]!=null)
					{
						AuctionItemData preSellItemsV=(AuctionItemData)preSellItemsVValues[preSellItemsVI];
						AuctionItemData preSellItemsU;
						if(preSellItemsV!=null)
						{
							preSellItemsU=(AuctionItemData)preSellItemsV.clone();
						}
						else
						{
							preSellItemsU=null;
							nullObjError("preSellItemsU");
						}
						
						preSellItemsT.put(preSellItemsU.instanceID,preSellItemsU);
					}
				}
			}
		}
		else
		{
			this.preSellItems=null;
			nullObjError("preSellItems");
		}
		
		if(mData.preBuyItems!=null)
		{
			if(this.preBuyItems!=null)
			{
				this.preBuyItems.clear();
				this.preBuyItems.ensureCapacity(mData.preBuyItems.size());
			}
			else
			{
				this.preBuyItems=new LongObjectMap<AuctionBuyItemData>(AuctionBuyItemData[]::new,mData.preBuyItems.size());
			}
			
			LongObjectMap<AuctionBuyItemData> preBuyItemsT=this.preBuyItems;
			if(!mData.preBuyItems.isEmpty())
			{
				Object[] preBuyItemsVValues=mData.preBuyItems.getValues();
				for(int preBuyItemsVI=preBuyItemsVValues.length-1;preBuyItemsVI>=0;--preBuyItemsVI)
				{
					if(preBuyItemsVValues[preBuyItemsVI]!=null)
					{
						AuctionBuyItemData preBuyItemsV=(AuctionBuyItemData)preBuyItemsVValues[preBuyItemsVI];
						AuctionBuyItemData preBuyItemsU;
						if(preBuyItemsV!=null)
						{
							preBuyItemsU=(AuctionBuyItemData)preBuyItemsV.clone();
						}
						else
						{
							preBuyItemsU=null;
							nullObjError("preBuyItemsU");
						}
						
						preBuyItemsT.put(preBuyItemsU.instanceID,preBuyItemsU);
					}
				}
			}
		}
		else
		{
			this.preBuyItems=null;
			nullObjError("preBuyItems");
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		PlayerAuctionToolData mData=(PlayerAuctionToolData)data;
		if(mData.sellItems!=null)
		{
			if(this.sellItems==null)
				return false;
			if(this.sellItems.size()!=mData.sellItems.size())
				return false;
			LongObjectMap<AuctionItemData> sellItemsR=mData.sellItems;
			if(!this.sellItems.isEmpty())
			{
				long sellItemsKFreeValue=this.sellItems.getFreeValue();
				long[] sellItemsKKeys=this.sellItems.getKeys();
				Object[] sellItemsVValues=this.sellItems.getValues();
				for(int sellItemsKI=sellItemsKKeys.length-1;sellItemsKI>=0;--sellItemsKI)
				{
					long sellItemsK=sellItemsKKeys[sellItemsKI];
					if(sellItemsK!=sellItemsKFreeValue)
					{
						AuctionItemData sellItemsV=(AuctionItemData)sellItemsVValues[sellItemsKI];
						AuctionItemData sellItemsU=sellItemsR.get(sellItemsK);
						if(sellItemsU!=null)
						{
							if(sellItemsV==null)
								return false;
							if(!sellItemsV.dataEquals(sellItemsU))
								return false;
						}
						else
						{
							if(sellItemsV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.sellItems!=null)
				return false;
		}
		
		if(mData.preSellItems!=null)
		{
			if(this.preSellItems==null)
				return false;
			if(this.preSellItems.size()!=mData.preSellItems.size())
				return false;
			LongObjectMap<AuctionItemData> preSellItemsR=mData.preSellItems;
			if(!this.preSellItems.isEmpty())
			{
				long preSellItemsKFreeValue=this.preSellItems.getFreeValue();
				long[] preSellItemsKKeys=this.preSellItems.getKeys();
				Object[] preSellItemsVValues=this.preSellItems.getValues();
				for(int preSellItemsKI=preSellItemsKKeys.length-1;preSellItemsKI>=0;--preSellItemsKI)
				{
					long preSellItemsK=preSellItemsKKeys[preSellItemsKI];
					if(preSellItemsK!=preSellItemsKFreeValue)
					{
						AuctionItemData preSellItemsV=(AuctionItemData)preSellItemsVValues[preSellItemsKI];
						AuctionItemData preSellItemsU=preSellItemsR.get(preSellItemsK);
						if(preSellItemsU!=null)
						{
							if(preSellItemsV==null)
								return false;
							if(!preSellItemsV.dataEquals(preSellItemsU))
								return false;
						}
						else
						{
							if(preSellItemsV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.preSellItems!=null)
				return false;
		}
		
		if(mData.preBuyItems!=null)
		{
			if(this.preBuyItems==null)
				return false;
			if(this.preBuyItems.size()!=mData.preBuyItems.size())
				return false;
			LongObjectMap<AuctionBuyItemData> preBuyItemsR=mData.preBuyItems;
			if(!this.preBuyItems.isEmpty())
			{
				long preBuyItemsKFreeValue=this.preBuyItems.getFreeValue();
				long[] preBuyItemsKKeys=this.preBuyItems.getKeys();
				Object[] preBuyItemsVValues=this.preBuyItems.getValues();
				for(int preBuyItemsKI=preBuyItemsKKeys.length-1;preBuyItemsKI>=0;--preBuyItemsKI)
				{
					long preBuyItemsK=preBuyItemsKKeys[preBuyItemsKI];
					if(preBuyItemsK!=preBuyItemsKFreeValue)
					{
						AuctionBuyItemData preBuyItemsV=(AuctionBuyItemData)preBuyItemsVValues[preBuyItemsKI];
						AuctionBuyItemData preBuyItemsU=preBuyItemsR.get(preBuyItemsK);
						if(preBuyItemsU!=null)
						{
							if(preBuyItemsV==null)
								return false;
							if(!preBuyItemsV.dataEquals(preBuyItemsU))
								return false;
						}
						else
						{
							if(preBuyItemsV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.preBuyItems!=null)
				return false;
		}
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("sellItems");
		writer.sb.append(':');
		writer.sb.append("Map<long,AuctionItemData>");
		if(this.sellItems!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.sellItems.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.sellItems.isEmpty())
			{
				long sellItemsKFreeValue=this.sellItems.getFreeValue();
				long[] sellItemsKKeys=this.sellItems.getKeys();
				Object[] sellItemsVValues=this.sellItems.getValues();
				for(int sellItemsKI=sellItemsKKeys.length-1;sellItemsKI>=0;--sellItemsKI)
				{
					long sellItemsK=sellItemsKKeys[sellItemsKI];
					if(sellItemsK!=sellItemsKFreeValue)
					{
						AuctionItemData sellItemsV=(AuctionItemData)sellItemsVValues[sellItemsKI];
						writer.writeTabs();
						writer.sb.append(sellItemsK);
						
						writer.sb.append(':');
						if(sellItemsV!=null)
						{
							sellItemsV.writeDataString(writer);
						}
						else
						{
							writer.sb.append("AuctionItemData=null");
						}
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("preSellItems");
		writer.sb.append(':');
		writer.sb.append("Map<long,AuctionItemData>");
		if(this.preSellItems!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.preSellItems.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.preSellItems.isEmpty())
			{
				long preSellItemsKFreeValue=this.preSellItems.getFreeValue();
				long[] preSellItemsKKeys=this.preSellItems.getKeys();
				Object[] preSellItemsVValues=this.preSellItems.getValues();
				for(int preSellItemsKI=preSellItemsKKeys.length-1;preSellItemsKI>=0;--preSellItemsKI)
				{
					long preSellItemsK=preSellItemsKKeys[preSellItemsKI];
					if(preSellItemsK!=preSellItemsKFreeValue)
					{
						AuctionItemData preSellItemsV=(AuctionItemData)preSellItemsVValues[preSellItemsKI];
						writer.writeTabs();
						writer.sb.append(preSellItemsK);
						
						writer.sb.append(':');
						if(preSellItemsV!=null)
						{
							preSellItemsV.writeDataString(writer);
						}
						else
						{
							writer.sb.append("AuctionItemData=null");
						}
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("preBuyItems");
		writer.sb.append(':');
		writer.sb.append("Map<long,AuctionBuyItemData>");
		if(this.preBuyItems!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.preBuyItems.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.preBuyItems.isEmpty())
			{
				long preBuyItemsKFreeValue=this.preBuyItems.getFreeValue();
				long[] preBuyItemsKKeys=this.preBuyItems.getKeys();
				Object[] preBuyItemsVValues=this.preBuyItems.getValues();
				for(int preBuyItemsKI=preBuyItemsKKeys.length-1;preBuyItemsKI>=0;--preBuyItemsKI)
				{
					long preBuyItemsK=preBuyItemsKKeys[preBuyItemsKI];
					if(preBuyItemsK!=preBuyItemsKFreeValue)
					{
						AuctionBuyItemData preBuyItemsV=(AuctionBuyItemData)preBuyItemsVValues[preBuyItemsKI];
						writer.writeTabs();
						writer.sb.append(preBuyItemsK);
						
						writer.sb.append(':');
						if(preBuyItemsV!=null)
						{
							preBuyItemsV.writeDataString(writer);
						}
						else
						{
							writer.sb.append("AuctionBuyItemData=null");
						}
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		super.initDefault();
		
		this.sellItems=new LongObjectMap<AuctionItemData>(AuctionItemData[]::new);
		this.preSellItems=new LongObjectMap<AuctionItemData>(AuctionItemData[]::new);
		this.preBuyItems=new LongObjectMap<AuctionBuyItemData>(AuctionBuyItemData[]::new);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.sellItems=null;
		this.preSellItems=null;
		this.preBuyItems=null;
	}
	
}
