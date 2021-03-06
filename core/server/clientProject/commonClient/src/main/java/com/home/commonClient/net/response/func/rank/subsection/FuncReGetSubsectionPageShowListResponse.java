package com.home.commonClient.net.response.func.rank.subsection;
import com.home.commonBase.data.system.KeyData;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.response.func.base.FuncSResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.SList;
import com.home.shine.support.pool.DataPool;

/** 推送获取分段翻页显示内容，无缓存方式(generated by shine) */
public class FuncReGetSubsectionPageShowListResponse extends FuncSResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.FuncReGetSubsectionPageShowList;
	
	/** 大组index */
	public int subsectionIndex;
	
	/** 小组index */
	public int subsectionSubIndex;
	
	/** 页码 */
	public int page;
	
	/** 参数 */
	public int arg;
	
	/** 数据组 */
	public SList<KeyData> list;
	
	public FuncReGetSubsectionPageShowListResponse()
	{
		_dataID=GameResponseType.FuncReGetSubsectionPageShowList;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncReGetSubsectionPageShowListResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.subsectionIndex=stream.readInt();
		
		this.subsectionSubIndex=stream.readInt();
		
		this.page=stream.readInt();
		
		this.arg=stream.readInt();
		
		if(stream.readBoolean())
		{
			int listLen=stream.readLen();
			if(this.list!=null)
			{
				this.list.clear();
				this.list.ensureCapacity(listLen);
			}
			else
			{
				this.list=new SList<KeyData>(KeyData[]::new,listLen);
			}
			
			SList<KeyData> listT=this.list;
			for(int listI=listLen-1;listI>=0;--listI)
			{
				KeyData listV;
				if(stream.readBoolean())
				{
					BaseData listVT=stream.readDataFullNotNull();
					if(listVT!=null)
					{
						if(listVT instanceof KeyData)
						{
							listV=(KeyData)listVT;
						}
						else
						{
							listV=new KeyData();
							if(!(listVT.getClass().isAssignableFrom(KeyData.class)))
							{
								stream.throwTypeReadError(KeyData.class,listVT.getClass());
							}
							listV.shadowCopy(listVT);
						}
					}
					else
					{
						listV=null;
					}
				}
				else
				{
					listV=null;
				}
				
				listT.add(listV);
			}
		}
		else
		{
			this.list=null;
		}
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.subsectionIndex=stream.readInt();
		
		this.subsectionSubIndex=stream.readInt();
		
		this.page=stream.readInt();
		
		this.arg=stream.readInt();
		
		if(stream.readBoolean())
		{
			int listLen=stream.readLen();
			if(this.list!=null)
			{
				this.list.clear();
				this.list.ensureCapacity(listLen);
			}
			else
			{
				this.list=new SList<KeyData>(KeyData[]::new,listLen);
			}
			
			SList<KeyData> listT=this.list;
			for(int listI=listLen-1;listI>=0;--listI)
			{
				KeyData listV;
				if(stream.readBoolean())
				{
					listV=(KeyData)stream.readDataSimpleNotNull();
				}
				else
				{
					listV=null;
				}
				
				listT.add(listV);
			}
		}
		else
		{
			this.list=null;
		}
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("subsectionIndex");
		writer.sb.append(':');
		writer.sb.append(this.subsectionIndex);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("subsectionSubIndex");
		writer.sb.append(':');
		writer.sb.append(this.subsectionSubIndex);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("page");
		writer.sb.append(':');
		writer.sb.append(this.page);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("arg");
		writer.sb.append(':');
		writer.sb.append(this.arg);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("list");
		writer.sb.append(':');
		writer.sb.append("List<KeyData>");
		if(this.list!=null)
		{
			SList<KeyData> listT=this.list;
			int listLen=listT.size();
			writer.sb.append('(');
			writer.sb.append(listLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int listI=0;listI<listLen;++listI)
			{
				KeyData listV=listT.get(listI);
				writer.writeTabs();
				writer.sb.append(listI);
				writer.sb.append(':');
				if(listV!=null)
				{
					listV.writeDataString(writer);
				}
				else
				{
					writer.sb.append("KeyData=null");
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
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.subsectionIndex=0;
		this.subsectionSubIndex=0;
		this.page=0;
		this.arg=0;
		this.list=null;
	}
	
}
