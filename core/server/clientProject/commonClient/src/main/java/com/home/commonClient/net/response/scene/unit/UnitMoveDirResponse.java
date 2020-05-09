package com.home.commonClient.net.response.scene.unit;
import com.home.commonBase.data.scene.base.DirData;
import com.home.commonClient.constlist.generate.GameResponseType;
import com.home.commonClient.net.response.scene.base.UnitSResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 单位移动朝向消息(generated by shine) */
public class UnitMoveDirResponse extends UnitSResponse
{
	/** 数据类型ID */
	public static final int dataID=GameResponseType.UnitMoveDir;
	
	/** 移动类型 */
	public int type;
	
	/** 实际移动朝向 */
	public DirData realMoveDir;
	
	/** 实际移动速度比率 */
	public int realMoveSpeedRatio;
	
	/** 目标朝向 */
	public DirData dir;
	
	public UnitMoveDirResponse()
	{
		_dataID=GameResponseType.UnitMoveDir;
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		scene.getFightUnitAbs(instanceID).move.onServerMoveDir(type,dir,realMoveDir,realMoveSpeedRatio);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "UnitMoveDirResponse";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.type=stream.readInt();
		
		this.dir=new DirData();
		this.dir.readBytesFull(stream);
		
		if(stream.readBoolean())
		{
			this.realMoveDir=new DirData();
			this.realMoveDir.readBytesFull(stream);
		}
		else
		{
			this.realMoveDir=null;
		}
		
		this.realMoveSpeedRatio=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.type=stream.readInt();
		
		this.dir=new DirData();
		this.dir.readBytesSimple(stream);
		
		if(stream.readBoolean())
		{
			this.realMoveDir=new DirData();
			this.realMoveDir.readBytesSimple(stream);
		}
		else
		{
			this.realMoveDir=null;
		}
		
		this.realMoveSpeedRatio=stream.readInt();
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("type");
		writer.sb.append(':');
		writer.sb.append(this.type);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("dir");
		writer.sb.append(':');
		if(this.dir!=null)
		{
			this.dir.writeDataString(writer);
		}
		else
		{
			writer.sb.append("DirData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("realMoveDir");
		writer.sb.append(':');
		if(this.realMoveDir!=null)
		{
			this.realMoveDir.writeDataString(writer);
		}
		else
		{
			writer.sb.append("DirData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("realMoveSpeedRatio");
		writer.sb.append(':');
		writer.sb.append(this.realMoveSpeedRatio);
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.type=0;
		this.dir=null;
		this.realMoveDir=null;
		this.realMoveSpeedRatio=0;
	}
	
}