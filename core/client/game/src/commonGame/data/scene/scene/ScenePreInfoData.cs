using ShineEngine;

/// <summary>
/// 场景预备信息数据(generated by shine)
/// </summary>
public class ScenePreInfoData:BaseData
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=BaseDataType.ScenePreInfo;
	
	/// <summary>
	/// 指定玩家组
	/// </summary>
	public RoleShowData[] signedPlayers;
	
	public ScenePreInfoData()
	{
		_dataID=BaseDataType.ScenePreInfo;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "ScenePreInfoData";
	}
	
	/// <summary>
	/// 读取字节流(简版)
	/// </summary>
	protected override void toReadBytesSimple(BytesReadStream stream)
	{
		if(stream.readBoolean())
		{
			int signedPlayersLen=stream.readLen();
			if(this.signedPlayers==null || this.signedPlayers.Length!=signedPlayersLen)
			{
				this.signedPlayers=new RoleShowData[signedPlayersLen];
			}
			RoleShowData[] signedPlayersT=this.signedPlayers;
			for(int signedPlayersI=0;signedPlayersI<signedPlayersLen;++signedPlayersI)
			{
				RoleShowData signedPlayersV;
				if(stream.readBoolean())
				{
					signedPlayersV=(RoleShowData)stream.readDataSimpleNotNull();
				}
				else
				{
					signedPlayersV=null;
				}
				
				signedPlayersT[signedPlayersI]=signedPlayersV;
			}
		}
		else
		{
			this.signedPlayers=null;
		}
		
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		if(this.signedPlayers!=null)
		{
			stream.writeBoolean(true);
			RoleShowData[] signedPlayersT=this.signedPlayers;
			stream.writeLen(signedPlayersT.Length);
			for(int signedPlayersVI=0,signedPlayersVLen=signedPlayersT.Length;signedPlayersVI<signedPlayersVLen;++signedPlayersVI)
			{
				RoleShowData signedPlayersV=signedPlayersT[signedPlayersVI];
				if(signedPlayersV!=null)
				{
					stream.writeBoolean(true);
					stream.writeDataSimpleNotNull(signedPlayersV);
				}
				else
				{
					stream.writeBoolean(false);
				}
				
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
	}
	
	/// <summary>
	/// 复制(潜拷贝)
	/// </summary>
	protected override void toShadowCopy(BaseData data)
	{
		if(!(data is ScenePreInfoData))
			return;
		
		ScenePreInfoData mData=(ScenePreInfoData)data;
		
		this.signedPlayers=mData.signedPlayers;
	}
	
	/// <summary>
	/// 复制(深拷贝)
	/// </summary>
	protected override void toCopy(BaseData data)
	{
		if(!(data is ScenePreInfoData))
			return;
		
		ScenePreInfoData mData=(ScenePreInfoData)data;
		
		if(mData.signedPlayers!=null)
		{
			RoleShowData[] signedPlayersR=mData.signedPlayers;
			int signedPlayersLen=signedPlayersR.Length;
			if(this.signedPlayers==null || this.signedPlayers.Length!=signedPlayersLen)
			{
				this.signedPlayers=new RoleShowData[signedPlayersLen];
			}
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
				}
				
				signedPlayersT[signedPlayersI]=signedPlayersU;
			}
		}
		else
		{
			this.signedPlayers=null;
		}
		
	}
	
	/// <summary>
	/// 是否数据一致
	/// </summary>
	protected override bool toDataEquals(BaseData data)
	{
		ScenePreInfoData mData=(ScenePreInfoData)data;
		if(mData.signedPlayers!=null)
		{
			if(this.signedPlayers==null)
				return false;
			if(this.signedPlayers.Length!=mData.signedPlayers.Length)
				return false;
			RoleShowData[] signedPlayersT=this.signedPlayers;
			RoleShowData[] signedPlayersR=mData.signedPlayers;
			int signedPlayersLen=signedPlayersT.Length;
			for(int signedPlayersI=0;signedPlayersI<signedPlayersLen;++signedPlayersI)
			{
				RoleShowData signedPlayersU=signedPlayersT[signedPlayersI];
				RoleShowData signedPlayersV=signedPlayersR[signedPlayersI];
				if(signedPlayersV!=null)
				{
					if(signedPlayersU==null)
						return false;
					if(!signedPlayersU.dataEquals(signedPlayersV))
						return false;
				}
				else
				{
					if(signedPlayersU!=null)
						return false;
				}
				
			}
		}
		else
		{
			if(this.signedPlayers!=null)
				return false;
		}
		
		return true;
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.Append("signedPlayers");
		writer.sb.Append(':');
		writer.sb.Append("Array<RoleShowData>");
		if(this.signedPlayers!=null)
		{
			RoleShowData[] signedPlayersT=this.signedPlayers;
			int signedPlayersLen=signedPlayersT.Length;
			writer.sb.Append('(');
			writer.sb.Append(signedPlayersLen);
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int signedPlayersI=0;signedPlayersI<signedPlayersLen;++signedPlayersI)
			{
				RoleShowData signedPlayersV=signedPlayersT[signedPlayersI];
				writer.writeTabs();
				writer.sb.Append(signedPlayersI);
				writer.sb.Append(':');
				if(signedPlayersV!=null)
				{
					signedPlayersV.writeDataString(writer);
				}
				else
				{
					writer.sb.Append("RoleShowData=null");
				}
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.Append("=null");
		}
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 初始化初值
	/// </summary>
	public override void initDefault()
	{
		
	}
	
	/// <summary>
	/// 读取字节流(完整版)
	/// </summary>
	protected override void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		if(stream.readBoolean())
		{
			int signedPlayersLen=stream.readLen();
			if(this.signedPlayers==null || this.signedPlayers.Length!=signedPlayersLen)
			{
				this.signedPlayers=new RoleShowData[signedPlayersLen];
			}
			RoleShowData[] signedPlayersT=this.signedPlayers;
			for(int signedPlayersI=0;signedPlayersI<signedPlayersLen;++signedPlayersI)
			{
				RoleShowData signedPlayersV;
				if(stream.readBoolean())
				{
					BaseData signedPlayersVT=stream.readDataFullNotNull();
					if(signedPlayersVT!=null)
					{
						if(signedPlayersVT is RoleShowData)
						{
							signedPlayersV=(RoleShowData)signedPlayersVT;
						}
						else
						{
							signedPlayersV=new RoleShowData();
							if(!(signedPlayersVT.GetType().IsAssignableFrom(typeof(RoleShowData))))
							{
								stream.throwTypeReadError(typeof(RoleShowData),signedPlayersVT.GetType());
							}
							signedPlayersV.shadowCopy(signedPlayersVT);
						}
					}
					else
					{
						signedPlayersV=null;
					}
				}
				else
				{
					signedPlayersV=null;
				}
				
				signedPlayersT[signedPlayersI]=signedPlayersV;
			}
		}
		else
		{
			this.signedPlayers=null;
		}
		
		stream.endReadObj();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		if(this.signedPlayers!=null)
		{
			stream.writeBoolean(true);
			RoleShowData[] signedPlayersT=this.signedPlayers;
			stream.writeLen(signedPlayersT.Length);
			for(int signedPlayersVI=0,signedPlayersVLen=signedPlayersT.Length;signedPlayersVI<signedPlayersVLen;++signedPlayersVI)
			{
				RoleShowData signedPlayersV=signedPlayersT[signedPlayersVI];
				if(signedPlayersV!=null)
				{
					stream.writeBoolean(true);
					stream.writeDataFullNotNull(signedPlayersV);
				}
				else
				{
					stream.writeBoolean(false);
				}
				
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		this.signedPlayers=null;
	}
	
}