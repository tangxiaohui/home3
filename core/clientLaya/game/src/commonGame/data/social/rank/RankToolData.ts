namespace Shine
{
	/** 排行榜数据(存库数据)(generated by shine) */
	export class RankToolData extends FuncToolData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.RankTool;
		
		/** 当前排行版本(刷新一次一个版本) */
		public version:number;
		
		/** 列表 */
		public list:SList<RankData>;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.RankTool;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "RankToolData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.version=stream.readInt();
			
			var listLen:number=stream.readLen();
			if(this.list!=null)
			{
				this.list.clear();
				this.list.ensureCapacity(listLen);
			}
			else
			{
				this.list=new SList<RankData>();
			}
			
			var listT:SList<RankData>=this.list;
			for(var listI:number=listLen-1;listI>=0;--listI)
			{
				var listV:RankData;
				listV=stream.readDataSimpleNotNull() as RankData;
				
				listT.add(listV);
			}
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.version);
			
			stream.writeLen(this.list.size());
			if(!this.list.isEmpty())
			{
				for(var listVI=0,listVLen=this.list.length;listVI<listVLen;++listVI)
				{
					var listV:RankData=this.list[listVI];
					stream.writeDataSimpleNotNull(listV);
					
				}
			}
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			super.toShadowCopy(data);
			
			if(!(data instanceof RankToolData))
				return;
			
			var mData:RankToolData=data as RankToolData;
			
			this.version=mData.version;
			this.list=mData.list;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			super.toCopy(data);
			
			if(!(data instanceof RankToolData))
				return;
			
			var mData:RankToolData=data as RankToolData;
			
			this.version=mData.version;
			
			if(this.list!=null)
			{
				this.list.clear();
				this.list.ensureCapacity(mData.list.size());
			}
			else
			{
				this.list=new SList<RankData>();
			}
			
			var listT:SList<RankData>=this.list;
			if(!mData.list.isEmpty())
			{
				for(var listVI=0,listVLen=mData.list.length;listVI<listVLen;++listVI)
				{
					var listV:RankData=mData.list[listVI];
					var listU:RankData;
					listU=listV.clone() as RankData;
					
					listT.add(listU);
				}
			}
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			super.initDefault();
			
			this.list=new SList<RankData>();
		}
		
	}
}