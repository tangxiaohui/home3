package com.home.commonBase.table.task;
import com.home.commonBase.table.result.ServerDBResult;
import com.home.commonBase.table.table.ServerTable;
import com.home.shine.table.BaseDBResult;
import com.home.shine.table.BaseTable;
import com.home.shine.table.task.BaseDBTask;

/** 服务器信息表(generated by shine) */
public class ServerDBTask extends BaseDBTask
{
	/** 创建时区服ID */
	public int areaID;
	
	/** 当前区服ID */
	public int nowAreaID;
	
	/** 服务器名(描述) */
	public String name="";
	
	@Override
	public BaseTable createTable()
	{
		return new ServerTable();
	}
	
	@Override
	public BaseDBResult createResult()
	{
		return new ServerDBResult();
	}
	
	@Override
	protected void toSetValues(boolean isInsert)
	{
		setInt(areaID);
		setInt(nowAreaID);
		setString(name);
	}
	
	@Override
	public Object getPrimaryKeyByIndex(int index)
	{
		switch(index)
		{
			case 0:
				return areaID;
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
				setInt(areaID);
			}
				break;
		}
	}
	
}