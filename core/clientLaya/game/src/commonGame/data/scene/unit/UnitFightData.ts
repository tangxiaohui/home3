namespace Shine
{
	/** 战斗基础数据(4元素+cd)(generated by shine) */
	export class UnitFightData extends BaseData
	{
		/** 数据类型ID */
		public static dataID:number=BaseDataType.UnitFight;
		
		/** 状态组 */
		public status:SMap<number,boolean>;
		
		/** 属性组 */
		public attributes:SMap<number,number>;
		
		/** 技能组 */
		public skills:SMap<number,SkillData>;
		
		/** buff组 */
		public buffs:SMap<number,BuffData>;
		
		/** CD组 */
		public cds:SMap<number,CDData>;
		
		constructor()
		{
			super();
			this._dataID=BaseDataType.UnitFight;
		}
		
		/** 获取数据类名 */
		public getDataClassName():string
		{
			return "UnitFightData";
		}
		
		/** 读取字节流(简版) */
		protected toReadBytesSimple(stream:BytesReadStream):void
		{
			var statusLen:number=stream.readLen();
			if(this.status!=null)
			{
				this.status.clear();
				this.status.ensureCapacity(statusLen);
			}
			else
			{
				this.status=new SMap<number,boolean>(statusLen);
			}
			
			var statusT:SMap<number,boolean>=this.status;
			for(var statusI:number=statusLen-1;statusI>=0;--statusI)
			{
				var statusK:number;
				var statusV:boolean;
				statusK=stream.readInt();
				
				statusV=stream.readBoolean();
				
				statusT.put(statusK,statusV);
			}
			
			var attributesLen:number=stream.readLen();
			if(this.attributes!=null)
			{
				this.attributes.clear();
				this.attributes.ensureCapacity(attributesLen);
			}
			else
			{
				this.attributes=new SMap<number,number>(attributesLen);
			}
			
			var attributesT:SMap<number,number>=this.attributes;
			for(var attributesI:number=attributesLen-1;attributesI>=0;--attributesI)
			{
				var attributesK:number;
				var attributesV:number;
				attributesK=stream.readInt();
				
				attributesV=stream.readInt();
				
				attributesT.put(attributesK,attributesV);
			}
			
			var skillsLen:number=stream.readLen();
			if(this.skills!=null)
			{
				this.skills.clear();
				this.skills.ensureCapacity(skillsLen);
			}
			else
			{
				this.skills=new SMap<number,SkillData>(skillsLen);
			}
			
			var skillsT:SMap<number,SkillData>=this.skills;
			for(var skillsI:number=skillsLen-1;skillsI>=0;--skillsI)
			{
				var skillsV:SkillData;
				skillsV=stream.readDataSimpleNotNull() as SkillData;
				
				skillsT.put(skillsV.id,skillsV);
			}
			
			var buffsLen:number=stream.readLen();
			if(this.buffs!=null)
			{
				this.buffs.clear();
				this.buffs.ensureCapacity(buffsLen);
			}
			else
			{
				this.buffs=new SMap<number,BuffData>(buffsLen);
			}
			
			var buffsT:SMap<number,BuffData>=this.buffs;
			for(var buffsI:number=buffsLen-1;buffsI>=0;--buffsI)
			{
				var buffsV:BuffData;
				buffsV=stream.readDataSimpleNotNull() as BuffData;
				
				buffsT.put(buffsV.instanceID,buffsV);
			}
			
			var cdsLen:number=stream.readLen();
			if(this.cds!=null)
			{
				this.cds.clear();
				this.cds.ensureCapacity(cdsLen);
			}
			else
			{
				this.cds=new SMap<number,CDData>(cdsLen);
			}
			
			var cdsT:SMap<number,CDData>=this.cds;
			for(var cdsI:number=cdsLen-1;cdsI>=0;--cdsI)
			{
				var cdsV:CDData;
				cdsV=new CDData();
				cdsV.readBytesSimple(stream);
				
				cdsT.put(cdsV.id,cdsV);
			}
			
		}
		
		/** 写入字节流(简版) */
		protected toWriteBytesSimple(stream:BytesWriteStream):void
		{
			stream.writeLen(this.status.size());
			if(!this.status.isEmpty())
			{
				for(var statusK of this.status.getKeys())
				{
					var statusV:boolean=this.status.get(statusK);
					stream.writeInt(statusK);
					
					stream.writeBoolean(statusV);
					
				}
			}
			
			stream.writeLen(this.attributes.size());
			if(!this.attributes.isEmpty())
			{
				for(var attributesK of this.attributes.getKeys())
				{
					var attributesV:number=this.attributes.get(attributesK);
					stream.writeInt(attributesK);
					
					stream.writeInt(attributesV);
					
				}
			}
			
			stream.writeLen(this.skills.size());
			if(!this.skills.isEmpty())
			{
				for(var skillsV of this.skills.getValues())
				{
					stream.writeDataSimpleNotNull(skillsV);
					
				}
			}
			
			stream.writeLen(this.buffs.size());
			if(!this.buffs.isEmpty())
			{
				for(var buffsV of this.buffs.getValues())
				{
					stream.writeDataSimpleNotNull(buffsV);
					
				}
			}
			
			stream.writeLen(this.cds.size());
			if(!this.cds.isEmpty())
			{
				for(var cdsV of this.cds.getValues())
				{
					cdsV.writeBytesSimple(stream);
					
				}
			}
			
		}
		
		/** 复制(潜拷贝) */
		protected toShadowCopy(data:BaseData):void
		{
			if(!(data instanceof UnitFightData))
				return;
			
			var mData:UnitFightData=data as UnitFightData;
			
			this.status=mData.status;
			this.attributes=mData.attributes;
			this.skills=mData.skills;
			this.buffs=mData.buffs;
			this.cds=mData.cds;
		}
		
		/** 复制(深拷贝) */
		protected toCopy(data:BaseData):void
		{
			if(!(data instanceof UnitFightData))
				return;
			
			var mData:UnitFightData=data as UnitFightData;
			
			if(this.status!=null)
			{
				this.status.clear();
				this.status.ensureCapacity(mData.status.size());
			}
			else
			{
				this.status=new SMap<number,boolean>(mData.status.size());
			}
			
			var statusT:SMap<number,boolean>=this.status;
			if(!mData.status.isEmpty())
			{
				for(var statusK of mData.status.getKeys())
				{
					var statusV:boolean=mData.status.get(statusK);
					var statusW:number;
					var statusU:boolean;
					statusW=statusK;
					
					statusU=statusV;
					
					statusT.put(statusW,statusU);
				}
			}
			
			if(this.attributes!=null)
			{
				this.attributes.clear();
				this.attributes.ensureCapacity(mData.attributes.size());
			}
			else
			{
				this.attributes=new SMap<number,number>(mData.attributes.size());
			}
			
			var attributesT:SMap<number,number>=this.attributes;
			if(!mData.attributes.isEmpty())
			{
				for(var attributesK of mData.attributes.getKeys())
				{
					var attributesV:number=mData.attributes.get(attributesK);
					var attributesW:number;
					var attributesU:number;
					attributesW=attributesK;
					
					attributesU=attributesV;
					
					attributesT.put(attributesW,attributesU);
				}
			}
			
			if(this.skills!=null)
			{
				this.skills.clear();
				this.skills.ensureCapacity(mData.skills.size());
			}
			else
			{
				this.skills=new SMap<number,SkillData>(mData.skills.size());
			}
			
			var skillsT:SMap<number,SkillData>=this.skills;
			if(!mData.skills.isEmpty())
			{
				for(var skillsV of mData.skills.getValues())
				{
					var skillsU:SkillData;
					skillsU=skillsV.clone() as SkillData;
					
					skillsT.put(skillsU.id,skillsU);
				}
			}
			
			if(this.buffs!=null)
			{
				this.buffs.clear();
				this.buffs.ensureCapacity(mData.buffs.size());
			}
			else
			{
				this.buffs=new SMap<number,BuffData>(mData.buffs.size());
			}
			
			var buffsT:SMap<number,BuffData>=this.buffs;
			if(!mData.buffs.isEmpty())
			{
				for(var buffsV of mData.buffs.getValues())
				{
					var buffsU:BuffData;
					buffsU=buffsV.clone() as BuffData;
					
					buffsT.put(buffsU.instanceID,buffsU);
				}
			}
			
			if(this.cds!=null)
			{
				this.cds.clear();
				this.cds.ensureCapacity(mData.cds.size());
			}
			else
			{
				this.cds=new SMap<number,CDData>(mData.cds.size());
			}
			
			var cdsT:SMap<number,CDData>=this.cds;
			if(!mData.cds.isEmpty())
			{
				for(var cdsV of mData.cds.getValues())
				{
					var cdsU:CDData;
					cdsU=new CDData();
					cdsU.copy(cdsV);
					
					cdsT.put(cdsU.id,cdsU);
				}
			}
			
		}
		
		/** 初始化初值 */
		public initDefault():void
		{
			this.status=new SMap<number,boolean>();
			this.attributes=new SMap<number,number>();
			this.skills=new SMap<number,SkillData>();
			this.buffs=new SMap<number,BuffData>();
			this.cds=new SMap<number,CDData>();
		}
		
	}
}
