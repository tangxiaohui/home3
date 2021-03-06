package com.home.commonGame.net.request.func.roleGroup;
import com.home.commonBase.data.role.RoleShowData;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.request.func.base.FuncSRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送处理邀请结果到邀请者(generated by shine) */
public class FuncSendHandleInviteResultRoleGroupRequest extends FuncSRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.FuncSendHandleInviteResultRoleGroup;
	
	/** 被邀请者 */
	public RoleShowData showData;
	
	public int result;
	
	public FuncSendHandleInviteResultRoleGroupRequest()
	{
		_dataID=GameRequestType.FuncSendHandleInviteResultRoleGroup;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		RoleShowData showDataTemp=showData;
		if(showDataTemp!=null)
		{
			this.showData=(RoleShowData)showDataTemp.clone();
		}
		else
		{
			this.showData=null;
			nullObjError("showData");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncSendHandleInviteResultRoleGroupRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.showData!=null)
		{
			stream.writeDataFullNotNull(this.showData);
		}
		else
		{
			nullObjError("showData");
		}
		
		stream.writeInt(this.result);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.showData!=null)
		{
			stream.writeDataSimpleNotNull(this.showData);
		}
		else
		{
			nullObjError("showData");
		}
		
		stream.writeInt(this.result);
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("showData");
		writer.sb.append(':');
		if(this.showData!=null)
		{
			this.showData.writeDataString(writer);
		}
		else
		{
			writer.sb.append("RoleShowData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("result");
		writer.sb.append(':');
		writer.sb.append(this.result);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.showData.release(pool);
		this.showData=null;
		this.result=0;
	}
	
	/** 创建实例 */
	public static FuncSendHandleInviteResultRoleGroupRequest create(int funcID,RoleShowData showData,int result)
	{
		FuncSendHandleInviteResultRoleGroupRequest re=(FuncSendHandleInviteResultRoleGroupRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.showData=showData;
		re.result=result;
		return re;
	}
	
}
