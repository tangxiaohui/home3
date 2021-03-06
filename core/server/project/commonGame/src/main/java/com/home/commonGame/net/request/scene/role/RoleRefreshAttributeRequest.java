package com.home.commonGame.net.request.scene.role;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.request.scene.base.RoleSRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.IntIntMap;
import com.home.shine.support.pool.DataPool;

/** 角色刷新属性(generated by shine) */
public class RoleRefreshAttributeRequest extends RoleSRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.RoleRefreshAttribute;
	
	/** 改变的属性组 */
	public IntIntMap attributes;
	
	public RoleRefreshAttributeRequest()
	{
		_dataID=GameRequestType.RoleRefreshAttribute;
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
		return "RoleRefreshAttributeRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
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
		
		if(this.attributes!=null)
		{
			this.attributes.clear();
		}
	}
	
	/** 创建实例 */
	public static RoleRefreshAttributeRequest create(long playerID,IntIntMap attributes)
	{
		RoleRefreshAttributeRequest re=(RoleRefreshAttributeRequest)BytesControl.createRequest(dataID);
		re.playerID=playerID;
		re.attributes=attributes;
		return re;
	}
	
}
