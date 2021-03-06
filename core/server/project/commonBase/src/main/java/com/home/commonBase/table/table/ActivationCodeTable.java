package com.home.commonBase.table.table;
import com.home.commonBase.constlist.generate.BaseTableType;
import com.home.commonBase.table.result.ActivationCodeDBResult;
import com.home.commonBase.table.task.ActivationCodeDBTask;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.table.BaseDBResult;
import com.home.shine.table.BaseTable;
import com.home.shine.table.task.BaseDBTask;

/** 激活码表(generated by shine) */
public class ActivationCodeTable extends BaseTable
{
	/** 增 */
	private static final String _insertStr="insert into `activationcode` (`code`,`id`,`lastNum`,`bornTime`,`disableTime` ) values (?,?,?,?,?)";
	
	/** 删 */
	private static final String _deleteStr="delete from `activationcode` where `code` = ?";
	
	/** 剩余可使用次数 */
	public int lastNum;
	
	/** 改 */
	private static final String _updateStr="update `activationcode` set `code` = ?,`id` = ?,`lastNum` = ?,`bornTime` = ?,`disableTime` = ? where `code` = ?";
	
	/** 查询头 */
	private static final String _selectStr="select `code`,`id`,`lastNum`,`bornTime`,`disableTime` from `activationcode`";
	
	/** 查0 */
	private static final String _selectInStr0="select `code`,`id`,`lastNum`,`bornTime`,`disableTime` from `activationcode` where `code` in (";
	
	/** 码 */
	public String code="";
	
	/** id */
	public int id;
	
	/** 生成时间戳 */
	public long bornTime;
	
	/** 失效时间戳 */
	public long disableTime;
	
	public ActivationCodeTable()
	{
		_dataID=BaseTableType.ActivationCode;
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
		ActivationCodeDBTask task=new ActivationCodeDBTask();
		task.code=this.code;
		task.id=this.id;
		task.lastNum=this.lastNum;
		task.bornTime=this.bornTime;
		task.disableTime=this.disableTime;
		return task;
	}
	
	@Override
	public void readByResult(BaseDBResult result)
	{
		ActivationCodeDBResult re=(ActivationCodeDBResult)result;
		this.code=re.code;
		this.id=re.id;
		this.lastNum=re.lastNum;
		this.bornTime=re.bornTime;
		this.disableTime=re.disableTime;
	}
	
	@Override
	protected void toReadValues()
	{
		code=readString();
		id=readInt();
		lastNum=readInt();
		bornTime=readLong();
		disableTime=readLong();
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		this.code=stream.readUTF();
		
		this.id=stream.readInt();
		
		this.lastNum=stream.readInt();
		
		this.bornTime=stream.readLong();
		
		this.disableTime=stream.readLong();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.writeUTF(this.code);
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.lastNum);
		
		stream.writeLong(this.bornTime);
		
		stream.writeLong(this.disableTime);
		
		stream.endWriteObj();
	}
	
}
