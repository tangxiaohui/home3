using ShineEngine;

/// <summary>
/// (generated by shine)
/// </summary>
public class CharacterPartData:BaseData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=PlayerPartDataType.Character;
	
	public CharacterPartData()
	{
		_dataID=PlayerPartDataType.Character;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "CharacterPartData";
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.endWriteObj();
	}
	
}