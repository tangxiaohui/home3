package com.home.commonGame.net.response.mail;
import com.home.commonBase.data.mail.MailData;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.net.base.GameResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 客户端发送邮件消息(generated by shine) */
public class ClientSendMailResponse extends GameResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.ClientSendMail;
	
	/** 目标玩家ID */
	public long playerID;
	
	/** 邮件数据 */
	public MailData mail;
	
	public ClientSendMailResponse()
	{
		_dataID=GameResponseType.ClientSendMail;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.mail.clientSendMail(playerID,mail);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ClientSendMailResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.playerID=stream.readLong();
		
		BaseData mailT=stream.readDataFullNotNull();
		if(mailT!=null)
		{
			if(mailT instanceof MailData)
			{
				this.mail=(MailData)mailT;
			}
			else
			{
				this.mail=new MailData();
				if(!(mailT.getClass().isAssignableFrom(MailData.class)))
				{
					stream.throwTypeReadError(MailData.class,mailT.getClass());
				}
				this.mail.shadowCopy(mailT);
			}
		}
		else
		{
			this.mail=null;
		}
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.playerID=stream.readLong();
		
		this.mail=(MailData)stream.readDataSimpleNotNull();
		
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
		writer.writeTabs();
		writer.sb.append("mail");
		writer.sb.append(':');
		if(this.mail!=null)
		{
			this.mail.writeDataString(writer);
		}
		else
		{
			writer.sb.append("MailData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.playerID=0L;
		this.mail=null;
	}
	
}
