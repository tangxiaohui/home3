package com.home.commonGame.net.serverResponse.game.func.base;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.global.GameC;
import com.home.commonGame.logic.func.RoleGroup;
import com.home.commonGame.net.serverResponse.game.func.base.FuncToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class FuncRoleGroupToGameServerResponse extends FuncToGameServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.FuncRoleGroupToGame;
	
	public long groupID;
	
	public RoleGroup roleGroup;
	
	public FuncRoleGroupToGameServerResponse()
	{
		_dataID=ServerMessageType.FuncRoleGroupToGame;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncRoleGroupToGameServerResponse";
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.groupID=stream.readLong();
		
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
	}
	
	@Override
	protected void preExecute()
	{
		if((roleGroup=GameC.main.getRoleGroup(funcID,groupID))!=null)
		{
			doExecute();
		}
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.groupID=0L;
	}
	
}