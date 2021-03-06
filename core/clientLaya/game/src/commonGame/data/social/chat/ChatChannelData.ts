namespace Shine
{
	/** 聊天频道数据(generated by shine) */
	export class ChatChannelData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.ChatChannel;
		
		public queue:SList<RoleChatData>;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.ChatChannel;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			var queueLen:number=stream.readLen();
			if(this.queue!=null)
			{
				this.queue.clear();
				this.queue.ensureCapacity(queueLen);
			}
			else
			{
				this.queue=new SList<RoleChatData>();
			}
			
			var queueT:SList<RoleChatData>=this.queue;
			for(var queueI:number=queueLen-1;queueI>=0;--queueI)
			{
				var queueV:RoleChatData;
				queueV=stream.readDataSimpleNotNull() as RoleChatData;
				
				queueT.add(queueV);
			}
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeLen(this.queue.size());
			if(!this.queue.isEmpty())
			{
				for(var queueVI=0,queueVLen=this.queue.length;queueVI<queueVLen;++queueVI)
				{
					var queueV:RoleChatData=this.queue[queueVI];
					stream.writeDataSimpleNotNull(queueV);
					
				}
			}
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof ChatChannelData))
				return;
			
			var mData:ChatChannelData=data as ChatChannelData;
			
			this.queue=mData.queue;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof ChatChannelData))
				return;
			
			var mData:ChatChannelData=data as ChatChannelData;
			
			if(this.queue!=null)
			{
				this.queue.clear();
				this.queue.ensureCapacity(mData.queue.size());
			}
			else
			{
				this.queue=new SList<RoleChatData>();
			}
			
			var queueT:SList<RoleChatData>=this.queue;
			if(!mData.queue.isEmpty())
			{
				for(var queueVI=0,queueVLen=mData.queue.length;queueVI<queueVLen;++queueVI)
				{
					var queueV:RoleChatData=mData.queue[queueVI];
					var queueU:RoleChatData;
					queueU=queueV.clone() as RoleChatData;
					
					queueT.add(queueU);
				}
			}
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			this.queue=new SList<RoleChatData>();
		}
		
	}
}
