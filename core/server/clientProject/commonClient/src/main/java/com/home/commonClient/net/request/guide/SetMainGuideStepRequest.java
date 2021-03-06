package com.home.commonClient.net.request.guide;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 设置主引导步消息(generated by shine) */
public class SetMainGuideStepRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.SetMainGuideStep;
	
	/** 主引导步 */
	public int value;
	
	public SetMainGuideStepRequest()
	{
		_dataID=GameRequestType.SetMainGuideStep;
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
		return "SetMainGuideStepRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("value");
		writer.sb.append(':');
		writer.sb.append(this.value);
		
		writer.writeEnter();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.value);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.value);
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.value=0;
	}
	
	/** 创建实例 */
	public static SetMainGuideStepRequest create(int value)
	{
		SetMainGuideStepRequest re=(SetMainGuideStepRequest)BytesControl.createRequest(dataID);
		re.value=value;
		return re;
	}
	
}
