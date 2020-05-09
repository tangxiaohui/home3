package com.home.commonLogin.net.serverResponse.login.login;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonLogin.net.serverResponse.login.base.LoginToLoginServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 回复客户端登陆错误码(generated by shine) */
public class ReClientLoginErrorServerResponse extends LoginToLoginServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.ReClientLoginError;
	
	public int httpID;
	
	public int code;
	
	public ReClientLoginErrorServerResponse()
	{
		_dataID=ServerMessageType.ReClientLoginError;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ReClientLoginErrorServerResponse";
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.httpID=stream.readInt();
		
		this.code=stream.readInt();
		
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
		writer.sb.append("code");
		writer.sb.append(':');
		writer.sb.append(this.code);
		
		writer.writeEnter();
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.httpID=0;
		this.code=0;
	}
	
}