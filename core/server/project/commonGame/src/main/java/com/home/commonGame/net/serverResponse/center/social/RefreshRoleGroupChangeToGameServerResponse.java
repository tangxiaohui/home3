package com.home.commonGame.net.serverResponse.center.social;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.social.roleGroup.RoleGroupChangeData;
import com.home.commonGame.global.GameC;
import com.home.commonGame.net.serverResponse.center.base.CenterToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 刷新(generated by shine) */
public class RefreshRoleGroupChangeToGameServerResponse extends CenterToGameServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.RefreshRoleGroupChangeToGame;
	
	public int funcID;
	
	public long groupID;
	
	public RoleGroupChangeData data;
	
	public RefreshRoleGroupChangeToGameServerResponse()
	{
		_dataID=ServerMessageType.RefreshRoleGroupChangeToGame;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "RefreshRoleGroupChangeToGameServerResponse";
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.funcID=stream.readInt();
		
		this.groupID=stream.readLong();
		
		this.data=(RoleGroupChangeData)stream.readDataSimpleNotNull();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("funcID");
		writer.sb.append(':');
		writer.sb.append(this.funcID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("groupID");
		writer.sb.append(':');
		writer.sb.append(this.groupID);
		
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
			writer.sb.append("RoleGroupChangeData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		GameC.global.func.getRoleGroupTool(funcID).onRoleGroupSimpleChange(groupID,data);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.funcID=0;
		this.groupID=0L;
		this.data=null;
	}
	
}