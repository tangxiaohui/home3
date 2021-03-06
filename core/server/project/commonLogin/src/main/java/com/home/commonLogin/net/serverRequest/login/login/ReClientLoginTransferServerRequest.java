package com.home.commonLogin.net.serverRequest.login.login;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.login.ClientLoginResultData;
import com.home.commonLogin.net.serverRequest.login.base.LoginToLoginServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class ReClientLoginTransferServerRequest extends LoginToLoginServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.ReClientLoginTransfer;
	
	public int httpID;
	
	/** 登陆结果数据 */
	public ClientLoginResultData data;
	
	public ReClientLoginTransferServerRequest()
	{
		_dataID=ServerMessageType.ReClientLoginTransfer;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		ClientLoginResultData dataTemp=data;
		if(dataTemp!=null)
		{
			this.data=(ClientLoginResultData)dataTemp.clone();
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
		return "ReClientLoginTransferServerRequest";
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.httpID);
		
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
			writer.sb.append("ClientLoginResultData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.httpID=0;
		this.data.release(pool);
		this.data=null;
	}
	
	/** 创建实例 */
	public static ReClientLoginTransferServerRequest create(int httpID,ClientLoginResultData data)
	{
		ReClientLoginTransferServerRequest re=(ReClientLoginTransferServerRequest)BytesControl.createRequest(dataID);
		re.httpID=httpID;
		re.data=data;
		return re;
	}
	
}
