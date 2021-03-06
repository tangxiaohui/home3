namespace Shine
{
	/** 角色到玩家群TCC事务结果(generated by shine) */
	export class PlayerToRoleGroupTCCResultWData extends PlayerWorkData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.PlayerToRoleGroupTCCResultW;
		
		/** 发送事务数据 */
		public workData:PlayerToRoleGroupTCCWData;
		
		/** 结果 */
		public isSuccess:boolean;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.PlayerToRoleGroupTCCResultW;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.workData=stream.readDataSimpleNotNull() as PlayerToRoleGroupTCCWData;
			
			this.isSuccess=stream.readBoolean();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeDataSimpleNotNull(this.workData);
			
			stream.writeBoolean(this.isSuccess);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			super.toShadowCopy(data);
			
			if(!(data instanceof PlayerToRoleGroupTCCResultWData))
				return;
			
			var mData:PlayerToRoleGroupTCCResultWData=data as PlayerToRoleGroupTCCResultWData;
			
			this.workData=mData.workData;
			this.isSuccess=mData.isSuccess;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			super.toCopy(data);
			
			if(!(data instanceof PlayerToRoleGroupTCCResultWData))
				return;
			
			var mData:PlayerToRoleGroupTCCResultWData=data as PlayerToRoleGroupTCCResultWData;
			
			this.workData=mData.workData.clone() as PlayerToRoleGroupTCCWData;
			
			this.isSuccess=mData.isSuccess;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			super.initDefault();
			
			this.workData=new PlayerToRoleGroupTCCWData();
			this.workData.initDefault();
		}
		
	}
}
