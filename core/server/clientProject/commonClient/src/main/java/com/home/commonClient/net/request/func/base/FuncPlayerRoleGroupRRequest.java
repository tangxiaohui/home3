package com.home.commonClient.net.request.func.base;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.net.request.func.base.FuncRRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class FuncPlayerRoleGroupRRequest extends FuncRRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.FuncPlayerRoleGroupR;
	
	public long groupID;
	
	public FuncPlayerRoleGroupRRequest()
	{
		_dataID=GameRequestType.FuncPlayerRoleGroupR;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncPlayerRoleGroupRRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeLong(this.groupID);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeLong(this.groupID);
		
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
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.groupID=0L;
	}
	
	/** 创建实例 */
	public static FuncPlayerRoleGroupRRequest create(int funcID,long groupID)
	{
		FuncPlayerRoleGroupRRequest re=(FuncPlayerRoleGroupRRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.groupID=groupID;
		return re;
	}
	
}
