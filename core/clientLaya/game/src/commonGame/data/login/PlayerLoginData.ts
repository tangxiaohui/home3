namespace Shine
{
	/** 角色登录数据(generated by shine) */
	export class PlayerLoginData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.PlayerLogin;
		
		/** 角色ID */
		public playerID:number;
		
		/** 名字 */
		public name:string;
		
		/** 性别 */
		public sex:number;
		
		/** 职业 */
		public vocation:number;
		
		/** 当前是否还在线 */
		public isOnline:boolean;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.PlayerLogin;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "PlayerLoginData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.playerID=stream.readLong();
			
			this.name=stream.readUTF();
			
			this.sex=stream.readInt();
			
			this.vocation=stream.readInt();
			
			this.isOnline=stream.readBoolean();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeLong(this.playerID);
			
			stream.writeUTF(this.name);
			
			stream.writeInt(this.sex);
			
			stream.writeInt(this.vocation);
			
			stream.writeBoolean(this.isOnline);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof PlayerLoginData))
				return;
			
			var mData:PlayerLoginData=data as PlayerLoginData;
			
			this.playerID=mData.playerID;
			this.name=mData.name;
			this.sex=mData.sex;
			this.vocation=mData.vocation;
			this.isOnline=mData.isOnline;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof PlayerLoginData))
				return;
			
			var mData:PlayerLoginData=data as PlayerLoginData;
			
			this.playerID=mData.playerID;
			
			this.name=mData.name;
			
			this.sex=mData.sex;
			
			this.vocation=mData.vocation;
			
			this.isOnline=mData.isOnline;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			
		}
		
	}
}