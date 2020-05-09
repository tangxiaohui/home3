package com.home.commonBase.data.scene.unit;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.scene.unit.UnitAvatarData;
import com.home.commonBase.data.scene.unit.UnitIdentityData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 单位信息数据(generated by shine) */
public class UnitInfoData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.UnitInfo;
	
	/** 身份数据 */
	public UnitIdentityData identity;
	
	/** 造型数据 */
	public UnitAvatarData avatar;
	
	public UnitInfoData()
	{
		_dataID=BaseDataType.UnitInfo;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "UnitInfoData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		BaseData identityT=stream.readDataFullNotNull();
		if(identityT!=null)
		{
			if(identityT instanceof UnitIdentityData)
			{
				this.identity=(UnitIdentityData)identityT;
			}
			else
			{
				this.identity=new UnitIdentityData();
				if(!(identityT.getClass().isAssignableFrom(UnitIdentityData.class)))
				{
					stream.throwTypeReadError(UnitIdentityData.class,identityT.getClass());
				}
				this.identity.shadowCopy(identityT);
			}
		}
		else
		{
			this.identity=null;
		}
		
		if(stream.readBoolean())
		{
			BaseData avatarT=stream.readDataFullNotNull();
			if(avatarT!=null)
			{
				if(avatarT instanceof UnitAvatarData)
				{
					this.avatar=(UnitAvatarData)avatarT;
				}
				else
				{
					this.avatar=new UnitAvatarData();
					if(!(avatarT.getClass().isAssignableFrom(UnitAvatarData.class)))
					{
						stream.throwTypeReadError(UnitAvatarData.class,avatarT.getClass());
					}
					this.avatar.shadowCopy(avatarT);
				}
			}
			else
			{
				this.avatar=null;
			}
		}
		else
		{
			this.avatar=null;
		}
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.identity!=null)
		{
			stream.writeDataFullNotNull(this.identity);
		}
		else
		{
			nullObjError("identity");
		}
		
		if(this.avatar!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataFullNotNull(this.avatar);
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
		this.identity=(UnitIdentityData)stream.readDataSimpleNotNull();
		
		if(stream.readBoolean())
		{
			this.avatar=(UnitAvatarData)stream.readDataSimpleNotNull();
		}
		else
		{
			this.avatar=null;
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.identity!=null)
		{
			stream.writeDataSimpleNotNull(this.identity);
		}
		else
		{
			nullObjError("identity");
		}
		
		if(this.avatar!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataSimpleNotNull(this.avatar);
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
		if(!(data instanceof UnitInfoData))
			return;
		
		UnitInfoData mData=(UnitInfoData)data;
		
		this.identity=mData.identity;
		this.avatar=mData.avatar;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof UnitInfoData))
			return;
		
		UnitInfoData mData=(UnitInfoData)data;
		
		if(mData.identity!=null)
		{
			this.identity=(UnitIdentityData)mData.identity.clone();
		}
		else
		{
			this.identity=null;
			nullObjError("identity");
		}
		
		if(mData.avatar!=null)
		{
			this.avatar=(UnitAvatarData)mData.avatar.clone();
		}
		else
		{
			this.avatar=null;
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		UnitInfoData mData=(UnitInfoData)data;
		if(mData.identity!=null)
		{
			if(this.identity==null)
				return false;
			if(!this.identity.dataEquals(mData.identity))
				return false;
		}
		else
		{
			if(this.identity!=null)
				return false;
		}
		
		if(mData.avatar!=null)
		{
			if(this.avatar==null)
				return false;
			if(!this.avatar.dataEquals(mData.avatar))
				return false;
		}
		else
		{
			if(this.avatar!=null)
				return false;
		}
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("identity");
		writer.sb.append(':');
		if(this.identity!=null)
		{
			this.identity.writeDataString(writer);
		}
		else
		{
			writer.sb.append("UnitIdentityData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("avatar");
		writer.sb.append(':');
		if(this.avatar!=null)
		{
			this.avatar.writeDataString(writer);
		}
		else
		{
			writer.sb.append("UnitAvatarData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		this.identity=new UnitIdentityData();
		this.identity.initDefault();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.identity=null;
		this.avatar=null;
	}
	
}