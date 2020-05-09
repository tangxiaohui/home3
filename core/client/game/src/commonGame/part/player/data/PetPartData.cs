using ShineEngine;

/// <summary>
/// 宠物(generated by shine)
/// </summary>
public class PetPartData:BaseData
{
	/// <summary>
	/// 宠物字典
	/// </summary>
	public IntObjectMap<PetUseData> petDic;
	
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=PlayerPartDataType.Pet;
	
	public PetPartData()
	{
		_dataID=PlayerPartDataType.Pet;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "PetPartData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		int petDicLen=stream.readLen();
		if(this.petDic!=null)
		{
			this.petDic.clear();
			this.petDic.ensureCapacity(petDicLen);
		}
		else
		{
			this.petDic=new IntObjectMap<PetUseData>(petDicLen);
		}
		
		IntObjectMap<PetUseData> petDicT=this.petDic;
		for(int petDicI=petDicLen-1;petDicI>=0;--petDicI)
		{
			PetUseData petDicV;
			BaseData petDicVT=stream.readDataFullNotNull();
			if(petDicVT!=null)
			{
				if(petDicVT is PetUseData)
				{
					petDicV=(PetUseData)petDicVT;
				}
				else
				{
					petDicV=new PetUseData();
					if(!(petDicVT.GetType().IsAssignableFrom(typeof(PetUseData))))
					{
						stream.throwTypeReadError(typeof(PetUseData),petDicVT.GetType());
					}
					petDicV.shadowCopy(petDicVT);
				}
			}
			else
			{
				petDicV=null;
			}
			
			petDicT.put(petDicV.mIndex,petDicV);
		}
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.petDic!=null)
		{
			stream.writeLen(this.petDic.size());
			if(!this.petDic.isEmpty())
			{
				PetUseData[] petDicVValues=this.petDic.getValues();
				for(int petDicVI=petDicVValues.Length-1;petDicVI>=0;--petDicVI)
				{
					PetUseData petDicV=petDicVValues[petDicVI];
					if(petDicV!=null)
					{
						if(petDicV!=null)
						{
							stream.writeDataFullNotNull(petDicV);
						}
						else
						{
							nullObjError("petDicV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("petDic");
		}
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		int petDicLen=stream.readLen();
		if(this.petDic!=null)
		{
			this.petDic.clear();
			this.petDic.ensureCapacity(petDicLen);
		}
		else
		{
			this.petDic=new IntObjectMap<PetUseData>(petDicLen);
		}
		
		IntObjectMap<PetUseData> petDicT=this.petDic;
		for(int petDicI=petDicLen-1;petDicI>=0;--petDicI)
		{
			PetUseData petDicV;
			petDicV=(PetUseData)stream.readDataSimpleNotNull();
			
			petDicT.put(petDicV.mIndex,petDicV);
		}
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.petDic!=null)
		{
			stream.writeLen(this.petDic.size());
			if(!this.petDic.isEmpty())
			{
				PetUseData[] petDicVValues=this.petDic.getValues();
				for(int petDicVI=petDicVValues.Length-1;petDicVI>=0;--petDicVI)
				{
					PetUseData petDicV=petDicVValues[petDicVI];
					if(petDicV!=null)
					{
						if(petDicV!=null)
						{
							stream.writeDataSimpleNotNull(petDicV);
						}
						else
						{
							nullObjError("petDicV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("petDic");
		}
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is PetPartData))
			return;
		
		PetPartData mData=(PetPartData)data;
		
		this.petDic=mData.petDic;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is PetPartData))
			return;
		
		PetPartData mData=(PetPartData)data;
		
		if(mData.petDic!=null)
		{
			if(this.petDic!=null)
			{
				this.petDic.clear();
				this.petDic.ensureCapacity(mData.petDic.size());
			}
			else
			{
				this.petDic=new IntObjectMap<PetUseData>(mData.petDic.size());
			}
			
			IntObjectMap<PetUseData> petDicT=this.petDic;
			if(!mData.petDic.isEmpty())
			{
				PetUseData[] petDicVValues=mData.petDic.getValues();
				for(int petDicVI=petDicVValues.Length-1;petDicVI>=0;--petDicVI)
				{
					PetUseData petDicV=petDicVValues[petDicVI];
					if(petDicV!=null)
					{
						PetUseData petDicU;
						if(petDicV!=null)
						{
							petDicU=(PetUseData)petDicV.clone();
						}
						else
						{
							petDicU=null;
							nullObjError("petDicU");
						}
						
						petDicT.put(petDicU.mIndex,petDicU);
					}
				}
			}
		}
		else
		{
			this.petDic=null;
			nullObjError("petDic");
		}
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		PetPartData mData=(PetPartData)data;
		if(mData.petDic!=null)
		{
			if(this.petDic==null)
				return false;
			if(this.petDic.size()!=mData.petDic.size())
				return false;
			IntObjectMap<PetUseData> petDicR=mData.petDic;
			if(!this.petDic.isEmpty())
			{
				int petDicKFreeValue=this.petDic.getFreeValue();
				int[] petDicKKeys=this.petDic.getKeys();
				PetUseData[] petDicVValues=this.petDic.getValues();
				for(int petDicKI=petDicKKeys.Length-1;petDicKI>=0;--petDicKI)
				{
					int petDicK=petDicKKeys[petDicKI];
					if(petDicK!=petDicKFreeValue)
					{
						PetUseData petDicV=petDicVValues[petDicKI];
						PetUseData petDicU=petDicR.get(petDicK);
						if(petDicU!=null)
						{
							if(petDicV==null)
								return false;
							if(!petDicV.dataEquals(petDicU))
								return false;
						}
						else
						{
							if(petDicV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.petDic!=null)
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
		writer.sb.Append("petDic");
		writer.sb.Append(':');
		writer.sb.Append("Map<int,PetUseData>");
		if(this.petDic!=null)
		{
			writer.sb.Append('(');
			writer.sb.Append(this.petDic.size());
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.petDic.isEmpty())
			{
				int petDicKFreeValue=this.petDic.getFreeValue();
				int[] petDicKKeys=this.petDic.getKeys();
				PetUseData[] petDicVValues=this.petDic.getValues();
				for(int petDicKI=petDicKKeys.Length-1;petDicKI>=0;--petDicKI)
				{
					int petDicK=petDicKKeys[petDicKI];
					if(petDicK!=petDicKFreeValue)
					{
						PetUseData petDicV=petDicVValues[petDicKI];
						writer.writeTabs();
						writer.sb.Append(petDicK);
						
						writer.sb.Append(':');
						if(petDicV!=null)
						{
							petDicV.writeDataString(writer);
						}
						else
						{
							writer.sb.Append("PetUseData=null");
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
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		this.petDic=new IntObjectMap<PetUseData>();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		this.petDic=null;
	}
	
}