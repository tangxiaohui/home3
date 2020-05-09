namespace Shine
{
	/** 单位位置数据(generated by shine) */
	export class UnitPosData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.UnitPos;
		
		/** 当前位置 */
		public pos:PosData;
		
		/** 当前朝向 */
		public dir:DirData;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.UnitPos;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "UnitPosData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.pos=new PosData();
			this.pos.readBytesSimple(stream);
			
			this.dir=new DirData();
			this.dir.readBytesSimple(stream);
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			this.pos.writeBytesSimple(stream);
			
			this.dir.writeBytesSimple(stream);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof UnitPosData))
				return;
			
			var mData:UnitPosData=data as UnitPosData;
			
			this.pos=mData.pos;
			this.dir=mData.dir;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof UnitPosData))
				return;
			
			var mData:UnitPosData=data as UnitPosData;
			
			this.pos=new PosData();
			this.pos.copy(mData.pos);
			
			this.dir=new DirData();
			this.dir.copy(mData.dir);
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			this.pos=new PosData();
			this.pos.initDefault();
			this.dir=new DirData();
			this.dir.initDefault();
		}
		
	}
}