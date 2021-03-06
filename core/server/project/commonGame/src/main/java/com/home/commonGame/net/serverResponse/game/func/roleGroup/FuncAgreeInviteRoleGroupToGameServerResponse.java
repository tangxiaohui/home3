package com.home.commonGame.net.serverResponse.game.func.roleGroup;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.social.RoleSocialData;
import com.home.commonGame.global.GameC;
import com.home.commonGame.net.serverResponse.game.func.base.FuncRoleGroupToGameServerResponse;
import com.home.commonGame.net.serverResponse.game.func.base.FuncToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 同意邀请入群到逻辑服(generated by shine) */
public class FuncAgreeInviteRoleGroupToGameServerResponse extends FuncToGameServerResponse
{
	public long groupID;
	
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.FuncAgreeInviteRoleGroupToGame;
	
	/** 邀请者 */
	public long invitor;
	
	/** 数据 */
	public RoleSocialData data;
	
	public FuncAgreeInviteRoleGroupToGameServerResponse()
	{
		_dataID=ServerMessageType.FuncAgreeInviteRoleGroupToGame;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncAgreeInviteRoleGroupToGameServerResponse";
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.groupID=stream.readLong();
		
		this.invitor=stream.readLong();
		
		this.data=(RoleSocialData)stream.readDataSimpleNotNull();
		
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
		writer.sb.append("invitor");
		writer.sb.append(':');
		writer.sb.append(this.invitor);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("data");
		writer.sb.append(':');
		if(this.data!=null)
		{
			this.data.writeDataString(writer);
		}
		else
		{
			writer.sb.append("RoleSocialData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		GameC.global.func.getRoleGroupTool(funcID).beInviteJoin(groupID,invitor,data);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.groupID=0L;
		this.invitor=0L;
		this.data=null;
	}
	
}
