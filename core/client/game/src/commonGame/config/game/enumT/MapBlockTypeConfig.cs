using ShineEngine;

/// <summary>
/// 地图格子阻挡类型类型(generated by shine)
/// </summary>
public class MapBlockTypeConfig:BaseConfig
{
	/** 存储集合 */
	private static MapBlockTypeConfig[] _dic;
	
	/// <summary>
	/// id
	/// </summary>
	public int id;
	
	/// <summary>
	/// 驾驶地面减速度(动摩擦系数*重力加速度)
	/// </summary>
	public float groundFriction;
	
	/// <summary>
	/// 允许移动方式
	/// </summary>
	public int[] allowMoveType;
	
	/// <summary>
	/// 获取
	/// </summary>
	public static MapBlockTypeConfig get(int id)
	{
		return id>=0 && id<_dic.Length ? _dic[id] : null;
	}
	
	/// <summary>
	/// 设置字典
	/// </summary>
	public static void setDic(MapBlockTypeConfig[] dic)
	{
		_dic=dic;
	}
	
	/// <summary>
	/// 添加字典(热更用)
	/// </summary>
	public static void addDic(MapBlockTypeConfig[] dic)
	{
		ObjectUtils.arrayPutAll(_dic,dic);
	}
	
	/// <summary>
	/// 获取全部
	/// </summary>
	public static MapBlockTypeConfig[] getDic()
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
		
		int allowMoveTypeLen=stream.readLen();
		if(this.allowMoveType==null || this.allowMoveType.Length!=allowMoveTypeLen)
		{
			this.allowMoveType=new int[allowMoveTypeLen];
		}
		int[] allowMoveTypeT=this.allowMoveType;
		for(int allowMoveTypeI=0;allowMoveTypeI<allowMoveTypeLen;++allowMoveTypeI)
		{
			int allowMoveTypeV;
			allowMoveTypeV=stream.readInt();
			
			allowMoveTypeT[allowMoveTypeI]=allowMoveTypeV;
		}
		
		this.groundFriction=stream.readFloat();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		if(this.allowMoveType!=null)
		{
			int[] allowMoveTypeT=this.allowMoveType;
			stream.writeLen(allowMoveTypeT.Length);
			for(int allowMoveTypeVI=0,allowMoveTypeVLen=allowMoveTypeT.Length;allowMoveTypeVI<allowMoveTypeVLen;++allowMoveTypeVI)
			{
				int allowMoveTypeV=allowMoveTypeT[allowMoveTypeVI];
				stream.writeInt(allowMoveTypeV);
				
			}
		}
		else
		{
			nullObjError("allowMoveType");
		}
		
		stream.writeFloat(this.groundFriction);
		
	}
	
	/// <summary>
	/// 读完所有表后处理
	/// </summary>
	public static void afterReadConfigAll()
	{
		
	}
	
}