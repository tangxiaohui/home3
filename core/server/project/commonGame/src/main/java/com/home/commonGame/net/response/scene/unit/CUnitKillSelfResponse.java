package com.home.commonGame.net.response.scene.unit;
import com.home.commonBase.scene.base.Unit;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.net.response.scene.base.CUnitRResponse;
import com.home.commonGame.net.response.scene.base.SceneRResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;

/** 控制单位自杀消息(generated by shine) */
public class CUnitKillSelfResponse extends CUnitRResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.CUnitKillSelf;
	
	public CUnitKillSelfResponse()
	{
		_dataID=GameResponseType.CUnitKillSelf;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		unit.fight.clientKillSelf();
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CUnitKillSelfResponse";
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