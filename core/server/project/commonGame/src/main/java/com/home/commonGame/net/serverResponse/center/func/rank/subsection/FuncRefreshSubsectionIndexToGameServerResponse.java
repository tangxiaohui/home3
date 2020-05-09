package com.home.commonGame.net.serverResponse.center.func.rank.subsection;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.net.serverResponse.center.func.base.FuncPlayerToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 刷新subIndex(generated by shine) */
public class FuncRefreshSubsectionIndexToGameServerResponse extends FuncPlayerToGameServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.FuncRefreshSubsectionIndexToGame;
	
	/** 大组index */
	public int subsectionIndex;
	
	/** 小组index */
	public int subsectionSubIndex;
	
	public FuncRefreshSubsectionIndexToGameServerResponse()
	{
		_dataID=ServerMessageType.FuncRefreshSubsectionIndexToGame;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncRefreshSubsectionIndexToGameServerResponse";
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.subsectionIndex=stream.readInt();
		
		this.subsectionSubIndex=stream.readInt();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("subsectionIndex");
		writer.sb.append(':');
		writer.sb.append(this.subsectionIndex);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("subsectionSubIndex");
		writer.sb.append(':');
		writer.sb.append(this.subsectionSubIndex);
		
		writer.writeEnter();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.func.getSubsectionRankTool(funcID).refreshSubsectionIndex(subsectionIndex,subsectionSubIndex);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.subsectionIndex=0;
		this.subsectionSubIndex=0;
	}
	
}