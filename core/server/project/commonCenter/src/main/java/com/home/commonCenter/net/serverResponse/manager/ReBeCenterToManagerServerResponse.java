package com.home.commonCenter.net.serverResponse.manager;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.system.ServerInfoData;
import com.home.commonCenter.global.CenterC;
import com.home.commonCenter.net.base.CenterServerResponse;
import com.home.commonCenter.net.serverResponse.manager.base.ManagerToCenterServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.constlist.SocketType;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.IntIntMap;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class ReBeCenterToManagerServerResponse extends ManagerToCenterServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.ReBeCenterToManager;
	
	/** 服务器信息 */
	public ServerInfoData info;
	
	/** 区服字典(areaID:gameID) */
	public IntIntMap areaDic;
	
	public ReBeCenterToManagerServerResponse()
	{
		_dataID=ServerMessageType.ReBeCenterToManager;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ReBeCenterToManagerServerResponse";
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		if(stream.readBoolean())
		{
			this.info=(ServerInfoData)stream.readDataSimpleNotNull();
		}
		else
		{
			this.info=null;
		}
		
		int areaDicLen=stream.readLen();
		if(this.areaDic!=null)
		{
			this.areaDic.clear();
			this.areaDic.ensureCapacity(areaDicLen);
		}
		else
		{
			this.areaDic=new IntIntMap(areaDicLen);
		}
		
		IntIntMap areaDicT=this.areaDic;
		for(int areaDicI=areaDicLen-1;areaDicI>=0;--areaDicI)
		{
			int areaDicK;
			int areaDicV;
			areaDicK=stream.readInt();
			
			areaDicV=stream.readInt();
			
			areaDicT.put(areaDicK,areaDicV);
		}
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("info");
		writer.sb.append(':');
		if(this.info!=null)
		{
			this.info.writeDataString(writer);
		}
		else
		{
			writer.sb.append("ServerInfoData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("areaDic");
		writer.sb.append(':');
		writer.sb.append("Map<int,int>");
		if(this.areaDic!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.areaDic.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.areaDic.isEmpty())
			{
				int areaDicKFreeValue=this.areaDic.getFreeValue();
				long[] areaDicKTable=this.areaDic.getTable();
				long areaDicKEntry;
				for(int areaDicKI=areaDicKTable.length-1;areaDicKI>=0;--areaDicKI)
				{
					areaDicKEntry=areaDicKTable[areaDicKI];
					int areaDicK=(int)areaDicKEntry;
					if(areaDicK!=areaDicKFreeValue)
					{
						int areaDicV=(int)(areaDicKEntry>>>32);
						writer.writeTabs();
						writer.sb.append(areaDicK);
						
						writer.sb.append(':');
						writer.sb.append(areaDicV);
						
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
	
	/** 执行 */
	@Override
	protected void execute()
	{
		CenterC.server.reBack(SocketType.Manager);
		
		CenterC.main.setAreaDic(areaDic);
		
		if(info!=null)
		{
			CenterC.server.setSelfInfo(info);
		}
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.info=null;
		this.areaDic=null;
	}
	
}
