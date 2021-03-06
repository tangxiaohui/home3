package com.home.commonBase.data.scene.unit.identity;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.scene.unit.UnitIdentityData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 掉落包身份数据(generated by shine) */
public class FieldItemBagIdentityData extends UnitIdentityData
{
	/** 来源怪物id */
	public int fromMonsterID;
	
	/** 数据类型ID */
	public static final int dataID=BaseDataType.FieldItemBagIdentity;
	
	public FieldItemBagIdentityData()
	{
		_dataID=BaseDataType.FieldItemBagIdentity;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FieldItemBagIdentityData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.fromMonsterID=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.fromMonsterID);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.fromMonsterID=stream.readInt();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.fromMonsterID);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof FieldItemBagIdentityData))
			return;
		
		FieldItemBagIdentityData mData=(FieldItemBagIdentityData)data;
		
		this.fromMonsterID=mData.fromMonsterID;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof FieldItemBagIdentityData))
			return;
		
		FieldItemBagIdentityData mData=(FieldItemBagIdentityData)data;
		
		this.fromMonsterID=mData.fromMonsterID;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		FieldItemBagIdentityData mData=(FieldItemBagIdentityData)data;
		if(this.fromMonsterID!=mData.fromMonsterID)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("fromMonsterID");
		writer.sb.append(':');
		writer.sb.append(this.fromMonsterID);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		super.initDefault();
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.fromMonsterID=0;
	}
	
}
