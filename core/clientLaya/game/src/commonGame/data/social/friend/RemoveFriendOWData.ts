namespace Shine
{
	/** 执行移除好友离线事务(generated by shine) */
	export class RemoveFriendOWData extends PlayerWorkData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.RemoveFriendOW;
		
		public playerID:number;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.RemoveFriendOW;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "RemoveFriendOWData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.playerID=stream.readLong();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeLong(this.playerID);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			super.toShadowCopy(data);
			
			if(!(data instanceof RemoveFriendOWData))
				return;
			
			var mData:RemoveFriendOWData=data as RemoveFriendOWData;
			
			this.playerID=mData.playerID;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			super.toCopy(data);
			
			if(!(data instanceof RemoveFriendOWData))
				return;
			
			var mData:RemoveFriendOWData=data as RemoveFriendOWData;
			
			this.playerID=mData.playerID;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			super.initDefault();
			
		}
		
	}
}
