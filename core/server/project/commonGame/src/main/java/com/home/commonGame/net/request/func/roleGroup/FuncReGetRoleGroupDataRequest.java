package com.home.commonGame.net.request.func.roleGroup;
import com.home.commonBase.data.social.roleGroup.PlayerRoleGroupExData;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.request.func.base.FuncPlayerRoleGroupSRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 回复获取玩家群数据消息(generated by shine) */
public class FuncReGetRoleGroupDataRequest extends FuncPlayerRoleGroupSRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.FuncReGetRoleGroupData;
	
	/** 玩家群数据 */
	public PlayerRoleGroupExData data;
	
	public FuncReGetRoleGroupDataRequest()
	{
		_dataID=GameRequestType.FuncReGetRoleGroupData;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		PlayerRoleGroupExData dataTemp=data;
		if(dataTemp!=null)
		{
			this.data=(PlayerRoleGroupExData)dataTemp.clone();
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
		return "FuncReGetRoleGroupDataRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
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
		writer.sb.append("data");
		writer.sb.append(':');
		if(this.data!=null)
		{
			this.data.writeDataString(writer);
		}
		else
		{
			writer.sb.append("PlayerRoleGroupExData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.data.release(pool);
		this.data=null;
	}
	
	/** 创建实例 */
	public static FuncReGetRoleGroupDataRequest create(int funcID,long groupID,PlayerRoleGroupExData data)
	{
		FuncReGetRoleGroupDataRequest re=(FuncReGetRoleGroupDataRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.groupID=groupID;
		re.data=data;
		return re;
	}
	
}