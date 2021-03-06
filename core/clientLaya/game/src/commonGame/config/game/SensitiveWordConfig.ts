namespace Shine
{
	/** 敏感词表(generated by shine) */
	export class SensitiveWordConfig extends BaseConfig
	{
		/** 存储集合 */
		private static _dic:SMap<number,SensitiveWordConfig>;
		
		/** 键 */
		public key:number;
		
		/** 简体中文 */
		public zh_CN:string;
		
		/** 美国英语 */
		public en_US:string;
		
		/** 获取 */
		public static get(key:number):SensitiveWordConfig
		{
			return this._dic.get(key);
		}
		
		/** 设置字典 */
		public static setDic(dic:SMap<number,SensitiveWordConfig>):void
		{
			this._dic=dic;
		}
		
		/** 添加字典(热更用) */
		public static addDic(dic:SMap<number,SensitiveWordConfig>):void
		{
			this._dic.putAll(dic);
		}
		
		/** 获取全部 */
		public static getDic():SMap<number,SensitiveWordConfig>
		{
			return this._dic;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.key=stream.readInt();
			
			this.zh_CN=stream.readUTF();
			
			this.en_US=stream.readUTF();
			
		}
		
		/** 读完所有表后处理 */
		public static afterReadConfigAll():void
		{
			
		}
		
	}
}
