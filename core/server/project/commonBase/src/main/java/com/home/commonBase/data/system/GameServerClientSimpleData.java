package com.home.commonBase.data.system;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.serverConfig.BaseServerConfig;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 游戏服给客户端的简版数据(generated by shine) */
public class GameServerClientSimpleData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.GameServerClientSimple;
	
	/** 客户端地址 */
	public String clientHost="";
	
	/** 客户端使用端口(可能经过lbs等服务转发) */
	public int clientUsePort;
	
	/** ID */
	public int id;
	
	public GameServerClientSimpleData()
	{
		_dataID=BaseDataType.GameServerClientSimple;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "GameServerClientSimpleData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.id=stream.readInt();
		
		this.clientHost=stream.readUTF();
		
		this.clientUsePort=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.id);
		
		stream.writeUTF(this.clientHost);
		
		stream.writeInt(this.clientUsePort);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.id=stream.readInt();
		
		this.clientHost=stream.readUTF();
		
		this.clientUsePort=stream.readInt();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.id);
		
		stream.writeUTF(this.clientHost);
		
		stream.writeInt(this.clientUsePort);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof GameServerClientSimpleData))
			return;
		
		GameServerClientSimpleData mData=(GameServerClientSimpleData)data;
		
		this.id=mData.id;
		this.clientHost=mData.clientHost;
		this.clientUsePort=mData.clientUsePort;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof GameServerClientSimpleData))
			return;
		
		GameServerClientSimpleData mData=(GameServerClientSimpleData)data;
		
		this.id=mData.id;
		
		this.clientHost=mData.clientHost;
		
		this.clientUsePort=mData.clientUsePort;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		GameServerClientSimpleData mData=(GameServerClientSimpleData)data;
		if(this.id!=mData.id)
			return false;
		
		if(!this.clientHost.equals(mData.clientHost))
			return false;
		
		if(this.clientUsePort!=mData.clientUsePort)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("id");
		writer.sb.append(':');
		writer.sb.append(this.id);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("clientHost");
		writer.sb.append(':');
		writer.sb.append(this.clientHost);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("clientUsePort");
		writer.sb.append(':');
		writer.sb.append(this.clientUsePort);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		
	}
	
	public void readByConfig(BaseServerConfig config)
	{
		this.id=config.id;
		this.clientHost=config.clientHost;
		this.clientUsePort=config.clientUsePort;
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.id=0;
		this.clientHost="";
		this.clientUsePort=0;
	}
	
}
