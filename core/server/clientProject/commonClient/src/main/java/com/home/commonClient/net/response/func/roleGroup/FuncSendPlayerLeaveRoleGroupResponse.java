package com.home.commonClient.net.response.func.roleGroup;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.response.func.base.FuncSResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送玩家离开玩家群消息(generated by shine) */
public class FuncSendPlayerLeaveRoleGroupResponse extends FuncSResponse
{
	/** 方式 */
	public int type;
	
	public long groupID;
	
	/** 数据类型ID */
	public static final int dataID=GameResponseType.FuncSendPlayerLeaveRoleGroup;
	
	public FuncSendPlayerLeaveRoleGroupResponse()
	{
		_dataID=GameResponseType.FuncSendPlayerLeaveRoleGroup;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncSendPlayerLeaveRoleGroupResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.groupID=stream.readLong();
		
		this.type=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.func.getRoleGroupTool(funcID).onLeaveRoleGroup(groupID,type);
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.groupID=stream.readLong();
		
		this.type=stream.readInt();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("groupID");
		writer.sb.append(':');
		writer.sb.append(this.groupID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("type");
		writer.sb.append(':');
		writer.sb.append(this.type);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.groupID=0L;
		this.type=0;
	}
	
}
