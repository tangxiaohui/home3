namespace Shine
{
	/** 客户端场景广播(generated by shine) */
	export class ClientSceneRadioRequest extends SceneRRequest
	{
		/** 数据类型ID */
		public static dataID:number=GameRequestType.ClientSceneRadio;
		
		/** 数据 */
		public data:BaseData;
		
		constructor()
		{
			super();
			this._dataID=GameRequestType.ClientSceneRadio;
		}
		
		protected copyData():void
		{
			super.copyData();
			var dataTemp:BaseData=this.data;
			this.data=dataTemp.clone() as BaseData;
			
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "ClientSceneRadioRequest";
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			super.toWriteBytesSimple(stream);
			
			stream.writeDataSimpleNotNull(this.data);
			
		}
		
		/** 创建实例 */
		public static createClientSceneRadio(data:BaseData):ClientSceneRadioRequest
		{
			var re:ClientSceneRadioRequest=new ClientSceneRadioRequest();
			re.data=data;
			return re;
		}
		
	}
}