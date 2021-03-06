package com.home.commonClient.net.request.func.item;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.net.request.func.base.FuncRRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 穿戴装备(从背包)(generated by shine) */
public class FuncPutOnEquipRequest extends FuncRRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.FuncPutOnEquip;
	
	/** 背包序号 */
	public int bagIndex;
	
	/** 装备槽位 */
	public int slot;
	
	public FuncPutOnEquipRequest()
	{
		_dataID=GameRequestType.FuncPutOnEquip;
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
		return "FuncPutOnEquipRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.slot);
		
		stream.writeInt(this.bagIndex);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.slot);
		
		stream.writeInt(this.bagIndex);
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("slot");
		writer.sb.append(':');
		writer.sb.append(this.slot);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("bagIndex");
		writer.sb.append(':');
		writer.sb.append(this.bagIndex);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.slot=0;
		this.bagIndex=0;
	}
	
	/** 创建实例 */
	public static FuncPutOnEquipRequest create(int funcID,int slot,int bagIndex)
	{
		FuncPutOnEquipRequest re=(FuncPutOnEquipRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.slot=slot;
		re.bagIndex=bagIndex;
		return re;
	}
	
}
