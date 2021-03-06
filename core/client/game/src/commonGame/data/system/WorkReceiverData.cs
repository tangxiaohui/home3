using ShineEngine;

/// <summary>
/// 事务接收者数据(generated by shine)
/// </summary>
public class WorkReceiverData:BaseData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.WorkReceiver;
	
	/// <summary>
	/// 事务执行记录(key:发起者序号->key:instanceID,value:时间戳)
	/// </summary>
	public IntObjectMap<LongLongMap> workExecuteRecordDic;
	
	public WorkReceiverData()
	{
		_dataID=BaseDataType.WorkReceiver;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "WorkReceiverData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		int workExecuteRecordDicLen=stream.readLen();
		if(this.workExecuteRecordDic!=null)
		{
			this.workExecuteRecordDic.clear();
			this.workExecuteRecordDic.ensureCapacity(workExecuteRecordDicLen);
		}
		else
		{
			this.workExecuteRecordDic=new IntObjectMap<LongLongMap>(workExecuteRecordDicLen);
		}
		
		IntObjectMap<LongLongMap> workExecuteRecordDicT=this.workExecuteRecordDic;
		for(int workExecuteRecordDicI=workExecuteRecordDicLen-1;workExecuteRecordDicI>=0;--workExecuteRecordDicI)
		{
			int workExecuteRecordDicK;
			LongLongMap workExecuteRecordDicV;
			workExecuteRecordDicK=stream.readInt();
			
			int workExecuteRecordDicVLen=stream.readLen();
			workExecuteRecordDicV=new LongLongMap(workExecuteRecordDicVLen);
			LongLongMap workExecuteRecordDicVT=workExecuteRecordDicV;
			for(int workExecuteRecordDicVI=workExecuteRecordDicVLen-1;workExecuteRecordDicVI>=0;--workExecuteRecordDicVI)
			{
				long workExecuteRecordDicVK;
				long workExecuteRecordDicVV;
				workExecuteRecordDicVK=stream.readLong();
				
				workExecuteRecordDicVV=stream.readLong();
				
				workExecuteRecordDicVT.put(workExecuteRecordDicVK,workExecuteRecordDicVV);
			}
			
			workExecuteRecordDicT.put(workExecuteRecordDicK,workExecuteRecordDicV);
		}
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.workExecuteRecordDic!=null)
		{
			stream.writeLen(this.workExecuteRecordDic.size());
			if(!this.workExecuteRecordDic.isEmpty())
			{
				int workExecuteRecordDicKFreeValue=this.workExecuteRecordDic.getFreeValue();
				int[] workExecuteRecordDicKKeys=this.workExecuteRecordDic.getKeys();
				LongLongMap[] workExecuteRecordDicVValues=this.workExecuteRecordDic.getValues();
				for(int workExecuteRecordDicKI=workExecuteRecordDicKKeys.Length-1;workExecuteRecordDicKI>=0;--workExecuteRecordDicKI)
				{
					int workExecuteRecordDicK=workExecuteRecordDicKKeys[workExecuteRecordDicKI];
					if(workExecuteRecordDicK!=workExecuteRecordDicKFreeValue)
					{
						LongLongMap workExecuteRecordDicV=workExecuteRecordDicVValues[workExecuteRecordDicKI];
						stream.writeInt(workExecuteRecordDicK);
						
						if(workExecuteRecordDicV!=null)
						{
							stream.writeLen(workExecuteRecordDicV.size());
							if(!workExecuteRecordDicV.isEmpty())
							{
								long workExecuteRecordDicVKFreeValue=workExecuteRecordDicV.getFreeValue();
								long[] workExecuteRecordDicVKKeys=workExecuteRecordDicV.getKeys();
								long[] workExecuteRecordDicVVValues=workExecuteRecordDicV.getValues();
								for(int workExecuteRecordDicVKI=workExecuteRecordDicVKKeys.Length-1;workExecuteRecordDicVKI>=0;--workExecuteRecordDicVKI)
								{
									long workExecuteRecordDicVK=workExecuteRecordDicVKKeys[workExecuteRecordDicVKI];
									if(workExecuteRecordDicVK!=workExecuteRecordDicVKFreeValue)
									{
										long workExecuteRecordDicVV=workExecuteRecordDicVVValues[workExecuteRecordDicVKI];
										stream.writeLong(workExecuteRecordDicVK);
										
										stream.writeLong(workExecuteRecordDicVV);
										
									}
								}
							}
						}
						else
						{
							nullObjError("workExecuteRecordDicV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("workExecuteRecordDic");
		}
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		int workExecuteRecordDicLen=stream.readLen();
		if(this.workExecuteRecordDic!=null)
		{
			this.workExecuteRecordDic.clear();
			this.workExecuteRecordDic.ensureCapacity(workExecuteRecordDicLen);
		}
		else
		{
			this.workExecuteRecordDic=new IntObjectMap<LongLongMap>(workExecuteRecordDicLen);
		}
		
		IntObjectMap<LongLongMap> workExecuteRecordDicT=this.workExecuteRecordDic;
		for(int workExecuteRecordDicI=workExecuteRecordDicLen-1;workExecuteRecordDicI>=0;--workExecuteRecordDicI)
		{
			int workExecuteRecordDicK;
			LongLongMap workExecuteRecordDicV;
			workExecuteRecordDicK=stream.readInt();
			
			int workExecuteRecordDicVLen=stream.readLen();
			workExecuteRecordDicV=new LongLongMap(workExecuteRecordDicVLen);
			LongLongMap workExecuteRecordDicVT=workExecuteRecordDicV;
			for(int workExecuteRecordDicVI=workExecuteRecordDicVLen-1;workExecuteRecordDicVI>=0;--workExecuteRecordDicVI)
			{
				long workExecuteRecordDicVK;
				long workExecuteRecordDicVV;
				workExecuteRecordDicVK=stream.readLong();
				
				workExecuteRecordDicVV=stream.readLong();
				
				workExecuteRecordDicVT.put(workExecuteRecordDicVK,workExecuteRecordDicVV);
			}
			
			workExecuteRecordDicT.put(workExecuteRecordDicK,workExecuteRecordDicV);
		}
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.workExecuteRecordDic!=null)
		{
			stream.writeLen(this.workExecuteRecordDic.size());
			if(!this.workExecuteRecordDic.isEmpty())
			{
				int workExecuteRecordDicKFreeValue=this.workExecuteRecordDic.getFreeValue();
				int[] workExecuteRecordDicKKeys=this.workExecuteRecordDic.getKeys();
				LongLongMap[] workExecuteRecordDicVValues=this.workExecuteRecordDic.getValues();
				for(int workExecuteRecordDicKI=workExecuteRecordDicKKeys.Length-1;workExecuteRecordDicKI>=0;--workExecuteRecordDicKI)
				{
					int workExecuteRecordDicK=workExecuteRecordDicKKeys[workExecuteRecordDicKI];
					if(workExecuteRecordDicK!=workExecuteRecordDicKFreeValue)
					{
						LongLongMap workExecuteRecordDicV=workExecuteRecordDicVValues[workExecuteRecordDicKI];
						stream.writeInt(workExecuteRecordDicK);
						
						if(workExecuteRecordDicV!=null)
						{
							stream.writeLen(workExecuteRecordDicV.size());
							if(!workExecuteRecordDicV.isEmpty())
							{
								long workExecuteRecordDicVKFreeValue=workExecuteRecordDicV.getFreeValue();
								long[] workExecuteRecordDicVKKeys=workExecuteRecordDicV.getKeys();
								long[] workExecuteRecordDicVVValues=workExecuteRecordDicV.getValues();
								for(int workExecuteRecordDicVKI=workExecuteRecordDicVKKeys.Length-1;workExecuteRecordDicVKI>=0;--workExecuteRecordDicVKI)
								{
									long workExecuteRecordDicVK=workExecuteRecordDicVKKeys[workExecuteRecordDicVKI];
									if(workExecuteRecordDicVK!=workExecuteRecordDicVKFreeValue)
									{
										long workExecuteRecordDicVV=workExecuteRecordDicVVValues[workExecuteRecordDicVKI];
										stream.writeLong(workExecuteRecordDicVK);
										
										stream.writeLong(workExecuteRecordDicVV);
										
									}
								}
							}
						}
						else
						{
							nullObjError("workExecuteRecordDicV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("workExecuteRecordDic");
		}
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is WorkReceiverData))
			return;
		
		WorkReceiverData mData=(WorkReceiverData)data;
		
		this.workExecuteRecordDic=mData.workExecuteRecordDic;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is WorkReceiverData))
			return;
		
		WorkReceiverData mData=(WorkReceiverData)data;
		
		if(mData.workExecuteRecordDic!=null)
		{
			if(this.workExecuteRecordDic!=null)
			{
				this.workExecuteRecordDic.clear();
				this.workExecuteRecordDic.ensureCapacity(mData.workExecuteRecordDic.size());
			}
			else
			{
				this.workExecuteRecordDic=new IntObjectMap<LongLongMap>(mData.workExecuteRecordDic.size());
			}
			
			IntObjectMap<LongLongMap> workExecuteRecordDicT=this.workExecuteRecordDic;
			if(!mData.workExecuteRecordDic.isEmpty())
			{
				int workExecuteRecordDicKFreeValue=mData.workExecuteRecordDic.getFreeValue();
				int[] workExecuteRecordDicKKeys=mData.workExecuteRecordDic.getKeys();
				LongLongMap[] workExecuteRecordDicVValues=mData.workExecuteRecordDic.getValues();
				for(int workExecuteRecordDicKI=workExecuteRecordDicKKeys.Length-1;workExecuteRecordDicKI>=0;--workExecuteRecordDicKI)
				{
					int workExecuteRecordDicK=workExecuteRecordDicKKeys[workExecuteRecordDicKI];
					if(workExecuteRecordDicK!=workExecuteRecordDicKFreeValue)
					{
						LongLongMap workExecuteRecordDicV=workExecuteRecordDicVValues[workExecuteRecordDicKI];
						int workExecuteRecordDicW;
						LongLongMap workExecuteRecordDicU;
						workExecuteRecordDicW=workExecuteRecordDicK;
						
						if(workExecuteRecordDicV!=null)
						{
							workExecuteRecordDicU=new LongLongMap(workExecuteRecordDicV.size());
							LongLongMap workExecuteRecordDicUT=workExecuteRecordDicU;
							if(!workExecuteRecordDicV.isEmpty())
							{
								long workExecuteRecordDicUKFreeValue=workExecuteRecordDicV.getFreeValue();
								long[] workExecuteRecordDicUKKeys=workExecuteRecordDicV.getKeys();
								long[] workExecuteRecordDicUVValues=workExecuteRecordDicV.getValues();
								for(int workExecuteRecordDicUKI=workExecuteRecordDicUKKeys.Length-1;workExecuteRecordDicUKI>=0;--workExecuteRecordDicUKI)
								{
									long workExecuteRecordDicUK=workExecuteRecordDicUKKeys[workExecuteRecordDicUKI];
									if(workExecuteRecordDicUK!=workExecuteRecordDicUKFreeValue)
									{
										long workExecuteRecordDicUV=workExecuteRecordDicUVValues[workExecuteRecordDicUKI];
										long workExecuteRecordDicUW;
										long workExecuteRecordDicUU;
										workExecuteRecordDicUW=workExecuteRecordDicUK;
										
										workExecuteRecordDicUU=workExecuteRecordDicUV;
										
										workExecuteRecordDicUT.put(workExecuteRecordDicUW,workExecuteRecordDicUU);
									}
								}
							}
						}
						else
						{
							workExecuteRecordDicU=null;
							nullObjError("workExecuteRecordDicU");
						}
						
						workExecuteRecordDicT.put(workExecuteRecordDicW,workExecuteRecordDicU);
					}
				}
			}
		}
		else
		{
			this.workExecuteRecordDic=null;
			nullObjError("workExecuteRecordDic");
		}
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		WorkReceiverData mData=(WorkReceiverData)data;
		if(mData.workExecuteRecordDic!=null)
		{
			if(this.workExecuteRecordDic==null)
				return false;
			if(this.workExecuteRecordDic.size()!=mData.workExecuteRecordDic.size())
				return false;
			IntObjectMap<LongLongMap> workExecuteRecordDicR=mData.workExecuteRecordDic;
			if(!this.workExecuteRecordDic.isEmpty())
			{
				int workExecuteRecordDicKFreeValue=this.workExecuteRecordDic.getFreeValue();
				int[] workExecuteRecordDicKKeys=this.workExecuteRecordDic.getKeys();
				LongLongMap[] workExecuteRecordDicVValues=this.workExecuteRecordDic.getValues();
				for(int workExecuteRecordDicKI=workExecuteRecordDicKKeys.Length-1;workExecuteRecordDicKI>=0;--workExecuteRecordDicKI)
				{
					int workExecuteRecordDicK=workExecuteRecordDicKKeys[workExecuteRecordDicKI];
					if(workExecuteRecordDicK!=workExecuteRecordDicKFreeValue)
					{
						LongLongMap workExecuteRecordDicV=workExecuteRecordDicVValues[workExecuteRecordDicKI];
						LongLongMap workExecuteRecordDicU=workExecuteRecordDicR.get(workExecuteRecordDicK);
						if(workExecuteRecordDicU!=null)
						{
							if(workExecuteRecordDicV==null)
								return false;
							if(workExecuteRecordDicV.size()!=workExecuteRecordDicU.size())
								return false;
							LongLongMap workExecuteRecordDicVR=workExecuteRecordDicU;
							if(!workExecuteRecordDicV.isEmpty())
							{
								long workExecuteRecordDicVKFreeValue=workExecuteRecordDicV.getFreeValue();
								long[] workExecuteRecordDicVKKeys=workExecuteRecordDicV.getKeys();
								long[] workExecuteRecordDicVVValues=workExecuteRecordDicV.getValues();
								for(int workExecuteRecordDicVKI=workExecuteRecordDicVKKeys.Length-1;workExecuteRecordDicVKI>=0;--workExecuteRecordDicVKI)
								{
									long workExecuteRecordDicVK=workExecuteRecordDicVKKeys[workExecuteRecordDicVKI];
									if(workExecuteRecordDicVK!=workExecuteRecordDicVKFreeValue)
									{
										long workExecuteRecordDicVV=workExecuteRecordDicVVValues[workExecuteRecordDicVKI];
										long workExecuteRecordDicVU=workExecuteRecordDicVR.get(workExecuteRecordDicVK);
										if(workExecuteRecordDicVV!=workExecuteRecordDicVU)
											return false;
										
									}
								}
							}
						}
						else
						{
							if(workExecuteRecordDicV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.workExecuteRecordDic!=null)
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
		writer.sb.Append("workExecuteRecordDic");
		writer.sb.Append(':');
		writer.sb.Append("Map<int,LongLongMap>");
		if(this.workExecuteRecordDic!=null)
		{
			writer.sb.Append('(');
			writer.sb.Append(this.workExecuteRecordDic.size());
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.workExecuteRecordDic.isEmpty())
			{
				int workExecuteRecordDicKFreeValue=this.workExecuteRecordDic.getFreeValue();
				int[] workExecuteRecordDicKKeys=this.workExecuteRecordDic.getKeys();
				LongLongMap[] workExecuteRecordDicVValues=this.workExecuteRecordDic.getValues();
				for(int workExecuteRecordDicKI=workExecuteRecordDicKKeys.Length-1;workExecuteRecordDicKI>=0;--workExecuteRecordDicKI)
				{
					int workExecuteRecordDicK=workExecuteRecordDicKKeys[workExecuteRecordDicKI];
					if(workExecuteRecordDicK!=workExecuteRecordDicKFreeValue)
					{
						LongLongMap workExecuteRecordDicV=workExecuteRecordDicVValues[workExecuteRecordDicKI];
						writer.writeTabs();
						writer.sb.Append(workExecuteRecordDicK);
						
						writer.sb.Append(':');
						writer.sb.Append("Map<long,long>");
						if(workExecuteRecordDicV!=null)
						{
							writer.sb.Append('(');
							writer.sb.Append(workExecuteRecordDicV.size());
							writer.sb.Append(')');
							writer.writeEnter();
							writer.writeLeftBrace();
							if(!workExecuteRecordDicV.isEmpty())
							{
								long workExecuteRecordDicVKFreeValue=workExecuteRecordDicV.getFreeValue();
								long[] workExecuteRecordDicVKKeys=workExecuteRecordDicV.getKeys();
								long[] workExecuteRecordDicVVValues=workExecuteRecordDicV.getValues();
								for(int workExecuteRecordDicVKI=workExecuteRecordDicVKKeys.Length-1;workExecuteRecordDicVKI>=0;--workExecuteRecordDicVKI)
								{
									long workExecuteRecordDicVK=workExecuteRecordDicVKKeys[workExecuteRecordDicVKI];
									if(workExecuteRecordDicVK!=workExecuteRecordDicVKFreeValue)
									{
										long workExecuteRecordDicVV=workExecuteRecordDicVVValues[workExecuteRecordDicVKI];
										writer.writeTabs();
										writer.sb.Append(workExecuteRecordDicVK);
										
										writer.sb.Append(':');
										writer.sb.Append(workExecuteRecordDicVV);
										
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
		this.workExecuteRecordDic=new IntObjectMap<LongLongMap>();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		this.workExecuteRecordDic=null;
	}
	
}
