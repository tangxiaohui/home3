using ShineEngine;

/// <summary>
/// 物品数据(generated by shine)
/// </summary>
public class ItemData:BaseData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.Item;
	
	/// <summary>
	/// 物品ID
	/// </summary>
	public int id;
	
	/// <summary>
	/// 物品数目
	/// </summary>
	public int num;
	
	/// <summary>
	/// 失效时间(-1为失效或过期)
	/// </summary>
	public long disableTime=-1L;
	
	/// <summary>
	/// 是否绑定
	/// </summary>
	public bool isBind;
	
	/// <summary>
	/// 身份数据
	/// </summary>
	public ItemIdentityData identity;
	
	/// <summary>
	/// 物品配置
	/// </summary>
	public ItemConfig config;
	
	/// <summary>
	/// 回收标记
	/// </summary>
	public bool canRelease;
	
	/// <summary>
	/// 所在索引
	/// </summary>
	public int index=-1;
	
	/// <summary>
	/// 是否有红点
	/// </summary>
	public bool hasRedPoint;
	
	public ItemData()
	{
		_dataID=BaseDataType.Item;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "ItemData";
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		this.id=stream.readInt();
		
		this.num=stream.readInt();
		
		this.isBind=stream.readBoolean();
		
		this.disableTime=stream.readLong();
		
		if(stream.readBoolean())
		{
			this.identity=(ItemIdentityData)stream.readDataSimpleNotNull();
		}
		else
		{
			this.identity=null;
		}
		
		this.hasRedPoint=stream.readBoolean();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.id);
		
		stream.writeInt(this.num);
		
		stream.writeBoolean(this.isBind);
		
		stream.writeLong(this.disableTime);
		
		if(this.identity!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataSimpleNotNull(this.identity);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeBoolean(this.hasRedPoint);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is ItemData))
			return;
		
		ItemData mData=(ItemData)data;
		
		this.id=mData.id;
		this.num=mData.num;
		this.isBind=mData.isBind;
		this.disableTime=mData.disableTime;
		this.identity=mData.identity;
		this.hasRedPoint=mData.hasRedPoint;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is ItemData))
			return;
		
		ItemData mData=(ItemData)data;
		
		this.id=mData.id;
		
		this.num=mData.num;
		
		this.isBind=mData.isBind;
		
		this.disableTime=mData.disableTime;
		
		if(mData.identity!=null)
		{
			this.identity=(ItemIdentityData)mData.identity.clone();
		}
		else
		{
			this.identity=null;
		}
		
		this.hasRedPoint=mData.hasRedPoint;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		ItemData mData=(ItemData)data;
		if(this.id!=mData.id)
			return false;
		
		if(this.num!=mData.num)
			return false;
		
		if(this.isBind!=mData.isBind)
			return false;
		
		if(this.disableTime!=mData.disableTime)
			return false;
		
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
		
		if(this.hasRedPoint!=mData.hasRedPoint)
			return false;
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.Append("id");
		writer.sb.Append(':');
		writer.sb.Append(this.id);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("num");
		writer.sb.Append(':');
		writer.sb.Append(this.num);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("isBind");
		writer.sb.Append(':');
		writer.sb.Append(this.isBind);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("disableTime");
		writer.sb.Append(':');
		writer.sb.Append(this.disableTime);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("identity");
		writer.sb.Append(':');
		if(this.identity!=null)
		{
			this.identity.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("ItemIdentityData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("hasRedPoint");
		writer.sb.Append(':');
		writer.sb.Append(this.hasRedPoint);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		
	}
	
	/// <summary>
	/// 清空/析构
	/// </summary>
	public override void clear()
	{
		isBind=false;
		identity.clear();
		config=null;
		canRelease=false;
		index=-1;
		hasRedPoint=false;
	}
	
	public void initIdentityByType(int type)
	{
		identity=BaseC.logic.createItemIdentityByType(type);
		identity.type=type;//设置type
	}
	
	/// <summary>
	/// 初始化身份
	/// </summary>
	public void makeConfig()
	{
		if(config==null)
		{
			config=ItemConfig.get(id);
		}
	}
	
	/// <summary>
	/// 重载配置
	/// </summary>
	public void reloadConfig()
	{
		config=ItemConfig.get(id);
	}
	
	/// <summary>
	/// 从目标物品身上拷贝
	/// </summary>
	public void copyItem(ItemData data)
	{
		//数据拷贝
		this.copy(data);
		config=null;
		makeConfig();
	}
	
	/// <summary>
	/// 是否达到单个数目上限
	/// </summary>
	public bool isSingleNumMax()
	{
		return config.singlePlusMax>0 && num>=config.singlePlusMax;
	}
	
	/// <summary>
	/// 获取单个叠加空数(-1为无限)
	/// </summary>
	public int getPlusLast()
	{
		if(config.singlePlusMax<=0)
			return -1;

		if(num>=config.singlePlusMax)
			return 0;

		return config.singlePlusMax-num;
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.id=stream.readInt();
		
		this.num=stream.readInt();
		
		this.isBind=stream.readBoolean();
		
		this.disableTime=stream.readLong();
		
		if(stream.readBoolean())
		{
			BaseData identityT=stream.readDataFullNotNull();
			if(identityT!=null)
			{
				if(identityT is ItemIdentityData)
				{
					this.identity=(ItemIdentityData)identityT;
				}
				else
				{
					this.identity=new ItemIdentityData();
					if(!(identityT.GetType().IsAssignableFrom(typeof(ItemIdentityData))))
					{
						stream.throwTypeReadError(typeof(ItemIdentityData),identityT.GetType());
					}
					this.identity.shadowCopy(identityT);
				}
			}
			else
			{
				this.identity=null;
			}
		}
		else
		{
			this.identity=null;
		}
		
		this.hasRedPoint=stream.readBoolean();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.num);
		
		stream.writeBoolean(this.isBind);
		
		stream.writeLong(this.disableTime);
		
		if(this.identity!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataFullNotNull(this.identity);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeBoolean(this.hasRedPoint);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		this.id=0;
		this.num=0;
		this.isBind=false;
		this.disableTime=0L;
		this.identity=null;
		this.hasRedPoint=false;
	}
	
}
