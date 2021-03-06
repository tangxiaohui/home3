using ShineEngine;

/// <summary>
/// trigger方法组(generated by shine)
/// </summary>
public class TriggerFuncListData:TriggerObjData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=ShineDataType.TriggerFuncList;
	
	/// <summary>
	/// 函数组
	/// </summary>
	public TriggerFuncData[] args;
	
	/// <summary>
	/// 函数组
	/// </summary>
	public TriggerFuncData[] funcList;
	
	public TriggerFuncListData()
	{
		_dataID=ShineDataType.TriggerFuncList;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "TriggerFuncListData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		base.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		int funcListLen=stream.readLen();
		if(this.funcList==null || this.funcList.Length!=funcListLen)
		{
			this.funcList=new TriggerFuncData[funcListLen];
		}
		TriggerFuncData[] funcListT=this.funcList;
		for(int funcListI=0;funcListI<funcListLen;++funcListI)
		{
			TriggerFuncData funcListV;
			BaseData funcListVT=stream.readDataFullNotNull();
			if(funcListVT!=null)
			{
				if(funcListVT is TriggerFuncData)
				{
					funcListV=(TriggerFuncData)funcListVT;
				}
				else
				{
					funcListV=new TriggerFuncData();
					if(!(funcListVT.GetType().IsAssignableFrom(typeof(TriggerFuncData))))
					{
						stream.throwTypeReadError(typeof(TriggerFuncData),funcListVT.GetType());
					}
					funcListV.shadowCopy(funcListVT);
				}
			}
			else
			{
				funcListV=null;
			}
			
			funcListT[funcListI]=funcListV;
		}
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.funcList!=null)
		{
			TriggerFuncData[] funcListT=this.funcList;
			stream.writeLen(funcListT.Length);
			for(int funcListVI=0,funcListVLen=funcListT.Length;funcListVI<funcListVLen;++funcListVI)
			{
				TriggerFuncData funcListV=funcListT[funcListVI];
				if(funcListV!=null)
				{
					stream.writeDataFullNotNull(funcListV);
				}
				else
				{
					nullObjError("funcListV");
				}
				
			}
		}
		else
		{
			nullObjError("funcList");
		}
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		int funcListLen=stream.readLen();
		if(this.funcList==null || this.funcList.Length!=funcListLen)
		{
			this.funcList=new TriggerFuncData[funcListLen];
		}
		TriggerFuncData[] funcListT=this.funcList;
		for(int funcListI=0;funcListI<funcListLen;++funcListI)
		{
			TriggerFuncData funcListV;
			funcListV=(TriggerFuncData)stream.readDataSimpleNotNull();
			
			funcListT[funcListI]=funcListV;
		}
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		if(this.funcList!=null)
		{
			TriggerFuncData[] funcListT=this.funcList;
			stream.writeLen(funcListT.Length);
			for(int funcListVI=0,funcListVLen=funcListT.Length;funcListVI<funcListVLen;++funcListVI)
			{
				TriggerFuncData funcListV=funcListT[funcListVI];
				if(funcListV!=null)
				{
					stream.writeDataSimpleNotNull(funcListV);
				}
				else
				{
					nullObjError("funcListV");
				}
				
			}
		}
		else
		{
			nullObjError("funcList");
		}
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		base.toShadowCopy(data);
		
		if(!(data is TriggerFuncListData))
			return;
		
		TriggerFuncListData mData=(TriggerFuncListData)data;
		
		this.funcList=mData.funcList;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		base.toCopy(data);
		
		if(!(data is TriggerFuncListData))
			return;
		
		TriggerFuncListData mData=(TriggerFuncListData)data;
		
		if(mData.funcList!=null)
		{
			TriggerFuncData[] funcListR=mData.funcList;
			int funcListLen=funcListR.Length;
			if(this.funcList==null || this.funcList.Length!=funcListLen)
			{
				this.funcList=new TriggerFuncData[funcListLen];
			}
			TriggerFuncData[] funcListT=this.funcList;
			for(int funcListI=0;funcListI<funcListLen;++funcListI)
			{
				TriggerFuncData funcListV=funcListR[funcListI];
				TriggerFuncData funcListU;
				if(funcListV!=null)
				{
					funcListU=(TriggerFuncData)funcListV.clone();
				}
				else
				{
					funcListU=null;
					nullObjError("funcListU");
				}
				
				funcListT[funcListI]=funcListU;
			}
		}
		else
		{
			this.funcList=null;
			nullObjError("funcList");
		}
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		if(!base.toDataEquals(data))
			return false;
		
		TriggerFuncListData mData=(TriggerFuncListData)data;
		if(mData.funcList!=null)
		{
			if(this.funcList==null)
				return false;
			if(this.funcList.Length!=mData.funcList.Length)
				return false;
			TriggerFuncData[] funcListT=this.funcList;
			TriggerFuncData[] funcListR=mData.funcList;
			int funcListLen=funcListT.Length;
			for(int funcListI=0;funcListI<funcListLen;++funcListI)
			{
				TriggerFuncData funcListU=funcListT[funcListI];
				TriggerFuncData funcListV=funcListR[funcListI];
				if(funcListV!=null)
				{
					if(funcListU==null)
						return false;
					if(!funcListU.dataEquals(funcListV))
						return false;
				}
				else
				{
					if(funcListU!=null)
						return false;
				}
				
			}
		}
		else
		{
			if(this.funcList!=null)
				return false;
		}
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("funcList");
		writer.sb.Append(':');
		writer.sb.Append("Array<TriggerFuncData>");
		if(this.funcList!=null)
		{
			TriggerFuncData[] funcListT=this.funcList;
			int funcListLen=funcListT.Length;
			writer.sb.Append('(');
			writer.sb.Append(funcListLen);
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int funcListI=0;funcListI<funcListLen;++funcListI)
			{
				TriggerFuncData funcListV=funcListT[funcListI];
				writer.writeTabs();
				writer.sb.Append(funcListI);
				writer.sb.Append(':');
				if(funcListV!=null)
				{
					funcListV.writeDataString(writer);
				}
				else
				{
					writer.sb.Append("TriggerFuncData=null");
				}
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.Append("=null");
		}
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		base.initDefault();
		
		this.funcList=new TriggerFuncData[0];
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.funcList=null;
	}
	
}
