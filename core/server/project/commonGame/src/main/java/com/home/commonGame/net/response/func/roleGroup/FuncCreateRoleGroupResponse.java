package com.home.commonGame.net.response.func.roleGroup;
import com.home.commonBase.data.social.roleGroup.CreateRoleGroupData;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.net.response.func.base.FuncRResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 创建玩家群消息(generated by shine) */
public class FuncCreateRoleGroupResponse extends FuncRResponse
{
	/** 创建数据 */
	public CreateRoleGroupData createData;
	
	/** 数据类型ID */
	public static final int dataID=GameResponseType.FuncCreateRoleGroup;
	
	public FuncCreateRoleGroupResponse()
	{
		_dataID=GameResponseType.FuncCreateRoleGroup;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncCreateRoleGroupResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		BaseData createDataT=stream.readDataFullNotNull();
		if(createDataT!=null)
		{
			if(createDataT instanceof CreateRoleGroupData)
			{
				this.createData=(CreateRoleGroupData)createDataT;
			}
			else
			{
				this.createData=new CreateRoleGroupData();
				if(!(createDataT.getClass().isAssignableFrom(CreateRoleGroupData.class)))
				{
					stream.throwTypeReadError(CreateRoleGroupData.class,createDataT.getClass());
				}
				this.createData.shadowCopy(createDataT);
			}
		}
		else
		{
			this.createData=null;
		}
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.createData=(CreateRoleGroupData)stream.readDataSimpleNotNull();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("createData");
		writer.sb.append(':');
		if(this.createData!=null)
		{
			this.createData.writeDataString(writer);
		}
		else
		{
			writer.sb.append("CreateRoleGroupData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.func.getRoleGroupTool(funcID).createRoleGroup(createData);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.createData=null;
	}
	
}
