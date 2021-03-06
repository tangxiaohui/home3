package com.home.commonGame.net.serverResponse.game.system;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.global.GameC;
import com.home.commonGame.net.serverResponse.game.base.GameToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class SendPlayerCenterRequestListToGameServerResponse extends GameToGameServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.SendPlayerCenterRequestListToGame;
	
	public long playerID;
	
	public byte[][] data;
	
	public SendPlayerCenterRequestListToGameServerResponse()
	{
		_dataID=ServerMessageType.SendPlayerCenterRequestListToGame;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "SendPlayerCenterRequestListToGameServerResponse";
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.playerID=stream.readLong();
		
		int dataLen=stream.readLen();
		if(this.data==null || this.data.length!=dataLen)
		{
			this.data=new byte[dataLen][];
		}
		byte[][] dataT=this.data;
		for(int dataI=0;dataI<dataLen;++dataI)
		{
			byte[] dataV;
			int dataVLen=stream.readLen();
			dataV=stream.readByteArr(dataVLen);
			
			dataT[dataI]=dataV;
		}
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("playerID");
		writer.sb.append(':');
		writer.sb.append(this.playerID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("data");
		writer.sb.append(':');
		writer.sb.append("Array<byte[]>");
		if(this.data!=null)
		{
			byte[][] dataT=this.data;
			int dataLen=dataT.length;
			writer.sb.append('(');
			writer.sb.append(dataLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int dataI=0;dataI<dataLen;++dataI)
			{
				byte[] dataV=dataT[dataI];
				writer.writeTabs();
				writer.sb.append(dataI);
				writer.sb.append(':');
				writer.sb.append("Array<byte>");
				if(dataV!=null)
				{
					byte[] dataVT=dataV;
					int dataVLen=dataVT.length;
					writer.sb.append('(');
					writer.sb.append(dataVLen);
					writer.sb.append(')');
					writer.writeEnter();
					writer.writeLeftBrace();
					for(int dataVI=0;dataVI<dataVLen;++dataVI)
					{
						byte dataVV=dataVT[dataVI];
						writer.writeTabs();
						writer.sb.append(dataVI);
						writer.sb.append(':');
						writer.sb.append(dataVV);
						
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
		for(byte[] v:data)
		{
			GameC.gameSwitch.addPlayerCenterRequest(playerID,v);
		}
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.playerID=0L;
		this.data=null;
	}
	
}
