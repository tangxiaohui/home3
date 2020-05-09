using ShineEngine;

/// <summary>
/// 单位模型表(generated by shine)
/// </summary>
public class ModelConfig:BaseConfig
{
	/** 存储集合 */
	private static IntObjectMap<ModelConfig> _dic;
	
	/// <summary>
	/// 默认部件显示
	/// </summary>
	public DIntData[] showParts;
	
	/// <summary>
	/// 默认部件显示转
	/// </summary>
	public IntIntMap showPartsT;
	
	/// <summary>
	/// 触碰半径
	/// </summary>
	public float collideRadius;
	
	/// <summary>
	/// 默认碰撞矩形(2D)
	/// </summary>
	public float[] defaultHitRect;
	
	/// <summary>
	/// 单位高度
	/// </summary>
	public float height;
	
	/// <summary>
	/// 默认碰撞矩形转
	/// </summary>
	public SRect defaultHitRectT;
	
	/// <summary>
	/// 模型id
	/// </summary>
	public int id;
	
	/// <summary>
	/// 资源
	/// </summary>
	public string source;
	
	/// <summary>
	/// 资源(资源转)
	/// </summary>
	public int sourceT;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static ModelConfig get(int id)
	{
		return _dic.get(id);
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(IntObjectMap<ModelConfig> dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(IntObjectMap<ModelConfig> dic)
	{
		_dic.putAll(dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static IntObjectMap<ModelConfig> getDic()
	{
		return _dic;
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		base.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		int showPartsLen=stream.readLen();
		if(this.showParts==null || this.showParts.Length!=showPartsLen)
		{
			this.showParts=new DIntData[showPartsLen];
		}
		DIntData[] showPartsT=this.showParts;
		for(int showPartsI=0;showPartsI<showPartsLen;++showPartsI)
		{
			DIntData showPartsV;
			showPartsV=(DIntData)stream.createData(DIntData.dataID);
			showPartsV.readBytesSimple(stream);
			
			showPartsT[showPartsI]=showPartsV;
		}
		
		this.source=stream.readUTF();
		
		this.collideRadius=stream.readFloat();
		
		int defaultHitRectLen=stream.readLen();
		if(this.defaultHitRect==null || this.defaultHitRect.Length!=defaultHitRectLen)
		{
			this.defaultHitRect=new float[defaultHitRectLen];
		}
		float[] defaultHitRectT=this.defaultHitRect;
		for(int defaultHitRectI=0;defaultHitRectI<defaultHitRectLen;++defaultHitRectI)
		{
			float defaultHitRectV;
			defaultHitRectV=stream.readFloat();
			
			defaultHitRectT[defaultHitRectI]=defaultHitRectV;
		}
		
		this.height=stream.readFloat();
		
	}
	
	/// <summary>
	/// 读完表后处理
	/// </summary>
	protected override void afterReadConfig()
	{
		base.afterReadConfig();

		showPartsT=ObjectUtils.parseIntIntMapByDIntArr(showParts);
		defaultHitRectT=SRect.createByConfig(defaultHitRect);
	}
	
	/// <summary>
	/// 读完所有表后处理
	/// </summary>
	public static void afterReadConfigAll()
	{
		
	}
	
	/// <summary>
	/// 生成刷新配置
	/// </summary>
	protected override void generateRefresh()
	{
		sourceT=LoadControl.getResourceIDByName(source);
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		if(this.showParts!=null)
		{
			DIntData[] showPartsT=this.showParts;
			stream.writeLen(showPartsT.Length);
			for(int showPartsVI=0,showPartsVLen=showPartsT.Length;showPartsVI<showPartsVLen;++showPartsVI)
			{
				DIntData showPartsV=showPartsT[showPartsVI];
				if(showPartsV!=null)
				{
					showPartsV.writeBytesSimple(stream);
				}
				else
				{
					nullObjError("showPartsV");
				}
				
			}
		}
		else
		{
			nullObjError("showParts");
		}
		
		stream.writeUTF(this.source);
		
		stream.writeFloat(this.collideRadius);
		
		if(this.defaultHitRect!=null)
		{
			float[] defaultHitRectT=this.defaultHitRect;
			stream.writeLen(defaultHitRectT.Length);
			for(int defaultHitRectVI=0,defaultHitRectVLen=defaultHitRectT.Length;defaultHitRectVI<defaultHitRectVLen;++defaultHitRectVI)
			{
				float defaultHitRectV=defaultHitRectT[defaultHitRectVI];
				stream.writeFloat(defaultHitRectV);
				
			}
		}
		else
		{
			nullObjError("defaultHitRect");
		}
		
		stream.writeFloat(this.height);
		
	}
	
}