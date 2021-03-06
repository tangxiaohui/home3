package com.home.commonGame.net.serverRequest.game.func.roleGroup;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.net.serverRequest.game.func.base.FuncPlayerRoleGroupGameToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 玩家群移除成员(generated by shine) */
public class FuncSendRoleGroupRemoveMemberToPlayerServerRequest extends FuncPlayerRoleGroupGameToGameServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.FuncSendRoleGroupRemoveMemberToPlayer;
	
	/** 方式 */
	public int type;
	
	/** 成员id */
	public long playerID;
	
	public FuncSendRoleGroupRemoveMemberToPlayerServerRequest()
	{
		_dataID=ServerMessageType.FuncSendRoleGroupRemoveMemberToPlayer;
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
		return "FuncSendRoleGroupRemoveMemberToPlayerServerRequest";
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeLong(this.playerID);
		
		stream.writeInt(this.type);
		
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
		
		this.playerID=0L;
		this.type=0;
	}
	
	/** 创建实例 */
	public static FuncSendRoleGroupRemoveMemberToPlayerServerRequest create(int funcID,long groupID,long playerID,int type)
	{
		FuncSendRoleGroupRemoveMemberToPlayerServerRequest re=(FuncSendRoleGroupRemoveMemberToPlayerServerRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.groupID=groupID;
		re.playerID=playerID;
		re.type=type;
		return re;
	}
	
}
