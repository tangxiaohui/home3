namespace Shine
{
	/** 战斗单位身份数据(generated by shine) */
	export class FightUnitIdentityData extends UnitIdentityData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.FightUnitIdentity;
		
		/** 单位类型ID(类型不同,数据表不同) */
		public id:number;
		
		/** 单位等级 */
		public level:number;
		
		/** 控制角色ID(服务器控制就是-1) */
		public controlPlayerID:number=-1;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.FightUnitIdentity;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "FightUnitIdentityData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.id=stream.readInt();
			
			this.level=stream.readInt();
			
			this.controlPlayerID=stream.readLong();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.id);
			
			stream.writeInt(this.level);
			
			stream.writeLong(this.controlPlayerID);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			super.toShadowCopy(data);
			
			if(!(data instanceof FightUnitIdentityData))
				return;
			
			var mData:FightUnitIdentityData=data as FightUnitIdentityData;
			
			this.id=mData.id;
			this.level=mData.level;
			this.controlPlayerID=mData.controlPlayerID;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			super.toCopy(data);
			
			if(!(data instanceof FightUnitIdentityData))
				return;
			
			var mData:FightUnitIdentityData=data as FightUnitIdentityData;
			
			this.id=mData.id;
			
			this.level=mData.level;
			
			this.controlPlayerID=mData.controlPlayerID;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			super.initDefault();
			
		}
		
	}
}