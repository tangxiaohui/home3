package com.home.commonBase.global;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.data.BaseData;

/** 全局配置表(generated by shine) */
public class GlobalReadData extends BaseData
{
	/** 每个账号一个区服可拥有的角色数目(合服不影响每个被合区服的拥有角色数目) */
	public int ownPlayerNum;
	
	/** 每个game服设计承载人数(在线) */
	public int gameDesignBearNum;
	
	/** 每个game服最大承载人数(在线) */
	public int gameMaxBearNum;
	
	/** 每个区服设计注册人数 */
	public int areaDesignRegistNum;
	
	/** 每个区最大注册人数 */
	public int areaMaxRegistNum;
	
	/** 角色名字上限数目(机器字) */
	public int playerNameLength;
	
	/** 角色名字是否使用区服ID作为前缀,如(s1.张三) */
	public boolean isNameUseAreaIDAsFront;
	
	/** 角色名字是否可以重名 */
	public boolean canPlayerNameRepeat;
	
	/** 客户端离线事务，每日可修改时间的次数 */
	public int clientOfflineWorkTimeChangeDailyNum;
	
	/** 显示网络延迟圈圈最大超时时间(ms) */
	public int showNetDelayMaxTime;
	
	/** 显示网络延迟圈圈最小间隔(ms) */
	public int showNetDelayMinTime;
	
	/** 激活码长度 */
	public int activationCodeLength;
	
	/** 激活码是否使用批次(每批次每个玩家只能用一次) */
	public boolean activationCodeUseBatch;
	
	/** 游戏信息日志保留时间(玩家自身)(day) */
	public int infoLogKeepTime;
	
	/** 游戏信息日志保留数目(玩家自身) */
	public int infoLogKeepNum;
	
	/** 翻页显示插件每页CD(s) */
	public int pageToolShowCD;
	
	/** 大Float数字每段位数(3为千,4为万) */
	public int bigFloatWei;
	
	/** 坐标推送缩放比率 */
	public float posSendScale;
	
	/** 朝向推送缩放比率 */
	public float directionSendScale;
	
	/** 保持当前属性百分比在上限改变前(否则就是保持当前值不变) */
	public boolean keepCurrentPercentAtMaxChange;
	
	/** 单位转身XY和最小值(小于此值不转身) */
	public float unitTurnXYSumMin;
	
	/** 单位移动XY和的最大允许误差(超过此值即拉回) */
	public float unitMovePosMaxDeviation;
	
	/** 距离验证允许误差 */
	public float distanceCheckDeviation;
	
	/** 移动速度最小值 */
	public int moveSpeedMin;
	
	/** 移动速度最大值 */
	public int moveSpeedMax;
	
	/** 攻击速度最小值 */
	public int attackSpeedMin;
	
	/** 攻击速度最大值 */
	public int attackSpeedMax;
	
	/** 施法速度最小值 */
	public int castSpeedMin;
	
	/** 施法速度最大值 */
	public int castSpeedMax;
	
	/** 使用移动速度比率(使用值=数值*比率)(每秒多少米) */
	public float useMoveSpeedRatio;
	
	/** 命中公式参数0(基础命中率) */
	public float hitRateArg0;
	
	/** 暴击公式参数0(基础暴击率) */
	public float critArg0;
	
	/** 暴击默认伤害比率 */
	public float critDamageBaseRatio;
	
	/** 子弹最长保留时间(s) */
	public int bulletMaxLastTime;
	
	/** 场景保留时间(s) */
	public int sceneKeepTime;
	
	/** 攻击范围背向延伸距离(米) */
	public float attackScopeBackLength;
	
	/** 攻击范围默认攻击高度(米) */
	public float attackScopeDefaultHeight;
	
	/** 帧同步缓存帧数 */
	public int frameSyncCacheFrames;
	
	/** 徘徊等待时间最小值(s) */
	public int wanderWaitTimeMin;
	
	/** 徘徊等待时间最大值(s) */
	public int wanderWaitTimeMax;
	
	/** 徘徊移动半径(米) */
	public float wanderMoveRadius;
	
	/** 阻止网络延迟时间(ms) */
	public int preventNetDelayTime;
	
	/** 场景分线数目(仅在sceneLinePlayerLimitNum为0时有意义) */
	public int sceneLineNum;
	
	/** 客户端移动消息发送最短间隔(ms) */
	public int clientMoveSendMinDelay;
	
	/** 朝向移动预测最短距离(米) */
	public float moveDirForecastMinDistance;
	
	/** 朝向移动预测时间(ms) */
	public int moveDirForecastTime;
	
	/** 朝向移动预测发送消息间隔(ms) */
	public int moveDirSendDelay;
	
	/** 地图阻挡尺寸(米) */
	public float mapBlockSize;
	
	/** 怪物退回时每秒回血千分比 */
	public int monsterBackAddHPPercent;
	
	/** 地图SamplePosition半径(米) */
	public float mapSamplePositionRadius;
	
	/** 光环buff更新时间(ms) */
	public int ringLightBuffRefreshTime;
	
	/** 光环buff单次持续时间(ms) */
	public int ringLightBuffLastTime;
	
	/** 唤醒同伴间隔时间(ms) */
	public int wakeUpCompanionDelayTime;
	
	/** 战斗状态单次持续时间(ms) */
	public int fightStateOnceLastTime;
	
	/** 出生主城ID */
	public int bornTownID;
	
	/** 场景分线角色限制数目(当此值大于0时,视为启用按人数分线策略,并且sceenLineNum值无效) */
	public int sceneLinePlayerLimitNum;
	
	/** 单位AI受击判定最短间隔(ms) */
	public int unitBeAttackDelay;
	
	/** 单位切换基础成本 */
	public float unitSwitchFixedCost;
	
	/** 单位切换基础距离 */
	public float unitSwitchBaseDistance;
	
	/** 单位切换距离成本系数 */
	public float unitSwitchDistanceCost;
	
	/** 单位切换仇恨成本系数 */
	public float unitSwitchHateCost;
	
	/** 单位仇恨伤害千分比系数 */
	public float unitHateDamagePercentRatio;
	
	/** 出生主城位置ID */
	public int bornTownPosID;
	
	/** 匹配成功后最长等待确认时间(s) */
	public int matchWaitTime;
	
	/** 场景AOI灯塔尺寸 */
	public int aoiTowerSize;
	
	/** aoi可视单位上限 */
	public int aoiSeeMax;
	
	/** 拾取范围半径(米) */
	public float pickUpRadius;
	
	/** 自增属性计算间隔(ms) */
	public int increaseAttributeDelay;
	
	/** 自动分线场景，单场景容量 */
	public int autoLinedSceneCapacity;
	
	/** 自动分线场景，预备超时时间(s) */
	public int autoLinedScenePreTimeOut;
	
	/** 摄像机最近距离(与目标距离) */
	public float cameraMinDistance;
	
	/** 摄像机最长距离(与目标距离) */
	public float cameraMaxDistance;
	
	/** 摄像机2.5D视角(角度) */
	public float camera25DAngle;
	
	/** 摄像机最小视角(角度) */
	public float cameraMinAxisXAngle;
	
	/** 摄像机大小视角(角度) */
	public float cameraMaxAxisXAngle;
	
	/** 摄像机缓动时间(s) */
	public float cameraTweenTime;
	
	/** 摄像机鼠标滚轮缩放速度 */
	public float cameraWheelSpeed;
	
	/** 摄像机默认距离 */
	public float cameraDefaultDistance;
	
	/** 摄像机X轴旋转速度 */
	public float cameraRotateSpeedX;
	
	/** 摄像机Y轴旋转速度 */
	public float cameraRotateSpeedY;
	
	/** 摄像机触摸缩放速度 */
	public float cameraScaleSpeed;
	
	/** 等级上限 */
	public int levelMax;
	
	/** 主背包格子数(初始) */
	public int mainBagGridNum;
	
	/** 邮件每页显示数目 */
	public int mailPageEachShowNum;
	
	/** 邮件最多保存数目 */
	public int mailSaveMaxNum;
	
	/** 邮件最长保存时间(天) */
	public int mailSaveMaxTime;
	
	/** 玩家发送的邮件ID */
	public int playerMailID;
	
	/** 任务可视等级差 */
	public int questCanSeeLevelD;
	
	/** 好友功能启用双向好友(否则单向) */
	public boolean useOvonicFriend;
	
	/** 好友上限数目(0为无上限) */
	public int friendMaxNum;
	
	/** 任务配置变更版本号 */
	public int questConfigChangeVersion;
	
	/** 好友黑名单上限数目(0为无上限) */
	public int friendBlackListMaxNum;
	
	/** 申请添加好友上限数目(0为无上限) */
	public int applyAddFriendMaxNum;
	
	/** 好友申请最长保存时间(天) */
	public int friendApplySaveMaxTime;
	
	/** 工会的玩家群id(<=0则为无工会) */
	public int unionRoleGroupID;
	
	/** 组队的玩家群id(<=0则为无组队功能) */
	public int teamRoleGroupID;
	
	/** 组队共享半径(米)(0为无限) */
	public float teamShareRadius;
	
	/** 客户端随机种子数目 */
	public int clientRandomSeedNum;
	
	/** 伤害值是否使用实际伤害值 */
	public boolean damageValueUseRealDamage;
	
	/** 宠物同一id是否唯一 */
	public boolean isPetUnique;
	
	/** 宠物是否需要装备功能 */
	public boolean isPetNeedEquip;
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.ownPlayerNum=stream.readInt();
		
		this.gameDesignBearNum=stream.readInt();
		
		this.gameMaxBearNum=stream.readInt();
		
		this.areaDesignRegistNum=stream.readInt();
		
		this.areaMaxRegistNum=stream.readInt();
		
		this.playerNameLength=stream.readInt();
		
		this.isNameUseAreaIDAsFront=stream.readBoolean();
		
		this.canPlayerNameRepeat=stream.readBoolean();
		
		this.clientOfflineWorkTimeChangeDailyNum=stream.readInt();
		
		this.showNetDelayMinTime=stream.readInt();
		
		this.showNetDelayMaxTime=stream.readInt();
		
		this.activationCodeLength=stream.readInt();
		
		this.activationCodeUseBatch=stream.readBoolean();
		
		this.infoLogKeepTime=stream.readInt();
		
		this.infoLogKeepNum=stream.readInt();
		
		this.clientRandomSeedNum=stream.readInt();
		
		this.pageToolShowCD=stream.readInt();
		
		this.bigFloatWei=stream.readInt();
		
		this.posSendScale=stream.readFloat();
		
		this.directionSendScale=stream.readFloat();
		
		this.keepCurrentPercentAtMaxChange=stream.readBoolean();
		
		this.unitTurnXYSumMin=stream.readFloat();
		
		this.unitMovePosMaxDeviation=stream.readFloat();
		
		this.distanceCheckDeviation=stream.readFloat();
		
		this.moveSpeedMin=stream.readInt();
		
		this.moveSpeedMax=stream.readInt();
		
		this.attackSpeedMin=stream.readInt();
		
		this.attackSpeedMax=stream.readInt();
		
		this.castSpeedMin=stream.readInt();
		
		this.castSpeedMax=stream.readInt();
		
		this.useMoveSpeedRatio=stream.readFloat();
		
		this.hitRateArg0=stream.readFloat();
		
		this.critArg0=stream.readFloat();
		
		this.critDamageBaseRatio=stream.readFloat();
		
		this.bulletMaxLastTime=stream.readInt();
		
		this.sceneKeepTime=stream.readInt();
		
		this.attackScopeBackLength=stream.readFloat();
		
		this.attackScopeDefaultHeight=stream.readFloat();
		
		this.frameSyncCacheFrames=stream.readInt();
		
		this.wanderWaitTimeMin=stream.readInt();
		
		this.wanderWaitTimeMax=stream.readInt();
		
		this.wanderMoveRadius=stream.readFloat();
		
		this.preventNetDelayTime=stream.readInt();
		
		this.increaseAttributeDelay=stream.readInt();
		
		this.clientMoveSendMinDelay=stream.readInt();
		
		this.moveDirSendDelay=stream.readInt();
		
		this.moveDirForecastTime=stream.readInt();
		
		this.moveDirForecastMinDistance=stream.readFloat();
		
		this.mapBlockSize=stream.readFloat();
		
		this.mapSamplePositionRadius=stream.readFloat();
		
		this.monsterBackAddHPPercent=stream.readInt();
		
		this.ringLightBuffRefreshTime=stream.readInt();
		
		this.ringLightBuffLastTime=stream.readInt();
		
		this.fightStateOnceLastTime=stream.readInt();
		
		this.wakeUpCompanionDelayTime=stream.readInt();
		
		this.damageValueUseRealDamage=stream.readBoolean();
		
		this.unitBeAttackDelay=stream.readInt();
		
		this.unitHateDamagePercentRatio=stream.readFloat();
		
		this.unitSwitchHateCost=stream.readFloat();
		
		this.unitSwitchDistanceCost=stream.readFloat();
		
		this.unitSwitchBaseDistance=stream.readFloat();
		
		this.unitSwitchFixedCost=stream.readFloat();
		
		this.sceneLineNum=stream.readInt();
		
		this.sceneLinePlayerLimitNum=stream.readInt();
		
		this.bornTownID=stream.readInt();
		
		this.bornTownPosID=stream.readInt();
		
		this.matchWaitTime=stream.readInt();
		
		this.aoiTowerSize=stream.readInt();
		
		this.aoiSeeMax=stream.readInt();
		
		this.pickUpRadius=stream.readFloat();
		
		this.autoLinedSceneCapacity=stream.readInt();
		
		this.autoLinedScenePreTimeOut=stream.readInt();
		
		this.cameraMinDistance=stream.readFloat();
		
		this.cameraMaxDistance=stream.readFloat();
		
		this.camera25DAngle=stream.readFloat();
		
		this.cameraMinAxisXAngle=stream.readFloat();
		
		this.cameraMaxAxisXAngle=stream.readFloat();
		
		this.cameraTweenTime=stream.readFloat();
		
		this.cameraWheelSpeed=stream.readFloat();
		
		this.cameraDefaultDistance=stream.readFloat();
		
		this.cameraRotateSpeedX=stream.readFloat();
		
		this.cameraRotateSpeedY=stream.readFloat();
		
		this.cameraScaleSpeed=stream.readFloat();
		
		this.levelMax=stream.readInt();
		
		this.mainBagGridNum=stream.readInt();
		
		this.mailPageEachShowNum=stream.readInt();
		
		this.mailSaveMaxNum=stream.readInt();
		
		this.mailSaveMaxTime=stream.readInt();
		
		this.playerMailID=stream.readInt();
		
		this.questCanSeeLevelD=stream.readInt();
		
		this.questConfigChangeVersion=stream.readInt();
		
		this.useOvonicFriend=stream.readBoolean();
		
		this.friendMaxNum=stream.readInt();
		
		this.friendBlackListMaxNum=stream.readInt();
		
		this.applyAddFriendMaxNum=stream.readInt();
		
		this.friendApplySaveMaxTime=stream.readInt();
		
		this.unionRoleGroupID=stream.readInt();
		
		this.teamRoleGroupID=stream.readInt();
		
		this.teamShareRadius=stream.readFloat();
		
		this.isPetUnique=stream.readBoolean();
		
		this.isPetNeedEquip=stream.readBoolean();
		
	}
	
}