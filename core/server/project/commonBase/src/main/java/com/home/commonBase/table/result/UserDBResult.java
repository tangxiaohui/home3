package com.home.commonBase.table.result;
import com.home.shine.table.BaseDBResult;

/** 用户表(generated by shine) */
public class UserDBResult extends BaseDBResult
{
	/** 用户ID */
	public long userID;
	
	/** platform_uid */
	public String puid="";
	
	/** 平台类型 */
	public String platform="";
	
	/** 是否成人 */
	public boolean isAdult;
	
	/** 绑定(上次选择)区服ID */
	public int areaID;
	
	/** 拥有角色ID组(逗号分隔) */
	public String playerIDs="";
	
	/** 指向源userID(一账号多平台用) */
	public long sourceUserID;
	
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
	
	@Override
	public Object getPrimaryKeyByIndex(int index)
	{
		switch(index)
		{
			case 0:
				return userID;
			case 1:
				return puid;
		}
		
		return null;
	}
	
}
