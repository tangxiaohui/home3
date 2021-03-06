package com.home.commonGame.net.serverRequest.game.func.roleGroup;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.net.serverRequest.game.func.base.FuncRoleGroupToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class FuncChangeRoleGroupNoticeToGameServerRequest extends FuncRoleGroupToGameServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.FuncChangeRoleGroupNoticeToGame;
	
	public long operator;
	
	public String notice="";
	
	public FuncChangeRoleGroupNoticeToGameServerRequest()
	{
		_dataID=ServerMessageType.FuncChangeRoleGroupNoticeToGame;
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
		return "FuncChangeRoleGroupNoticeToGameServerRequest";
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeLong(this.operator);
		
		stream.writeUTF(this.notice);
		
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
		writer.sb.append("notice");
		writer.sb.append(':');
		writer.sb.append(this.notice);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.operator=0L;
		this.notice="";
	}
	
	/** 创建实例 */
	public static FuncChangeRoleGroupNoticeToGameServerRequest create(int funcID,long groupID,long operator,String notice)
	{
		FuncChangeRoleGroupNoticeToGameServerRequest re=(FuncChangeRoleGroupNoticeToGameServerRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.groupID=groupID;
		re.operator=operator;
		re.notice=notice;
		return re;
	}
	
}
