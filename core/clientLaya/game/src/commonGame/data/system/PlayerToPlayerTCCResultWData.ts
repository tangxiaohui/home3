namespace Shine
{
	/** 玩家到玩家TCC结果数据(generated by shine) */
	export class PlayerToPlayerTCCResultWData extends PlayerWorkData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.PlayerToPlayerTCCResultW;
		
		/** 发送事务数据 */
		public workData:PlayerToPlayerTCCWData;
		
		/** 结果 */
		public isSuccess:boolean;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.PlayerToPlayerTCCResultW;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.workData=stream.readDataSimpleNotNull() as PlayerToPlayerTCCWData;
			
			this.isSuccess=stream.readBoolean();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeDataSimpleNotNull(this.workData);
			
			stream.writeBoolean(this.isSuccess);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			super.toShadowCopy(data);
			
			if(!(data instanceof PlayerToPlayerTCCResultWData))
				return;
			
			var mData:PlayerToPlayerTCCResultWData=data as PlayerToPlayerTCCResultWData;
			
			this.workData=mData.workData;
			this.isSuccess=mData.isSuccess;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			super.toCopy(data);
			
			if(!(data instanceof PlayerToPlayerTCCResultWData))
				return;
			
			var mData:PlayerToPlayerTCCResultWData=data as PlayerToPlayerTCCResultWData;
			
			this.workData=mData.workData.clone() as PlayerToPlayerTCCWData;
			
			this.isSuccess=mData.isSuccess;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			super.initDefault();
			
			this.workData=new PlayerToPlayerTCCWData();
			this.workData.initDefault();
		}
		
	}
}
