package com.home.commonBase.data.item;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;

/** 使用物品参数数据(generated by shine) */
public class UseItemArgData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.UseItemArg;
	
	public UseItemArgData()
	{
		_dataID=BaseDataType.UseItemArg;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "UseItemArgData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.endWriteObj();
	}
	
}
