package com.home.commonBase.part.player.clientData;
import com.home.commonBase.baseData.BaseClientPartData;
import com.home.commonBase.constlist.generate.PlayerPartClientDataType;
import com.home.commonBase.data.system.InfoLogData;
import com.home.commonBase.data.system.KeepSaveData;
import com.home.commonBase.data.system.SaveVersionData;
import com.home.commonBase.part.player.data.SystemPartData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.data.BaseData;
import com.home.shine.data.DateData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.SList;
import com.home.shine.support.collection.SQueue;
import com.home.shine.support.collection.SSet;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class SystemClientPartData extends BaseClientPartData
{
	/** 版本数据 */
	public SaveVersionData version;
	
	/** 服务器时间戳(毫秒) */
	public long serverTime;
	
	/** 数据类型ID */
	public static final int dataID=PlayerPartClientDataType.System;
	
	/** 创建日期 */
	public DateData createDate;
	
	/** 流程步 */
	public int flowStep;
	
	/** 保存数据 */
	public KeepSaveData keepSave;
	
	/** 客户端随机种子序号 */
	public int clientRandomSeedIndex;
	
	/** 客户端离线事务收到的客户端序号 */
	public int clientOfflineWorkReceiveIndex;
	
	/** gm指令组(开发期有意义,已废弃) */
	public SSet<String> gmCommandSet;
	
	/** GM类型 */
	public int gmType;
	
	/** 服务器出生码(每个新服生成一次) */
	public int serverBornCode;
	
	/** 服务器开服时间戳(毫秒) */
	public long serverStartTime;
	
	/** 游戏日志信息队列 */
	public SQueue<InfoLogData> logQueue;
	
	/** 客户端随机种子 */
	public int[] clientRandomSeeds;
	
	/** 下一个0点时刻 */
	public long nextDailyTime;
	
	/** 当前随机种子key */
	public int clientRandomSeedKey;
	
	/** 是否封号 */
	public boolean isBlock;
	
	/** 上次的每天时刻 */
	public long lastDailyTime;
	
	/** 上次下线时间 */
	public long logoutDate;
	
	/** 上次上线时间 */
	public long loginDate;
	
	/** 是否初次登录过 */
	public boolean firstLogined;
	
	/** 解封日期 */
	public long openBlockDate;
	
	public SystemClientPartData()
	{
		_dataID=PlayerPartClientDataType.System;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.version=(SaveVersionData)stream.readDataSimpleNotNull();
		
		this.serverTime=stream.readLong();
		
		this.isBlock=stream.readBoolean();
		
		this.flowStep=stream.readInt();
		
		this.keepSave=new KeepSaveData();
		this.keepSave.readBytesSimple(stream);
		
		if(stream.readBoolean())
		{
			int clientRandomSeedsLen=stream.readLen();
			if(this.clientRandomSeeds==null || this.clientRandomSeeds.length!=clientRandomSeedsLen)
			{
				this.clientRandomSeeds=new int[clientRandomSeedsLen];
			}
			int[] clientRandomSeedsT=this.clientRandomSeeds;
			for(int clientRandomSeedsI=0;clientRandomSeedsI<clientRandomSeedsLen;++clientRandomSeedsI)
			{
				int clientRandomSeedsV;
				clientRandomSeedsV=stream.readInt();
				
				clientRandomSeedsT[clientRandomSeedsI]=clientRandomSeedsV;
			}
		}
		else
		{
			this.clientRandomSeeds=null;
		}
		
		this.clientRandomSeedIndex=stream.readInt();
		
		this.clientOfflineWorkReceiveIndex=stream.readInt();
		
		if(stream.readBoolean())
		{
			int gmCommandSetLen=stream.readLen();
			if(this.gmCommandSet!=null)
			{
				this.gmCommandSet.clear();
				this.gmCommandSet.ensureCapacity(gmCommandSetLen);
			}
			else
			{
				this.gmCommandSet=new SSet<String>(String[]::new,gmCommandSetLen);
			}
			
			SSet<String> gmCommandSetT=this.gmCommandSet;
			for(int gmCommandSetI=gmCommandSetLen-1;gmCommandSetI>=0;--gmCommandSetI)
			{
				String gmCommandSetV;
				gmCommandSetV=stream.readUTF();
				
				gmCommandSetT.add(gmCommandSetV);
			}
		}
		else
		{
			this.gmCommandSet=null;
		}
		
		this.gmType=stream.readInt();
		
		this.serverBornCode=stream.readInt();
		
		this.serverStartTime=stream.readLong();
		
		int logQueueLen=stream.readLen();
		if(this.logQueue!=null)
		{
			this.logQueue.clear();
			this.logQueue.ensureCapacity(logQueueLen);
		}
		else
		{
			this.logQueue=new SQueue<InfoLogData>(InfoLogData[]::new,logQueueLen);
		}
		
		SQueue<InfoLogData> logQueueT=this.logQueue;
		for(int logQueueI=logQueueLen-1;logQueueI>=0;--logQueueI)
		{
			InfoLogData logQueueV;
			logQueueV=(InfoLogData)stream.readDataSimpleNotNull();
			
			logQueueT.offer(logQueueV);
		}
		
		this.nextDailyTime=stream.readLong();
		
		this.createDate=new DateData();
		this.createDate.readBytesSimple(stream);
		
		this.clientRandomSeedKey=stream.readInt();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.version!=null)
		{
			stream.writeDataSimpleNotNull(this.version);
		}
		else
		{
			nullObjError("version");
		}
		
		stream.writeLong(this.serverTime);
		
		stream.writeBoolean(this.isBlock);
		
		stream.writeInt(this.flowStep);
		
		if(this.keepSave!=null)
		{
			this.keepSave.writeBytesSimple(stream);
		}
		else
		{
			nullObjError("keepSave");
		}
		
		if(this.clientRandomSeeds!=null)
		{
			stream.writeBoolean(true);
			int[] clientRandomSeedsT=this.clientRandomSeeds;
			stream.writeLen(clientRandomSeedsT.length);
			for(int clientRandomSeedsVI=0,clientRandomSeedsVLen=clientRandomSeedsT.length;clientRandomSeedsVI<clientRandomSeedsVLen;++clientRandomSeedsVI)
			{
				int clientRandomSeedsV=clientRandomSeedsT[clientRandomSeedsVI];
				stream.writeInt(clientRandomSeedsV);
				
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeInt(this.clientRandomSeedIndex);
		
		stream.writeInt(this.clientOfflineWorkReceiveIndex);
		
		if(this.gmCommandSet!=null)
		{
			stream.writeBoolean(true);
			stream.writeLen(this.gmCommandSet.size());
			if(!this.gmCommandSet.isEmpty())
			{
				Object[] gmCommandSetVKeys=this.gmCommandSet.getKeys();
				for(int gmCommandSetVI=gmCommandSetVKeys.length-1;gmCommandSetVI>=0;--gmCommandSetVI)
				{
					if(gmCommandSetVKeys[gmCommandSetVI]!=null)
					{
						String gmCommandSetV=(String)gmCommandSetVKeys[gmCommandSetVI];
						stream.writeUTF(gmCommandSetV);
						
					}
				}
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeInt(this.gmType);
		
		stream.writeInt(this.serverBornCode);
		
		stream.writeLong(this.serverStartTime);
		
		if(this.logQueue!=null)
		{
			stream.writeLen(this.logQueue.size());
			if(!this.logQueue.isEmpty())
			{
				Object[] logQueueVValues=this.logQueue.getValues();
				int logQueueVMark=this.logQueue.getMark();
				int logQueueVStart=this.logQueue.getStart();
				for(int logQueueVI=0,logQueueVLen=this.logQueue.length();logQueueVI<logQueueVLen;++logQueueVI)
				{
					InfoLogData logQueueV=(InfoLogData)logQueueVValues[(logQueueVI+logQueueVStart)&logQueueVMark];
					if(logQueueV!=null)
					{
						stream.writeDataSimpleNotNull(logQueueV);
					}
					else
					{
						nullObjError("logQueueV");
					}
					
				}
			}
		}
		else
		{
			nullObjError("logQueue");
		}
		
		stream.writeLong(this.nextDailyTime);
		
		if(this.createDate!=null)
		{
			this.createDate.writeBytesSimple(stream);
		}
		else
		{
			nullObjError("createDate");
		}
		
		stream.writeInt(this.clientRandomSeedKey);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof SystemClientPartData))
			return;
		
		SystemClientPartData mData=(SystemClientPartData)data;
		
		this.version=mData.version;
		this.serverTime=mData.serverTime;
		this.isBlock=mData.isBlock;
		this.flowStep=mData.flowStep;
		this.keepSave=mData.keepSave;
		this.clientRandomSeeds=mData.clientRandomSeeds;
		this.clientRandomSeedIndex=mData.clientRandomSeedIndex;
		this.clientOfflineWorkReceiveIndex=mData.clientOfflineWorkReceiveIndex;
		this.gmCommandSet=mData.gmCommandSet;
		this.gmType=mData.gmType;
		this.serverBornCode=mData.serverBornCode;
		this.serverStartTime=mData.serverStartTime;
		this.logQueue=mData.logQueue;
		this.nextDailyTime=mData.nextDailyTime;
		this.createDate=mData.createDate;
		this.clientRandomSeedKey=mData.clientRandomSeedKey;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof SystemClientPartData))
			return;
		
		SystemClientPartData mData=(SystemClientPartData)data;
		
		if(mData.version!=null)
		{
			this.version=(SaveVersionData)mData.version.clone();
		}
		else
		{
			this.version=null;
			nullObjError("version");
		}
		
		this.serverTime=mData.serverTime;
		
		this.isBlock=mData.isBlock;
		
		this.flowStep=mData.flowStep;
		
		if(mData.keepSave!=null)
		{
			this.keepSave=new KeepSaveData();
			this.keepSave.copy(mData.keepSave);
		}
		else
		{
			this.keepSave=null;
			nullObjError("keepSave");
		}
		
		if(mData.clientRandomSeeds!=null)
		{
			int[] clientRandomSeedsR=mData.clientRandomSeeds;
			int clientRandomSeedsLen=clientRandomSeedsR.length;
			if(this.clientRandomSeeds==null || this.clientRandomSeeds.length!=clientRandomSeedsLen)
			{
				this.clientRandomSeeds=new int[clientRandomSeedsLen];
			}
			BytesControl.arrayCopy(mData.clientRandomSeeds,this.clientRandomSeeds,clientRandomSeedsLen);
		}
		else
		{
			this.clientRandomSeeds=null;
		}
		
		this.clientRandomSeedIndex=mData.clientRandomSeedIndex;
		
		this.clientOfflineWorkReceiveIndex=mData.clientOfflineWorkReceiveIndex;
		
		if(mData.gmCommandSet!=null)
		{
			if(this.gmCommandSet!=null)
			{
				this.gmCommandSet.clear();
				this.gmCommandSet.ensureCapacity(mData.gmCommandSet.size());
			}
			else
			{
				this.gmCommandSet=new SSet<String>(String[]::new,mData.gmCommandSet.size());
			}
			
			SSet<String> gmCommandSetT=this.gmCommandSet;
			if(!mData.gmCommandSet.isEmpty())
			{
				Object[] gmCommandSetVKeys=mData.gmCommandSet.getKeys();
				for(int gmCommandSetVI=gmCommandSetVKeys.length-1;gmCommandSetVI>=0;--gmCommandSetVI)
				{
					if(gmCommandSetVKeys[gmCommandSetVI]!=null)
					{
						String gmCommandSetV=(String)gmCommandSetVKeys[gmCommandSetVI];
						String gmCommandSetU;
						gmCommandSetU=gmCommandSetV;
						
						gmCommandSetT.add(gmCommandSetU);
					}
				}
			}
		}
		else
		{
			this.gmCommandSet=null;
		}
		
		this.gmType=mData.gmType;
		
		this.serverBornCode=mData.serverBornCode;
		
		this.serverStartTime=mData.serverStartTime;
		
		if(mData.logQueue!=null)
		{
			if(this.logQueue!=null)
			{
				this.logQueue.clear();
				this.logQueue.ensureCapacity(mData.logQueue.size());
			}
			else
			{
				this.logQueue=new SQueue<InfoLogData>(InfoLogData[]::new,mData.logQueue.size());
			}
			
			SQueue<InfoLogData> logQueueT=this.logQueue;
			if(!mData.logQueue.isEmpty())
			{
				Object[] logQueueVValues=mData.logQueue.getValues();
				int logQueueVMark=mData.logQueue.getMark();
				int logQueueVStart=mData.logQueue.getStart();
				for(int logQueueVI=0,logQueueVLen=mData.logQueue.length();logQueueVI<logQueueVLen;++logQueueVI)
				{
					InfoLogData logQueueV=(InfoLogData)logQueueVValues[(logQueueVI+logQueueVStart)&logQueueVMark];
					InfoLogData logQueueU;
					if(logQueueV!=null)
					{
						logQueueU=(InfoLogData)logQueueV.clone();
					}
					else
					{
						logQueueU=null;
						nullObjError("logQueueU");
					}
					
					logQueueT.offer(logQueueU);
				}
			}
		}
		else
		{
			this.logQueue=null;
			nullObjError("logQueue");
		}
		
		this.nextDailyTime=mData.nextDailyTime;
		
		if(mData.createDate!=null)
		{
			this.createDate=new DateData();
			this.createDate.copy(mData.createDate);
		}
		else
		{
			this.createDate=null;
			nullObjError("createDate");
		}
		
		this.clientRandomSeedKey=mData.clientRandomSeedKey;
		
	}
	
	/** 从服务器数据上复制数据(潜拷,因InitClient会copy) */
	@Override
	protected void toCopyFromServer(BaseData data)
	{
		super.toCopyFromServer(data);
		if(!(data instanceof SystemPartData))
			return;
		
		SystemPartData mData=(SystemPartData)data;
		
		this.version=mData.version;
		
		this.isBlock=mData.isBlock;
		
		this.flowStep=mData.flowStep;
		
		this.keepSave=mData.keepSave;
		
		this.clientRandomSeeds=mData.clientRandomSeeds;
		
		this.clientRandomSeedIndex=mData.clientRandomSeedIndex;
		
		this.clientOfflineWorkReceiveIndex=mData.clientOfflineWorkReceiveIndex;
		
		this.gmType=mData.gmType;
		
		this.logQueue=mData.logQueue;
		
		this.nextDailyTime=mData.nextDailyTime;
		
		this.createDate=mData.createDate;
		
		this.clientRandomSeedKey=mData.clientRandomSeedKey;
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "SystemClientPartData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		BaseData versionT=stream.readDataFullNotNull();
		if(versionT!=null)
		{
			if(versionT instanceof SaveVersionData)
			{
				this.version=(SaveVersionData)versionT;
			}
			else
			{
				this.version=new SaveVersionData();
				if(!(versionT.getClass().isAssignableFrom(SaveVersionData.class)))
				{
					stream.throwTypeReadError(SaveVersionData.class,versionT.getClass());
				}
				this.version.shadowCopy(versionT);
			}
		}
		else
		{
			this.version=null;
		}
		
		this.serverTime=stream.readLong();
		
		this.isBlock=stream.readBoolean();
		
		this.flowStep=stream.readInt();
		
		this.keepSave=new KeepSaveData();
		this.keepSave.readBytesFull(stream);
		
		if(stream.readBoolean())
		{
			int clientRandomSeedsLen=stream.readLen();
			if(this.clientRandomSeeds==null || this.clientRandomSeeds.length!=clientRandomSeedsLen)
			{
				this.clientRandomSeeds=new int[clientRandomSeedsLen];
			}
			int[] clientRandomSeedsT=this.clientRandomSeeds;
			for(int clientRandomSeedsI=0;clientRandomSeedsI<clientRandomSeedsLen;++clientRandomSeedsI)
			{
				int clientRandomSeedsV;
				clientRandomSeedsV=stream.readInt();
				
				clientRandomSeedsT[clientRandomSeedsI]=clientRandomSeedsV;
			}
		}
		else
		{
			this.clientRandomSeeds=null;
		}
		
		this.clientRandomSeedIndex=stream.readInt();
		
		this.clientOfflineWorkReceiveIndex=stream.readInt();
		
		if(stream.readBoolean())
		{
			int gmCommandSetLen=stream.readLen();
			if(this.gmCommandSet!=null)
			{
				this.gmCommandSet.clear();
				this.gmCommandSet.ensureCapacity(gmCommandSetLen);
			}
			else
			{
				this.gmCommandSet=new SSet<String>(String[]::new,gmCommandSetLen);
			}
			
			SSet<String> gmCommandSetT=this.gmCommandSet;
			for(int gmCommandSetI=gmCommandSetLen-1;gmCommandSetI>=0;--gmCommandSetI)
			{
				String gmCommandSetV;
				gmCommandSetV=stream.readUTF();
				
				gmCommandSetT.add(gmCommandSetV);
			}
		}
		else
		{
			this.gmCommandSet=null;
		}
		
		this.gmType=stream.readInt();
		
		this.serverBornCode=stream.readInt();
		
		this.serverStartTime=stream.readLong();
		
		int logQueueLen=stream.readLen();
		if(this.logQueue!=null)
		{
			this.logQueue.clear();
			this.logQueue.ensureCapacity(logQueueLen);
		}
		else
		{
			this.logQueue=new SQueue<InfoLogData>(InfoLogData[]::new,logQueueLen);
		}
		
		SQueue<InfoLogData> logQueueT=this.logQueue;
		for(int logQueueI=logQueueLen-1;logQueueI>=0;--logQueueI)
		{
			InfoLogData logQueueV;
			BaseData logQueueVT=stream.readDataFullNotNull();
			if(logQueueVT!=null)
			{
				if(logQueueVT instanceof InfoLogData)
				{
					logQueueV=(InfoLogData)logQueueVT;
				}
				else
				{
					logQueueV=new InfoLogData();
					if(!(logQueueVT.getClass().isAssignableFrom(InfoLogData.class)))
					{
						stream.throwTypeReadError(InfoLogData.class,logQueueVT.getClass());
					}
					logQueueV.shadowCopy(logQueueVT);
				}
			}
			else
			{
				logQueueV=null;
			}
			
			logQueueT.offer(logQueueV);
		}
		
		this.nextDailyTime=stream.readLong();
		
		this.createDate=new DateData();
		this.createDate.readBytesFull(stream);
		
		this.clientRandomSeedKey=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.version!=null)
		{
			stream.writeDataFullNotNull(this.version);
		}
		else
		{
			nullObjError("version");
		}
		
		stream.writeLong(this.serverTime);
		
		stream.writeBoolean(this.isBlock);
		
		stream.writeInt(this.flowStep);
		
		if(this.keepSave!=null)
		{
			this.keepSave.writeBytesFull(stream);
		}
		else
		{
			nullObjError("keepSave");
		}
		
		if(this.clientRandomSeeds!=null)
		{
			stream.writeBoolean(true);
			int[] clientRandomSeedsT=this.clientRandomSeeds;
			stream.writeLen(clientRandomSeedsT.length);
			for(int clientRandomSeedsVI=0,clientRandomSeedsVLen=clientRandomSeedsT.length;clientRandomSeedsVI<clientRandomSeedsVLen;++clientRandomSeedsVI)
			{
				int clientRandomSeedsV=clientRandomSeedsT[clientRandomSeedsVI];
				stream.writeInt(clientRandomSeedsV);
				
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeInt(this.clientRandomSeedIndex);
		
		stream.writeInt(this.clientOfflineWorkReceiveIndex);
		
		if(this.gmCommandSet!=null)
		{
			stream.writeBoolean(true);
			stream.writeLen(this.gmCommandSet.size());
			if(!this.gmCommandSet.isEmpty())
			{
				Object[] gmCommandSetVKeys=this.gmCommandSet.getKeys();
				for(int gmCommandSetVI=gmCommandSetVKeys.length-1;gmCommandSetVI>=0;--gmCommandSetVI)
				{
					if(gmCommandSetVKeys[gmCommandSetVI]!=null)
					{
						String gmCommandSetV=(String)gmCommandSetVKeys[gmCommandSetVI];
						stream.writeUTF(gmCommandSetV);
						
					}
				}
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeInt(this.gmType);
		
		stream.writeInt(this.serverBornCode);
		
		stream.writeLong(this.serverStartTime);
		
		if(this.logQueue!=null)
		{
			stream.writeLen(this.logQueue.size());
			if(!this.logQueue.isEmpty())
			{
				Object[] logQueueVValues=this.logQueue.getValues();
				int logQueueVMark=this.logQueue.getMark();
				int logQueueVStart=this.logQueue.getStart();
				for(int logQueueVI=0,logQueueVLen=this.logQueue.length();logQueueVI<logQueueVLen;++logQueueVI)
				{
					InfoLogData logQueueV=(InfoLogData)logQueueVValues[(logQueueVI+logQueueVStart)&logQueueVMark];
					if(logQueueV!=null)
					{
						stream.writeDataFullNotNull(logQueueV);
					}
					else
					{
						nullObjError("logQueueV");
					}
					
				}
			}
		}
		else
		{
			nullObjError("logQueue");
		}
		
		stream.writeLong(this.nextDailyTime);
		
		if(this.createDate!=null)
		{
			this.createDate.writeBytesFull(stream);
		}
		else
		{
			nullObjError("createDate");
		}
		
		stream.writeInt(this.clientRandomSeedKey);
		
		stream.endWriteObj();
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		SystemClientPartData mData=(SystemClientPartData)data;
		if(mData.version!=null)
		{
			if(this.version==null)
				return false;
			if(!this.version.dataEquals(mData.version))
				return false;
		}
		else
		{
			if(this.version!=null)
				return false;
		}
		
		if(this.serverTime!=mData.serverTime)
			return false;
		
		if(this.isBlock!=mData.isBlock)
			return false;
		
		if(this.flowStep!=mData.flowStep)
			return false;
		
		if(mData.keepSave!=null)
		{
			if(this.keepSave==null)
				return false;
			if(!this.keepSave.dataEquals(mData.keepSave))
				return false;
		}
		else
		{
			if(this.keepSave!=null)
				return false;
		}
		
		if(mData.clientRandomSeeds!=null)
		{
			if(this.clientRandomSeeds==null)
				return false;
			if(this.clientRandomSeeds.length!=mData.clientRandomSeeds.length)
				return false;
			int[] clientRandomSeedsT=this.clientRandomSeeds;
			int[] clientRandomSeedsR=mData.clientRandomSeeds;
			int clientRandomSeedsLen=clientRandomSeedsT.length;
			for(int clientRandomSeedsI=0;clientRandomSeedsI<clientRandomSeedsLen;++clientRandomSeedsI)
			{
				int clientRandomSeedsU=clientRandomSeedsT[clientRandomSeedsI];
				int clientRandomSeedsV=clientRandomSeedsR[clientRandomSeedsI];
				if(clientRandomSeedsU!=clientRandomSeedsV)
					return false;
				
			}
		}
		else
		{
			if(this.clientRandomSeeds!=null)
				return false;
		}
		
		if(this.clientRandomSeedIndex!=mData.clientRandomSeedIndex)
			return false;
		
		if(this.clientOfflineWorkReceiveIndex!=mData.clientOfflineWorkReceiveIndex)
			return false;
		
		if(mData.gmCommandSet!=null)
		{
			if(this.gmCommandSet==null)
				return false;
			if(this.gmCommandSet.size()!=mData.gmCommandSet.size())
				return false;
			SSet<String> gmCommandSetR=mData.gmCommandSet;
			if(!this.gmCommandSet.isEmpty())
			{
				Object[] gmCommandSetVKeys=this.gmCommandSet.getKeys();
				for(int gmCommandSetVI=gmCommandSetVKeys.length-1;gmCommandSetVI>=0;--gmCommandSetVI)
				{
					if(gmCommandSetVKeys[gmCommandSetVI]!=null)
					{
						String gmCommandSetV=(String)gmCommandSetVKeys[gmCommandSetVI];
						if(!gmCommandSetR.contains(gmCommandSetV))
							return false;
					}
				}
			}
		}
		else
		{
			if(this.gmCommandSet!=null)
				return false;
		}
		
		if(this.gmType!=mData.gmType)
			return false;
		
		if(this.serverBornCode!=mData.serverBornCode)
			return false;
		
		if(this.serverStartTime!=mData.serverStartTime)
			return false;
		
		if(mData.logQueue!=null)
		{
			if(this.logQueue==null)
				return false;
			if(this.logQueue.size()!=mData.logQueue.size())
				return false;
			SQueue<InfoLogData> logQueueT=this.logQueue;
			SQueue<InfoLogData> logQueueR=mData.logQueue;
			int logQueueLen=logQueueT.size();
			for(int logQueueI=0;logQueueI<logQueueLen;++logQueueI)
			{
				InfoLogData logQueueU=logQueueT.get(logQueueI);
				InfoLogData logQueueV=logQueueR.get(logQueueI);
				if(logQueueV!=null)
				{
					if(logQueueU==null)
						return false;
					if(!logQueueU.dataEquals(logQueueV))
						return false;
				}
				else
				{
					if(logQueueU!=null)
						return false;
				}
				
			}
		}
		else
		{
			if(this.logQueue!=null)
				return false;
		}
		
		if(this.nextDailyTime!=mData.nextDailyTime)
			return false;
		
		if(mData.createDate!=null)
		{
			if(this.createDate==null)
				return false;
			if(!this.createDate.dataEquals(mData.createDate))
				return false;
		}
		else
		{
			if(this.createDate!=null)
				return false;
		}
		
		if(this.clientRandomSeedKey!=mData.clientRandomSeedKey)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("version");
		writer.sb.append(':');
		if(this.version!=null)
		{
			this.version.writeDataString(writer);
		}
		else
		{
			writer.sb.append("SaveVersionData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("serverTime");
		writer.sb.append(':');
		writer.sb.append(this.serverTime);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("isBlock");
		writer.sb.append(':');
		writer.sb.append(this.isBlock);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("flowStep");
		writer.sb.append(':');
		writer.sb.append(this.flowStep);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("keepSave");
		writer.sb.append(':');
		if(this.keepSave!=null)
		{
			this.keepSave.writeDataString(writer);
		}
		else
		{
			writer.sb.append("KeepSaveData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("clientRandomSeeds");
		writer.sb.append(':');
		writer.sb.append("Array<int>");
		if(this.clientRandomSeeds!=null)
		{
			int[] clientRandomSeedsT=this.clientRandomSeeds;
			int clientRandomSeedsLen=clientRandomSeedsT.length;
			writer.sb.append('(');
			writer.sb.append(clientRandomSeedsLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int clientRandomSeedsI=0;clientRandomSeedsI<clientRandomSeedsLen;++clientRandomSeedsI)
			{
				int clientRandomSeedsV=clientRandomSeedsT[clientRandomSeedsI];
				writer.writeTabs();
				writer.sb.append(clientRandomSeedsI);
				writer.sb.append(':');
				writer.sb.append(clientRandomSeedsV);
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("clientRandomSeedIndex");
		writer.sb.append(':');
		writer.sb.append(this.clientRandomSeedIndex);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("clientOfflineWorkReceiveIndex");
		writer.sb.append(':');
		writer.sb.append(this.clientOfflineWorkReceiveIndex);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("gmCommandSet");
		writer.sb.append(':');
		writer.sb.append("Set<String>");
		if(this.gmCommandSet!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.gmCommandSet.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.gmCommandSet.isEmpty())
			{
				Object[] gmCommandSetVKeys=this.gmCommandSet.getKeys();
				for(int gmCommandSetVI=gmCommandSetVKeys.length-1;gmCommandSetVI>=0;--gmCommandSetVI)
				{
					if(gmCommandSetVKeys[gmCommandSetVI]!=null)
					{
						String gmCommandSetV=(String)gmCommandSetVKeys[gmCommandSetVI];
						writer.writeTabs();
						writer.sb.append(gmCommandSetV);
						
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
		writer.sb.append("gmType");
		writer.sb.append(':');
		writer.sb.append(this.gmType);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("serverBornCode");
		writer.sb.append(':');
		writer.sb.append(this.serverBornCode);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("serverStartTime");
		writer.sb.append(':');
		writer.sb.append(this.serverStartTime);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("logQueue");
		writer.sb.append(':');
		writer.sb.append("Queue<InfoLogData>");
		if(this.logQueue!=null)
		{
			SQueue<InfoLogData> logQueueT=this.logQueue;
			int logQueueLen=logQueueT.size();
			writer.sb.append('(');
			writer.sb.append(logQueueLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int logQueueI=0;logQueueI<logQueueLen;++logQueueI)
			{
				InfoLogData logQueueV=logQueueT.get(logQueueI);
				writer.writeTabs();
				writer.sb.append(logQueueI);
				writer.sb.append(':');
				if(logQueueV!=null)
				{
					logQueueV.writeDataString(writer);
				}
				else
				{
					writer.sb.append("InfoLogData=null");
				}
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("nextDailyTime");
		writer.sb.append(':');
		writer.sb.append(this.nextDailyTime);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("createDate");
		writer.sb.append(':');
		if(this.createDate!=null)
		{
			this.createDate.writeDataString(writer);
		}
		else
		{
			writer.sb.append("DateData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("clientRandomSeedKey");
		writer.sb.append(':');
		writer.sb.append(this.clientRandomSeedKey);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		super.initDefault();
		
		this.version=new SaveVersionData();
		this.version.initDefault();
		this.keepSave=new KeepSaveData();
		this.keepSave.initDefault();
		this.logQueue=new SQueue<InfoLogData>(InfoLogData[]::new);
		this.createDate=new DateData();
		this.createDate.initDefault();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.version=null;
		this.serverTime=0L;
		this.isBlock=false;
		this.flowStep=0;
		this.keepSave=null;
		this.clientRandomSeeds=null;
		this.clientRandomSeedIndex=0;
		this.clientOfflineWorkReceiveIndex=0;
		this.gmCommandSet=null;
		this.gmType=0;
		this.serverBornCode=0;
		this.serverStartTime=0L;
		this.logQueue=null;
		this.nextDailyTime=0L;
		this.createDate=null;
		this.clientRandomSeedKey=0;
	}
	
}