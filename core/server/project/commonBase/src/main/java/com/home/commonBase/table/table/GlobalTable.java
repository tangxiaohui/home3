package com.home.commonBase.table.table;
import com.home.commonBase.constlist.generate.BaseTableType;
import com.home.commonBase.table.result.GlobalDBResult;
import com.home.commonBase.table.task.GlobalDBTask;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.DateData;
import com.home.shine.table.BaseDBResult;
import com.home.shine.table.BaseTable;
import com.home.shine.table.task.BaseDBTask;

/** 全局表(generated by shine) */
public class GlobalTable extends BaseTable
{
	/** 增 */
	private static final String _insertStr="insert into `global` (`key`,`dataVersion`,`saveDate`,`data` ) values (?,?,?,?)";
	
	/** 删 */
	private static final String _deleteStr="delete from `global` where `key` = ?";
	
	/** 上次保存时间 */
	public DateData saveDate;
	
	/** 改 */
	private static final String _updateStr="update `global` set `key` = ?,`dataVersion` = ?,`saveDate` = ?,`data` = ? where `key` = ?";
	
	/** 查询头 */
	private static final String _selectStr="select `key`,`dataVersion`,`saveDate`,`data` from `global`";
	
	/** 默认主键 */
	public int key;
	
	/** 数据结构版本 */
	public int dataVersion;
	
	/** blob值 */
	public byte[] data;
	
	/** 查0 */
	private static final String _selectInStr0="select `key`,`dataVersion`,`saveDate`,`data` from `global` where `key` in (";
	
	public GlobalTable()
	{
		_dataID=BaseTableType.Global;
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
		GlobalDBTask task=new GlobalDBTask();
		task.key=this.key;
		task.dataVersion=this.dataVersion;
		task.saveDate=this.saveDate;
		task.data=this.data;
		return task;
	}
	
	@Override
	public void readByResult(BaseDBResult result)
	{
		GlobalDBResult re=(GlobalDBResult)result;
		this.key=re.key;
		this.dataVersion=re.dataVersion;
		this.saveDate=re.saveDate;
		this.data=re.data;
	}
	
	@Override
	protected void toReadValues()
	{
		key=readInt();
		dataVersion=readInt();
		saveDate=readDate();
		data=readBytes();
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.key=stream.readInt();
		
		this.dataVersion=stream.readInt();
		
		this.saveDate=new DateData();
		this.saveDate.readBytesFull(stream);
		
		int dataLen=stream.readLen();
		this.data=stream.readByteArr(dataLen);
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeInt(this.key);
		
		stream.writeInt(this.dataVersion);
		
		if(this.saveDate!=null)
		{
			this.saveDate.writeBytesFull(stream);
		}
		else
		{
			nullObjError("saveDate");
		}
		
		if(this.data!=null)
		{
			stream.writeLen(this.data.length);
			stream.writeByteArr(this.data);
		}
		else
		{
			nullObjError("data");
		}
		
		stream.endWriteObj();
	}
	
}
