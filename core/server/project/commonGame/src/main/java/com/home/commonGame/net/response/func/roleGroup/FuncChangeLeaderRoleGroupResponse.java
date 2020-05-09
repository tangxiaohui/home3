package com.home.commonGame.net.response.func.roleGroup;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.net.response.func.base.FuncPlayerRoleGroupRResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 禅让群主(generated by shine) */
public class FuncChangeLeaderRoleGroupResponse extends FuncPlayerRoleGroupRResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.FuncChangeLeaderRoleGroup;
	
	/** 目标id */
	public long playerID;
	
	public FuncChangeLeaderRoleGroupResponse()
	{
		_dataID=GameResponseType.FuncChangeLeaderRoleGroup;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncChangeLeaderRoleGroupResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.playerID=stream.readLong();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.playerID=stream.readLong();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("playerID");
		writer.sb.append(':');
		writer.sb.append(this.playerID);
		
		writer.writeEnter();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		roleGroup.changeLeader(playerID);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.playerID=0L;
	}
	
}