namespace Shine
{
	/** 排行榜基础数据(generated by shine) */
	export class RankData extends KeyData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.Rank;
		
		/** 排名(从1开始) */
		public rank:number;
		
		/** 排行值(如以后一个值不够用,再补,理论上应该是够的) */
		public value:number;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.Rank;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "RankData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.rank=stream.readInt();
			
			this.value=stream.readLong();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.rank);
			
			stream.writeLong(this.value);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			super.toShadowCopy(data);
			
			if(!(data instanceof RankData))
				return;
			
			var mData:RankData=data as RankData;
			
			this.rank=mData.rank;
			this.value=mData.value;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			super.toCopy(data);
			
			if(!(data instanceof RankData))
				return;
			
			var mData:RankData=data as RankData;
			
			this.rank=mData.rank;
			
			this.value=mData.value;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			super.initDefault();
			
		}
		
	}
}
