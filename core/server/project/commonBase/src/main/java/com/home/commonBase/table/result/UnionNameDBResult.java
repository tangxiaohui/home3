package com.home.commonBase.table.result;
import com.home.shine.table.BaseDBResult;

/** 工会名字表(generated by shine) */
public class UnionNameDBResult extends BaseDBResult
{
	/** 名字 */
	public String name="";
	
	/** 角色id */
	public long groupID;
	
	@Override
	protected void toReadValues()
	{
		name=readString();
		groupID=readLong();
	}
	
	@Override
	public Object getPrimaryKeyByIndex(int index)
	{
		switch(index)
		{
			case 0:
				return name;
		}
		
		return null;
	}
	
}