package com.home.commonBase.data.system;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.serverConfig.BaseServerConfig;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 服务器启动信息(generated by shine) */
public class ServerInfoData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.ServerInfo;
	
	/** ID */
	public int id;
	
	/** 服务器地址 */
	public String serverHost="";
	
	/** 服务器端口 */
	public int serverPort;
	
	/** 服务器http端口 */
	public int serverHttpPort;
	
	/** 客户端地址 */
	public String clientHost="";
	
	/** 客户端端口 */
	public int clientPort;
	
	/** 客户端http端口 */
	public int clientHttpPort;
	
	/** mysql */
	public String mysql="";
	
	public ServerInfoData()
	{
		_dataID=BaseDataType.ServerInfo;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ServerInfoData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.id=stream.readInt();
		
		this.serverHost=stream.readUTF();
		
		this.serverPort=stream.readInt();
		
		this.serverHttpPort=stream.readInt();
		
		this.clientHost=stream.readUTF();
		
		this.clientPort=stream.readInt();
		
		this.clientHttpPort=stream.readInt();
		
		this.mysql=stream.readUTF();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.id);
		
		stream.writeUTF(this.serverHost);
		
		stream.writeInt(this.serverPort);
		
		stream.writeInt(this.serverHttpPort);
		
		stream.writeUTF(this.clientHost);
		
		stream.writeInt(this.clientPort);
		
		stream.writeInt(this.clientHttpPort);
		
		stream.writeUTF(this.mysql);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.id=stream.readInt();
		
		this.serverHost=stream.readUTF();
		
		this.serverPort=stream.readInt();
		
		this.serverHttpPort=stream.readInt();
		
		this.clientHost=stream.readUTF();
		
		this.clientPort=stream.readInt();
		
		this.clientHttpPort=stream.readInt();
		
		this.mysql=stream.readUTF();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.id);
		
		stream.writeUTF(this.serverHost);
		
		stream.writeInt(this.serverPort);
		
		stream.writeInt(this.serverHttpPort);
		
		stream.writeUTF(this.clientHost);
		
		stream.writeInt(this.clientPort);
		
		stream.writeInt(this.clientHttpPort);
		
		stream.writeUTF(this.mysql);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof ServerInfoData))
			return;
		
		ServerInfoData mData=(ServerInfoData)data;
		
		this.id=mData.id;
		this.serverHost=mData.serverHost;
		this.serverPort=mData.serverPort;
		this.serverHttpPort=mData.serverHttpPort;
		this.clientHost=mData.clientHost;
		this.clientPort=mData.clientPort;
		this.clientHttpPort=mData.clientHttpPort;
		this.mysql=mData.mysql;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof ServerInfoData))
			return;
		
		ServerInfoData mData=(ServerInfoData)data;
		
		this.id=mData.id;
		
		this.serverHost=mData.serverHost;
		
		this.serverPort=mData.serverPort;
		
		this.serverHttpPort=mData.serverHttpPort;
		
		this.clientHost=mData.clientHost;
		
		this.clientPort=mData.clientPort;
		
		this.clientHttpPort=mData.clientHttpPort;
		
		this.mysql=mData.mysql;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		ServerInfoData mData=(ServerInfoData)data;
		if(this.id!=mData.id)
			return false;
		
		if(!this.serverHost.equals(mData.serverHost))
			return false;
		
		if(this.serverPort!=mData.serverPort)
			return false;
		
		if(this.serverHttpPort!=mData.serverHttpPort)
			return false;
		
		if(!this.clientHost.equals(mData.clientHost))
			return false;
		
		if(this.clientPort!=mData.clientPort)
			return false;
		
		if(this.clientHttpPort!=mData.clientHttpPort)
			return false;
		
		if(!this.mysql.equals(mData.mysql))
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
		writer.sb.append("serverHost");
		writer.sb.append(':');
		writer.sb.append(this.serverHost);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("serverPort");
		writer.sb.append(':');
		writer.sb.append(this.serverPort);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("serverHttpPort");
		writer.sb.append(':');
		writer.sb.append(this.serverHttpPort);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("clientHost");
		writer.sb.append(':');
		writer.sb.append(this.clientHost);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("clientPort");
		writer.sb.append(':');
		writer.sb.append(this.clientPort);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("clientHttpPort");
		writer.sb.append(':');
		writer.sb.append(this.clientHttpPort);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("mysql");
		writer.sb.append(':');
		writer.sb.append(this.mysql);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		
	}
	
	/** 从配置 */
	public void readByConfig(BaseServerConfig config)
	{
		this.id=config.id;
		this.serverHost=config.serverHost;
		this.serverPort=config.serverPort;
		this.serverHttpPort=config.serverHttpPort;
		this.clientHost=config.clientHost;
		this.clientPort=config.clientPort;
		this.clientHttpPort=config.clientHttpPort;
		this.mysql=config.mysql;
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.id=0;
		this.serverHost="";
		this.serverPort=0;
		this.serverHttpPort=0;
		this.clientHost="";
		this.clientPort=0;
		this.clientHttpPort=0;
		this.mysql="";
	}
	
}