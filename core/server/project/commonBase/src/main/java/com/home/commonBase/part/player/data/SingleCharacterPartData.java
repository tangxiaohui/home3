package com.home.commonBase.part.player.data;
import com.home.commonBase.constlist.generate.PlayerPartDataType;
import com.home.commonBase.data.role.CharacterSaveData;
import com.home.commonBase.part.player.data.CharacterPartData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 单一角色模块(generated by shine) */
public class SingleCharacterPartData extends CharacterPartData
{
	/** 主角数据 */
	public CharacterSaveData hero;
	
	/** 数据类型ID */
	public static final int dataID=PlayerPartDataType.SingleCharacter;
	
	public SingleCharacterPartData()
	{
		_dataID=PlayerPartDataType.SingleCharacter;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "SingleCharacterPartData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		BaseData heroT=stream.readDataFullNotNull();
		if(heroT!=null)
		{
			if(heroT instanceof CharacterSaveData)
			{
				this.hero=(CharacterSaveData)heroT;
			}
			else
			{
				this.hero=new CharacterSaveData();
				if(!(heroT.getClass().isAssignableFrom(CharacterSaveData.class)))
				{
					stream.throwTypeReadError(CharacterSaveData.class,heroT.getClass());
				}
				this.hero.shadowCopy(heroT);
			}
		}
		else
		{
			this.hero=null;
		}
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.hero!=null)
		{
			stream.writeDataFullNotNull(this.hero);
		}
		else
		{
			nullObjError("hero");
		}
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.hero=(CharacterSaveData)stream.readDataSimpleNotNull();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.hero!=null)
		{
			stream.writeDataSimpleNotNull(this.hero);
		}
		else
		{
			nullObjError("hero");
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof SingleCharacterPartData))
			return;
		
		SingleCharacterPartData mData=(SingleCharacterPartData)data;
		
		this.hero=mData.hero;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof SingleCharacterPartData))
			return;
		
		SingleCharacterPartData mData=(SingleCharacterPartData)data;
		
		if(mData.hero!=null)
		{
			this.hero=(CharacterSaveData)mData.hero.clone();
		}
		else
		{
			this.hero=null;
			nullObjError("hero");
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		SingleCharacterPartData mData=(SingleCharacterPartData)data;
		if(mData.hero!=null)
		{
			if(this.hero==null)
				return false;
			if(!this.hero.dataEquals(mData.hero))
				return false;
		}
		else
		{
			if(this.hero!=null)
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
		writer.sb.append("hero");
		writer.sb.append(':');
		if(this.hero!=null)
		{
			this.hero.writeDataString(writer);
		}
		else
		{
			writer.sb.append("CharacterSaveData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		super.initDefault();
		
		this.hero=new CharacterSaveData();
		this.hero.initDefault();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.hero=null;
	}
	
}