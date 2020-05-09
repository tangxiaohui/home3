package com.home.commonGMClient.net.httpRequest.role;
import com.home.commonGMClient.constlist.generate.ManagerHttpRequestType;
import com.home.commonGMClient.net.httpRequest.base.ManagerRHttpRequest;
import com.home.commonGMClient.net.httpResponseResult.role.MQueryPlayerResult;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;

/** 查询角色消息(generated by shine) */
public class MQueryPlayerHttpRequest extends ManagerRHttpRequest
{
	/** 数据类型ID */
	public static final int dataID=ManagerHttpRequestType.MQueryPlayer;
	
	/** 返回值 */
	protected MQueryPlayerResult _re;
	
	/** gameID */
	public int gameID;
	
	/** 角色ID */
	public long playerID;
	
	public MQueryPlayerHttpRequest()
	{
		_dataID=ManagerHttpRequestType.MQueryPlayer;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
	}
	
	/** 执行 */
	@Override
	protected void toRead()
	{
		_re=new MQueryPlayerResult();
		readResult(_re,_resultStream);
	}
	
	/** 获取结果 */
	public MQueryPlayerResult getResult()
	{
		return _re;
	}
	
	/** 执行 */
	@Override
	protected void onComplete()
	{
		
	}
	
	/** 同步执行 */
	public MQueryPlayerResult sendMSync()
	{
		doSendSync();
		return _re;
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.gameID);
		
		stream.writeLong(this.playerID);
		
	}
	
	/** 创建实例 */
	public static MQueryPlayerHttpRequest create(int token,int gameID,long playerID)
	{
		MQueryPlayerHttpRequest re=new MQueryPlayerHttpRequest();
		re.token=token;
		re.gameID=gameID;
		re.playerID=playerID;
		return re;
	}
	
}