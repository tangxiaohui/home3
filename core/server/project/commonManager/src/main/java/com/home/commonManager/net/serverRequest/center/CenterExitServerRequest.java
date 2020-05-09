package com.home.commonManager.net.serverRequest.center;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonManager.net.base.ManagerServerRequest;
import com.home.commonManager.net.serverRequest.center.base.ManagerToCenterServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;

/** (generated by shine) */
public class CenterExitServerRequest extends ManagerToCenterServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.CenterExit;
	
	public CenterExitServerRequest()
	{
		_dataID=ServerMessageType.CenterExit;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CenterExitServerRequest";
	}
	
	/** 创建实例 */
	public static CenterExitServerRequest create()
	{
		CenterExitServerRequest re=(CenterExitServerRequest)BytesControl.createRequest(dataID);
		return re;
	}
	
}