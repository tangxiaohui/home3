using ShineEngine;

/// <summary>
/// 任务数据(已接)(generated by shine)
/// </summary>
public class QuestData:BaseData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.Quest;
	
	/// <summary>
	/// id
	/// </summary>
	public int id;
	
	/// <summary>
	/// 有效时间(0为无限)
	/// </summary>
	public long enableTime;
	
	/// <summary>
	/// 是否失败
	/// </summary>
	public bool isFailed;
	
	/// <summary>
	/// 任务目标组
	/// </summary>
	public TaskData[] tasks;
	
	/// <summary>
	/// 配置
	/// </summary>
	public QuestConfig config;
	
	public QuestData()
	{
		_dataID=BaseDataType.Quest;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "QuestData";
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		this.id=stream.readInt();
		
		int tasksLen=stream.readLen();
		if(this.tasks==null || this.tasks.Length!=tasksLen)
		{
			this.tasks=new TaskData[tasksLen];
		}
		TaskData[] tasksT=this.tasks;
		for(int tasksI=0;tasksI<tasksLen;++tasksI)
		{
			TaskData tasksV;
			tasksV=(TaskData)stream.readDataSimpleNotNull();
			
			tasksT[tasksI]=tasksV;
		}
		
		this.isFailed=stream.readBoolean();
		
		this.enableTime=stream.readLong();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.id);
		
		if(this.tasks!=null)
		{
			TaskData[] tasksT=this.tasks;
			stream.writeLen(tasksT.Length);
			for(int tasksVI=0,tasksVLen=tasksT.Length;tasksVI<tasksVLen;++tasksVI)
			{
				TaskData tasksV=tasksT[tasksVI];
				if(tasksV!=null)
				{
					stream.writeDataSimpleNotNull(tasksV);
				}
				else
				{
					nullObjError("tasksV");
				}
				
			}
		}
		else
		{
			nullObjError("tasks");
		}
		
		stream.writeBoolean(this.isFailed);
		
		stream.writeLong(this.enableTime);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is QuestData))
			return;
		
		QuestData mData=(QuestData)data;
		
		this.id=mData.id;
		this.tasks=mData.tasks;
		this.isFailed=mData.isFailed;
		this.enableTime=mData.enableTime;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is QuestData))
			return;
		
		QuestData mData=(QuestData)data;
		
		this.id=mData.id;
		
		if(mData.tasks!=null)
		{
			TaskData[] tasksR=mData.tasks;
			int tasksLen=tasksR.Length;
			if(this.tasks==null || this.tasks.Length!=tasksLen)
			{
				this.tasks=new TaskData[tasksLen];
			}
			TaskData[] tasksT=this.tasks;
			for(int tasksI=0;tasksI<tasksLen;++tasksI)
			{
				TaskData tasksV=tasksR[tasksI];
				TaskData tasksU;
				if(tasksV!=null)
				{
					tasksU=(TaskData)tasksV.clone();
				}
				else
				{
					tasksU=null;
					nullObjError("tasksU");
				}
				
				tasksT[tasksI]=tasksU;
			}
		}
		else
		{
			this.tasks=null;
			nullObjError("tasks");
		}
		
		this.isFailed=mData.isFailed;
		
		this.enableTime=mData.enableTime;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		QuestData mData=(QuestData)data;
		if(this.id!=mData.id)
			return false;
		
		if(mData.tasks!=null)
		{
			if(this.tasks==null)
				return false;
			if(this.tasks.Length!=mData.tasks.Length)
				return false;
			TaskData[] tasksT=this.tasks;
			TaskData[] tasksR=mData.tasks;
			int tasksLen=tasksT.Length;
			for(int tasksI=0;tasksI<tasksLen;++tasksI)
			{
				TaskData tasksU=tasksT[tasksI];
				TaskData tasksV=tasksR[tasksI];
				if(tasksV!=null)
				{
					if(tasksU==null)
						return false;
					if(!tasksU.dataEquals(tasksV))
						return false;
				}
				else
				{
					if(tasksU!=null)
						return false;
				}
				
			}
		}
		else
		{
			if(this.tasks!=null)
				return false;
		}
		
		if(this.isFailed!=mData.isFailed)
			return false;
		
		if(this.enableTime!=mData.enableTime)
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
		writer.sb.Append("tasks");
		writer.sb.Append(':');
		writer.sb.Append("Array<TaskData>");
		if(this.tasks!=null)
		{
			TaskData[] tasksT=this.tasks;
			int tasksLen=tasksT.Length;
			writer.sb.Append('(');
			writer.sb.Append(tasksLen);
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int tasksI=0;tasksI<tasksLen;++tasksI)
			{
				TaskData tasksV=tasksT[tasksI];
				writer.writeTabs();
				writer.sb.Append(tasksI);
				writer.sb.Append(':');
				if(tasksV!=null)
				{
					tasksV.writeDataString(writer);
				}
				else
				{
					writer.sb.Append("TaskData=null");
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
		writer.sb.Append("isFailed");
		writer.sb.Append(':');
		writer.sb.Append(this.isFailed);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("enableTime");
		writer.sb.Append(':');
		writer.sb.Append(this.enableTime);
		
		writer.writeEnter();
	}
	
	public void makeConfig()
	{
		if(config==null)
		{
			config=QuestConfig.get(id);
		}
	}
	
	public bool isComplete()
	{
		if(config.executeType==QuestExecuteType.Either)
		{
			foreach(TaskData v in tasks)
			{
				if(v.isComplete())
					return true;
			}

			return false;
		}
		else
		{
			foreach(TaskData v in tasks)
			{
				if(!v.isComplete())
					return false;
			}

			return true;
		}

	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		this.tasks=new TaskData[0];
	}
	
	public override void clear()
	{
		config=null;
		enableTime=0L;
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.id=stream.readInt();
		
		int tasksLen=stream.readLen();
		if(this.tasks==null || this.tasks.Length!=tasksLen)
		{
			this.tasks=new TaskData[tasksLen];
		}
		TaskData[] tasksT=this.tasks;
		for(int tasksI=0;tasksI<tasksLen;++tasksI)
		{
			TaskData tasksV;
			BaseData tasksVT=stream.readDataFullNotNull();
			if(tasksVT!=null)
			{
				if(tasksVT is TaskData)
				{
					tasksV=(TaskData)tasksVT;
				}
				else
				{
					tasksV=new TaskData();
					if(!(tasksVT.GetType().IsAssignableFrom(typeof(TaskData))))
					{
						stream.throwTypeReadError(typeof(TaskData),tasksVT.GetType());
					}
					tasksV.shadowCopy(tasksVT);
				}
			}
			else
			{
				tasksV=null;
			}
			
			tasksT[tasksI]=tasksV;
		}
		
		this.isFailed=stream.readBoolean();
		
		this.enableTime=stream.readLong();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.id);
		
		if(this.tasks!=null)
		{
			TaskData[] tasksT=this.tasks;
			stream.writeLen(tasksT.Length);
			for(int tasksVI=0,tasksVLen=tasksT.Length;tasksVI<tasksVLen;++tasksVI)
			{
				TaskData tasksV=tasksT[tasksVI];
				if(tasksV!=null)
				{
					stream.writeDataFullNotNull(tasksV);
				}
				else
				{
					nullObjError("tasksV");
				}
				
			}
		}
		else
		{
			nullObjError("tasks");
		}
		
		stream.writeBoolean(this.isFailed);
		
		stream.writeLong(this.enableTime);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		this.id=0;
		this.tasks=null;
		this.isFailed=false;
		this.enableTime=0L;
	}
	
}