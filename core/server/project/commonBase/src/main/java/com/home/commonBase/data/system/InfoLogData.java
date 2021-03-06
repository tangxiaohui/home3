package com.home.commonBase.data.system;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 信息日志数据(generated by shine) */
public class InfoLogData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.InfoLog;
	
	/** 日志id */
	public int id;
	
	/** 日志时间 */
	public long logTime;
	
	/** 参数组 */
	public String[] args;
	
	public InfoLogData()
	{
		_dataID=BaseDataType.InfoLog;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "InfoLogData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.id=stream.readInt();
		
		if(stream.readBoolean())
		{
			int argsLen=stream.readLen();
			if(this.args==null || this.args.length!=argsLen)
			{
				this.args=new String[argsLen];
			}
			String[] argsT=this.args;
			for(int argsI=0;argsI<argsLen;++argsI)
			{
				String argsV;
				argsV=stream.readUTF();
				
				argsT[argsI]=argsV;
			}
		}
		else
		{
			this.args=null;
		}
		
		this.logTime=stream.readLong();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.id);
		
		if(this.args!=null)
		{
			stream.writeBoolean(true);
			String[] argsT=this.args;
			stream.writeLen(argsT.length);
			for(int argsVI=0,argsVLen=argsT.length;argsVI<argsVLen;++argsVI)
			{
				String argsV=argsT[argsVI];
				stream.writeUTF(argsV);
				
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeLong(this.logTime);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.id=stream.readInt();
		
		if(stream.readBoolean())
		{
			int argsLen=stream.readLen();
			if(this.args==null || this.args.length!=argsLen)
			{
				this.args=new String[argsLen];
			}
			String[] argsT=this.args;
			for(int argsI=0;argsI<argsLen;++argsI)
			{
				String argsV;
				argsV=stream.readUTF();
				
				argsT[argsI]=argsV;
			}
		}
		else
		{
			this.args=null;
		}
		
		this.logTime=stream.readLong();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.id);
		
		if(this.args!=null)
		{
			stream.writeBoolean(true);
			String[] argsT=this.args;
			stream.writeLen(argsT.length);
			for(int argsVI=0,argsVLen=argsT.length;argsVI<argsVLen;++argsVI)
			{
				String argsV=argsT[argsVI];
				stream.writeUTF(argsV);
				
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeLong(this.logTime);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof InfoLogData))
			return;
		
		InfoLogData mData=(InfoLogData)data;
		
		this.id=mData.id;
		this.args=mData.args;
		this.logTime=mData.logTime;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof InfoLogData))
			return;
		
		InfoLogData mData=(InfoLogData)data;
		
		this.id=mData.id;
		
		if(mData.args!=null)
		{
			String[] argsR=mData.args;
			int argsLen=argsR.length;
			if(this.args==null || this.args.length!=argsLen)
			{
				this.args=new String[argsLen];
			}
			BytesControl.arrayCopy(mData.args,this.args,argsLen);
		}
		else
		{
			this.args=null;
		}
		
		this.logTime=mData.logTime;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		InfoLogData mData=(InfoLogData)data;
		if(this.id!=mData.id)
			return false;
		
		if(mData.args!=null)
		{
			if(this.args==null)
				return false;
			if(this.args.length!=mData.args.length)
				return false;
			String[] argsT=this.args;
			String[] argsR=mData.args;
			int argsLen=argsT.length;
			for(int argsI=0;argsI<argsLen;++argsI)
			{
				String argsU=argsT[argsI];
				String argsV=argsR[argsI];
				if(!argsU.equals(argsV))
					return false;
				
			}
		}
		else
		{
			if(this.args!=null)
				return false;
		}
		
		if(this.logTime!=mData.logTime)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("id");
		writer.sb.append(':');
		writer.sb.append(this.id);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("args");
		writer.sb.append(':');
		writer.sb.append("Array<String>");
		if(this.args!=null)
		{
			String[] argsT=this.args;
			int argsLen=argsT.length;
			writer.sb.append('(');
			writer.sb.append(argsLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int argsI=0;argsI<argsLen;++argsI)
			{
				String argsV=argsT[argsI];
				writer.writeTabs();
				writer.sb.append(argsI);
				writer.sb.append(':');
				writer.sb.append(argsV);
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("logTime");
		writer.sb.append(':');
		writer.sb.append(this.logTime);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.id=0;
		this.args=null;
		this.logTime=0L;
	}
	
}
