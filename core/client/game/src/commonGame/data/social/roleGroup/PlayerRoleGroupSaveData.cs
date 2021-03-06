using ShineEngine;

/// <summary>
/// 角色自身玩家群存库数据(generated by shine)
/// </summary>
public class PlayerRoleGroupSaveData:BaseData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.PlayerRoleGroupSave;
	
	/// <summary>
	/// 所在群id
	/// </summary>
	public long groupID;
	
	public PlayerRoleGroupSaveData()
	{
		_dataID=BaseDataType.PlayerRoleGroupSave;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "PlayerRoleGroupSaveData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.groupID=stream.readLong();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeLong(this.groupID);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		this.groupID=stream.readLong();
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeLong(this.groupID);
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is PlayerRoleGroupSaveData))
			return;
		
		PlayerRoleGroupSaveData mData=(PlayerRoleGroupSaveData)data;
		
		this.groupID=mData.groupID;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is PlayerRoleGroupSaveData))
			return;
		
		PlayerRoleGroupSaveData mData=(PlayerRoleGroupSaveData)data;
		
		this.groupID=mData.groupID;
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		PlayerRoleGroupSaveData mData=(PlayerRoleGroupSaveData)data;
		if(this.groupID!=mData.groupID)
			return false;
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.Append("groupID");
		writer.sb.Append(':');
		writer.sb.Append(this.groupID);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		this.groupID=0L;
	}
	
}
