package com.home.commonGame.net.serverRequest.center.system;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.system.WorkCompleteData;
import com.home.commonGame.net.serverRequest.center.base.GameToCenterServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class SendCenterWorkCompleteToCenterServerRequest extends GameToCenterServerRequest
{
	/** 完成数据 */
	public WorkCompleteData data;
	
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.SendCenterWorkCompleteToCenter;
	
	public SendCenterWorkCompleteToCenterServerRequest()
	{
		_dataID=ServerMessageType.SendCenterWorkCompleteToCenter;
		setDontCopy();
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		WorkCompleteData dataTemp=data;
		if(dataTemp!=null)
		{
			this.data=(WorkCompleteData)dataTemp.clone();
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
		return "SendCenterWorkCompleteToCenterServerRequest";
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
			writer.sb.append("WorkCompleteData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.data=null;
	}
	
	/** 创建实例 */
	public static SendCenterWorkCompleteToCenterServerRequest create(WorkCompleteData data)
	{
		SendCenterWorkCompleteToCenterServerRequest re=(SendCenterWorkCompleteToCenterServerRequest)BytesControl.createRequest(dataID);
		re.data=data;
		return re;
	}
	
}