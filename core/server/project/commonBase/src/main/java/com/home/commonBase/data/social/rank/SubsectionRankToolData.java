package com.home.commonBase.data.social.rank;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.func.FuncToolData;
import com.home.commonBase.data.social.rank.RankData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.IntObjectMap;
import com.home.shine.support.collection.SList;
import com.home.shine.support.pool.DataPool;

/** 分段排行榜数据(存库数据)(generated by shine) */
public class SubsectionRankToolData extends FuncToolData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.SubsectionRankTool;
	
	/** 大组index,小组index,排行榜列表 */
	public IntObjectMap<SList<SList<RankData>>> listListMap;
	
	/** 当前排行版本(刷新一次一个版本) */
	public int version;
	
	public SubsectionRankToolData()
	{
		_dataID=BaseDataType.SubsectionRankTool;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "SubsectionRankToolData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.version=stream.readInt();
		
		int listListMapLen=stream.readLen();
		if(this.listListMap!=null)
		{
			this.listListMap.clear();
			this.listListMap.ensureCapacity(listListMapLen);
		}
		else
		{
			this.listListMap=new IntObjectMap<SList<SList<RankData>>>(SList[]::new,listListMapLen);
		}
		
		IntObjectMap<SList<SList<RankData>>> listListMapT=this.listListMap;
		for(int listListMapI=listListMapLen-1;listListMapI>=0;--listListMapI)
		{
			int listListMapK;
			SList<SList<RankData>> listListMapV;
			listListMapK=stream.readInt();
			
			int listListMapVLen=stream.readLen();
			listListMapV=new SList<SList<RankData>>(SList[]::new,listListMapVLen);
			SList<SList<RankData>> listListMapVT=listListMapV;
			for(int listListMapVI=listListMapVLen-1;listListMapVI>=0;--listListMapVI)
			{
				SList<RankData> listListMapVV;
				int listListMapVVLen=stream.readLen();
				listListMapVV=new SList<RankData>(RankData[]::new,listListMapVVLen);
				SList<RankData> listListMapVVT=listListMapVV;
				for(int listListMapVVI=listListMapVVLen-1;listListMapVVI>=0;--listListMapVVI)
				{
					RankData listListMapVVV;
					BaseData listListMapVVVT=stream.readDataFullNotNull();
					if(listListMapVVVT!=null)
					{
						if(listListMapVVVT instanceof RankData)
						{
							listListMapVVV=(RankData)listListMapVVVT;
						}
						else
						{
							listListMapVVV=new RankData();
							if(!(listListMapVVVT.getClass().isAssignableFrom(RankData.class)))
							{
								stream.throwTypeReadError(RankData.class,listListMapVVVT.getClass());
							}
							listListMapVVV.shadowCopy(listListMapVVVT);
						}
					}
					else
					{
						listListMapVVV=null;
					}
					
					listListMapVVT.add(listListMapVVV);
				}
				
				listListMapVT.add(listListMapVV);
			}
			
			listListMapT.put(listListMapK,listListMapV);
		}
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.version);
		
		if(this.listListMap!=null)
		{
			stream.writeLen(this.listListMap.size());
			if(!this.listListMap.isEmpty())
			{
				int listListMapKFreeValue=this.listListMap.getFreeValue();
				int[] listListMapKKeys=this.listListMap.getKeys();
				Object[] listListMapVValues=this.listListMap.getValues();
				for(int listListMapKI=listListMapKKeys.length-1;listListMapKI>=0;--listListMapKI)
				{
					int listListMapK=listListMapKKeys[listListMapKI];
					if(listListMapK!=listListMapKFreeValue)
					{
						SList<SList<RankData>> listListMapV=(SList<SList<RankData>>)listListMapVValues[listListMapKI];
						stream.writeInt(listListMapK);
						
						if(listListMapV!=null)
						{
							stream.writeLen(listListMapV.size());
							if(!listListMapV.isEmpty())
							{
								Object[] listListMapVVValues=listListMapV.getValues();
								for(int listListMapVVI=0,listListMapVVLen=listListMapV.length();listListMapVVI<listListMapVVLen;++listListMapVVI)
								{
									SList<RankData> listListMapVV=(SList<RankData>)listListMapVVValues[listListMapVVI];
									if(listListMapVV!=null)
									{
										stream.writeLen(listListMapVV.size());
										if(!listListMapVV.isEmpty())
										{
											Object[] listListMapVVVValues=listListMapVV.getValues();
											for(int listListMapVVVI=0,listListMapVVVLen=listListMapVV.length();listListMapVVVI<listListMapVVVLen;++listListMapVVVI)
											{
												RankData listListMapVVV=(RankData)listListMapVVVValues[listListMapVVVI];
												if(listListMapVVV!=null)
												{
													stream.writeDataFullNotNull(listListMapVVV);
												}
												else
												{
													nullObjError("listListMapVVV");
												}
												
											}
										}
									}
									else
									{
										nullObjError("listListMapVV");
									}
									
								}
							}
						}
						else
						{
							nullObjError("listListMapV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("listListMap");
		}
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.version=stream.readInt();
		
		int listListMapLen=stream.readLen();
		if(this.listListMap!=null)
		{
			this.listListMap.clear();
			this.listListMap.ensureCapacity(listListMapLen);
		}
		else
		{
			this.listListMap=new IntObjectMap<SList<SList<RankData>>>(SList[]::new,listListMapLen);
		}
		
		IntObjectMap<SList<SList<RankData>>> listListMapT=this.listListMap;
		for(int listListMapI=listListMapLen-1;listListMapI>=0;--listListMapI)
		{
			int listListMapK;
			SList<SList<RankData>> listListMapV;
			listListMapK=stream.readInt();
			
			int listListMapVLen=stream.readLen();
			listListMapV=new SList<SList<RankData>>(SList[]::new,listListMapVLen);
			SList<SList<RankData>> listListMapVT=listListMapV;
			for(int listListMapVI=listListMapVLen-1;listListMapVI>=0;--listListMapVI)
			{
				SList<RankData> listListMapVV;
				int listListMapVVLen=stream.readLen();
				listListMapVV=new SList<RankData>(RankData[]::new,listListMapVVLen);
				SList<RankData> listListMapVVT=listListMapVV;
				for(int listListMapVVI=listListMapVVLen-1;listListMapVVI>=0;--listListMapVVI)
				{
					RankData listListMapVVV;
					listListMapVVV=(RankData)stream.readDataSimpleNotNull();
					
					listListMapVVT.add(listListMapVVV);
				}
				
				listListMapVT.add(listListMapVV);
			}
			
			listListMapT.put(listListMapK,listListMapV);
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.version);
		
		if(this.listListMap!=null)
		{
			stream.writeLen(this.listListMap.size());
			if(!this.listListMap.isEmpty())
			{
				int listListMapKFreeValue=this.listListMap.getFreeValue();
				int[] listListMapKKeys=this.listListMap.getKeys();
				Object[] listListMapVValues=this.listListMap.getValues();
				for(int listListMapKI=listListMapKKeys.length-1;listListMapKI>=0;--listListMapKI)
				{
					int listListMapK=listListMapKKeys[listListMapKI];
					if(listListMapK!=listListMapKFreeValue)
					{
						SList<SList<RankData>> listListMapV=(SList<SList<RankData>>)listListMapVValues[listListMapKI];
						stream.writeInt(listListMapK);
						
						if(listListMapV!=null)
						{
							stream.writeLen(listListMapV.size());
							if(!listListMapV.isEmpty())
							{
								Object[] listListMapVVValues=listListMapV.getValues();
								for(int listListMapVVI=0,listListMapVVLen=listListMapV.length();listListMapVVI<listListMapVVLen;++listListMapVVI)
								{
									SList<RankData> listListMapVV=(SList<RankData>)listListMapVVValues[listListMapVVI];
									if(listListMapVV!=null)
									{
										stream.writeLen(listListMapVV.size());
										if(!listListMapVV.isEmpty())
										{
											Object[] listListMapVVVValues=listListMapVV.getValues();
											for(int listListMapVVVI=0,listListMapVVVLen=listListMapVV.length();listListMapVVVI<listListMapVVVLen;++listListMapVVVI)
											{
												RankData listListMapVVV=(RankData)listListMapVVVValues[listListMapVVVI];
												if(listListMapVVV!=null)
												{
													stream.writeDataSimpleNotNull(listListMapVVV);
												}
												else
												{
													nullObjError("listListMapVVV");
												}
												
											}
										}
									}
									else
									{
										nullObjError("listListMapVV");
									}
									
								}
							}
						}
						else
						{
							nullObjError("listListMapV");
						}
						
					}
				}
			}
		}
		else
		{
			nullObjError("listListMap");
		}
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		super.toShadowCopy(data);
		
		if(!(data instanceof SubsectionRankToolData))
			return;
		
		SubsectionRankToolData mData=(SubsectionRankToolData)data;
		
		this.version=mData.version;
		this.listListMap=mData.listListMap;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		super.toCopy(data);
		
		if(!(data instanceof SubsectionRankToolData))
			return;
		
		SubsectionRankToolData mData=(SubsectionRankToolData)data;
		
		this.version=mData.version;
		
		if(mData.listListMap!=null)
		{
			if(this.listListMap!=null)
			{
				this.listListMap.clear();
				this.listListMap.ensureCapacity(mData.listListMap.size());
			}
			else
			{
				this.listListMap=new IntObjectMap<SList<SList<RankData>>>(SList[]::new,mData.listListMap.size());
			}
			
			IntObjectMap<SList<SList<RankData>>> listListMapT=this.listListMap;
			if(!mData.listListMap.isEmpty())
			{
				int listListMapKFreeValue=mData.listListMap.getFreeValue();
				int[] listListMapKKeys=mData.listListMap.getKeys();
				Object[] listListMapVValues=mData.listListMap.getValues();
				for(int listListMapKI=listListMapKKeys.length-1;listListMapKI>=0;--listListMapKI)
				{
					int listListMapK=listListMapKKeys[listListMapKI];
					if(listListMapK!=listListMapKFreeValue)
					{
						SList<SList<RankData>> listListMapV=(SList<SList<RankData>>)listListMapVValues[listListMapKI];
						int listListMapW;
						SList<SList<RankData>> listListMapU;
						listListMapW=listListMapK;
						
						if(listListMapV!=null)
						{
							listListMapU=new SList<SList<RankData>>(SList[]::new,listListMapV.size());
							SList<SList<RankData>> listListMapUT=listListMapU;
							if(!listListMapV.isEmpty())
							{
								Object[] listListMapUVValues=listListMapV.getValues();
								for(int listListMapUVI=0,listListMapUVLen=listListMapV.length();listListMapUVI<listListMapUVLen;++listListMapUVI)
								{
									SList<RankData> listListMapUV=(SList<RankData>)listListMapUVValues[listListMapUVI];
									SList<RankData> listListMapUU;
									if(listListMapUV!=null)
									{
										listListMapUU=new SList<RankData>(RankData[]::new,listListMapUV.size());
										SList<RankData> listListMapUUT=listListMapUU;
										if(!listListMapUV.isEmpty())
										{
											Object[] listListMapUUVValues=listListMapUV.getValues();
											for(int listListMapUUVI=0,listListMapUUVLen=listListMapUV.length();listListMapUUVI<listListMapUUVLen;++listListMapUUVI)
											{
												RankData listListMapUUV=(RankData)listListMapUUVValues[listListMapUUVI];
												RankData listListMapUUU;
												if(listListMapUUV!=null)
												{
													listListMapUUU=(RankData)listListMapUUV.clone();
												}
												else
												{
													listListMapUUU=null;
													nullObjError("listListMapUUU");
												}
												
												listListMapUUT.add(listListMapUUU);
											}
										}
									}
									else
									{
										listListMapUU=null;
										nullObjError("listListMapUU");
									}
									
									listListMapUT.add(listListMapUU);
								}
							}
						}
						else
						{
							listListMapU=null;
							nullObjError("listListMapU");
						}
						
						listListMapT.put(listListMapW,listListMapU);
					}
				}
			}
		}
		else
		{
			this.listListMap=null;
			nullObjError("listListMap");
		}
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		if(!super.toDataEquals(data))
			return false;
		
		SubsectionRankToolData mData=(SubsectionRankToolData)data;
		if(this.version!=mData.version)
			return false;
		
		if(mData.listListMap!=null)
		{
			if(this.listListMap==null)
				return false;
			if(this.listListMap.size()!=mData.listListMap.size())
				return false;
			IntObjectMap<SList<SList<RankData>>> listListMapR=mData.listListMap;
			if(!this.listListMap.isEmpty())
			{
				int listListMapKFreeValue=this.listListMap.getFreeValue();
				int[] listListMapKKeys=this.listListMap.getKeys();
				Object[] listListMapVValues=this.listListMap.getValues();
				for(int listListMapKI=listListMapKKeys.length-1;listListMapKI>=0;--listListMapKI)
				{
					int listListMapK=listListMapKKeys[listListMapKI];
					if(listListMapK!=listListMapKFreeValue)
					{
						SList<SList<RankData>> listListMapV=(SList<SList<RankData>>)listListMapVValues[listListMapKI];
						SList<SList<RankData>> listListMapU=listListMapR.get(listListMapK);
						if(listListMapU!=null)
						{
							if(listListMapV==null)
								return false;
							if(listListMapV.size()!=listListMapU.size())
								return false;
							SList<SList<RankData>> listListMapVT=listListMapV;
							SList<SList<RankData>> listListMapVR=listListMapU;
							int listListMapVLen=listListMapVT.size();
							for(int listListMapVI=0;listListMapVI<listListMapVLen;++listListMapVI)
							{
								SList<RankData> listListMapVU=listListMapVT.get(listListMapVI);
								SList<RankData> listListMapVV=listListMapVR.get(listListMapVI);
								if(listListMapVV!=null)
								{
									if(listListMapVU==null)
										return false;
									if(listListMapVU.size()!=listListMapVV.size())
										return false;
									SList<RankData> listListMapVUT=listListMapVU;
									SList<RankData> listListMapVUR=listListMapVV;
									int listListMapVULen=listListMapVUT.size();
									for(int listListMapVUI=0;listListMapVUI<listListMapVULen;++listListMapVUI)
									{
										RankData listListMapVUU=listListMapVUT.get(listListMapVUI);
										RankData listListMapVUV=listListMapVUR.get(listListMapVUI);
										if(listListMapVUV!=null)
										{
											if(listListMapVUU==null)
												return false;
											if(!listListMapVUU.dataEquals(listListMapVUV))
												return false;
										}
										else
										{
											if(listListMapVUU!=null)
												return false;
										}
										
									}
								}
								else
								{
									if(listListMapVU!=null)
										return false;
								}
								
							}
						}
						else
						{
							if(listListMapV!=null)
								return false;
						}
						
					}
				}
			}
		}
		else
		{
			if(this.listListMap!=null)
				return false;
		}
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("version");
		writer.sb.append(':');
		writer.sb.append(this.version);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("listListMap");
		writer.sb.append(':');
		writer.sb.append("Map<int,SList<SList<RankData>>>");
		if(this.listListMap!=null)
		{
			writer.sb.append('(');
			writer.sb.append(this.listListMap.size());
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			if(!this.listListMap.isEmpty())
			{
				int listListMapKFreeValue=this.listListMap.getFreeValue();
				int[] listListMapKKeys=this.listListMap.getKeys();
				Object[] listListMapVValues=this.listListMap.getValues();
				for(int listListMapKI=listListMapKKeys.length-1;listListMapKI>=0;--listListMapKI)
				{
					int listListMapK=listListMapKKeys[listListMapKI];
					if(listListMapK!=listListMapKFreeValue)
					{
						SList<SList<RankData>> listListMapV=(SList<SList<RankData>>)listListMapVValues[listListMapKI];
						writer.writeTabs();
						writer.sb.append(listListMapK);
						
						writer.sb.append(':');
						writer.sb.append("List<SList<RankData>>");
						if(listListMapV!=null)
						{
							SList<SList<RankData>> listListMapVT=listListMapV;
							int listListMapVLen=listListMapVT.size();
							writer.sb.append('(');
							writer.sb.append(listListMapVLen);
							writer.sb.append(')');
							writer.writeEnter();
							writer.writeLeftBrace();
							for(int listListMapVI=0;listListMapVI<listListMapVLen;++listListMapVI)
							{
								SList<RankData> listListMapVV=listListMapVT.get(listListMapVI);
								writer.writeTabs();
								writer.sb.append(listListMapVI);
								writer.sb.append(':');
								writer.sb.append("List<RankData>");
								if(listListMapVV!=null)
								{
									SList<RankData> listListMapVVT=listListMapVV;
									int listListMapVVLen=listListMapVVT.size();
									writer.sb.append('(');
									writer.sb.append(listListMapVVLen);
									writer.sb.append(')');
									writer.writeEnter();
									writer.writeLeftBrace();
									for(int listListMapVVI=0;listListMapVVI<listListMapVVLen;++listListMapVVI)
									{
										RankData listListMapVVV=listListMapVVT.get(listListMapVVI);
										writer.writeTabs();
										writer.sb.append(listListMapVVI);
										writer.sb.append(':');
										if(listListMapVVV!=null)
										{
											listListMapVVV.writeDataString(writer);
										}
										else
										{
											writer.sb.append("RankData=null");
										}
										
										writer.writeEnter();
									}
									writer.writeRightBrace();
								}
								else
								{
									writer.sb.append("=null");
								}
								
								writer.writeEnter();
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
		super.initDefault();
		
		this.listListMap=new IntObjectMap<SList<SList<RankData>>>(SList[]::new);
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.version=0;
		this.listListMap=null;
	}
	
}
