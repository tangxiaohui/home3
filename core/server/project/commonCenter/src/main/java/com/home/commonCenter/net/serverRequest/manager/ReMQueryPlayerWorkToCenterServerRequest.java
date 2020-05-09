package com.home.commonCenter.net.serverRequest.manager;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonCenter.net.serverRequest.manager.base.CenterToManagerServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 查询事务到中心服(generated by shine) */
public class ReMQueryPlayerWorkToCenterServerRequest extends CenterToManagerServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.ReMQueryPlayerWorkToCenter;
	
	public int httpID;
	
	/** 返回数据 */
	public BaseData data;
	
	public ReMQueryPlayerWorkToCenterServerRequest()
	{
		_dataID=ServerMessageType.ReMQueryPlayerWorkToCenter;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		BaseData dataTemp=data;
		if(dataTemp!=null)
		{
			this.data=(BaseData)dataTemp.clone();
		}
		else
		{
			this.data=null;
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ReMQueryPlayerWorkToCenterServerRequest";
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.httpID);
		
		if(this.data!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataSimpleNotNull(this.data);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("httpID");
		writer.sb.append(':');
		writer.sb.append(this.httpID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("data");
		writer.sb.append(':');
		if(this.data!=null)
		{
			this.data.writeDataString(writer);
		}
		else
		{
			writer.sb.append("BaseData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.httpID=0;
		if(this.data!=null)
		{
			this.data.release(pool);
			this.data=null;
		}
	}
	
	/** 创建实例 */
	public static ReMQueryPlayerWorkToCenterServerRequest create(int httpID,BaseData data)
	{
		ReMQueryPlayerWorkToCenterServerRequest re=(ReMQueryPlayerWorkToCenterServerRequest)BytesControl.createRequest(dataID);
		re.httpID=httpID;
		re.data=data;
		return re;
	}
	
}