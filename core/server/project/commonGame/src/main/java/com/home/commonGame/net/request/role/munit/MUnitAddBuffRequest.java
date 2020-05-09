package com.home.commonGame.net.request.role.munit;
import com.home.commonBase.data.scene.base.BuffData;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.base.GameRequest;
import com.home.commonGame.net.request.role.munit.MUnitSRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 主角加buff(generated by shine) */
public class MUnitAddBuffRequest extends MUnitSRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.MUnitAddBuff;
	
	/** buff数据 */
	public BuffData buff;
	
	public MUnitAddBuffRequest()
	{
		_dataID=GameRequestType.MUnitAddBuff;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		BuffData buffTemp=buff;
		if(buffTemp!=null)
		{
			this.buff=(BuffData)buffTemp.clone();
		}
		else
		{
			this.buff=null;
			nullObjError("buff");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "MUnitAddBuffRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("buff");
		writer.sb.append(':');
		if(this.buff!=null)
		{
			this.buff.writeDataString(writer);
		}
		else
		{
			writer.sb.append("BuffData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.buff!=null)
		{
			stream.writeDataFullNotNull(this.buff);
		}
		else
		{
			nullObjError("buff");
		}
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.buff!=null)
		{
			stream.writeDataSimpleNotNull(this.buff);
		}
		else
		{
			nullObjError("buff");
		}
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.buff.release(pool);
		this.buff=null;
	}
	
	/** 创建实例 */
	public static MUnitAddBuffRequest create(int mIndex,BuffData buff)
	{
		MUnitAddBuffRequest re=(MUnitAddBuffRequest)BytesControl.createRequest(dataID);
		re.mIndex=mIndex;
		re.buff=buff;
		return re;
	}
	
}