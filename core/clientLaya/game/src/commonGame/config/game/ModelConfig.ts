namespace Shine
{
	/** 单位模型表(generated by shine) */
	export class ModelConfig extends BaseConfig
	{
		/** 存储集合 */
		private static _dic:SMap<number,ModelConfig>;
		
		/** 模型id */
		public id:number;
		
		/** 默认部件显示 */
		public showParts:DIntData[];
		
		/** 资源 */
		public source:string;
		
		/** 资源(资源转) */
		public sourceT:number;
		
		/** 单位高度 */
		public height:number;
		
		/** 触碰半径 */
		public collideRadius:number;
		
		/** 默认碰撞矩形(2D) */
		public defaultHitRect:number[];
		
		/** 获取 */
		public static get(id:number):ModelConfig
		{
			return this._dic.get(id);
		}
		
		/** 设置字典 */
		public static setDic(dic:SMap<number,ModelConfig>):void
		{
			this._dic=dic;
		}
		
		/** 添加字典(热更用) */
		public static addDic(dic:SMap<number,ModelConfig>):void
		{
			this._dic.putAll(dic);
		}
		
		/** 获取全部 */
		public static getDic():SMap<number,ModelConfig>
		{
			return this._dic;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.id=stream.readInt();
			
			var showPartsLen:number=stream.readLen();
			this.showParts=new Array<DIntData>(showPartsLen);
			var showPartsT:DIntData[]=this.showParts;
			for(var showPartsI:number=0;showPartsI<showPartsLen;++showPartsI)
			{
				var showPartsV:DIntData;
				showPartsV=new DIntData();
				showPartsV.readBytesSimple(stream);
				
				showPartsT[showPartsI]=showPartsV;
			}
			
			this.source=stream.readUTF();
			
			this.collideRadius=stream.readFloat();
			
			var defaultHitRectLen:number=stream.readLen();
			this.defaultHitRect=new Array<number>(defaultHitRectLen);
			var defaultHitRectT:number[]=this.defaultHitRect;
			for(var defaultHitRectI:number=0;defaultHitRectI<defaultHitRectLen;++defaultHitRectI)
			{
				var defaultHitRectV:number;
				defaultHitRectV=stream.readFloat();
				
				defaultHitRectT[defaultHitRectI]=defaultHitRectV;
			}
			
			this.height=stream.readFloat();
			
		}
		
		/** 生成刷新配置 */
		protected generateRefresh():void
		{
			this.sourceT=LoadControl.getResourceIDByName(this.source);
		}
		
		/** 读完所有表后处理 */
		public static afterReadConfigAll():void
		{
			
		}
		
	}
}
