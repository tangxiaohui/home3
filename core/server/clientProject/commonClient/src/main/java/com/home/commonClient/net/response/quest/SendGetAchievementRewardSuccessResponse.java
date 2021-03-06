package com.home.commonClient.net.response.quest;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.base.GameResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 推送领取成就奖励成功消息(generated by shine) */
public class SendGetAchievementRewardSuccessResponse extends GameResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.SendGetAchievementRewardSuccess;
	
	/** id */
	public int id;
	
	public SendGetAchievementRewardSuccessResponse()
	{
		_dataID=GameResponseType.SendGetAchievementRewardSuccess;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.achievement.onGetReward(id);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "SendGetAchievementRewardSuccessResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.id=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("id");
		writer.sb.append(':');
		writer.sb.append(this.id);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.id=0;
	}
	
}
