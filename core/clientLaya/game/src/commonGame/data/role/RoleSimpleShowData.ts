namespace Shine
{
	/** 角色简版外显数据(聊天等使用)(generated by shine) */
	export class RoleSimpleShowData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.RoleSimpleShow;
		
		/** 角色ID */
		public playerID:number;
		
		/** 创建区服 */
		public createAreaID:number;
		
		/** 名字 */
		public name:string;
		
		/** 性别 */
		public sex:number;
		
		/** 职业 */
		public vocation:number;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.RoleSimpleShow;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.playerID=stream.readLong();
			
			this.createAreaID=stream.readInt();
			
			this.name=stream.readUTF();
			
			this.sex=stream.readInt();
			
			this.vocation=stream.readInt();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeLong(this.playerID);
			
			stream.writeInt(this.createAreaID);
			
			stream.writeUTF(this.name);
			
			stream.writeInt(this.sex);
			
			stream.writeInt(this.vocation);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof RoleSimpleShowData))
				return;
			
			var mData:RoleSimpleShowData=data as RoleSimpleShowData;
			
			this.playerID=mData.playerID;
			this.createAreaID=mData.createAreaID;
			this.name=mData.name;
			this.sex=mData.sex;
			this.vocation=mData.vocation;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof RoleSimpleShowData))
				return;
			
			var mData:RoleSimpleShowData=data as RoleSimpleShowData;
			
			this.playerID=mData.playerID;
			
			this.createAreaID=mData.createAreaID;
			
			this.name=mData.name;
			
			this.sex=mData.sex;
			
			this.vocation=mData.vocation;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			
		}
		
	}
}