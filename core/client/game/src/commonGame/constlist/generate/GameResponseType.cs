using ShineEngine;

/// <summary>
/// (generated by shine)
/// </summary>
public class GameResponseType
{
	/// <summary>
	/// 起始
	/// </summary>
	public const int off=700;
	
	/// <summary>
	/// 计数
	/// </summary>
	public const int count=892;
	
	/// <summary>
	/// AOI灯塔刷新消息(删除一组+添加一组)
	/// </summary>
	public const int AOITowerRefresh=700;
	
	/// <summary>
	/// 活动完成一次消息
	/// </summary>
	public const int ActivityCompleteOnce=701;
	
	/// <summary>
	/// 活动重置
	/// </summary>
	public const int ActivityReset=702;
	
	/// <summary>
	/// 活动开启/关闭消息
	/// </summary>
	public const int ActivitySwitch=703;
	
	/// <summary>
	/// 单位发出子弹消息
	/// </summary>
	public const int AddBullet=704;
	
	/// <summary>
	/// 新邮件消息
	/// </summary>
	public const int AddMail=705;
	
	/// <summary>
	/// 添加奖励消息
	/// </summary>
	public const int AddReward=706;
	
	/// <summary>
	/// 添加单位消息
	/// </summary>
	public const int AddUnit=707;
	
	/// <summary>
	/// 攻击伤害数据
	/// </summary>
	public const int AttackDamage=708;
	
	/// <summary>
	/// 建筑建造成功
	/// </summary>
	public const int BuildingBuildComplete=709;
	
	/// <summary>
	/// 建筑取消升级
	/// </summary>
	public const int BuildingCancelLevelUp=710;
	
	/// <summary>
	/// 建筑升级成功的广播协议 注意:包含父类参数 instanceID
	/// </summary>
	public const int BuildingLevelUpingComplete=711;
	
	/// <summary>
	/// 建筑开始升级的广播协议  注意:包含父类参数 instanceID
	/// </summary>
	public const int BuildingStartLevelUp=712;
	
	/// <summary>
	/// 中心服转发消息
	/// </summary>
	public const int CenterTransGameToClient=713;
	
	/// <summary>
	/// 更改角色名字消息
	/// </summary>
	public const int ChangeRoleName=714;
	
	/// <summary>
	/// 角色更新部分角色外显数据消息
	/// </summary>
	public const int CharacterRefreshPartRoleShowData=715;
	
	/// <summary>
	/// 客户端版本热更新消息
	/// </summary>
	public const int ClientHotfix=716;
	
	/// <summary>
	/// 创建角色成功消息
	/// </summary>
	public const int CreatePlayerSuccess=717;
	
	/// <summary>
	/// 每日消息
	/// </summary>
	public const int Daily=718;
	
	/// <summary>
	/// 删除角色成功消息
	/// </summary>
	public const int DeletePlayerSuccess=719;
	
	/// <summary>
	/// 进入空场景消息(为客户端显示)
	/// </summary>
	public const int EnterNoneScene=720;
	
	/// <summary>
	/// 进入场景失败消息
	/// </summary>
	public const int EnterSceneFailed=721;
	
	/// <summary>
	/// 进入场景消息(依赖MessageCopy)
	/// </summary>
	public const int EnterScene=722;
	
	/// <summary>
	/// 帧同步每帧消息
	/// </summary>
	public const int FrameSyncFrame=723;
	
	/// <summary>
	/// 帧同步起始消息
	/// </summary>
	public const int FrameSyncStart=724;
	
	/// <summary>
	/// 拍卖行更新自己出售物品数目消息
	/// </summary>
	public const int FuncAuctionRefreshSaleItem=725;
	
	/// <summary>
	/// 添加物品消息
	/// </summary>
	public const int FuncAddItem=726;
	
	/// <summary>
	/// 推送添加单个物品
	/// </summary>
	public const int FuncAddOneItem=727;
	
	/// <summary>
	/// 添加单个物品数目消息
	/// </summary>
	public const int FuncAddOneItemNum=728;
	
	/// <summary>
	/// 取消匹配消息
	/// </summary>
	public const int FuncCancelMatch=729;
	
	/// <summary>
	/// 匹配结束(成功结束)
	/// </summary>
	public const int FuncMatchOver=730;
	
	/// <summary>
	/// 匹配成功消息
	/// </summary>
	public const int FuncMatchSuccess=731;
	
	/// <summary>
	/// 匹配超时消息
	/// </summary>
	public const int FuncMatchTimeOut=732;
	
	/// <summary>
	/// 重新加入匹配队列消息
	/// </summary>
	public const int FuncReAddMatch=733;
	
	/// <summary>
	/// 功能-回复查询每页排行
	/// </summary>
	public const int FuncReGetPageShow=734;
	
	public const int FuncReGetSelfPageShow=735;
	
	public const int FuncRefreshRank=736;
	
	/// <summary>
	/// 移除物品消息
	/// </summary>
	public const int FuncRemoveItem=737;
	
	/// <summary>
	/// 移除单个物品
	/// </summary>
	public const int FuncRemoveOneItem=738;
	
	/// <summary>
	/// 功能-重置排行消息
	/// </summary>
	public const int FuncResetRank=739;
	
	/// <summary>
	/// 功能发送消息
	/// </summary>
	public const int FuncS=740;
	
	/// <summary>
	/// 推送接受匹配
	/// </summary>
	public const int FuncSendAcceptMatch=741;
	
	/// <summary>
	/// 推送整理物品消息
	/// </summary>
	public const int FuncSendCleanUpItem=742;
	
	/// <summary>
	/// 移动装备消息
	/// </summary>
	public const int FuncSendMoveEquip=743;
	
	/// <summary>
	/// 脱装备
	/// </summary>
	public const int FuncSendPutOffEquip=744;
	
	/// <summary>
	/// 穿装备
	/// </summary>
	public const int FuncSendPutOnEquip=745;
	
	/// <summary>
	/// 开始匹配消息
	/// </summary>
	public const int FuncStartMatch=746;
	
	/// <summary>
	/// 使用物品结果消息
	/// </summary>
	public const int FuncUseItemResult=747;
	
	/// <summary>
	/// 初始化客户端消息(ClientListData)(此处需要使用copy,因工具已改为潜拷,为了逻辑层避开深拷问题)
	/// </summary>
	public const int InitClient=748;
	
	/// <summary>
	/// 离开场景消息
	/// </summary>
	public const int LeaveScene=749;
	
	/// <summary>
	/// 升级消息
	/// </summary>
	public const int LevelUp=750;
	
	/// <summary>
	/// 主角加buff
	/// </summary>
	public const int MUnitAddBuff=751;
	
	/// <summary>
	/// 控制单位添加组CD上限百分比
	/// </summary>
	public const int MUnitAddGroupTimeMaxPercent=752;
	
	/// <summary>
	/// 控制单位添加组CD上限值
	/// </summary>
	public const int MUnitAddGroupTimeMaxValue=753;
	
	/// <summary>
	/// 控制单位添加组时间经过
	/// </summary>
	public const int MUnitAddGroupTimePass=754;
	
	/// <summary>
	/// 主角加技能消息
	/// </summary>
	public const int MUnitAddSkill=755;
	
	/// <summary>
	/// 刷新主角属性
	/// </summary>
	public const int MUnitRefreshAttributes=756;
	
	/// <summary>
	/// 控制单位刷新造型消息
	/// </summary>
	public const int MUnitRefreshAvatar=757;
	
	/// <summary>
	/// 控制单位改变显示部件
	/// </summary>
	public const int MUnitRefreshAvatarPart=758;
	
	/// <summary>
	/// 主角刷buff剩余次数
	/// </summary>
	public const int MUnitRefreshBuffLastNum=759;
	
	/// <summary>
	/// 主角刷buff
	/// </summary>
	public const int MUnitRefreshBuff=760;
	
	/// <summary>
	/// 刷新主角状态
	/// </summary>
	public const int MUnitRefreshStatus=761;
	
	/// <summary>
	/// 主角移除buff
	/// </summary>
	public const int MUnitRemoveBuff=762;
	
	/// <summary>
	/// 控制单位移除组CD消息
	/// </summary>
	public const int MUnitRemoveGroupCD=763;
	
	/// <summary>
	/// 主角删技能消息
	/// </summary>
	public const int MUnitRemoveSkill=764;
	
	/// <summary>
	/// 玩家单位开始CD组
	/// </summary>
	public const int MUnitStartCDs=765;
	
	/// <summary>
	/// 预备进入场景消息
	/// </summary>
	public const int PreEnterScene=766;
	
	/// <summary>
	/// 预进入场景服务器就绪
	/// </summary>
	public const int PreEnterSceneNext=767;
	
	/// <summary>
	/// 单位拉回消息
	/// </summary>
	public const int ReCUnitPullBack=768;
	
	/// <summary>
	/// 回复技能失败消息
	/// </summary>
	public const int ReCUnitSkillFailedEx=769;
	
	/// <summary>
	/// 回复C单位技能失败
	/// </summary>
	public const int ReCUnitSkillFailed=770;
	
	/// <summary>
	/// 回复获取全部邮件消息
	/// </summary>
	public const int ReGetAllMail=771;
	
	/// <summary>
	/// 回复角色列表消息
	/// </summary>
	public const int RePlayerList=772;
	
	/// <summary>
	/// 回复查询角色消息
	/// </summary>
	public const int ReQueryPlayer=773;
	
	/// <summary>
	/// 返回搜索结果
	/// </summary>
	public const int ReSearchPlayer=774;
	
	/// <summary>
	/// 回复更新社交数据消息
	/// </summary>
	public const int ReUpdateRoleSocialData=775;
	
	/// <summary>
	/// 刷新单个社交数据(实时刷新用)
	/// </summary>
	public const int ReUpdateRoleSocialDataOne=776;
	
	/// <summary>
	/// 收到客户端离线事务消息
	/// </summary>
	public const int ReceiveClientOfflineWork=777;
	
	/// <summary>
	/// 刷新货币消息
	/// </summary>
	public const int RefreshCurrency=778;
	
	/// <summary>
	/// 刷新当期线ID消息
	/// </summary>
	public const int RefreshCurrentLine=779;
	
	/// <summary>
	/// 刷经验消息
	/// </summary>
	public const int RefreshExp=780;
	
	/// <summary>
	/// 刷新角色战斗力消息
	/// </summary>
	public const int RefreshFightForce=781;
	
	/// <summary>
	/// 刷新引导步消息
	/// </summary>
	public const int RefreshMainGuideStep=782;
	
	/// <summary>
	/// 更新操作体状态消息
	/// </summary>
	public const int RefreshOperationState=783;
	
	/// <summary>
	/// 刷新服务器时间
	/// </summary>
	public const int RefreshServerTime=784;
	
	/// <summary>
	/// 刷新目标数目消息
	/// </summary>
	public const int RefreshTask=785;
	
	/// <summary>
	/// 刷新单位属性
	/// </summary>
	public const int RefreshUnitAttributes=786;
	
	/// <summary>
	/// 刷新单位造型消息
	/// </summary>
	public const int RefreshUnitAvatar=787;
	
	/// <summary>
	/// 刷新单位显示部件数据
	/// </summary>
	public const int RefreshUnitAvatarPart=788;
	
	/// <summary>
	/// 刷新单位状态
	/// </summary>
	public const int RefreshUnitStatus=789;
	
	/// <summary>
	/// 移除子弹
	/// </summary>
	public const int RemoveBullet=790;
	
	/// <summary>
	/// 移除单位协议
	/// </summary>
	public const int RemoveUnit=791;
	
	/// <summary>
	/// 推送场景广播消息
	/// </summary>
	public const int SceneRadio=792;
	
	/// <summary>
	/// 场景推送基类
	/// </summary>
	public const int SceneS=793;
	
	/// <summary>
	/// 推送添加成就消息
	/// </summary>
	public const int SendAcceptAchievement=794;
	
	/// <summary>
	/// 推送接任务消息
	/// </summary>
	public const int SendAcceptQuest=795;
	
	/// <summary>
	/// 推送成就完成消息
	/// </summary>
	public const int SendAchievementComplete=796;
	
	/// <summary>
	/// 推送添加好友黑名单
	/// </summary>
	public const int SendAddFriendBlackList=797;
	
	/// <summary>
	/// 推送添加好友消息
	/// </summary>
	public const int SendAddFriend=798;
	
	/// <summary>
	/// 推送申请添加好友消息
	/// </summary>
	public const int SendApplyAddFriend=799;
	
	/// <summary>
	/// 推送副本类场景状态信息
	/// </summary>
	public const int SendBattleState=800;
	
	/// <summary>
	/// 推送绑定平台消息
	/// </summary>
	public const int SendBindPlatform=801;
	
	/// <summary>
	/// 推送清空全部任务(gm)
	/// </summary>
	public const int SendClearAllQuestByGM=802;
	
	/// <summary>
	/// 推送交任务消息
	/// </summary>
	public const int SendCommitQuest=803;
	
	/// <summary>
	/// 推送删除邮件消息
	/// </summary>
	public const int SendDeleteMail=804;
	
	/// <summary>
	/// 推送Game服息回执
	/// </summary>
	public const int SendGameReceiptToClient=805;
	
	/// <summary>
	/// 推送领取成就奖励成功消息
	/// </summary>
	public const int SendGetAchievementRewardSuccess=806;
	
	/// <summary>
	/// 推送任务放弃消息
	/// </summary>
	public const int SendGiveUpQuest=807;
	
	/// <summary>
	/// 推送信息码消息
	/// </summary>
	public const int SendInfoCode=808;
	
	/// <summary>
	/// 推送带参信息码消息
	/// </summary>
	public const int SendInfoCodeWithArgs=809;
	
	/// <summary>
	/// 推送任务失败消息
	/// </summary>
	public const int SendQuestFailed=810;
	
	/// <summary>
	/// 推送强制删除已接任务消息
	/// </summary>
	public const int SendRemoveAcceptQuest=811;
	
	/// <summary>
	/// 推送移除好友黑名单
	/// </summary>
	public const int SendRemoveFriendBlackList=812;
	
	/// <summary>
	/// 推送移除好友
	/// </summary>
	public const int SendRemoveFriend=813;
	
	/// <summary>
	/// 切换game服消息
	/// </summary>
	public const int SwitchGame=814;
	
	/// <summary>
	/// 领取邮件成功
	/// </summary>
	public const int TakeMailSuccess=815;
	
	/// <summary>
	/// 添加buff消息
	/// </summary>
	public const int UnitAddBuff=816;
	
	/// <summary>
	/// 单位添加组CD百分比
	/// </summary>
	public const int UnitAddGroupTimeMaxPercent=817;
	
	/// <summary>
	/// 单位添加组CD固定值
	/// </summary>
	public const int UnitAddGroupTimeMaxValue=818;
	
	/// <summary>
	/// 单位添加组CD时间经过
	/// </summary>
	public const int UnitAddGroupTimePass=819;
	
	/// <summary>
	/// 单位聊天消息
	/// </summary>
	public const int UnitChat=820;
	
	/// <summary>
	/// 单位死亡消息
	/// </summary>
	public const int UnitDead=821;
	
	/// <summary>
	/// 单位移动朝向消息
	/// </summary>
	public const int UnitMoveDir=822;
	
	/// <summary>
	/// 单位移动点组消息
	/// </summary>
	public const int UnitMovePosList=823;
	
	/// <summary>
	/// 单位移动位置
	/// </summary>
	public const int UnitMovePos=824;
	
	/// <summary>
	/// 单位确认选择
	/// </summary>
	public const int UnitPreBattleSure=825;
	
	/// <summary>
	/// 单位刷新buff剩余次数消息
	/// </summary>
	public const int UnitRefreshBuffLastNum=826;
	
	/// <summary>
	/// 单位刷新buff
	/// </summary>
	public const int UnitRefreshBuff=827;
	
	/// <summary>
	/// 单位移除buff
	/// </summary>
	public const int UnitRemoveBuff=828;
	
	/// <summary>
	/// 单位移除组CD
	/// </summary>
	public const int UnitRemoveGroupCD=829;
	
	/// <summary>
	/// 单位复活消息
	/// </summary>
	public const int UnitRevive=830;
	
	public const int UnitS=831;
	
	/// <summary>
	/// 单位释放技能结束(强制结束)
	/// </summary>
	public const int UnitSkillOver=832;
	
	/// <summary>
	/// 单位特殊移动消息
	/// </summary>
	public const int UnitSpecialMove=833;
	
	/// <summary>
	/// 单位开始CD组
	/// </summary>
	public const int UnitStartCDs=834;
	
	/// <summary>
	/// 单位停止移动(reIdle)
	/// </summary>
	public const int UnitStopMove=835;
	
	/// <summary>
	/// 单位同步指令消息
	/// </summary>
	public const int UnitSyncCommand=836;
	
	/// <summary>
	/// 单位使用技能
	/// </summary>
	public const int UnitUseSkill=837;
	
	/// <summary>
	/// 推送添加玩家群消息
	/// </summary>
	public const int FuncSendPlayerJoinRoleGroup=838;
	
	/// <summary>
	/// 推送玩家离开玩家群消息
	/// </summary>
	public const int FuncSendPlayerLeaveRoleGroup=839;
	
	/// <summary>
	/// 推送添加成员消息
	/// </summary>
	public const int FuncSendRoleGroupAddMember=840;
	
	/// <summary>
	/// 推送玩家群移除成员
	/// </summary>
	public const int FuncSendRoleGroupRemoveMember=841;
	
	/// <summary>
	/// 玩家群消息基类
	/// </summary>
	public const int FuncPlayerRoleGroupS=842;
	
	/// <summary>
	/// 添加申请消息
	/// </summary>
	public const int FuncSendAddApplyRoleGroup=843;
	
	/// <summary>
	/// 推送处理申请结果玩家群
	/// </summary>
	public const int FuncSendHandleApplyResultRoleGroup=844;
	
	/// <summary>
	/// 推送处理邀请结果到邀请者
	/// </summary>
	public const int FuncSendHandleInviteResultRoleGroup=845;
	
	/// <summary>
	/// 推送邀请加入玩家群消息
	/// </summary>
	public const int FuncSendInviteRoleGroup=846;
	
	/// <summary>
	/// 推送获取翻页显示内容，无缓存方式
	/// </summary>
	public const int FuncReGetPageShowList=847;
	
	/// <summary>
	/// 更新成员职位
	/// </summary>
	public const int FuncRefeshTitleRoleGroup=848;
	
	/// <summary>
	/// 推送更换队长消息
	/// </summary>
	public const int FuncSendChangeLeaderRoleGroup=849;
	
	public const int FuncRefreshSubsectionRank=850;
	
	/// <summary>
	/// 逻辑服转发消息
	/// </summary>
	public const int GameTransGameToClient=851;
	
	/// <summary>
	/// 群里有权限成员通知处理申请结果
	/// </summary>
	public const int FuncSendHandleApplyResultToMember=852;
	
	/// <summary>
	/// 添加申请玩家群到自身消息
	/// </summary>
	public const int FuncSendAddApplyRoleGroupSelf=853;
	
	/// <summary>
	/// 推送玩家群变更数据
	/// </summary>
	public const int FuncSendRoleGroupChange=854;
	
	/// <summary>
	/// 推送信息日志消息
	/// </summary>
	public const int SendInfoLog=855;
	
	/// <summary>
	/// 推送获取分段翻页显示内容，无缓存方式
	/// </summary>
	public const int FuncReGetSubsectionPageShowList=856;
	
	/// <summary>
	/// 发送被邀请时是否可直接入群的变化
	/// </summary>
	public const int FuncSendChangeCanInviteInAbsRoleGroup=857;
	
	/// <summary>
	/// 客户端热更配置消息
	/// </summary>
	public const int ClientHotfixConfig=858;
	
	/// <summary>
	/// 玩家群信息日志消息
	/// </summary>
	public const int FuncSendRoleGroupInfoLog=859;
	
	/// <summary>
	/// 玩家群成员数据改变消息
	/// </summary>
	public const int FuncSendRoleGroupMemberChange=860;
	
	/// <summary>
	/// 回复获取玩家群数据消息
	/// </summary>
	public const int FuncReGetRoleGroupData=861;
	
	/// <summary>
	/// 单位直接更改位置朝向消息
	/// </summary>
	public const int UnitSetPosDir=862;
	
	/// <summary>
	/// 添加掉落物品包绑定消息
	/// </summary>
	public const int AddFieldItemBagBind=863;
	
	public const int RemoveFieldItemBagBind=864;
	
	/// <summary>
	/// 角色刷新属性
	/// </summary>
	public const int RoleRefreshAttribute=865;
	
	/// <summary>
	/// 角色推送消息
	/// </summary>
	public const int RoleS=866;
	
	/// <summary>
	/// 推送角色聊天
	/// </summary>
	public const int SendPlayerChat=867;
	
	/// <summary>
	/// 添加宠物
	/// </summary>
	public const int AddPet=868;
	
	public const int FuncSendRoleGroupMemberRoleShowChange=869;
	
	/// <summary>
	/// 添加绑定视野单位
	/// </summary>
	public const int AddBindVisionUnit=870;
	
	public const int RemoveBindVisionUnit=871;
	
	/// <summary>
	/// 刷新简版单位属性消息
	/// </summary>
	public const int RefreshSimpleUnitAttribute=872;
	
	/// <summary>
	/// 刷新简版单位位置消息
	/// </summary>
	public const int RefreshSimpleUnitPos=873;
	
	/// <summary>
	/// 推送移动物品
	/// </summary>
	public const int FuncSendMoveItem=874;
	
	/// <summary>
	/// 改变格子数
	/// </summary>
	public const int FuncRefreshItemGridNum=875;
	
	public const int FuncRefreshRoleGroupRank=876;
	
	public const int FuncResetRoleGroupRank=877;
	
	/// <summary>
	/// 推送警告日志
	/// </summary>
	public const int SendWarningLog=878;
	
	/// <summary>
	/// 单位下载具消息
	/// </summary>
	public const int UnitGetOffVehicle=879;
	
	/// <summary>
	/// 单位上载具消息
	/// </summary>
	public const int UnitGetOnVehicle=880;
	
	public const int UnitDrive=881;
	
	/// <summary>
	/// 功能关闭
	/// </summary>
	public const int FuncClose=882;
	
	/// <summary>
	/// 功能开启
	/// </summary>
	public const int FuncOpen=883;
	
	/// <summary>
	/// 拍卖行添加自己的出售物品消息
	/// </summary>
	public const int FuncAuctionAddSaleItem=884;
	
	/// <summary>
	/// 返回拍卖行查询结果
	/// </summary>
	public const int FuncAuctionReQuery=885;
	
	/// <summary>
	/// 主单位消息基类
	/// </summary>
	public const int MUnitS=886;
	
	/// <summary>
	/// 更新宠物是否出战消息
	/// </summary>
	public const int RefreshPetIsWorking=887;
	
	/// <summary>
	/// 回复获取拍卖行物品推荐价格
	/// </summary>
	public const int FuncReGetAuctionItemSuggestPrice=888;
	
	/// <summary>
	/// 删除宠物
	/// </summary>
	public const int RemovePet=889;
	
	/// <summary>
	/// 拍卖行移除自己的物品消息
	/// </summary>
	public const int FuncAuctionRemoveSaleItem=890;
	
	/// <summary>
	/// 攻击伤害单个数据()
	/// </summary>
	public const int AttackDamageOne=891;
	
}
