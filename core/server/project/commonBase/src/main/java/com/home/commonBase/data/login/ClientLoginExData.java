package com.home.commonBase.data.login;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.login.ClientLoginData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 客户端登录扩展数据(generated by shine) */
public class ClientLoginExData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.ClientLoginEx;
	
	/** 数据 */
	public ClientLoginData data;
	
	/** 账号唯一ID */
	public long userID;
	
	/** ip地址 */
	public String ip="";
	
	/** 选择区服ID */
	public int areaID=-1;
	
	/** 是否成人 */
	public boolean isAdult;
	
	public ClientLoginExData()
	{
		_dataID=BaseDataType.ClientLoginEx;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ClientLoginExData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		BaseData dataT=stream.readDataFullNotNull();
		if(dataT!=null)
		{
			if(dataT instanceof ClientLoginData)
			{
				this.data=(ClientLoginData)dataT;
			}
			else
			{
				this.data=new ClientLoginData();
				if(!(dataT.getClass().isAssignableFrom(ClientLoginData.class)))
				{
					stream.throwTypeReadError(ClientLoginData.class,dataT.getClass());
				}
				this.data.shadowCopy(dataT);
			}
		}
		else
		{
			this.data=null;
		}
		
		this.userID=stream.readLong();
		
		this.ip=stream.readUTF();
		
		this.isAdult=stream.readBoolean();
		
		this.areaID=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.data!=null)
		{
			stream.writeDataFullNotNull(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
		stream.writeLong(this.userID);
		
		stream.writeUTF(this.ip);
		
		stream.writeBoolean(this.isAdult);
		
		stream.writeInt(this.areaID);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.data=(ClientLoginData)stream.readDataSimpleNotNull();
		
		this.userID=stream.readLong();
		
		this.ip=stream.readUTF();
		
		this.isAdult=stream.readBoolean();
		
		this.areaID=stream.readInt();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.data!=null)
		{
			stream.writeDataSimpleNotNull(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
		stream.writeLong(this.userID);
		
		stream.writeUTF(this.ip);
		
		stream.writeBoolean(this.isAdult);
		
		stream.writeInt(this.areaID);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof ClientLoginExData))
			return;
		
		ClientLoginExData mData=(ClientLoginExData)data;
		
		this.data=mData.data;
		this.userID=mData.userID;
		this.ip=mData.ip;
		this.isAdult=mData.isAdult;
		this.areaID=mData.areaID;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof ClientLoginExData))
			return;
		
		ClientLoginExData mData=(ClientLoginExData)data;
		
		if(mData.data!=null)
		{
			this.data=(ClientLoginData)mData.data.clone();
		}
		else
		{
			this.data=null;
			nullObjError("data");
		}
		
		this.userID=mData.userID;
		
		this.ip=mData.ip;
		
		this.isAdult=mData.isAdult;
		
		this.areaID=mData.areaID;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		ClientLoginExData mData=(ClientLoginExData)data;
		if(mData.data!=null)
		{
			if(this.data==null)
				return false;
			if(!this.data.dataEquals(mData.data))
				return false;
		}
		else
		{
			if(this.data!=null)
				return false;
		}
		
		if(this.userID!=mData.userID)
			return false;
		
		if(!this.ip.equals(mData.ip))
			return false;
		
		if(this.isAdult!=mData.isAdult)
			return false;
		
		if(this.areaID!=mData.areaID)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("data");
		writer.sb.append(':');
		if(this.data!=null)
		{
			this.data.writeDataString(writer);
		}
		else
		{
			writer.sb.append("ClientLoginData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("userID");
		writer.sb.append(':');
		writer.sb.append(this.userID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("ip");
		writer.sb.append(':');
		writer.sb.append(this.ip);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("isAdult");
		writer.sb.append(':');
		writer.sb.append(this.isAdult);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("areaID");
		writer.sb.append(':');
		writer.sb.append(this.areaID);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		this.data=new ClientLoginData();
		this.data.initDefault();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.data=null;
		this.userID=0L;
		this.ip="";
		this.isAdult=false;
		this.areaID=0;
	}
	
}