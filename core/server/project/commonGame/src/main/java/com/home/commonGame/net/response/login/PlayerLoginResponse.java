package com.home.commonGame.net.response.login;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.global.GameC;
import com.home.commonGame.net.response.base.LoginResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 角色登录消息(generated by shine) */
public class PlayerLoginResponse extends LoginResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.PlayerLogin;
	
	/** 角色ID */
	public long playerID;
	
	public PlayerLoginResponse()
	{
		_dataID=GameResponseType.PlayerLogin;
	}
	
	/** 执行 */
	protected void execute()
	{
		GameC.main.playerLogin(gameSocket,playerID,null);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "PlayerLoginResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.playerID=stream.readLong();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.playerID=stream.readLong();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("playerID");
		writer.sb.append(':');
		writer.sb.append(this.playerID);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.playerID=0L;
	}
	
}