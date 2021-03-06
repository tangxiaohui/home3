namespace Shine
{
	/** int查询结果数据(generated by shine) */
	export class IntQueryResultData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.IntQueryResult;
		
		public intValue:number;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.IntQueryResult;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "IntQueryResultData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.intValue=stream.readInt();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeInt(this.intValue);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof IntQueryResultData))
				return;
			
			var mData:IntQueryResultData=data as IntQueryResultData;
			
			this.intValue=mData.intValue;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof IntQueryResultData))
				return;
			
			var mData:IntQueryResultData=data as IntQueryResultData;
			
			this.intValue=mData.intValue;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			
		}
		
	}
}
