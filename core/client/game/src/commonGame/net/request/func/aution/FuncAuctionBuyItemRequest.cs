using ShineEngine;

/// <summary>
/// 拍卖行购买消息(generated by shine)
/// </summary>
public class FuncAuctionBuyItemRequest:FuncRRequest
{
	/// <summary>
	/// 购买物品数据
	/// </summary>
	public AuctionBuyItemData data;
	
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameRequestType.FuncAuctionBuyItem;
	
	public FuncAuctionBuyItemRequest()
	{
		_dataID=GameRequestType.FuncAuctionBuyItem;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "FuncAuctionBuyItemRequest";
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.data!=null)
		{
			stream.writeDataFullNotNull(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		if(this.data!=null)
		{
			stream.writeDataSimpleNotNull(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("data");
		writer.sb.Append(':');
		if(this.data!=null)
		{
			this.data.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("AuctionBuyItemData=null");
		}
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.data.release(pool);
		this.data=null;
	}
	
	protected override void copyData()
	{
		base.copyData();
		AuctionBuyItemData dataTemp=data;
		if(dataTemp!=null)
		{
			this.data=(AuctionBuyItemData)dataTemp.clone();
		}
		else
		{
			this.data=null;
			nullObjError("data");
		}
		
	}
	
	/// <summary>
	/// 创建实例
	/// </summary>
	public static FuncAuctionBuyItemRequest create(int funcID,AuctionBuyItemData data)
	{
		FuncAuctionBuyItemRequest re=(FuncAuctionBuyItemRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.data=data;
		return re;
	}
	
}
