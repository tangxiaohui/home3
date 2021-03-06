namespace Shine
{
	/** 客户端主控单位添加子弹(generated by shine) */
	export class CUnitAddBulletRequest extends CUnitRRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.CUnitAddBullet;
		
		/** 子弹数据 */
		public bullet:BulletData;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.CUnitAddBullet;
		}
		
		protected copyData():void
		{
			super.copyData();
			var bulletTemp:BulletData=this.bullet;
			this.bullet=bulletTemp.clone() as BulletData;
			
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "CUnitAddBulletRequest";
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeDataSimpleNotNull(this.bullet);
			
		}
		
		/** 创建实例 */
		public static createCUnitAddBullet(instanceID:number,bullet:BulletData):CUnitAddBulletRequest
		{
			var re:CUnitAddBulletRequest=new CUnitAddBulletRequest();
			re.instanceID=instanceID;
			re.bullet=bullet;
			return re;
		}
		
	}
}
