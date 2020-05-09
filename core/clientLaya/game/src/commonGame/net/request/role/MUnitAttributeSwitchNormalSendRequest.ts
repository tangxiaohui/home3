namespace Shine
{
	/** 主单位切换属性开关(generated by shine) */
	export class MUnitAttributeSwitchNormalSendRequest extends GameRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.MUnitAttributeSwitchNormalSend;
		
		/** 序号 */
		public index:number;
		
		/** 是否开启 */
		public isOpen:boolean;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.MUnitAttributeSwitchNormalSend;
		}
		
		protected copyData():void
		{
			super.copyData();
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "MUnitAttributeSwitchNormalSendRequest";
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.index);
			
			stream.writeBoolean(this.isOpen);
			
		}
		
		/** 创建实例 */
		public static createMUnitAttributeSwitchNormalSend(index:number,isOpen:boolean):MUnitAttributeSwitchNormalSendRequest
		{
			var re:MUnitAttributeSwitchNormalSendRequest=new MUnitAttributeSwitchNormalSendRequest();
			re.index=index;
			re.isOpen=isOpen;
			return re;
		}
		
	}
}