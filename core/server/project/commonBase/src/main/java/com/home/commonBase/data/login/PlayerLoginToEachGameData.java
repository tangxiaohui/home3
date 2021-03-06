package com.home.commonBase.data.login;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.social.RoleSocialData;
import com.home.commonBase.data.social.roleGroup.PlayerRoleGroupSaveData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.IntObjectMap;
import com.home.shine.support.collection.LongObjectMap;
import com.home.shine.support.collection.LongSet;
import com.home.shine.support.pool.DataPool;

/** 角色登录到其他逻辑服的数据(generated by shine) */
public class PlayerLoginToEachGameData extends BaseData
{
	/** 自身社交数据 */
	public RoleSocialData selfData;
	
	/** 数据类型ID */
	public static final int dataID=BaseDataType.PlayerLoginToEachGame;
	
	/** 玩家群组(key:funcID) */
	public IntObjectMap<LongObjectMap<PlayerRoleGroupSaveData>> roleGroups;
	
	/** 需要的角色社交数据组(玩家群单独算) */
	public LongSet needRoleSocials;
	
	public PlayerLoginToEachGameData()
	{
		_dataID=BaseDataType.PlayerLoginToEachGame;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "PlayerLoginToEachGameData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		BaseData selfDataT=stream.readDataFullNotNull();
		if(selfDataT!=null)
		{
			if(selfDataT instanceof RoleSocialData)
			{
				this.selfData=(RoleSocialData)selfDataT;
			}
			else
			{
				this.selfData=new RoleSocialData();
				if(!(selfDataT.getClass().isAssignableFrom(RoleSocialData.class)))
				{
					stream.throwTypeReadError(RoleSocialData.class,selfDataT.getClass());
				}
				this.selfData.shadowCopy(selfDataT);
			}
		}
		else
		{
			this.selfData=null;
		}
		
		int needRoleSocialsLen=stream.readLen();
		if(this.needRoleSocials!=null)
		{
			this.needRoleSocials.clear();
			this.needRoleSocials.ensureCapacity(needRoleSocialsLen);
		}
		else
		{
			this.needRoleSocials=new LongSet(needRoleSocialsLen);
		}
		
		LongSet needRoleSocialsT=this.needRoleSocials;
		for(int needRoleSocialsI=needRoleSocialsLen-1;needRoleSocialsI>=0;--needRoleSocialsI)
		{
			long needRoleSocialsV;
			needRoleSocialsV=stream.readLong();
			
			needRoleSocialsT.add(needRoleSocialsV);
		}
		
		int roleGroupsLen=stream.readLen();
		if(this.roleGroups!=null)
		{
			this.roleGroups.clear();
			this.roleGroups.ensureCapacity(roleGroupsLen);
		}
		else
		{
			this.roleGroups=new IntObjectMap<LongObjectMap<PlayerRoleGroupSaveData>>(LongObjectMap[]::new,roleGroupsLen);
		}
		
		IntObjectMap<LongObjectMap<PlayerRoleGroupSaveData>> roleGroupsT=this.roleGroups;
		for(int roleGroupsI=roleGroupsLen-1;roleGroupsI>=0;--roleGroupsI)
		{
			int roleGroupsK;
			LongObjectMap<PlayerRoleGroupSaveData> roleGroupsV;
			roleGroupsK=stream.readInt();
			
			int roleGroupsVLen=stream.readLen();
			roleGroupsV=new LongObjectMap<PlayerRoleGroupSaveData>(PlayerRoleGroupSaveData[]::new,roleGroupsVLen);
			LongObjectMap<PlayerRoleGroupSaveData> roleGroupsVT=roleGroupsV;
			for(int roleGroupsVI=roleGroupsVLen-1;roleGroupsVI>=0;--roleGroupsVI)
			{
				long roleGroupsVK;
				PlayerRoleGroupSaveData roleGroupsVV;
				roleGroupsVK=stream.readLong();
				
				BaseData roleGroupsVVT=stream.readDataFullNotNull();
				if(roleGroupsVVT!=null)
				{
					if(roleGroupsVVT instanceof PlayerRoleGroupSaveData)
					{
						roleGroupsVV=(PlayerRoleGroupSaveData)roleGroupsVVT;
					}
					else
					{
						roleGroupsVV=new PlayerRoleGroupSaveData();
						if(!(roleGroupsVVT.getClass().isAssignableFrom(PlayerRoleGroupSaveData.class)))
						{
							stream.throwTypeReadError(PlayerRoleGroupSaveData.class,roleGroupsVVT.getClass());
						}
						roleGroupsVV.shadowCopy(roleGroupsVVT);
					}
				}
				else
				{
					roleGroupsVV=null;
				}
				
				roleGroupsVT.put(roleGroupsVK,roleGroupsVV);
			}
			
			roleGroupsT.put(roleGroupsK,roleGroupsV);
		}
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.selfData!=null)
		{
			stream.writeDataFullNotNull(this.selfData);
		}
		else
		{
			nullObjError("selfData");
		}
		
		if(this.needRoleSocials!=null)
		{
			stream.writeLen(this.needRoleSocials.size());
			if(!this.needRoleSocials.isEmpty())
			{
				long needRoleSocialsVFreeValue=this.needRoleSocials.getFreeValue();
				long[] needRoleSocialsVKeys=this.needRoleSocials.getKeys();
				for(int needRoleSocialsVI=needRoleSocialsVKeys.length-1;needRoleSocialsVI>=0;--needRoleSocialsVI)
				{
					long needRoleSocialsV=needRoleSocialsVKeys[needRoleSocialsVI];
					if(needRoleSocialsV!=needRoleSocialsVFreeValue)
					{
						stream.writeLong(needRoleSocialsV);
						
					}
				}
			}
		}
		else
		{
			nullObjError("needRoleSocials");
		}
		
		if(this.roleGroups!=null)
		{
			stream.writeLen(this.roleGroups.size());
			if(!this.roleGroups.isEmpty())
			{
				int roleGroupsKFreeValue=this.roleGroups.getFreeValue();
				int[] roleGroupsKKeys=this.roleGroups.getKeys();
				Object[] roleGroupsVValues=this.roleGroups.getValues();
				for(int roleGroupsKI=roleGroupsKKeys.length-1;roleGroupsKI>=0;--roleGroupsKI)
				{
					int roleGroupsK=roleGroupsKKeys[roleGroupsKI];
					if(roleGroupsK!=roleGroupsKFreeValue)
					{
						LongObjectMap<PlayerRoleGroupSaveData> roleGroupsV=(LongObjectMap<PlayerRoleGroupSaveData>)roleGroupsVValues[roleGroupsKI];
						stream.writeInt(roleGroupsK);
						
						if(roleGroupsV!=null)
						{
							stream.writeLen(roleGroupsV.size());
							if(!roleGroupsV.isEmpty())
							{
								long roleGroupsVKFreeValue=roleGroupsV.getFreeValue();
								long[] roleGroupsVKKeys=roleGroupsV.getKeys();
								Object[] roleGroupsVVValues=roleGroupsV.getValues();
								for(int roleGroupsVKI=roleGroupsVKKeys.length-1;roleGroupsVKI>=0;--roleGroupsVKI)
								{
									long roleGroupsVK=roleGroupsVKKeys[roleGroupsVKI];
									if(roleGroupsVK!=roleGroupsVKFreeValue)
									{
										PlayerRoleGroupSaveData roleGroupsVV=(PlayerRoleGroupSaveData)roleGroupsVVValues[roleGroupsVKI];
										stream.writeLong(roleGroupsVK);
										
										if(roleGroupsVV!=null)
										{
											stream.writeDataFullNotNull(roleGroupsVV);
										}
										else
										{
											nullObjError("roleGroupsVV");
										}
										
									}
								}
							}
						}
						else
						{
							nullObjError("roleGroupsV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("roleGroups");
		}
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.selfData=(RoleSocialData)stream.readDataSimpleNotNull();
		
		int needRoleSocialsLen=stream.readLen();
		if(this.needRoleSocials!=null)
		{
			this.needRoleSocials.clear();
			this.needRoleSocials.ensureCapacity(needRoleSocialsLen);
		}
		else
		{
			this.needRoleSocials=new LongSet(needRoleSocialsLen);
		}
		
		LongSet needRoleSocialsT=this.needRoleSocials;
		for(int needRoleSocialsI=needRoleSocialsLen-1;needRoleSocialsI>=0;--needRoleSocialsI)
		{
			long needRoleSocialsV;
			needRoleSocialsV=stream.readLong();
			
			needRoleSocialsT.add(needRoleSocialsV);
		}
		
		int roleGroupsLen=stream.readLen();
		if(this.roleGroups!=null)
		{
			this.roleGroups.clear();
			this.roleGroups.ensureCapacity(roleGroupsLen);
		}
		else
		{
			this.roleGroups=new IntObjectMap<LongObjectMap<PlayerRoleGroupSaveData>>(LongObjectMap[]::new,roleGroupsLen);
		}
		
		IntObjectMap<LongObjectMap<PlayerRoleGroupSaveData>> roleGroupsT=this.roleGroups;
		for(int roleGroupsI=roleGroupsLen-1;roleGroupsI>=0;--roleGroupsI)
		{
			int roleGroupsK;
			LongObjectMap<PlayerRoleGroupSaveData> roleGroupsV;
			roleGroupsK=stream.readInt();
			
			int roleGroupsVLen=stream.readLen();
			roleGroupsV=new LongObjectMap<PlayerRoleGroupSaveData>(PlayerRoleGroupSaveData[]::new,roleGroupsVLen);
			LongObjectMap<PlayerRoleGroupSaveData> roleGroupsVT=roleGroupsV;
			for(int roleGroupsVI=roleGroupsVLen-1;roleGroupsVI>=0;--roleGroupsVI)
			{
				long roleGroupsVK;
				PlayerRoleGroupSaveData roleGroupsVV;
				roleGroupsVK=stream.readLong();
				
				roleGroupsVV=(PlayerRoleGroupSaveData)stream.readDataSimpleNotNull();
				
				roleGroupsVT.put(roleGroupsVK,roleGroupsVV);
			}
			
			roleGroupsT.put(roleGroupsK,roleGroupsV);
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.selfData!=null)
		{
			stream.writeDataSimpleNotNull(this.selfData);
		}
		else
		{
			nullObjError("selfData");
		}
		
		if(this.needRoleSocials!=null)
		{
			stream.writeLen(this.needRoleSocials.size());
			if(!this.needRoleSocials.isEmpty())
			{
				long needRoleSocialsVFreeValue=this.needRoleSocials.getFreeValue();
				long[] needRoleSocialsVKeys=this.needRoleSocials.getKeys();
				for(int needRoleSocialsVI=needRoleSocialsVKeys.length-1;needRoleSocialsVI>=0;--needRoleSocialsVI)
				{
					long needRoleSocialsV=needRoleSocialsVKeys[needRoleSocialsVI];
					if(needRoleSocialsV!=needRoleSocialsVFreeValue)
					{
						stream.writeLong(needRoleSocialsV);
						
					}
				}
			}
		}
		else
		{
			nullObjError("needRoleSocials");
		}
		
		if(this.roleGroups!=null)
		{
			stream.writeLen(this.roleGroups.size());
			if(!this.roleGroups.isEmpty())
			{
				int roleGroupsKFreeValue=this.roleGroups.getFreeValue();
				int[] roleGroupsKKeys=this.roleGroups.getKeys();
				Object[] roleGroupsVValues=this.roleGroups.getValues();
				for(int roleGroupsKI=roleGroupsKKeys.length-1;roleGroupsKI>=0;--roleGroupsKI)
				{
					int roleGroupsK=roleGroupsKKeys[roleGroupsKI];
					if(roleGroupsK!=roleGroupsKFreeValue)
					{
						LongObjectMap<PlayerRoleGroupSaveData> roleGroupsV=(LongObjectMap<PlayerRoleGroupSaveData>)roleGroupsVValues[roleGroupsKI];
						stream.writeInt(roleGroupsK);
						
						if(roleGroupsV!=null)
						{
							stream.writeLen(roleGroupsV.size());
							if(!roleGroupsV.isEmpty())
							{
								long roleGroupsVKFreeValue=roleGroupsV.getFreeValue();
								long[] roleGroupsVKKeys=roleGroupsV.getKeys();
								Object[] roleGroupsVVValues=roleGroupsV.getValues();
								for(int roleGroupsVKI=roleGroupsVKKeys.length-1;roleGroupsVKI>=0;--roleGroupsVKI)
								{
									long roleGroupsVK=roleGroupsVKKeys[roleGroupsVKI];
									if(roleGroupsVK!=roleGroupsVKFreeValue)
									{
										PlayerRoleGroupSaveData roleGroupsVV=(PlayerRoleGroupSaveData)roleGroupsVVValues[roleGroupsVKI];
										stream.writeLong(roleGroupsVK);
										
										if(roleGroupsVV!=null)
										{
											stream.writeDataSimpleNotNull(roleGroupsVV);
										}
										else
										{
											nullObjError("roleGroupsVV");
										}
										
									}
								}
							}
						}
						else
						{
							nullObjError("roleGroupsV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("roleGroups");
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof PlayerLoginToEachGameData))
			return;
		
		PlayerLoginToEachGameData mData=(PlayerLoginToEachGameData)data;
		
		this.selfData=mData.selfData;
		this.needRoleSocials=mData.needRoleSocials;
		this.roleGroups=mData.roleGroups;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof PlayerLoginToEachGameData))
			return;
		
		PlayerLoginToEachGameData mData=(PlayerLoginToEachGameData)data;
		
		if(mData.selfData!=null)
		{
			this.selfData=(RoleSocialData)mData.selfData.clone();
		}
		else
		{
			this.selfData=null;
			nullObjError("selfData");
		}
		
		if(mData.needRoleSocials!=null)
		{
			if(this.needRoleSocials!=null)
			{
				this.needRoleSocials.clear();
				this.needRoleSocials.ensureCapacity(mData.needRoleSocials.size());
			}
			else
			{
				this.needRoleSocials=new LongSet(mData.needRoleSocials.size());
			}
			
			LongSet needRoleSocialsT=this.needRoleSocials;
			if(!mData.needRoleSocials.isEmpty())
			{
				long needRoleSocialsVFreeValue=mData.needRoleSocials.getFreeValue();
				long[] needRoleSocialsVKeys=mData.needRoleSocials.getKeys();
				for(int needRoleSocialsVI=needRoleSocialsVKeys.length-1;needRoleSocialsVI>=0;--needRoleSocialsVI)
				{
					long needRoleSocialsV=needRoleSocialsVKeys[needRoleSocialsVI];
					if(needRoleSocialsV!=needRoleSocialsVFreeValue)
					{
						long needRoleSocialsU;
						needRoleSocialsU=needRoleSocialsV;
						
						needRoleSocialsT.add(needRoleSocialsU);
					}
				}
			}
		}
		else
		{
			this.needRoleSocials=null;
			nullObjError("needRoleSocials");
		}
		
		if(mData.roleGroups!=null)
		{
			if(this.roleGroups!=null)
			{
				this.roleGroups.clear();
				this.roleGroups.ensureCapacity(mData.roleGroups.size());
			}
			else
			{
				this.roleGroups=new IntObjectMap<LongObjectMap<PlayerRoleGroupSaveData>>(LongObjectMap[]::new,mData.roleGroups.size());
			}
			
			IntObjectMap<LongObjectMap<PlayerRoleGroupSaveData>> roleGroupsT=this.roleGroups;
			if(!mData.roleGroups.isEmpty())
			{
				int roleGroupsKFreeValue=mData.roleGroups.getFreeValue();
				int[] roleGroupsKKeys=mData.roleGroups.getKeys();
				Object[] roleGroupsVValues=mData.roleGroups.getValues();
				for(int roleGroupsKI=roleGroupsKKeys.length-1;roleGroupsKI>=0;--roleGroupsKI)
				{
					int roleGroupsK=roleGroupsKKeys[roleGroupsKI];
					if(roleGroupsK!=roleGroupsKFreeValue)
					{
						LongObjectMap<PlayerRoleGroupSaveData> roleGroupsV=(LongObjectMap<PlayerRoleGroupSaveData>)roleGroupsVValues[roleGroupsKI];
						int roleGroupsW;
						LongObjectMap<PlayerRoleGroupSaveData> roleGroupsU;
						roleGroupsW=roleGroupsK;
						
						if(roleGroupsV!=null)
						{
							roleGroupsU=new LongObjectMap<PlayerRoleGroupSaveData>(PlayerRoleGroupSaveData[]::new,roleGroupsV.size());
							LongObjectMap<PlayerRoleGroupSaveData> roleGroupsUT=roleGroupsU;
							if(!roleGroupsV.isEmpty())
							{
								long roleGroupsUKFreeValue=roleGroupsV.getFreeValue();
								long[] roleGroupsUKKeys=roleGroupsV.getKeys();
								Object[] roleGroupsUVValues=roleGroupsV.getValues();
								for(int roleGroupsUKI=roleGroupsUKKeys.length-1;roleGroupsUKI>=0;--roleGroupsUKI)
								{
									long roleGroupsUK=roleGroupsUKKeys[roleGroupsUKI];
									if(roleGroupsUK!=roleGroupsUKFreeValue)
									{
										PlayerRoleGroupSaveData roleGroupsUV=(PlayerRoleGroupSaveData)roleGroupsUVValues[roleGroupsUKI];
										long roleGroupsUW;
										PlayerRoleGroupSaveData roleGroupsUU;
										roleGroupsUW=roleGroupsUK;
										
										if(roleGroupsUV!=null)
										{
											roleGroupsUU=(PlayerRoleGroupSaveData)roleGroupsUV.clone();
										}
										else
										{
											roleGroupsUU=null;
											nullObjError("roleGroupsUU");
										}
										
										roleGroupsUT.put(roleGroupsUW,roleGroupsUU);
									}
								}
							}
						}
						else
						{
							roleGroupsU=null;
							nullObjError("roleGroupsU");
						}
						
						roleGroupsT.put(roleGroupsW,roleGroupsU);
					}
				}
			}
		}
		else
		{
			this.roleGroups=null;
			nullObjError("roleGroups");
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		PlayerLoginToEachGameData mData=(PlayerLoginToEachGameData)data;
		if(mData.selfData!=null)
		{
			if(this.selfData==null)
				return false;
			if(!this.selfData.dataEquals(mData.selfData))
				return false;
		}
		else
		{
			if(this.selfData!=null)
				return false;
		}
		
		if(mData.needRoleSocials!=null)
		{
			if(this.needRoleSocials==null)
				return false;
			if(this.needRoleSocials.size()!=mData.needRoleSocials.size())
				return false;
			LongSet needRoleSocialsR=mData.needRoleSocials;
			if(!this.needRoleSocials.isEmpty())
			{
				long needRoleSocialsVFreeValue=this.needRoleSocials.getFreeValue();
				long[] needRoleSocialsVKeys=this.needRoleSocials.getKeys();
				for(int needRoleSocialsVI=needRoleSocialsVKeys.length-1;needRoleSocialsVI>=0;--needRoleSocialsVI)
				{
					long needRoleSocialsV=needRoleSocialsVKeys[needRoleSocialsVI];
					if(needRoleSocialsV!=needRoleSocialsVFreeValue)
					{
						if(!needRoleSocialsR.contains(needRoleSocialsV))
							return false;
					}
				}
			}
		}
		else
		{
			if(this.needRoleSocials!=null)
				return false;
		}
		
		if(mData.roleGroups!=null)
		{
			if(this.roleGroups==null)
				return false;
			if(this.roleGroups.size()!=mData.roleGroups.size())
				return false;
			IntObjectMap<LongObjectMap<PlayerRoleGroupSaveData>> roleGroupsR=mData.roleGroups;
			if(!this.roleGroups.isEmpty())
			{
				int roleGroupsKFreeValue=this.roleGroups.getFreeValue();
				int[] roleGroupsKKeys=this.roleGroups.getKeys();
				Object[] roleGroupsVValues=this.roleGroups.getValues();
				for(int roleGroupsKI=roleGroupsKKeys.length-1;roleGroupsKI>=0;--roleGroupsKI)
				{
					int roleGroupsK=roleGroupsKKeys[roleGroupsKI];
					if(roleGroupsK!=roleGroupsKFreeValue)
					{
						LongObjectMap<PlayerRoleGroupSaveData> roleGroupsV=(LongObjectMap<PlayerRoleGroupSaveData>)roleGroupsVValues[roleGroupsKI];
						LongObjectMap<PlayerRoleGroupSaveData> roleGroupsU=roleGroupsR.get(roleGroupsK);
						if(roleGroupsU!=null)
						{
							if(roleGroupsV==null)
								return false;
							if(roleGroupsV.size()!=roleGroupsU.size())
								return false;
							LongObjectMap<PlayerRoleGroupSaveData> roleGroupsVR=roleGroupsU;
							if(!roleGroupsV.isEmpty())
							{
								long roleGroupsVKFreeValue=roleGroupsV.getFreeValue();
								long[] roleGroupsVKKeys=roleGroupsV.getKeys();
								Object[] roleGroupsVVValues=roleGroupsV.getValues();
								for(int roleGroupsVKI=roleGroupsVKKeys.length-1;roleGroupsVKI>=0;--roleGroupsVKI)
								{
									long roleGroupsVK=roleGroupsVKKeys[roleGroupsVKI];
									if(roleGroupsVK!=roleGroupsVKFreeValue)
									{
										PlayerRoleGroupSaveData roleGroupsVV=(PlayerRoleGroupSaveData)roleGroupsVVValues[roleGroupsVKI];
										PlayerRoleGroupSaveData roleGroupsVU=roleGroupsVR.get(roleGroupsVK);
										if(roleGroupsVU!=null)
										{
											if(roleGroupsVV==null)
												return false;
											if(!roleGroupsVV.dataEquals(roleGroupsVU))
												return false;
										}
										else
										{
											if(roleGroupsVV!=null)
												return false;
										}
										
									}
								}
							}
						}
						else
						{
							if(roleGroupsV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.roleGroups!=null)
				return false;
		}
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("selfData");
		writer.sb.append(':');
		if(this.selfData!=null)
		{
			this.selfData.writeDataString(writer);
		}
		else
		{
			writer.sb.append("RoleSocialData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("needRoleSocials");
		writer.sb.append(':');
		writer.sb.append("Set<long>");
		if(this.needRoleSocials!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.needRoleSocials.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.needRoleSocials.isEmpty())
			{
				long needRoleSocialsVFreeValue=this.needRoleSocials.getFreeValue();
				long[] needRoleSocialsVKeys=this.needRoleSocials.getKeys();
				for(int needRoleSocialsVI=needRoleSocialsVKeys.length-1;needRoleSocialsVI>=0;--needRoleSocialsVI)
				{
					long needRoleSocialsV=needRoleSocialsVKeys[needRoleSocialsVI];
					if(needRoleSocialsV!=needRoleSocialsVFreeValue)
					{
						writer.writeTabs();
						writer.sb.append(needRoleSocialsV);
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("roleGroups");
		writer.sb.append(':');
		writer.sb.append("Map<int,LongObjectMap<PlayerRoleGroupSaveData>>");
		if(this.roleGroups!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.roleGroups.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.roleGroups.isEmpty())
			{
				int roleGroupsKFreeValue=this.roleGroups.getFreeValue();
				int[] roleGroupsKKeys=this.roleGroups.getKeys();
				Object[] roleGroupsVValues=this.roleGroups.getValues();
				for(int roleGroupsKI=roleGroupsKKeys.length-1;roleGroupsKI>=0;--roleGroupsKI)
				{
					int roleGroupsK=roleGroupsKKeys[roleGroupsKI];
					if(roleGroupsK!=roleGroupsKFreeValue)
					{
						LongObjectMap<PlayerRoleGroupSaveData> roleGroupsV=(LongObjectMap<PlayerRoleGroupSaveData>)roleGroupsVValues[roleGroupsKI];
						writer.writeTabs();
						writer.sb.append(roleGroupsK);
						
						writer.sb.append(':');
						writer.sb.append("Map<long,PlayerRoleGroupSaveData>");
						if(roleGroupsV!=null)
						{
							writer.sb.append('(');
							writer.sb.append(roleGroupsV.size());
							writer.sb.append(')');
							writer.writeEnter();
							writer.writeLeftBrace();
							if(!roleGroupsV.isEmpty())
							{
								long roleGroupsVKFreeValue=roleGroupsV.getFreeValue();
								long[] roleGroupsVKKeys=roleGroupsV.getKeys();
								Object[] roleGroupsVVValues=roleGroupsV.getValues();
								for(int roleGroupsVKI=roleGroupsVKKeys.length-1;roleGroupsVKI>=0;--roleGroupsVKI)
								{
									long roleGroupsVK=roleGroupsVKKeys[roleGroupsVKI];
									if(roleGroupsVK!=roleGroupsVKFreeValue)
									{
										PlayerRoleGroupSaveData roleGroupsVV=(PlayerRoleGroupSaveData)roleGroupsVVValues[roleGroupsVKI];
										writer.writeTabs();
										writer.sb.append(roleGroupsVK);
										
										writer.sb.append(':');
										if(roleGroupsVV!=null)
										{
											roleGroupsVV.writeDataString(writer);
										}
										else
										{
											writer.sb.append("PlayerRoleGroupSaveData=null");
										}
										
										writer.writeEnter();
									}
								}
							}
							writer.writeRightBrace();
						}
						else
						{
							writer.sb.append("=null");
						}
						
						writer.writeEnter();
					}
				}
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		this.selfData=new RoleSocialData();
		this.selfData.initDefault();
		this.needRoleSocials=new LongSet();
		this.roleGroups=new IntObjectMap<LongObjectMap<PlayerRoleGroupSaveData>>(LongObjectMap[]::new);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.selfData=null;
		this.needRoleSocials=null;
		this.roleGroups=null;
	}
	
}
