package com.home.commonBase.data.item.auction;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 拍卖行临时购买物品数据(generated by shine) */
public class AuctionBuyItemData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.AuctionBuyItem;
	
	public long instanceID;
	
	public int itemID;
	
	public int num;
	
	public int price;
	
	/** 临时时间计次 */
	public int tempTimeIndex;
	
	public AuctionBuyItemData()
	{
		_dataID=BaseDataType.AuctionBuyItem;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "AuctionBuyItemData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.instanceID=stream.readLong();
		
		this.itemID=stream.readInt();
		
		this.num=stream.readInt();
		
		this.price=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeLong(this.instanceID);
		
		stream.writeInt(this.itemID);
		
		stream.writeInt(this.num);
		
		stream.writeInt(this.price);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.instanceID=stream.readLong();
		
		this.itemID=stream.readInt();
		
		this.num=stream.readInt();
		
		this.price=stream.readInt();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeLong(this.instanceID);
		
		stream.writeInt(this.itemID);
		
		stream.writeInt(this.num);
		
		stream.writeInt(this.price);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof AuctionBuyItemData))
			return;
		
		AuctionBuyItemData mData=(AuctionBuyItemData)data;
		
		this.instanceID=mData.instanceID;
		this.itemID=mData.itemID;
		this.num=mData.num;
		this.price=mData.price;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof AuctionBuyItemData))
			return;
		
		AuctionBuyItemData mData=(AuctionBuyItemData)data;
		
		this.instanceID=mData.instanceID;
		
		this.itemID=mData.itemID;
		
		this.num=mData.num;
		
		this.price=mData.price;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		AuctionBuyItemData mData=(AuctionBuyItemData)data;
		if(this.instanceID!=mData.instanceID)
			return false;
		
		if(this.itemID!=mData.itemID)
			return false;
		
		if(this.num!=mData.num)
			return false;
		
		if(this.price!=mData.price)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("instanceID");
		writer.sb.append(':');
		writer.sb.append(this.instanceID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("itemID");
		writer.sb.append(':');
		writer.sb.append(this.itemID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("num");
		writer.sb.append(':');
		writer.sb.append(this.num);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("price");
		writer.sb.append(':');
		writer.sb.append(this.price);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.instanceID=0L;
		this.itemID=0;
		this.num=0;
		this.price=0;
	}
	
}
