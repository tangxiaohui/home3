package com.home.commonManager.net.serverResponse.center;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonManager.global.ManagerC;
import com.home.commonManager.net.base.ManagerServerResponse;
import com.home.commonManager.net.httpResponse.role.MAddPlayerWorkHttpResponse;
import com.home.commonManager.net.serverResponse.center.base.CenterToManagerServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.net.httpResponse.BaseHttpResponse;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 回复添加角色事务到中心服(generated by shine) */
public class ReMAddPlayerWorkToCenterServerResponse extends CenterToManagerServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.ReMAddPlayerWorkToCenter;
	
	/** 结果 */
	public int result;
	
	public int httpID;
	
	public ReMAddPlayerWorkToCenterServerResponse()
	{
		_dataID=ServerMessageType.ReMAddPlayerWorkToCenter;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ReMAddPlayerWorkToCenterServerResponse";
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.httpID=stream.readInt();
		
		this.result=stream.readInt();
		
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		BaseHttpResponse httpResponse=ManagerC.server.getHttpResponse(httpID);
		
		if(httpResponse instanceof MAddPlayerWorkHttpResponse)
		{
			((MAddPlayerWorkHttpResponse)httpResponse).reBack(result==0);
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
		writer.sb.append("result");
		writer.sb.append(':');
		writer.sb.append(this.result);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.httpID=0;
		this.result=0;
	}
	
}