package com.home.commonBase.data.social.union;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.social.roleGroup.PlayerRoleGroupSaveData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;

/** 角色工会存储数据(generated by shine) */
public class PlayerUnionSaveData extends PlayerRoleGroupSaveData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.PlayerUnionSave;
	
	public PlayerUnionSaveData()
	{
		_dataID=BaseDataType.PlayerUnionSave;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "PlayerUnionSaveData";
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