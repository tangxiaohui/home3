package com.home.commonBase.part.player.data;
import com.home.commonBase.constlist.generate.PlayerPartDataType;
import com.home.commonBase.part.player.data.BagPartData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;

/** 单一背包模块(generated by shine) */
public class SingleBagPartData extends BagPartData
{
	/** 数据类型ID */
	public static final int dataID=PlayerPartDataType.SingleBag;
	
	public SingleBagPartData()
	{
		_dataID=PlayerPartDataType.SingleBag;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "SingleBagPartData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.endWriteObj();
	}
	
}
