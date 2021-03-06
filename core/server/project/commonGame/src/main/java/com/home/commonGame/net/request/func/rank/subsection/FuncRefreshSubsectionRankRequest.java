package com.home.commonGame.net.request.func.rank.subsection;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.request.func.base.FuncSRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class FuncRefreshSubsectionRankRequest extends FuncSRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.FuncRefreshSubsectionRank;
	
	/** 排行(-1为移除排行) */
	public int rank;
	
	/** 排行值 */
	public long value;
	
	public FuncRefreshSubsectionRankRequest()
	{
		_dataID=GameRequestType.FuncRefreshSubsectionRank;
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
		return "FuncRefreshSubsectionRankRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.rank);
		
		stream.writeLong(this.value);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.rank);
		
		stream.writeLong(this.value);
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
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
		
		this.rank=0;
		this.value=0L;
	}
	
	/** 创建实例 */
	public static FuncRefreshSubsectionRankRequest create(int funcID,int rank,long value)
	{
		FuncRefreshSubsectionRankRequest re=(FuncRefreshSubsectionRankRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.rank=rank;
		re.value=value;
		return re;
	}
	
}
