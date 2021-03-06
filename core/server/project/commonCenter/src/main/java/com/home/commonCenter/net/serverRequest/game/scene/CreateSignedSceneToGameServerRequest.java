package com.home.commonCenter.net.serverRequest.game.scene;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.role.RoleShowData;
import com.home.commonBase.data.scene.scene.CreateSceneData;
import com.home.commonBase.data.scene.unit.UnitInfoData;
import com.home.commonCenter.net.serverRequest.game.base.CenterToGameServerRequest;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 创建指定场景到Game服(generated by shine) */
public class CreateSignedSceneToGameServerRequest extends CenterToGameServerRequest
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.CreateSignedSceneToGame;
	
	/** 创建场景数据 */
	public CreateSceneData createData;
	
	/** 事务索引 */
	public int index;
	
	/** 指定角色组 */
	public RoleShowData[] signedPlayers;
	
	public CreateSignedSceneToGameServerRequest()
	{
		_dataID=ServerMessageType.CreateSignedSceneToGame;
		setDontCopy();
	}
	
	@Override
	protected void copyData()
	{
		super.copyData();
		CreateSceneData createDataTemp=createData;
		if(createDataTemp!=null)
		{
			this.createData=(CreateSceneData)createDataTemp.clone();
		}
		else
		{
			this.createData=null;
			nullObjError("createData");
		}
		
		RoleShowData[] signedPlayersTemp=signedPlayers;
		if(signedPlayersTemp!=null)
		{
			RoleShowData[] signedPlayersR=signedPlayersTemp;
			int signedPlayersLen=signedPlayersR.length;
			this.signedPlayers=new RoleShowData[signedPlayersLen];
			RoleShowData[] signedPlayersT=this.signedPlayers;
			for(int signedPlayersI=0;signedPlayersI<signedPlayersLen;++signedPlayersI)
			{
				RoleShowData signedPlayersV=signedPlayersR[signedPlayersI];
				RoleShowData signedPlayersU;
				if(signedPlayersV!=null)
				{
					signedPlayersU=(RoleShowData)signedPlayersV.clone();
				}
				else
				{
					signedPlayersU=null;
					nullObjError("signedPlayersU");
				}
				
				signedPlayersT[signedPlayersI]=signedPlayersU;
			}
		}
		else
		{
			this.signedPlayers=null;
			nullObjError("signedPlayers");
		}
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.index);
		
		if(this.createData!=null)
		{
			stream.writeDataSimpleNotNull(this.createData);
		}
		else
		{
			nullObjError("createData");
		}
		
		if(this.signedPlayers!=null)
		{
			RoleShowData[] signedPlayersT=this.signedPlayers;
			stream.writeLen(signedPlayersT.length);
			for(int signedPlayersVI=0,signedPlayersVLen=signedPlayersT.length;signedPlayersVI<signedPlayersVLen;++signedPlayersVI)
			{
				RoleShowData signedPlayersV=signedPlayersT[signedPlayersVI];
				if(signedPlayersV!=null)
				{
					stream.writeDataSimpleNotNull(signedPlayersV);
				}
				else
				{
					nullObjError("signedPlayersV");
				}
				
			}
		}
		else
		{
			nullObjError("signedPlayers");
		}
		
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CreateSignedSceneToGameServerRequest";
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
		writer.sb.append("createData");
		writer.sb.append(':');
		if(this.createData!=null)
		{
			this.createData.writeDataString(writer);
		}
		else
		{
			writer.sb.append("CreateSceneData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("signedPlayers");
		writer.sb.append(':');
		writer.sb.append("Array<RoleShowData>");
		if(this.signedPlayers!=null)
		{
			RoleShowData[] signedPlayersT=this.signedPlayers;
			int signedPlayersLen=signedPlayersT.length;
			writer.sb.append('(');
			writer.sb.append(signedPlayersLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int signedPlayersI=0;signedPlayersI<signedPlayersLen;++signedPlayersI)
			{
				RoleShowData signedPlayersV=signedPlayersT[signedPlayersI];
				writer.writeTabs();
				writer.sb.append(signedPlayersI);
				writer.sb.append(':');
				if(signedPlayersV!=null)
				{
					signedPlayersV.writeDataString(writer);
				}
				else
				{
					writer.sb.append("RoleShowData=null");
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
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		super.toRelease(pool);
		
		this.index=0;
		this.createData=null;
		this.signedPlayers=null;
	}
	
	/** 创建实例 */
	public static CreateSignedSceneToGameServerRequest create(int index,CreateSceneData createData,RoleShowData[] signedPlayers)
	{
		CreateSignedSceneToGameServerRequest re=(CreateSignedSceneToGameServerRequest)BytesControl.createRequest(dataID);
		re.index=index;
		re.createData=createData;
		re.signedPlayers=signedPlayers;
		return re;
	}
	
}
