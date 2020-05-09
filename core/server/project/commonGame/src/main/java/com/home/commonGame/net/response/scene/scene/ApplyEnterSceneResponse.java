package com.home.commonGame.net.response.scene.scene;
import com.home.commonGame.constlist.generate.GameResponseType;
import com.home.commonGame.net.base.GameResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 请求进入场景消息(generated by shine) */
public class ApplyEnterSceneResponse extends GameResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.ApplyEnterScene;
	
	/** 场景ID */
	public int id;
	
	/** 线ID */
	public int line=-1;
	
	/** 位置ID */
	public int posID=-1;
	
	public ApplyEnterSceneResponse()
	{
		_dataID=GameResponseType.ApplyEnterScene;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ApplyEnterSceneResponse";
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		me.scene.applyEnterScene(id,line,posID);
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.id=stream.readInt();
		
		this.line=stream.readInt();
		
		this.posID=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.line=stream.readInt();
		
		this.posID=stream.readInt();
		
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
		writer.sb.append("line");
		writer.sb.append(':');
		writer.sb.append(this.line);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("posID");
		writer.sb.append(':');
		writer.sb.append(this.posID);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.id=0;
		this.line=0;
		this.posID=0;
	}
	
}