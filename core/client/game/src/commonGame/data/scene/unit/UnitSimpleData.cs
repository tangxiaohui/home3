using ShineEngine;

/// <summary>
/// 单位简版数据(只位置,血量,身份)(generated by shine)
/// </summary>
public class UnitSimpleData:BaseData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.UnitSimple;
	
	/// <summary>
	/// 流水ID
	/// </summary>
	public int instanceID;
	
	/// <summary>
	/// 身份数据
	/// </summary>
	public UnitIdentityData identity;
	
	/// <summary>
	/// 位置数据
	/// </summary>
	public UnitPosData pos;
	
	/// <summary>
	/// 属性组(血量)
	/// </summary>
	public IntIntMap attributes;
	
	public UnitSimpleData()
	{
		_dataID=BaseDataType.UnitSimple;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "UnitSimpleData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.instanceID=stream.readInt();
		
		BaseData identityT=stream.readDataFullNotNull();
		if(identityT!=null)
		{
			if(identityT is UnitIdentityData)
			{
				this.identity=(UnitIdentityData)identityT;
			}
			else
			{
				this.identity=new UnitIdentityData();
				if(!(identityT.GetType().IsAssignableFrom(typeof(UnitIdentityData))))
				{
					stream.throwTypeReadError(typeof(UnitIdentityData),identityT.GetType());
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
			BaseData posT=stream.readDataFullNotNull();
			if(posT!=null)
			{
				if(posT is UnitPosData)
				{
					this.pos=(UnitPosData)posT;
				}
				else
				{
					this.pos=new UnitPosData();
					if(!(posT.GetType().IsAssignableFrom(typeof(UnitPosData))))
					{
						stream.throwTypeReadError(typeof(UnitPosData),posT.GetType());
					}
					this.pos.shadowCopy(posT);
				}
			}
			else
			{
				this.pos=null;
			}
		}
		else
		{
			this.pos=null;
		}
		
		int attributesLen=stream.readLen();
		if(this.attributes!=null)
		{
			this.attributes.clear();
			this.attributes.ensureCapacity(attributesLen);
		}
		else
		{
			this.attributes=new IntIntMap(attributesLen);
		}
		
		IntIntMap attributesT=this.attributes;
		for(int attributesI=attributesLen-1;attributesI>=0;--attributesI)
		{
			int attributesK;
			int attributesV;
			attributesK=stream.readInt();
			
			attributesV=stream.readInt();
			
			attributesT.put(attributesK,attributesV);
		}
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.instanceID);
		
		if(this.identity!=null)
		{
			stream.writeDataFullNotNull(this.identity);
		}
		else
		{
			nullObjError("identity");
		}
		
		if(this.pos!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataFullNotNull(this.pos);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.attributes!=null)
		{
			stream.writeLen(this.attributes.size());
			if(!this.attributes.isEmpty())
			{
				int attributesKFreeValue=this.attributes.getFreeValue();
				int[] attributesKKeys=this.attributes.getKeys();
				int[] attributesVValues=this.attributes.getValues();
				for(int attributesKI=attributesKKeys.Length-1;attributesKI>=0;--attributesKI)
				{
					int attributesK=attributesKKeys[attributesKI];
					if(attributesK!=attributesKFreeValue)
					{
						int attributesV=attributesVValues[attributesKI];
						stream.writeInt(attributesK);
						
						stream.writeInt(attributesV);
						
					}
				}
			}
		}
		else
		{
			nullObjError("attributes");
		}
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		this.instanceID=stream.readInt();
		
		this.identity=(UnitIdentityData)stream.readDataSimpleNotNull();
		
		if(stream.readBoolean())
		{
			this.pos=(UnitPosData)stream.readDataSimpleNotNull();
		}
		else
		{
			this.pos=null;
		}
		
		int attributesLen=stream.readLen();
		if(this.attributes!=null)
		{
			this.attributes.clear();
			this.attributes.ensureCapacity(attributesLen);
		}
		else
		{
			this.attributes=new IntIntMap(attributesLen);
		}
		
		IntIntMap attributesT=this.attributes;
		for(int attributesI=attributesLen-1;attributesI>=0;--attributesI)
		{
			int attributesK;
			int attributesV;
			attributesK=stream.readInt();
			
			attributesV=stream.readInt();
			
			attributesT.put(attributesK,attributesV);
		}
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.instanceID);
		
		if(this.identity!=null)
		{
			stream.writeDataSimpleNotNull(this.identity);
		}
		else
		{
			nullObjError("identity");
		}
		
		if(this.pos!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataSimpleNotNull(this.pos);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.attributes!=null)
		{
			stream.writeLen(this.attributes.size());
			if(!this.attributes.isEmpty())
			{
				int attributesKFreeValue=this.attributes.getFreeValue();
				int[] attributesKKeys=this.attributes.getKeys();
				int[] attributesVValues=this.attributes.getValues();
				for(int attributesKI=attributesKKeys.Length-1;attributesKI>=0;--attributesKI)
				{
					int attributesK=attributesKKeys[attributesKI];
					if(attributesK!=attributesKFreeValue)
					{
						int attributesV=attributesVValues[attributesKI];
						stream.writeInt(attributesK);
						
						stream.writeInt(attributesV);
						
					}
				}
			}
		}
		else
		{
			nullObjError("attributes");
		}
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is UnitSimpleData))
			return;
		
		UnitSimpleData mData=(UnitSimpleData)data;
		
		this.instanceID=mData.instanceID;
		this.identity=mData.identity;
		this.pos=mData.pos;
		this.attributes=mData.attributes;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is UnitSimpleData))
			return;
		
		UnitSimpleData mData=(UnitSimpleData)data;
		
		this.instanceID=mData.instanceID;
		
		if(mData.identity!=null)
		{
			this.identity=(UnitIdentityData)mData.identity.clone();
		}
		else
		{
			this.identity=null;
			nullObjError("identity");
		}
		
		if(mData.pos!=null)
		{
			this.pos=(UnitPosData)mData.pos.clone();
		}
		else
		{
			this.pos=null;
		}
		
		if(mData.attributes!=null)
		{
			if(this.attributes!=null)
			{
				this.attributes.clear();
				this.attributes.ensureCapacity(mData.attributes.size());
			}
			else
			{
				this.attributes=new IntIntMap(mData.attributes.size());
			}
			
			IntIntMap attributesT=this.attributes;
			if(!mData.attributes.isEmpty())
			{
				int attributesKFreeValue=mData.attributes.getFreeValue();
				int[] attributesKKeys=mData.attributes.getKeys();
				int[] attributesVValues=mData.attributes.getValues();
				for(int attributesKI=attributesKKeys.Length-1;attributesKI>=0;--attributesKI)
				{
					int attributesK=attributesKKeys[attributesKI];
					if(attributesK!=attributesKFreeValue)
					{
						int attributesV=attributesVValues[attributesKI];
						int attributesW;
						int attributesU;
						attributesW=attributesK;
						
						attributesU=attributesV;
						
						attributesT.put(attributesW,attributesU);
					}
				}
			}
		}
		else
		{
			this.attributes=null;
			nullObjError("attributes");
		}
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		UnitSimpleData mData=(UnitSimpleData)data;
		if(this.instanceID!=mData.instanceID)
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
		
		if(mData.pos!=null)
		{
			if(this.pos==null)
				return false;
			if(!this.pos.dataEquals(mData.pos))
				return false;
		}
		else
		{
			if(this.pos!=null)
				return false;
		}
		
		if(mData.attributes!=null)
		{
			if(this.attributes==null)
				return false;
			if(this.attributes.size()!=mData.attributes.size())
				return false;
			IntIntMap attributesR=mData.attributes;
			if(!this.attributes.isEmpty())
			{
				int attributesKFreeValue=this.attributes.getFreeValue();
				int[] attributesKKeys=this.attributes.getKeys();
				int[] attributesVValues=this.attributes.getValues();
				for(int attributesKI=attributesKKeys.Length-1;attributesKI>=0;--attributesKI)
				{
					int attributesK=attributesKKeys[attributesKI];
					if(attributesK!=attributesKFreeValue)
					{
						int attributesV=attributesVValues[attributesKI];
						int attributesU=attributesR.get(attributesK);
						if(attributesV!=attributesU)
							return false;
						
					}
				}
			}
		}
		else
		{
			if(this.attributes!=null)
				return false;
		}
		
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
		writer.sb.Append("identity");
		writer.sb.Append(':');
		if(this.identity!=null)
		{
			this.identity.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("UnitIdentityData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("pos");
		writer.sb.Append(':');
		if(this.pos!=null)
		{
			this.pos.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("UnitPosData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("attributes");
		writer.sb.Append(':');
		writer.sb.Append("Map<int,int>");
		if(this.attributes!=null)
		{
			writer.sb.Append('(');
			writer.sb.Append(this.attributes.size());
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.attributes.isEmpty())
			{
				int attributesKFreeValue=this.attributes.getFreeValue();
				int[] attributesKKeys=this.attributes.getKeys();
				int[] attributesVValues=this.attributes.getValues();
				for(int attributesKI=attributesKKeys.Length-1;attributesKI>=0;--attributesKI)
				{
					int attributesK=attributesKKeys[attributesKI];
					if(attributesK!=attributesKFreeValue)
					{
						int attributesV=attributesVValues[attributesKI];
						writer.writeTabs();
						writer.sb.Append(attributesK);
						
						writer.sb.Append(':');
						writer.sb.Append(attributesV);
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.Append("=null");
		}
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		this.identity=new UnitIdentityData();
		this.identity.initDefault();
		this.attributes=new IntIntMap();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		this.instanceID=0;
		this.identity=null;
		this.pos=null;
		this.attributes=null;
	}
	
}