package com.home.commonClient.net.response.func.roleGroup;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.response.func.base.FuncPlayerRoleGroupSResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 群里有权限成员通知处理申请结果(generated by shine) */
public class FuncSendHandleApplyResultToMemberResponse extends FuncPlayerRoleGroupSResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.FuncSendHandleApplyResultToMember;
	
	/** 目标id */
	public long targetID;
	
	/** 结果 */
	public int result;
	
	public FuncSendHandleApplyResultToMemberResponse()
	{
		_dataID=GameResponseType.FuncSendHandleApplyResultToMember;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncSendHandleApplyResultToMemberResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.targetID=stream.readLong();
		
		this.result=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.targetID=stream.readLong();
		
		this.result=stream.readInt();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("targetID");
		writer.sb.append(':');
		writer.sb.append(this.targetID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("result");
		writer.sb.append(':');
		writer.sb.append(this.result);
		
		writer.writeEnter();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		roleGroup.onApplyHandleResult(targetID,result);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.targetID=0L;
		this.result=0;
	}
	
}
