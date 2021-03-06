package com.home.commonGame.net.response.system;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.global.GameC;
import com.home.commonGame.net.base.GameResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 客户端GM指令(generated by shine) */
public class ClientGMResponse extends GameResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.ClientGM;
	
	/** 指令 */
	public String cmd="";
	
	public ClientGMResponse()
	{
		_dataID=GameResponseType.ClientGM;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		GameC.clientGM.execute(me,cmd);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ClientGMResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.cmd=stream.readUTF();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.cmd=stream.readUTF();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("cmd");
		writer.sb.append(':');
		writer.sb.append(this.cmd);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.cmd="";
	}
	
}
