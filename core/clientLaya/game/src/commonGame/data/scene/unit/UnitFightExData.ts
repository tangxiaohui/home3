namespace Shine
{
	/** 附加战斗数据(generated by shine) */
	export class UnitFightExData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.UnitFightEx;
		
		/** 当前技能ID(-1为没有释放技能) */
		public currentSkillID:number=-1;
		
		/** 当前技能等级 */
		public currentSkillLevel:number=0;
		
		/** 当前技能目标 */
		public currentTarget:SkillTargetData;
		
		/** 当前技能步 */
		public currentSkillStep:number;
		
		/** 当前技能读条时间经过 */
		public currentSkillBarTimePass:number;
		
		/** 当前技能读条ID */
		public currentSkillBarID:number=-1;
		
		/** 当前步时间经过 */
		public currentSkillStepTimePass:number;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.UnitFightEx;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "UnitFightExData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			this.currentSkillID=stream.readInt();
			
			this.currentSkillLevel=stream.readInt();
			
			if(stream.readBoolean())
			{
				this.currentTarget=stream.readDataSimpleNotNull() as SkillTargetData;
			}
			else
			{
				this.currentTarget=null;
			}
			
			this.currentSkillStep=stream.readInt();
			
			this.currentSkillStepTimePass=stream.readInt();
			
			this.currentSkillBarID=stream.readInt();
			
			this.currentSkillBarTimePass=stream.readInt();
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeInt(this.currentSkillID);
			
			stream.writeInt(this.currentSkillLevel);
			
			if(this.currentTarget!=null)
			{
				stream.writeBoolean(true);
				stream.writeDataSimpleNotNull(this.currentTarget);
			}
			else
			{
				stream.writeBoolean(false);
			}
			
			stream.writeInt(this.currentSkillStep);
			
			stream.writeInt(this.currentSkillStepTimePass);
			
			stream.writeInt(this.currentSkillBarID);
			
			stream.writeInt(this.currentSkillBarTimePass);
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof UnitFightExData))
				return;
			
			var mData:UnitFightExData=data as UnitFightExData;
			
			this.currentSkillID=mData.currentSkillID;
			this.currentSkillLevel=mData.currentSkillLevel;
			this.currentTarget=mData.currentTarget;
			this.currentSkillStep=mData.currentSkillStep;
			this.currentSkillStepTimePass=mData.currentSkillStepTimePass;
			this.currentSkillBarID=mData.currentSkillBarID;
			this.currentSkillBarTimePass=mData.currentSkillBarTimePass;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof UnitFightExData))
				return;
			
			var mData:UnitFightExData=data as UnitFightExData;
			
			this.currentSkillID=mData.currentSkillID;
			
			this.currentSkillLevel=mData.currentSkillLevel;
			
			if(mData.currentTarget!=null)
			{
				this.currentTarget=mData.currentTarget.clone() as SkillTargetData;
			}
			else
			{
				this.currentTarget=null;
			}
			
			this.currentSkillStep=mData.currentSkillStep;
			
			this.currentSkillStepTimePass=mData.currentSkillStepTimePass;
			
			this.currentSkillBarID=mData.currentSkillBarID;
			
			this.currentSkillBarTimePass=mData.currentSkillBarTimePass;
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			
		}
		
	}
}
