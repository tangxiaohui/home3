package com.home.commonGame.net.request.func.auction;
import com.home.commonBase.data.item.auction.AuctionItemData;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.request.func.base.FuncSRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.SList;
import com.home.shine.support.pool.DataPool;

/** 返回拍卖行查询结果(generated by shine) */
public class FuncAuctionReQueryRequest extends FuncSRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.FuncAuctionReQuery;
	
	/** 结果页码 */
	public int page;
	
	/** 结果组 */
	public SList<AuctionItemData> resultList;
	
	public FuncAuctionReQueryRequest()
	{
		_dataID=GameRequestType.FuncAuctionReQuery;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		SList<AuctionItemData> resultListTemp=resultList;
		if(resultListTemp!=null)
		{
			this.resultList=new SList<AuctionItemData>(AuctionItemData[]::new,resultListTemp.size());
			SList<AuctionItemData> resultListT=this.resultList;
			if(!resultListTemp.isEmpty())
			{
				Object[] resultListVValues=resultListTemp.getValues();
				for(int resultListVI=0,resultListVLen=resultListTemp.length();resultListVI<resultListVLen;++resultListVI)
				{
					AuctionItemData resultListV=(AuctionItemData)resultListVValues[resultListVI];
					AuctionItemData resultListU;
					if(resultListV!=null)
					{
						resultListU=(AuctionItemData)resultListV.clone();
					}
					else
					{
						resultListU=null;
						nullObjError("resultListU");
					}
					
					resultListT.add(resultListU);
				}
			}
		}
		else
		{
			this.resultList=null;
			nullObjError("resultList");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncAuctionReQueryRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.page);
		
		if(this.resultList!=null)
		{
			stream.writeLen(this.resultList.size());
			if(!this.resultList.isEmpty())
			{
				Object[] resultListVValues=this.resultList.getValues();
				for(int resultListVI=0,resultListVLen=this.resultList.length();resultListVI<resultListVLen;++resultListVI)
				{
					AuctionItemData resultListV=(AuctionItemData)resultListVValues[resultListVI];
					if(resultListV!=null)
					{
						stream.writeDataFullNotNull(resultListV);
					}
					else
					{
						nullObjError("resultListV");
					}
					
				}
			}
		}
		else
		{
			nullObjError("resultList");
		}
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.page);
		
		if(this.resultList!=null)
		{
			stream.writeLen(this.resultList.size());
			if(!this.resultList.isEmpty())
			{
				Object[] resultListVValues=this.resultList.getValues();
				for(int resultListVI=0,resultListVLen=this.resultList.length();resultListVI<resultListVLen;++resultListVI)
				{
					AuctionItemData resultListV=(AuctionItemData)resultListVValues[resultListVI];
					if(resultListV!=null)
					{
						stream.writeDataSimpleNotNull(resultListV);
					}
					else
					{
						nullObjError("resultListV");
					}
					
				}
			}
		}
		else
		{
			nullObjError("resultList");
		}
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("page");
		writer.sb.append(':');
		writer.sb.append(this.page);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("resultList");
		writer.sb.append(':');
		writer.sb.append("List<AuctionItemData>");
		if(this.resultList!=null)
		{
			SList<AuctionItemData> resultListT=this.resultList;
			int resultListLen=resultListT.size();
			writer.sb.append('(');
			writer.sb.append(resultListLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int resultListI=0;resultListI<resultListLen;++resultListI)
			{
				AuctionItemData resultListV=resultListT.get(resultListI);
				writer.writeTabs();
				writer.sb.append(resultListI);
				writer.sb.append(':');
				if(resultListV!=null)
				{
					resultListV.writeDataString(writer);
				}
				else
				{
					writer.sb.append("AuctionItemData=null");
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
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.page=0;
		if(this.resultList!=null)
		{
			if(!this.resultList.isEmpty())
			{
				Object[] resultListVValues=this.resultList.getValues();
				for(int resultListVI=0,resultListVLen=this.resultList.length();resultListVI<resultListVLen;++resultListVI)
				{
					AuctionItemData resultListV=(AuctionItemData)resultListVValues[resultListVI];
					resultListV.release(pool);
					resultListV=null;
					resultListVValues[resultListVI]=null;
				}
			}
			this.resultList.justClearSize();
		}
	}
	
	/** 创建实例 */
	public static FuncAuctionReQueryRequest create(int funcID,int page,SList<AuctionItemData> resultList)
	{
		FuncAuctionReQueryRequest re=(FuncAuctionReQueryRequest)BytesControl.createRequest(dataID);
		re.funcID=funcID;
		re.page=page;
		re.resultList=resultList;
		return re;
	}
	
}
