package com.home.commonCenter.tool.generate;
import com.home.commonBase.constlist.generate.ServerMessageType;
import com.home.commonCenter.net.serverRequest.game.activity.ActivityResetToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.activity.ActivitySwitchToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.activity.ChangeActivityForceCloseToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.base.PlayerToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.func.auction.FuncRefreshAuctionItemPriceToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.func.base.FuncCenterToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.func.base.FuncPlayerToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.func.match.FuncMatchTimeOutToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.func.pageShow.FuncReGetPageShowToPlayerServerRequest;
import com.home.commonCenter.net.serverRequest.game.func.rank.FuncAddRankToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.func.rank.FuncRefreshRankToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.func.rank.FuncRemoveRankToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.func.rank.FuncResetRankToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.func.rank.subsection.FuncAddSubsectionRankToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.func.rank.subsection.FuncRefreshSubsectionIndexToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.func.rank.subsection.FuncRefreshSubsectionRankToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.func.rank.subsection.FuncRemoveSubsectionRankToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.func.rank.subsection.FuncResetSubsectionRankToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.func.social.FuncReGetRandomPlayerListFromRoleSocialPoolToCenterServerRequest;
import com.home.commonCenter.net.serverRequest.game.login.KickPlayerFromCenterServerRequest;
import com.home.commonCenter.net.serverRequest.game.mail.SendMailToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.scene.CreateSignedSceneToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.scene.EnterSignedSceneToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.social.RefreshRoleGroupChangeToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.social.RefreshRoleShowDataChangeToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.social.RemoveCenterRoleSocialDataToPlayerServerRequest;
import com.home.commonCenter.net.serverRequest.game.social.SendGetRoleSocialDataToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.system.CenterTransCenterToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.system.GameExitServerRequest;
import com.home.commonCenter.net.serverRequest.game.system.GameReloadConfigServerRequest;
import com.home.commonCenter.net.serverRequest.game.system.PlayerToGameTransCenterToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.system.ReBeGameToCenterServerRequest;
import com.home.commonCenter.net.serverRequest.game.system.ReceiptWorkToGameFromCenterServerRequest;
import com.home.commonCenter.net.serverRequest.game.system.RefreshServerOffTimeToGameServerRequest;
import com.home.commonCenter.net.serverRequest.game.system.SendAreaWorkToGameFromCenterServerRequest;
import com.home.commonCenter.net.serverRequest.game.system.SendPlayerWorkCompleteServerRequest;
import com.home.commonCenter.net.serverRequest.game.system.SendPlayerWorkServerRequest;
import com.home.commonCenter.net.serverRequest.game.system.SendWorkFailedServerRequest;
import com.home.commonCenter.net.serverRequest.manager.BeCenterToManagerServerRequest;
import com.home.commonCenter.net.serverRequest.manager.ReMAddPlayerWorkToCenterServerRequest;
import com.home.commonCenter.net.serverRequest.manager.ReMQueryPlayerWorkToCenterServerRequest;
import com.home.shine.data.BaseData;
import com.home.shine.tool.CreateDataFunc;
import com.home.shine.tool.DataMaker;

/** (generated by shine) */
public class CenterServerRequestMaker extends DataMaker
{
	public CenterServerRequestMaker()
	{
		offSet=ServerMessageType.off;
		list=new CreateDataFunc[ServerMessageType.count-offSet];
		list[ServerMessageType.FuncCenterToGame-offSet]=this::createFuncCenterToGameServerRequest;
		list[ServerMessageType.FuncRefreshAuctionItemPriceToGame-offSet]=this::createFuncRefreshAuctionItemPriceToGameServerRequest;
		list[ServerMessageType.ActivityResetToGame-offSet]=this::createActivityResetToGameServerRequest;
		list[ServerMessageType.ActivitySwitchToGame-offSet]=this::createActivitySwitchToGameServerRequest;
		list[ServerMessageType.CenterTransCenterToGame-offSet]=this::createCenterTransCenterToGameServerRequest;
		list[ServerMessageType.ChangeActivityForceCloseToGame-offSet]=this::createChangeActivityForceCloseToGameServerRequest;
		list[ServerMessageType.CreateSignedSceneToGame-offSet]=this::createCreateSignedSceneToGameServerRequest;
		list[ServerMessageType.EnterSignedSceneToGame-offSet]=this::createEnterSignedSceneToGameServerRequest;
		list[ServerMessageType.FuncAddRankToGame-offSet]=this::createFuncAddRankToGameServerRequest;
		list[ServerMessageType.FuncMatchTimeOutToGame-offSet]=this::createFuncMatchTimeOutToGameServerRequest;
		list[ServerMessageType.FuncPlayerToGame-offSet]=this::createFuncPlayerToGameServerRequest;
		list[ServerMessageType.FuncReGetRandomPlayerListFromRoleSocialPoolToCenter-offSet]=this::createFuncReGetRandomPlayerListFromRoleSocialPoolToCenterServerRequest;
		list[ServerMessageType.FuncRefreshRankToGame-offSet]=this::createFuncRefreshRankToGameServerRequest;
		list[ServerMessageType.FuncRemoveRankToGame-offSet]=this::createFuncRemoveRankToGameServerRequest;
		list[ServerMessageType.FuncResetRankToGame-offSet]=this::createFuncResetRankToGameServerRequest;
		list[ServerMessageType.GameExit-offSet]=this::createGameExitServerRequest;
		list[ServerMessageType.GameReloadConfig-offSet]=this::createGameReloadConfigServerRequest;
		list[ServerMessageType.KickPlayerFromCenter-offSet]=this::createKickPlayerFromCenterServerRequest;
		list[ServerMessageType.PlayerToGame-offSet]=this::createPlayerToGameServerRequest;
		list[ServerMessageType.PlayerToGameTransCenterToGame-offSet]=this::createPlayerToGameTransCenterToGameServerRequest;
		list[ServerMessageType.ReBeGameToCenter-offSet]=this::createReBeGameToCenterServerRequest;
		list[ServerMessageType.RefreshServerOffTimeToGame-offSet]=this::createRefreshServerOffTimeToGameServerRequest;
		list[ServerMessageType.SendGetRoleSocialDataToGame-offSet]=this::createSendGetRoleSocialDataToGameServerRequest;
		list[ServerMessageType.SendMailToGame-offSet]=this::createSendMailToGameServerRequest;
		list[ServerMessageType.SendPlayerWorkComplete-offSet]=this::createSendPlayerWorkCompleteServerRequest;
		list[ServerMessageType.SendPlayerWork-offSet]=this::createSendPlayerWorkServerRequest;
		list[ServerMessageType.SendWorkFailed-offSet]=this::createSendWorkFailedServerRequest;
		list[ServerMessageType.FuncAddSubsectionRankToGame-offSet]=this::createFuncAddSubsectionRankToGameServerRequest;
		list[ServerMessageType.FuncRefreshSubsectionIndexToGame-offSet]=this::createFuncRefreshSubsectionIndexToGameServerRequest;
		list[ServerMessageType.FuncRefreshSubsectionRankToGame-offSet]=this::createFuncRefreshSubsectionRankToGameServerRequest;
		list[ServerMessageType.FuncRemoveSubsectionRankToGame-offSet]=this::createFuncRemoveSubsectionRankToGameServerRequest;
		list[ServerMessageType.ReMAddPlayerWorkToCenter-offSet]=this::createReMAddPlayerWorkToCenterServerRequest;
		list[ServerMessageType.ReMQueryPlayerWorkToCenter-offSet]=this::createReMQueryPlayerWorkToCenterServerRequest;
		list[ServerMessageType.FuncResetSubsectionRankToGame-offSet]=this::createFuncResetSubsectionRankToGameServerRequest;
		list[ServerMessageType.RemoveCenterRoleSocialDataToPlayer-offSet]=this::createRemoveCenterRoleSocialDataToPlayerServerRequest;
		list[ServerMessageType.FuncReGetPageShowToPlayer-offSet]=this::createFuncReGetPageShowToPlayerServerRequest;
		list[ServerMessageType.BeCenterToManager-offSet]=this::createBeCenterToManagerServerRequest;
		list[ServerMessageType.ReceiptWorkToGameFromCenter-offSet]=this::createReceiptWorkToGameFromCenterServerRequest;
		list[ServerMessageType.SendAreaWorkToGameFromCenter-offSet]=this::createSendAreaWorkToGameFromCenterServerRequest;
		list[ServerMessageType.RefreshRoleGroupChangeToGame-offSet]=this::createRefreshRoleGroupChangeToGameServerRequest;
		list[ServerMessageType.RefreshRoleShowDataChangeToGame-offSet]=this::createRefreshRoleShowDataChangeToGameServerRequest;
	}
	
	private BaseData createFuncCenterToGameServerRequest()
	{
		return new FuncCenterToGameServerRequest();
	}
	
	private BaseData createFuncRefreshAuctionItemPriceToGameServerRequest()
	{
		return new FuncRefreshAuctionItemPriceToGameServerRequest();
	}
	
	private BaseData createActivityResetToGameServerRequest()
	{
		return new ActivityResetToGameServerRequest();
	}
	
	private BaseData createActivitySwitchToGameServerRequest()
	{
		return new ActivitySwitchToGameServerRequest();
	}
	
	private BaseData createCenterTransCenterToGameServerRequest()
	{
		return new CenterTransCenterToGameServerRequest();
	}
	
	private BaseData createChangeActivityForceCloseToGameServerRequest()
	{
		return new ChangeActivityForceCloseToGameServerRequest();
	}
	
	private BaseData createCreateSignedSceneToGameServerRequest()
	{
		return new CreateSignedSceneToGameServerRequest();
	}
	
	private BaseData createEnterSignedSceneToGameServerRequest()
	{
		return new EnterSignedSceneToGameServerRequest();
	}
	
	private BaseData createFuncAddRankToGameServerRequest()
	{
		return new FuncAddRankToGameServerRequest();
	}
	
	private BaseData createFuncMatchTimeOutToGameServerRequest()
	{
		return new FuncMatchTimeOutToGameServerRequest();
	}
	
	private BaseData createFuncPlayerToGameServerRequest()
	{
		return new FuncPlayerToGameServerRequest();
	}
	
	private BaseData createFuncReGetRandomPlayerListFromRoleSocialPoolToCenterServerRequest()
	{
		return new FuncReGetRandomPlayerListFromRoleSocialPoolToCenterServerRequest();
	}
	
	private BaseData createFuncRefreshRankToGameServerRequest()
	{
		return new FuncRefreshRankToGameServerRequest();
	}
	
	private BaseData createFuncRemoveRankToGameServerRequest()
	{
		return new FuncRemoveRankToGameServerRequest();
	}
	
	private BaseData createFuncResetRankToGameServerRequest()
	{
		return new FuncResetRankToGameServerRequest();
	}
	
	private BaseData createGameExitServerRequest()
	{
		return new GameExitServerRequest();
	}
	
	private BaseData createGameReloadConfigServerRequest()
	{
		return new GameReloadConfigServerRequest();
	}
	
	private BaseData createKickPlayerFromCenterServerRequest()
	{
		return new KickPlayerFromCenterServerRequest();
	}
	
	private BaseData createPlayerToGameServerRequest()
	{
		return new PlayerToGameServerRequest();
	}
	
	private BaseData createPlayerToGameTransCenterToGameServerRequest()
	{
		return new PlayerToGameTransCenterToGameServerRequest();
	}
	
	private BaseData createReBeGameToCenterServerRequest()
	{
		return new ReBeGameToCenterServerRequest();
	}
	
	private BaseData createRefreshServerOffTimeToGameServerRequest()
	{
		return new RefreshServerOffTimeToGameServerRequest();
	}
	
	private BaseData createSendGetRoleSocialDataToGameServerRequest()
	{
		return new SendGetRoleSocialDataToGameServerRequest();
	}
	
	private BaseData createSendMailToGameServerRequest()
	{
		return new SendMailToGameServerRequest();
	}
	
	private BaseData createSendPlayerWorkCompleteServerRequest()
	{
		return new SendPlayerWorkCompleteServerRequest();
	}
	
	private BaseData createSendPlayerWorkServerRequest()
	{
		return new SendPlayerWorkServerRequest();
	}
	
	private BaseData createSendWorkFailedServerRequest()
	{
		return new SendWorkFailedServerRequest();
	}
	
	private BaseData createFuncAddSubsectionRankToGameServerRequest()
	{
		return new FuncAddSubsectionRankToGameServerRequest();
	}
	
	private BaseData createFuncRefreshSubsectionIndexToGameServerRequest()
	{
		return new FuncRefreshSubsectionIndexToGameServerRequest();
	}
	
	private BaseData createFuncRefreshSubsectionRankToGameServerRequest()
	{
		return new FuncRefreshSubsectionRankToGameServerRequest();
	}
	
	private BaseData createFuncRemoveSubsectionRankToGameServerRequest()
	{
		return new FuncRemoveSubsectionRankToGameServerRequest();
	}
	
	private BaseData createReMAddPlayerWorkToCenterServerRequest()
	{
		return new ReMAddPlayerWorkToCenterServerRequest();
	}
	
	private BaseData createReMQueryPlayerWorkToCenterServerRequest()
	{
		return new ReMQueryPlayerWorkToCenterServerRequest();
	}
	
	private BaseData createFuncResetSubsectionRankToGameServerRequest()
	{
		return new FuncResetSubsectionRankToGameServerRequest();
	}
	
	private BaseData createRemoveCenterRoleSocialDataToPlayerServerRequest()
	{
		return new RemoveCenterRoleSocialDataToPlayerServerRequest();
	}
	
	private BaseData createFuncReGetPageShowToPlayerServerRequest()
	{
		return new FuncReGetPageShowToPlayerServerRequest();
	}
	
	private BaseData createBeCenterToManagerServerRequest()
	{
		return new BeCenterToManagerServerRequest();
	}
	
	private BaseData createReceiptWorkToGameFromCenterServerRequest()
	{
		return new ReceiptWorkToGameFromCenterServerRequest();
	}
	
	private BaseData createSendAreaWorkToGameFromCenterServerRequest()
	{
		return new SendAreaWorkToGameFromCenterServerRequest();
	}
	
	private BaseData createRefreshRoleGroupChangeToGameServerRequest()
	{
		return new RefreshRoleGroupChangeToGameServerRequest();
	}
	
	private BaseData createRefreshRoleShowDataChangeToGameServerRequest()
	{
		return new RefreshRoleShowDataChangeToGameServerRequest();
	}
	
}