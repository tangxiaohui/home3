package com.home.commonGame.net.response.func.roleGroup;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.net.response.func.base.FuncPlayerRoleGroupRResponse;
import com.home.shine.bytes.BytesReadStream;

/** 解散玩家群(generated by shine) */
public class FuncDisbandRoleGroupResponse extends FuncPlayerRoleGroupRResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.FuncDisbandRoleGroup;
	
	public FuncDisbandRoleGroupResponse()
	{
		_dataID=GameResponseType.FuncDisbandRoleGroup;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncDisbandRoleGroupResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		stream.endReadObj();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		roleGroup.disband();
	}
	
}