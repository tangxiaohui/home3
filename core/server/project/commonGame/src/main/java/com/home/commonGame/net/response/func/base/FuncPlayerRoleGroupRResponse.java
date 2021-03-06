package com.home.commonGame.net.response.func.base;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.logic.func.PlayerRoleGroup;
import com.home.commonGame.net.response.func.base.FuncRResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class FuncPlayerRoleGroupRResponse extends FuncRResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.FuncPlayerRoleGroupR;
	
	public long groupID;
	
	public PlayerRoleGroup roleGroup;
	
	public FuncPlayerRoleGroupRResponse()
	{
		_dataID=GameResponseType.FuncPlayerRoleGroupR;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncPlayerRoleGroupRResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.groupID=stream.readLong();
		
		stream.endReadObj();
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
		if((roleGroup=me.func.getRoleGroupTool(funcID).getRoleGroup(groupID))!=null)
		{
			super.preExecute();
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
