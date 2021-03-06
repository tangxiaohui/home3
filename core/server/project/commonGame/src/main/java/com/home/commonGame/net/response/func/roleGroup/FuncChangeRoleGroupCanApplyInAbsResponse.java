package com.home.commonGame.net.response.func.roleGroup;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.net.response.func.base.FuncPlayerRoleGroupRResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 更改申请时是否可直接入群(generated by shine) */
public class FuncChangeRoleGroupCanApplyInAbsResponse extends FuncPlayerRoleGroupRResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.FuncChangeRoleGroupCanApplyInAbs;
	
	/** 申请时是否可直接入群(无需同意) */
	public boolean canApplyInAbs;
	
	public FuncChangeRoleGroupCanApplyInAbsResponse()
	{
		_dataID=GameResponseType.FuncChangeRoleGroupCanApplyInAbs;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncChangeRoleGroupCanApplyInAbsResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.canApplyInAbs=stream.readBoolean();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.canApplyInAbs=stream.readBoolean();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("canApplyInAbs");
		writer.sb.append(':');
		writer.sb.append(this.canApplyInAbs);
		
		writer.writeEnter();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		roleGroup.changeCanApplyInAbs(canApplyInAbs);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.canApplyInAbs=false;
	}
	
}
