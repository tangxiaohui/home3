namespace Shine
{
	/** (generated by shine) */
	export class GameRequestBindTool extends MessageBindTool
	{
		constructor()
		{
			super();
			this.offSet=GameRequestType.off;
			this.list=new Array<number[]>(GameRequestType.count-this.offSet);
			this.list[GameRequestType.AddAllFriend-this.offSet]=new Array().concat();
			this.list[GameRequestType.AddFriend-this.offSet]=new Array().concat();
			this.list[GameRequestType.AgreeAddFriend-this.offSet]=new Array().concat();
			this.list[GameRequestType.ApplyChangeRoleName-this.offSet]=new Array().concat();
			this.list[GameRequestType.CreatePlayer-this.offSet]=new Array().concat();
			this.list[GameRequestType.DeleteMail-this.offSet]=new Array().concat();
			this.list[GameRequestType.RefuseApplyAddFriend-this.offSet]=new Array().concat();
			this.list[GameRequestType.RemoveFriend-this.offSet]=new Array().concat();
			this.list[GameRequestType.SearchPlayer-this.offSet]=new Array().concat();
			this.list[GameRequestType.TakeMail-this.offSet]=new Array().concat();
		}
		
	}
}
