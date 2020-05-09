package com.home.commonClient.net.response.func.roleGroup;
import com.home.commonBase.data.social.roleGroup.PlayerRoleGroupExData;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.response.func.base.FuncPlayerRoleGroupSResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 回复获取玩家群数据消息(generated by shine) */
public class FuncReGetRoleGroupDataResponse extends FuncPlayerRoleGroupSResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.FuncReGetRoleGroupData;
	
	/** 玩家群数据 */
	public PlayerRoleGroupExData data;
	
	public FuncReGetRoleGroupDataResponse()
	{
		_dataID=GameResponseType.FuncReGetRoleGroupData;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncReGetRoleGroupDataResponse";
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
			if(dataT instanceof PlayerRoleGroupExData)
			{
				this.data=(PlayerRoleGroupExData)dataT;
			}
			else
			{
				this.data=new PlayerRoleGroupExData();
				if(!(dataT.getClass().isAssignableFrom(PlayerRoleGroupExData.class)))
				{
					stream.throwTypeReadError(PlayerRoleGroupExData.class,dataT.getClass());
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
		
		this.data=(PlayerRoleGroupExData)stream.readDataSimpleNotNull();
		
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
		
		this.data=null;
	}
	
}