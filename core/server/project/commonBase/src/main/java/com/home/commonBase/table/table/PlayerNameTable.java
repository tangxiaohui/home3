package com.home.commonBase.table.table;
import com.home.commonBase.constlist.generate.BaseTableType;
import com.home.commonBase.table.result.PlayerNameDBResult;
import com.home.commonBase.table.task.PlayerNameDBTask;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.table.BaseDBResult;
import com.home.shine.table.BaseTable;
import com.home.shine.table.task.BaseDBTask;

/** 中心服角色名字表(generated by shine) */
public class PlayerNameTable extends BaseTable
{
	/** 增 */
	private static final String _insertStr="insert into `playername` (`name`,`playerID` ) values (?,?)";
	
	/** 删 */
	private static final String _deleteStr="delete from `playername` where `name` = ?";
	
	/** 改 */
	private static final String _updateStr="update `playername` set `name` = ?,`playerID` = ? where `name` = ?";
	
	/** 查询头 */
	private static final String _selectStr="select `name`,`playerID` from `playername`";
	
	/** 查0 */
	private static final String _selectInStr0="select `name`,`playerID` from `playername` where `name` in (";
	
	/** 名字 */
	public String name="";
	
	/** 角色id */
	public long playerID;
	
	public PlayerNameTable()
	{
		_dataID=BaseTableType.PlayerName;
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
		}
		
		return null;
	}
	
	@Override
	protected BaseDBTask createTask()
	{
		PlayerNameDBTask task=new PlayerNameDBTask();
		task.name=this.name;
		task.playerID=this.playerID;
		return task;
	}
	
	@Override
	public void readByResult(BaseDBResult result)
	{
		PlayerNameDBResult re=(PlayerNameDBResult)result;
		this.name=re.name;
		this.playerID=re.playerID;
	}
	
	@Override
	protected void toReadValues()
	{
		name=readString();
		playerID=readLong();
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.name=stream.readUTF();
		
		this.playerID=stream.readLong();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeUTF(this.name);
		
		stream.writeLong(this.playerID);
		
		stream.endWriteObj();
	}
	
}