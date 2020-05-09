package com.home.commonBase.data.scene.scene;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.role.RoleShowChangeData;
import com.home.commonBase.data.role.RoleShowData;
import com.home.commonBase.data.scene.scene.SceneLocationData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 场景位置社交改变数据(generated by shine) */
public class SceneLocationRoleShowChangeData extends RoleShowChangeData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.SceneLocationRoleShowChange;
	
	/** 场景位置 */
	public SceneLocationData localtion;
	
	public SceneLocationRoleShowChangeData()
	{
		_dataID=BaseDataType.SceneLocationRoleShowChange;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "SceneLocationRoleShowChangeData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		if(stream.readBoolean())
		{
			BaseData localtionT=stream.readDataFullNotNull();
			if(localtionT!=null)
			{
				if(localtionT instanceof SceneLocationData)
				{
					this.localtion=(SceneLocationData)localtionT;
				}
				else
				{
					this.localtion=new SceneLocationData();
					if(!(localtionT.getClass().isAssignableFrom(SceneLocationData.class)))
					{
						stream.throwTypeReadError(SceneLocationData.class,localtionT.getClass());
					}
					this.localtion.shadowCopy(localtionT);
				}
			}
			else
			{
				this.localtion=null;
			}
		}
		else
		{
			this.localtion=null;
		}
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.localtion!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataFullNotNull(this.localtion);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		if(stream.readBoolean())
		{
			this.localtion=(SceneLocationData)stream.readDataSimpleNotNull();
		}
		else
		{
			this.localtion=null;
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.localtion!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataSimpleNotNull(this.localtion);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof SceneLocationRoleShowChangeData))
			return;
		
		SceneLocationRoleShowChangeData mData=(SceneLocationRoleShowChangeData)data;
		
		this.localtion=mData.localtion;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof SceneLocationRoleShowChangeData))
			return;
		
		SceneLocationRoleShowChangeData mData=(SceneLocationRoleShowChangeData)data;
		
		if(mData.localtion!=null)
		{
			this.localtion=(SceneLocationData)mData.localtion.clone();
		}
		else
		{
			this.localtion=null;
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		SceneLocationRoleShowChangeData mData=(SceneLocationRoleShowChangeData)data;
		if(mData.localtion!=null)
		{
			if(this.localtion==null)
				return false;
			if(!this.localtion.dataEquals(mData.localtion))
				return false;
		}
		else
		{
			if(this.localtion!=null)
				return false;
		}
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("localtion");
		writer.sb.append(':');
		if(this.localtion!=null)
		{
			this.localtion.writeDataString(writer);
		}
		else
		{
			writer.sb.append("SceneLocationData=null");
		}
		
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
		
		this.localtion=null;
	}
	
}