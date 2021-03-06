package com.home.commonGame.net.request.func.auction;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.request.func.base.FuncSRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 拍卖行移除自己的物品消息(generated by shine) */
public class FuncAuctionRemoveSaleItemRequest extends FuncSRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.FuncAuctionRemoveSaleItem;
	
	/** 原因 */
	public int code;
	
	/** 实例ID */
	public long instanceID;
	
	public FuncAuctionRemoveSaleItemRequest()
	{
		_dataID=GameRequestType.FuncAuctionRemoveSaleItem;
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
		return "FuncAuctionRemoveSaleItemRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeLong(this.instanceID);
		
		stream.writeInt(this.code);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeLong(this.instanceID);
		
		stream.writeInt(this.code);
		
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
		writer.sb.append("code");
		writer.sb.append(':');
		writer.sb.append(this.code);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.instanceID=0L;
		this.code=0;
	}
	
	/** 创建实例 */
	public static FuncAuctionRemoveSaleItemRequest create(int funcID,long instanceID,int code)
	{
		FuncAuctionRemoveSaleItemRequest re=(FuncAuctionRemoveSaleItemRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.instanceID=instanceID;
		re.code=code;
		return re;
	}
	
}
