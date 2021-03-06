namespace Shine
{
	/** 添加邮件离线事务(generated by shine) */
	export class AddMailOWData extends PlayerWorkData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.AddMailOW;
		
		/** 邮件数据 */
		public data:MailData;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.AddMailOW;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "AddMailOWData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.data=stream.readDataSimpleNotNull() as MailData;
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeDataSimpleNotNull(this.data);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			super.toShadowCopy(data);
			
			if(!(data instanceof AddMailOWData))
				return;
			
			var mData:AddMailOWData=data as AddMailOWData;
			
			this.data=mData.data;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			super.toCopy(data);
			
			if(!(data instanceof AddMailOWData))
				return;
			
			var mData:AddMailOWData=data as AddMailOWData;
			
			this.data=mData.data.clone() as MailData;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			super.initDefault();
			
			this.data=new MailData();
			this.data.initDefault();
		}
		
	}
}
