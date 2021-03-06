using ShineEngine;

/// <summary>
/// 客户端任务目标消息(generated by shine)
/// </summary>
public class ClientTaskEventRequest:GameRequest
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameRequestType.ClientTaskEvent;
	
	/// <summary>
	/// 类型
	/// </summary>
	public int type;
	
	/// <summary>
	/// 参数组
	/// </summary>
	public int[] args;
	
	public ClientTaskEventRequest()
	{
		_dataID=GameRequestType.ClientTaskEvent;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "ClientTaskEventRequest";
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("type");
		writer.sb.Append(':');
		writer.sb.Append(this.type);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("args");
		writer.sb.Append(':');
		writer.sb.Append("Array<int>");
		if(this.args!=null)
		{
			int[] argsT=this.args;
			int argsLen=argsT.Length;
			writer.sb.Append('(');
			writer.sb.Append(argsLen);
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int argsI=0;argsI<argsLen;++argsI)
			{
				int argsV=argsT[argsI];
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
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.type);
		
		if(this.args!=null)
		{
			stream.writeBoolean(true);
			int[] argsT=this.args;
			stream.writeLen(argsT.Length);
			for(int argsVI=0,argsVLen=argsT.Length;argsVI<argsVLen;++argsVI)
			{
				int argsV=argsT[argsVI];
				stream.writeInt(argsV);
				
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.type);
		
		if(this.args!=null)
		{
			stream.writeBoolean(true);
			int[] argsT=this.args;
			stream.writeLen(argsT.Length);
			for(int argsVI=0,argsVLen=argsT.Length;argsVI<argsVLen;++argsVI)
			{
				int argsV=argsT[argsVI];
				stream.writeInt(argsV);
				
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.type=0;
	}
	
	protected override void copyData()
	{
		base.copyData();
		int[] argsTemp=args;
		if(argsTemp!=null)
		{
			int[] argsR=argsTemp;
			int argsLen=argsR.Length;
			this.args=new int[argsLen];
			BytesControl.arrayCopy(argsTemp,this.args,argsLen);
		}
		else
		{
			this.args=null;
		}
		
	}
	
	/// <summary>
	/// 创建实例
	/// </summary>
	public static ClientTaskEventRequest create(int type,int[] args)
	{
		ClientTaskEventRequest re=(ClientTaskEventRequest)BytesControl.createRequest(dataID);
		re.type=type;
		re.args=args;
		return re;
	}
	
}
