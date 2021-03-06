package com.home.commonGame.net.response.func.item;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.net.response.func.base.FuncRResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 移动装备消息(generated by shine) */
public class FuncMoveEquipResponse extends FuncRResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.FuncMoveEquip;
	
	public int fromSlot;
	
	public int toSlot;
	
	public FuncMoveEquipResponse()
	{
		_dataID=GameResponseType.FuncMoveEquip;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncMoveEquipResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.fromSlot=stream.readInt();
		
		this.toSlot=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.fromSlot=stream.readInt();
		
		this.toSlot=stream.readInt();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("fromSlot");
		writer.sb.append(':');
		writer.sb.append(this.fromSlot);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("toSlot");
		writer.sb.append(':');
		writer.sb.append(this.toSlot);
		
		writer.writeEnter();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.func.getEquipContainerTool(funcID).moveEquip(fromSlot,toSlot);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.fromSlot=0;
		this.toSlot=0;
	}
	
}
