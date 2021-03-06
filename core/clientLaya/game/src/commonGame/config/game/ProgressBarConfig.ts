namespace Shine
{
	/** 进度条表(generated by shine) */
	export class ProgressBarConfig extends BaseConfig
	{
		/** 存储集合 */
		private static _dic:SMap<number,ProgressBarConfig>;
		
		/** 读条ID */
		public id:number;
		
		/** 类型 */
		public type:number;
		
		/** 时长(ms) */
		public time:number;
		
		/** 资源 */
		public source:string;
		
		/** 资源(资源转) */
		public sourceT:number;
		
		/** 声音 */
		public sound:string;
		
		/** 声音(资源转) */
		public soundT:number;
		
		/** 获取 */
		public static get(id:number):ProgressBarConfig
		{
			return this._dic.get(id);
		}
		
		/** 设置字典 */
		public static setDic(dic:SMap<number,ProgressBarConfig>):void
		{
			this._dic=dic;
		}
		
		/** 添加字典(热更用) */
		public static addDic(dic:SMap<number,ProgressBarConfig>):void
		{
			this._dic.putAll(dic);
		}
		
		/** 获取全部 */
		public static getDic():SMap<number,ProgressBarConfig>
		{
			return this._dic;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.id=stream.readInt();
			
			this.type=stream.readInt();
			
			this.time=stream.readInt();
			
			this.source=stream.readUTF();
			
			this.sound=stream.readUTF();
			
		}
		
		/** 生成刷新配置 */
		protected generateRefresh():void
		{
			this.sourceT=LoadControl.getResourceIDByName(this.source);
			this.soundT=LoadControl.getResourceIDByName(this.sound);
		}
		
		/** 读完所有表后处理 */
		public static afterReadConfigAll():void
		{
			
		}
		
	}
}
