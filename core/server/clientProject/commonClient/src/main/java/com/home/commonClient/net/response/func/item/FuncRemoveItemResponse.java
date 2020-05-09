package com.home.commonClient.net.response.func.item;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.base.GameResponse;
import com.home.commonClient.net.response.func.base.FuncSResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.IntIntMap;
import com.home.shine.support.pool.DataPool;

/** 移除物品消息(generated by shine) */
public class FuncRemoveItemResponse extends FuncSResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.FuncRemoveItem;
	
	/** 途径 */
	public int way;
	
	/** 移除序号数目组 */
	public IntIntMap dic;
	
	public FuncRemoveItemResponse()
	{
		_dataID=GameResponseType.FuncRemoveItem;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.func.getBaseItemContainerTool(funcID).onRemoveItemsByServer(dic,way);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncRemoveItemResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.way=stream.readInt();
		
		int dicLen=stream.readLen();
		if(this.dic!=null)
		{
			this.dic.clear();
			this.dic.ensureCapacity(dicLen);
		}
		else
		{
			this.dic=new IntIntMap(dicLen);
		}
		
		IntIntMap dicT=this.dic;
		for(int dicI=dicLen-1;dicI>=0;--dicI)
		{
			int dicK;
			int dicV;
			dicK=stream.readInt();
			
			dicV=stream.readInt();
			
			dicT.put(dicK,dicV);
		}
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.way=stream.readInt();
		
		int dicLen=stream.readLen();
		if(this.dic!=null)
		{
			this.dic.clear();
			this.dic.ensureCapacity(dicLen);
		}
		else
		{
			this.dic=new IntIntMap(dicLen);
		}
		
		IntIntMap dicT=this.dic;
		for(int dicI=dicLen-1;dicI>=0;--dicI)
		{
			int dicK;
			int dicV;
			dicK=stream.readInt();
			
			dicV=stream.readInt();
			
			dicT.put(dicK,dicV);
		}
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("way");
		writer.sb.append(':');
		writer.sb.append(this.way);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("dic");
		writer.sb.append(':');
		writer.sb.append("Map<int,int>");
		if(this.dic!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.dic.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.dic.isEmpty())
			{
				int dicKFreeValue=this.dic.getFreeValue();
				long[] dicKTable=this.dic.getTable();
				long dicKEntry;
				for(int dicKI=dicKTable.length-1;dicKI>=0;--dicKI)
				{
					dicKEntry=dicKTable[dicKI];
					int dicK=(int)dicKEntry;
					if(dicK!=dicKFreeValue)
					{
						int dicV=(int)(dicKEntry>>>32);
						writer.writeTabs();
						writer.sb.append(dicK);
						
						writer.sb.append(':');
						writer.sb.append(dicV);
						
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
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.way=0;
		this.dic=null;
	}
	
}