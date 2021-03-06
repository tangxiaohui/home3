package com.home.commonClient.net.response.scene.unit;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.constlist.generate.MGameResponseType;
import com.home.commonClient.net.response.scene.base.SceneSResponse;
import com.home.commonClient.net.response.scene.base.UnitSResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 单位移除buff(generated by shine) */
public class UnitRemoveBuffResponse extends UnitSResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.UnitRemoveBuff;
	
	/** buff实例ID */
	public int buffInstanceID;
	
	public UnitRemoveBuffResponse()
	{
		_dataID=GameResponseType.UnitRemoveBuff;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		scene.getFightUnitAbs(instanceID).fight.getBuffLogic().removeBuffByInstanceID(buffInstanceID);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "UnitRemoveBuffResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.buffInstanceID=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.buffInstanceID=stream.readInt();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("buffInstanceID");
		writer.sb.append(':');
		writer.sb.append(this.buffInstanceID);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.buffInstanceID=0;
	}
	
}
