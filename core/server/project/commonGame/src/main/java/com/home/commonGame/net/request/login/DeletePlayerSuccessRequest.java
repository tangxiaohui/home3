package com.home.commonGame.net.request.login;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 删除角色成功消息(generated by shine) */
public class DeletePlayerSuccessRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.DeletePlayerSuccess;
	
	/** 角色ID */
	public long playerID;
	
	public DeletePlayerSuccessRequest()
	{
		_dataID=GameRequestType.DeletePlayerSuccess;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "DeletePlayerSuccessRequest";
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
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeLong(this.playerID);
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeLong(this.playerID);
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.playerID=0L;
	}
	
	/** 创建实例 */
	public static DeletePlayerSuccessRequest create(long playerID)
	{
		DeletePlayerSuccessRequest re=(DeletePlayerSuccessRequest)BytesControl.createRequest(dataID);
		re.playerID=playerID;
		return re;
	}
	
}