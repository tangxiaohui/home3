package com.home.commonBase.data.system;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.system.KeepSaveData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 客户端本地角色缓存数据(generated by shine) */
public class ClientPlayerLocalCacheData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.ClientPlayerLocalCache;
	
	/** 标准保存数据 */
	public KeepSaveData keep;
	
	public ClientPlayerLocalCacheData()
	{
		_dataID=BaseDataType.ClientPlayerLocalCache;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ClientPlayerLocalCacheData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.keep=new KeepSaveData();
		this.keep.readBytesFull(stream);
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.keep!=null)
		{
			this.keep.writeBytesFull(stream);
		}
		else
		{
			nullObjError("keep");
		}
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.keep=new KeepSaveData();
		this.keep.readBytesSimple(stream);
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.keep!=null)
		{
			this.keep.writeBytesSimple(stream);
		}
		else
		{
			nullObjError("keep");
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof ClientPlayerLocalCacheData))
			return;
		
		ClientPlayerLocalCacheData mData=(ClientPlayerLocalCacheData)data;
		
		this.keep=mData.keep;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof ClientPlayerLocalCacheData))
			return;
		
		ClientPlayerLocalCacheData mData=(ClientPlayerLocalCacheData)data;
		
		if(mData.keep!=null)
		{
			this.keep=new KeepSaveData();
			this.keep.copy(mData.keep);
		}
		else
		{
			this.keep=null;
			nullObjError("keep");
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		ClientPlayerLocalCacheData mData=(ClientPlayerLocalCacheData)data;
		if(mData.keep!=null)
		{
			if(this.keep==null)
				return false;
			if(!this.keep.dataEquals(mData.keep))
				return false;
		}
		else
		{
			if(this.keep!=null)
				return false;
		}
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("keep");
		writer.sb.append(':');
		if(this.keep!=null)
		{
			this.keep.writeDataString(writer);
		}
		else
		{
			writer.sb.append("KeepSaveData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		this.keep=new KeepSaveData();
		this.keep.initDefault();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.keep=null;
	}
	
}
