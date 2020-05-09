package com.home.commonClient.net.request.base;
import com.home.commonClient.constlist.generate.GameRequestType;
import com.home.commonClient.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;

/** 登陆部分协议基类(generated by shine) */
public class LoginRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.Login;
	
	public LoginRequest()
	{
		_dataID=GameRequestType.Login;
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
		return "LoginRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.endWriteObj();
	}
	
	/** 创建实例 */
	public static LoginRequest create()
	{
		LoginRequest re=(LoginRequest)BytesControl.createRequest(dataID);
		return re;
	}
	
}