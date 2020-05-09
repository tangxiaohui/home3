package com.home.commonManager.net.serverRequest.game;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.login.GameInitServerData;
import com.home.commonManager.net.serverRequest.game.base.ManagerToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class ReBeGameToManagerServerRequest extends ManagerToGameServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.ReBeGameToManager;
	
	/** 初始化数据 */
	public GameInitServerData initData;
	
	public ReBeGameToManagerServerRequest()
	{
		_dataID=ServerMessageType.ReBeGameToManager;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		GameInitServerData initDataTemp=initData;
		if(initDataTemp!=null)
		{
			this.initData=(GameInitServerData)initDataTemp.clone();
		}
		else
		{
			this.initData=null;
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ReBeGameToManagerServerRequest";
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.initData!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataSimpleNotNull(this.initData);
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
		writer.sb.append("initData");
		writer.sb.append(':');
		if(this.initData!=null)
		{
			this.initData.writeDataString(writer);
		}
		else
		{
			writer.sb.append("GameInitServerData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		if(this.initData!=null)
		{
			this.initData.release(pool);
			this.initData=null;
		}
	}
	
	/** 创建实例 */
	public static ReBeGameToManagerServerRequest create(GameInitServerData initData)
	{
		ReBeGameToManagerServerRequest re=(ReBeGameToManagerServerRequest)BytesControl.createRequest(dataID);
		re.initData=initData;
		return re;
	}
	
}