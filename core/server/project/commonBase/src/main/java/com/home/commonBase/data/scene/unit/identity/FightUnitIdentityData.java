package com.home.commonBase.data.scene.unit.identity;
import com.home.commonBase.config.game.FightUnitConfig;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.scene.unit.UnitIdentityData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 战斗单位身份数据(generated by shine) */
public class FightUnitIdentityData extends UnitIdentityData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.FightUnitIdentity;
	
	/** 单位类型ID(类型不同,数据表不同) */
	public int id;
	
	/** 单位等级 */
	public int level;
	
	/** 控制角色ID(服务器控制就是-1) */
	public long controlPlayerID=-1L;
	
	public FightUnitIdentityData()
	{
		_dataID=BaseDataType.FightUnitIdentity;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FightUnitIdentityData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.id=stream.readInt();
		
		this.level=stream.readInt();
		
		this.controlPlayerID=stream.readLong();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.level);
		
		stream.writeLong(this.controlPlayerID);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.level=stream.readInt();
		
		this.controlPlayerID=stream.readLong();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.level);
		
		stream.writeLong(this.controlPlayerID);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof FightUnitIdentityData))
			return;
		
		FightUnitIdentityData mData=(FightUnitIdentityData)data;
		
		this.id=mData.id;
		this.level=mData.level;
		this.controlPlayerID=mData.controlPlayerID;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof FightUnitIdentityData))
			return;
		
		FightUnitIdentityData mData=(FightUnitIdentityData)data;
		
		this.id=mData.id;
		
		this.level=mData.level;
		
		this.controlPlayerID=mData.controlPlayerID;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		FightUnitIdentityData mData=(FightUnitIdentityData)data;
		if(this.id!=mData.id)
			return false;
		
		if(this.level!=mData.level)
			return false;
		
		if(this.controlPlayerID!=mData.controlPlayerID)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("id");
		writer.sb.append(':');
		writer.sb.append(this.id);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("level");
		writer.sb.append(':');
		writer.sb.append(this.level);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("controlPlayerID");
		writer.sb.append(':');
		writer.sb.append(this.controlPlayerID);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		super.initDefault();
		
	}
	
	/** 获取战斗单位ID */
	public int getFightUnitID()
	{
		return -1;
	}
	
	/** 获取战斗单位配置(可能为空) */
	public FightUnitConfig getFightUnitConfig()
	{
		return FightUnitConfig.get(getFightUnitID());
	}
	
	/** 设置归属和控制角色ID */
	public void setBelongAndControlPLayerID(long value)
	{
		controlPlayerID=playerID=value;
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.id=0;
		this.level=0;
		this.controlPlayerID=0L;
	}
	
}