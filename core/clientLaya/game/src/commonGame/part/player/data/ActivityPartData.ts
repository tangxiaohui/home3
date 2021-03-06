namespace Shine
{
	/** (generated by shine) */
	export class ActivityPartData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=PlayerPartDataType.Activity;
		
		/** 数据组 */
		public datas:SMap<number,ActivityData>;
		
		constructor()
		{
			super();
			this._dataID=PlayerPartDataType.Activity;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "ActivityPartData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			var datasLen:number=stream.readLen();
			if(this.datas!=null)
			{
				this.datas.clear();
				this.datas.ensureCapacity(datasLen);
			}
			else
			{
				this.datas=new SMap<number,ActivityData>(datasLen);
			}
			
			var datasT:SMap<number,ActivityData>=this.datas;
			for(var datasI:number=datasLen-1;datasI>=0;--datasI)
			{
				var datasV:ActivityData;
				datasV=stream.readDataSimpleNotNull() as ActivityData;
				
				datasT.put(datasV.id,datasV);
			}
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeLen(this.datas.size());
			if(!this.datas.isEmpty())
			{
				for(var datasV of this.datas.getValues())
				{
					stream.writeDataSimpleNotNull(datasV);
					
				}
			}
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof ActivityPartData))
				return;
			
			var mData:ActivityPartData=data as ActivityPartData;
			
			this.datas=mData.datas;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof ActivityPartData))
				return;
			
			var mData:ActivityPartData=data as ActivityPartData;
			
			if(this.datas!=null)
			{
				this.datas.clear();
				this.datas.ensureCapacity(mData.datas.size());
			}
			else
			{
				this.datas=new SMap<number,ActivityData>(mData.datas.size());
			}
			
			var datasT:SMap<number,ActivityData>=this.datas;
			if(!mData.datas.isEmpty())
			{
				for(var datasV of mData.datas.getValues())
				{
					var datasU:ActivityData;
					datasU=datasV.clone() as ActivityData;
					
					datasT.put(datasU.id,datasU);
				}
			}
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			this.datas=new SMap<number,ActivityData>();
		}
		
		/** 读取字节流(完整版) */
		protected toReadBytesFull(stream:BytesReadStream):void
		{
			var position:number=BytesReadStream.getReadBytes(stream);
			
			var datasLen:number=stream.readLen();
			if(this.datas!=null)
			{
				this.datas.clear();
				this.datas.ensureCapacity(datasLen);
			}
			else
			{
				this.datas=new SMap<number,ActivityData>(datasLen);
			}
			
			var datasT:SMap<number,ActivityData>=this.datas;
			for(var datasI:number=datasLen-1;datasI>=0;--datasI)
			{
				var datasV:ActivityData;
				datasV=stream.readDataFullNotNull() as ActivityData;
				
				datasT.put(datasV.id,datasV);
			}
			
			BytesReadStream.disReadBytes(stream,position);
		}
		
		/** 写入字节流(完整版) */
		protected toWriteBytesFull(stream:BytesWriteStream):void
		{
			var position:number=BytesWriteStream.getWriteBytes(stream);
			
			stream.writeLen(this.datas.size());
			if(!this.datas.isEmpty())
			{
				for(var datasV of this.datas.getValues())
				{
					stream.writeDataFullNotNull(datasV);
					
				}
			}
			
			BytesWriteStream.disWriteBytes(stream,position);
		}
		
		/** 是否数据一致 */
		protected toDataEquals(data:BaseData):boolean
		{
			var mData:ActivityPartData=data as ActivityPartData;
			if(this.datas==null)
				return false;
			if(this.datas.size()!=mData.datas.size())
				return false;
			var datasR:SMap<number,ActivityData>=mData.datas;
			if(!this.datas.isEmpty())
			{
				for(var datasK of this.datas.getKeys())
				{
					var datasV:ActivityData=this.datas.get(datasK);
					var datasU:ActivityData=datasR.get(datasK);
					if(datasV==null)
						return false;
					if(!datasV.dataEquals(datasU))
						return false;
					
				}
			}
			
			return true;
		}
		
		/** 转文本输出 */
		protected toWriteDataString(writer:DataWriter):void
		{
			writer.writeTabs();
			writer.sb.append("datas");
			writer.sb.append(':');
			writer.sb.append("Map<number,ActivityData>");
			writer.sb.append('(');
			writer.sb.append(this.datas.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.datas.isEmpty())
			{
				for(var datasK of this.datas.getKeys())
				{
					var datasV:ActivityData=this.datas.get(datasK);
					writer.writeTabs();
					writer.sb.append(datasK);
					
					writer.sb.append(':');
					datasV.writeDataString(writer);
					
					writer.writeEnter();
				}
			}
			writer.writeRightBrace();
			
			writer.writeEnter();
		}
		
	}
}
