package com.home.commonGame.net.request.activity;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 活动完成一次消息(generated by shine) */
public class ActivityCompleteOnceRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.ActivityCompleteOnce;
	
	/** id */
	public int id;
	
	/** 参与次数 */
	public int joinTimes;
	
	public ActivityCompleteOnceRequest()
	{
		_dataID=GameRequestType.ActivityCompleteOnce;
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
		return "ActivityCompleteOnceRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("id");
		writer.sb.append(':');
		writer.sb.append(this.id);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("joinTimes");
		writer.sb.append(':');
		writer.sb.append(this.joinTimes);
		
		writer.writeEnter();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.joinTimes);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.joinTimes);
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.id=0;
		this.joinTimes=0;
	}
	
	/** 创建实例 */
	public static ActivityCompleteOnceRequest create(int id,int joinTimes)
	{
		ActivityCompleteOnceRequest re=(ActivityCompleteOnceRequest)BytesControl.createRequest(dataID);
		re.id=id;
		re.joinTimes=joinTimes;
		return re;
	}
	
}
