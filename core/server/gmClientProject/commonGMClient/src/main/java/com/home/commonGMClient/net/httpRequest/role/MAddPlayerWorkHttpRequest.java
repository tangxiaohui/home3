package com.home.commonGMClient.net.httpRequest.role;
import com.home.commonBase.data.system.PlayerWorkData;
import com.home.commonGMClient.constlist.generate.ManagerHttpRequestType;
import com.home.commonGMClient.net.httpRequest.base.ManagerRHttpRequest;
import com.home.commonGMClient.net.httpResponseResult.role.MAddPlayerWorkResult;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;

/** gm添加事务消息(generated by shine) */
public class MAddPlayerWorkHttpRequest extends ManagerRHttpRequest
{
	/** 数据类型ID */
	public static final int dataID=ManagerHttpRequestType.MAddPlayerWork;
	
	/** 返回值 */
	protected MAddPlayerWorkResult _re;
	
	/** 角色事务 */
	public PlayerWorkData work;
	
	public MAddPlayerWorkHttpRequest()
	{
		_dataID=ManagerHttpRequestType.MAddPlayerWork;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		PlayerWorkData workTemp=work;
		if(workTemp!=null)
		{
			this.work=(PlayerWorkData)workTemp.clone();
		}
		else
		{
			this.work=null;
			nullObjError("work");
		}
		
	}
	
	/** 执行 */
	@Override
	protected void toRead()
	{
		_re=new MAddPlayerWorkResult();
		readResult(_re,_resultStream);
	}
	
	/** 获取结果 */
	public MAddPlayerWorkResult getResult()
	{
		return _re;
	}
	
	/** 执行 */
	@Override
	protected void onComplete()
	{
		
	}
	
	/** 同步执行 */
	public MAddPlayerWorkResult sendMSync()
	{
		doSendSync();
		return _re;
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.work!=null)
		{
			stream.writeDataSimpleNotNull(this.work);
		}
		else
		{
			nullObjError("work");
		}
		
	}
	
	/** 创建实例 */
	public static MAddPlayerWorkHttpRequest create(int token,PlayerWorkData work)
	{
		MAddPlayerWorkHttpRequest re=new MAddPlayerWorkHttpRequest();
		re.token=token;
		re.work=work;
		return re;
	}
	
}