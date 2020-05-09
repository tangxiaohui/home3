package com.home.commonGame.net.response.scene.unit.building;
import com.home.commonBase.scene.unit.BuildingIdentityLogic;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.net.response.scene.base.CUnitRResponse;
import com.home.shine.bytes.BytesReadStream;

/** 客户端请求建筑升级 注意:包含父类参数 instanceID(generated by shine) */
public class CBuildingLevelUpResponse extends CUnitRResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.CBuildingLevelUp;
	
	public CBuildingLevelUpResponse()
	{
		_dataID=GameResponseType.CBuildingLevelUp;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CBuildingLevelUpResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		stream.endReadObj();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		unit.getBuildingIdentityLogic().startLevelUp();
	}
	
}