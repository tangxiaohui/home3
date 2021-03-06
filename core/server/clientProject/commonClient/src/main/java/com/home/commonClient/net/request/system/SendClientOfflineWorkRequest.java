package com.home.commonClient.net.request.system;
import com.home.commonBase.data.system.ClientOfflineWorkData;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送在线的客户端离线事务数据(generated by shine) */
public class SendClientOfflineWorkRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.SendClientOfflineWork;
	
	/** 数据 */
	public ClientOfflineWorkData data;
	
	public SendClientOfflineWorkRequest()
	{
		_dataID=GameRequestType.SendClientOfflineWork;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		ClientOfflineWorkData dataTemp=data;
		if(dataTemp!=null)
		{
			this.data=(ClientOfflineWorkData)dataTemp.clone();
		}
		else
		{
			this.data=null;
			nullObjError("data");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "SendClientOfflineWorkRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("data");
		writer.sb.append(':');
		if(this.data!=null)
		{
			this.data.writeDataString(writer);
		}
		else
		{
			writer.sb.append("ClientOfflineWorkData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.data!=null)
		{
			stream.writeDataFullNotNull(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.data!=null)
		{
			stream.writeDataSimpleNotNull(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.data.release(pool);
		this.data=null;
	}
	
	/** 创建实例 */
	public static SendClientOfflineWorkRequest create(ClientOfflineWorkData data)
	{
		SendClientOfflineWorkRequest re=(SendClientOfflineWorkRequest)BytesControl.createRequest(dataID);
		re.data=data;
		return re;
	}
	
}
