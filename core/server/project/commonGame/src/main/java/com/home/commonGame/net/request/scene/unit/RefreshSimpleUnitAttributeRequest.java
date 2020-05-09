package com.home.commonGame.net.request.scene.unit;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.base.GameRequest;
import com.home.commonGame.net.request.scene.base.SceneSRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.IntIntMap;
import com.home.shine.support.pool.DataPool;

/** 刷新简版单位属性消息(generated by shine) */
public class RefreshSimpleUnitAttributeRequest extends SceneSRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.RefreshSimpleUnitAttribute;
	
	public int instanceID;
	
	/** 改变的属性组 */
	public IntIntMap attributes;
	
	public RefreshSimpleUnitAttributeRequest()
	{
		_dataID=GameRequestType.RefreshSimpleUnitAttribute;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		IntIntMap attributesTemp=attributes;
		if(attributesTemp!=null)
		{
			this.attributes=new IntIntMap(attributesTemp.size());
			IntIntMap attributesT=this.attributes;
			if(!attributesTemp.isEmpty())
			{
				int attributesKFreeValue=attributesTemp.getFreeValue();
				long[] attributesKTable=attributesTemp.getTable();
				long attributesKEntry;
				for(int attributesKI=attributesKTable.length-1;attributesKI>=0;--attributesKI)
				{
					attributesKEntry=attributesKTable[attributesKI];
					int attributesK=(int)attributesKEntry;
					if(attributesK!=attributesKFreeValue)
					{
						int attributesV=(int)(attributesKEntry>>>32);
						int attributesW;
						int attributesU;
						attributesW=attributesK;
						
						attributesU=attributesV;
						
						attributesT.put(attributesW,attributesU);
					}
				}
			}
		}
		else
		{
			this.attributes=null;
			nullObjError("attributes");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "RefreshSimpleUnitAttributeRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.instanceID);
		
		if(this.attributes!=null)
		{
			stream.writeLen(this.attributes.size());
			if(!this.attributes.isEmpty())
			{
				int attributesKFreeValue=this.attributes.getFreeValue();
				long[] attributesKTable=this.attributes.getTable();
				long attributesKEntry;
				for(int attributesKI=attributesKTable.length-1;attributesKI>=0;--attributesKI)
				{
					attributesKEntry=attributesKTable[attributesKI];
					int attributesK=(int)attributesKEntry;
					if(attributesK!=attributesKFreeValue)
					{
						int attributesV=(int)(attributesKEntry>>>32);
						stream.writeInt(attributesK);
						
						stream.writeInt(attributesV);
						
					}
				}
			}
		}
		else
		{
			nullObjError("attributes");
		}
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.instanceID);
		
		if(this.attributes!=null)
		{
			stream.writeLen(this.attributes.size());
			if(!this.attributes.isEmpty())
			{
				int attributesKFreeValue=this.attributes.getFreeValue();
				long[] attributesKTable=this.attributes.getTable();
				long attributesKEntry;
				for(int attributesKI=attributesKTable.length-1;attributesKI>=0;--attributesKI)
				{
					attributesKEntry=attributesKTable[attributesKI];
					int attributesK=(int)attributesKEntry;
					if(attributesK!=attributesKFreeValue)
					{
						int attributesV=(int)(attributesKEntry>>>32);
						stream.writeInt(attributesK);
						
						stream.writeInt(attributesV);
						
					}
				}
			}
		}
		else
		{
			nullObjError("attributes");
		}
		
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("instanceID");
		writer.sb.append(':');
		writer.sb.append(this.instanceID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("attributes");
		writer.sb.append(':');
		writer.sb.append("Map<int,int>");
		if(this.attributes!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.attributes.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.attributes.isEmpty())
			{
				int attributesKFreeValue=this.attributes.getFreeValue();
				long[] attributesKTable=this.attributes.getTable();
				long attributesKEntry;
				for(int attributesKI=attributesKTable.length-1;attributesKI>=0;--attributesKI)
				{
					attributesKEntry=attributesKTable[attributesKI];
					int attributesK=(int)attributesKEntry;
					if(attributesK!=attributesKFreeValue)
					{
						int attributesV=(int)(attributesKEntry>>>32);
						writer.writeTabs();
						writer.sb.append(attributesK);
						
						writer.sb.append(':');
						writer.sb.append(attributesV);
						
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
		
		this.instanceID=0;
		if(this.attributes!=null)
		{
			this.attributes.clear();
		}
	}
	
	/** 创建实例 */
	public static RefreshSimpleUnitAttributeRequest create(int instanceID,IntIntMap attributes)
	{
		RefreshSimpleUnitAttributeRequest re=(RefreshSimpleUnitAttributeRequest)BytesControl.createRequest(dataID);
		re.instanceID=instanceID;
		re.attributes=attributes;
		return re;
	}
	
}