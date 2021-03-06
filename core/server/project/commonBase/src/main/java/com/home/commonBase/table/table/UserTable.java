package com.home.commonBase.table.table;
import com.home.commonBase.constlist.generate.BaseTableType;
import com.home.commonBase.table.result.UserDBResult;
import com.home.commonBase.table.task.UserDBTask;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.dataEx.VBoolean;
import com.home.shine.support.collection.LongSet;
import com.home.shine.support.collection.SSet;
import com.home.shine.support.pool.StringBuilderPool;
import com.home.shine.table.BaseDBResult;
import com.home.shine.table.BaseTable;
import com.home.shine.table.task.BaseDBTask;
import com.home.shine.utils.StringUtils;

/** 用户表(generated by shine) */
public class UserTable extends BaseTable
{
	/** 查询头 */
	private static final String _selectStr="select `userID`,`puid`,`platform`,`isAdult`,`areaID`,`playerIDs`,`sourceUserID` from `user`";
	
	/** platform_uid */
	public String puid="";
	
	/** 查0 */
	private static final String _selectInStr0="select `userID`,`puid`,`platform`,`isAdult`,`areaID`,`playerIDs`,`sourceUserID` from `user` where `userID` in (";
	
	/** 查1 */
	private static final String _selectInStr1="select `userID`,`puid`,`platform`,`isAdult`,`areaID`,`playerIDs`,`sourceUserID` from `user` where `puid` in (";
	
	/** 用户ID */
	public long userID;
	
	/** 拥有角色ID组(逗号分隔) */
	public String playerIDs="";
	
	/** 平台类型 */
	public String platform="";
	
	/** 是否成人 */
	public boolean isAdult;
	
	/** 增 */
	private static final String _insertStr="insert into `user` (`userID`,`puid`,`platform`,`isAdult`,`areaID`,`playerIDs`,`sourceUserID` ) values (?,?,?,?,?,?,?)";
	
	/** 删 */
	private static final String _deleteStr="delete from `user` where `userID` = ?";
	
	/** 改 */
	private static final String _updateStr="update `user` set `userID` = ?,`puid` = ?,`platform` = ?,`isAdult` = ?,`areaID` = ?,`playerIDs` = ?,`sourceUserID` = ? where `userID` = ?";
	
	/** 绑定(上次选择)区服ID */
	public int areaID;
	
	private LongSet _playerSet;
	
	/** 指向源userID(一账号多平台用) */
	public long sourceUserID;
	
	public UserTable()
	{
		_dataID=BaseTableType.User;
	}
	
	@Override
	public String getInsertStr()
	{
		return _insertStr;
	}
	
	@Override
	public String getDeleteStr()
	{
		return _deleteStr;
	}
	
	@Override
	public String getUpdateStr()
	{
		return _updateStr;
	}
	
	@Override
	public String getSelectStr()
	{
		return _selectStr;
	}
	
	@Override
	public String getSelectInStrByIndex(int index)
	{
		switch(index)
		{
			case 0:
				return _selectInStr0;
			case 1:
				return _selectInStr1;
		}
		
		return null;
	}
	
	@Override
	protected BaseDBTask createTask()
	{
		UserDBTask task=new UserDBTask();
		task.userID=this.userID;
		task.puid=this.puid;
		task.platform=this.platform;
		task.isAdult=this.isAdult;
		task.areaID=this.areaID;
		task.playerIDs=this.playerIDs;
		task.sourceUserID=this.sourceUserID;
		return task;
	}
	
	@Override
	public void readByResult(BaseDBResult result)
	{
		UserDBResult re=(UserDBResult)result;
		this.userID=re.userID;
		this.puid=re.puid;
		this.platform=re.platform;
		this.isAdult=re.isAdult;
		this.areaID=re.areaID;
		this.playerIDs=re.playerIDs;
		this.sourceUserID=re.sourceUserID;
	}
	
	@Override
	protected void toReadValues()
	{
		userID=readLong();
		puid=readString();
		platform=readString();
		isAdult=readBoolean();
		areaID=readInt();
		playerIDs=readString();
		sourceUserID=readLong();
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.userID=stream.readLong();
		
		this.puid=stream.readUTF();
		
		this.platform=stream.readUTF();
		
		this.isAdult=stream.readBoolean();
		
		this.areaID=stream.readInt();
		
		this.playerIDs=stream.readUTF();
		
		this.sourceUserID=stream.readLong();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeLong(this.userID);
		
		stream.writeUTF(this.puid);
		
		stream.writeUTF(this.platform);
		
		stream.writeBoolean(this.isAdult);
		
		stream.writeInt(this.areaID);
		
		stream.writeUTF(this.playerIDs);
		
		stream.writeLong(this.sourceUserID);
		
		stream.endWriteObj();
	}
	
	/** 获取playerSet */
	public LongSet getPlayerSet()
	{
		if(_playerSet==null)
		{
			if(playerIDs.isEmpty())
			{
				_playerSet=new LongSet();
			}
			else
			{
				String[] arr=playerIDs.split(",");
				
				_playerSet=new LongSet(arr.length);
				
				for(String v:arr)
				{
					if(!StringUtils.isNullOrEmpty(v))
					{
						_playerSet.add(Long.parseLong(v));
					}
				}
			}
		}
		
		return _playerSet;
	}
	
	private void writeToPlayerIDs()
	{
		StringBuilder sb=StringBuilderPool.create();
		
		VBoolean isNext=new VBoolean();
		
		_playerSet.forEachA(k->
		{
			if(isNext.value)
				sb.append(",");
			
			sb.append(k);
			
			isNext.value=true;
		});
		
		playerIDs=StringBuilderPool.releaseStr(sb);
	}
	
	public void addPlayerID(long playerID)
	{
		getPlayerSet();
		_playerSet.add(playerID);
		writeToPlayerIDs();
	}
	
	public void removePlayerID(long playerID)
	{
		getPlayerSet();
		_playerSet.remove(playerID);
		writeToPlayerIDs();
	}
	
}
