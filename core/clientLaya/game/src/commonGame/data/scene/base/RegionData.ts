namespace Shine
{
	/** 区域数据(generated by shine) */
	export class RegionData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.Region;
		
		/** 实例ID */
		public instanceID:number;
		
		/** id */
		public id:number;
		
		/** 参数组 */
		public args:number[];
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.Region;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.instanceID=stream.readInt();
			
			this.id=stream.readInt();
			
			var argsLen:number=stream.readLen();
			this.args=new Array<number>(argsLen);
			var argsT:number[]=this.args;
			for(var argsI:number=0;argsI<argsLen;++argsI)
			{
				var argsV:number;
				argsV=stream.readFloat();
				
				argsT[argsI]=argsV;
			}
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeInt(this.instanceID);
			
			stream.writeInt(this.id);
			
			var argsT:number[]=this.args;
			stream.writeLen(argsT.length);
			for(var argsVI=0,argsVLen=argsT.length;argsVI<argsVLen;++argsVI)
			{
				var argsV:number=argsT[argsVI];
				stream.writeFloat(argsV);
				
			}
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof RegionData))
				return;
			
			var mData:RegionData=data as RegionData;
			
			this.instanceID=mData.instanceID;
			this.id=mData.id;
			this.args=mData.args;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof RegionData))
				return;
			
			var mData:RegionData=data as RegionData;
			
			this.instanceID=mData.instanceID;
			
			this.id=mData.id;
			
			var argsR:number[]=mData.args;
			var argsLen:number=argsR.length;
			this.args=new Array<number>(argsLen);
			var argsT:number[]=this.args;
			for(var argsI:number=0;argsI<argsLen;++argsI)
			{
				var argsV:number=argsR[argsI];
				var argsU:number;
				argsU=argsV;
				
				argsT[argsI]=argsU;
			}
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			this.args=new Array<number>(0);
		}
		
	}
}
