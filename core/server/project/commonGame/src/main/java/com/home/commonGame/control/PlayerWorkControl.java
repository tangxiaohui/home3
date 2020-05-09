package com.home.commonGame.control;
import com.home.commonBase.constlist.generate.CallWayType;
import com.home.commonBase.data.activity.UseActivationCodeSuccessOWData;
import com.home.commonBase.data.func.PlayerFuncWorkData;
import com.home.commonBase.data.gm.GMAddCurrencyOWData;
import com.home.commonBase.data.gm.QueryPlayerLevelWData;
import com.home.commonBase.data.item.auction.AuctionReBuyItemOWData;
import com.home.commonBase.data.item.auction.AuctionReSellItemOWData;
import com.home.commonBase.data.item.auction.AuctionRemoveSellItemOWData;
import com.home.commonBase.data.item.auction.AuctionSoldItemOWData;
import com.home.commonBase.data.login.PlayerBindPlatformAWData;
import com.home.commonBase.data.mail.AddMailOWData;
import com.home.commonBase.data.queryResult.IntQueryResultData;
import com.home.commonBase.data.social.QueryPlayerAWData;
import com.home.commonBase.data.social.ReGetRoleSocialDataWData;
import com.home.commonBase.data.social.ReQueryPlayerOWData;
import com.home.commonBase.data.social.RefreshPartRoleShowDataWData;
import com.home.commonBase.data.social.chat.SendPlayerChatOWData;
import com.home.commonBase.data.social.friend.AddBeFriendOWData;
import com.home.commonBase.data.social.friend.AddFriendFailedForOvonicAWData;
import com.home.commonBase.data.social.friend.AddFriendForOvonicAWData;
import com.home.commonBase.data.social.friend.ApplyAddFriendOWData;
import com.home.commonBase.data.social.friend.RemoveBeFriendOWData;
import com.home.commonBase.data.social.friend.RemoveFriendOWData;
import com.home.commonBase.data.social.roleGroup.work.AddApplyRoleGroupSelfWData;
import com.home.commonBase.data.social.roleGroup.work.CreateRoleGroupResultOWData;
import com.home.commonBase.data.social.roleGroup.work.HandleApplyRoleGroupWData;
import com.home.commonBase.data.social.roleGroup.work.InviteRoleGroupWData;
import com.home.commonBase.data.social.roleGroup.work.JoinRoleGroupWData;
import com.home.commonBase.data.social.roleGroup.work.LeaveRoleGroupWData;
import com.home.commonBase.data.social.roleGroup.work.PlayerToRoleGroupTCCResultWData;
import com.home.commonBase.data.system.InfoLogWData;
import com.home.commonBase.data.system.PlayerToPlayerTCCResultWData;
import com.home.commonBase.data.system.PlayerToPlayerTCCWData;
import com.home.commonBase.data.system.PlayerWorkData;
import com.home.commonGame.global.GameC;
import com.home.commonGame.part.player.Player;
import com.home.commonGame.tool.func.PlayerRoleGroupTool;

/** 角色事务控制(generated by shine) */
public class PlayerWorkControl extends BasePlayerWorkControl
{
	/** 注册 */
	@Override
	protected void regist()
	{
		registOne(UseActivationCodeSuccessOWData.dataID,this::doUseActivationCodeSuccessOW);
		registOne(PlayerFuncWorkData.dataID,this::doPlayerFuncWork);
		registOne(GMAddCurrencyOWData.dataID,this::doGMAddCurrencyOW);
		registOne(QueryPlayerLevelWData.dataID,this::doQueryPlayerLevelW);
		registOne(AuctionReBuyItemOWData.dataID,this::doAuctionReBuyItemOW);
		registOne(AuctionReSellItemOWData.dataID,this::doAuctionReSellItemOW);
		registOne(AuctionRemoveSellItemOWData.dataID,this::doAuctionRemoveSellItemOW);
		registOne(AuctionSoldItemOWData.dataID,this::doAuctionSoldItemOW);
		registOne(PlayerBindPlatformAWData.dataID,this::doPlayerBindPlatformAW);
		registOne(AddMailOWData.dataID,this::doAddMailOW);
		registOne(QueryPlayerAWData.dataID,this::doQueryPlayerAW);
		registOne(ReGetRoleSocialDataWData.dataID,this::doReGetRoleSocialDataW);
		registOne(ReQueryPlayerOWData.dataID,this::doReQueryPlayerOW);
		registOne(RefreshPartRoleShowDataWData.dataID,this::doRefreshPartRoleShowDataW);
		registOne(SendPlayerChatOWData.dataID,this::doSendPlayerChatOW);
		registOne(AddBeFriendOWData.dataID,this::doAddBeFriendOW);
		registOne(AddFriendFailedForOvonicAWData.dataID,this::doAddFriendFailedForOvonicAW);
		registOne(AddFriendForOvonicAWData.dataID,this::doAddFriendForOvonicAW);
		registOne(ApplyAddFriendOWData.dataID,this::doApplyAddFriendOW);
		registOne(RemoveBeFriendOWData.dataID,this::doRemoveBeFriendOW);
		registOne(RemoveFriendOWData.dataID,this::doRemoveFriendOW);
		registOne(AddApplyRoleGroupSelfWData.dataID,this::doAddApplyRoleGroupSelfW);
		registOne(CreateRoleGroupResultOWData.dataID,this::doCreateRoleGroupResultOW);
		registOne(HandleApplyRoleGroupWData.dataID,this::doHandleApplyRoleGroupW);
		registOne(InviteRoleGroupWData.dataID,this::doInviteRoleGroupW);
		registOne(JoinRoleGroupWData.dataID,this::doJoinRoleGroupW);
		registOne(LeaveRoleGroupWData.dataID,this::doLeaveRoleGroupW);
		registOne(PlayerToRoleGroupTCCResultWData.dataID,this::doPlayerToRoleGroupTCCResultW);
		registOne(InfoLogWData.dataID,this::doInfoLogW);
		registOne(PlayerToPlayerTCCResultWData.dataID,this::doPlayerToPlayerTCCResultW);
		registOne(PlayerToPlayerTCCWData.dataID,this::doPlayerToPlayerTCCW);
	}
	
	/** 注册玩家群TCC事务结果 */
	@Override
	protected void registRoleGroupTCCResult()
	{
		
	}
	
	/** 注册玩家TCC事务到达 */
	@Override
	protected void registPlayerTCC()
	{
		
	}
	
	/** 注册玩家TCC事务结果 */
	@Override
	protected void registPlayerTCCResult()
	{
		
	}
	
	/** 角色功能事务数据 */
	private void doPlayerFuncWork(Player me,PlayerWorkData wData)
	{
		PlayerFuncWorkData data=(PlayerFuncWorkData)wData;
		
	}
	
	/** 添加邮件离线事务 */
	private void doAddMailOW(Player me,PlayerWorkData wData)
	{
		AddMailOWData data=(AddMailOWData)wData;
		me.mail.addMail(data.data);
	}
	
	/** 申请添加好友离线事务 */
	private void doApplyAddFriendOW(Player me,PlayerWorkData wData)
	{
		ApplyAddFriendOWData data=(ApplyAddFriendOWData)wData;
		
		me.friend.onAddApplyFriend(data.applyData);
	}
	
	/** 添加好友失败 */
	private void doAddFriendFailedForOvonicAW(Player me,PlayerWorkData wData)
	{
		AddFriendFailedForOvonicAWData data=(AddFriendFailedForOvonicAWData)wData;
		me.friend.addFriendFailedForOvnic(data.playerID);
	}
	
	/** 添加被好友离线事务 */
	private void doAddBeFriendOW(Player me,PlayerWorkData wData)
	{
		AddBeFriendOWData data=(AddBeFriendOWData)wData;
		me.friend.doAddBeFriend(data.playerID);
	}
	
	/** 添加好友(双向)立即事务 */
	private void doAddFriendForOvonicAW(Player me,PlayerWorkData wData)
	{
		AddFriendForOvonicAWData data=(AddFriendForOvonicAWData)wData;
		me.friend.addFriendForOvonic(data.data.showData.playerID,data.data,data.type);
	}
	
	/** 执行移除好友离线事务 */
	private void doRemoveFriendOW(Player me,PlayerWorkData wData)
	{
		RemoveFriendOWData data=(RemoveFriendOWData)wData;
		me.friend.doRemoveFriend(data.playerID);
	}
	
	/** 移除被好友离线事务 */
	private void doRemoveBeFriendOW(Player me,PlayerWorkData wData)
	{
		RemoveBeFriendOWData data=(RemoveBeFriendOWData)wData;
		me.friend.doRemoveBeFriend(data.playerID);
	}
	
	/** 刷新部分角色数据在线事务数据 */
	private void doRefreshPartRoleShowDataW(Player me,PlayerWorkData wData)
	{
		RefreshPartRoleShowDataWData data=(RefreshPartRoleShowDataWData)wData;
		me.social.onRefreshPartRoleSocial(data.playerID,data.data);
	}
	
	/** 回复获取角色社交数据在线数据 */
	private void doReGetRoleSocialDataW(Player me,PlayerWorkData wData)
	{
		ReGetRoleSocialDataWData data=(ReGetRoleSocialDataWData)wData;
		me.social.onReGetRoleSocialData(data);
	}
	
	/** 查询角色等级事务(测试) */
	private void doQueryPlayerLevelW(Player me,PlayerWorkData wData)
	{
		QueryPlayerLevelWData data=(QueryPlayerLevelWData)wData;
		
		IntQueryResultData reData=new IntQueryResultData();
		reData.intValue=me.role.getLevel();
		
		//返回结果
		GameC.main.reQueryResult(data.senderCarryID,reData);
	}
	
	/** gm添加货币离线事务 */
	private void doGMAddCurrencyOW(Player me,PlayerWorkData wData)
	{
		GMAddCurrencyOWData data=(GMAddCurrencyOWData)wData;
		
		if(data.value>0)
		{
			me.role.addCurrency(data.type,data.value,CallWayType.AddCurrencyByClientGM);
		}
		else
		{
			me.role.costCurrency(data.type,-data.value,CallWayType.AddCurrencyByClientGM);
		}
	}
	
	/** 查询角色abs事务 */
	private void doQueryPlayerAW(Player me,PlayerWorkData wData)
	{
		QueryPlayerAWData data=(QueryPlayerAWData)wData;
		
		me.social.onQueryPlayer(data);
	}
	
	/** 回复查询角色在线数据 */
	private void doReQueryPlayerOW(Player me,PlayerWorkData wData)
	{
		ReQueryPlayerOWData data=(ReQueryPlayerOWData)wData;
		
		me.social.onQueryPlayerResult(data.result);
	}
	
	/** 角色绑定平台事务 */
	private void doPlayerBindPlatformAW(Player me,PlayerWorkData wData)
	{
		PlayerBindPlatformAWData data=(PlayerBindPlatformAWData)wData;
		
		me.role.onBindPlatform(data.uid,data.platform);
	}
	
	/** 创建玩家群结果消息(退回cost用) */
	private void doCreateRoleGroupResultOW(Player me,PlayerWorkData wData)
	{
		CreateRoleGroupResultOWData data=(CreateRoleGroupResultOWData)wData;
		
		PlayerRoleGroupTool roleGroupTool=me.func.getRoleGroupTool(data.funcID);
		
		roleGroupTool.onCreateRoleGroupResult(data.success);
	}
	
	/** 邀请进入玩家群消息 */
	private void doInviteRoleGroupW(Player me,PlayerWorkData wData)
	{
		InviteRoleGroupWData data=(InviteRoleGroupWData)wData;
		
		me.func.getRoleGroupTool(data.funcID).receiveInviteRoleGroup(data.inviter,data.simpleData);
	}
	
	/** 添加自身申请玩家群事务 */
	private void doAddApplyRoleGroupSelfW(Player me,PlayerWorkData wData)
	{
		AddApplyRoleGroupSelfWData data=(AddApplyRoleGroupSelfWData)wData;
		
		me.func.getRoleGroupTool(data.funcID).onAddApplySelf(data.data);
	}
	
	/** 处理申请结果事务 */
	private void doHandleApplyRoleGroupW(Player me,PlayerWorkData wData)
	{
		HandleApplyRoleGroupWData data=(HandleApplyRoleGroupWData)wData;
		
		me.func.getRoleGroupTool(data.funcID).onApplyResult(data.groupID,data.result);
	}
	
	/** 加入玩家群事务 */
	private void doJoinRoleGroupW(Player me,PlayerWorkData wData)
	{
		JoinRoleGroupWData data=(JoinRoleGroupWData)wData;
		
		me.func.getRoleGroupTool(data.funcID).onJoinRoleGroup(data.data,data.type);
	}
	
	/** 离开玩家群事务 */
	private void doLeaveRoleGroupW(Player me,PlayerWorkData wData)
	{
		LeaveRoleGroupWData data=(LeaveRoleGroupWData)wData;
		
		me.func.getRoleGroupTool(data.funcID).onLeaveRoleGroup(data.groupID,data.type);
	}
	
	/** 使用激活码成功 */
	private void doUseActivationCodeSuccessOW(Player me,PlayerWorkData wData)
	{
		UseActivationCodeSuccessOWData data=(UseActivationCodeSuccessOWData)wData;
		
		me.activity.onUseActivationCodeSuccess(data.code,data.id);
	}
	
	/** 信息日志事务数据 */
	private void doInfoLogW(Player me,PlayerWorkData wData)
	{
		InfoLogWData data=(InfoLogWData)wData;
		
		me.addInfoLog(data.data);
	}
	
	/** 玩家到玩家tcc事务基类 */
	private void doPlayerToPlayerTCCW(Player me,PlayerWorkData wData)
	{
		PlayerToPlayerTCCWData data=(PlayerToPlayerTCCWData)wData;
		
	}
	
	/** 角色到玩家群TCC事务结果 */
	private void doPlayerToRoleGroupTCCResultW(Player me,PlayerWorkData wData)
	{
		PlayerToRoleGroupTCCResultWData data=(PlayerToRoleGroupTCCResultWData)wData;
		
		this.executeRoleGroupTCCResult(me,data.workData,data.result);
	}
	
	/** 玩家到玩家TCC结果数据 */
	private void doPlayerToPlayerTCCResultW(Player me,PlayerWorkData wData)
	{
		PlayerToPlayerTCCResultWData data=(PlayerToPlayerTCCResultWData)wData;
		
		this.executePlayerTCCResult(me,data.workData,data.result);
	}
	
	/** 推送玩家聊天 */
	private void doSendPlayerChatOW(Player me,PlayerWorkData wData)
	{
		SendPlayerChatOWData data=(SendPlayerChatOWData)wData;
		
		me.social.onReceiveChat(data.chatData,data.channel,data.key);
	}
	
	/** 拍卖行回复出售结果事务数据 */
	private void doAuctionReSellItemOW(Player me,PlayerWorkData wData)
	{
		AuctionReSellItemOWData data=(AuctionReSellItemOWData)wData;
		
		me.func.getAuctionTool(data.funcID).onSellItemResult(data.instanceID,data.success);
	}
	
	/** 拍卖行回复购买物品数据 */
	private void doAuctionReBuyItemOW(Player me,PlayerWorkData wData)
	{
		AuctionReBuyItemOWData data=(AuctionReBuyItemOWData)wData;
		
		me.func.getAuctionTool(data.funcID).onBuyItem(data.instanceID,data.item,data.code);
	}
	
	/** 更新出售物品数目 */
	private void doAuctionSoldItemOW(Player me,PlayerWorkData wData)
	{
		AuctionSoldItemOWData data=(AuctionSoldItemOWData)wData;
		
		me.func.getAuctionTool(data.funcID).onSoldItem(data.instanceID,data.num,data.consumer,data.isSoldOut);
	}
	
	/** 拍卖行移除上架物品 */
	private void doAuctionRemoveSellItemOW(Player me,PlayerWorkData wData)
	{
		AuctionRemoveSellItemOWData data=(AuctionRemoveSellItemOWData)wData;
		
		me.func.getAuctionTool(data.funcID).onRemoveSellItem(data.instanceID,data.lastNum,data.code);
	}
	
}