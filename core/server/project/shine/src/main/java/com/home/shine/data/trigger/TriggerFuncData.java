package com.home.shine.data.trigger;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.constlist.generate.ShineDataType;
import com.home.shine.data.BaseData;
import com.home.shine.data.trigger.TriggerObjData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** (generated by shine) */
public class TriggerFuncData extends TriggerObjData
{
	/** 数据类型ID */
	public static final int dataID=ShineDataType.TriggerFunc;
	
	/** 方法id */
	public int id;
	
	/** 参数组 */
	public TriggerObjData[] args;
	
	public TriggerFuncData()
	{
		_dataID=ShineDataType.TriggerFunc;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "TriggerFuncData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.id=stream.readInt();
		
		int argsLen=stream.readLen();
		if(this.args==null || this.args.length!=argsLen)
		{
			this.args=new TriggerObjData[argsLen];
		}
		TriggerObjData[] argsT=this.args;
		for(int argsI=0;argsI<argsLen;++argsI)
		{
			TriggerObjData argsV;
			BaseData argsVT=stream.readDataFullNotNull();
			if(argsVT!=null)
			{
				if(argsVT instanceof TriggerObjData)
				{
					argsV=(TriggerObjData)argsVT;
				}
				else
				{
					argsV=new TriggerObjData();
					if(!(argsVT.getClass().isAssignableFrom(TriggerObjData.class)))
					{
						stream.throwTypeReadError(TriggerObjData.class,argsVT.getClass());
					}
					argsV.shadowCopy(argsVT);
				}
			}
			else
			{
				argsV=null;
			}
			
			argsT[argsI]=argsV;
		}
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.id);
		
		if(this.args!=null)
		{
			TriggerObjData[] argsT=this.args;
			stream.writeLen(argsT.length);
			for(int argsVI=0,argsVLen=argsT.length;argsVI<argsVLen;++argsVI)
			{
				TriggerObjData argsV=argsT[argsVI];
				if(argsV!=null)
				{
					stream.writeDataFullNotNull(argsV);
				}
				else
				{
					nullObjError("argsV");
				}
				
			}
		}
		else
		{
			nullObjError("args");
		}
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		int argsLen=stream.readLen();
		if(this.args==null || this.args.length!=argsLen)
		{
			this.args=new TriggerObjData[argsLen];
		}
		TriggerObjData[] argsT=this.args;
		for(int argsI=0;argsI<argsLen;++argsI)
		{
			TriggerObjData argsV;
			argsV=(TriggerObjData)stream.readDataSimpleNotNull();
			
			argsT[argsI]=argsV;
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		if(this.args!=null)
		{
			TriggerObjData[] argsT=this.args;
			stream.writeLen(argsT.length);
			for(int argsVI=0,argsVLen=argsT.length;argsVI<argsVLen;++argsVI)
			{
				TriggerObjData argsV=argsT[argsVI];
				if(argsV!=null)
				{
					stream.writeDataSimpleNotNull(argsV);
				}
				else
				{
					nullObjError("argsV");
				}
				
			}
		}
		else
		{
			nullObjError("args");
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof TriggerFuncData))
			return;
		
		TriggerFuncData mData=(TriggerFuncData)data;
		
		this.id=mData.id;
		this.args=mData.args;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof TriggerFuncData))
			return;
		
		TriggerFuncData mData=(TriggerFuncData)data;
		
		this.id=mData.id;
		
		if(mData.args!=null)
		{
			TriggerObjData[] argsR=mData.args;
			int argsLen=argsR.length;
			if(this.args==null || this.args.length!=argsLen)
			{
				this.args=new TriggerObjData[argsLen];
			}
			TriggerObjData[] argsT=this.args;
			for(int argsI=0;argsI<argsLen;++argsI)
			{
				TriggerObjData argsV=argsR[argsI];
				TriggerObjData argsU;
				if(argsV!=null)
				{
					argsU=(TriggerObjData)argsV.clone();
				}
				else
				{
					argsU=null;
					nullObjError("argsU");
				}
				
				argsT[argsI]=argsU;
			}
		}
		else
		{
			this.args=null;
			nullObjError("args");
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		TriggerFuncData mData=(TriggerFuncData)data;
		if(this.id!=mData.id)
			return false;
		
		if(mData.args!=null)
		{
			if(this.args==null)
				return false;
			if(this.args.length!=mData.args.length)
				return false;
			TriggerObjData[] argsT=this.args;
			TriggerObjData[] argsR=mData.args;
			int argsLen=argsT.length;
			for(int argsI=0;argsI<argsLen;++argsI)
			{
				TriggerObjData argsU=argsT[argsI];
				TriggerObjData argsV=argsR[argsI];
				if(argsV!=null)
				{
					if(argsU==null)
						return false;
					if(!argsU.dataEquals(argsV))
						return false;
				}
				else
				{
					if(argsU!=null)
						return false;
				}
				
			}
		}
		else
		{
			if(this.args!=null)
				return false;
		}
		
		return true;
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
		writer.sb.append("args");
		writer.sb.append(':');
		writer.sb.append("Array<TriggerObjData>");
		if(this.args!=null)
		{
			TriggerObjData[] argsT=this.args;
			int argsLen=argsT.length;
			writer.sb.append('(');
			writer.sb.append(argsLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int argsI=0;argsI<argsLen;++argsI)
			{
				TriggerObjData argsV=argsT[argsI];
				writer.writeTabs();
				writer.sb.append(argsI);
				writer.sb.append(':');
				if(argsV!=null)
				{
					argsV.writeDataString(writer);
				}
				else
				{
					writer.sb.append("TriggerObjData=null");
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
		super.initDefault();
		
		this.args=new TriggerObjData[0];
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.id=0;
		this.args=null;
	}
	
}