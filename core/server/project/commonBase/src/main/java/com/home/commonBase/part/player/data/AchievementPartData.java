package com.home.commonBase.part.player.data;
import com.home.commonBase.constlist.generate.PlayerPartDataType;
import com.home.commonBase.data.quest.AchievementCompleteData;
import com.home.commonBase.data.quest.AchievementSaveData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.IntObjectMap;
import com.home.shine.support.pool.DataPool;

/** 成就数据(generated by shine) */
public class AchievementPartData extends BaseData
{
	/** 完成数据组 */
	public IntObjectMap<AchievementCompleteData> completeDatas;
	
	/** 运行中数据组 */
	public IntObjectMap<AchievementSaveData> runningDatas;
	
	/** 数据类型ID */
	public static final int dataID=PlayerPartDataType.Achievement;
	
	public AchievementPartData()
	{
		_dataID=PlayerPartDataType.Achievement;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "AchievementPartData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		int runningDatasLen=stream.readLen();
		if(this.runningDatas!=null)
		{
			this.runningDatas.clear();
			this.runningDatas.ensureCapacity(runningDatasLen);
		}
		else
		{
			this.runningDatas=new IntObjectMap<AchievementSaveData>(AchievementSaveData[]::new,runningDatasLen);
		}
		
		IntObjectMap<AchievementSaveData> runningDatasT=this.runningDatas;
		for(int runningDatasI=runningDatasLen-1;runningDatasI>=0;--runningDatasI)
		{
			AchievementSaveData runningDatasV;
			BaseData runningDatasVT=stream.readDataFullNotNull();
			if(runningDatasVT!=null)
			{
				if(runningDatasVT instanceof AchievementSaveData)
				{
					runningDatasV=(AchievementSaveData)runningDatasVT;
				}
				else
				{
					runningDatasV=new AchievementSaveData();
					if(!(runningDatasVT.getClass().isAssignableFrom(AchievementSaveData.class)))
					{
						stream.throwTypeReadError(AchievementSaveData.class,runningDatasVT.getClass());
					}
					runningDatasV.shadowCopy(runningDatasVT);
				}
			}
			else
			{
				runningDatasV=null;
			}
			
			runningDatasT.put(runningDatasV.id,runningDatasV);
		}
		
		int completeDatasLen=stream.readLen();
		if(this.completeDatas!=null)
		{
			this.completeDatas.clear();
			this.completeDatas.ensureCapacity(completeDatasLen);
		}
		else
		{
			this.completeDatas=new IntObjectMap<AchievementCompleteData>(AchievementCompleteData[]::new,completeDatasLen);
		}
		
		IntObjectMap<AchievementCompleteData> completeDatasT=this.completeDatas;
		for(int completeDatasI=completeDatasLen-1;completeDatasI>=0;--completeDatasI)
		{
			AchievementCompleteData completeDatasV;
			BaseData completeDatasVT=stream.readDataFullNotNull();
			if(completeDatasVT!=null)
			{
				if(completeDatasVT instanceof AchievementCompleteData)
				{
					completeDatasV=(AchievementCompleteData)completeDatasVT;
				}
				else
				{
					completeDatasV=new AchievementCompleteData();
					if(!(completeDatasVT.getClass().isAssignableFrom(AchievementCompleteData.class)))
					{
						stream.throwTypeReadError(AchievementCompleteData.class,completeDatasVT.getClass());
					}
					completeDatasV.shadowCopy(completeDatasVT);
				}
			}
			else
			{
				completeDatasV=null;
			}
			
			completeDatasT.put(completeDatasV.id,completeDatasV);
		}
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.runningDatas!=null)
		{
			stream.writeLen(this.runningDatas.size());
			if(!this.runningDatas.isEmpty())
			{
				Object[] runningDatasVValues=this.runningDatas.getValues();
				for(int runningDatasVI=runningDatasVValues.length-1;runningDatasVI>=0;--runningDatasVI)
				{
					if(runningDatasVValues[runningDatasVI]!=null)
					{
						AchievementSaveData runningDatasV=(AchievementSaveData)runningDatasVValues[runningDatasVI];
						if(runningDatasV!=null)
						{
							stream.writeDataFullNotNull(runningDatasV);
						}
						else
						{
							nullObjError("runningDatasV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("runningDatas");
		}
		
		if(this.completeDatas!=null)
		{
			stream.writeLen(this.completeDatas.size());
			if(!this.completeDatas.isEmpty())
			{
				Object[] completeDatasVValues=this.completeDatas.getValues();
				for(int completeDatasVI=completeDatasVValues.length-1;completeDatasVI>=0;--completeDatasVI)
				{
					if(completeDatasVValues[completeDatasVI]!=null)
					{
						AchievementCompleteData completeDatasV=(AchievementCompleteData)completeDatasVValues[completeDatasVI];
						if(completeDatasV!=null)
						{
							stream.writeDataFullNotNull(completeDatasV);
						}
						else
						{
							nullObjError("completeDatasV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("completeDatas");
		}
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		int runningDatasLen=stream.readLen();
		if(this.runningDatas!=null)
		{
			this.runningDatas.clear();
			this.runningDatas.ensureCapacity(runningDatasLen);
		}
		else
		{
			this.runningDatas=new IntObjectMap<AchievementSaveData>(AchievementSaveData[]::new,runningDatasLen);
		}
		
		IntObjectMap<AchievementSaveData> runningDatasT=this.runningDatas;
		for(int runningDatasI=runningDatasLen-1;runningDatasI>=0;--runningDatasI)
		{
			AchievementSaveData runningDatasV;
			runningDatasV=(AchievementSaveData)stream.readDataSimpleNotNull();
			
			runningDatasT.put(runningDatasV.id,runningDatasV);
		}
		
		int completeDatasLen=stream.readLen();
		if(this.completeDatas!=null)
		{
			this.completeDatas.clear();
			this.completeDatas.ensureCapacity(completeDatasLen);
		}
		else
		{
			this.completeDatas=new IntObjectMap<AchievementCompleteData>(AchievementCompleteData[]::new,completeDatasLen);
		}
		
		IntObjectMap<AchievementCompleteData> completeDatasT=this.completeDatas;
		for(int completeDatasI=completeDatasLen-1;completeDatasI>=0;--completeDatasI)
		{
			AchievementCompleteData completeDatasV;
			completeDatasV=(AchievementCompleteData)stream.readDataSimpleNotNull();
			
			completeDatasT.put(completeDatasV.id,completeDatasV);
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.runningDatas!=null)
		{
			stream.writeLen(this.runningDatas.size());
			if(!this.runningDatas.isEmpty())
			{
				Object[] runningDatasVValues=this.runningDatas.getValues();
				for(int runningDatasVI=runningDatasVValues.length-1;runningDatasVI>=0;--runningDatasVI)
				{
					if(runningDatasVValues[runningDatasVI]!=null)
					{
						AchievementSaveData runningDatasV=(AchievementSaveData)runningDatasVValues[runningDatasVI];
						if(runningDatasV!=null)
						{
							stream.writeDataSimpleNotNull(runningDatasV);
						}
						else
						{
							nullObjError("runningDatasV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("runningDatas");
		}
		
		if(this.completeDatas!=null)
		{
			stream.writeLen(this.completeDatas.size());
			if(!this.completeDatas.isEmpty())
			{
				Object[] completeDatasVValues=this.completeDatas.getValues();
				for(int completeDatasVI=completeDatasVValues.length-1;completeDatasVI>=0;--completeDatasVI)
				{
					if(completeDatasVValues[completeDatasVI]!=null)
					{
						AchievementCompleteData completeDatasV=(AchievementCompleteData)completeDatasVValues[completeDatasVI];
						if(completeDatasV!=null)
						{
							stream.writeDataSimpleNotNull(completeDatasV);
						}
						else
						{
							nullObjError("completeDatasV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("completeDatas");
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof AchievementPartData))
			return;
		
		AchievementPartData mData=(AchievementPartData)data;
		
		this.runningDatas=mData.runningDatas;
		this.completeDatas=mData.completeDatas;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof AchievementPartData))
			return;
		
		AchievementPartData mData=(AchievementPartData)data;
		
		if(mData.runningDatas!=null)
		{
			if(this.runningDatas!=null)
			{
				this.runningDatas.clear();
				this.runningDatas.ensureCapacity(mData.runningDatas.size());
			}
			else
			{
				this.runningDatas=new IntObjectMap<AchievementSaveData>(AchievementSaveData[]::new,mData.runningDatas.size());
			}
			
			IntObjectMap<AchievementSaveData> runningDatasT=this.runningDatas;
			if(!mData.runningDatas.isEmpty())
			{
				Object[] runningDatasVValues=mData.runningDatas.getValues();
				for(int runningDatasVI=runningDatasVValues.length-1;runningDatasVI>=0;--runningDatasVI)
				{
					if(runningDatasVValues[runningDatasVI]!=null)
					{
						AchievementSaveData runningDatasV=(AchievementSaveData)runningDatasVValues[runningDatasVI];
						AchievementSaveData runningDatasU;
						if(runningDatasV!=null)
						{
							runningDatasU=(AchievementSaveData)runningDatasV.clone();
						}
						else
						{
							runningDatasU=null;
							nullObjError("runningDatasU");
						}
						
						runningDatasT.put(runningDatasU.id,runningDatasU);
					}
				}
			}
		}
		else
		{
			this.runningDatas=null;
			nullObjError("runningDatas");
		}
		
		if(mData.completeDatas!=null)
		{
			if(this.completeDatas!=null)
			{
				this.completeDatas.clear();
				this.completeDatas.ensureCapacity(mData.completeDatas.size());
			}
			else
			{
				this.completeDatas=new IntObjectMap<AchievementCompleteData>(AchievementCompleteData[]::new,mData.completeDatas.size());
			}
			
			IntObjectMap<AchievementCompleteData> completeDatasT=this.completeDatas;
			if(!mData.completeDatas.isEmpty())
			{
				Object[] completeDatasVValues=mData.completeDatas.getValues();
				for(int completeDatasVI=completeDatasVValues.length-1;completeDatasVI>=0;--completeDatasVI)
				{
					if(completeDatasVValues[completeDatasVI]!=null)
					{
						AchievementCompleteData completeDatasV=(AchievementCompleteData)completeDatasVValues[completeDatasVI];
						AchievementCompleteData completeDatasU;
						if(completeDatasV!=null)
						{
							completeDatasU=(AchievementCompleteData)completeDatasV.clone();
						}
						else
						{
							completeDatasU=null;
							nullObjError("completeDatasU");
						}
						
						completeDatasT.put(completeDatasU.id,completeDatasU);
					}
				}
			}
		}
		else
		{
			this.completeDatas=null;
			nullObjError("completeDatas");
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		AchievementPartData mData=(AchievementPartData)data;
		if(mData.runningDatas!=null)
		{
			if(this.runningDatas==null)
				return false;
			if(this.runningDatas.size()!=mData.runningDatas.size())
				return false;
			IntObjectMap<AchievementSaveData> runningDatasR=mData.runningDatas;
			if(!this.runningDatas.isEmpty())
			{
				int runningDatasKFreeValue=this.runningDatas.getFreeValue();
				int[] runningDatasKKeys=this.runningDatas.getKeys();
				Object[] runningDatasVValues=this.runningDatas.getValues();
				for(int runningDatasKI=runningDatasKKeys.length-1;runningDatasKI>=0;--runningDatasKI)
				{
					int runningDatasK=runningDatasKKeys[runningDatasKI];
					if(runningDatasK!=runningDatasKFreeValue)
					{
						AchievementSaveData runningDatasV=(AchievementSaveData)runningDatasVValues[runningDatasKI];
						AchievementSaveData runningDatasU=runningDatasR.get(runningDatasK);
						if(runningDatasU!=null)
						{
							if(runningDatasV==null)
								return false;
							if(!runningDatasV.dataEquals(runningDatasU))
								return false;
						}
						else
						{
							if(runningDatasV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.runningDatas!=null)
				return false;
		}
		
		if(mData.completeDatas!=null)
		{
			if(this.completeDatas==null)
				return false;
			if(this.completeDatas.size()!=mData.completeDatas.size())
				return false;
			IntObjectMap<AchievementCompleteData> completeDatasR=mData.completeDatas;
			if(!this.completeDatas.isEmpty())
			{
				int completeDatasKFreeValue=this.completeDatas.getFreeValue();
				int[] completeDatasKKeys=this.completeDatas.getKeys();
				Object[] completeDatasVValues=this.completeDatas.getValues();
				for(int completeDatasKI=completeDatasKKeys.length-1;completeDatasKI>=0;--completeDatasKI)
				{
					int completeDatasK=completeDatasKKeys[completeDatasKI];
					if(completeDatasK!=completeDatasKFreeValue)
					{
						AchievementCompleteData completeDatasV=(AchievementCompleteData)completeDatasVValues[completeDatasKI];
						AchievementCompleteData completeDatasU=completeDatasR.get(completeDatasK);
						if(completeDatasU!=null)
						{
							if(completeDatasV==null)
								return false;
							if(!completeDatasV.dataEquals(completeDatasU))
								return false;
						}
						else
						{
							if(completeDatasV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.completeDatas!=null)
				return false;
		}
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("runningDatas");
		writer.sb.append(':');
		writer.sb.append("Map<int,AchievementSaveData>");
		if(this.runningDatas!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.runningDatas.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.runningDatas.isEmpty())
			{
				int runningDatasKFreeValue=this.runningDatas.getFreeValue();
				int[] runningDatasKKeys=this.runningDatas.getKeys();
				Object[] runningDatasVValues=this.runningDatas.getValues();
				for(int runningDatasKI=runningDatasKKeys.length-1;runningDatasKI>=0;--runningDatasKI)
				{
					int runningDatasK=runningDatasKKeys[runningDatasKI];
					if(runningDatasK!=runningDatasKFreeValue)
					{
						AchievementSaveData runningDatasV=(AchievementSaveData)runningDatasVValues[runningDatasKI];
						writer.writeTabs();
						writer.sb.append(runningDatasK);
						
						writer.sb.append(':');
						if(runningDatasV!=null)
						{
							runningDatasV.writeDataString(writer);
						}
						else
						{
							writer.sb.append("AchievementSaveData=null");
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
		writer.writeTabs();
		writer.sb.append("completeDatas");
		writer.sb.append(':');
		writer.sb.append("Map<int,AchievementCompleteData>");
		if(this.completeDatas!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.completeDatas.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.completeDatas.isEmpty())
			{
				int completeDatasKFreeValue=this.completeDatas.getFreeValue();
				int[] completeDatasKKeys=this.completeDatas.getKeys();
				Object[] completeDatasVValues=this.completeDatas.getValues();
				for(int completeDatasKI=completeDatasKKeys.length-1;completeDatasKI>=0;--completeDatasKI)
				{
					int completeDatasK=completeDatasKKeys[completeDatasKI];
					if(completeDatasK!=completeDatasKFreeValue)
					{
						AchievementCompleteData completeDatasV=(AchievementCompleteData)completeDatasVValues[completeDatasKI];
						writer.writeTabs();
						writer.sb.append(completeDatasK);
						
						writer.sb.append(':');
						if(completeDatasV!=null)
						{
							completeDatasV.writeDataString(writer);
						}
						else
						{
							writer.sb.append("AchievementCompleteData=null");
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
		this.runningDatas=new IntObjectMap<AchievementSaveData>(AchievementSaveData[]::new);
		this.completeDatas=new IntObjectMap<AchievementCompleteData>(AchievementCompleteData[]::new);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.runningDatas=null;
		this.completeDatas=null;
	}
	
}
