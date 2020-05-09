package com.home.commonBase.data.system;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.system.PlayerWorkData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.SList;
import com.home.shine.support.pool.DataPool;

/** 角色事务组数据(generated by shine) */
public class PlayerWorkListData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.PlayerWorkList;
	
	/** 数据组 */
	public SList<PlayerWorkData> list;
	
	public PlayerWorkListData()
	{
		_dataID=BaseDataType.PlayerWorkList;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "PlayerWorkListData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		int listLen=stream.readLen();
		if(this.list!=null)
		{
			this.list.clear();
			this.list.ensureCapacity(listLen);
		}
		else
		{
			this.list=new SList<PlayerWorkData>(PlayerWorkData[]::new,listLen);
		}
		
		SList<PlayerWorkData> listT=this.list;
		for(int listI=listLen-1;listI>=0;--listI)
		{
			PlayerWorkData listV;
			BaseData listVT=stream.readDataFullNotNull();
			if(listVT!=null)
			{
				if(listVT instanceof PlayerWorkData)
				{
					listV=(PlayerWorkData)listVT;
				}
				else
				{
					listV=new PlayerWorkData();
					if(!(listVT.getClass().isAssignableFrom(PlayerWorkData.class)))
					{
						stream.throwTypeReadError(PlayerWorkData.class,listVT.getClass());
					}
					listV.shadowCopy(listVT);
				}
			}
			else
			{
				listV=null;
			}
			
			listT.add(listV);
		}
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.list!=null)
		{
			stream.writeLen(this.list.size());
			if(!this.list.isEmpty())
			{
				Object[] listVValues=this.list.getValues();
				for(int listVI=0,listVLen=this.list.length();listVI<listVLen;++listVI)
				{
					PlayerWorkData listV=(PlayerWorkData)listVValues[listVI];
					if(listV!=null)
					{
						stream.writeDataFullNotNull(listV);
					}
					else
					{
						nullObjError("listV");
					}
					
				}
			}
		}
		else
		{
			nullObjError("list");
		}
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		int listLen=stream.readLen();
		if(this.list!=null)
		{
			this.list.clear();
			this.list.ensureCapacity(listLen);
		}
		else
		{
			this.list=new SList<PlayerWorkData>(PlayerWorkData[]::new,listLen);
		}
		
		SList<PlayerWorkData> listT=this.list;
		for(int listI=listLen-1;listI>=0;--listI)
		{
			PlayerWorkData listV;
			listV=(PlayerWorkData)stream.readDataSimpleNotNull();
			
			listT.add(listV);
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.list!=null)
		{
			stream.writeLen(this.list.size());
			if(!this.list.isEmpty())
			{
				Object[] listVValues=this.list.getValues();
				for(int listVI=0,listVLen=this.list.length();listVI<listVLen;++listVI)
				{
					PlayerWorkData listV=(PlayerWorkData)listVValues[listVI];
					if(listV!=null)
					{
						stream.writeDataSimpleNotNull(listV);
					}
					else
					{
						nullObjError("listV");
					}
					
				}
			}
		}
		else
		{
			nullObjError("list");
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof PlayerWorkListData))
			return;
		
		PlayerWorkListData mData=(PlayerWorkListData)data;
		
		this.list=mData.list;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof PlayerWorkListData))
			return;
		
		PlayerWorkListData mData=(PlayerWorkListData)data;
		
		if(mData.list!=null)
		{
			if(this.list!=null)
			{
				this.list.clear();
				this.list.ensureCapacity(mData.list.size());
			}
			else
			{
				this.list=new SList<PlayerWorkData>(PlayerWorkData[]::new,mData.list.size());
			}
			
			SList<PlayerWorkData> listT=this.list;
			if(!mData.list.isEmpty())
			{
				Object[] listVValues=mData.list.getValues();
				for(int listVI=0,listVLen=mData.list.length();listVI<listVLen;++listVI)
				{
					PlayerWorkData listV=(PlayerWorkData)listVValues[listVI];
					PlayerWorkData listU;
					if(listV!=null)
					{
						listU=(PlayerWorkData)listV.clone();
					}
					else
					{
						listU=null;
						nullObjError("listU");
					}
					
					listT.add(listU);
				}
			}
		}
		else
		{
			this.list=null;
			nullObjError("list");
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		PlayerWorkListData mData=(PlayerWorkListData)data;
		if(mData.list!=null)
		{
			if(this.list==null)
				return false;
			if(this.list.size()!=mData.list.size())
				return false;
			SList<PlayerWorkData> listT=this.list;
			SList<PlayerWorkData> listR=mData.list;
			int listLen=listT.size();
			for(int listI=0;listI<listLen;++listI)
			{
				PlayerWorkData listU=listT.get(listI);
				PlayerWorkData listV=listR.get(listI);
				if(listV!=null)
				{
					if(listU==null)
						return false;
					if(!listU.dataEquals(listV))
						return false;
				}
				else
				{
					if(listU!=null)
						return false;
				}
				
			}
		}
		else
		{
			if(this.list!=null)
				return false;
		}
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("list");
		writer.sb.append(':');
		writer.sb.append("List<PlayerWorkData>");
		if(this.list!=null)
		{
			SList<PlayerWorkData> listT=this.list;
			int listLen=listT.size();
			writer.sb.append('(');
			writer.sb.append(listLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int listI=0;listI<listLen;++listI)
			{
				PlayerWorkData listV=listT.get(listI);
				writer.writeTabs();
				writer.sb.append(listI);
				writer.sb.append(':');
				if(listV!=null)
				{
					listV.writeDataString(writer);
				}
				else
				{
					writer.sb.append("PlayerWorkData=null");
				}
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		this.list=new SList<PlayerWorkData>(PlayerWorkData[]::new);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.list=null;
	}
	
}