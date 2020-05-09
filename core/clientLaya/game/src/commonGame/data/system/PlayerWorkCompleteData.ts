namespace Shine
{
	/** 角色事务完成数据(generated by shine) */
	export class PlayerWorkCompleteData extends WorkCompleteData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.PlayerWorkComplete;
		
		/** 接受者playerID */
		public receivePlayerID:number;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.PlayerWorkComplete;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.receivePlayerID=stream.readLong();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeLong(this.receivePlayerID);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			super.toShadowCopy(data);
			
			if(!(data instanceof PlayerWorkCompleteData))
				return;
			
			var mData:PlayerWorkCompleteData=data as PlayerWorkCompleteData;
			
			this.receivePlayerID=mData.receivePlayerID;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			super.toCopy(data);
			
			if(!(data instanceof PlayerWorkCompleteData))
				return;
			
			var mData:PlayerWorkCompleteData=data as PlayerWorkCompleteData;
			
			this.receivePlayerID=mData.receivePlayerID;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			super.initDefault();
			
		}
		
	}
}