package com.home.commonGame.net.serverResponse.center.func.rank;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.global.GameC;
import com.home.commonGame.net.serverResponse.center.base.CenterToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送移除排行榜数据消息(generated by shine) */
public class FuncRemoveRankToGameServerResponse extends CenterToGameServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.FuncRemoveRankToGame;
	
	/** 功能ID */
	public int funcID;
	
	/** 主键 */
	public long key;
	
	public FuncRemoveRankToGameServerResponse()
	{
		_dataID=ServerMessageType.FuncRemoveRankToGame;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.funcID=stream.readInt();
		
		this.key=stream.readLong();
		
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		GameC.global.func.getRankToolForCenter(funcID).onRemoveRankFromCenter(key);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncRemoveRankToGameServerResponse";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("funcID");
		writer.sb.append(':');
		writer.sb.append(this.funcID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("key");
		writer.sb.append(':');
		writer.sb.append(this.key);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.funcID=0;
		this.key=0L;
	}
	
}
