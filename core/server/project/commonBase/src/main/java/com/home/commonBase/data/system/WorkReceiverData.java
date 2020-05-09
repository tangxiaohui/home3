package com.home.commonBase.data.system;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.IntLongMap;
import com.home.shine.support.collection.IntObjectMap;
import com.home.shine.support.collection.LongList;
import com.home.shine.support.collection.LongLongMap;
import com.home.shine.support.pool.DataPool;

/** 事务接收者数据(generated by shine) */
public class WorkReceiverData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.WorkReceiver;
	
	/** 事务执行记录(key:发起者序号->key:instanceID,value:时间戳) */
	public IntObjectMap<LongLongMap> workExecuteRecordDic;
	
	public WorkReceiverData()
	{
		_dataID=BaseDataType.WorkReceiver;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "WorkReceiverData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
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
			this.workExecuteRecordDic=new IntObjectMap<LongLongMap>(LongLongMap[]::new,workExecuteRecordDicLen);
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
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.workExecuteRecordDic!=null)
		{
			stream.writeLen(this.workExecuteRecordDic.size());
			if(!this.workExecuteRecordDic.isEmpty())
			{
				int workExecuteRecordDicKFreeValue=this.workExecuteRecordDic.getFreeValue();
				int[] workExecuteRecordDicKKeys=this.workExecuteRecordDic.getKeys();
				Object[] workExecuteRecordDicVValues=this.workExecuteRecordDic.getValues();
				for(int workExecuteRecordDicKI=workExecuteRecordDicKKeys.length-1;workExecuteRecordDicKI>=0;--workExecuteRecordDicKI)
				{
					int workExecuteRecordDicK=workExecuteRecordDicKKeys[workExecuteRecordDicKI];
					if(workExecuteRecordDicK!=workExecuteRecordDicKFreeValue)
					{
						LongLongMap workExecuteRecordDicV=(LongLongMap)workExecuteRecordDicVValues[workExecuteRecordDicKI];
						stream.writeInt(workExecuteRecordDicK);
						
						if(workExecuteRecordDicV!=null)
						{
							stream.writeLen(workExecuteRecordDicV.size());
							if(!workExecuteRecordDicV.isEmpty())
							{
								long workExecuteRecordDicVKFreeValue=workExecuteRecordDicV.getFreeValue();
								long[] workExecuteRecordDicVKKeys=workExecuteRecordDicV.getKeys();
								long[] workExecuteRecordDicVVValues=workExecuteRecordDicV.getValues();
								for(int workExecuteRecordDicVKI=workExecuteRecordDicVKKeys.length-1;workExecuteRecordDicVKI>=0;--workExecuteRecordDicVKI)
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
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		int workExecuteRecordDicLen=stream.readLen();
		if(this.workExecuteRecordDic!=null)
		{
			this.workExecuteRecordDic.clear();
			this.workExecuteRecordDic.ensureCapacity(workExecuteRecordDicLen);
		}
		else
		{
			this.workExecuteRecordDic=new IntObjectMap<LongLongMap>(LongLongMap[]::new,workExecuteRecordDicLen);
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
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.workExecuteRecordDic!=null)
		{
			stream.writeLen(this.workExecuteRecordDic.size());
			if(!this.workExecuteRecordDic.isEmpty())
			{
				int workExecuteRecordDicKFreeValue=this.workExecuteRecordDic.getFreeValue();
				int[] workExecuteRecordDicKKeys=this.workExecuteRecordDic.getKeys();
				Object[] workExecuteRecordDicVValues=this.workExecuteRecordDic.getValues();
				for(int workExecuteRecordDicKI=workExecuteRecordDicKKeys.length-1;workExecuteRecordDicKI>=0;--workExecuteRecordDicKI)
				{
					int workExecuteRecordDicK=workExecuteRecordDicKKeys[workExecuteRecordDicKI];
					if(workExecuteRecordDicK!=workExecuteRecordDicKFreeValue)
					{
						LongLongMap workExecuteRecordDicV=(LongLongMap)workExecuteRecordDicVValues[workExecuteRecordDicKI];
						stream.writeInt(workExecuteRecordDicK);
						
						if(workExecuteRecordDicV!=null)
						{
							stream.writeLen(workExecuteRecordDicV.size());
							if(!workExecuteRecordDicV.isEmpty())
							{
								long workExecuteRecordDicVKFreeValue=workExecuteRecordDicV.getFreeValue();
								long[] workExecuteRecordDicVKKeys=workExecuteRecordDicV.getKeys();
								long[] workExecuteRecordDicVVValues=workExecuteRecordDicV.getValues();
								for(int workExecuteRecordDicVKI=workExecuteRecordDicVKKeys.length-1;workExecuteRecordDicVKI>=0;--workExecuteRecordDicVKI)
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
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof WorkReceiverData))
			return;
		
		WorkReceiverData mData=(WorkReceiverData)data;
		
		this.workExecuteRecordDic=mData.workExecuteRecordDic;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof WorkReceiverData))
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
				this.workExecuteRecordDic=new IntObjectMap<LongLongMap>(LongLongMap[]::new,mData.workExecuteRecordDic.size());
			}
			
			IntObjectMap<LongLongMap> workExecuteRecordDicT=this.workExecuteRecordDic;
			if(!mData.workExecuteRecordDic.isEmpty())
			{
				int workExecuteRecordDicKFreeValue=mData.workExecuteRecordDic.getFreeValue();
				int[] workExecuteRecordDicKKeys=mData.workExecuteRecordDic.getKeys();
				Object[] workExecuteRecordDicVValues=mData.workExecuteRecordDic.getValues();
				for(int workExecuteRecordDicKI=workExecuteRecordDicKKeys.length-1;workExecuteRecordDicKI>=0;--workExecuteRecordDicKI)
				{
					int workExecuteRecordDicK=workExecuteRecordDicKKeys[workExecuteRecordDicKI];
					if(workExecuteRecordDicK!=workExecuteRecordDicKFreeValue)
					{
						LongLongMap workExecuteRecordDicV=(LongLongMap)workExecuteRecordDicVValues[workExecuteRecordDicKI];
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
								for(int workExecuteRecordDicUKI=workExecuteRecordDicUKKeys.length-1;workExecuteRecordDicUKI>=0;--workExecuteRecordDicUKI)
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
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
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
				Object[] workExecuteRecordDicVValues=this.workExecuteRecordDic.getValues();
				for(int workExecuteRecordDicKI=workExecuteRecordDicKKeys.length-1;workExecuteRecordDicKI>=0;--workExecuteRecordDicKI)
				{
					int workExecuteRecordDicK=workExecuteRecordDicKKeys[workExecuteRecordDicKI];
					if(workExecuteRecordDicK!=workExecuteRecordDicKFreeValue)
					{
						LongLongMap workExecuteRecordDicV=(LongLongMap)workExecuteRecordDicVValues[workExecuteRecordDicKI];
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
								for(int workExecuteRecordDicVKI=workExecuteRecordDicVKKeys.length-1;workExecuteRecordDicVKI>=0;--workExecuteRecordDicVKI)
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
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("workExecuteRecordDic");
		writer.sb.append(':');
		writer.sb.append("Map<int,LongLongMap>");
		if(this.workExecuteRecordDic!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.workExecuteRecordDic.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.workExecuteRecordDic.isEmpty())
			{
				int workExecuteRecordDicKFreeValue=this.workExecuteRecordDic.getFreeValue();
				int[] workExecuteRecordDicKKeys=this.workExecuteRecordDic.getKeys();
				Object[] workExecuteRecordDicVValues=this.workExecuteRecordDic.getValues();
				for(int workExecuteRecordDicKI=workExecuteRecordDicKKeys.length-1;workExecuteRecordDicKI>=0;--workExecuteRecordDicKI)
				{
					int workExecuteRecordDicK=workExecuteRecordDicKKeys[workExecuteRecordDicKI];
					if(workExecuteRecordDicK!=workExecuteRecordDicKFreeValue)
					{
						LongLongMap workExecuteRecordDicV=(LongLongMap)workExecuteRecordDicVValues[workExecuteRecordDicKI];
						writer.writeTabs();
						writer.sb.append(workExecuteRecordDicK);
						
						writer.sb.append(':');
						writer.sb.append("Map<long,long>");
						if(workExecuteRecordDicV!=null)
						{
							writer.sb.append('(');
							writer.sb.append(workExecuteRecordDicV.size());
							writer.sb.append(')');
							writer.writeEnter();
							writer.writeLeftBrace();
							if(!workExecuteRecordDicV.isEmpty())
							{
								long workExecuteRecordDicVKFreeValue=workExecuteRecordDicV.getFreeValue();
								long[] workExecuteRecordDicVKKeys=workExecuteRecordDicV.getKeys();
								long[] workExecuteRecordDicVVValues=workExecuteRecordDicV.getValues();
								for(int workExecuteRecordDicVKI=workExecuteRecordDicVKKeys.length-1;workExecuteRecordDicVKI>=0;--workExecuteRecordDicVKI)
								{
									long workExecuteRecordDicVK=workExecuteRecordDicVKKeys[workExecuteRecordDicVKI];
									if(workExecuteRecordDicVK!=workExecuteRecordDicVKFreeValue)
									{
										long workExecuteRecordDicVV=workExecuteRecordDicVVValues[workExecuteRecordDicVKI];
										writer.writeTabs();
										writer.sb.append(workExecuteRecordDicVK);
										
										writer.sb.append(':');
										writer.sb.append(workExecuteRecordDicVV);
										
										writer.writeEnter();
									}
								}
							}
							writer.writeRightBrace();
						}
						else
						{
							writer.sb.append("=null");
						}
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		this.workExecuteRecordDic=new IntObjectMap<LongLongMap>(LongLongMap[]::new);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.workExecuteRecordDic=null;
	}
	
}