using ShineEngine;

/// <summary>
/// 使用物品消息(generated by shine)
/// </summary>
public class FuncUseItemRequest:FuncRRequest
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameRequestType.FuncUseItem;
	
	/// <summary>
	/// 格子序号
	/// </summary>
	public int index;
	
	/// <summary>
	/// 数目
	/// </summary>
	public int num;
	
	/// <summary>
	/// 道具ID(检验用)
	/// </summary>
	public int itemID;
	
	/// <summary>
	/// 额外使用参数
	/// </summary>
	public UseItemArgData arg;
	
	public FuncUseItemRequest()
	{
		_dataID=GameRequestType.FuncUseItem;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "FuncUseItemRequest";
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("index");
		writer.sb.Append(':');
		writer.sb.Append(this.index);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("num");
		writer.sb.Append(':');
		writer.sb.Append(this.num);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("itemID");
		writer.sb.Append(':');
		writer.sb.Append(this.itemID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("arg");
		writer.sb.Append(':');
		if(this.arg!=null)
		{
			this.arg.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("UseItemArgData=null");
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
		
		stream.writeInt(this.index);
		
		stream.writeInt(this.num);
		
		stream.writeInt(this.itemID);
		
		if(this.arg!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataFullNotNull(this.arg);
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
		
		stream.writeInt(this.index);
		
		stream.writeInt(this.num);
		
		stream.writeInt(this.itemID);
		
		if(this.arg!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataSimpleNotNull(this.arg);
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
		
		this.index=0;
		this.num=0;
		this.itemID=0;
		if(this.arg!=null)
		{
			this.arg.release(pool);
			this.arg=null;
		}
	}
	
	protected override void copyData()
	{
		base.copyData();
		UseItemArgData argTemp=arg;
		if(argTemp!=null)
		{
			this.arg=(UseItemArgData)argTemp.clone();
		}
		else
		{
			this.arg=null;
		}
		
	}
	
	/// <summary>
	/// 创建实例
	/// </summary>
	public static FuncUseItemRequest create(int funcID,int index,int num,int itemID,UseItemArgData arg)
	{
		FuncUseItemRequest re=(FuncUseItemRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.index=index;
		re.num=num;
		re.itemID=itemID;
		re.arg=arg;
		return re;
	}
	
}
