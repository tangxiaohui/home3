package com.home.commonClient.net.request.func.aution;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.net.request.func.base.FuncRRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 获取拍卖行物品推荐价格(generated by shine) */
public class FuncGetAuctionItemSuggestPriceRequest extends FuncRRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.FuncGetAuctionItemSuggestPrice;
	
	public int itemID;
	
	public FuncGetAuctionItemSuggestPriceRequest()
	{
		_dataID=GameRequestType.FuncGetAuctionItemSuggestPrice;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncGetAuctionItemSuggestPriceRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.itemID);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.itemID);
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("itemID");
		writer.sb.append(':');
		writer.sb.append(this.itemID);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.itemID=0;
	}
	
	/** 创建实例 */
	public static FuncGetAuctionItemSuggestPriceRequest create(int funcID,int itemID)
	{
		FuncGetAuctionItemSuggestPriceRequest re=(FuncGetAuctionItemSuggestPriceRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.itemID=itemID;
		return re;
	}
	
}
