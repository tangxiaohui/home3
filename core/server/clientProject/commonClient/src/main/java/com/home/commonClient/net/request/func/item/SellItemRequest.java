package com.home.commonClient.net.request.func.item;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** main背包卖出协议(generated by shine) */
public class SellItemRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.SellItem;
	
	/** 格子序号 */
	public int index;
	
	/** 数目 */
	public int num;
	
	/** 道具ID(检验用) */
	public int itemID;
	
	public SellItemRequest()
	{
		_dataID=GameRequestType.SellItem;
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
		return "SellItemRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("index");
		writer.sb.append(':');
		writer.sb.append(this.index);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("num");
		writer.sb.append(':');
		writer.sb.append(this.num);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("itemID");
		writer.sb.append(':');
		writer.sb.append(this.itemID);
		
		writer.writeEnter();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.index);
		
		stream.writeInt(this.num);
		
		stream.writeInt(this.itemID);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.index);
		
		stream.writeInt(this.num);
		
		stream.writeInt(this.itemID);
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.index=0;
		this.num=0;
		this.itemID=0;
	}
	
	/** 创建实例 */
	public static SellItemRequest create(int index,int num,int itemID)
	{
		SellItemRequest re=(SellItemRequest)BytesControl.createRequest(dataID);
		re.index=index;
		re.num=num;
		re.itemID=itemID;
		return re;
	}
	
}