package com.home.commonGame.net.response.scene.syncScene;
import com.home.commonBase.constlist.generate.SceneInstanceType;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.net.response.scene.base.SceneRResponse;
import com.home.commonGame.scene.scene.PreBattleScenePlayLogic;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 单位确认选择(generated by shine) */
public class CUnitPreBattleSureResponse extends SceneRResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.CUnitPreBattleSure;
	
	/** 实例ID */
	public int instanceID;
	
	public CUnitPreBattleSureResponse()
	{
		_dataID=GameResponseType.CUnitPreBattleSure;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		//不是预备场景
		if(scene.getConfig().instanceType!=SceneInstanceType.PreBattle)
			return;
		
		//能控制
		if(scene.getPlayerControlUnit(me,instanceID)!=null)
		{
			((PreBattleScenePlayLogic)scene.gamePlay).unitSure(me.role.playerID);
		}
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CUnitPreBattleSureResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.instanceID=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.instanceID=stream.readInt();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("instanceID");
		writer.sb.append(':');
		writer.sb.append(this.instanceID);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.instanceID=0;
	}
	
}
