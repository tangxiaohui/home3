package com.home.commonCenter.net.serverRequest.game.system;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.login.ClientVersionData;
import com.home.commonBase.data.login.GameLoginData;
import com.home.commonBase.data.system.GameServerSimpleInfoData;
import com.home.commonCenter.net.base.CenterServerRequest;
import com.home.commonCenter.net.serverRequest.game.base.CenterToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.IntObjectMap;
import com.home.shine.support.collection.SSet;
import com.home.shine.support.pool.DataPool;

/** 回复获取逻辑服消息(generated by shine) */
public class ReBeGameToCenterServerRequest extends CenterToGameServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.ReBeGameToCenter;
	
	/** 登录数据 */
	public GameLoginData loginData;
	
	public ReBeGameToCenterServerRequest()
	{
		_dataID=ServerMessageType.ReBeGameToCenter;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		GameLoginData loginDataTemp=loginData;
		if(loginDataTemp!=null)
		{
			this.loginData=(GameLoginData)loginDataTemp.clone();
		}
		else
		{
			this.loginData=null;
			nullObjError("loginData");
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.loginData!=null)
		{
			stream.writeDataSimpleNotNull(this.loginData);
		}
		else
		{
			nullObjError("loginData");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ReBeGameToCenterServerRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("loginData");
		writer.sb.append(':');
		if(this.loginData!=null)
		{
			this.loginData.writeDataString(writer);
		}
		else
		{
			writer.sb.append("GameLoginData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.loginData.release(pool);
		this.loginData=null;
	}
	
	/** 创建实例 */
	public static ReBeGameToCenterServerRequest create(GameLoginData loginData)
	{
		ReBeGameToCenterServerRequest re=(ReBeGameToCenterServerRequest)BytesControl.createRequest(dataID);
		re.loginData=loginData;
		return re;
	}
	
}
