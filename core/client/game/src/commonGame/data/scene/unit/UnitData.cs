using ShineEngine;

/// <summary>
/// 单位数据(generated by shine)
/// </summary>
public class UnitData:BaseData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.Unit;
	
	/// <summary>
	/// 流水ID
	/// </summary>
	public int instanceID;
	
	/// <summary>
	/// 通用数据
	/// </summary>
	public UnitNormalData normal;
	
	/// <summary>
	/// 身份数据
	/// </summary>
	public UnitIdentityData identity;
	
	/// <summary>
	/// 位置数据
	/// </summary>
	public UnitPosData pos;
	
	/// <summary>
	/// 移动数据
	/// </summary>
	public UnitMoveData move;
	
	/// <summary>
	/// 造型数据
	/// </summary>
	public UnitAvatarData avatar;
	
	/// <summary>
	/// 附加战斗数据
	/// </summary>
	public UnitFightExData fightEx;
	
	/// <summary>
	/// AI数据
	/// </summary>
	public UnitAIData ai;
	
	/// <summary>
	/// 功能数据
	/// </summary>
	public UnitFuncData func;
	
	/// <summary>
	/// 战斗数据逻辑
	/// </summary>
	public UnitFightDataLogic fightDataLogic;
	
	/// <summary>
	/// 战斗数据
	/// </summary>
	public UnitFightData fight;
	
	public UnitData()
	{
		_dataID=BaseDataType.Unit;
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		this.instanceID=stream.readInt();
		
		this.identity=(UnitIdentityData)stream.readDataSimpleNotNull();
		
		this.normal=(UnitNormalData)stream.readDataSimpleNotNull();
		
		if(stream.readBoolean())
		{
			this.pos=(UnitPosData)stream.readDataSimpleNotNull();
		}
		else
		{
			this.pos=null;
		}
		
		if(stream.readBoolean())
		{
			this.avatar=(UnitAvatarData)stream.readDataSimpleNotNull();
		}
		else
		{
			this.avatar=null;
		}
		
		if(stream.readBoolean())
		{
			this.move=(UnitMoveData)stream.readDataSimpleNotNull();
		}
		else
		{
			this.move=null;
		}
		
		if(stream.readBoolean())
		{
			this.fight=(UnitFightData)stream.readDataSimpleNotNull();
		}
		else
		{
			this.fight=null;
		}
		
		if(stream.readBoolean())
		{
			this.fightEx=(UnitFightExData)stream.readDataSimpleNotNull();
		}
		else
		{
			this.fightEx=null;
		}
		
		if(stream.readBoolean())
		{
			this.ai=(UnitAIData)stream.readDataSimpleNotNull();
		}
		else
		{
			this.ai=null;
		}
		
		if(stream.readBoolean())
		{
			this.func=(UnitFuncData)stream.readDataSimpleNotNull();
		}
		else
		{
			this.func=null;
		}
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.instanceID);
		
		if(this.identity!=null)
		{
			stream.writeDataSimpleNotNull(this.identity);
		}
		else
		{
			nullObjError("identity");
		}
		
		if(this.normal!=null)
		{
			stream.writeDataSimpleNotNull(this.normal);
		}
		else
		{
			nullObjError("normal");
		}
		
		if(this.pos!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataSimpleNotNull(this.pos);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.avatar!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataSimpleNotNull(this.avatar);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.move!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataSimpleNotNull(this.move);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.fight!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataSimpleNotNull(this.fight);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.fightEx!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataSimpleNotNull(this.fightEx);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.ai!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataSimpleNotNull(this.ai);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.func!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataSimpleNotNull(this.func);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is UnitData))
			return;
		
		UnitData mData=(UnitData)data;
		
		this.instanceID=mData.instanceID;
		this.identity=mData.identity;
		this.normal=mData.normal;
		this.pos=mData.pos;
		this.avatar=mData.avatar;
		this.move=mData.move;
		this.fight=mData.fight;
		this.fightEx=mData.fightEx;
		this.ai=mData.ai;
		this.func=mData.func;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is UnitData))
			return;
		
		UnitData mData=(UnitData)data;
		
		this.instanceID=mData.instanceID;
		
		if(mData.identity!=null)
		{
			this.identity=(UnitIdentityData)mData.identity.clone();
		}
		else
		{
			this.identity=null;
			nullObjError("identity");
		}
		
		if(mData.normal!=null)
		{
			this.normal=(UnitNormalData)mData.normal.clone();
		}
		else
		{
			this.normal=null;
			nullObjError("normal");
		}
		
		if(mData.pos!=null)
		{
			this.pos=(UnitPosData)mData.pos.clone();
		}
		else
		{
			this.pos=null;
		}
		
		if(mData.avatar!=null)
		{
			this.avatar=(UnitAvatarData)mData.avatar.clone();
		}
		else
		{
			this.avatar=null;
		}
		
		if(mData.move!=null)
		{
			this.move=(UnitMoveData)mData.move.clone();
		}
		else
		{
			this.move=null;
		}
		
		if(mData.fight!=null)
		{
			this.fight=(UnitFightData)mData.fight.clone();
		}
		else
		{
			this.fight=null;
		}
		
		if(mData.fightEx!=null)
		{
			this.fightEx=(UnitFightExData)mData.fightEx.clone();
		}
		else
		{
			this.fightEx=null;
		}
		
		if(mData.ai!=null)
		{
			this.ai=(UnitAIData)mData.ai.clone();
		}
		else
		{
			this.ai=null;
		}
		
		if(mData.func!=null)
		{
			this.func=(UnitFuncData)mData.func.clone();
		}
		else
		{
			this.func=null;
		}
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		UnitData mData=(UnitData)data;
		if(this.instanceID!=mData.instanceID)
			return false;
		
		if(mData.identity!=null)
		{
			if(this.identity==null)
				return false;
			if(!this.identity.dataEquals(mData.identity))
				return false;
		}
		else
		{
			if(this.identity!=null)
				return false;
		}
		
		if(mData.normal!=null)
		{
			if(this.normal==null)
				return false;
			if(!this.normal.dataEquals(mData.normal))
				return false;
		}
		else
		{
			if(this.normal!=null)
				return false;
		}
		
		if(mData.pos!=null)
		{
			if(this.pos==null)
				return false;
			if(!this.pos.dataEquals(mData.pos))
				return false;
		}
		else
		{
			if(this.pos!=null)
				return false;
		}
		
		if(mData.avatar!=null)
		{
			if(this.avatar==null)
				return false;
			if(!this.avatar.dataEquals(mData.avatar))
				return false;
		}
		else
		{
			if(this.avatar!=null)
				return false;
		}
		
		if(mData.move!=null)
		{
			if(this.move==null)
				return false;
			if(!this.move.dataEquals(mData.move))
				return false;
		}
		else
		{
			if(this.move!=null)
				return false;
		}
		
		if(mData.fight!=null)
		{
			if(this.fight==null)
				return false;
			if(!this.fight.dataEquals(mData.fight))
				return false;
		}
		else
		{
			if(this.fight!=null)
				return false;
		}
		
		if(mData.fightEx!=null)
		{
			if(this.fightEx==null)
				return false;
			if(!this.fightEx.dataEquals(mData.fightEx))
				return false;
		}
		else
		{
			if(this.fightEx!=null)
				return false;
		}
		
		if(mData.ai!=null)
		{
			if(this.ai==null)
				return false;
			if(!this.ai.dataEquals(mData.ai))
				return false;
		}
		else
		{
			if(this.ai!=null)
				return false;
		}
		
		if(mData.func!=null)
		{
			if(this.func==null)
				return false;
			if(!this.func.dataEquals(mData.func))
				return false;
		}
		else
		{
			if(this.func!=null)
				return false;
		}
		
		return true;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "UnitData";
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.Append("instanceID");
		writer.sb.Append(':');
		writer.sb.Append(this.instanceID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("identity");
		writer.sb.Append(':');
		if(this.identity!=null)
		{
			this.identity.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("UnitIdentityData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("normal");
		writer.sb.Append(':');
		if(this.normal!=null)
		{
			this.normal.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("UnitNormalData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("pos");
		writer.sb.Append(':');
		if(this.pos!=null)
		{
			this.pos.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("UnitPosData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("avatar");
		writer.sb.Append(':');
		if(this.avatar!=null)
		{
			this.avatar.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("UnitAvatarData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("move");
		writer.sb.Append(':');
		if(this.move!=null)
		{
			this.move.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("UnitMoveData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("fight");
		writer.sb.Append(':');
		if(this.fight!=null)
		{
			this.fight.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("UnitFightData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("fightEx");
		writer.sb.Append(':');
		if(this.fightEx!=null)
		{
			this.fightEx.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("UnitFightExData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("ai");
		writer.sb.Append(':');
		if(this.ai!=null)
		{
			this.ai.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("UnitAIData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("func");
		writer.sb.Append(':');
		if(this.func!=null)
		{
			this.func.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("UnitFuncData=null");
		}
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		this.identity=new UnitIdentityData();
		this.identity.initDefault();
		this.normal=new UnitNormalData();
		this.normal.initDefault();
	}
	
	public override void clear()
	{
		if(fightEx!=null)
			fightEx.clear();
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.instanceID=stream.readInt();
		
		BaseData identityT=stream.readDataFullNotNull();
		if(identityT!=null)
		{
			if(identityT is UnitIdentityData)
			{
				this.identity=(UnitIdentityData)identityT;
			}
			else
			{
				this.identity=new UnitIdentityData();
				if(!(identityT.GetType().IsAssignableFrom(typeof(UnitIdentityData))))
				{
					stream.throwTypeReadError(typeof(UnitIdentityData),identityT.GetType());
				}
				this.identity.shadowCopy(identityT);
			}
		}
		else
		{
			this.identity=null;
		}
		
		BaseData normalT=stream.readDataFullNotNull();
		if(normalT!=null)
		{
			if(normalT is UnitNormalData)
			{
				this.normal=(UnitNormalData)normalT;
			}
			else
			{
				this.normal=new UnitNormalData();
				if(!(normalT.GetType().IsAssignableFrom(typeof(UnitNormalData))))
				{
					stream.throwTypeReadError(typeof(UnitNormalData),normalT.GetType());
				}
				this.normal.shadowCopy(normalT);
			}
		}
		else
		{
			this.normal=null;
		}
		
		if(stream.readBoolean())
		{
			BaseData posT=stream.readDataFullNotNull();
			if(posT!=null)
			{
				if(posT is UnitPosData)
				{
					this.pos=(UnitPosData)posT;
				}
				else
				{
					this.pos=new UnitPosData();
					if(!(posT.GetType().IsAssignableFrom(typeof(UnitPosData))))
					{
						stream.throwTypeReadError(typeof(UnitPosData),posT.GetType());
					}
					this.pos.shadowCopy(posT);
				}
			}
			else
			{
				this.pos=null;
			}
		}
		else
		{
			this.pos=null;
		}
		
		if(stream.readBoolean())
		{
			BaseData avatarT=stream.readDataFullNotNull();
			if(avatarT!=null)
			{
				if(avatarT is UnitAvatarData)
				{
					this.avatar=(UnitAvatarData)avatarT;
				}
				else
				{
					this.avatar=new UnitAvatarData();
					if(!(avatarT.GetType().IsAssignableFrom(typeof(UnitAvatarData))))
					{
						stream.throwTypeReadError(typeof(UnitAvatarData),avatarT.GetType());
					}
					this.avatar.shadowCopy(avatarT);
				}
			}
			else
			{
				this.avatar=null;
			}
		}
		else
		{
			this.avatar=null;
		}
		
		if(stream.readBoolean())
		{
			BaseData moveT=stream.readDataFullNotNull();
			if(moveT!=null)
			{
				if(moveT is UnitMoveData)
				{
					this.move=(UnitMoveData)moveT;
				}
				else
				{
					this.move=new UnitMoveData();
					if(!(moveT.GetType().IsAssignableFrom(typeof(UnitMoveData))))
					{
						stream.throwTypeReadError(typeof(UnitMoveData),moveT.GetType());
					}
					this.move.shadowCopy(moveT);
				}
			}
			else
			{
				this.move=null;
			}
		}
		else
		{
			this.move=null;
		}
		
		if(stream.readBoolean())
		{
			BaseData fightT=stream.readDataFullNotNull();
			if(fightT!=null)
			{
				if(fightT is UnitFightData)
				{
					this.fight=(UnitFightData)fightT;
				}
				else
				{
					this.fight=new UnitFightData();
					if(!(fightT.GetType().IsAssignableFrom(typeof(UnitFightData))))
					{
						stream.throwTypeReadError(typeof(UnitFightData),fightT.GetType());
					}
					this.fight.shadowCopy(fightT);
				}
			}
			else
			{
				this.fight=null;
			}
		}
		else
		{
			this.fight=null;
		}
		
		if(stream.readBoolean())
		{
			BaseData fightExT=stream.readDataFullNotNull();
			if(fightExT!=null)
			{
				if(fightExT is UnitFightExData)
				{
					this.fightEx=(UnitFightExData)fightExT;
				}
				else
				{
					this.fightEx=new UnitFightExData();
					if(!(fightExT.GetType().IsAssignableFrom(typeof(UnitFightExData))))
					{
						stream.throwTypeReadError(typeof(UnitFightExData),fightExT.GetType());
					}
					this.fightEx.shadowCopy(fightExT);
				}
			}
			else
			{
				this.fightEx=null;
			}
		}
		else
		{
			this.fightEx=null;
		}
		
		if(stream.readBoolean())
		{
			BaseData aiT=stream.readDataFullNotNull();
			if(aiT!=null)
			{
				if(aiT is UnitAIData)
				{
					this.ai=(UnitAIData)aiT;
				}
				else
				{
					this.ai=new UnitAIData();
					if(!(aiT.GetType().IsAssignableFrom(typeof(UnitAIData))))
					{
						stream.throwTypeReadError(typeof(UnitAIData),aiT.GetType());
					}
					this.ai.shadowCopy(aiT);
				}
			}
			else
			{
				this.ai=null;
			}
		}
		else
		{
			this.ai=null;
		}
		
		if(stream.readBoolean())
		{
			BaseData funcT=stream.readDataFullNotNull();
			if(funcT!=null)
			{
				if(funcT is UnitFuncData)
				{
					this.func=(UnitFuncData)funcT;
				}
				else
				{
					this.func=new UnitFuncData();
					if(!(funcT.GetType().IsAssignableFrom(typeof(UnitFuncData))))
					{
						stream.throwTypeReadError(typeof(UnitFuncData),funcT.GetType());
					}
					this.func.shadowCopy(funcT);
				}
			}
			else
			{
				this.func=null;
			}
		}
		else
		{
			this.func=null;
		}
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.instanceID);
		
		if(this.identity!=null)
		{
			stream.writeDataFullNotNull(this.identity);
		}
		else
		{
			nullObjError("identity");
		}
		
		if(this.normal!=null)
		{
			stream.writeDataFullNotNull(this.normal);
		}
		else
		{
			nullObjError("normal");
		}
		
		if(this.pos!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataFullNotNull(this.pos);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.avatar!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataFullNotNull(this.avatar);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.move!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataFullNotNull(this.move);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.fight!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataFullNotNull(this.fight);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.fightEx!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataFullNotNull(this.fightEx);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.ai!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataFullNotNull(this.ai);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.func!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataFullNotNull(this.func);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 获取战斗单位身份数据
	/// </summary>
	public FightUnitIdentityData getFightIdentity()
	{
		return (FightUnitIdentityData)identity;
	}
	
	public CharacterIdentityData getCharacterIdentity()
	{
		return (CharacterIdentityData)identity;
	}
	
	public MUnitIdentityData getMUnitIdentity()
	{
		return (MUnitIdentityData)identity;
	}
	
	public SceneEffectIdentityData getSceneEffectIdentity()
	{
		return (SceneEffectIdentityData)identity;
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		this.instanceID=0;
		this.identity=null;
		this.normal=null;
		this.pos=null;
		this.avatar=null;
		this.move=null;
		this.fight=null;
		this.fightEx=null;
		this.ai=null;
		this.func=null;
	}
	
}
