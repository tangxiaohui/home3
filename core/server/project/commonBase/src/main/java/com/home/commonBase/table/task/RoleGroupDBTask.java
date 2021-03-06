package com.home.commonBase.table.task;
import com.home.commonBase.table.result.RoleGroupDBResult;
import com.home.commonBase.table.table.RoleGroupTable;
import com.home.shine.data.DateData;
import com.home.shine.table.BaseDBResult;
import com.home.shine.table.BaseTable;
import com.home.shine.table.task.BaseDBTask;

/** 玩家群表(generated by shine) */
public class RoleGroupDBTask extends BaseDBTask
{
	/** 群id */
	public long groupID;
	
	/** 原区ID */
	public int createAreaID;
	
	/** 功能id */
	public int funcID;
	
	/** 创建日期 */
	public DateData createDate;
	
	/** 数据 */
	public byte[] data;
	
	@Override
	public BaseTable createTable()
	{
		return new RoleGroupTable();
	}
	
	@Override
	public BaseDBResult createResult()
	{
		return new RoleGroupDBResult();
	}
	
	@Override
	protected void toSetValues(boolean isInsert)
	{
		setLong(groupID);
		setInt(createAreaID);
		setInt(funcID);
		setDate(createDate);
		setBytes(data);
	}
	
	@Override
	public Object getPrimaryKeyByIndex(int index)
	{
		switch(index)
		{
			case 0:
				return groupID;
		}
		return null;
	}
	
	@Override
	protected void toSetPrimaryKeyByIndex(int index)
	{
		switch(index)
		{
			case 0:
			{
				setLong(groupID);
			}
				break;
		}
	}
	
}
