namespace Shine
{
	/** 脱装备(向背包)(generated by shine) */
	export class FuncPutOffEquipRequest extends FuncRRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.FuncPutOffEquip;
		
		/** 装备槽位 */
		public slot:number;
		
		/** 背包序号(如传-1则为自动选择) */
		public bagIndex:number;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.FuncPutOffEquip;
		}
		
		protected copyData():void
		{
			super.copyData();
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "FuncPutOffEquipRequest";
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeInt(this.slot);
			
			stream.writeInt(this.bagIndex);
			
		}
		
		/** 创建实例 */
		public static createFuncPutOffEquip(funcID:number,slot:number,bagIndex:number):FuncPutOffEquipRequest
		{
			var re:FuncPutOffEquipRequest=new FuncPutOffEquipRequest();
			re.funcID=funcID;
			re.slot=slot;
			re.bagIndex=bagIndex;
			return re;
		}
		
	}
}
