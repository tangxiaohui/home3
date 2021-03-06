package com.home.commonGame.net.request.func.roleGroup;
import com.home.commonBase.data.social.roleGroup.RoleGroupMemberChangeData;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.request.func.base.FuncPlayerRoleGroupSRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 玩家群成员数据改变消息(generated by shine) */
public class FuncSendRoleGroupMemberChangeRequest extends FuncPlayerRoleGroupSRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.FuncSendRoleGroupMemberChange;
	
	public long memberID;
	
	public RoleGroupMemberChangeData data;
	
	public FuncSendRoleGroupMemberChangeRequest()
	{
		_dataID=GameRequestType.FuncSendRoleGroupMemberChange;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		RoleGroupMemberChangeData dataTemp=data;
		if(dataTemp!=null)
		{
			this.data=(RoleGroupMemberChangeData)dataTemp.clone();
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
		return "FuncSendRoleGroupMemberChangeRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeLong(this.memberID);
		
		if(this.data!=null)
		{
			stream.writeDataFullNotNull(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeLong(this.memberID);
		
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
		writer.sb.append("memberID");
		writer.sb.append(':');
		writer.sb.append(this.memberID);
		
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
			writer.sb.append("RoleGroupMemberChangeData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.memberID=0L;
		this.data.release(pool);
		this.data=null;
	}
	
	/** 创建实例 */
	public static FuncSendRoleGroupMemberChangeRequest create(int funcID,long groupID,long memberID,RoleGroupMemberChangeData data)
	{
		FuncSendRoleGroupMemberChangeRequest re=(FuncSendRoleGroupMemberChangeRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.groupID=groupID;
		re.memberID=memberID;
		re.data=data;
		return re;
	}
	
}
