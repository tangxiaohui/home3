package com.home.commonGame.net.serverResponse.game.func.roleGroup;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.net.serverResponse.game.func.base.FuncRoleGroupToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class FuncChangeRoleGroupNoticeToGameServerResponse extends FuncRoleGroupToGameServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.FuncChangeRoleGroupNoticeToGame;
	
	public long operator;
	
	public String notice="";
	
	public FuncChangeRoleGroupNoticeToGameServerResponse()
	{
		_dataID=ServerMessageType.FuncChangeRoleGroupNoticeToGame;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncChangeRoleGroupNoticeToGameServerResponse";
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.operator=stream.readLong();
		
		this.notice=stream.readUTF();
		
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
	
	/** 执行 */
	@Override
	protected void execute()
	{
		roleGroup.changeNotice(operator,notice);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.operator=0L;
		this.notice="";
	}
	
}
