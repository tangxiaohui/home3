package com.home.commonGame.net.serverRequest.game.func.roleGroup;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.social.RoleSocialData;
import com.home.commonGame.net.serverRequest.game.func.base.FuncRoleGroupToGameServerRequest;
import com.home.commonGame.net.serverRequest.game.func.base.FuncToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 同意邀请入群到逻辑服(generated by shine) */
public class FuncAgreeInviteRoleGroupToGameServerRequest extends FuncToGameServerRequest
{
	public long groupID;
	
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.FuncAgreeInviteRoleGroupToGame;
	
	/** 邀请者 */
	public long invitor;
	
	/** 数据 */
	public RoleSocialData data;
	
	public FuncAgreeInviteRoleGroupToGameServerRequest()
	{
		_dataID=ServerMessageType.FuncAgreeInviteRoleGroupToGame;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		RoleSocialData dataTemp=data;
		if(dataTemp!=null)
		{
			this.data=(RoleSocialData)dataTemp.clone();
		}
		else
		{
			this.data=null;
			nullObjError("data");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncAgreeInviteRoleGroupToGameServerRequest";
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeLong(this.groupID);
		
		stream.writeLong(this.invitor);
		
		if(this.data!=null)
		{
			stream.writeDataSimpleNotNull(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
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
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.groupID=0L;
		this.invitor=0L;
		this.data.release(pool);
		this.data=null;
	}
	
	/** 创建实例 */
	public static FuncAgreeInviteRoleGroupToGameServerRequest create(int funcID,long groupID,long invitor,RoleSocialData data)
	{
		FuncAgreeInviteRoleGroupToGameServerRequest re=(FuncAgreeInviteRoleGroupToGameServerRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.groupID=groupID;
		re.invitor=invitor;
		re.data=data;
		return re;
	}
	
}