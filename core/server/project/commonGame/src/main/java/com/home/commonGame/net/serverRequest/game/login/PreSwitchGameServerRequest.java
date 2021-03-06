package com.home.commonGame.net.serverRequest.game.login;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.login.PlayerSwitchGameData;
import com.home.commonBase.data.system.PlayerPrimaryKeyData;
import com.home.commonGame.net.serverRequest.game.base.GameToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 准备切换游戏服消息(generated by shine) */
public class PreSwitchGameServerRequest extends GameToGameServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.PreSwitchGame;
	
	/** 角色主键数据 */
	public PlayerPrimaryKeyData keyData;
	
	/** 角色列表数据 */
	public BaseData listData;
	
	/** 切换数据 */
	public PlayerSwitchGameData switchData;
	
	public PreSwitchGameServerRequest()
	{
		_dataID=ServerMessageType.PreSwitchGame;
		setDontCopy();
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		PlayerPrimaryKeyData keyDataTemp=keyData;
		if(keyDataTemp!=null)
		{
			this.keyData=new PlayerPrimaryKeyData();
			this.keyData.copy(keyDataTemp);
		}
		else
		{
			this.keyData=null;
			nullObjError("keyData");
		}
		
		BaseData listDataTemp=listData;
		if(listDataTemp!=null)
		{
			this.listData=(BaseData)listDataTemp.clone();
		}
		else
		{
			this.listData=null;
			nullObjError("listData");
		}
		
		PlayerSwitchGameData switchDataTemp=switchData;
		if(switchDataTemp!=null)
		{
			this.switchData=(PlayerSwitchGameData)switchDataTemp.clone();
		}
		else
		{
			this.switchData=null;
			nullObjError("switchData");
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.keyData!=null)
		{
			this.keyData.writeBytesSimple(stream);
		}
		else
		{
			nullObjError("keyData");
		}
		
		if(this.listData!=null)
		{
			stream.writeDataSimpleNotNull(this.listData);
		}
		else
		{
			nullObjError("listData");
		}
		
		if(this.switchData!=null)
		{
			stream.writeDataSimpleNotNull(this.switchData);
		}
		else
		{
			nullObjError("switchData");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "PreSwitchGameServerRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("keyData");
		writer.sb.append(':');
		if(this.keyData!=null)
		{
			this.keyData.writeDataString(writer);
		}
		else
		{
			writer.sb.append("PlayerPrimaryKeyData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("listData");
		writer.sb.append(':');
		if(this.listData!=null)
		{
			this.listData.writeDataString(writer);
		}
		else
		{
			writer.sb.append("BaseData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("switchData");
		writer.sb.append(':');
		if(this.switchData!=null)
		{
			this.switchData.writeDataString(writer);
		}
		else
		{
			writer.sb.append("PlayerSwitchGameData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.keyData=null;
		this.listData=null;
		this.switchData=null;
	}
	
	/** 创建实例 */
	public static PreSwitchGameServerRequest create(PlayerPrimaryKeyData keyData,BaseData listData,PlayerSwitchGameData switchData)
	{
		PreSwitchGameServerRequest re=(PreSwitchGameServerRequest)BytesControl.createRequest(dataID);
		re.keyData=keyData;
		re.listData=listData;
		re.switchData=switchData;
		return re;
	}
	
}
