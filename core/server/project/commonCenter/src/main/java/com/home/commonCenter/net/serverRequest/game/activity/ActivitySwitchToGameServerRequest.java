package com.home.commonCenter.net.serverRequest.game.activity;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonCenter.net.serverRequest.game.base.CenterToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 活动切换开启/关闭(generated by shine) */
public class ActivitySwitchToGameServerRequest extends CenterToGameServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.ActivitySwitchToGame;
	
	/** 活动ID */
	public int id;
	
	/** 是否开启 */
	public boolean isRunning;
	
	/** 上次触发时间 */
	public long lastTurnTime;
	
	/** 下次触发时间 */
	public long nextTurnTime;
	
	/** 是否到时间自然触发 */
	public boolean atTime;
	
	public ActivitySwitchToGameServerRequest()
	{
		_dataID=ServerMessageType.ActivitySwitchToGame;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ActivitySwitchToGameServerRequest";
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeBoolean(this.isRunning);
		
		stream.writeLong(this.lastTurnTime);
		
		stream.writeLong(this.nextTurnTime);
		
		stream.writeBoolean(this.atTime);
		
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
		writer.writeTabs();
		writer.sb.append("isRunning");
		writer.sb.append(':');
		writer.sb.append(this.isRunning);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("lastTurnTime");
		writer.sb.append(':');
		writer.sb.append(this.lastTurnTime);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("nextTurnTime");
		writer.sb.append(':');
		writer.sb.append(this.nextTurnTime);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("atTime");
		writer.sb.append(':');
		writer.sb.append(this.atTime);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.id=0;
		this.isRunning=false;
		this.lastTurnTime=0L;
		this.nextTurnTime=0L;
		this.atTime=false;
	}
	
	/** 创建实例 */
	public static ActivitySwitchToGameServerRequest create(int id,boolean isRunning,long lastTurnTime,long nextTurnTime,boolean atTime)
	{
		ActivitySwitchToGameServerRequest re=(ActivitySwitchToGameServerRequest)BytesControl.createRequest(dataID);
		re.id=id;
		re.isRunning=isRunning;
		re.lastTurnTime=lastTurnTime;
		re.nextTurnTime=nextTurnTime;
		re.atTime=atTime;
		return re;
	}
	
}