package com.home.commonGame.net.request.func.roleGroup;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.request.func.base.FuncPlayerRoleGroupSRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送更换队长消息(generated by shine) */
public class FuncSendChangeLeaderRoleGroupRequest extends FuncPlayerRoleGroupSRequest
{
	/** 上次队长 */
	public long lastLeader;
	
	/** 数据类型ID */
	public static final int dataID=GameRequestType.FuncSendChangeLeaderRoleGroup;
	
	/** 现在的队长 */
	public long nowLeader;
	
	public FuncSendChangeLeaderRoleGroupRequest()
	{
		_dataID=GameRequestType.FuncSendChangeLeaderRoleGroup;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncSendChangeLeaderRoleGroupRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeLong(this.lastLeader);
		
		stream.writeLong(this.nowLeader);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeLong(this.lastLeader);
		
		stream.writeLong(this.nowLeader);
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("lastLeader");
		writer.sb.append(':');
		writer.sb.append(this.lastLeader);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("nowLeader");
		writer.sb.append(':');
		writer.sb.append(this.nowLeader);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.lastLeader=0L;
		this.nowLeader=0L;
	}
	
	/** 创建实例 */
	public static FuncSendChangeLeaderRoleGroupRequest create(int funcID,long groupID,long lastLeader,long nowLeader)
	{
		FuncSendChangeLeaderRoleGroupRequest re=(FuncSendChangeLeaderRoleGroupRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.groupID=groupID;
		re.lastLeader=lastLeader;
		re.nowLeader=nowLeader;
		return re;
	}
	
}