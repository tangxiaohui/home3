package com.home.commonBase.data.item.auction;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.item.auction.AuctionQueryConditionData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 整形拍卖行查询条件(generated by shine) */
public class IntAuctionQueryConditionData extends AuctionQueryConditionData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.IntAuctionQueryCondition;
	
	/** 下限(如相等，则用等号) */
	public int min;
	
	/** 上限 */
	public int max;
	
	public IntAuctionQueryConditionData()
	{
		_dataID=BaseDataType.IntAuctionQueryCondition;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "IntAuctionQueryConditionData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.min=stream.readInt();
		
		this.max=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.min);
		
		stream.writeInt(this.max);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.min=stream.readInt();
		
		this.max=stream.readInt();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.min);
		
		stream.writeInt(this.max);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof IntAuctionQueryConditionData))
			return;
		
		IntAuctionQueryConditionData mData=(IntAuctionQueryConditionData)data;
		
		this.min=mData.min;
		this.max=mData.max;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof IntAuctionQueryConditionData))
			return;
		
		IntAuctionQueryConditionData mData=(IntAuctionQueryConditionData)data;
		
		this.min=mData.min;
		
		this.max=mData.max;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		IntAuctionQueryConditionData mData=(IntAuctionQueryConditionData)data;
		if(this.min!=mData.min)
			return false;
		
		if(this.max!=mData.max)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("min");
		writer.sb.append(':');
		writer.sb.append(this.min);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("max");
		writer.sb.append(':');
		writer.sb.append(this.max);
		
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
		
		this.min=0;
		this.max=0;
	}
	
}
