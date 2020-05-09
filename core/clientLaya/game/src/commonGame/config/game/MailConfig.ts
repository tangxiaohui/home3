namespace Shine
{
	/** 邮件表(generated by shine) */
	export class MailConfig extends BaseConfig
	{
		/** 存储集合 */
		private static _dic:SMap<number,MailConfig>;
		
		/** id */
		public id:number;
		
		/** 类型 */
		public type:number;
		
		/** 标题 */
		public title:string;
		
		/** 内容 */
		public content:string;
		
		/** 是否新获得时出现红点 */
		public needRedPoint:boolean;
		
		/** 奖励id */
		public rewardID:number;
		
		/** 标题原值 */
		private _title:string;
		
		/** 内容原值 */
		private _content:string;
		
		/** 获取 */
		public static get(id:number):MailConfig
		{
			return this._dic.get(id);
		}
		
		/** 设置字典 */
		public static setDic(dic:SMap<number,MailConfig>):void
		{
			this._dic=dic;
		}
		
		/** 添加字典(热更用) */
		public static addDic(dic:SMap<number,MailConfig>):void
		{
			this._dic.putAll(dic);
		}
		
		/** 获取全部 */
		public static getDic():SMap<number,MailConfig>
		{
			return this._dic;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.id=stream.readInt();
			
			this.type=stream.readInt();
			
			this.title=stream.readUTF();
			
			this.content=stream.readUTF();
			
			this.needRedPoint=stream.readBoolean();
			
			this.rewardID=stream.readInt();
			
		}
		
		/** 生成刷新配置 */
		protected generateRefresh():void
		{
			if(this._title==null)
				this._title=this.title;
			this.title=LanguageConfig.getText(this._title);
			
			if(this._content==null)
				this._content=this.content;
			this.content=LanguageConfig.getText(this._content);
			
		}
		
		/** 读完所有表后处理 */
		public static afterReadConfigAll():void
		{
			
		}
		
	}
}