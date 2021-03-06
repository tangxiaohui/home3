namespace Shine
{
	/** (generated by shine) */
	export class FuncRefreshRankResponse extends FuncSResponse
	{
		/** 数据类型ID */
		public static dataID:number=GameResponseType.FuncRefreshRank;
		
		/** 排行值 */
		public value:number;
		
		/** 排行(-1为移除排行) */
		public rank:number;
		
		constructor()
		{
			super();
			this._dataID=GameResponseType.FuncRefreshRank;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "FuncRefreshRankResponse";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.rank=stream.readInt();
			
			this.value=stream.readLong();
			
		}
		
		/** 执行 */
		protected execute():void
		{			
			this.me.func.getRankTool(this.funcID).onRefreshRank(this.rank,this.value);
		}
		
	}
}
