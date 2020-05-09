namespace Shine
{
	/** 角色匹配数据(generated by shine) */
	export class PlayerMatchData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.PlayerMatch;
		
		/** 单位显示数据 */
		public showData:RoleShowData;
		
		/** 匹配值 */
		public value:number;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.PlayerMatch;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "PlayerMatchData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.showData=stream.readDataSimpleNotNull() as RoleShowData;
			
			this.value=stream.readInt();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeDataSimpleNotNull(this.showData);
			
			stream.writeInt(this.value);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof PlayerMatchData))
				return;
			
			var mData:PlayerMatchData=data as PlayerMatchData;
			
			this.showData=mData.showData;
			this.value=mData.value;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof PlayerMatchData))
				return;
			
			var mData:PlayerMatchData=data as PlayerMatchData;
			
			this.showData=mData.showData.clone() as RoleShowData;
			
			this.value=mData.value;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			this.showData=new RoleShowData();
			this.showData.initDefault();
		}
		
	}
}