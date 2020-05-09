package com.home.commonGame.net.serverRequest.game.func.roleGroup;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.net.serverRequest.game.base.GameToGameServerRequest;
import com.home.commonGame.net.serverRequest.game.func.base.FuncRoleGroupToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 更改玩家群申请方式(generated by shine) */
public class FuncChangeRoleGroupApplyTypeToGameServerRequest extends FuncRoleGroupToGameServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.FuncChangeRoleGroupApplyTypeToGame;
	
	/** 申请时是否可直接入群(无需同意) */
	public boolean canApplyInAbs;
	
	/** 操作者 */
	public long operator;
	
	public FuncChangeRoleGroupApplyTypeToGameServerRequest()
	{
		_dataID=ServerMessageType.FuncChangeRoleGroupApplyTypeToGame;
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
		return "FuncChangeRoleGroupApplyTypeToGameServerRequest";
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeLong(this.operator);
		
		stream.writeBoolean(this.canApplyInAbs);
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("operator");
		writer.sb.append(':');
		writer.sb.append(this.operator);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("canApplyInAbs");
		writer.sb.append(':');
		writer.sb.append(this.canApplyInAbs);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.operator=0L;
		this.canApplyInAbs=false;
	}
	
	/** 创建实例 */
	public static FuncChangeRoleGroupApplyTypeToGameServerRequest create(int funcID,long groupID,long operator,boolean canApplyInAbs)
	{
		FuncChangeRoleGroupApplyTypeToGameServerRequest re=(FuncChangeRoleGroupApplyTypeToGameServerRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.groupID=groupID;
		re.operator=operator;
		re.canApplyInAbs=canApplyInAbs;
		return re;
	}
	
}