namespace Shine
{
	/** 场景预备信息数据(generated by shine) */
	export class ScenePreInfoData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.ScenePreInfo;
		
		/** 指定玩家组 */
		public signedPlayers:RoleShowData[];
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.ScenePreInfo;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "ScenePreInfoData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			if(stream.readBoolean())
			{
				var signedPlayersLen:number=stream.readLen();
				this.signedPlayers=new Array<RoleShowData>(signedPlayersLen);
				var signedPlayersT:RoleShowData[]=this.signedPlayers;
				for(var signedPlayersI:number=0;signedPlayersI<signedPlayersLen;++signedPlayersI)
				{
					var signedPlayersV:RoleShowData;
					if(stream.readBoolean())
					{
						signedPlayersV=stream.readDataSimpleNotNull() as RoleShowData;
					}
					else
					{
						signedPlayersV=null;
					}
					
					signedPlayersT[signedPlayersI]=signedPlayersV;
				}
			}
			else
			{
				this.signedPlayers=null;
			}
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			if(this.signedPlayers!=null)
			{
				stream.writeBoolean(true);
				var signedPlayersT:RoleShowData[]=this.signedPlayers;
				stream.writeLen(signedPlayersT.length);
				for(var signedPlayersVI=0,signedPlayersVLen=signedPlayersT.length;signedPlayersVI<signedPlayersVLen;++signedPlayersVI)
				{
					var signedPlayersV:RoleShowData=signedPlayersT[signedPlayersVI];
					if(signedPlayersV!=null)
					{
						stream.writeBoolean(true);
						stream.writeDataSimpleNotNull(signedPlayersV);
					}
					else
					{
						stream.writeBoolean(false);
					}
					
				}
			}
			else
			{
				stream.writeBoolean(false);
			}
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof ScenePreInfoData))
				return;
			
			var mData:ScenePreInfoData=data as ScenePreInfoData;
			
			this.signedPlayers=mData.signedPlayers;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof ScenePreInfoData))
				return;
			
			var mData:ScenePreInfoData=data as ScenePreInfoData;
			
			if(mData.signedPlayers!=null)
			{
				var signedPlayersR:RoleShowData[]=mData.signedPlayers;
				var signedPlayersLen:number=signedPlayersR.length;
				this.signedPlayers=new Array<RoleShowData>(signedPlayersLen);
				var signedPlayersT:RoleShowData[]=this.signedPlayers;
				for(var signedPlayersI:number=0;signedPlayersI<signedPlayersLen;++signedPlayersI)
				{
					var signedPlayersV:RoleShowData=signedPlayersR[signedPlayersI];
					var signedPlayersU:RoleShowData;
					if(signedPlayersV!=null)
					{
						signedPlayersU=signedPlayersV.clone() as RoleShowData;
					}
					else
					{
						signedPlayersU=null;
					}
					
					signedPlayersT[signedPlayersI]=signedPlayersU;
				}
			}
			else
			{
				this.signedPlayers=null;
			}
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			
		}
		
	}
}
