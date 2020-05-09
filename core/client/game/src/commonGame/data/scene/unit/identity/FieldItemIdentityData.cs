using ShineEngine;

/// <summary>
/// 掉落物品身份数据(generated by shine)
/// </summary>
public class FieldItemIdentityData:UnitIdentityData
{
	/// <summary>
	/// 物品数据
	/// </summary>
	public ItemData item;
	
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.FieldItemIdentity;
	
	public FieldItemIdentityData()
	{
		_dataID=BaseDataType.FieldItemIdentity;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "FieldItemIdentityData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		BaseData itemT=stream.readDataFullNotNull();
		if(itemT!=null)
		{
			if(itemT is ItemData)
			{
				this.item=(ItemData)itemT;
			}
			else
			{
				this.item=new ItemData();
				if(!(itemT.GetType().IsAssignableFrom(typeof(ItemData))))
				{
					stream.throwTypeReadError(typeof(ItemData),itemT.GetType());
				}
				this.item.shadowCopy(itemT);
			}
		}
		else
		{
			this.item=null;
		}
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.item!=null)
		{
			stream.writeDataFullNotNull(this.item);
		}
		else
		{
			nullObjError("item");
		}
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.item=(ItemData)stream.readDataSimpleNotNull();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		if(this.item!=null)
		{
			stream.writeDataSimpleNotNull(this.item);
		}
		else
		{
			nullObjError("item");
		}
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		base.toShadowCopy(data);
		
		if(!(data is FieldItemIdentityData))
			return;
		
		FieldItemIdentityData mData=(FieldItemIdentityData)data;
		
		this.item=mData.item;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		base.toCopy(data);
		
		if(!(data is FieldItemIdentityData))
			return;
		
		FieldItemIdentityData mData=(FieldItemIdentityData)data;
		
		if(mData.item!=null)
		{
			this.item=(ItemData)mData.item.clone();
		}
		else
		{
			this.item=null;
			nullObjError("item");
		}
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		if(!base.toDataEquals(data))
			return false;
		
		FieldItemIdentityData mData=(FieldItemIdentityData)data;
		if(mData.item!=null)
		{
			if(this.item==null)
				return false;
			if(!this.item.dataEquals(mData.item))
				return false;
		}
		else
		{
			if(this.item!=null)
				return false;
		}
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("item");
		writer.sb.Append(':');
		if(this.item!=null)
		{
			this.item.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("ItemData=null");
		}
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		base.initDefault();
		
		this.item=new ItemData();
		this.item.initDefault();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.item=null;
	}
	
	public override void clear()
	{
		item=null;
	}
	
}