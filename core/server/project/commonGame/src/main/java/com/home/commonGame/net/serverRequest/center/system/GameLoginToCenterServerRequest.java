package com.home.commonGame.net.serverRequest.center.system;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.login.GameLoginToCenterData;
import com.home.commonGame.net.serverRequest.center.base.GameToCenterServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 逻辑服登录到中心服数据(generated by shine) */
public class GameLoginToCenterServerRequest extends GameToCenterServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.GameLoginToCenter;
	
	public GameLoginToCenterData data;
	
	public GameLoginToCenterServerRequest()
	{
		_dataID=ServerMessageType.GameLoginToCenter;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		GameLoginToCenterData dataTemp=data;
		if(dataTemp!=null)
		{
			this.data=(GameLoginToCenterData)dataTemp.clone();
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
		return "GameLoginToCenterServerRequest";
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
			writer.sb.append("GameLoginToCenterData=null");
		}
		
		writer.writeEnter();
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
	public static GameLoginToCenterServerRequest create(GameLoginToCenterData data)
	{
		GameLoginToCenterServerRequest re=(GameLoginToCenterServerRequest)BytesControl.createRequest(dataID);
		re.data=data;
		return re;
	}
	
}