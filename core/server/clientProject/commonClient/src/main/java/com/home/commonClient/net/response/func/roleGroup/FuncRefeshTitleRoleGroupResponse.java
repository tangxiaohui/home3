package com.home.commonClient.net.response.func.roleGroup;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.response.func.base.FuncPlayerRoleGroupSResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 更新成员职位(generated by shine) */
public class FuncRefeshTitleRoleGroupResponse extends FuncPlayerRoleGroupSResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.FuncRefeshTitleRoleGroup;
	
	/** 成员id */
	public long memberID;
	
	/** 职位 */
	public int title;
	
	public FuncRefeshTitleRoleGroupResponse()
	{
		_dataID=GameResponseType.FuncRefeshTitleRoleGroup;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncRefeshTitleRoleGroupResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.memberID=stream.readLong();
		
		this.title=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.memberID=stream.readLong();
		
		this.title=stream.readInt();
		
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
		writer.sb.append("title");
		writer.sb.append(':');
		writer.sb.append(this.title);
		
		writer.writeEnter();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		roleGroup.onSetTitle(memberID,title);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.memberID=0L;
		this.title=0;
	}
	
}
