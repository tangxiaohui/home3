namespace Shine
{
	/** 客户端离线事务数据(generated by shine) */
	export class ClientOfflineWorkData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.ClientOfflineWork;
		
		/** 序号 */
		public workIndex:number;
		
		/** 时间戳 */
		public workTime:number;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.ClientOfflineWork;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "ClientOfflineWorkData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.workIndex=stream.readInt();
			
			this.workTime=stream.readLong();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeInt(this.workIndex);
			
			stream.writeLong(this.workTime);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof ClientOfflineWorkData))
				return;
			
			var mData:ClientOfflineWorkData=data as ClientOfflineWorkData;
			
			this.workIndex=mData.workIndex;
			this.workTime=mData.workTime;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof ClientOfflineWorkData))
				return;
			
			var mData:ClientOfflineWorkData=data as ClientOfflineWorkData;
			
			this.workIndex=mData.workIndex;
			
			this.workTime=mData.workTime;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			
		}
		
	}
}
