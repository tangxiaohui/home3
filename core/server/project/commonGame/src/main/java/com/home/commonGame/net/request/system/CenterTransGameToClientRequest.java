package com.home.commonGame.net.request.system;
import com.home.commonGame.constlist.generate.GameRequestType;
import com.home.commonGame.net.base.GameRequest;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;

/** 中心服转发消息(generated by shine) */
public class CenterTransGameToClientRequest extends GameRequest
{
	/** 数据类型ID */
	public static final int dataID=GameRequestType.CenterTransGameToClient;
	
	private byte[] _data;
	
	public CenterTransGameToClientRequest()
	{
		_dataID=GameRequestType.CenterTransGameToClient;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
	}
	
	@Override
	protected void doWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeByteArr(_data);
	}
	
	public void setData(byte[] data)
	{
		_data=data;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CenterTransGameToClientRequest";
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.endWriteObj();
	}
	
	/** 创建实例 */
	public static CenterTransGameToClientRequest create()
	{
		CenterTransGameToClientRequest re=(CenterTransGameToClientRequest)BytesControl.createRequest(dataID);
		return re;
	}
	
}