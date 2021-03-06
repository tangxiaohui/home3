package com.home.commonClient.net.response.quest;
import com.home.commonBase.data.quest.QuestData;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.base.GameResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送接任务消息(generated by shine) */
public class SendAcceptQuestResponse extends GameResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.SendAcceptQuest;
	
	/** 任务数据 */
	public QuestData data;
	
	public SendAcceptQuestResponse()
	{
		_dataID=GameResponseType.SendAcceptQuest;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.quest.onAcceptQuest(data);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "SendAcceptQuestResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		BaseData dataT=stream.readDataFullNotNull();
		if(dataT!=null)
		{
			if(dataT instanceof QuestData)
			{
				this.data=(QuestData)dataT;
			}
			else
			{
				this.data=new QuestData();
				if(!(dataT.getClass().isAssignableFrom(QuestData.class)))
				{
					stream.throwTypeReadError(QuestData.class,dataT.getClass());
				}
				this.data.shadowCopy(dataT);
			}
		}
		else
		{
			this.data=null;
		}
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.data=(QuestData)stream.readDataSimpleNotNull();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("data");
		writer.sb.append(':');
		if(this.data!=null)
		{
			this.data.writeDataString(writer);
		}
		else
		{
			writer.sb.append("QuestData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.data=null;
	}
	
}
