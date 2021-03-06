package com.home.commonGame.net.serverResponse.game.func.auction;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.item.auction.AuctionItemData;
import com.home.commonGame.global.GameC;
import com.home.commonGame.net.serverResponse.game.func.base.FuncToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.constlist.ThreadType;
import com.home.shine.control.ThreadControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送拍卖行出售物品到源服(generated by shine) */
public class FuncSendAuctionSellItemToSourceGameServerResponse extends FuncToGameServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.FuncSendAuctionSellItemToSourceGame;
	
	/** 出售物品 */
	public AuctionItemData data;
	
	public FuncSendAuctionSellItemToSourceGameServerResponse()
	{
		_dataID=ServerMessageType.FuncSendAuctionSellItemToSourceGame;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncSendAuctionSellItemToSourceGameServerResponse";
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.data=(AuctionItemData)stream.readDataSimpleNotNull();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("data");
		writer.sb.append(':');
		if(this.data!=null)
		{
			this.data.writeDataString(writer);
		}
		else
		{
			writer.sb.append("AuctionItemData=null");
		}
		
		writer.writeEnter();
	}
	
	@Override
	public void dispatch()
	{
		_threadType=ThreadType.Pool;
		_poolIndex=(int)data.instanceID & ThreadControl.poolThreadNumMark;
		doDispatch();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		GameC.global.func.getAuctionTool(funcID).getExecutor(_poolIndex).sellItem(data);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.data=null;
	}
	
}
