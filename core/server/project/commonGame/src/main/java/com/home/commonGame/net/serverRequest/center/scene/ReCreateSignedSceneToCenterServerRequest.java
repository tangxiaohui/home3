package com.home.commonGame.net.serverRequest.center.scene;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.scene.scene.SceneEnterArgData;
import com.home.commonBase.data.scene.scene.SceneLocationData;
import com.home.commonGame.net.serverRequest.center.base.GameToCenterServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 回创建指定场景到中心服(generated by shine) */
public class ReCreateSignedSceneToCenterServerRequest extends GameToCenterServerRequest
{
	/** 序号 */
	public int index;
	
	/** 进入场景参数数据 */
	public SceneLocationData eData;
	
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.ReCreateSignedSceneToCenter;
	
	public ReCreateSignedSceneToCenterServerRequest()
	{
		_dataID=ServerMessageType.ReCreateSignedSceneToCenter;
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		SceneLocationData eDataTemp=eData;
		if(eDataTemp!=null)
		{
			this.eData=(SceneLocationData)eDataTemp.clone();
		}
		else
		{
			this.eData=null;
			nullObjError("eData");
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.index);
		
		if(this.eData!=null)
		{
			stream.writeDataSimpleNotNull(this.eData);
		}
		else
		{
			nullObjError("eData");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "ReCreateSignedSceneToCenterServerRequest";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		super.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.append("index");
		writer.sb.append(':');
		writer.sb.append(this.index);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("eData");
		writer.sb.append(':');
		if(this.eData!=null)
		{
			this.eData.writeDataString(writer);
		}
		else
		{
			writer.sb.append("SceneLocationData=null");
		}
		
		writer.writeEnter();
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.index=0;
		this.eData.release(pool);
		this.eData=null;
	}
	
	/** 创建实例 */
	public static ReCreateSignedSceneToCenterServerRequest create(int index,SceneLocationData eData)
	{
		ReCreateSignedSceneToCenterServerRequest re=(ReCreateSignedSceneToCenterServerRequest)BytesControl.createRequest(dataID);
		re.index=index;
		re.eData=eData;
		return re;
	}
	
}