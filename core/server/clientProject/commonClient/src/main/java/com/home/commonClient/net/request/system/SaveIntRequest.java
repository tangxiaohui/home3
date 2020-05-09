package com.home.commonClient.net.request.system;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 保存整形(generated by shine) */
public class SaveIntRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.SaveInt;
	
	/** key */
	public int key;
	
	/** 值 */
	public int value;
	
	public SaveIntRequest()
	{
		_dataID=GameRequestType.SaveInt;
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
		return "SaveIntRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("key");
		writer.sb.append(':');
		writer.sb.append(this.key);
		
		writer.writeEnter();
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
		
		stream.writeInt(this.key);
		
		stream.writeInt(this.value);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.key);
		
		stream.writeInt(this.value);
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.key=0;
		this.value=0;
	}
	
	/** 创建实例 */
	public static SaveIntRequest create(int key,int value)
	{
		SaveIntRequest re=(SaveIntRequest)BytesControl.createRequest(dataID);
		re.key=key;
		re.value=value;
		return re;
	}
	
}