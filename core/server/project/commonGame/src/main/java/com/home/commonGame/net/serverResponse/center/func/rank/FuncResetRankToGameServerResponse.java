package com.home.commonGame.net.serverResponse.center.func.rank;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.global.GameC;
import com.home.commonGame.net.serverResponse.center.base.CenterToGameServerResponse;
import com.home.commonGame.net.serverResponse.center.func.base.FuncCenterToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 重置排行榜到game服(generated by shine) */
public class FuncResetRankToGameServerResponse extends FuncCenterToGameServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.FuncResetRankToGame;
	
	/** 新版本号 */
	public int version;
	
	public FuncResetRankToGameServerResponse()
	{
		_dataID=ServerMessageType.FuncResetRankToGame;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.version=stream.readInt();
		
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		GameC.global.func.getRankToolForCenter(funcID).onReset(version);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncResetRankToGameServerResponse";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("version");
		writer.sb.append(':');
		writer.sb.append(this.version);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.version=0;
	}
	
}