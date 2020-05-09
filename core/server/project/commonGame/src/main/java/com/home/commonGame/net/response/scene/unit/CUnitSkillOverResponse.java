package com.home.commonGame.net.response.scene.unit;
import com.home.commonBase.scene.base.Unit;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.net.response.scene.base.CUnitRResponse;
import com.home.commonGame.net.response.scene.base.SceneRResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;

/** 控制单位使用Attack(客户端驱动attack时用)(generated by shine) */
public class CUnitSkillOverResponse extends CUnitRResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.CUnitSkillOver;
	
	public CUnitSkillOverResponse()
	{
		_dataID=GameResponseType.CUnitSkillOver;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		unit.fight.clientSkillOver();
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CUnitSkillOverResponse";
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