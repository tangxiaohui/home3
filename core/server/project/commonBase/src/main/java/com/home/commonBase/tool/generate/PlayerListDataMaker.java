package com.home.commonBase.tool.generate;
import com.home.commonBase.constlist.generate.PlayerListDataType;
import com.home.commonBase.part.player.list.PlayerListData;
import com.home.shine.data.BaseData;
import com.home.shine.tool.CreateDataFunc;
import com.home.shine.tool.DataMaker;

/** (generated by shine) */
public class PlayerListDataMaker extends DataMaker
{
	public PlayerListDataMaker()
	{
		offSet=PlayerListDataType.off;
		list=new CreateDataFunc[PlayerListDataType.count-offSet];
		list[PlayerListDataType.Player-offSet]=this::createPlayerListData;
	}
	
	private BaseData createPlayerListData()
	{
		return new PlayerListData();
	}
	
}
