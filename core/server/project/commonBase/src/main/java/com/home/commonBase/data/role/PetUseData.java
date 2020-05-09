package com.home.commonBase.data.role;
import com.home.commonBase.config.game.PetConfig;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.role.MUnitUseData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;

/** (generated by shine) */
public class PetUseData extends MUnitUseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.PetUse;
	
	public PetUseData()
	{
		_dataID=BaseDataType.PetUse;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "PetUseData";
	}
	
	@Override
	public int getFightUnitID()
	{
		return PetConfig.get(id).fightUnitID;
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