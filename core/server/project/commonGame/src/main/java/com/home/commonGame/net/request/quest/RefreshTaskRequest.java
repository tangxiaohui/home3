package com.home.commonGame.net.request.quest;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 刷新目标数目消息(generated by shine) */
public class RefreshTaskRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.RefreshTask;
	
	/** 实例ID */
	public int instanceID;
	
	/** 数目 */
	public int num;
	
	public RefreshTaskRequest()
	{
		_dataID=GameRequestType.RefreshTask;
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
		return "RefreshTaskRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("instanceID");
		writer.sb.append(':');
		writer.sb.append(this.instanceID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("num");
		writer.sb.append(':');
		writer.sb.append(this.num);
		
		writer.writeEnter();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.instanceID);
		
		stream.writeInt(this.num);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.instanceID);
		
		stream.writeInt(this.num);
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.instanceID=0;
		this.num=0;
	}
	
	/** 创建实例 */
	public static RefreshTaskRequest create(int instanceID,int num)
	{
		RefreshTaskRequest re=(RefreshTaskRequest)BytesControl.createRequest(dataID);
		re.instanceID=instanceID;
		re.num=num;
		return re;
	}
	
}
