package com.home.commonGame.net.serverRequest.game.func.rank;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.net.serverRequest.game.func.base.FuncPlayerRoleGroupGameToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 更新排行(玩家群)消息(generated by shine) */
public class FuncRefreshRankForRoleGroupServerRequest extends FuncPlayerRoleGroupGameToGameServerRequest
{
	/** 排行榜的功能ID */
	public int rankFuncID;
	
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.FuncRefreshRankForRoleGroup;
	
	/** 排行(-1为移除排行) */
	public int rank;
	
	/** 排行值 */
	public long value;
	
	public FuncRefreshRankForRoleGroupServerRequest()
	{
		_dataID=ServerMessageType.FuncRefreshRankForRoleGroup;
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
		return "FuncRefreshRankForRoleGroupServerRequest";
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.rankFuncID);
		
		stream.writeInt(this.rank);
		
		stream.writeLong(this.value);
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("rankFuncID");
		writer.sb.append(':');
		writer.sb.append(this.rankFuncID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("rank");
		writer.sb.append(':');
		writer.sb.append(this.rank);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("value");
		writer.sb.append(':');
		writer.sb.append(this.value);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.rankFuncID=0;
		this.rank=0;
		this.value=0L;
	}
	
	/** 创建实例 */
	public static FuncRefreshRankForRoleGroupServerRequest create(int funcID,long groupID,int rankFuncID,int rank,long value)
	{
		FuncRefreshRankForRoleGroupServerRequest re=(FuncRefreshRankForRoleGroupServerRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.groupID=groupID;
		re.rankFuncID=rankFuncID;
		re.rank=rank;
		re.value=value;
		return re;
	}
	
}
