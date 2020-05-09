package com.home.commonGame.net.response.mail;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.net.base.GameResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 删除邮件消息(generated by shine) */
public class DeleteMailResponse extends GameResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.DeleteMail;
	
	/** 邮件序号 */
	public int index;
	
	/** 邮件实例ID */
	public int instanceID;
	
	public DeleteMailResponse()
	{
		_dataID=GameResponseType.DeleteMail;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.mail.deleteMail(index,instanceID);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "DeleteMailResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.index=stream.readInt();
		
		this.instanceID=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.index=stream.readInt();
		
		this.instanceID=stream.readInt();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("index");
		writer.sb.append(':');
		writer.sb.append(this.index);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("instanceID");
		writer.sb.append(':');
		writer.sb.append(this.instanceID);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.index=0;
		this.instanceID=0;
	}
	
}