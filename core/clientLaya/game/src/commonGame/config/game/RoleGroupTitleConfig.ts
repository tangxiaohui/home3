namespace Shine
{
	/** 玩家群职位表(generated by shine) */
	export class RoleGroupTitleConfig extends BaseConfig
	{
		/** 存储集合 */
		private static _dic:RoleGroupTitleConfig[];
		
		/** id */
		public id:number;
		
		/** 名字 */
		public name:string;
		
		/** 最多数目 */
		public num:number;
		
		/** 最多数目(资源转) */
		public numT:number;
		
		/** 是否可修改群公告 */
		public canChangeNotice:boolean;
		
		/** 可踢出职位 */
		public canKickTitle:number;
		
		/** 是否可修改群名 */
		public canChangeName:boolean;
		
		/** 是否可修改申请直接进入 */
		public canChangeApplyInAbs:boolean;
		
		/** 是否可处理申请 */
		public canHandleApply:boolean;
		
		/** 可任命职位 */
		public canSetTitle:number;
		
		/** 获取 */
		public static get(id:number):RoleGroupTitleConfig
		{
			return id>=0 && id<this._dic.length ? this._dic[id] : null;
		}
		
		/** 设置字典 */
		public static setDic(dic:RoleGroupTitleConfig[]):void
		{
			this._dic=dic;
		}
		
		/** 添加字典(热更用) */
		public static addDic(dic:RoleGroupTitleConfig[]):void
		{
			ObjectUtils.arrayPutAll(this._dic,dic);
		}
		
		/** 获取全部 */
		public static getDic():RoleGroupTitleConfig[]
		{
			return this._dic;
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			super.toReadBytesSimple(stream);
			
			this.id=stream.readInt();
			
			this.name=stream.readUTF();
			
			this.num=stream.readInt();
			
			this.canChangeName=stream.readBoolean();
			
			this.canChangeNotice=stream.readBoolean();
			
			this.canHandleApply=stream.readBoolean();
			
			this.canSetTitle=stream.readInt();
			
			this.canKickTitle=stream.readInt();
			
			this.canChangeApplyInAbs=stream.readBoolean();
			
		}
		
		/** 读完所有表后处理 */
		public static afterReadConfigAll():void
		{
			
		}
		
	}
}