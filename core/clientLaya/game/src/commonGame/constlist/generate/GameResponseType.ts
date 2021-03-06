namespace Shine
{
	/** (generated by shine) */
	export class GameResponseType
	{
		/** 起始 */
		public static off:number=700;
		
		/** 计数 */
		public static count:number=868;
		
		/** 活动完成一次消息 */
		public static ActivityCompleteOnce:number=701;
		
		/** 活动重置 */
		public static ActivityReset:number=702;
		
		/** 单位发出子弹消息 */
		public static AddBullet:number=704;
		
		/** 新邮件消息 */
		public static AddMail:number=705;
		
		/** 添加奖励消息 */
		public static AddReward:number=706;
		
		/** 添加单位消息 */
		public static AddUnit:number=707;
		
		/** 攻击伤害数据 */
		public static AttackDamage:number=708;
		
		/** 中心服转发消息 */
		public static CenterTransGameToClient:number=713;
		
		/** 更改角色名字消息 */
		public static ChangeRoleName:number=714;
		
		/** 角色更新部分角色外显数据消息 */
		public static CharacterRefreshPartRoleShowData:number=715;
		
		/** 客户端版本热更新消息 */
		public static ClientHotfix:number=716;
		
		/** 创建角色成功消息 */
		public static CreatePlayerSuccess:number=717;
		
		/** 每日消息 */
		public static Daily:number=718;
		
		/** 删除角色成功消息 */
		public static DeletePlayerSuccess:number=719;
		
		/** 进入空场景消息(为客户端显示) */
		public static EnterNoneScene:number=720;
		
		/** 进入场景失败消息 */
		public static EnterSceneFailed:number=721;
		
		/** 进入场景消息(依赖MessageCopy) */
		public static EnterScene:number=722;
		
		/** 帧同步每帧消息 */
		public static FrameSyncFrame:number=723;
		
		/** 帧同步起始消息 */
		public static FrameSyncStart:number=724;
		
		/** 添加格子数 */
		public static FuncAddItemGridNum:number=725;
		
		/** 添加物品消息 */
		public static FuncAddItem:number=726;
		
		/** 推送添加单个物品 */
		public static FuncAddOneItem:number=727;
		
		/** 添加单个物品数目消息 */
		public static FuncAddOneItemNum:number=728;
		
		/** 取消匹配消息 */
		public static FuncCancelMatch:number=729;
		
		/** 匹配结束(成功结束) */
		public static FuncMatchOver:number=730;
		
		/** 匹配成功消息 */
		public static FuncMatchSuccess:number=731;
		
		/** 匹配超时消息 */
		public static FuncMatchTimeOut:number=732;
		
		/** 重新加入匹配队列消息 */
		public static FuncReAddMatch:number=733;
		
		/** 功能-回复查询每页排行 */
		public static FuncReGetPageShow:number=734;
		
		public static FuncReGetSelfPageShow:number=735;
		
		public static FuncRefreshRank:number=736;
		
		/** 移除物品消息 */
		public static FuncRemoveItem:number=737;
		
		/** 移除单个物品 */
		public static FuncRemoveOneItem:number=738;
		
		/** 功能-重置排行消息 */
		public static FuncResetRank:number=739;
		
		/** 功能发送消息 */
		public static FuncS:number=740;
		
		/** 推送接受匹配 */
		public static FuncSendAcceptMatch:number=741;
		
		/** 推送整理物品消息 */
		public static FuncSendCleanUpItem:number=742;
		
		/** 开始匹配消息 */
		public static FuncStartMatch:number=746;
		
		/** 使用物品结果消息 */
		public static FuncUseItemResult:number=747;
		
		/** 初始化客户端消息(ClientListData)(此处需要使用copy,因工具已改为潜拷,为了逻辑层避开深拷问题) */
		public static InitClient:number=748;
		
		/** 离开场景消息 */
		public static LeaveScene:number=749;
		
		/** 升级消息 */
		public static LevelUp:number=750;
		
		/** 主角加buff */
		public static MUnitAddBuff:number=751;
		
		/** 控制单位添加组CD上限百分比 */
		public static MUnitAddGroupTimeMaxPercent:number=752;
		
		/** 控制单位添加组CD上限值 */
		public static MUnitAddGroupTimeMaxValue:number=753;
		
		/** 控制单位添加组时间经过 */
		public static MUnitAddGroupTimePass:number=754;
		
		/** 刷新主角属性 */
		public static MUnitRefreshAttributes:number=756;
		
		/** 控制单位刷新造型消息 */
		public static MUnitRefreshAvatar:number=757;
		
		/** 控制单位改变显示部件 */
		public static MUnitRefreshAvatarPart:number=758;
		
		/** 主角刷buff剩余次数 */
		public static MUnitRefreshBuffLastNum:number=759;
		
		/** 主角刷buff */
		public static MUnitRefreshBuff:number=760;
		
		/** 刷新主角状态 */
		public static MUnitRefreshStatus:number=761;
		
		/** 主角移除buff */
		public static MUnitRemoveBuff:number=762;
		
		/** 控制单位移除组CD消息 */
		public static MUnitRemoveGroupCD:number=763;
		
		/** 玩家单位开始CD组 */
		public static MUnitStartCDs:number=765;
		
		/** 预备进入场景消息 */
		public static PreEnterScene:number=766;
		
		/** 预进入场景服务器就绪 */
		public static PreEnterSceneNext:number=767;
		
		/** 单位拉回消息 */
		public static ReCUnitPullBack:number=768;
		
		/** 回复技能失败消息 */
		public static ReCUnitSkillFailedEx:number=769;
		
		/** 回复C单位技能失败 */
		public static ReCUnitSkillFailed:number=770;
		
		/** 回复角色列表消息 */
		public static RePlayerList:number=772;
		
		/** 返回搜索结果 */
		public static ReSearchPlayer:number=774;
		
		/** 回复更新社交数据消息 */
		public static ReUpdateRoleSocialData:number=775;
		
		/** 刷新单个社交数据(实时刷新用) */
		public static ReUpdateRoleSocialDataOne:number=776;
		
		/** 收到客户端离线事务消息 */
		public static ReceiveClientOfflineWork:number=777;
		
		/** 刷新货币消息 */
		public static RefreshCurrency:number=778;
		
		/** 刷新当期线ID消息 */
		public static RefreshCurrentLine:number=779;
		
		/** 刷经验消息 */
		public static RefreshExp:number=780;
		
		/** 刷新引导步消息 */
		public static RefreshMainGuideStep:number=782;
		
		/** 刷新服务器时间 */
		public static RefreshServerTime:number=784;
		
		/** 刷新目标数目消息 */
		public static RefreshTask:number=785;
		
		/** 刷新单位属性 */
		public static RefreshUnitAttributes:number=786;
		
		/** 刷新单位造型消息 */
		public static RefreshUnitAvatar:number=787;
		
		/** 刷新单位显示部件数据 */
		public static RefreshUnitAvatarPart:number=788;
		
		/** 刷新单位状态 */
		public static RefreshUnitStatus:number=789;
		
		/** 移除子弹 */
		public static RemoveBullet:number=790;
		
		/** 移除单位协议 */
		public static RemoveUnit:number=791;
		
		/** 推送场景广播消息 */
		public static SceneRadio:number=792;
		
		/** 场景推送基类 */
		public static SceneS:number=793;
		
		/** 推送接任务消息 */
		public static SendAcceptQuest:number=795;
		
		/** 推送成就完成消息 */
		public static SendAchievementComplete:number=796;
		
		/** 推送添加好友黑名单 */
		public static SendAddFriendBlackList:number=797;
		
		/** 推送添加好友消息 */
		public static SendAddFriend:number=798;
		
		/** 推送申请添加好友消息 */
		public static SendApplyAddFriend:number=799;
		
		/** 推送副本类场景状态信息 */
		public static SendBattleState:number=800;
		
		/** 推送绑定平台消息 */
		public static SendBindPlatform:number=801;
		
		/** 推送清空全部任务(gm) */
		public static SendClearAllQuestByGM:number=802;
		
		/** 推送交任务消息 */
		public static SendCommitQuest:number=803;
		
		/** 推送删除邮件消息 */
		public static SendDeleteMail:number=804;
		
		/** 推送领取成就奖励成功消息 */
		public static SendGetAchievementRewardSuccess:number=806;
		
		/** 推送任务放弃消息 */
		public static SendGiveUpQuest:number=807;
		
		/** 推送信息码消息 */
		public static SendInfoCode:number=808;
		
		/** 推送带参信息码消息 */
		public static SendInfoCodeWithArgs:number=809;
		
		/** 推送任务失败消息 */
		public static SendQuestFailed:number=810;
		
		/** 推送移除好友黑名单 */
		public static SendRemoveFriendBlackList:number=812;
		
		/** 推送移除好友 */
		public static SendRemoveFriend:number=813;
		
		/** 切换game服消息 */
		public static SwitchGame:number=814;
		
		/** 添加buff消息 */
		public static UnitAddBuff:number=816;
		
		/** 单位添加组CD百分比 */
		public static UnitAddGroupTimeMaxPercent:number=817;
		
		/** 单位添加组CD固定值 */
		public static UnitAddGroupTimeMaxValue:number=818;
		
		/** 单位添加组CD时间经过 */
		public static UnitAddGroupTimePass:number=819;
		
		/** 单位聊天消息 */
		public static UnitChat:number=820;
		
		/** 单位死亡消息 */
		public static UnitDead:number=821;
		
		/** 单位移动朝向消息 */
		public static UnitMoveDir:number=822;
		
		/** 单位移动点组消息 */
		public static UnitMovePosList:number=823;
		
		/** 单位移动位置 */
		public static UnitMovePos:number=824;
		
		/** 单位确认选择 */
		public static UnitPreBattleSure:number=825;
		
		/** 单位刷新buff剩余次数消息 */
		public static UnitRefreshBuffLastNum:number=826;
		
		/** 单位刷新buff */
		public static UnitRefreshBuff:number=827;
		
		/** 单位移除buff */
		public static UnitRemoveBuff:number=828;
		
		/** 单位移除组CD */
		public static UnitRemoveGroupCD:number=829;
		
		/** 单位复活消息 */
		public static UnitRevive:number=830;
		
		/** 单位释放技能结束(强制结束) */
		public static UnitSkillOver:number=832;
		
		/** 单位特殊移动消息 */
		public static UnitSpecialMove:number=833;
		
		/** 单位开始CD组 */
		public static UnitStartCDs:number=834;
		
		/** 单位停止移动(reIdle) */
		public static UnitStopMove:number=835;
		
		/** 单位同步指令消息 */
		public static UnitSyncCommand:number=836;
		
		/** 单位使用技能 */
		public static UnitUseSkill:number=837;
		
		/** 刷新角色战斗力消息 */
		public static RefreshFightForce:number=781;
		
		/** 回复查询角色消息 */
		public static ReQueryPlayer:number=773;
		
		/** 回复获取全部邮件消息 */
		public static ReGetAllMail:number=771;
		
		/** 领取邮件成功 */
		public static TakeMailSuccess:number=815;
		
		/** AOI灯塔刷新消息(删除一组+添加一组) */
		public static AOITowerRefresh:number=700;
		
		/** 推送添加成就消息 */
		public static SendAcceptAchievement:number=794;
		
		/** 推送Game服息回执 */
		public static SendGameReceiptToClient:number=805;
		
		/** 移动装备消息 */
		public static FuncSendMoveEquip:number=743;
		
		/** 脱装备 */
		public static FuncSendPutOffEquip:number=744;
		
		/** 穿装备 */
		public static FuncSendPutOnEquip:number=745;
		
		/** 活动开启/关闭消息 */
		public static ActivitySwitch:number=703;
		
		/** 推送强制删除已接任务消息 */
		public static SendRemoveAcceptQuest:number=811;
		
		/** 建筑升级成功 */
		public static BuildingBuildComplete:number=709;
		
		/** 建筑取消升级 */
		public static BuildingCancelLevelUp:number=710;
		
		/** 建筑升级成功 */
		public static BuildingLevelUpingComplete:number=711;
		
		/** 建筑开始升级 */
		public static BuildingStartLevelUp:number=712;
		
		public static UnitS:number=831;
		
		/** 主角加技能消息 */
		public static MUnitAddSkill:number=755;
		
		/** 主角删技能消息 */
		public static MUnitRemoveSkill:number=764;
		
		/** 更新操作体状态消息 */
		public static RefreshOperationState:number=783;
		
		/** 玩家群消息基类 */
		public static FuncPlayerRoleGroupS:number=842;
		
		/** 更新成员职位 */
		public static FuncRefeshTitleRoleGroup:number=848;
		
		/** 添加申请消息 */
		public static FuncSendAddApplyRoleGroup:number=843;
		
		/** 添加申请玩家群到自身消息 */
		public static FuncSendAddApplyRoleGroupSelf:number=853;
		
		/** 推送更换队长消息 */
		public static FuncSendChangeLeaderRoleGroup:number=849;
		
		/** 推送处理申请结果玩家群 */
		public static FuncSendHandleApplyResultRoleGroup:number=844;
		
		/** 群里有权限成员通知处理申请结果 */
		public static FuncSendHandleApplyResultToMember:number=852;
		
		/** 推送处理邀请结果到邀请者 */
		public static FuncSendHandleInviteResultRoleGroup:number=845;
		
		/** 推送邀请加入玩家群消息 */
		public static FuncSendInviteRoleGroup:number=846;
		
		/** 推送添加玩家群消息 */
		public static FuncSendPlayerJoinRoleGroup:number=838;
		
		/** 推送玩家离开玩家群消息 */
		public static FuncSendPlayerLeaveRoleGroup:number=839;
		
		/** 推送添加成员消息 */
		public static FuncSendRoleGroupAddMember:number=840;
		
		/** 推送玩家群变更数据 */
		public static FuncSendRoleGroupChange:number=854;
		
		/** 推送玩家群移除成员 */
		public static FuncSendRoleGroupRemoveMember:number=841;
		
		/** 逻辑服转发消息 */
		public static GameTransGameToClient:number=851;
		
		/** 推送信息日志消息 */
		public static SendInfoLog:number=855;
		
		/** 客户端热更配置消息 */
		public static ClientHotfixConfig:number=858;
		
		/** 发送被邀请时是否可直接入群的变化 */
		public static FuncSendChangeCanInviteInAbsRoleGroup:number=857;
		
		/** 玩家群信息日志消息 */
		public static FuncSendRoleGroupInfoLog:number=859;
		
		/** 回复获取玩家群数据消息 */
		public static FuncReGetRoleGroupData:number=861;
		
		/** 玩家群成员数据改变消息 */
		public static FuncSendRoleGroupMemberChange:number=860;
		
		/** 单位直接更改位置朝向消息 */
		public static UnitSetPosDir:number=862;
		
		/** 添加掉落物品包绑定消息 */
		public static AddFieldItemBagBind:number=863;
		
		public static RemoveFieldItemBagBind:number=864;
		
		/** 添加绑定视野单位 */
		public static AddBindVisionUnit:number=870;
		
		public static FuncSendRoleGroupMemberRoleShowChange:number=869;
		
		/** 刷新简版单位属性消息 */
		public static RefreshSimpleUnitAttribute:number=872;
		
		/** 刷新简版单位位置消息 */
		public static RefreshSimpleUnitPos:number=873;
		
		public static RemoveBindVisionUnit:number=871;
		
		/** 角色刷新属性 */
		public static RoleRefreshAttribute:number=865;
		
		/** 角色推送消息 */
		public static RoleS:number=866;
		
		/** 推送角色聊天 */
		public static SendPlayerChat:number=867;
		
	}
}
