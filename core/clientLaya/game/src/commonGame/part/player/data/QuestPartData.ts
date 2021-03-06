namespace Shine
{
	/** 任务数据(generated by shine) */
	export class QuestPartData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=PlayerPartDataType.Quest;
		
		/** 客户端目标实例ID序号 */
		public clientTaskInstanceIDIndex:number;
		
		/** 已接任务组 */
		public accepts:SMap<number,QuestData>;
		
		/** 完成任务线组 */
		public completeLines:SMap<number,number>;
		
		/** 完成任务id组 */
		public completeIDs:SSet<number>;
		
		/** 完成任务组(周期组) */
		public completeQuestsDic:SMap<number,QuestCompleteData>;
		
		constructor()
		{
			super();
			this._dataID=PlayerPartDataType.Quest;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "QuestPartData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.clientTaskInstanceIDIndex=stream.readInt();
			
			var acceptsLen:number=stream.readLen();
			if(this.accepts!=null)
			{
				this.accepts.clear();
				this.accepts.ensureCapacity(acceptsLen);
			}
			else
			{
				this.accepts=new SMap<number,QuestData>(acceptsLen);
			}
			
			var acceptsT:SMap<number,QuestData>=this.accepts;
			for(var acceptsI:number=acceptsLen-1;acceptsI>=0;--acceptsI)
			{
				var acceptsV:QuestData;
				acceptsV=stream.readDataSimpleNotNull() as QuestData;
				
				acceptsT.put(acceptsV.id,acceptsV);
			}
			
			var completeLinesLen:number=stream.readLen();
			if(this.completeLines!=null)
			{
				this.completeLines.clear();
				this.completeLines.ensureCapacity(completeLinesLen);
			}
			else
			{
				this.completeLines=new SMap<number,number>(completeLinesLen);
			}
			
			var completeLinesT:SMap<number,number>=this.completeLines;
			for(var completeLinesI:number=completeLinesLen-1;completeLinesI>=0;--completeLinesI)
			{
				var completeLinesK:number;
				var completeLinesV:number;
				completeLinesK=stream.readInt();
				
				completeLinesV=stream.readInt();
				
				completeLinesT.put(completeLinesK,completeLinesV);
			}
			
			var completeIDsLen:number=stream.readLen();
			if(this.completeIDs!=null)
			{
				this.completeIDs.clear();
				this.completeIDs.ensureCapacity(completeIDsLen);
			}
			else
			{
				this.completeIDs=new SSet<number>();
			}
			
			var completeIDsT:SSet<number>=this.completeIDs;
			for(var completeIDsI:number=completeIDsLen-1;completeIDsI>=0;--completeIDsI)
			{
				var completeIDsV:number;
				completeIDsV=stream.readInt();
				
				completeIDsT.add(completeIDsV);
			}
			
			var completeQuestsDicLen:number=stream.readLen();
			if(this.completeQuestsDic!=null)
			{
				this.completeQuestsDic.clear();
				this.completeQuestsDic.ensureCapacity(completeQuestsDicLen);
			}
			else
			{
				this.completeQuestsDic=new SMap<number,QuestCompleteData>(completeQuestsDicLen);
			}
			
			var completeQuestsDicT:SMap<number,QuestCompleteData>=this.completeQuestsDic;
			for(var completeQuestsDicI:number=completeQuestsDicLen-1;completeQuestsDicI>=0;--completeQuestsDicI)
			{
				var completeQuestsDicV:QuestCompleteData;
				completeQuestsDicV=stream.readDataSimpleNotNull() as QuestCompleteData;
				
				completeQuestsDicT.put(completeQuestsDicV.id,completeQuestsDicV);
			}
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeInt(this.clientTaskInstanceIDIndex);
			
			stream.writeLen(this.accepts.size());
			if(!this.accepts.isEmpty())
			{
				for(var acceptsV of this.accepts.getValues())
				{
					stream.writeDataSimpleNotNull(acceptsV);
					
				}
			}
			
			stream.writeLen(this.completeLines.size());
			if(!this.completeLines.isEmpty())
			{
				for(var completeLinesK of this.completeLines.getKeys())
				{
					var completeLinesV:number=this.completeLines.get(completeLinesK);
					stream.writeInt(completeLinesK);
					
					stream.writeInt(completeLinesV);
					
				}
			}
			
			stream.writeLen(this.completeIDs.size());
			if(!this.completeIDs.isEmpty())
			{
				for(var completeIDsV of this.completeIDs.getKeys())
				{
					stream.writeInt(completeIDsV);
					
				}
			}
			
			stream.writeLen(this.completeQuestsDic.size());
			if(!this.completeQuestsDic.isEmpty())
			{
				for(var completeQuestsDicV of this.completeQuestsDic.getValues())
				{
					stream.writeDataSimpleNotNull(completeQuestsDicV);
					
				}
			}
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof QuestPartData))
				return;
			
			var mData:QuestPartData=data as QuestPartData;
			
			this.clientTaskInstanceIDIndex=mData.clientTaskInstanceIDIndex;
			this.accepts=mData.accepts;
			this.completeLines=mData.completeLines;
			this.completeIDs=mData.completeIDs;
			this.completeQuestsDic=mData.completeQuestsDic;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof QuestPartData))
				return;
			
			var mData:QuestPartData=data as QuestPartData;
			
			this.clientTaskInstanceIDIndex=mData.clientTaskInstanceIDIndex;
			
			if(this.accepts!=null)
			{
				this.accepts.clear();
				this.accepts.ensureCapacity(mData.accepts.size());
			}
			else
			{
				this.accepts=new SMap<number,QuestData>(mData.accepts.size());
			}
			
			var acceptsT:SMap<number,QuestData>=this.accepts;
			if(!mData.accepts.isEmpty())
			{
				for(var acceptsV of mData.accepts.getValues())
				{
					var acceptsU:QuestData;
					acceptsU=acceptsV.clone() as QuestData;
					
					acceptsT.put(acceptsU.id,acceptsU);
				}
			}
			
			if(this.completeLines!=null)
			{
				this.completeLines.clear();
				this.completeLines.ensureCapacity(mData.completeLines.size());
			}
			else
			{
				this.completeLines=new SMap<number,number>(mData.completeLines.size());
			}
			
			var completeLinesT:SMap<number,number>=this.completeLines;
			if(!mData.completeLines.isEmpty())
			{
				for(var completeLinesK of mData.completeLines.getKeys())
				{
					var completeLinesV:number=mData.completeLines.get(completeLinesK);
					var completeLinesW:number;
					var completeLinesU:number;
					completeLinesW=completeLinesK;
					
					completeLinesU=completeLinesV;
					
					completeLinesT.put(completeLinesW,completeLinesU);
				}
			}
			
			if(this.completeIDs!=null)
			{
				this.completeIDs.clear();
				this.completeIDs.ensureCapacity(mData.completeIDs.size());
			}
			else
			{
				this.completeIDs=new SSet<number>();
			}
			
			var completeIDsT:SSet<number>=this.completeIDs;
			if(!mData.completeIDs.isEmpty())
			{
				for(var completeIDsV of mData.completeIDs.getKeys())
				{
					var completeIDsU:number;
					completeIDsU=completeIDsV;
					
					completeIDsT.add(completeIDsU);
				}
			}
			
			if(this.completeQuestsDic!=null)
			{
				this.completeQuestsDic.clear();
				this.completeQuestsDic.ensureCapacity(mData.completeQuestsDic.size());
			}
			else
			{
				this.completeQuestsDic=new SMap<number,QuestCompleteData>(mData.completeQuestsDic.size());
			}
			
			var completeQuestsDicT:SMap<number,QuestCompleteData>=this.completeQuestsDic;
			if(!mData.completeQuestsDic.isEmpty())
			{
				for(var completeQuestsDicV of mData.completeQuestsDic.getValues())
				{
					var completeQuestsDicU:QuestCompleteData;
					completeQuestsDicU=completeQuestsDicV.clone() as QuestCompleteData;
					
					completeQuestsDicT.put(completeQuestsDicU.id,completeQuestsDicU);
				}
			}
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			this.accepts=new SMap<number,QuestData>();
			this.completeLines=new SMap<number,number>();
			this.completeIDs=new SSet<number>();
			this.completeQuestsDic=new SMap<number,QuestCompleteData>();
		}
		
		/** 读取字节流(完整版) */
		protected toReadBytesFull(stream:BytesReadStream):void
		{
			var position:number=BytesReadStream.getReadBytes(stream);
			
			this.clientTaskInstanceIDIndex=stream.readInt();
			
			var acceptsLen:number=stream.readLen();
			if(this.accepts!=null)
			{
				this.accepts.clear();
				this.accepts.ensureCapacity(acceptsLen);
			}
			else
			{
				this.accepts=new SMap<number,QuestData>(acceptsLen);
			}
			
			var acceptsT:SMap<number,QuestData>=this.accepts;
			for(var acceptsI:number=acceptsLen-1;acceptsI>=0;--acceptsI)
			{
				var acceptsV:QuestData;
				acceptsV=stream.readDataFullNotNull() as QuestData;
				
				acceptsT.put(acceptsV.id,acceptsV);
			}
			
			var completeLinesLen:number=stream.readLen();
			if(this.completeLines!=null)
			{
				this.completeLines.clear();
				this.completeLines.ensureCapacity(completeLinesLen);
			}
			else
			{
				this.completeLines=new SMap<number,number>(completeLinesLen);
			}
			
			var completeLinesT:SMap<number,number>=this.completeLines;
			for(var completeLinesI:number=completeLinesLen-1;completeLinesI>=0;--completeLinesI)
			{
				var completeLinesK:number;
				var completeLinesV:number;
				completeLinesK=stream.readInt();
				
				completeLinesV=stream.readInt();
				
				completeLinesT.put(completeLinesK,completeLinesV);
			}
			
			var completeIDsLen:number=stream.readLen();
			if(this.completeIDs!=null)
			{
				this.completeIDs.clear();
				this.completeIDs.ensureCapacity(completeIDsLen);
			}
			else
			{
				this.completeIDs=new SSet<number>();
			}
			
			var completeIDsT:SSet<number>=this.completeIDs;
			for(var completeIDsI:number=completeIDsLen-1;completeIDsI>=0;--completeIDsI)
			{
				var completeIDsV:number;
				completeIDsV=stream.readInt();
				
				completeIDsT.add(completeIDsV);
			}
			
			var completeQuestsDicLen:number=stream.readLen();
			if(this.completeQuestsDic!=null)
			{
				this.completeQuestsDic.clear();
				this.completeQuestsDic.ensureCapacity(completeQuestsDicLen);
			}
			else
			{
				this.completeQuestsDic=new SMap<number,QuestCompleteData>(completeQuestsDicLen);
			}
			
			var completeQuestsDicT:SMap<number,QuestCompleteData>=this.completeQuestsDic;
			for(var completeQuestsDicI:number=completeQuestsDicLen-1;completeQuestsDicI>=0;--completeQuestsDicI)
			{
				var completeQuestsDicV:QuestCompleteData;
				completeQuestsDicV=stream.readDataFullNotNull() as QuestCompleteData;
				
				completeQuestsDicT.put(completeQuestsDicV.id,completeQuestsDicV);
			}
			
			BytesReadStream.disReadBytes(stream,position);
		}
		
		/** 写入字节流(完整版) */
		protected toWriteBytesFull(stream:BytesWriteStream):void
		{
			var position:number=BytesWriteStream.getWriteBytes(stream);
			
			stream.writeInt(this.clientTaskInstanceIDIndex);
			
			stream.writeLen(this.accepts.size());
			if(!this.accepts.isEmpty())
			{
				for(var acceptsV of this.accepts.getValues())
				{
					stream.writeDataFullNotNull(acceptsV);
					
				}
			}
			
			stream.writeLen(this.completeLines.size());
			if(!this.completeLines.isEmpty())
			{
				for(var completeLinesK of this.completeLines.getKeys())
				{
					var completeLinesV:number=this.completeLines.get(completeLinesK);
					stream.writeInt(completeLinesK);
					
					stream.writeInt(completeLinesV);
					
				}
			}
			
			stream.writeLen(this.completeIDs.size());
			if(!this.completeIDs.isEmpty())
			{
				for(var completeIDsV of this.completeIDs.getKeys())
				{
					stream.writeInt(completeIDsV);
					
				}
			}
			
			stream.writeLen(this.completeQuestsDic.size());
			if(!this.completeQuestsDic.isEmpty())
			{
				for(var completeQuestsDicV of this.completeQuestsDic.getValues())
				{
					stream.writeDataFullNotNull(completeQuestsDicV);
					
				}
			}
			
			BytesWriteStream.disWriteBytes(stream,position);
		}
		
		/** 是否数据一致 */
		protected toDataEquals(data:BaseData):boolean
		{
			var mData:QuestPartData=data as QuestPartData;
			if(this.clientTaskInstanceIDIndex!=mData.clientTaskInstanceIDIndex)
				return false;
			
			if(this.accepts==null)
				return false;
			if(this.accepts.size()!=mData.accepts.size())
				return false;
			var acceptsR:SMap<number,QuestData>=mData.accepts;
			if(!this.accepts.isEmpty())
			{
				for(var acceptsK of this.accepts.getKeys())
				{
					var acceptsV:QuestData=this.accepts.get(acceptsK);
					var acceptsU:QuestData=acceptsR.get(acceptsK);
					if(acceptsV==null)
						return false;
					if(!acceptsV.dataEquals(acceptsU))
						return false;
					
				}
			}
			
			if(this.completeLines==null)
				return false;
			if(this.completeLines.size()!=mData.completeLines.size())
				return false;
			var completeLinesR:SMap<number,number>=mData.completeLines;
			if(!this.completeLines.isEmpty())
			{
				for(var completeLinesK of this.completeLines.getKeys())
				{
					var completeLinesV:number=this.completeLines.get(completeLinesK);
					var completeLinesU:number=completeLinesR.get(completeLinesK);
					if(completeLinesV!=completeLinesU)
						return false;
					
				}
			}
			
			if(this.completeIDs==null)
				return false;
			if(this.completeIDs.size()!=mData.completeIDs.size())
				return false;
			var completeIDsR:SSet<number>=mData.completeIDs;
			if(!this.completeIDs.isEmpty())
			{
				for(var completeIDsV of this.completeIDs.getKeys())
				{
					if(!completeIDsR.contains(completeIDsV))
						return false;
				}
			}
			
			if(this.completeQuestsDic==null)
				return false;
			if(this.completeQuestsDic.size()!=mData.completeQuestsDic.size())
				return false;
			var completeQuestsDicR:SMap<number,QuestCompleteData>=mData.completeQuestsDic;
			if(!this.completeQuestsDic.isEmpty())
			{
				for(var completeQuestsDicK of this.completeQuestsDic.getKeys())
				{
					var completeQuestsDicV:QuestCompleteData=this.completeQuestsDic.get(completeQuestsDicK);
					var completeQuestsDicU:QuestCompleteData=completeQuestsDicR.get(completeQuestsDicK);
					if(completeQuestsDicV==null)
						return false;
					if(!completeQuestsDicV.dataEquals(completeQuestsDicU))
						return false;
					
				}
			}
			
			return true;
		}
		
		/** 转文本输出 */
		protected toWriteDataString(writer:DataWriter):void
		{
			writer.writeTabs();
			writer.sb.append("clientTaskInstanceIDIndex");
			writer.sb.append(':');
			writer.sb.append(this.clientTaskInstanceIDIndex);
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("accepts");
			writer.sb.append(':');
			writer.sb.append("Map<number,QuestData>");
			writer.sb.append('(');
			writer.sb.append(this.accepts.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.accepts.isEmpty())
			{
				for(var acceptsK of this.accepts.getKeys())
				{
					var acceptsV:QuestData=this.accepts.get(acceptsK);
					writer.writeTabs();
					writer.sb.append(acceptsK);
					
					writer.sb.append(':');
					acceptsV.writeDataString(writer);
					
					writer.writeEnter();
				}
			}
			writer.writeRightBrace();
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("completeLines");
			writer.sb.append(':');
			writer.sb.append("Map<number,number>");
			writer.sb.append('(');
			writer.sb.append(this.completeLines.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.completeLines.isEmpty())
			{
				for(var completeLinesK of this.completeLines.getKeys())
				{
					var completeLinesV:number=this.completeLines.get(completeLinesK);
					writer.writeTabs();
					writer.sb.append(completeLinesK);
					
					writer.sb.append(':');
					writer.sb.append(completeLinesV);
					
					writer.writeEnter();
				}
			}
			writer.writeRightBrace();
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("completeIDs");
			writer.sb.append(':');
			writer.sb.append("Set<number>");
			writer.sb.append('(');
			writer.sb.append(this.completeIDs.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.completeIDs.isEmpty())
			{
				for(var completeIDsV of this.completeIDs.getKeys())
				{
					writer.writeTabs();
					writer.sb.append(completeIDsV);
					
					writer.writeEnter();
				}
			}
			writer.writeRightBrace();
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("completeQuestsDic");
			writer.sb.append(':');
			writer.sb.append("Map<number,QuestCompleteData>");
			writer.sb.append('(');
			writer.sb.append(this.completeQuestsDic.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.completeQuestsDic.isEmpty())
			{
				for(var completeQuestsDicK of this.completeQuestsDic.getKeys())
				{
					var completeQuestsDicV:QuestCompleteData=this.completeQuestsDic.get(completeQuestsDicK);
					writer.writeTabs();
					writer.sb.append(completeQuestsDicK);
					
					writer.sb.append(':');
					completeQuestsDicV.writeDataString(writer);
					
					writer.writeEnter();
				}
			}
			writer.writeRightBrace();
			
			writer.writeEnter();
		}
		
	}
}
