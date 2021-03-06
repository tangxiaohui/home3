package com.home.commonClient.net.request.func.item;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.net.request.func.base.FuncRRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 移动物品消息(generated by shine) */
public class FuncMoveItemRequest extends FuncRRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.FuncMoveItem;
	
	/** 从某格子 */
	public int fromIndex;
	
	/** 到某格子 */
	public int toIndex;
	
	public FuncMoveItemRequest()
	{
		_dataID=GameRequestType.FuncMoveItem;
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
		return "FuncMoveItemRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.fromIndex);
		
		stream.writeInt(this.toIndex);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.fromIndex);
		
		stream.writeInt(this.toIndex);
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("fromIndex");
		writer.sb.append(':');
		writer.sb.append(this.fromIndex);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("toIndex");
		writer.sb.append(':');
		writer.sb.append(this.toIndex);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.fromIndex=0;
		this.toIndex=0;
	}
	
	/** 创建实例 */
	public static FuncMoveItemRequest create(int funcID,int fromIndex,int toIndex)
	{
		FuncMoveItemRequest re=(FuncMoveItemRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.fromIndex=fromIndex;
		re.toIndex=toIndex;
		return re;
	}
	
}
