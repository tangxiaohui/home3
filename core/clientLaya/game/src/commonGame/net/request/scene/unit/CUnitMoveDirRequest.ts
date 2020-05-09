namespace Shine
{
	/** 客户端单位朝向移动消息(generated by shine) */
	export class CUnitMoveDirRequest extends CUnitRRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.CUnitMoveDir;
		
		/** 移动类型 */
		public type:number;
		
		/** 当前位置 */
		public pos:PosData;
		
		/** 目标朝向 */
		public dir:DirData;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.CUnitMoveDir;
		}
		
		protected copyData():void
		{
			super.copyData();
			var posTemp:PosData=this.pos;
			if(posTemp!=null)
			{
				this.pos=new PosData();
				this.pos.copy(posTemp);
			}
			else
			{
				this.pos=null;
			}
			
			var dirTemp:DirData=this.dir;
			this.dir=new DirData();
			this.dir.copy(dirTemp);
			
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "CUnitMoveDirRequest";
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.type);
			
			if(this.pos!=null)
			{
				stream.writeBoolean(true);
				this.pos.writeBytesSimple(stream);
			}
			else
			{
				stream.writeBoolean(false);
			}
			
			this.dir.writeBytesSimple(stream);
			
		}
		
		/** 创建实例 */
		public static createCUnitMoveDir(instanceID:number,type:number,pos:PosData,dir:DirData):CUnitMoveDirRequest
		{
			var re:CUnitMoveDirRequest=new CUnitMoveDirRequest();
			re.instanceID=instanceID;
			re.type=type;
			re.pos=pos;
			re.dir=dir;
			return re;
		}
		
	}
}