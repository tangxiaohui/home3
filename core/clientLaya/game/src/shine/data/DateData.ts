namespace Shine
{
	/** 日期数据(generated by shine) */
	export class DateData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=ShineDataType.Date;
		
		/** 当前秒 */
		public timeSeconds:number;
		
		/** 年 */
		private _year:number=0;
		
		/** 月 */
		private _month:number=0;
		
		/** 日 */
		private _day:number=0;
		
		/** 时 */
		private _hour:number=0;
		
		/** 分 */
		private _minute:number=0;
		
		/** 秒 */
		private _second:number=0;
		
		/** 拆分时间dirty */
		private _timeDirty:boolean=true;
		
		constructor()
		{
			super();
			this._dataID=ShineDataType.Date;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "DateData";
		}
		
		/** 读取字节流(完整版) */
		protected toReadBytesFull(stream:BytesReadStream):void
		{
			var position:number=BytesReadStream.getReadBytes(stream);
			
			this.timeSeconds=stream.readLong();
			
			BytesReadStream.disReadBytes(stream,position);
		}
		
		/** 写入字节流(完整版) */
		protected toWriteBytesFull(stream:BytesWriteStream):void
		{
			var position:number=BytesWriteStream.getWriteBytes(stream);
			
			stream.writeLong(this.timeSeconds);
			
			BytesWriteStream.disWriteBytes(stream,position);
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.timeSeconds=stream.readLong();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeLong(this.timeSeconds);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof DateData))
				return;
			
			var mData:DateData=data as DateData;
			
			this.timeSeconds=mData.timeSeconds;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof DateData))
				return;
			
			var mData:DateData=data as DateData;
			
			this.timeSeconds=mData.timeSeconds;
			
		}
		
		/** 是否数据一致 */
		protected toDataEquals(data:BaseData):boolean
		{
			var mData:DateData=data as DateData;
			if(this.timeSeconds!=mData.timeSeconds)
				return false;
			
			return true;
		}
		
		/** 读后 */
		protected afterRead():void
		{
			this._timeDirty=true;
		}
		
		/** 通过原生日期读取 */
		public initByTimeMillis(timeMillis:number):void
		{
			this.timeSeconds=timeMillis/1000;
			this._timeDirty=true;
		}
		
		/** 通过原生日期读取 */
		public initByTimeSeconds(timeSeconds:number):void
		{
			this.timeSeconds=timeSeconds;
			this._timeDirty=true;
		}

		/** 获取当前数据时间年 */
		public getYear():number
		{
			this.ensureTime();
			return this._year;
		}
		
		/** 获取当前数据时间月 */
		public getMonth():number
		{
			this.ensureTime();
			return this._month;
		}
		
		/** 获取当前数据时间日 */
		public getDay():number
		{
			this.ensureTime();
			return this._day;
		}
		
		/** 获取当前数据时间小时数 */
		public getHour():number
		{
			this.ensureTime();
			return this._hour;
		}
		
		/** 获取当前数据时间分钟数 */
		public getMinute():number
		{
			this.ensureTime();
			return this._minute;
		}
		
		/** 获取当前数据时间秒数 */
		public getSecond():number
		{
			this.ensureTime();
			return this._second;
		}

		/** 刷时间 */
		private ensureTime():void
		{
			if(this._timeDirty)
			{
				var dateTime:Date=new Date(this.timeSeconds*1000);
				this.initDTime(dateTime);
				this._timeDirty=false;
			}
		}
		
		/** 通过DateTime初始化时间 */
		public initByDateTimeDate(dateTime:Date):void
		{
			this.initDTime(dateTime);
			this._timeDirty=false;
		}
		
		/** 通过原生日期读取 */
		private initDTime(dateTime:Date):void
		{
			this._year=dateTime.getFullYear();
			this._month=dateTime.getMonth();
			this._day=dateTime.getDay();
			this._hour=dateTime.getHours();
			this._minute=dateTime.getMinutes();
			this._second=dateTime.getSeconds();
		}
		
		/** 获取所表达的毫秒时间 */
		public getTimeSeconds():number
		{
			return this.timeSeconds;
		}
		
		/** 获取所表达的毫秒时间 */
		public getTimeMillis():number
		{
			return this.timeSeconds*1000;
		}
		
		/** 克隆 */
		public cloneDate():DateData
		{
			var re:DateData=new DateData();
			re.timeSeconds=this.timeSeconds;
			re._timeDirty=true;

			return re;
		}
		
		/** 是否在此日期前 */
		public before(data:DateData):boolean
		{
			return this.timeSeconds<data.timeSeconds;
		}
		
		/** 是否在此日期后 */
		public after(data:DateData):boolean
		{
			return this.timeSeconds>data.timeSeconds;
		}
		
		/** 是否和此日期相等 */
		public equalsDate(data:DateData):boolean
		{
			return this.timeSeconds>data.timeSeconds;
		}
		
		/** 增加毫秒时间(主线程) */
		public addTime(time:number):void
		{
			this.timeSeconds+=time;
			this._timeDirty=true;
		}
		
		/** 获取当前日期 */
		public static getNow():DateData
		{
			return DateControl.getNow();
		}
		
		/** 转文本输出 */
		protected toWriteDataString(writer:DataWriter):void
		{
			writer.writeTabs();
			writer.sb.append("timeSeconds");
			writer.sb.append(':');
			writer.sb.append(this.timeSeconds);
			
			writer.writeEnter();
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			
		}
		
		/** 创建日期数据 */
		public static createByTimeSeconds(timeSeconds:number):DateData
		{
			var re:DateData=new DateData();
			re.initByTimeSeconds(timeSeconds);
			return re;
		}
		
	}
}