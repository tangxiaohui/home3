package com.home.commonManager.net.httpResponse.base;
import com.home.commonManager.dataEx.GMClientUser;
import com.home.commonManager.global.ManagerC;
import com.home.commonManager.net.base.ManagerHttpResponse;
import com.home.shine.bytes.BytesReadStream;

/** (generated by shine) */
public class ManagerRHttpResponse extends ManagerHttpResponse
{
	public int token;
	
	public ManagerRHttpResponse()
	{
	
	}
	
	@Override
	public void preExecute()
	{
		GMClientUser user=ManagerC.main.getUserByToken(token);
		
		if(user!=null)
		{
			execute();
		}
		else
		{
			//不存在
		}
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.token=stream.readInt();
		
	}
	
}