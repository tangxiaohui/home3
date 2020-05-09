package com.home.commonBase.data.system;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.serverConfig.BaseServerConfig;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 中心服简版连接数据(generated by shine) */
public class ServerSimpleInfoData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.ServerSimpleInfo;
	
	/** ID */
	public int id;
	
	/** 服务器地址 */
	public String serverHost="";
	
	/** mysql地址 */
	public String mysql="";
	
	/** 服务器端口 */
	public int serverPort;
	
	public ServerSimpleInfoData()
	{
		_dataID=BaseDataType.ServerSimpleInfo;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ServerSimpleInfoData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.id=stream.readInt();
		
		this.serverHost=stream.readUTF();
		
		this.serverPort=stream.readInt();
		
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
		
		this.mysql=stream.readUTF();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.id);
		
		stream.writeUTF(this.serverHost);
		
		stream.writeInt(this.serverPort);
		
		stream.writeUTF(this.mysql);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof ServerSimpleInfoData))
			return;
		
		ServerSimpleInfoData mData=(ServerSimpleInfoData)data;
		
		this.id=mData.id;
		this.serverHost=mData.serverHost;
		this.serverPort=mData.serverPort;
		this.mysql=mData.mysql;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof ServerSimpleInfoData))
			return;
		
		ServerSimpleInfoData mData=(ServerSimpleInfoData)data;
		
		this.id=mData.id;
		
		this.serverHost=mData.serverHost;
		
		this.serverPort=mData.serverPort;
		
		this.mysql=mData.mysql;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		ServerSimpleInfoData mData=(ServerSimpleInfoData)data;
		if(this.id!=mData.id)
			return false;
		
		if(!this.serverHost.equals(mData.serverHost))
			return false;
		
		if(this.serverPort!=mData.serverPort)
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
		this.mysql=config.mysql;
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.id=0;
		this.serverHost="";
		this.serverPort=0;
		this.mysql="";
	}
	
}