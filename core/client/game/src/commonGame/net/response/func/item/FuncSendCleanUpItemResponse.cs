using ShineEngine;

/// <summary>
/// 推送整理物品消息(generated by shine)
/// </summary>
public class FuncSendCleanUpItemResponse:FuncSResponse
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameResponseType.FuncSendCleanUpItem;
	
	/// <summary>
	/// 道具组
	/// </summary>
	public SList<ItemData> items;
	
	public FuncSendCleanUpItemResponse()
	{
		_dataID=GameResponseType.FuncSendCleanUpItem;
	}
	
	/// <summary>
	/// 执行
	/// </summary>
	protected override void execute()
	{
		me.func.getItemContainerTool(funcID).onCleanUpByServer(items);
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "FuncSendCleanUpItemResponse";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		if(stream.readBoolean())
		{
			int itemsLen=stream.readLen();
			if(this.items!=null)
			{
				this.items.clear();
				this.items.ensureCapacity(itemsLen);
			}
			else
			{
				this.items=new SList<ItemData>();
			}
			
			SList<ItemData> itemsT=this.items;
			for(int itemsI=itemsLen-1;itemsI>=0;--itemsI)
			{
				ItemData itemsV;
				if(stream.readBoolean())
				{
					BaseData itemsVT=stream.readDataFullNotNull();
					if(itemsVT!=null)
					{
						if(itemsVT is ItemData)
						{
							itemsV=(ItemData)itemsVT;
						}
						else
						{
							itemsV=new ItemData();
							if(!(itemsVT.GetType().IsAssignableFrom(typeof(ItemData))))
							{
								stream.throwTypeReadError(typeof(ItemData),itemsVT.GetType());
							}
							itemsV.shadowCopy(itemsVT);
						}
					}
					else
					{
						itemsV=null;
					}
				}
				else
				{
					itemsV=null;
				}
				
				itemsT.add(itemsV);
			}
		}
		else
		{
			this.items=null;
		}
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		if(stream.readBoolean())
		{
			int itemsLen=stream.readLen();
			if(this.items!=null)
			{
				this.items.clear();
				this.items.ensureCapacity(itemsLen);
			}
			else
			{
				this.items=new SList<ItemData>();
			}
			
			SList<ItemData> itemsT=this.items;
			for(int itemsI=itemsLen-1;itemsI>=0;--itemsI)
			{
				ItemData itemsV;
				if(stream.readBoolean())
				{
					itemsV=(ItemData)stream.readDataSimpleNotNull();
				}
				else
				{
					itemsV=null;
				}
				
				itemsT.add(itemsV);
			}
		}
		else
		{
			this.items=null;
		}
		
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("items");
		writer.sb.Append(':');
		writer.sb.Append("List<ItemData>");
		if(this.items!=null)
		{
			SList<ItemData> itemsT=this.items;
			int itemsLen=itemsT.size();
			writer.sb.Append('(');
			writer.sb.Append(itemsLen);
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int itemsI=0;itemsI<itemsLen;++itemsI)
			{
				ItemData itemsV=itemsT.get(itemsI);
				writer.writeTabs();
				writer.sb.Append(itemsI);
				writer.sb.Append(':');
				if(itemsV!=null)
				{
					itemsV.writeDataString(writer);
				}
				else
				{
					writer.sb.Append("ItemData=null");
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
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.items=null;
	}
	
}
