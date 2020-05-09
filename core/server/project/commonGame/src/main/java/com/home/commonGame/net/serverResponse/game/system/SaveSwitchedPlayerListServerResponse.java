package com.home.commonGame.net.serverResponse.game.system;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.global.GameC;
import com.home.commonGame.net.serverResponse.game.base.GameToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.LongObjectMap;
import com.home.shine.support.pool.DataPool;

/** 保存切换后的角色数据消息(generated by shine) */
public class SaveSwitchedPlayerListServerResponse extends GameToGameServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.SaveSwitchedPlayerList;
	
	/** 数据组(playerID->listData(序列化好的)) */
	public LongObjectMap<byte[]> datas;
	
	public SaveSwitchedPlayerListServerResponse()
	{
		_dataID=ServerMessageType.SaveSwitchedPlayerList;
		setLongMessage();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		int datasLen=stream.readLen();
		if(this.datas!=null)
		{
			this.datas.clear();
			this.datas.ensureCapacity(datasLen);
		}
		else
		{
			this.datas=new LongObjectMap<byte[]>(byte[][]::new,datasLen);
		}
		
		LongObjectMap<byte[]> datasT=this.datas;
		for(int datasI=datasLen-1;datasI>=0;--datasI)
		{
			long datasK;
			byte[] datasV;
			datasK=stream.readLong();
			
			int datasVLen=stream.readLen();
			datasV=stream.readByteArr(datasVLen);
			
			datasT.put(datasK,datasV);
		}
		
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		GameC.gameSwitch.onReceiveSaveSwitchedPlayerList(datas);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "SaveSwitchedPlayerListServerResponse";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("datas");
		writer.sb.append(':');
		writer.sb.append("Map<long,byte[]>");
		if(this.datas!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.datas.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.datas.isEmpty())
			{
				long datasKFreeValue=this.datas.getFreeValue();
				long[] datasKKeys=this.datas.getKeys();
				Object[] datasVValues=this.datas.getValues();
				for(int datasKI=datasKKeys.length-1;datasKI>=0;--datasKI)
				{
					long datasK=datasKKeys[datasKI];
					if(datasK!=datasKFreeValue)
					{
						byte[] datasV=(byte[])datasVValues[datasKI];
						writer.writeTabs();
						writer.sb.append(datasK);
						
						writer.sb.append(':');
						writer.sb.append("Array<byte>");
						if(datasV!=null)
						{
							byte[] datasVT=datasV;
							int datasVLen=datasVT.length;
							writer.sb.append('(');
							writer.sb.append(datasVLen);
							writer.sb.append(')');
							writer.writeEnter();
							writer.writeLeftBrace();
							for(int datasVI=0;datasVI<datasVLen;++datasVI)
							{
								byte datasVV=datasVT[datasVI];
								writer.writeTabs();
								writer.sb.append(datasVI);
								writer.sb.append(':');
								writer.sb.append(datasVV);
								
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
		
		this.datas=null;
	}
	
}