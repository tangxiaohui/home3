package com.home.commonClient.net.centerResponse.func.match;
import com.home.commonBase.data.scene.match.PlayerMatchData;
import com.home.commonClient.constlist.generate.CenterResponseType;
import com.home.commonClient.net.base.CenterResponse;
import com.home.commonClient.net.centerResponse.func.base.FuncFromCenterSResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.SList;
import com.home.shine.support.pool.DataPool;

/** 匹配成功到game(generated by shine) */
public class FuncMatchSuccessFromCenterResponse extends FuncFromCenterSResponse
{
	/** 数据类型ID */
	public static final int dataID=CenterResponseType.FuncMatchSuccessFromCenter;
	
	/** 匹配序号 */
	public int index;
	
	/** 匹配数据组 */
	public PlayerMatchData[] matchDatas;
	
	public FuncMatchSuccessFromCenterResponse()
	{
		_dataID=CenterResponseType.FuncMatchSuccessFromCenter;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.scene.onMatchSuccess(funcID,index,matchDatas);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "FuncMatchSuccessFromCenterResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.index=stream.readInt();
		
		int matchDatasLen=stream.readLen();
		if(this.matchDatas==null || this.matchDatas.length!=matchDatasLen)
		{
			this.matchDatas=new PlayerMatchData[matchDatasLen];
		}
		PlayerMatchData[] matchDatasT=this.matchDatas;
		for(int matchDatasI=0;matchDatasI<matchDatasLen;++matchDatasI)
		{
			PlayerMatchData matchDatasV;
			BaseData matchDatasVT=stream.readDataFullNotNull();
			if(matchDatasVT!=null)
			{
				if(matchDatasVT instanceof PlayerMatchData)
				{
					matchDatasV=(PlayerMatchData)matchDatasVT;
				}
				else
				{
					matchDatasV=new PlayerMatchData();
					if(!(matchDatasVT.getClass().isAssignableFrom(PlayerMatchData.class)))
					{
						stream.throwTypeReadError(PlayerMatchData.class,matchDatasVT.getClass());
					}
					matchDatasV.shadowCopy(matchDatasVT);
				}
			}
			else
			{
				matchDatasV=null;
			}
			
			matchDatasT[matchDatasI]=matchDatasV;
		}
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.index=stream.readInt();
		
		int matchDatasLen=stream.readLen();
		if(this.matchDatas==null || this.matchDatas.length!=matchDatasLen)
		{
			this.matchDatas=new PlayerMatchData[matchDatasLen];
		}
		PlayerMatchData[] matchDatasT=this.matchDatas;
		for(int matchDatasI=0;matchDatasI<matchDatasLen;++matchDatasI)
		{
			PlayerMatchData matchDatasV;
			matchDatasV=(PlayerMatchData)stream.readDataSimpleNotNull();
			
			matchDatasT[matchDatasI]=matchDatasV;
		}
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("index");
		writer.sb.append(':');
		writer.sb.append(this.index);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("matchDatas");
		writer.sb.append(':');
		writer.sb.append("Array<PlayerMatchData>");
		if(this.matchDatas!=null)
		{
			PlayerMatchData[] matchDatasT=this.matchDatas;
			int matchDatasLen=matchDatasT.length;
			writer.sb.append('(');
			writer.sb.append(matchDatasLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int matchDatasI=0;matchDatasI<matchDatasLen;++matchDatasI)
			{
				PlayerMatchData matchDatasV=matchDatasT[matchDatasI];
				writer.writeTabs();
				writer.sb.append(matchDatasI);
				writer.sb.append(':');
				if(matchDatasV!=null)
				{
					matchDatasV.writeDataString(writer);
				}
				else
				{
					writer.sb.append("PlayerMatchData=null");
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
		
		this.index=0;
		this.matchDatas=null;
	}
	
}