using ShineEngine;

/// <summary>
/// 查询角色结果数据(generated by shine)
/// </summary>
public class QueryPlayerResultData:BaseData
{
	/// <summary>
	/// 查询参数组
	/// </summary>
	public int[] queryArgs;
	
	/// <summary>
	/// 查询类型
	/// </summary>
	public int queryType;
	
	/// <summary>
	/// 被查询角色ID
	/// </summary>
	public long queryPlayerID;
	
	/// <summary>
	/// 是否有该角色
	/// </summary>
	public bool isSuccess;
	
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.QueryPlayerResult;
	
	public QueryPlayerResultData()
	{
		_dataID=BaseDataType.QueryPlayerResult;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "QueryPlayerResultData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.queryPlayerID=stream.readLong();
		
		this.queryType=stream.readInt();
		
		if(stream.readBoolean())
		{
			int queryArgsLen=stream.readLen();
			if(this.queryArgs==null || this.queryArgs.Length!=queryArgsLen)
			{
				this.queryArgs=new int[queryArgsLen];
			}
			int[] queryArgsT=this.queryArgs;
			for(int queryArgsI=0;queryArgsI<queryArgsLen;++queryArgsI)
			{
				int queryArgsV;
				queryArgsV=stream.readInt();
				
				queryArgsT[queryArgsI]=queryArgsV;
			}
		}
		else
		{
			this.queryArgs=null;
		}
		
		this.isSuccess=stream.readBoolean();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeLong(this.queryPlayerID);
		
		stream.writeInt(this.queryType);
		
		if(this.queryArgs!=null)
		{
			stream.writeBoolean(true);
			int[] queryArgsT=this.queryArgs;
			stream.writeLen(queryArgsT.Length);
			for(int queryArgsVI=0,queryArgsVLen=queryArgsT.Length;queryArgsVI<queryArgsVLen;++queryArgsVI)
			{
				int queryArgsV=queryArgsT[queryArgsVI];
				stream.writeInt(queryArgsV);
				
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeBoolean(this.isSuccess);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		this.queryPlayerID=stream.readLong();
		
		this.queryType=stream.readInt();
		
		if(stream.readBoolean())
		{
			int queryArgsLen=stream.readLen();
			if(this.queryArgs==null || this.queryArgs.Length!=queryArgsLen)
			{
				this.queryArgs=new int[queryArgsLen];
			}
			int[] queryArgsT=this.queryArgs;
			for(int queryArgsI=0;queryArgsI<queryArgsLen;++queryArgsI)
			{
				int queryArgsV;
				queryArgsV=stream.readInt();
				
				queryArgsT[queryArgsI]=queryArgsV;
			}
		}
		else
		{
			this.queryArgs=null;
		}
		
		this.isSuccess=stream.readBoolean();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeLong(this.queryPlayerID);
		
		stream.writeInt(this.queryType);
		
		if(this.queryArgs!=null)
		{
			stream.writeBoolean(true);
			int[] queryArgsT=this.queryArgs;
			stream.writeLen(queryArgsT.Length);
			for(int queryArgsVI=0,queryArgsVLen=queryArgsT.Length;queryArgsVI<queryArgsVLen;++queryArgsVI)
			{
				int queryArgsV=queryArgsT[queryArgsVI];
				stream.writeInt(queryArgsV);
				
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeBoolean(this.isSuccess);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is QueryPlayerResultData))
			return;
		
		QueryPlayerResultData mData=(QueryPlayerResultData)data;
		
		this.queryPlayerID=mData.queryPlayerID;
		this.queryType=mData.queryType;
		this.queryArgs=mData.queryArgs;
		this.isSuccess=mData.isSuccess;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is QueryPlayerResultData))
			return;
		
		QueryPlayerResultData mData=(QueryPlayerResultData)data;
		
		this.queryPlayerID=mData.queryPlayerID;
		
		this.queryType=mData.queryType;
		
		if(mData.queryArgs!=null)
		{
			int[] queryArgsR=mData.queryArgs;
			int queryArgsLen=queryArgsR.Length;
			if(this.queryArgs==null || this.queryArgs.Length!=queryArgsLen)
			{
				this.queryArgs=new int[queryArgsLen];
			}
			BytesControl.arrayCopy(mData.queryArgs,this.queryArgs,queryArgsLen);
		}
		else
		{
			this.queryArgs=null;
		}
		
		this.isSuccess=mData.isSuccess;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		QueryPlayerResultData mData=(QueryPlayerResultData)data;
		if(this.queryPlayerID!=mData.queryPlayerID)
			return false;
		
		if(this.queryType!=mData.queryType)
			return false;
		
		if(mData.queryArgs!=null)
		{
			if(this.queryArgs==null)
				return false;
			if(this.queryArgs.Length!=mData.queryArgs.Length)
				return false;
			int[] queryArgsT=this.queryArgs;
			int[] queryArgsR=mData.queryArgs;
			int queryArgsLen=queryArgsT.Length;
			for(int queryArgsI=0;queryArgsI<queryArgsLen;++queryArgsI)
			{
				int queryArgsU=queryArgsT[queryArgsI];
				int queryArgsV=queryArgsR[queryArgsI];
				if(queryArgsU!=queryArgsV)
					return false;
				
			}
		}
		else
		{
			if(this.queryArgs!=null)
				return false;
		}
		
		if(this.isSuccess!=mData.isSuccess)
			return false;
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.Append("queryPlayerID");
		writer.sb.Append(':');
		writer.sb.Append(this.queryPlayerID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("queryType");
		writer.sb.Append(':');
		writer.sb.Append(this.queryType);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("queryArgs");
		writer.sb.Append(':');
		writer.sb.Append("Array<int>");
		if(this.queryArgs!=null)
		{
			int[] queryArgsT=this.queryArgs;
			int queryArgsLen=queryArgsT.Length;
			writer.sb.Append('(');
			writer.sb.Append(queryArgsLen);
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int queryArgsI=0;queryArgsI<queryArgsLen;++queryArgsI)
			{
				int queryArgsV=queryArgsT[queryArgsI];
				writer.writeTabs();
				writer.sb.Append(queryArgsI);
				writer.sb.Append(':');
				writer.sb.Append(queryArgsV);
				
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
		writer.sb.Append("isSuccess");
		writer.sb.Append(':');
		writer.sb.Append(this.isSuccess);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		this.queryPlayerID=0L;
		this.queryType=0;
		this.queryArgs=null;
		this.isSuccess=false;
	}
	
}
