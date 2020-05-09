package com.home.commonBase.table.result;
import com.home.shine.table.BaseDBResult;

/** 中心服角色名字表(generated by shine) */
public class PlayerNameDBResult extends BaseDBResult
{
	/** 名字 */
	public String name="";
	
	/** 角色id */
	public long playerID;
	
	@Override
	protected void toReadValues()
	{
		name=readString();
		playerID=readLong();
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