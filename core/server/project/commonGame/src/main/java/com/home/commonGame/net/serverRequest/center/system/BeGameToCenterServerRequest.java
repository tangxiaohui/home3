package com.home.commonGame.net.serverRequest.center.system;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonGame.net.base.GameServerRequest;
import com.home.commonGame.net.serverRequest.center.base.GameToCenterServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class BeGameToCenterServerRequest extends GameToCenterServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.BeGameToCenter;
	
	/** 是否第一次连接 */
	public boolean isFirst;
	
	public int id;
	
	public BeGameToCenterServerRequest()
	{
		_dataID=ServerMessageType.BeGameToCenter;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeBoolean(this.isFirst);
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "BeGameToCenterServerRequest";
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
		writer.sb.append("isFirst");
		writer.sb.append(':');
		writer.sb.append(this.isFirst);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.id=0;
		this.isFirst=false;
	}
	
	/** 创建实例 */
	public static BeGameToCenterServerRequest create(int id,boolean isFirst)
	{
		BeGameToCenterServerRequest re=(BeGameToCenterServerRequest)BytesControl.createRequest(dataID);
		re.id=id;
		re.isFirst=isFirst;
		return re;
	}
	
}