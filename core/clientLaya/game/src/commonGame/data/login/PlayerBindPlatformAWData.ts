namespace Shine
{
	/** 角色绑定平台事务(generated by shine) */
	export class PlayerBindPlatformAWData extends PlayerWorkData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.PlayerBindPlatformAW;
		
		public uid:string;
		
		public platform:string;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.PlayerBindPlatformAW;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.uid=stream.readUTF();
			
			this.platform=stream.readUTF();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeUTF(this.uid);
			
			stream.writeUTF(this.platform);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			super.toShadowCopy(data);
			
			if(!(data instanceof PlayerBindPlatformAWData))
				return;
			
			var mData:PlayerBindPlatformAWData=data as PlayerBindPlatformAWData;
			
			this.uid=mData.uid;
			this.platform=mData.platform;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			super.toCopy(data);
			
			if(!(data instanceof PlayerBindPlatformAWData))
				return;
			
			var mData:PlayerBindPlatformAWData=data as PlayerBindPlatformAWData;
			
			this.uid=mData.uid;
			
			this.platform=mData.platform;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			super.initDefault();
			
		}
		
	}
}
