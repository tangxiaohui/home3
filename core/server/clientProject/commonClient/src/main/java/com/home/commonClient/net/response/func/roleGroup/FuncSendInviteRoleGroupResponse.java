package com.home.commonClient.net.response.func.roleGroup;
import com.home.commonBase.data.social.roleGroup.InviteRoleGroupReceiveData;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.response.func.base.FuncSResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送邀请加入玩家群消息(generated by shine) */
public class FuncSendInviteRoleGroupResponse extends FuncSResponse
{
	public InviteRoleGroupReceiveData data;
	
	/** 数据类型ID */
	public static final int dataID=GameResponseType.FuncSendInviteRoleGroup;
	
	public FuncSendInviteRoleGroupResponse()
	{
		_dataID=GameResponseType.FuncSendInviteRoleGroup;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncSendInviteRoleGroupResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		BaseData dataT=stream.readDataFullNotNull();
		if(dataT!=null)
		{
			if(dataT instanceof InviteRoleGroupReceiveData)
			{
				this.data=(InviteRoleGroupReceiveData)dataT;
			}
			else
			{
				this.data=new InviteRoleGroupReceiveData();
				if(!(dataT.getClass().isAssignableFrom(InviteRoleGroupReceiveData.class)))
				{
					stream.throwTypeReadError(InviteRoleGroupReceiveData.class,dataT.getClass());
				}
				this.data.shadowCopy(dataT);
			}
		}
		else
		{
			this.data=null;
		}
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.data=(InviteRoleGroupReceiveData)stream.readDataSimpleNotNull();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("data");
		writer.sb.append(':');
		if(this.data!=null)
		{
			this.data.writeDataString(writer);
		}
		else
		{
			writer.sb.append("InviteRoleGroupReceiveData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.func.getRoleGroupTool(funcID).receiveInviteRoleGroup(data);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.data=null;
	}
	
}