package com.home.commonBase.data.role;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 角色简版外显数据(聊天等使用)(generated by shine) */
public class RoleSimpleShowData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.RoleSimpleShow;
	
	/** 角色ID */
	public long playerID;
	
	/** 创建区服 */
	public int createAreaID;
	
	/** 名字 */
	public String name="";
	
	/** 性别 */
	public int sex;
	
	/** 职业 */
	public int vocation;
	
	public RoleSimpleShowData()
	{
		_dataID=BaseDataType.RoleSimpleShow;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "RoleSimpleShowData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.playerID=stream.readLong();
		
		this.createAreaID=stream.readInt();
		
		this.name=stream.readUTF();
		
		this.sex=stream.readInt();
		
		this.vocation=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeLong(this.playerID);
		
		stream.writeInt(this.createAreaID);
		
		stream.writeUTF(this.name);
		
		stream.writeInt(this.sex);
		
		stream.writeInt(this.vocation);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.playerID=stream.readLong();
		
		this.createAreaID=stream.readInt();
		
		this.name=stream.readUTF();
		
		this.sex=stream.readInt();
		
		this.vocation=stream.readInt();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeLong(this.playerID);
		
		stream.writeInt(this.createAreaID);
		
		stream.writeUTF(this.name);
		
		stream.writeInt(this.sex);
		
		stream.writeInt(this.vocation);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof RoleSimpleShowData))
			return;
		
		RoleSimpleShowData mData=(RoleSimpleShowData)data;
		
		this.playerID=mData.playerID;
		this.createAreaID=mData.createAreaID;
		this.name=mData.name;
		this.sex=mData.sex;
		this.vocation=mData.vocation;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof RoleSimpleShowData))
			return;
		
		RoleSimpleShowData mData=(RoleSimpleShowData)data;
		
		this.playerID=mData.playerID;
		
		this.createAreaID=mData.createAreaID;
		
		this.name=mData.name;
		
		this.sex=mData.sex;
		
		this.vocation=mData.vocation;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		RoleSimpleShowData mData=(RoleSimpleShowData)data;
		if(this.playerID!=mData.playerID)
			return false;
		
		if(this.createAreaID!=mData.createAreaID)
			return false;
		
		if(!this.name.equals(mData.name))
			return false;
		
		if(this.sex!=mData.sex)
			return false;
		
		if(this.vocation!=mData.vocation)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("playerID");
		writer.sb.append(':');
		writer.sb.append(this.playerID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("createAreaID");
		writer.sb.append(':');
		writer.sb.append(this.createAreaID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("name");
		writer.sb.append(':');
		writer.sb.append(this.name);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("sex");
		writer.sb.append(':');
		writer.sb.append(this.sex);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("vocation");
		writer.sb.append(':');
		writer.sb.append(this.vocation);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.playerID=0L;
		this.createAreaID=0;
		this.name="";
		this.sex=0;
		this.vocation=0;
	}
	
}
