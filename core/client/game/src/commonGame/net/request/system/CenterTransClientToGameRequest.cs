using ShineEngine;
using System;

/// <summary>
/// 客户端到中心服转发到game消息(generated by shine)
/// </summary>
public class CenterTransClientToGameRequest:GameRequest
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameRequestType.CenterTransClientToGame;
	
	/** 绑定消息 */
	private CenterRequest _request;
	
	public CenterTransClientToGameRequest()
	{
		_dataID=GameRequestType.CenterTransClientToGame;
		setDontCopy();
	}
	
	protected override void doWriteBytesSimple(BytesWriteStream stream)
	{
		if(_request==null)
		{
			Ctrl.throwError("绑定消息为空");
			return;
		}

		_request.writeToStream(stream);
	}
	
	/// <summary>
	/// 设置数据
	/// </summary>
	public void setData(CenterRequest request)
	{
		_request=request;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "CenterTransClientToGameRequest";
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.endWriteObj();
	}
	
	protected override void copyData()
	{
		base.copyData();
	}
	
	/// <summary>
	/// 创建实例
	/// </summary>
	public static CenterTransClientToGameRequest create()
	{
		CenterTransClientToGameRequest re=(CenterTransClientToGameRequest)BytesControl.createRequest(dataID);
		return re;
	}
	
}