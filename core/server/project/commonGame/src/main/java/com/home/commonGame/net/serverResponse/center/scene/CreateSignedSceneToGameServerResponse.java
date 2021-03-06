package com.home.commonGame.net.serverResponse.center.scene;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonBase.data.role.RoleShowData;
import com.home.commonBase.data.scene.scene.CreateSceneData;
import com.home.commonBase.data.scene.unit.UnitInfoData;
import com.home.commonGame.global.GameC;
import com.home.commonGame.net.serverResponse.center.base.CenterToGameServerResponse;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 创建指定场景到Game服(generated by shine) */
public class CreateSignedSceneToGameServerResponse extends CenterToGameServerResponse
{
	/** 数据类型ID */
	public static final int dataID=ServerMessageType.CreateSignedSceneToGame;
	
	/** 创建场景数据 */
	public CreateSceneData createData;
	
	/** 事务索引 */
	public int index;
	
	/** 指定角色组 */
	public RoleShowData[] signedPlayers;
	
	public CreateSignedSceneToGameServerResponse()
	{
		_dataID=ServerMessageType.CreateSignedSceneToGame;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.index=stream.readInt();
		
		this.createData=(CreateSceneData)stream.readDataSimpleNotNull();
		
		int signedPlayersLen=stream.readLen();
		if(this.signedPlayers==null || this.signedPlayers.length!=signedPlayersLen)
		{
			this.signedPlayers=new RoleShowData[signedPlayersLen];
		}
		RoleShowData[] signedPlayersT=this.signedPlayers;
		for(int signedPlayersI=0;signedPlayersI<signedPlayersLen;++signedPlayersI)
		{
			RoleShowData signedPlayersV;
			signedPlayersV=(RoleShowData)stream.readDataSimpleNotNull();
			
			signedPlayersT[signedPlayersI]=signedPlayersV;
		}
		
	}
	
	/** 执行 */
	@Override
	protected void execute()
	{
		GameC.scene.createSignedSceneByCenter(index,createData,signedPlayers);
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "CreateSignedSceneToGameServerResponse";
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
	
}
