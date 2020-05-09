package com.home.commonManager.net.serverRequest.game;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.login.ClientVersionData;
import com.home.commonManager.net.serverRequest.game.base.ManagerToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.IntObjectMap;
import com.home.shine.support.pool.DataPool;

/** 游戏服热更消息(generated by shine) */
public class HotfixToGameServerRequest extends ManagerToGameServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.HotfixToGame;
	
	/** 客户端版本 */
	public IntObjectMap<ClientVersionData> clientVersion;
	
	public HotfixToGameServerRequest()
	{
		_dataID=ServerMessageType.HotfixToGame;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		IntObjectMap<ClientVersionData> clientVersionTemp=clientVersion;
		if(clientVersionTemp!=null)
		{
			this.clientVersion=new IntObjectMap<ClientVersionData>(ClientVersionData[]::new,clientVersionTemp.size());
			IntObjectMap<ClientVersionData> clientVersionT=this.clientVersion;
			if(!clientVersionTemp.isEmpty())
			{
				Object[] clientVersionVValues=clientVersionTemp.getValues();
				for(int clientVersionVI=clientVersionVValues.length-1;clientVersionVI>=0;--clientVersionVI)
				{
					if(clientVersionVValues[clientVersionVI]!=null)
					{
						ClientVersionData clientVersionV=(ClientVersionData)clientVersionVValues[clientVersionVI];
						ClientVersionData clientVersionU;
						if(clientVersionV!=null)
						{
							clientVersionU=new ClientVersionData();
							clientVersionU.copy(clientVersionV);
						}
						else
						{
							clientVersionU=null;
							nullObjError("clientVersionU");
						}
						
						clientVersionT.put(clientVersionU.type,clientVersionU);
					}
				}
			}
		}
		else
		{
			this.clientVersion=null;
			nullObjError("clientVersion");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "HotfixToGameServerRequest";
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.clientVersion!=null)
		{
			stream.writeLen(this.clientVersion.size());
			if(!this.clientVersion.isEmpty())
			{
				Object[] clientVersionVValues=this.clientVersion.getValues();
				for(int clientVersionVI=clientVersionVValues.length-1;clientVersionVI>=0;--clientVersionVI)
				{
					if(clientVersionVValues[clientVersionVI]!=null)
					{
						ClientVersionData clientVersionV=(ClientVersionData)clientVersionVValues[clientVersionVI];
						if(clientVersionV!=null)
						{
							clientVersionV.writeBytesSimple(stream);
						}
						else
						{
							nullObjError("clientVersionV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("clientVersion");
		}
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("clientVersion");
		writer.sb.append(':');
		writer.sb.append("Map<int,ClientVersionData>");
		if(this.clientVersion!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.clientVersion.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.clientVersion.isEmpty())
			{
				int clientVersionKFreeValue=this.clientVersion.getFreeValue();
				int[] clientVersionKKeys=this.clientVersion.getKeys();
				Object[] clientVersionVValues=this.clientVersion.getValues();
				for(int clientVersionKI=clientVersionKKeys.length-1;clientVersionKI>=0;--clientVersionKI)
				{
					int clientVersionK=clientVersionKKeys[clientVersionKI];
					if(clientVersionK!=clientVersionKFreeValue)
					{
						ClientVersionData clientVersionV=(ClientVersionData)clientVersionVValues[clientVersionKI];
						writer.writeTabs();
						writer.sb.append(clientVersionK);
						
						writer.sb.append(':');
						if(clientVersionV!=null)
						{
							clientVersionV.writeDataString(writer);
						}
						else
						{
							writer.sb.append("ClientVersionData=null");
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
		
		if(this.clientVersion!=null)
		{
			if(!this.clientVersion.isEmpty())
			{
				int clientVersionKFreeValue=this.clientVersion.getFreeValue();
				int[] clientVersionKKeys=this.clientVersion.getKeys();
				Object[] clientVersionVValues=this.clientVersion.getValues();
				for(int clientVersionKI=clientVersionKKeys.length-1;clientVersionKI>=0;--clientVersionKI)
				{
					int clientVersionK=clientVersionKKeys[clientVersionKI];
					if(clientVersionK!=clientVersionKFreeValue)
					{
						ClientVersionData clientVersionV=(ClientVersionData)clientVersionVValues[clientVersionKI];
						clientVersionV.release(pool);
						clientVersionV=null;
						clientVersionKKeys[clientVersionKI]=clientVersionKFreeValue;
						clientVersionVValues[clientVersionKI]=null;
					}
				}
			}
			this.clientVersion.justClearSize();
		}
	}
	
	/** 创建实例 */
	public static HotfixToGameServerRequest create(IntObjectMap<ClientVersionData> clientVersion)
	{
		HotfixToGameServerRequest re=(HotfixToGameServerRequest)BytesControl.createRequest(dataID);
		re.clientVersion=clientVersion;
		return re;
	}
	
}