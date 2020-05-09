using ShineEngine;

/// <summary>
/// 添加所有好友消息(generated by shine)
/// </summary>
public class AddAllFriendRequest:GameRequest
{
	/// <summary>
	/// 数据类型ID
	/// </summary>
	public const int dataID=GameRequestType.AddAllFriend;
	
	/// <summary>
	/// 角色ID
	/// </summary>
	public LongList playerIDList;
	
	/// <summary>
	/// 添加方式(g层定义)
	/// </summary>
	public int type;
	
	public AddAllFriendRequest()
	{
		_dataID=GameRequestType.AddAllFriend;
	}
	
	/// <summary>
	/// 获取数据类名
	/// </summary>
	public override string getDataClassName()
	{
		return "AddAllFriendRequest";
	}
	
	/// <summary>
	/// 转文本输出
	/// </summary>
	protected override void toWriteDataString(DataWriter writer)
	{
		base.toWriteDataString(writer);
		
		writer.writeTabs();
		writer.sb.Append("playerIDList");
		writer.sb.Append(':');
		writer.sb.Append("List<long>");
		if(this.playerIDList!=null)
		{
			LongList playerIDListT=this.playerIDList;
			int playerIDListLen=playerIDListT.size();
			writer.sb.Append('(');
			writer.sb.Append(playerIDListLen);
			writer.sb.Append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int playerIDListI=0;playerIDListI<playerIDListLen;++playerIDListI)
			{
				long playerIDListV=playerIDListT.get(playerIDListI);
				writer.writeTabs();
				writer.sb.Append(playerIDListI);
				writer.sb.Append(':');
				writer.sb.Append(playerIDListV);
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.Append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.Append("type");
		writer.sb.Append(':');
		writer.sb.Append(this.type);
		
		writer.writeEnter();
	}
	
	/// <summary>
	/// 写入字节流(完整版)
	/// </summary>
	protected override void toWriteBytesFull(BytesWriteStream stream)
	{
		base.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		if(this.playerIDList!=null)
		{
			stream.writeLen(this.playerIDList.size());
			if(!this.playerIDList.isEmpty())
			{
				long[] playerIDListVValues=this.playerIDList.getValues();
				for(int playerIDListVI=0,playerIDListVLen=this.playerIDList.length();playerIDListVI<playerIDListVLen;++playerIDListVI)
				{
					long playerIDListV=playerIDListVValues[playerIDListVI];
					stream.writeLong(playerIDListV);
					
				}
			}
		}
		else
		{
			nullObjError("playerIDList");
		}
		
		stream.writeInt(this.type);
		
		stream.endWriteObj();
	}
	
	/// <summary>
	/// 写入字节流(简版)
	/// </summary>
	protected override void toWriteBytesSimple(BytesWriteStream stream)
	{
		base.toWriteBytesSimple(stream);
		
		if(this.playerIDList!=null)
		{
			stream.writeLen(this.playerIDList.size());
			if(!this.playerIDList.isEmpty())
			{
				long[] playerIDListVValues=this.playerIDList.getValues();
				for(int playerIDListVI=0,playerIDListVLen=this.playerIDList.length();playerIDListVI<playerIDListVLen;++playerIDListVI)
				{
					long playerIDListV=playerIDListVValues[playerIDListVI];
					stream.writeLong(playerIDListV);
					
				}
			}
		}
		else
		{
			nullObjError("playerIDList");
		}
		
		stream.writeInt(this.type);
		
	}
	
	/// <summary>
	/// 回池
	/// </summary>
	protected override void toRelease(DataPool pool)
	{
		base.toRelease(pool);
		
		if(this.playerIDList!=null)
		{
			this.playerIDList.clear();
		}
		this.type=0;
	}
	
	protected override void copyData()
	{
		base.copyData();
		LongList playerIDListTemp=playerIDList;
		if(playerIDListTemp!=null)
		{
			this.playerIDList=new LongList();
			LongList playerIDListT=this.playerIDList;
			if(!playerIDListTemp.isEmpty())
			{
				long[] playerIDListVValues=playerIDListTemp.getValues();
				for(int playerIDListVI=0,playerIDListVLen=playerIDListTemp.length();playerIDListVI<playerIDListVLen;++playerIDListVI)
				{
					long playerIDListV=playerIDListVValues[playerIDListVI];
					long playerIDListU;
					playerIDListU=playerIDListV;
					
					playerIDListT.add(playerIDListU);
				}
			}
		}
		else
		{
			this.playerIDList=null;
			nullObjError("playerIDList");
		}
		
	}
	
	/// <summary>
	/// 创建实例
	/// </summary>
	public static AddAllFriendRequest create(LongList playerIDList,int type)
	{
		AddAllFriendRequest re=(AddAllFriendRequest)BytesControl.createRequest(dataID);
		re.playerIDList=playerIDList;
		re.type=type;
		return re;
	}
	
}