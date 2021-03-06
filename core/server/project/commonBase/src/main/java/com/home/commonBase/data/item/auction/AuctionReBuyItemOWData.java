package com.home.commonBase.data.item.auction;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.func.PlayerFuncWorkData;
import com.home.commonBase.data.item.ItemData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 拍卖行回复购买物品数据(generated by shine) */
public class AuctionReBuyItemOWData extends PlayerFuncWorkData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.AuctionReBuyItemOW;
	
	/** 实例id */
	public long instanceID;
	
	/** 物品 */
	public ItemData item;
	
	/** 信息码 */
	public int code;
	
	/** 临时的发送目标id */
	public long tempPlayerID;
	
	/** 临时是否售罄 */
	public boolean tempSoldOut;
	
	public AuctionReBuyItemOWData()
	{
		_dataID=BaseDataType.AuctionReBuyItemOW;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "AuctionReBuyItemOWData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.instanceID=stream.readLong();
		
		if(stream.readBoolean())
		{
			BaseData itemT=stream.readDataFullNotNull();
			if(itemT!=null)
			{
				if(itemT instanceof ItemData)
				{
					this.item=(ItemData)itemT;
				}
				else
				{
					this.item=new ItemData();
					if(!(itemT.getClass().isAssignableFrom(ItemData.class)))
					{
						stream.throwTypeReadError(ItemData.class,itemT.getClass());
					}
					this.item.shadowCopy(itemT);
				}
			}
			else
			{
				this.item=null;
			}
		}
		else
		{
			this.item=null;
		}
		
		this.code=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeLong(this.instanceID);
		
		if(this.item!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataFullNotNull(this.item);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeInt(this.code);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.instanceID=stream.readLong();
		
		if(stream.readBoolean())
		{
			this.item=(ItemData)stream.readDataSimpleNotNull();
		}
		else
		{
			this.item=null;
		}
		
		this.code=stream.readInt();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeLong(this.instanceID);
		
		if(this.item!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataSimpleNotNull(this.item);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeInt(this.code);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof AuctionReBuyItemOWData))
			return;
		
		AuctionReBuyItemOWData mData=(AuctionReBuyItemOWData)data;
		
		this.instanceID=mData.instanceID;
		this.item=mData.item;
		this.code=mData.code;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof AuctionReBuyItemOWData))
			return;
		
		AuctionReBuyItemOWData mData=(AuctionReBuyItemOWData)data;
		
		this.instanceID=mData.instanceID;
		
		if(mData.item!=null)
		{
			this.item=(ItemData)mData.item.clone();
		}
		else
		{
			this.item=null;
		}
		
		this.code=mData.code;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		AuctionReBuyItemOWData mData=(AuctionReBuyItemOWData)data;
		if(this.instanceID!=mData.instanceID)
			return false;
		
		if(mData.item!=null)
		{
			if(this.item==null)
				return false;
			if(!this.item.dataEquals(mData.item))
				return false;
		}
		else
		{
			if(this.item!=null)
				return false;
		}
		
		if(this.code!=mData.code)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("instanceID");
		writer.sb.append(':');
		writer.sb.append(this.instanceID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("item");
		writer.sb.append(':');
		if(this.item!=null)
		{
			this.item.writeDataString(writer);
		}
		else
		{
			writer.sb.append("ItemData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("code");
		writer.sb.append(':');
		writer.sb.append(this.code);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		super.initDefault();
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.instanceID=0L;
		this.item=null;
		this.code=0;
	}
	
}
