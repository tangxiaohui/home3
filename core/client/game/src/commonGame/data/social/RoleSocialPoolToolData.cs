using ShineEngine;

/// <summary>
/// 角色社交数据池工具数据(generated by shine)
/// </summary>
public class RoleSocialPoolToolData:FuncToolData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.RoleSocialPoolTool;
	
	/// <summary>
	/// 下次裁剪
	/// </summary>
	public long nextCutTime;
	
	/// <summary>
	/// 数据
	/// </summary>
	public LongObjectMap<RoleSocialPoolData> dic;
	
	public RoleSocialPoolToolData()
	{
		_dataID=BaseDataType.RoleSocialPoolTool;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "RoleSocialPoolToolData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		int dicLen=stream.readLen();
		if(this.dic!=null)
		{
			this.dic.clear();
			this.dic.ensureCapacity(dicLen);
		}
		else
		{
			this.dic=new LongObjectMap<RoleSocialPoolData>(dicLen);
		}
		
		LongObjectMap<RoleSocialPoolData> dicT=this.dic;
		for(int dicI=dicLen-1;dicI>=0;--dicI)
		{
			long dicK;
			RoleSocialPoolData dicV;
			dicK=stream.readLong();
			
			BaseData dicVT=stream.readDataFullNotNull();
			if(dicVT!=null)
			{
				if(dicVT is RoleSocialPoolData)
				{
					dicV=(RoleSocialPoolData)dicVT;
				}
				else
				{
					dicV=new RoleSocialPoolData();
					if(!(dicVT.GetType().IsAssignableFrom(typeof(RoleSocialPoolData))))
					{
						stream.throwTypeReadError(typeof(RoleSocialPoolData),dicVT.GetType());
					}
					dicV.shadowCopy(dicVT);
				}
			}
			else
			{
				dicV=null;
			}
			
			dicT.put(dicK,dicV);
		}
		
		this.nextCutTime=stream.readLong();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.dic!=null)
		{
			stream.writeLen(this.dic.size());
			if(!this.dic.isEmpty())
			{
				long dicKFreeValue=this.dic.getFreeValue();
				long[] dicKKeys=this.dic.getKeys();
				RoleSocialPoolData[] dicVValues=this.dic.getValues();
				for(int dicKI=dicKKeys.Length-1;dicKI>=0;--dicKI)
				{
					long dicK=dicKKeys[dicKI];
					if(dicK!=dicKFreeValue)
					{
						RoleSocialPoolData dicV=dicVValues[dicKI];
						stream.writeLong(dicK);
						
						if(dicV!=null)
						{
							stream.writeDataFullNotNull(dicV);
						}
						else
						{
							nullObjError("dicV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("dic");
		}
		
		stream.writeLong(this.nextCutTime);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		int dicLen=stream.readLen();
		if(this.dic!=null)
		{
			this.dic.clear();
			this.dic.ensureCapacity(dicLen);
		}
		else
		{
			this.dic=new LongObjectMap<RoleSocialPoolData>(dicLen);
		}
		
		LongObjectMap<RoleSocialPoolData> dicT=this.dic;
		for(int dicI=dicLen-1;dicI>=0;--dicI)
		{
			long dicK;
			RoleSocialPoolData dicV;
			dicK=stream.readLong();
			
			dicV=(RoleSocialPoolData)stream.readDataSimpleNotNull();
			
			dicT.put(dicK,dicV);
		}
		
		this.nextCutTime=stream.readLong();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		if(this.dic!=null)
		{
			stream.writeLen(this.dic.size());
			if(!this.dic.isEmpty())
			{
				long dicKFreeValue=this.dic.getFreeValue();
				long[] dicKKeys=this.dic.getKeys();
				RoleSocialPoolData[] dicVValues=this.dic.getValues();
				for(int dicKI=dicKKeys.Length-1;dicKI>=0;--dicKI)
				{
					long dicK=dicKKeys[dicKI];
					if(dicK!=dicKFreeValue)
					{
						RoleSocialPoolData dicV=dicVValues[dicKI];
						stream.writeLong(dicK);
						
						if(dicV!=null)
						{
							stream.writeDataSimpleNotNull(dicV);
						}
						else
						{
							nullObjError("dicV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("dic");
		}
		
		stream.writeLong(this.nextCutTime);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		base.toShadowCopy(data);
		
		if(!(data is RoleSocialPoolToolData))
			return;
		
		RoleSocialPoolToolData mData=(RoleSocialPoolToolData)data;
		
		this.dic=mData.dic;
		this.nextCutTime=mData.nextCutTime;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		base.toCopy(data);
		
		if(!(data is RoleSocialPoolToolData))
			return;
		
		RoleSocialPoolToolData mData=(RoleSocialPoolToolData)data;
		
		if(mData.dic!=null)
		{
			if(this.dic!=null)
			{
				this.dic.clear();
				this.dic.ensureCapacity(mData.dic.size());
			}
			else
			{
				this.dic=new LongObjectMap<RoleSocialPoolData>(mData.dic.size());
			}
			
			LongObjectMap<RoleSocialPoolData> dicT=this.dic;
			if(!mData.dic.isEmpty())
			{
				long dicKFreeValue=mData.dic.getFreeValue();
				long[] dicKKeys=mData.dic.getKeys();
				RoleSocialPoolData[] dicVValues=mData.dic.getValues();
				for(int dicKI=dicKKeys.Length-1;dicKI>=0;--dicKI)
				{
					long dicK=dicKKeys[dicKI];
					if(dicK!=dicKFreeValue)
					{
						RoleSocialPoolData dicV=dicVValues[dicKI];
						long dicW;
						RoleSocialPoolData dicU;
						dicW=dicK;
						
						if(dicV!=null)
						{
							dicU=(RoleSocialPoolData)dicV.clone();
						}
						else
						{
							dicU=null;
							nullObjError("dicU");
						}
						
						dicT.put(dicW,dicU);
					}
				}
			}
		}
		else
		{
			this.dic=null;
			nullObjError("dic");
		}
		
		this.nextCutTime=mData.nextCutTime;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		if(!base.toDataEquals(data))
			return false;
		
		RoleSocialPoolToolData mData=(RoleSocialPoolToolData)data;
		if(mData.dic!=null)
		{
			if(this.dic==null)
				return false;
			if(this.dic.size()!=mData.dic.size())
				return false;
			LongObjectMap<RoleSocialPoolData> dicR=mData.dic;
			if(!this.dic.isEmpty())
			{
				long dicKFreeValue=this.dic.getFreeValue();
				long[] dicKKeys=this.dic.getKeys();
				RoleSocialPoolData[] dicVValues=this.dic.getValues();
				for(int dicKI=dicKKeys.Length-1;dicKI>=0;--dicKI)
				{
					long dicK=dicKKeys[dicKI];
					if(dicK!=dicKFreeValue)
					{
						RoleSocialPoolData dicV=dicVValues[dicKI];
						RoleSocialPoolData dicU=dicR.get(dicK);
						if(dicU!=null)
						{
							if(dicV==null)
								return false;
							if(!dicV.dataEquals(dicU))
								return false;
						}
						else
						{
							if(dicV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.dic!=null)
				return false;
		}
		
		if(this.nextCutTime!=mData.nextCutTime)
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
		writer.sb.Append("dic");
		writer.sb.Append(':');
		writer.sb.Append("Map<long,RoleSocialPoolData>");
		if(this.dic!=null)
		{
			writer.sb.Append('(');
			writer.sb.Append(this.dic.size());
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.dic.isEmpty())
			{
				long dicKFreeValue=this.dic.getFreeValue();
				long[] dicKKeys=this.dic.getKeys();
				RoleSocialPoolData[] dicVValues=this.dic.getValues();
				for(int dicKI=dicKKeys.Length-1;dicKI>=0;--dicKI)
				{
					long dicK=dicKKeys[dicKI];
					if(dicK!=dicKFreeValue)
					{
						RoleSocialPoolData dicV=dicVValues[dicKI];
						writer.writeTabs();
						writer.sb.Append(dicK);
						
						writer.sb.Append(':');
						if(dicV!=null)
						{
							dicV.writeDataString(writer);
						}
						else
						{
							writer.sb.Append("RoleSocialPoolData=null");
						}
						
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
		writer.writeTabs();
		writer.sb.Append("nextCutTime");
		writer.sb.Append(':');
		writer.sb.Append(this.nextCutTime);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		base.initDefault();
		
		this.dic=new LongObjectMap<RoleSocialPoolData>();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.dic=null;
		this.nextCutTime=0L;
	}
	
}
