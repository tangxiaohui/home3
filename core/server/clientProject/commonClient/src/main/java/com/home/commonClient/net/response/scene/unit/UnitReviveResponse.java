package com.home.commonClient.net.response.scene.unit;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.constlist.generate.MGameResponseType;
import com.home.commonClient.net.response.scene.base.SceneSResponse;
import com.home.commonClient.net.response.scene.base.UnitSResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;

/** 单位复活消息(generated by shine) */
public class UnitReviveResponse extends UnitSResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.UnitRevive;
	
	public UnitReviveResponse()
	{
		_dataID=GameResponseType.UnitRevive;
	}
	
	/** 执行 */
	protected void execute()
	{
		scene.getFightUnitAbs(instanceID).fight.onRevive();
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "UnitReviveResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		stream.endReadObj();
	}
	
}