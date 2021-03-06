package com.home.commonGame.net.request.social;
import com.home.commonBase.data.social.RoleSocialData;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.base.GameRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.LongObjectMap;
import com.home.shine.support.pool.DataPool;

/** 回复更新社交数据消息(generated by shine) */
public class ReUpdateRoleSocialDataRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.ReUpdateRoleSocialData;
	
	/** 变化的社交数据字典 */
	public LongObjectMap<RoleSocialData> dic;
	
	public ReUpdateRoleSocialDataRequest()
	{
		_dataID=GameRequestType.ReUpdateRoleSocialData;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		LongObjectMap<RoleSocialData> dicTemp=dic;
		if(dicTemp!=null)
		{
			this.dic=new LongObjectMap<RoleSocialData>(RoleSocialData[]::new,dicTemp.size());
			LongObjectMap<RoleSocialData> dicT=this.dic;
			if(!dicTemp.isEmpty())
			{
				Object[] dicVValues=dicTemp.getValues();
				for(int dicVI=dicVValues.length-1;dicVI>=0;--dicVI)
				{
					if(dicVValues[dicVI]!=null)
					{
						RoleSocialData dicV=(RoleSocialData)dicVValues[dicVI];
						RoleSocialData dicU;
						if(dicV!=null)
						{
							dicU=(RoleSocialData)dicV.clone();
						}
						else
						{
							dicU=null;
							nullObjError("dicU");
						}
						
						dicT.put(dicU.showData.playerID,dicU);
					}
				}
			}
		}
		else
		{
			this.dic=null;
			nullObjError("dic");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ReUpdateRoleSocialDataRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("dic");
		writer.sb.append(':');
		writer.sb.append("Map<long,RoleSocialData>");
		if(this.dic!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.dic.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.dic.isEmpty())
			{
				long dicKFreeValue=this.dic.getFreeValue();
				long[] dicKKeys=this.dic.getKeys();
				Object[] dicVValues=this.dic.getValues();
				for(int dicKI=dicKKeys.length-1;dicKI>=0;--dicKI)
				{
					long dicK=dicKKeys[dicKI];
					if(dicK!=dicKFreeValue)
					{
						RoleSocialData dicV=(RoleSocialData)dicVValues[dicKI];
						writer.writeTabs();
						writer.sb.append(dicK);
						
						writer.sb.append(':');
						if(dicV!=null)
						{
							dicV.writeDataString(writer);
						}
						else
						{
							writer.sb.append("RoleSocialData=null");
						}
						
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
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.dic!=null)
		{
			stream.writeLen(this.dic.size());
			if(!this.dic.isEmpty())
			{
				Object[] dicVValues=this.dic.getValues();
				for(int dicVI=dicVValues.length-1;dicVI>=0;--dicVI)
				{
					if(dicVValues[dicVI]!=null)
					{
						RoleSocialData dicV=(RoleSocialData)dicVValues[dicVI];
						if(dicV!=null)
						{
							stream.writeDataFullNotNull(dicV);
						}
						else
						{
							nullObjError("dicV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("dic");
		}
		
		stream.endWriteObj();
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		if(this.dic!=null)
		{
			stream.writeLen(this.dic.size());
			if(!this.dic.isEmpty())
			{
				Object[] dicVValues=this.dic.getValues();
				for(int dicVI=dicVValues.length-1;dicVI>=0;--dicVI)
				{
					if(dicVValues[dicVI]!=null)
					{
						RoleSocialData dicV=(RoleSocialData)dicVValues[dicVI];
						if(dicV!=null)
						{
							stream.writeDataSimpleNotNull(dicV);
						}
						else
						{
							nullObjError("dicV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("dic");
		}
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		if(this.dic!=null)
		{
			if(!this.dic.isEmpty())
			{
				long dicKFreeValue=this.dic.getFreeValue();
				long[] dicKKeys=this.dic.getKeys();
				Object[] dicVValues=this.dic.getValues();
				for(int dicKI=dicKKeys.length-1;dicKI>=0;--dicKI)
				{
					long dicK=dicKKeys[dicKI];
					if(dicK!=dicKFreeValue)
					{
						RoleSocialData dicV=(RoleSocialData)dicVValues[dicKI];
						dicV.release(pool);
						dicV=null;
						dicKKeys[dicKI]=dicKFreeValue;
						dicVValues[dicKI]=null;
					}
				}
			}
			this.dic.justClearSize();
		}
	}
	
	/** 创建实例 */
	public static ReUpdateRoleSocialDataRequest create(LongObjectMap<RoleSocialData> dic)
	{
		ReUpdateRoleSocialDataRequest re=(ReUpdateRoleSocialDataRequest)BytesControl.createRequest(dataID);
		re.dic=dic;
		return re;
	}
	
}
