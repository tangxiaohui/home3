namespace Shine
{
	/** 中心服转发消息(generated by shine) */
	export class CenterTransGameToClientResponse extends GameResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.CenterTransGameToClient;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.CenterTransGameToClient;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "CenterTransGameToClientResponse";
		}
		
		/** 执行 */
		protected execute():void
		{
			
		}
		
		public readFromStream(stream:BytesReadStream):BaseResponse
		{
			var mid:number=stream.natureReadUnsignedShort();

			var response:BaseResponse=GameC.server.createResponse(mid);

			if(response==null)
			{
				if(ShineSetting.needMessageExistCheck)
				{
					Ctrl.throwError("未解析mid为" + mid + "的协议");
				}

				return null;
			}

			response.socket=this.socket;

			//从流读取
			response.readFromStream(stream);

			return response;
		}
		
	}
}