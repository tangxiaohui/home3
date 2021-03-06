namespace Shine
{
	/** (generated by shine) */
	export class BaseDataMaker extends DataMaker
	{
		constructor()
		{
			super();
			this.offSet=BaseDataType.off;
			this.list=new Array<Function>(BaseDataType.count-this.offSet);
			this.list[BaseDataType.AchievementComplete-this.offSet]=this.createAchievementCompleteData;
			this.list[BaseDataType.Achievement-this.offSet]=this.createAchievementData;
			this.list[BaseDataType.AchievementSave-this.offSet]=this.createAchievementSaveData;
			this.list[BaseDataType.Activity-this.offSet]=this.createActivityData;
			this.list[BaseDataType.ActivityServer-this.offSet]=this.createActivityServerData;
			this.list[BaseDataType.AddBeFriendOW-this.offSet]=this.createAddBeFriendOWData;
			this.list[BaseDataType.AddFriendFailedForOvonicAW-this.offSet]=this.createAddFriendFailedForOvonicAWData;
			this.list[BaseDataType.AddFriendForOvonicAW-this.offSet]=this.createAddFriendForOvonicAWData;
			this.list[BaseDataType.AddMailOW-this.offSet]=this.createAddMailOWData;
			this.list[BaseDataType.ApplyAddFriend-this.offSet]=this.createApplyAddFriendData;
			this.list[BaseDataType.ApplyAddFriendOW-this.offSet]=this.createApplyAddFriendOWData;
			this.list[BaseDataType.AreaClient-this.offSet]=this.createAreaClientData;
			this.list[BaseDataType.BattleSceneEnter-this.offSet]=this.createBattleSceneEnterData;
			this.list[BaseDataType.Buff-this.offSet]=this.createBuffData;
			this.list[BaseDataType.Bullet-this.offSet]=this.createBulletData;
			this.list[BaseDataType.CD-this.offSet]=this.createCDData;
			this.list[BaseDataType.CharacterIdentity-this.offSet]=this.createCharacterIdentityData;
			this.list[BaseDataType.CharacterSave-this.offSet]=this.createCharacterSaveData;
			this.list[BaseDataType.CharacterUse-this.offSet]=this.createCharacterUseData;
			this.list[BaseDataType.Chat-this.offSet]=this.createChatData;
			this.list[BaseDataType.ChatElement-this.offSet]=this.createChatElementData;
			this.list[BaseDataType.ClientLoginCache-this.offSet]=this.createClientLoginCacheData;
			this.list[BaseDataType.ClientLogin-this.offSet]=this.createClientLoginData;
			this.list[BaseDataType.ClientLoginEx-this.offSet]=this.createClientLoginExData;
			this.list[BaseDataType.ClientOfflineWork-this.offSet]=this.createClientOfflineWorkData;
			this.list[BaseDataType.ClientOfflineWorkList-this.offSet]=this.createClientOfflineWorkListData;
			this.list[BaseDataType.ClientPlayerLocalCache-this.offSet]=this.createClientPlayerLocalCacheData;
			this.list[BaseDataType.ClientVersion-this.offSet]=this.createClientVersionData;
			this.list[BaseDataType.Contact-this.offSet]=this.createContactData;
			this.list[BaseDataType.CreatePlayer-this.offSet]=this.createCreatePlayerData;
			this.list[BaseDataType.DamageOne-this.offSet]=this.createDamageOneData;
			this.list[BaseDataType.Dir-this.offSet]=this.createDirData;
			this.list[BaseDataType.FrameSyncCommand-this.offSet]=this.createFrameSyncCommandData;
			this.list[BaseDataType.FrameSync-this.offSet]=this.createFrameSyncData;
			this.list[BaseDataType.Friend-this.offSet]=this.createFriendData;
			this.list[BaseDataType.FuncTool-this.offSet]=this.createFuncToolData;
			this.list[BaseDataType.GMAddCurrencyOW-this.offSet]=this.createGMAddCurrencyOWData;
			this.list[BaseDataType.GameGlobalWork-this.offSet]=this.createGameGlobalWorkData;
			this.list[BaseDataType.GameLogin-this.offSet]=this.createGameLoginData;
			this.list[BaseDataType.GameServerClientSimple-this.offSet]=this.createGameServerClientSimpleData;
			this.list[BaseDataType.GameServerInfo-this.offSet]=this.createGameServerInfoData;
			this.list[BaseDataType.GameServerRun-this.offSet]=this.createGameServerRunData;
			this.list[BaseDataType.GameServerSimpleInfo-this.offSet]=this.createGameServerSimpleInfoData;
			this.list[BaseDataType.IntQueryResult-this.offSet]=this.createIntQueryResultData;
			this.list[BaseDataType.ItemContainer-this.offSet]=this.createItemContainerData;
			this.list[BaseDataType.Item-this.offSet]=this.createItemData;
			this.list[BaseDataType.ItemEquip-this.offSet]=this.createItemEquipData;
			this.list[BaseDataType.ItemIdentity-this.offSet]=this.createItemIdentityData;
			this.list[BaseDataType.KeepSave-this.offSet]=this.createKeepSaveData;
			this.list[BaseDataType.Key-this.offSet]=this.createKeyData;
			this.list[BaseDataType.MUnitCache-this.offSet]=this.createMUnitCacheData;
			this.list[BaseDataType.MUnitUse-this.offSet]=this.createMUnitUseData;
			this.list[BaseDataType.Mail-this.offSet]=this.createMailData;
			this.list[BaseDataType.MonsterIdentity-this.offSet]=this.createMonsterIdentityData;
			this.list[BaseDataType.NPCIdentity-this.offSet]=this.createNPCIdentityData;
			this.list[BaseDataType.ParterIdentity-this.offSet]=this.createParterIdentityData;
			this.list[BaseDataType.PetUse-this.offSet]=this.createPetUseData;
			this.list[BaseDataType.PlayerLogin-this.offSet]=this.createPlayerLoginData;
			this.list[BaseDataType.PlayerMail-this.offSet]=this.createPlayerMailData;
			this.list[BaseDataType.PlayerMatch-this.offSet]=this.createPlayerMatchData;
			this.list[BaseDataType.PlayerOfflineCacheEx-this.offSet]=this.createPlayerOfflineCacheExData;
			this.list[BaseDataType.PlayerPrimaryKey-this.offSet]=this.createPlayerPrimaryKeyData;
			this.list[BaseDataType.PlayerRank-this.offSet]=this.createPlayerRankData;
			this.list[BaseDataType.PlayerRankTool-this.offSet]=this.createPlayerRankToolData;
			this.list[BaseDataType.PlayerSwitchGame-this.offSet]=this.createPlayerSwitchGameData;
			this.list[BaseDataType.PlayerWork-this.offSet]=this.createPlayerWorkData;
			this.list[BaseDataType.PlayerWorkList-this.offSet]=this.createPlayerWorkListData;
			this.list[BaseDataType.Pos-this.offSet]=this.createPosData;
			this.list[BaseDataType.PosDir-this.offSet]=this.createPosDirData;
			this.list[BaseDataType.PuppetIdentity-this.offSet]=this.createPuppetIdentityData;
			this.list[BaseDataType.QueryPlayerLevelW-this.offSet]=this.createQueryPlayerLevelWData;
			this.list[BaseDataType.QuestComplete-this.offSet]=this.createQuestCompleteData;
			this.list[BaseDataType.Quest-this.offSet]=this.createQuestData;
			this.list[BaseDataType.Rank-this.offSet]=this.createRankData;
			this.list[BaseDataType.RankSimple-this.offSet]=this.createRankSimpleData;
			this.list[BaseDataType.RankTool-this.offSet]=this.createRankToolData;
			this.list[BaseDataType.ReGetRoleSocialDataW-this.offSet]=this.createReGetRoleSocialDataWData;
			this.list[BaseDataType.RefreshPartRoleShowDataW-this.offSet]=this.createRefreshPartRoleShowDataWData;
			this.list[BaseDataType.RemoveBeFriendOW-this.offSet]=this.createRemoveBeFriendOWData;
			this.list[BaseDataType.RemoveFriendOW-this.offSet]=this.createRemoveFriendOWData;
			this.list[BaseDataType.RoleShowChange-this.offSet]=this.createRoleShowChangeData;
			this.list[BaseDataType.RoleShow-this.offSet]=this.createRoleShowData;
			this.list[BaseDataType.RoleSocial-this.offSet]=this.createRoleSocialData;
			this.list[BaseDataType.SaveVersion-this.offSet]=this.createSaveVersionData;
			this.list[BaseDataType.SceneEffectIdentity-this.offSet]=this.createSceneEffectIdentityData;
			this.list[BaseDataType.SceneEnterArg-this.offSet]=this.createSceneEnterArgData;
			this.list[BaseDataType.SceneEnter-this.offSet]=this.createSceneEnterData;
			this.list[BaseDataType.ScenePreInfo-this.offSet]=this.createScenePreInfoData;
			this.list[BaseDataType.ServerInfo-this.offSet]=this.createServerInfoData;
			this.list[BaseDataType.ServerSimpleInfo-this.offSet]=this.createServerSimpleInfoData;
			this.list[BaseDataType.Skill-this.offSet]=this.createSkillData;
			this.list[BaseDataType.SkillTarget-this.offSet]=this.createSkillTargetData;
			this.list[BaseDataType.Task-this.offSet]=this.createTaskData;
			this.list[BaseDataType.Test2-this.offSet]=this.createTest2Data;
			this.list[BaseDataType.Test-this.offSet]=this.createTestData;
			this.list[BaseDataType.UnitAI-this.offSet]=this.createUnitAIData;
			this.list[BaseDataType.UnitAvatar-this.offSet]=this.createUnitAvatarData;
			this.list[BaseDataType.Unit-this.offSet]=this.createUnitData;
			this.list[BaseDataType.UnitFight-this.offSet]=this.createUnitFightData;
			this.list[BaseDataType.UnitFightEx-this.offSet]=this.createUnitFightExData;
			this.list[BaseDataType.UnitIdentity-this.offSet]=this.createUnitIdentityData;
			this.list[BaseDataType.UnitInfo-this.offSet]=this.createUnitInfoData;
			this.list[BaseDataType.UnitPos-this.offSet]=this.createUnitPosData;
			this.list[BaseDataType.UseItemArg-this.offSet]=this.createUseItemArgData;
			this.list[BaseDataType.VehicleIdentity-this.offSet]=this.createVehicleIdentityData;
			this.list[BaseDataType.Work-this.offSet]=this.createWorkData;
			this.list[BaseDataType.WorkReceiver-this.offSet]=this.createWorkReceiverData;
			this.list[BaseDataType.WorkSender-this.offSet]=this.createWorkSenderData;
			this.list[BaseDataType.ItemDicContainer-this.offSet]=this.createItemDicContainerData;
			this.list[BaseDataType.RoleSocialPool-this.offSet]=this.createRoleSocialPoolData;
			this.list[BaseDataType.RoleSocialPoolTool-this.offSet]=this.createRoleSocialPoolToolData;
			this.list[BaseDataType.QueryPlayerAW-this.offSet]=this.createQueryPlayerAWData;
			this.list[BaseDataType.QueryPlayerResult-this.offSet]=this.createQueryPlayerResultData;
			this.list[BaseDataType.ReQueryPlayerOW-this.offSet]=this.createReQueryPlayerOWData;
			this.list[BaseDataType.BigFloat-this.offSet]=this.createBigFloatData;
			this.list[BaseDataType.OperationIdentity-this.offSet]=this.createOperationIdentityData;
			this.list[BaseDataType.FieldItemIdentity-this.offSet]=this.createFieldItemIdentityData;
			this.list[BaseDataType.FightUnitIdentity-this.offSet]=this.createFightUnitIdentityData;
			this.list[BaseDataType.EquipContainer-this.offSet]=this.createEquipContainerData;
			this.list[BaseDataType.MUnitSave-this.offSet]=this.createMUnitSaveData;
			this.list[BaseDataType.PetSave-this.offSet]=this.createPetSaveData;
			this.list[BaseDataType.RoleAttribute-this.offSet]=this.createRoleAttributeData;
			this.list[BaseDataType.SceneRole-this.offSet]=this.createSceneRoleData;
			this.list[BaseDataType.BuildingIdentity-this.offSet]=this.createBuildingIdentityData;
			this.list[BaseDataType.RoleForce-this.offSet]=this.createRoleForceData;
			this.list[BaseDataType.ClientLoginServerInfo-this.offSet]=this.createClientLoginServerInfoData;
			this.list[BaseDataType.PlayerRoleGroupTool-this.offSet]=this.createPlayerRoleGroupToolData;
			this.list[BaseDataType.RoleGroup-this.offSet]=this.createRoleGroupData;
			this.list[BaseDataType.RoleGroupMember-this.offSet]=this.createRoleGroupMemberData;
			this.list[BaseDataType.RoleGroupTool-this.offSet]=this.createRoleGroupToolData;
			this.list[BaseDataType.ClientLoginResult-this.offSet]=this.createClientLoginResultData;
			this.list[BaseDataType.AreaServer-this.offSet]=this.createAreaServerData;
			this.list[BaseDataType.PlayerBindPlatformAW-this.offSet]=this.createPlayerBindPlatformAWData;
			this.list[BaseDataType.PlayerLoginToEachGame-this.offSet]=this.createPlayerLoginToEachGameData;
			this.list[BaseDataType.RePlayerLoginFromEachGame-this.offSet]=this.createRePlayerLoginFromEachGameData;
			this.list[BaseDataType.PlayerWorkComplete-this.offSet]=this.createPlayerWorkCompleteData;
			this.list[BaseDataType.WorkComplete-this.offSet]=this.createWorkCompleteData;
			this.list[BaseDataType.AreaGlobalWork-this.offSet]=this.createAreaGlobalWorkData;
			this.list[BaseDataType.AreaGlobalWorkComplete-this.offSet]=this.createAreaGlobalWorkCompleteData;
			this.list[BaseDataType.CreateRoleGroup-this.offSet]=this.createCreateRoleGroupData;
			this.list[BaseDataType.PlayerRoleGroupSave-this.offSet]=this.createPlayerRoleGroupSaveData;
			this.list[BaseDataType.PlayerRoleGroup-this.offSet]=this.createPlayerRoleGroupData;
			this.list[BaseDataType.PlayerApplyRoleGroup-this.offSet]=this.createPlayerApplyRoleGroupData;
			this.list[BaseDataType.RoleGroupSimple-this.offSet]=this.createRoleGroupSimpleData;
			this.list[BaseDataType.CreateRoleGroupResultOW-this.offSet]=this.createCreateRoleGroupResultOWData;
			this.list[BaseDataType.CreateRoleGroupW-this.offSet]=this.createCreateRoleGroupWData;
			this.list[BaseDataType.InviteRoleGroupW-this.offSet]=this.createInviteRoleGroupWData;
			this.list[BaseDataType.PlayerFuncWork-this.offSet]=this.createPlayerFuncWorkData;
			this.list[BaseDataType.PlayerApplyRoleGroupSelf-this.offSet]=this.createPlayerApplyRoleGroupSelfData;
			this.list[BaseDataType.AddApplyRoleGroupSelfW-this.offSet]=this.createAddApplyRoleGroupSelfWData;
			this.list[BaseDataType.HandleApplyRoleGroupW-this.offSet]=this.createHandleApplyRoleGroupWData;
			this.list[BaseDataType.RoleGroupChange-this.offSet]=this.createRoleGroupChangeData;
			this.list[BaseDataType.PlayerRoleGroupClientTool-this.offSet]=this.createPlayerRoleGroupClientToolData;
			this.list[BaseDataType.PlayerUnion-this.offSet]=this.createPlayerUnionData;
			this.list[BaseDataType.Union-this.offSet]=this.createUnionData;
			this.list[BaseDataType.UnionMember-this.offSet]=this.createUnionMemberData;
			this.list[BaseDataType.CreateUnion-this.offSet]=this.createCreateUnionData;
			this.list[BaseDataType.UnionSimple-this.offSet]=this.createUnionSimpleData;
			this.list[BaseDataType.PlayerUnionSave-this.offSet]=this.createPlayerUnionSaveData;
			this.list[BaseDataType.JoinRoleGroupW-this.offSet]=this.createJoinRoleGroupWData;
			this.list[BaseDataType.LeaveRoleGroupW-this.offSet]=this.createLeaveRoleGroupWData;
			this.list[BaseDataType.UseActivationCodeSuccessOW-this.offSet]=this.createUseActivationCodeSuccessOWData;
			this.list[BaseDataType.Team-this.offSet]=this.createTeamData;
			this.list[BaseDataType.CreateTeam-this.offSet]=this.createCreateTeamData;
			this.list[BaseDataType.PlayerTeam-this.offSet]=this.createPlayerTeamData;
			this.list[BaseDataType.TeamMember-this.offSet]=this.createTeamMemberData;
			this.list[BaseDataType.TeamSimple-this.offSet]=this.createTeamSimpleData;
			this.list[BaseDataType.PlayerCreatedW-this.offSet]=this.createPlayerCreatedWData;
			this.list[BaseDataType.UserWork-this.offSet]=this.createUserWorkData;
			this.list[BaseDataType.PlayerDeletedW-this.offSet]=this.createPlayerDeletedWData;
			this.list[BaseDataType.InfoLog-this.offSet]=this.createInfoLogData;
			this.list[BaseDataType.RoleShowLog-this.offSet]=this.createRoleShowLogData;
			this.list[BaseDataType.InfoLogW-this.offSet]=this.createInfoLogWData;
			this.list[BaseDataType.GameInitServer-this.offSet]=this.createGameInitServerData;
			this.list[BaseDataType.LoginInitServer-this.offSet]=this.createLoginInitServerData;
			this.list[BaseDataType.GameLoginToCenter-this.offSet]=this.createGameLoginToCenterData;
			this.list[BaseDataType.GameLoginToGame-this.offSet]=this.createGameLoginToGameData;
			this.list[BaseDataType.PlayerToPlayerTCCW-this.offSet]=this.createPlayerToPlayerTCCWData;
			this.list[BaseDataType.PlayerToRoleGroupTCCW-this.offSet]=this.createPlayerToRoleGroupTCCWData;
			this.list[BaseDataType.RoleGroupWork-this.offSet]=this.createRoleGroupWorkData;
			this.list[BaseDataType.PlayerToRoleGroupTCCResultW-this.offSet]=this.createPlayerToRoleGroupTCCResultWData;
			this.list[BaseDataType.PlayerToPlayerTCCResultW-this.offSet]=this.createPlayerToPlayerTCCResultWData;
			this.list[BaseDataType.RoleShowInfoLog-this.offSet]=this.createRoleShowInfoLogData;
			this.list[BaseDataType.CreateScene-this.offSet]=this.createCreateSceneData;
			this.list[BaseDataType.RoleGroupCreateScene-this.offSet]=this.createRoleGroupCreateSceneData;
			this.list[BaseDataType.PlayerRoleGroupMember-this.offSet]=this.createPlayerRoleGroupMemberData;
			this.list[BaseDataType.RoleGroupMemberChange-this.offSet]=this.createRoleGroupMemberChangeData;
			this.list[BaseDataType.PlayerRoleGroupEx-this.offSet]=this.createPlayerRoleGroupExData;
			this.list[BaseDataType.UnitFunc-this.offSet]=this.createUnitFuncData;
			this.list[BaseDataType.UnitMove-this.offSet]=this.createUnitMoveData;
			this.list[BaseDataType.FieldItemBagIdentity-this.offSet]=this.createFieldItemBagIdentityData;
			this.list[BaseDataType.UnitNormal-this.offSet]=this.createUnitNormalData;
			this.list[BaseDataType.FieldItemBagBind-this.offSet]=this.createFieldItemBagBindData;
			this.list[BaseDataType.Rect-this.offSet]=this.createRectData;
			this.list[BaseDataType.ItemChatElement-this.offSet]=this.createItemChatElementData;
			this.list[BaseDataType.ChatChannel-this.offSet]=this.createChatChannelData;
			this.list[BaseDataType.RoleChat-this.offSet]=this.createRoleChatData;
			this.list[BaseDataType.RoleSimpleShow-this.offSet]=this.createRoleSimpleShowData;
			this.list[BaseDataType.SendPlayerChatOW-this.offSet]=this.createSendPlayerChatOWData;
			this.list[BaseDataType.SceneLocation-this.offSet]=this.createSceneLocationData;
			this.list[BaseDataType.SceneLocationRoleShowChange-this.offSet]=this.createSceneLocationRoleShowChangeData;
			this.list[BaseDataType.Region-this.offSet]=this.createRegionData;
			this.list[BaseDataType.UnitSimple-this.offSet]=this.createUnitSimpleData;
		}
		
		private createRoleShowData():BaseData
		{
			return new RoleShowData();
		}
		
		private createPetUseData():BaseData
		{
			return new PetUseData();
		}
		
		private createMUnitUseData():BaseData
		{
			return new MUnitUseData();
		}
		
		private createCharacterSaveData():BaseData
		{
			return new CharacterSaveData();
		}
		
		private createMUnitCacheData():BaseData
		{
			return new MUnitCacheData();
		}
		
		private createRoleShowChangeData():BaseData
		{
			return new RoleShowChangeData();
		}
		
		private createCharacterUseData():BaseData
		{
			return new CharacterUseData();
		}
		
		private createTest2Data():BaseData
		{
			return new Test2Data();
		}
		
		private createTestData():BaseData
		{
			return new TestData();
		}
		
		private createActivityServerData():BaseData
		{
			return new ActivityServerData();
		}
		
		private createActivityData():BaseData
		{
			return new ActivityData();
		}
		
		private createMailData():BaseData
		{
			return new MailData();
		}
		
		private createAddMailOWData():BaseData
		{
			return new AddMailOWData();
		}
		
		private createFriendData():BaseData
		{
			return new FriendData();
		}
		
		private createApplyAddFriendOWData():BaseData
		{
			return new ApplyAddFriendOWData();
		}
		
		private createAddFriendFailedForOvonicAWData():BaseData
		{
			return new AddFriendFailedForOvonicAWData();
		}
		
		private createAddBeFriendOWData():BaseData
		{
			return new AddBeFriendOWData();
		}
		
		private createAddFriendForOvonicAWData():BaseData
		{
			return new AddFriendForOvonicAWData();
		}
		
		private createApplyAddFriendData():BaseData
		{
			return new ApplyAddFriendData();
		}
		
		private createRemoveFriendOWData():BaseData
		{
			return new RemoveFriendOWData();
		}
		
		private createContactData():BaseData
		{
			return new ContactData();
		}
		
		private createRemoveBeFriendOWData():BaseData
		{
			return new RemoveBeFriendOWData();
		}
		
		private createChatData():BaseData
		{
			return new ChatData();
		}
		
		private createChatElementData():BaseData
		{
			return new ChatElementData();
		}
		
		private createRoleSocialData():BaseData
		{
			return new RoleSocialData();
		}
		
		private createRefreshPartRoleShowDataWData():BaseData
		{
			return new RefreshPartRoleShowDataWData();
		}
		
		private createReGetRoleSocialDataWData():BaseData
		{
			return new ReGetRoleSocialDataWData();
		}
		
		private createPlayerRankToolData():BaseData
		{
			return new PlayerRankToolData();
		}
		
		private createRankToolData():BaseData
		{
			return new RankToolData();
		}
		
		private createRankData():BaseData
		{
			return new RankData();
		}
		
		private createRankSimpleData():BaseData
		{
			return new RankSimpleData();
		}
		
		private createPlayerRankData():BaseData
		{
			return new PlayerRankData();
		}
		
		private createWorkSenderData():BaseData
		{
			return new WorkSenderData();
		}
		
		private createKeepSaveData():BaseData
		{
			return new KeepSaveData();
		}
		
		private createGameServerRunData():BaseData
		{
			return new GameServerRunData();
		}
		
		private createGameGlobalWorkData():BaseData
		{
			return new GameGlobalWorkData();
		}
		
		private createSaveVersionData():BaseData
		{
			return new SaveVersionData();
		}
		
		private createPlayerWorkListData():BaseData
		{
			return new PlayerWorkListData();
		}
		
		private createAreaClientData():BaseData
		{
			return new AreaClientData();
		}
		
		private createWorkData():BaseData
		{
			return new WorkData();
		}
		
		private createServerInfoData():BaseData
		{
			return new ServerInfoData();
		}
		
		private createGameServerInfoData():BaseData
		{
			return new GameServerInfoData();
		}
		
		private createGameServerSimpleInfoData():BaseData
		{
			return new GameServerSimpleInfoData();
		}
		
		private createClientOfflineWorkData():BaseData
		{
			return new ClientOfflineWorkData();
		}
		
		private createKeyData():BaseData
		{
			return new KeyData();
		}
		
		private createClientPlayerLocalCacheData():BaseData
		{
			return new ClientPlayerLocalCacheData();
		}
		
		private createGameServerClientSimpleData():BaseData
		{
			return new GameServerClientSimpleData();
		}
		
		private createWorkReceiverData():BaseData
		{
			return new WorkReceiverData();
		}
		
		private createClientOfflineWorkListData():BaseData
		{
			return new ClientOfflineWorkListData();
		}
		
		private createPlayerPrimaryKeyData():BaseData
		{
			return new PlayerPrimaryKeyData();
		}
		
		private createServerSimpleInfoData():BaseData
		{
			return new ServerSimpleInfoData();
		}
		
		private createPlayerWorkData():BaseData
		{
			return new PlayerWorkData();
		}
		
		private createItemEquipData():BaseData
		{
			return new ItemEquipData();
		}
		
		private createUseItemArgData():BaseData
		{
			return new UseItemArgData();
		}
		
		private createItemIdentityData():BaseData
		{
			return new ItemIdentityData();
		}
		
		private createItemData():BaseData
		{
			return new ItemData();
		}
		
		private createItemContainerData():BaseData
		{
			return new ItemContainerData();
		}
		
		private createPlayerMailData():BaseData
		{
			return new PlayerMailData();
		}
		
		private createQuestCompleteData():BaseData
		{
			return new QuestCompleteData();
		}
		
		private createTaskData():BaseData
		{
			return new TaskData();
		}
		
		private createQuestData():BaseData
		{
			return new QuestData();
		}
		
		private createAchievementSaveData():BaseData
		{
			return new AchievementSaveData();
		}
		
		private createAchievementCompleteData():BaseData
		{
			return new AchievementCompleteData();
		}
		
		private createAchievementData():BaseData
		{
			return new AchievementData();
		}
		
		private createDamageOneData():BaseData
		{
			return new DamageOneData();
		}
		
		private createFrameSyncData():BaseData
		{
			return new FrameSyncData();
		}
		
		private createSkillTargetData():BaseData
		{
			return new SkillTargetData();
		}
		
		private createFrameSyncCommandData():BaseData
		{
			return new FrameSyncCommandData();
		}
		
		private createPuppetIdentityData():BaseData
		{
			return new PuppetIdentityData();
		}
		
		private createSceneEffectIdentityData():BaseData
		{
			return new SceneEffectIdentityData();
		}
		
		private createCharacterIdentityData():BaseData
		{
			return new CharacterIdentityData();
		}
		
		private createMonsterIdentityData():BaseData
		{
			return new MonsterIdentityData();
		}
		
		private createNPCIdentityData():BaseData
		{
			return new NPCIdentityData();
		}
		
		private createVehicleIdentityData():BaseData
		{
			return new VehicleIdentityData();
		}
		
		private createParterIdentityData():BaseData
		{
			return new ParterIdentityData();
		}
		
		private createUnitIdentityData():BaseData
		{
			return new UnitIdentityData();
		}
		
		private createUnitPosData():BaseData
		{
			return new UnitPosData();
		}
		
		private createUnitFightExData():BaseData
		{
			return new UnitFightExData();
		}
		
		private createUnitFightData():BaseData
		{
			return new UnitFightData();
		}
		
		private createUnitInfoData():BaseData
		{
			return new UnitInfoData();
		}
		
		private createUnitData():BaseData
		{
			return new UnitData();
		}
		
		private createUnitAvatarData():BaseData
		{
			return new UnitAvatarData();
		}
		
		private createUnitAIData():BaseData
		{
			return new UnitAIData();
		}
		
		private createPlayerMatchData():BaseData
		{
			return new PlayerMatchData();
		}
		
		private createSceneEnterData():BaseData
		{
			return new SceneEnterData();
		}
		
		private createScenePreInfoData():BaseData
		{
			return new ScenePreInfoData();
		}
		
		private createBattleSceneEnterData():BaseData
		{
			return new BattleSceneEnterData();
		}
		
		private createSceneEnterArgData():BaseData
		{
			return new SceneEnterArgData();
		}
		
		private createBuffData():BaseData
		{
			return new BuffData();
		}
		
		private createCDData():BaseData
		{
			return new CDData();
		}
		
		private createDirData():BaseData
		{
			return new DirData();
		}
		
		private createPosData():BaseData
		{
			return new PosData();
		}
		
		private createBulletData():BaseData
		{
			return new BulletData();
		}
		
		private createPosDirData():BaseData
		{
			return new PosDirData();
		}
		
		private createSkillData():BaseData
		{
			return new SkillData();
		}
		
		private createClientLoginExData():BaseData
		{
			return new ClientLoginExData();
		}
		
		private createClientLoginData():BaseData
		{
			return new ClientLoginData();
		}
		
		private createCreatePlayerData():BaseData
		{
			return new CreatePlayerData();
		}
		
		private createPlayerSwitchGameData():BaseData
		{
			return new PlayerSwitchGameData();
		}
		
		private createClientLoginCacheData():BaseData
		{
			return new ClientLoginCacheData();
		}
		
		private createGameLoginData():BaseData
		{
			return new GameLoginData();
		}
		
		private createPlayerLoginData():BaseData
		{
			return new PlayerLoginData();
		}
		
		private createPlayerOfflineCacheExData():BaseData
		{
			return new PlayerOfflineCacheExData();
		}
		
		private createClientVersionData():BaseData
		{
			return new ClientVersionData();
		}
		
		private createFuncToolData():BaseData
		{
			return new FuncToolData();
		}
		
		private createQueryPlayerLevelWData():BaseData
		{
			return new QueryPlayerLevelWData();
		}
		
		private createGMAddCurrencyOWData():BaseData
		{
			return new GMAddCurrencyOWData();
		}
		
		private createIntQueryResultData():BaseData
		{
			return new IntQueryResultData();
		}
		
		private createItemDicContainerData():BaseData
		{
			return new ItemDicContainerData();
		}
		
		private createRoleSocialPoolData():BaseData
		{
			return new RoleSocialPoolData();
		}
		
		private createRoleSocialPoolToolData():BaseData
		{
			return new RoleSocialPoolToolData();
		}
		
		private createQueryPlayerAWData():BaseData
		{
			return new QueryPlayerAWData();
		}
		
		private createQueryPlayerResultData():BaseData
		{
			return new QueryPlayerResultData();
		}
		
		private createReQueryPlayerOWData():BaseData
		{
			return new ReQueryPlayerOWData();
		}
		
		private createBigFloatData():BaseData
		{
			return new BigFloatData();
		}
		
		private createOperationIdentityData():BaseData
		{
			return new OperationIdentityData();
		}
		
		private createFieldItemIdentityData():BaseData
		{
			return new FieldItemIdentityData();
		}
		
		private createFightUnitIdentityData():BaseData
		{
			return new FightUnitIdentityData();
		}
		
		private createEquipContainerData():BaseData
		{
			return new EquipContainerData();
		}
		
		private createMUnitSaveData():BaseData
		{
			return new MUnitSaveData();
		}
		
		private createPetSaveData():BaseData
		{
			return new PetSaveData();
		}
		
		private createRoleAttributeData():BaseData
		{
			return new RoleAttributeData();
		}
		
		private createSceneRoleData():BaseData
		{
			return new SceneRoleData();
		}
		
		private createBuildingIdentityData():BaseData
		{
			return new BuildingIdentityData();
		}
		
		private createRoleForceData():BaseData
		{
			return new RoleForceData();
		}
		
		private createClientLoginServerInfoData():BaseData
		{
			return new ClientLoginServerInfoData();
		}
		
		private createPlayerRoleGroupToolData():BaseData
		{
			return new PlayerRoleGroupToolData();
		}
		
		private createRoleGroupData():BaseData
		{
			return new RoleGroupData();
		}
		
		private createRoleGroupMemberData():BaseData
		{
			return new RoleGroupMemberData();
		}
		
		private createRoleGroupToolData():BaseData
		{
			return new RoleGroupToolData();
		}
		
		private createClientLoginResultData():BaseData
		{
			return new ClientLoginResultData();
		}
		
		private createAreaServerData():BaseData
		{
			return new AreaServerData();
		}
		
		private createPlayerBindPlatformAWData():BaseData
		{
			return new PlayerBindPlatformAWData();
		}
		
		private createPlayerLoginToEachGameData():BaseData
		{
			return new PlayerLoginToEachGameData();
		}
		
		private createRePlayerLoginFromEachGameData():BaseData
		{
			return new RePlayerLoginFromEachGameData();
		}
		
		private createPlayerRoleGroupData():BaseData
		{
			return new PlayerRoleGroupData();
		}
		
		private createPlayerWorkCompleteData():BaseData
		{
			return new PlayerWorkCompleteData();
		}
		
		private createWorkCompleteData():BaseData
		{
			return new WorkCompleteData();
		}
		
		private createCreateRoleGroupWData():BaseData
		{
			return new CreateRoleGroupWData();
		}
		
		private createAreaGlobalWorkData():BaseData
		{
			return new AreaGlobalWorkData();
		}
		
		private createAreaGlobalWorkCompleteData():BaseData
		{
			return new AreaGlobalWorkCompleteData();
		}
		
		private createCreateRoleGroupData():BaseData
		{
			return new CreateRoleGroupData();
		}
		
		private createPlayerRoleGroupSaveData():BaseData
		{
			return new PlayerRoleGroupSaveData();
		}
		
		private createPlayerApplyRoleGroupData():BaseData
		{
			return new PlayerApplyRoleGroupData();
		}
		
		private createRoleGroupSimpleData():BaseData
		{
			return new RoleGroupSimpleData();
		}
		
		private createCreateRoleGroupResultOWData():BaseData
		{
			return new CreateRoleGroupResultOWData();
		}
		
		private createInviteRoleGroupWData():BaseData
		{
			return new InviteRoleGroupWData();
		}
		
		private createPlayerFuncWorkData():BaseData
		{
			return new PlayerFuncWorkData();
		}
		
		private createPlayerApplyRoleGroupSelfData():BaseData
		{
			return new PlayerApplyRoleGroupSelfData();
		}
		
		private createAddApplyRoleGroupSelfWData():BaseData
		{
			return new AddApplyRoleGroupSelfWData();
		}
		
		private createHandleApplyRoleGroupWData():BaseData
		{
			return new HandleApplyRoleGroupWData();
		}
		
		private createRoleGroupChangeData():BaseData
		{
			return new RoleGroupChangeData();
		}
		
		private createPlayerRoleGroupClientToolData():BaseData
		{
			return new PlayerRoleGroupClientToolData();
		}
		
		private createPlayerUnionData():BaseData
		{
			return new PlayerUnionData();
		}
		
		private createUnionData():BaseData
		{
			return new UnionData();
		}
		
		private createUnionMemberData():BaseData
		{
			return new UnionMemberData();
		}
		
		private createCreateUnionData():BaseData
		{
			return new CreateUnionData();
		}
		
		private createUnionSimpleData():BaseData
		{
			return new UnionSimpleData();
		}
		
		private createPlayerUnionSaveData():BaseData
		{
			return new PlayerUnionSaveData();
		}
		
		private createJoinRoleGroupWData():BaseData
		{
			return new JoinRoleGroupWData();
		}
		
		private createLeaveRoleGroupWData():BaseData
		{
			return new LeaveRoleGroupWData();
		}
		
		private createUseActivationCodeSuccessOWData():BaseData
		{
			return new UseActivationCodeSuccessOWData();
		}
		
		private createTeamData():BaseData
		{
			return new TeamData();
		}
		
		private createCreateTeamData():BaseData
		{
			return new CreateTeamData();
		}
		
		private createPlayerTeamData():BaseData
		{
			return new PlayerTeamData();
		}
		
		private createTeamMemberData():BaseData
		{
			return new TeamMemberData();
		}
		
		private createTeamSimpleData():BaseData
		{
			return new TeamSimpleData();
		}
		
		private createPlayerCreatedWData():BaseData
		{
			return new PlayerCreatedWData();
		}
		
		private createUserWorkData():BaseData
		{
			return new UserWorkData();
		}
		
		private createPlayerDeletedWData():BaseData
		{
			return new PlayerDeletedWData();
		}
		
		private createInfoLogData():BaseData
		{
			return new InfoLogData();
		}
		
		private createRoleShowLogData():BaseData
		{
			return new RoleShowLogData();
		}
		
		private createInfoLogWData():BaseData
		{
			return new InfoLogWData();
		}
		
		private createGameInitServerData():BaseData
		{
			return new GameInitServerData();
		}
		
		private createLoginInitServerData():BaseData
		{
			return new LoginInitServerData();
		}
		
		private createGameLoginToCenterData():BaseData
		{
			return new GameLoginToCenterData();
		}
		
		private createGameLoginToGameData():BaseData
		{
			return new GameLoginToGameData();
		}
		
		private createPlayerToPlayerTCCWData():BaseData
		{
			return new PlayerToPlayerTCCWData();
		}
		
		private createPlayerToRoleGroupTCCWData():BaseData
		{
			return new PlayerToRoleGroupTCCWData();
		}
		
		private createRoleGroupWorkData():BaseData
		{
			return new RoleGroupWorkData();
		}
		
		private createPlayerToRoleGroupTCCResultWData():BaseData
		{
			return new PlayerToRoleGroupTCCResultWData();
		}
		
		private createPlayerToPlayerTCCResultWData():BaseData
		{
			return new PlayerToPlayerTCCResultWData();
		}
		
		private createRoleShowInfoLogData():BaseData
		{
			return new RoleShowInfoLogData();
		}
		
		private createCreateSceneData():BaseData
		{
			return new CreateSceneData();
		}
		
		private createRoleGroupCreateSceneData():BaseData
		{
			return new RoleGroupCreateSceneData();
		}
		
		private createPlayerRoleGroupMemberData():BaseData
		{
			return new PlayerRoleGroupMemberData();
		}
		
		private createRoleGroupMemberChangeData():BaseData
		{
			return new RoleGroupMemberChangeData();
		}
		
		private createPlayerRoleGroupExData():BaseData
		{
			return new PlayerRoleGroupExData();
		}
		
		private createUnitFuncData():BaseData
		{
			return new UnitFuncData();
		}
		
		private createUnitMoveData():BaseData
		{
			return new UnitMoveData();
		}
		
		private createFieldItemBagIdentityData():BaseData
		{
			return new FieldItemBagIdentityData();
		}
		
		private createUnitNormalData():BaseData
		{
			return new UnitNormalData();
		}
		
		private createFieldItemBagBindData():BaseData
		{
			return new FieldItemBagBindData();
		}
		
		private createRectData():BaseData
		{
			return new RectData();
		}
		
		private createItemChatElementData():BaseData
		{
			return new ItemChatElementData();
		}
		
		private createChatChannelData():BaseData
		{
			return new ChatChannelData();
		}
		
		private createRoleChatData():BaseData
		{
			return new RoleChatData();
		}
		
		private createRoleSimpleShowData():BaseData
		{
			return new RoleSimpleShowData();
		}
		
		private createSendPlayerChatOWData():BaseData
		{
			return new SendPlayerChatOWData();
		}
		
		private createSceneLocationData():BaseData
		{
			return new SceneLocationData();
		}
		
		private createSceneLocationRoleShowChangeData():BaseData
		{
			return new SceneLocationRoleShowChangeData();
		}
		
		private createRegionData():BaseData
		{
			return new RegionData();
		}
		
		private createUnitSimpleData():BaseData
		{
			return new UnitSimpleData();
		}
		
	}
}
