namespace Shine
{
	/** 信息日志表(generated by shine) */
	export class InfoLogConfig extends BaseConfig
	{
		/** 存储集合 */
		private static _dic:SMap<number,InfoLogConfig>;
		
		/** 信息id */
		public id:number;
		
		/** 文字 */
		public text:string;
		
		/** 文字原值 */
		private _text:string;
		
		/** 获取 */
		public static get(id:number):InfoLogConfig
		{
			return this._dic.get(id);
		}
		
		/** 设置字典 */
		public static setDic(dic:SMap<number,InfoLogConfig>):void
		{
			this._dic=dic;
		}
		
		/** 添加字典(热更用) */
		public static addDic(dic:SMap<number,InfoLogConfig>):void
		{
			this._dic.putAll(dic);
		}
		
		/** 获取全部 */
		public static getDic():SMap<number,InfoLogConfig>
		{
			return this._dic;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.id=stream.readInt();
			
			this.text=stream.readUTF();
			
		}
		
		/** 生成刷新配置 */
		protected generateRefresh():void
		{
			if(this._text==null)
				this._text=this.text;
			this.text=LanguageConfig.getText(this._text);
			
		}
		
		/** 读完所有表后处理 */
		public static afterReadConfigAll():void
		{
			
		}
		
	}
}