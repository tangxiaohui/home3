namespace Shine
{
	/** 存库数据版本(generated by shine) */
	export class SaveVersionData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.SaveVersion;
		
		/** c层数据版本号 */
		public cVersion:number;
		
		/** g层版本号(数据) */
		public gVersion:number;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.SaveVersion;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "SaveVersionData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.cVersion=stream.readInt();
			
			this.gVersion=stream.readInt();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeInt(this.cVersion);
			
			stream.writeInt(this.gVersion);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof SaveVersionData))
				return;
			
			var mData:SaveVersionData=data as SaveVersionData;
			
			this.cVersion=mData.cVersion;
			this.gVersion=mData.gVersion;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof SaveVersionData))
				return;
			
			var mData:SaveVersionData=data as SaveVersionData;
			
			this.cVersion=mData.cVersion;
			
			this.gVersion=mData.gVersion;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			
		}
		
	}
}
