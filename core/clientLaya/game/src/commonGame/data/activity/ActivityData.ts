namespace Shine
{
	/** 活动数据(个人)(与存库数据一致)(generated by shine) */
	export class ActivityData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.Activity;
		
		/** id */
		public id:number;
		
		/** 是否运行中(存库无效) */
		public isRunning:boolean;
		
		/** 已参与次数 */
		public joinTimes:number;
		
		/** 下次触发时间 */
		public nextTurnTime:number;
		
		/** 上次触发时间 */
		public lastTurnTime:number;
		
		/** 下个重置时间(0为未重置过) */
		public nextResetTime:number;
		
		/** 是否可见 */
		public isCanSee:boolean;
		
		/** 下个可见时间 */
		public nextSeeTurnTime:number=-1;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.Activity;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "ActivityData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.id=stream.readInt();
			
			this.isRunning=stream.readBoolean();
			
			this.joinTimes=stream.readInt();
			
			this.nextResetTime=stream.readLong();
			
			this.lastTurnTime=stream.readLong();
			
			this.nextTurnTime=stream.readLong();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeInt(this.id);
			
			stream.writeBoolean(this.isRunning);
			
			stream.writeInt(this.joinTimes);
			
			stream.writeLong(this.nextResetTime);
			
			stream.writeLong(this.lastTurnTime);
			
			stream.writeLong(this.nextTurnTime);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof ActivityData))
				return;
			
			var mData:ActivityData=data as ActivityData;
			
			this.id=mData.id;
			this.isRunning=mData.isRunning;
			this.joinTimes=mData.joinTimes;
			this.nextResetTime=mData.nextResetTime;
			this.lastTurnTime=mData.lastTurnTime;
			this.nextTurnTime=mData.nextTurnTime;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof ActivityData))
				return;
			
			var mData:ActivityData=data as ActivityData;
			
			this.id=mData.id;
			
			this.isRunning=mData.isRunning;
			
			this.joinTimes=mData.joinTimes;
			
			this.nextResetTime=mData.nextResetTime;
			
			this.lastTurnTime=mData.lastTurnTime;
			
			this.nextTurnTime=mData.nextTurnTime;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			
		}
		
	}
}