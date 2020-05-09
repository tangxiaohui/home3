package com.home.commonGame.net.response.func.aution;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.net.response.func.base.FuncRResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 取消上架拍卖行物品消息(generated by shine) */
public class FuncAuctionCancelSellItemResponse extends FuncRResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.FuncAuctionCancelSellItem;
	
	/** 实例id */
	public long instanceID;
	
	public FuncAuctionCancelSellItemResponse()
	{
		_dataID=GameResponseType.FuncAuctionCancelSellItem;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncAuctionCancelSellItemResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.instanceID=stream.readLong();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.instanceID=stream.readLong();
		
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
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.func.getAuctionTool(funcID).cancelSellItem(instanceID);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.instanceID=0L;
	}
	
}