package com.home.commonClient.net.response.func.item;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.response.func.base.FuncSResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送移动物品(generated by shine) */
public class FuncSendMoveItemResponse extends FuncSResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.FuncSendMoveItem;
	
	/** 从某格子 */
	public int fromIndex;
	
	/** 到某格子 */
	public int toIndex;
	
	public FuncSendMoveItemResponse()
	{
		_dataID=GameResponseType.FuncSendMoveItem;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncSendMoveItemResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.fromIndex=stream.readInt();
		
		this.toIndex=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.fromIndex=stream.readInt();
		
		this.toIndex=stream.readInt();
		
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
	
	/** 执行 */
	@Override
	protected void execute()
	{
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.fromIndex=0;
		this.toIndex=0;
	}
	
}