package com.home.commonClient.net.request.func.roleGroup;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.net.request.func.base.FuncPlayerRoleGroupRRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 更改群名消息(generated by shine) */
public class FuncChangeRoleGroupNameRequest extends FuncPlayerRoleGroupRRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.FuncChangeRoleGroupName;
	
	/** 名字 */
	public String name="";
	
	public FuncChangeRoleGroupNameRequest()
	{
		_dataID=GameRequestType.FuncChangeRoleGroupName;
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
		return "FuncChangeRoleGroupNameRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeUTF(this.name);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeUTF(this.name);
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("name");
		writer.sb.append(':');
		writer.sb.append(this.name);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.name="";
	}
	
	/** 创建实例 */
	public static FuncChangeRoleGroupNameRequest create(int funcID,long groupID,String name)
	{
		FuncChangeRoleGroupNameRequest re=(FuncChangeRoleGroupNameRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.groupID=groupID;
		re.name=name;
		return re;
	}
	
}