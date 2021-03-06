package com.home.commonClient.net.request.func.rank;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.net.base.GameRequest;
import com.home.commonClient.net.request.func.base.FuncRRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 获取每页数据(主线程)(generated by shine) */
public class FuncGetPageShowRequest extends FuncRRequest
{
	/** 参数(默认0) */
	public int arg;
	
	/** 数据类型ID */
	public static final int dataID=GameRequestType.FuncGetPageShow;
	
	/** 页码 */
	public int page;
	
	public FuncGetPageShowRequest()
	{
		_dataID=GameRequestType.FuncGetPageShow;
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
		return "FuncGetPageShowRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("page");
		writer.sb.append(':');
		writer.sb.append(this.page);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("arg");
		writer.sb.append(':');
		writer.sb.append(this.arg);
		
		writer.writeEnter();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.page);
		
		stream.writeInt(this.arg);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.page);
		
		stream.writeInt(this.arg);
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.page=0;
		this.arg=0;
	}
	
	/** 创建实例 */
	public static FuncGetPageShowRequest create(int funcID,int page,int arg)
	{
		FuncGetPageShowRequest re=(FuncGetPageShowRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.page=page;
		re.arg=arg;
		return re;
	}
	
}
