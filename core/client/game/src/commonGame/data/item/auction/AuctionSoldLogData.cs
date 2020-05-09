using ShineEngine;

/// <summary>
/// 拍卖行出售物品日志(generated by shine)
/// </summary>
public class AuctionSoldLogData:FuncInfoLogData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.AuctionSoldLog;
	
	/// <summary>
	/// 物品信息
	/// </summary>
	public ItemData item;
	
	/// <summary>
	/// 单价
	/// </summary>
	public int price;
	
	/// <summary>
	/// 购买者信息
	/// </summary>
	public RoleSimpleShowData role;
	
	public AuctionSoldLogData()
	{
		_dataID=BaseDataType.AuctionSoldLog;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "AuctionSoldLogData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		BaseData roleT=stream.readDataFullNotNull();
		if(roleT!=null)
		{
			if(roleT is RoleSimpleShowData)
			{
				this.role=(RoleSimpleShowData)roleT;
			}
			else
			{
				this.role=new RoleSimpleShowData();
				if(!(roleT.GetType().IsAssignableFrom(typeof(RoleSimpleShowData))))
				{
					stream.throwTypeReadError(typeof(RoleSimpleShowData),roleT.GetType());
				}
				this.role.shadowCopy(roleT);
			}
		}
		else
		{
			this.role=null;
		}
		
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
		
		this.price=stream.readInt();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.role!=null)
		{
			stream.writeDataFullNotNull(this.role);
		}
		else
		{
			nullObjError("role");
		}
		
		if(this.item!=null)
		{
			stream.writeDataFullNotNull(this.item);
		}
		else
		{
			nullObjError("item");
		}
		
		stream.writeInt(this.price);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.role=(RoleSimpleShowData)stream.readDataSimpleNotNull();
		
		this.item=(ItemData)stream.readDataSimpleNotNull();
		
		this.price=stream.readInt();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		if(this.role!=null)
		{
			stream.writeDataSimpleNotNull(this.role);
		}
		else
		{
			nullObjError("role");
		}
		
		if(this.item!=null)
		{
			stream.writeDataSimpleNotNull(this.item);
		}
		else
		{
			nullObjError("item");
		}
		
		stream.writeInt(this.price);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		base.toShadowCopy(data);
		
		if(!(data is AuctionSoldLogData))
			return;
		
		AuctionSoldLogData mData=(AuctionSoldLogData)data;
		
		this.role=mData.role;
		this.item=mData.item;
		this.price=mData.price;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		base.toCopy(data);
		
		if(!(data is AuctionSoldLogData))
			return;
		
		AuctionSoldLogData mData=(AuctionSoldLogData)data;
		
		if(mData.role!=null)
		{
			this.role=(RoleSimpleShowData)mData.role.clone();
		}
		else
		{
			this.role=null;
			nullObjError("role");
		}
		
		if(mData.item!=null)
		{
			this.item=(ItemData)mData.item.clone();
		}
		else
		{
			this.item=null;
			nullObjError("item");
		}
		
		this.price=mData.price;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		if(!base.toDataEquals(data))
			return false;
		
		AuctionSoldLogData mData=(AuctionSoldLogData)data;
		if(mData.role!=null)
		{
			if(this.role==null)
				return false;
			if(!this.role.dataEquals(mData.role))
				return false;
		}
		else
		{
			if(this.role!=null)
				return false;
		}
		
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
		
		if(this.price!=mData.price)
			return false;
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("role");
		writer.sb.Append(':');
		if(this.role!=null)
		{
			this.role.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("RoleSimpleShowData=null");
		}
		
		writer.writeEnter();
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
		writer.writeTabs();
		writer.sb.Append("price");
		writer.sb.Append(':');
		writer.sb.Append(this.price);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		base.initDefault();
		
		this.role=new RoleSimpleShowData();
		this.role.initDefault();
		this.item=new ItemData();
		this.item.initDefault();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.role=null;
		this.item=null;
		this.price=0;
	}
	
}