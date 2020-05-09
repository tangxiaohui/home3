namespace Shine
{
	/** 穿戴装备(从背包)(generated by shine) */
	export class FuncPutOnEquipRequest extends FuncRRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.FuncPutOnEquip;
		
		/** 背包序号 */
		public bagIndex:number;
		
		/** 装备槽位 */
		public slot:number;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.FuncPutOnEquip;
		}
		
		protected copyData():void
		{
			super.copyData();
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "FuncPutOnEquipRequest";
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.slot);
			
			stream.writeInt(this.bagIndex);
			
		}
		
		/** 创建实例 */
		public static createFuncPutOnEquip(funcID:number,slot:number,bagIndex:number):FuncPutOnEquipRequest
		{
			var re:FuncPutOnEquipRequest=new FuncPutOnEquipRequest();
			re.funcID=funcID;
			re.slot=slot;
			re.bagIndex=bagIndex;
			return re;
		}
		
	}
}