package com.home.commonGame.net.request.login;
import com.home.commonBase.data.login.PlayerLoginData;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 创建角色成功消息(generated by shine) */
public class CreatePlayerSuccessRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.CreatePlayerSuccess;
	
	public PlayerLoginData role;
	
	public CreatePlayerSuccessRequest()
	{
		_dataID=GameRequestType.CreatePlayerSuccess;
		setDontCopy();
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		PlayerLoginData roleTemp=role;
		if(roleTemp!=null)
		{
			this.role=(PlayerLoginData)roleTemp.clone();
		}
		else
		{
			this.role=null;
			nullObjError("role");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CreatePlayerSuccessRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("role");
		writer.sb.append(':');
		if(this.role!=null)
		{
			this.role.writeDataString(writer);
		}
		else
		{
			writer.sb.append("PlayerLoginData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.role!=null)
		{
			stream.writeDataFullNotNull(this.role);
		}
		else
		{
			nullObjError("role");
		}
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.role!=null)
		{
			stream.writeDataSimpleNotNull(this.role);
		}
		else
		{
			nullObjError("role");
		}
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.role=null;
	}
	
	/** 创建实例 */
	public static CreatePlayerSuccessRequest create(PlayerLoginData role)
	{
		CreatePlayerSuccessRequest re=(CreatePlayerSuccessRequest)BytesControl.createRequest(dataID);
		re.role=role;
		return re;
	}
	
}
