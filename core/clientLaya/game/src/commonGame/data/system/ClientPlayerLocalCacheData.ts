namespace Shine
{
	/** 客户端本地角色缓存数据(generated by shine) */
	export class ClientPlayerLocalCacheData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.ClientPlayerLocalCache;
		
		/** 标准保存数据 */
		public keep:KeepSaveData;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.ClientPlayerLocalCache;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "ClientPlayerLocalCacheData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.keep=new KeepSaveData();
			this.keep.readBytesSimple(stream);
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			this.keep.writeBytesSimple(stream);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof ClientPlayerLocalCacheData))
				return;
			
			var mData:ClientPlayerLocalCacheData=data as ClientPlayerLocalCacheData;
			
			this.keep=mData.keep;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof ClientPlayerLocalCacheData))
				return;
			
			var mData:ClientPlayerLocalCacheData=data as ClientPlayerLocalCacheData;
			
			this.keep=new KeepSaveData();
			this.keep.copy(mData.keep);
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			this.keep=new KeepSaveData();
			this.keep.initDefault();
		}
		
	}
}