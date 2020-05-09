using ShineEngine;

/// <summary>
/// 客户端控制单位子弹命中(generated by shine)
/// </summary>
public class CUnitBulletHitRequest:CUnitRRequest
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameRequestType.CUnitBulletHit;
	
	/// <summary>
	/// 子弹ID
	/// </summary>
	public int bulletID;
	
	/// <summary>
	/// 子弹等级
	/// </summary>
	public int bulletLevel;
	
	/// <summary>
	/// 目标
	/// </summary>
	public SkillTargetData target;
	
	public CUnitBulletHitRequest()
	{
		_dataID=GameRequestType.CUnitBulletHit;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "CUnitBulletHitRequest";
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("bulletID");
		writer.sb.Append(':');
		writer.sb.Append(this.bulletID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("bulletLevel");
		writer.sb.Append(':');
		writer.sb.Append(this.bulletLevel);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("target");
		writer.sb.Append(':');
		if(this.target!=null)
		{
			this.target.writeDataString(writer);
		}
		else
		{
			writer.sb.Append("SkillTargetData=null");
		}
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.bulletID);
		
		stream.writeInt(this.bulletLevel);
		
		if(this.target!=null)
		{
			stream.writeDataFullNotNull(this.target);
		}
		else
		{
			nullObjError("target");
		}
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		stream.writeInt(this.bulletID);
		
		stream.writeInt(this.bulletLevel);
		
		if(this.target!=null)
		{
			stream.writeDataSimpleNotNull(this.target);
		}
		else
		{
			nullObjError("target");
		}
		
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		this.bulletID=0;
		this.bulletLevel=0;
		this.target.release(pool);
		this.target=null;
	}
	
	protected override void copyData()
	{
		base.copyData();
		SkillTargetData targetTemp=target;
		if(targetTemp!=null)
		{
			this.target=(SkillTargetData)targetTemp.clone();
		}
		else
		{
			this.target=null;
			nullObjError("target");
		}
		
	}
	
	/// <summary>
	/// 创建实例
	/// </summary>
	public static CUnitBulletHitRequest create(int instanceID,int bulletID,int bulletLevel,SkillTargetData target)
	{
		CUnitBulletHitRequest re=(CUnitBulletHitRequest)BytesControl.createRequest(dataID);
		re.instanceID=instanceID;
		re.bulletID=bulletID;
		re.bulletLevel=bulletLevel;
		re.target=target;
		return re;
	}
	
}