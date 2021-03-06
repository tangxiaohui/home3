namespace Shine
{
	/** 好友(generated by shine) */
	export class FriendPart extends PlayerBasePart
	{
		/** 数据 */
		private _d:FriendPartData;
		
		public setData(data:BaseData):void
		{
			super.setData(data);
			
			this._d=data as FriendPartData;
		}
		
		/** 获取数据 */
		public getPartData():FriendPartData
		{
			return this._d;
		}
		
		/** 构造函数(只在new后调用一次,再次从池中取出不会调用) */
		public construct():void
		{
			
		}
		
		/** 构造数据前 */
		protected beforeMakeData():void
		{
			
		}
		
		/** 初始化(创建后刚调用,与dispose成对) */
		public init():void
		{
			
		}
		
		/** 析构(回池前调用,与init成对) */
		public dispose():void
		{
			
		}
		
		/** 从库中读完数据后(做数据的补充解析)(onNewCreate后也会调用一次)(主线程) */
		public afterReadData():void
		{
			if(!this._d.blackList.isEmpty())
			{

				this._d.blackList.forEachValue(v =>
				{
					v.data=this.me.social.addPlayerRoleSocial(v.playerID,v.data);
				});
			}

			if(!this._d.friends.isEmpty())
			{
				this._d.friends.forEachValue(v =>
				{
					v.data=this.me.social.addPlayerRoleSocial(v.playerID,v.data);
				});
			}
		}
		
		/** 功能开启(id:功能ID) */
		public onFunctionOpen(id:number):void
		{
			
		}
		
		/** 功能关闭(id:功能ID) */
		public onFunctionClose(id:number):void
		{
			
		}
		
		protected createPartData():BaseData
		{
			return new FriendPartData();
		}
		
		private compareApplyAddFriend(arg1:ApplyAddFriendData,arg2:ApplyAddFriendData):number
		{
			if(arg1.applyTime<arg2.applyTime)
				return -1;

			if(arg1.applyTime==arg2.applyTime)
				return 0;

			return 1;
		}
		
		/** 好友列表是否已满 */
		public isFriendListFull():boolean
		{
			return Global.friendMaxNum>0 && this._d.friends.size()>=Global.friendMaxNum;
		}
		
		/** 黑名单列表是否已满 */
		public isBlackListFull():boolean
		{
			return Global.friendBlackListMaxNum>0 && this._d.blackList.size()>=Global.friendBlackListMaxNum;
		}
		
		/** 是否是我的好友 */
		public isFriend(playerID:number):boolean
		{
			return this._d.friends.contains(playerID);
		}
		
		/** 获取好友数据 */
		public getFriend(playerID:number):FriendData
		{
			return this._d.friends.get(playerID);
		}
		
		/** 添加好友 */
		public onAddFriend(data:FriendData):void
		{
			data.data=this.me.social.addPlayerRoleSocial(data.playerID,data.data);//唯一实例

			this._d.friends.put(data.playerID,data);

			this.me.dispatch(GameEventType.AddFriend,data.playerID);

			if(this._d.applyDic.remove(data.playerID)!=null)
			{
				this.me.dispatch(GameEventType.RefreshApplyFriendList);
			}
		}
		
		/** 移除好友 */
		public onRemoveFriend(playerID:number):void
		{
			this._d.friends.remove(playerID);

			this.me.dispatch(GameEventType.RemoveFriend,playerID);
		}
		
		/** 申请添加好友 */
		public onApplyAddFriend(data:ApplyAddFriendData):void
		{
			//快捷方式
			// OtherUtils.putObjInDicWithMax(data.playerID,data,this._d.applyDic,Global.applyAddFriendMaxNum,this.compareApplyAddFriend);


			this._d.applyDic.put(data.playerID,data);

			this.me.dispatch(GameEventType.RefreshApplyFriendList);
			this.me.dispatch(GameEventType.AddFriend);
			this.onApplyAddFriendForG(data);
		}
		
		/** 申请添加好友 */
		public onApplyAddFriendForG(data:ApplyAddFriendData):void
		{
			
		}
		
		/** 添加黑名单 */
		public onAddBlackList(data:ContactData):void
		{
			data.data=this.me.social.addPlayerRoleSocial(data.playerID,data.data);//唯一实例

			this._d.blackList.put(data.playerID,data);

			this.me.dispatch(GameEventType.AddFriendBlackList);
		}
		
		/** 移除黑名单 */
		public onRemoveBlackList(playerID:number):void
		{
			this._d.blackList.remove(playerID);

			this.me.dispatch(GameEventType.RemoveFriendBlackList);
		}
		
		/** 同意添加好友 */
		public agreeApplyFriend(playerID:number):void
		{
			//好友列表已满
			if(this.isFriendListFull())
			{
				//this.me.showInfoCode(InfoCodeType.Friend_friendListIsFull);
				return;
			}

			//已是好友
			if(this._d.friends.contains(playerID))
			{
				//this.me.showInfoCode(InfoCodeType.Friend_targetIsAlreadyFriend);
				return;
			}

			if(this._d.applyDic.remove(playerID)!=null)
			{
				this.me.dispatch(GameEventType.RefreshApplyFriendList);
			}

			this.me.send(AgreeAddFriendRequest.createAgreeAddFriend(playerID));
		}
		
		/** 拒绝好友申请 */
		public refuseApplyAddFriend(playerID:number):void
		{
			var data:ApplyAddFriendData=this._d.applyDic.get(playerID);
			
			if(data==null)
			{
				this.me.warnLog("拒绝好友申请时,不存在");
				return;
			}
			
			this._d.applyDic.remove(playerID);
			
			RefuseApplyAddFriendRequest.createRefuseApplyAddFriend(playerID).send();
		}
		
	}
}
