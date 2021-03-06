namespace Shine
{
	/** (generated by shine) */
	export class TriggerFuncData extends TriggerObjData
	{
		/** 数据类型ID */
		public static dataID:number=ShineDataType.TriggerFunc;
		
		/** 方法id */
		public id:number;
		
		/** 参数组 */
		public args:TriggerObjData[];
		
		constructor()
		{
			super();
			this._dataID=ShineDataType.TriggerFunc;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "TriggerFuncData";
		}
		
		/** 读取字节流(完整版) */
		protected toReadBytesFull(stream:BytesReadStream):void
		{
			super.toReadBytesFull(stream);
			
			var position:number=BytesReadStream.getReadBytes(stream);
			
			this.id=stream.readInt();
			
			var argsLen:number=stream.readLen();
			this.args=new Array<TriggerObjData>(argsLen);
			var argsT:TriggerObjData[]=this.args;
			for(var argsI:number=0;argsI<argsLen;++argsI)
			{
				var argsV:TriggerObjData;
				argsV=stream.readDataFullNotNull() as TriggerObjData;
				
				argsT[argsI]=argsV;
			}
			
			BytesReadStream.disReadBytes(stream,position);
		}
		
		/** 写入字节流(完整版) */
		protected toWriteBytesFull(stream:BytesWriteStream):void
		{
			super.toWriteBytesFull(stream);
			
			var position:number=BytesWriteStream.getWriteBytes(stream);
			
			stream.writeInt(this.id);
			
			var argsT:TriggerObjData[]=this.args;
			stream.writeLen(argsT.length);
			for(var argsVI=0,argsVLen=argsT.length;argsVI<argsVLen;++argsVI)
			{
				var argsV:TriggerObjData=argsT[argsVI];
				stream.writeDataFullNotNull(argsV);
				
			}
			
			BytesWriteStream.disWriteBytes(stream,position);
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.id=stream.readInt();
			
			var argsLen:number=stream.readLen();
			this.args=new Array<TriggerObjData>(argsLen);
			var argsT:TriggerObjData[]=this.args;
			for(var argsI:number=0;argsI<argsLen;++argsI)
			{
				var argsV:TriggerObjData;
				argsV=stream.readDataSimpleNotNull() as TriggerObjData;
				
				argsT[argsI]=argsV;
			}
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.id);
			
			var argsT:TriggerObjData[]=this.args;
			stream.writeLen(argsT.length);
			for(var argsVI=0,argsVLen=argsT.length;argsVI<argsVLen;++argsVI)
			{
				var argsV:TriggerObjData=argsT[argsVI];
				stream.writeDataSimpleNotNull(argsV);
				
			}
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			super.toShadowCopy(data);
			
			if(!(data instanceof TriggerFuncData))
				return;
			
			var mData:TriggerFuncData=data as TriggerFuncData;
			
			this.id=mData.id;
			this.args=mData.args;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			super.toCopy(data);
			
			if(!(data instanceof TriggerFuncData))
				return;
			
			var mData:TriggerFuncData=data as TriggerFuncData;
			
			this.id=mData.id;
			
			var argsR:TriggerObjData[]=mData.args;
			var argsLen:number=argsR.length;
			this.args=new Array<TriggerObjData>(argsLen);
			var argsT:TriggerObjData[]=this.args;
			for(var argsI:number=0;argsI<argsLen;++argsI)
			{
				var argsV:TriggerObjData=argsR[argsI];
				var argsU:TriggerObjData;
				argsU=argsV.clone() as TriggerObjData;
				
				argsT[argsI]=argsU;
			}
			
		}
		
		/** 是否数据一致 */
		protected toDataEquals(data:BaseData):boolean
		{
			if(!super.toDataEquals(data))
				return false;
			
			var mData:TriggerFuncData=data as TriggerFuncData;
			if(this.id!=mData.id)
				return false;
			
			if(this.args==null)
				return false;
			if(this.args.length!=mData.args.length)
				return false;
			var argsT:TriggerObjData[]=this.args;
			var argsR:TriggerObjData[]=mData.args;
			var argsLen:number=argsT.length;
			for(var argsI:number=0;argsI<argsLen;++argsI)
			{
				var argsU:TriggerObjData=argsT[argsI];
				var argsV:TriggerObjData=argsR[argsI];
				if(argsU==null)
					return false;
				if(!argsU.dataEquals(argsV))
					return false;
				
			}
			
			return true;
		}
		
		/** 转文本输出 */
		protected toWriteDataString(writer:DataWriter):void
		{
			super.toWriteDataString(writer);
			
			writer.writeTabs();
			writer.sb.append("id");
			writer.sb.append(':');
			writer.sb.append(this.id);
			
			writer.writeEnter();
			writer.writeTabs();
			writer.sb.append("args");
			writer.sb.append(':');
			writer.sb.append("Array<TriggerObjData>");
			var argsT:TriggerObjData[]=this.args;
			var argsLen:number=argsT.length;
			writer.sb.append('(');
			writer.sb.append(argsLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(var argsI:number=0;argsI<argsLen;++argsI)
			{
				var argsV:TriggerObjData=argsT[argsI];
				writer.writeTabs();
				writer.sb.append(argsI);
				writer.sb.append(':');
				argsV.writeDataString(writer);
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
			
			writer.writeEnter();
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			super.initDefault();
			
			this.args=new Array<TriggerObjData>(0);
		}
		
	}
}
