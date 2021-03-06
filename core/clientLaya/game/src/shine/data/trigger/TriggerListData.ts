namespace Shine
{
	/** (generated by shine) */
	export class TriggerListData extends TriggerObjData
	{
		/** 数据类型ID */
		public static dataID:number=ShineDataType.TriggerList;
		
		public value:SList<TriggerObjData>;
		
		constructor()
		{
			super();
			this._dataID=ShineDataType.TriggerList;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "TriggerListData";
		}
		
		/** 读取字节流(完整版) */
		protected toReadBytesFull(stream:BytesReadStream):void
		{
			super.toReadBytesFull(stream);
			
			var position:number=BytesReadStream.getReadBytes(stream);
			
			var valueLen:number=stream.readLen();
			if(this.value!=null)
			{
				this.value.clear();
				this.value.ensureCapacity(valueLen);
			}
			else
			{
				this.value=new SList<TriggerObjData>();
			}
			
			var valueT:SList<TriggerObjData>=this.value;
			for(var valueI:number=valueLen-1;valueI>=0;--valueI)
			{
				var valueV:TriggerObjData;
				valueV=stream.readDataFullNotNull() as TriggerObjData;
				
				valueT.add(valueV);
			}
			
			BytesReadStream.disReadBytes(stream,position);
		}
		
		/** 写入字节流(完整版) */
		protected toWriteBytesFull(stream:BytesWriteStream):void
		{
			super.toWriteBytesFull(stream);
			
			var position:number=BytesWriteStream.getWriteBytes(stream);
			
			stream.writeLen(this.value.size());
			if(!this.value.isEmpty())
			{
				for(var valueVI=0,valueVLen=this.value.length;valueVI<valueVLen;++valueVI)
				{
					var valueV:TriggerObjData=this.value[valueVI];
					stream.writeDataFullNotNull(valueV);
					
				}
			}
			
			BytesWriteStream.disWriteBytes(stream,position);
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			var valueLen:number=stream.readLen();
			if(this.value!=null)
			{
				this.value.clear();
				this.value.ensureCapacity(valueLen);
			}
			else
			{
				this.value=new SList<TriggerObjData>();
			}
			
			var valueT:SList<TriggerObjData>=this.value;
			for(var valueI:number=valueLen-1;valueI>=0;--valueI)
			{
				var valueV:TriggerObjData;
				valueV=stream.readDataSimpleNotNull() as TriggerObjData;
				
				valueT.add(valueV);
			}
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeLen(this.value.size());
			if(!this.value.isEmpty())
			{
				for(var valueVI=0,valueVLen=this.value.length;valueVI<valueVLen;++valueVI)
				{
					var valueV:TriggerObjData=this.value[valueVI];
					stream.writeDataSimpleNotNull(valueV);
					
				}
			}
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			super.toShadowCopy(data);
			
			if(!(data instanceof TriggerListData))
				return;
			
			var mData:TriggerListData=data as TriggerListData;
			
			this.value=mData.value;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			super.toCopy(data);
			
			if(!(data instanceof TriggerListData))
				return;
			
			var mData:TriggerListData=data as TriggerListData;
			
			if(this.value!=null)
			{
				this.value.clear();
				this.value.ensureCapacity(mData.value.size());
			}
			else
			{
				this.value=new SList<TriggerObjData>();
			}
			
			var valueT:SList<TriggerObjData>=this.value;
			if(!mData.value.isEmpty())
			{
				for(var valueVI=0,valueVLen=mData.value.length;valueVI<valueVLen;++valueVI)
				{
					var valueV:TriggerObjData=mData.value[valueVI];
					var valueU:TriggerObjData;
					valueU=valueV.clone() as TriggerObjData;
					
					valueT.add(valueU);
				}
			}
			
		}
		
		/** 是否数据一致 */
		protected toDataEquals(data:BaseData):boolean
		{
			if(!super.toDataEquals(data))
				return false;
			
			var mData:TriggerListData=data as TriggerListData;
			if(this.value==null)
				return false;
			if(this.value.size()!=mData.value.size())
				return false;
			var valueT:SList<TriggerObjData>=this.value;
			var valueR:SList<TriggerObjData>=mData.value;
			var valueLen:number=valueT.size();
			for(var valueI:number=0;valueI<valueLen;++valueI)
			{
				var valueU:TriggerObjData=valueT.get(valueI);
				var valueV:TriggerObjData=valueR.get(valueI);
				if(valueU==null)
					return false;
				if(!valueU.dataEquals(valueV))
					return false;
				
			}
			
			return true;
		}
		
		/** 转文本输出 */
		protected toWriteDataString(writer:DataWriter):void
		{
			super.toWriteDataString(writer);
			
			writer.writeTabs();
			writer.sb.append("value");
			writer.sb.append(':');
			writer.sb.append("List<TriggerObjData>");
			var valueT:SList<TriggerObjData>=this.value;
			var valueLen:number=valueT.size();
			writer.sb.append('(');
			writer.sb.append(valueLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(var valueI:number=0;valueI<valueLen;++valueI)
			{
				var valueV:TriggerObjData=valueT.get(valueI);
				writer.writeTabs();
				writer.sb.append(valueI);
				writer.sb.append(':');
				valueV.writeDataString(writer);
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
			
			writer.writeEnter();
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			super.initDefault();
			
			this.value=new SList<TriggerObjData>();
		}
		
	}
}
