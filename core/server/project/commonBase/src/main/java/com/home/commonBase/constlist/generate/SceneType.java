package com.home.commonBase.constlist.generate;
import com.home.commonBase.config.game.enumT.SceneTypeConfig;

/** 场景类型(generated by shine) */
public class SceneType
{
	/** 长度 */
	public static int size=1;
	
	/** 获取实例类型 */
	public static int getInstanceType(int type)
	{
		return SceneTypeConfig.get(type).instanceType;
	}
	
}
