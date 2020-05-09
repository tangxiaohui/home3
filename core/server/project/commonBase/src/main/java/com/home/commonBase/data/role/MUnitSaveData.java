package com.home.commonBase.data.role;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.item.EquipContainerData;
import com.home.commonBase.data.role.MUnitCacheData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.ctrl.Ctrl;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 主单位存库数据(generated by shine) */
public class MUnitSaveData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.MUnitSave;
	
	/** 装备组 */
	public EquipContainerData equips;
	
	/** 缓存数据 */
	public MUnitCacheData cache;
	
	/** 角色ID */
	public int id;
	
	/** 主单位序号 */
	public int mIndex;
	
	public MUnitSaveData()
	{
		_dataID=BaseDataType.MUnitSave;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "MUnitSaveData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.id=stream.readInt();
		
		if(stream.readBoolean())
		{
			BaseData cacheT=stream.readDataFullNotNull();
			if(cacheT!=null)
			{
				if(cacheT instanceof MUnitCacheData)
				{
					this.cache=(MUnitCacheData)cacheT;
				}
				else
				{
					this.cache=new MUnitCacheData();
					if(!(cacheT.getClass().isAssignableFrom(MUnitCacheData.class)))
					{
						stream.throwTypeReadError(MUnitCacheData.class,cacheT.getClass());
					}
					this.cache.shadowCopy(cacheT);
				}
			}
			else
			{
				this.cache=null;
			}
		}
		else
		{
			this.cache=null;
		}
		
		BaseData equipsT=stream.readDataFullNotNull();
		if(equipsT!=null)
		{
			if(equipsT instanceof EquipContainerData)
			{
				this.equips=(EquipContainerData)equipsT;
			}
			else
			{
				this.equips=new EquipContainerData();
				if(!(equipsT.getClass().isAssignableFrom(EquipContainerData.class)))
				{
					stream.throwTypeReadError(EquipContainerData.class,equipsT.getClass());
				}
				this.equips.shadowCopy(equipsT);
			}
		}
		else
		{
			this.equips=null;
		}
		
		this.mIndex=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.id);
		
		if(this.cache!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataFullNotNull(this.cache);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.equips!=null)
		{
			stream.writeDataFullNotNull(this.equips);
		}
		else
		{
			nullObjError("equips");
		}
		
		stream.writeInt(this.mIndex);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.id=stream.readInt();
		
		if(stream.readBoolean())
		{
			this.cache=(MUnitCacheData)stream.readDataSimpleNotNull();
		}
		else
		{
			this.cache=null;
		}
		
		this.equips=(EquipContainerData)stream.readDataSimpleNotNull();
		
		this.mIndex=stream.readInt();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.id);
		
		if(this.cache!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataSimpleNotNull(this.cache);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.equips!=null)
		{
			stream.writeDataSimpleNotNull(this.equips);
		}
		else
		{
			nullObjError("equips");
		}
		
		stream.writeInt(this.mIndex);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof MUnitSaveData))
			return;
		
		MUnitSaveData mData=(MUnitSaveData)data;
		
		this.id=mData.id;
		this.cache=mData.cache;
		this.equips=mData.equips;
		this.mIndex=mData.mIndex;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof MUnitSaveData))
			return;
		
		MUnitSaveData mData=(MUnitSaveData)data;
		
		this.id=mData.id;
		
		if(mData.cache!=null)
		{
			this.cache=(MUnitCacheData)mData.cache.clone();
		}
		else
		{
			this.cache=null;
		}
		
		if(mData.equips!=null)
		{
			this.equips=(EquipContainerData)mData.equips.clone();
		}
		else
		{
			this.equips=null;
			nullObjError("equips");
		}
		
		this.mIndex=mData.mIndex;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		MUnitSaveData mData=(MUnitSaveData)data;
		if(this.id!=mData.id)
			return false;
		
		if(mData.cache!=null)
		{
			if(this.cache==null)
				return false;
			if(!this.cache.dataEquals(mData.cache))
				return false;
		}
		else
		{
			if(this.cache!=null)
				return false;
		}
		
		if(mData.equips!=null)
		{
			if(this.equips==null)
				return false;
			if(!this.equips.dataEquals(mData.equips))
				return false;
		}
		else
		{
			if(this.equips!=null)
				return false;
		}
		
		if(this.mIndex!=mData.mIndex)
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
		writer.sb.append("cache");
		writer.sb.append(':');
		if(this.cache!=null)
		{
			this.cache.writeDataString(writer);
		}
		else
		{
			writer.sb.append("MUnitCacheData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("equips");
		writer.sb.append(':');
		if(this.equips!=null)
		{
			this.equips.writeDataString(writer);
		}
		else
		{
			writer.sb.append("EquipContainerData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("mIndex");
		writer.sb.append(':');
		writer.sb.append(this.mIndex);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		this.equips=new EquipContainerData();
		this.equips.initDefault();
	}
	
	public int getUnitType()
	{
		Ctrl.throwError("this function should be override");
		return -1;
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.id=0;
		this.cache=null;
		this.equips=null;
		this.mIndex=0;
	}
	
}