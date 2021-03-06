using ShineEngine;

/// <summary>
/// 邮件数据(generated by shine)
/// </summary>
public class MailData:BaseData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.Mail;
	
	/// <summary>
	/// 实例ID
	/// </summary>
	public int instanceID;
	
	/// <summary>
	/// 邮件ID
	/// </summary>
	public int id;
	
	/// <summary>
	/// 参数组(如全自定义邮件，则args[0]为title,args[1]为content)
	/// </summary>
	public string[] args;
	
	/// <summary>
	/// 时间戳
	/// </summary>
	public long time;
	
	/// <summary>
	/// 物品列表
	/// </summary>
	public SList<ItemData> itemList;
	
	/// <summary>
	/// 是否领取过
	/// </summary>
	public bool rewarded;
	
	/// <summary>
	/// 是否有红点
	/// </summary>
	public bool hasRedPoint;
	
	/// <summary>
	/// 平台
	/// </summary>
	public string platform;
	
	/// <summary>
	/// 是否阅读过
	/// </summary>
	public bool readed;
	
	/// <summary>
	/// 邮件索引
	/// </summary>
	public int index;
	
	public MailData()
	{
		_dataID=BaseDataType.Mail;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "MailData";
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		this.instanceID=stream.readInt();
		
		this.id=stream.readInt();
		
		this.time=stream.readLong();
		
		if(stream.readBoolean())
		{
			int argsLen=stream.readLen();
			if(this.args==null || this.args.Length!=argsLen)
			{
				this.args=new string[argsLen];
			}
			string[] argsT=this.args;
			for(int argsI=0;argsI<argsLen;++argsI)
			{
				string argsV;
				argsV=stream.readUTF();
				
				argsT[argsI]=argsV;
			}
		}
		else
		{
			this.args=null;
		}
		
		if(stream.readBoolean())
		{
			int itemListLen=stream.readLen();
			if(this.itemList!=null)
			{
				this.itemList.clear();
				this.itemList.ensureCapacity(itemListLen);
			}
			else
			{
				this.itemList=new SList<ItemData>();
			}
			
			SList<ItemData> itemListT=this.itemList;
			for(int itemListI=itemListLen-1;itemListI>=0;--itemListI)
			{
				ItemData itemListV;
				if(stream.readBoolean())
				{
					itemListV=(ItemData)stream.readDataSimpleNotNull();
				}
				else
				{
					itemListV=null;
				}
				
				itemListT.add(itemListV);
			}
		}
		else
		{
			this.itemList=null;
		}
		
		this.readed=stream.readBoolean();
		
		this.rewarded=stream.readBoolean();
		
		this.hasRedPoint=stream.readBoolean();
		
		this.platform=stream.readUTF();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.instanceID);
		
		stream.writeInt(this.id);
		
		stream.writeLong(this.time);
		
		if(this.args!=null)
		{
			stream.writeBoolean(true);
			string[] argsT=this.args;
			stream.writeLen(argsT.Length);
			for(int argsVI=0,argsVLen=argsT.Length;argsVI<argsVLen;++argsVI)
			{
				string argsV=argsT[argsVI];
				stream.writeUTF(argsV);
				
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.itemList!=null)
		{
			stream.writeBoolean(true);
			stream.writeLen(this.itemList.size());
			if(!this.itemList.isEmpty())
			{
				ItemData[] itemListVValues=this.itemList.getValues();
				for(int itemListVI=0,itemListVLen=this.itemList.length();itemListVI<itemListVLen;++itemListVI)
				{
					ItemData itemListV=itemListVValues[itemListVI];
					if(itemListV!=null)
					{
						stream.writeBoolean(true);
						stream.writeDataSimpleNotNull(itemListV);
					}
					else
					{
						stream.writeBoolean(false);
					}
					
				}
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeBoolean(this.readed);
		
		stream.writeBoolean(this.rewarded);
		
		stream.writeBoolean(this.hasRedPoint);
		
		stream.writeUTF(this.platform);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is MailData))
			return;
		
		MailData mData=(MailData)data;
		
		this.instanceID=mData.instanceID;
		this.id=mData.id;
		this.time=mData.time;
		this.args=mData.args;
		this.itemList=mData.itemList;
		this.readed=mData.readed;
		this.rewarded=mData.rewarded;
		this.hasRedPoint=mData.hasRedPoint;
		this.platform=mData.platform;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is MailData))
			return;
		
		MailData mData=(MailData)data;
		
		this.instanceID=mData.instanceID;
		
		this.id=mData.id;
		
		this.time=mData.time;
		
		if(mData.args!=null)
		{
			string[] argsR=mData.args;
			int argsLen=argsR.Length;
			if(this.args==null || this.args.Length!=argsLen)
			{
				this.args=new string[argsLen];
			}
			string[] argsT=this.args;
			for(int argsI=0;argsI<argsLen;++argsI)
			{
				string argsV=argsR[argsI];
				string argsU;
				argsU=argsV;
				
				argsT[argsI]=argsU;
			}
		}
		else
		{
			this.args=null;
		}
		
		if(mData.itemList!=null)
		{
			if(this.itemList!=null)
			{
				this.itemList.clear();
				this.itemList.ensureCapacity(mData.itemList.size());
			}
			else
			{
				this.itemList=new SList<ItemData>();
			}
			
			SList<ItemData> itemListT=this.itemList;
			if(!mData.itemList.isEmpty())
			{
				ItemData[] itemListVValues=mData.itemList.getValues();
				for(int itemListVI=0,itemListVLen=mData.itemList.length();itemListVI<itemListVLen;++itemListVI)
				{
					ItemData itemListV=itemListVValues[itemListVI];
					ItemData itemListU;
					if(itemListV!=null)
					{
						itemListU=(ItemData)itemListV.clone();
					}
					else
					{
						itemListU=null;
					}
					
					itemListT.add(itemListU);
				}
			}
		}
		else
		{
			this.itemList=null;
		}
		
		this.readed=mData.readed;
		
		this.rewarded=mData.rewarded;
		
		this.hasRedPoint=mData.hasRedPoint;
		
		this.platform=mData.platform;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		MailData mData=(MailData)data;
		if(this.instanceID!=mData.instanceID)
			return false;
		
		if(this.id!=mData.id)
			return false;
		
		if(this.time!=mData.time)
			return false;
		
		if(mData.args!=null)
		{
			if(this.args==null)
				return false;
			if(this.args.Length!=mData.args.Length)
				return false;
			string[] argsT=this.args;
			string[] argsR=mData.args;
			int argsLen=argsT.Length;
			for(int argsI=0;argsI<argsLen;++argsI)
			{
				string argsU=argsT[argsI];
				string argsV=argsR[argsI];
				if(argsU!=argsV)
					return false;
				
			}
		}
		else
		{
			if(this.args!=null)
				return false;
		}
		
		if(mData.itemList!=null)
		{
			if(this.itemList==null)
				return false;
			if(this.itemList.size()!=mData.itemList.size())
				return false;
			SList<ItemData> itemListT=this.itemList;
			SList<ItemData> itemListR=mData.itemList;
			int itemListLen=itemListT.size();
			for(int itemListI=0;itemListI<itemListLen;++itemListI)
			{
				ItemData itemListU=itemListT.get(itemListI);
				ItemData itemListV=itemListR.get(itemListI);
				if(itemListV!=null)
				{
					if(itemListU==null)
						return false;
					if(!itemListU.dataEquals(itemListV))
						return false;
				}
				else
				{
					if(itemListU!=null)
						return false;
				}
				
			}
		}
		else
		{
			if(this.itemList!=null)
				return false;
		}
		
		if(this.readed!=mData.readed)
			return false;
		
		if(this.rewarded!=mData.rewarded)
			return false;
		
		if(this.hasRedPoint!=mData.hasRedPoint)
			return false;
		
		if(this.platform!=mData.platform)
			return false;
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.Append("instanceID");
		writer.sb.Append(':');
		writer.sb.Append(this.instanceID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("id");
		writer.sb.Append(':');
		writer.sb.Append(this.id);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("time");
		writer.sb.Append(':');
		writer.sb.Append(this.time);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("args");
		writer.sb.Append(':');
		writer.sb.Append("Array<string>");
		if(this.args!=null)
		{
			string[] argsT=this.args;
			int argsLen=argsT.Length;
			writer.sb.Append('(');
			writer.sb.Append(argsLen);
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int argsI=0;argsI<argsLen;++argsI)
			{
				string argsV=argsT[argsI];
				writer.writeTabs();
				writer.sb.Append(argsI);
				writer.sb.Append(':');
				writer.sb.Append(argsV);
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.Append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("itemList");
		writer.sb.Append(':');
		writer.sb.Append("List<ItemData>");
		if(this.itemList!=null)
		{
			SList<ItemData> itemListT=this.itemList;
			int itemListLen=itemListT.size();
			writer.sb.Append('(');
			writer.sb.Append(itemListLen);
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int itemListI=0;itemListI<itemListLen;++itemListI)
			{
				ItemData itemListV=itemListT.get(itemListI);
				writer.writeTabs();
				writer.sb.Append(itemListI);
				writer.sb.Append(':');
				if(itemListV!=null)
				{
					itemListV.writeDataString(writer);
				}
				else
				{
					writer.sb.Append("ItemData=null");
				}
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.Append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("readed");
		writer.sb.Append(':');
		writer.sb.Append(this.readed);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("rewarded");
		writer.sb.Append(':');
		writer.sb.Append(this.rewarded);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("hasRedPoint");
		writer.sb.Append(':');
		writer.sb.Append(this.hasRedPoint);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("platform");
		writer.sb.Append(':');
		writer.sb.Append(this.platform);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.instanceID=stream.readInt();
		
		this.id=stream.readInt();
		
		this.time=stream.readLong();
		
		if(stream.readBoolean())
		{
			int argsLen=stream.readLen();
			if(this.args==null || this.args.Length!=argsLen)
			{
				this.args=new string[argsLen];
			}
			string[] argsT=this.args;
			for(int argsI=0;argsI<argsLen;++argsI)
			{
				string argsV;
				argsV=stream.readUTF();
				
				argsT[argsI]=argsV;
			}
		}
		else
		{
			this.args=null;
		}
		
		if(stream.readBoolean())
		{
			int itemListLen=stream.readLen();
			if(this.itemList!=null)
			{
				this.itemList.clear();
				this.itemList.ensureCapacity(itemListLen);
			}
			else
			{
				this.itemList=new SList<ItemData>();
			}
			
			SList<ItemData> itemListT=this.itemList;
			for(int itemListI=itemListLen-1;itemListI>=0;--itemListI)
			{
				ItemData itemListV;
				if(stream.readBoolean())
				{
					BaseData itemListVT=stream.readDataFullNotNull();
					if(itemListVT!=null)
					{
						if(itemListVT is ItemData)
						{
							itemListV=(ItemData)itemListVT;
						}
						else
						{
							itemListV=new ItemData();
							if(!(itemListVT.GetType().IsAssignableFrom(typeof(ItemData))))
							{
								stream.throwTypeReadError(typeof(ItemData),itemListVT.GetType());
							}
							itemListV.shadowCopy(itemListVT);
						}
					}
					else
					{
						itemListV=null;
					}
				}
				else
				{
					itemListV=null;
				}
				
				itemListT.add(itemListV);
			}
		}
		else
		{
			this.itemList=null;
		}
		
		this.readed=stream.readBoolean();
		
		this.rewarded=stream.readBoolean();
		
		this.hasRedPoint=stream.readBoolean();
		
		this.platform=stream.readUTF();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.instanceID);
		
		stream.writeInt(this.id);
		
		stream.writeLong(this.time);
		
		if(this.args!=null)
		{
			stream.writeBoolean(true);
			string[] argsT=this.args;
			stream.writeLen(argsT.Length);
			for(int argsVI=0,argsVLen=argsT.Length;argsVI<argsVLen;++argsVI)
			{
				string argsV=argsT[argsVI];
				stream.writeUTF(argsV);
				
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.itemList!=null)
		{
			stream.writeBoolean(true);
			stream.writeLen(this.itemList.size());
			if(!this.itemList.isEmpty())
			{
				ItemData[] itemListVValues=this.itemList.getValues();
				for(int itemListVI=0,itemListVLen=this.itemList.length();itemListVI<itemListVLen;++itemListVI)
				{
					ItemData itemListV=itemListVValues[itemListVI];
					if(itemListV!=null)
					{
						stream.writeBoolean(true);
						stream.writeDataFullNotNull(itemListV);
					}
					else
					{
						stream.writeBoolean(false);
					}
					
				}
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeBoolean(this.readed);
		
		stream.writeBoolean(this.rewarded);
		
		stream.writeBoolean(this.hasRedPoint);
		
		stream.writeUTF(this.platform);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		this.instanceID=0;
		this.id=0;
		this.time=0L;
		this.args=null;
		this.itemList=null;
		this.readed=false;
		this.rewarded=false;
		this.hasRedPoint=false;
		this.platform="";
	}
	
	public override void clear()
	{
		instanceID=0;
		id=0;
		time=0L;
		args=null;
		itemList=null;
		readed=false;
		rewarded=false;
		hasRedPoint=false;
		platform="";
	}
	
}
