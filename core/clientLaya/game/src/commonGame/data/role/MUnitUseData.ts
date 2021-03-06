namespace Shine
{
	/** 主单位(可脱离场景存在的)使用数据(generated by shine) */
	export class MUnitUseData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.MUnitUse;
		
		/** 单位id */
		public id:number;
		
		/** 等级 */
		public level:number;
		
		/** 造型数据 */
		public avatar:UnitAvatarData;
		
		/** 装备组 */
		public equips:EquipContainerData;
		
		/** 战斗数据 */
		public fight:UnitFightData;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.MUnitUse;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "MUnitUseData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.id=stream.readInt();
			
			this.level=stream.readInt();
			
			this.avatar=stream.readDataSimpleNotNull() as UnitAvatarData;
			
			this.fight=stream.readDataSimpleNotNull() as UnitFightData;
			
			this.equips=stream.readDataSimpleNotNull() as EquipContainerData;
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeInt(this.id);
			
			stream.writeInt(this.level);
			
			stream.writeDataSimpleNotNull(this.avatar);
			
			stream.writeDataSimpleNotNull(this.fight);
			
			stream.writeDataSimpleNotNull(this.equips);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof MUnitUseData))
				return;
			
			var mData:MUnitUseData=data as MUnitUseData;
			
			this.id=mData.id;
			this.level=mData.level;
			this.avatar=mData.avatar;
			this.fight=mData.fight;
			this.equips=mData.equips;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof MUnitUseData))
				return;
			
			var mData:MUnitUseData=data as MUnitUseData;
			
			this.id=mData.id;
			
			this.level=mData.level;
			
			this.avatar=mData.avatar.clone() as UnitAvatarData;
			
			this.fight=mData.fight.clone() as UnitFightData;
			
			this.equips=mData.equips.clone() as EquipContainerData;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			this.avatar=new UnitAvatarData();
			this.avatar.initDefault();
			this.fight=new UnitFightData();
			this.fight.initDefault();
			this.equips=new EquipContainerData();
			this.equips.initDefault();
		}
		
	}
}
