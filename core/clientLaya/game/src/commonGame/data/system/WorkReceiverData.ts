namespace Shine
{
	/** 事务接收者数据(generated by shine) */
	export class WorkReceiverData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.WorkReceiver;
		
		/** 事务执行记录(key:发起者序号->key:instanceID,value:时间戳) */
		public workExecuteRecordDic:SMap<number,SMap<number,number>>;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.WorkReceiver;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "WorkReceiverData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			var workExecuteRecordDicLen:number=stream.readLen();
			if(this.workExecuteRecordDic!=null)
			{
				this.workExecuteRecordDic.clear();
				this.workExecuteRecordDic.ensureCapacity(workExecuteRecordDicLen);
			}
			else
			{
				this.workExecuteRecordDic=new SMap<number,SMap<number,number>>(workExecuteRecordDicLen);
			}
			
			var workExecuteRecordDicT:SMap<number,SMap<number,number>>=this.workExecuteRecordDic;
			for(var workExecuteRecordDicI:number=workExecuteRecordDicLen-1;workExecuteRecordDicI>=0;--workExecuteRecordDicI)
			{
				var workExecuteRecordDicK:number;
				var workExecuteRecordDicV:SMap<number,number>;
				workExecuteRecordDicK=stream.readInt();
				
				var workExecuteRecordDicVLen:number=stream.readLen();
				workExecuteRecordDicV=new SMap<number,number>(workExecuteRecordDicVLen);
				var workExecuteRecordDicVT:SMap<number,number>=workExecuteRecordDicV;
				for(var workExecuteRecordDicVI:number=workExecuteRecordDicVLen-1;workExecuteRecordDicVI>=0;--workExecuteRecordDicVI)
				{
					var workExecuteRecordDicVK:number;
					var workExecuteRecordDicVV:number;
					workExecuteRecordDicVK=stream.readLong();
					
					workExecuteRecordDicVV=stream.readLong();
					
					workExecuteRecordDicVT.put(workExecuteRecordDicVK,workExecuteRecordDicVV);
				}
				
				workExecuteRecordDicT.put(workExecuteRecordDicK,workExecuteRecordDicV);
			}
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeLen(this.workExecuteRecordDic.size());
			if(!this.workExecuteRecordDic.isEmpty())
			{
				for(var workExecuteRecordDicK of this.workExecuteRecordDic.getKeys())
				{
					var workExecuteRecordDicV:SMap<number,number>=this.workExecuteRecordDic.get(workExecuteRecordDicK);
					stream.writeInt(workExecuteRecordDicK);
					
					stream.writeLen(workExecuteRecordDicV.size());
					if(!workExecuteRecordDicV.isEmpty())
					{
						for(var workExecuteRecordDicVK of workExecuteRecordDicV.getKeys())
						{
							var workExecuteRecordDicVV:number=workExecuteRecordDicV.get(workExecuteRecordDicVK);
							stream.writeLong(workExecuteRecordDicVK);
							
							stream.writeLong(workExecuteRecordDicVV);
							
						}
					}
					
				}
			}
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof WorkReceiverData))
				return;
			
			var mData:WorkReceiverData=data as WorkReceiverData;
			
			this.workExecuteRecordDic=mData.workExecuteRecordDic;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof WorkReceiverData))
				return;
			
			var mData:WorkReceiverData=data as WorkReceiverData;
			
			if(this.workExecuteRecordDic!=null)
			{
				this.workExecuteRecordDic.clear();
				this.workExecuteRecordDic.ensureCapacity(mData.workExecuteRecordDic.size());
			}
			else
			{
				this.workExecuteRecordDic=new SMap<number,SMap<number,number>>(mData.workExecuteRecordDic.size());
			}
			
			var workExecuteRecordDicT:SMap<number,SMap<number,number>>=this.workExecuteRecordDic;
			if(!mData.workExecuteRecordDic.isEmpty())
			{
				for(var workExecuteRecordDicK of mData.workExecuteRecordDic.getKeys())
				{
					var workExecuteRecordDicV:SMap<number,number>=mData.workExecuteRecordDic.get(workExecuteRecordDicK);
					var workExecuteRecordDicW:number;
					var workExecuteRecordDicU:SMap<number,number>;
					workExecuteRecordDicW=workExecuteRecordDicK;
					
					workExecuteRecordDicU=new SMap<number,number>(workExecuteRecordDicV.size());
					var workExecuteRecordDicUT:SMap<number,number>=workExecuteRecordDicU;
					if(!workExecuteRecordDicV.isEmpty())
					{
						for(var workExecuteRecordDicUK of workExecuteRecordDicV.getKeys())
						{
							var workExecuteRecordDicUV:number=workExecuteRecordDicV.get(workExecuteRecordDicUK);
							var workExecuteRecordDicUW:number;
							var workExecuteRecordDicUU:number;
							workExecuteRecordDicUW=workExecuteRecordDicUK;
							
							workExecuteRecordDicUU=workExecuteRecordDicUV;
							
							workExecuteRecordDicUT.put(workExecuteRecordDicUW,workExecuteRecordDicUU);
						}
					}
					
					workExecuteRecordDicT.put(workExecuteRecordDicW,workExecuteRecordDicU);
				}
			}
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			this.workExecuteRecordDic=new SMap<number,SMap<number,number>>();
		}
		
	}
}