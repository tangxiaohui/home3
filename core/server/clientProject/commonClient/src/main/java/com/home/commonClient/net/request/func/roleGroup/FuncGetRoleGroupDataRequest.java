package com.home.commonClient.net.request.func.roleGroup;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.net.request.func.base.FuncPlayerRoleGroupRRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;

/** 获取玩家群数据消息(generated by shine) */
public class FuncGetRoleGroupDataRequest extends FuncPlayerRoleGroupRRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.FuncGetRoleGroupData;
	
	public FuncGetRoleGroupDataRequest()
	{
		_dataID=GameRequestType.FuncGetRoleGroupData;
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
		return "FuncGetRoleGroupDataRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.endWriteObj();
	}
	
	/** 创建实例 */
	public static FuncGetRoleGroupDataRequest create(int funcID,long groupID)
	{
		FuncGetRoleGroupDataRequest re=(FuncGetRoleGroupDataRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.groupID=groupID;
		return re;
	}
	
}