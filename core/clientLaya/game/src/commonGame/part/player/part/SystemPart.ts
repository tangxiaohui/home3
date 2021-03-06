namespace Shine
{
	/** 系统(generated by shine) */
	export class SystemPart extends PlayerBasePart
	{
		/** 数据 */
		private _d:SystemPartData;
		
		private _inited:boolean=false;
		
		/** 是否当前是在线状态 */
		private _isOnline:boolean=false;
		
		public setData(data:BaseData):void
		{
			super.setData(data);
			
			this._d=data as SystemPartData;
		}
		
		/** 获取数据 */
		public getPartData():SystemPartData
		{
			return this._d;
		}
		
		protected createPartData():BaseData
		{
			return new SystemPartData();
		}
		
		/** 初始化(创建后刚调用,与dispose成对) */
		public init():void
		{
			
		}
		
		/** 析构(回池前调用,与init成对) */
		public dispose():void
		{
			this._inited=false;
		}
		
		/** 从库中读完数据后(做数据的补充解析)(onNewCreate后也会调用一次)(主线程) */
		public afterReadData():void
		{
			if(!ShineSetting.isOfficial)
			{
				// GameC.clientGm.setServerCmdSet(this._d.gmCommandSet);
			}
	
			if(this.isOnline())
			{
				DateControl.setCurrentTime(this._d.serverTime);
	
				// if(CommonSetting.useOfflineGame)
				// {
				// 	GameC.offline.getExData().serverOffTime=DateControl.getOffTime();
				// }
			}
			else
			{
				// if(CommonSetting.useOfflineGame)
				// {
				// 	DateControl.setOffTime(GameC.offline.getExData().serverOffTime);
				// }
			}
		}
		
		/** 构造函数(只在new后调用一次,再次从池中取出不会调用) */
		public construct():void
		{
			
		}
		
		/** 构造数据前 */
		protected beforeMakeData():void
		{
			
		}
		
		/** 功能开启(id:功能ID) */
		public onFunctionOpen(id:number):void
		{
			
		}
		
		/** 功能关闭(id:功能ID) */
		public onFunctionClose(id:number):void
		{
			
		}
		
		/** 是否初始化过(数据) */
		public inited():boolean
		{
			return this._inited;
		}
		
		/** 设置初始化 */
		public setInited(value:boolean):void
		{
			this._inited=value;
		}
		
		/** 获取保存boolean值 */
		public getKeepInt(key:number):number
		{
			return this._d.keepSave.intDic.get(key);
		}
		
		/** 获取保存string值 */
		public getKeepString(key:string):string
		{
			return this._d.keepSave.stringDic.get(key);
		}
		
		/** 保存baalean值 */
		public saveKeepBoolean(key:number,value:boolean):void
		{
			this._d.keepSave.booleanDic.put(key,value);
	
			SaveBooleanRequest.createSaveBoolean(key,value).send();
		}
		
		/** 保存int值 */
		public saveKeepInt(key:number,value:number):void
		{
			this._d.keepSave.intDic.put(key,value);
	
			SaveIntRequest.createSaveInt(key,value).send();
		}
		
		/** 保存long值 */
		private getNextSeed():number
		{
			var seed:number=this._d.clientRandomSeeds[this._d.clientRandomSeedIndex];
	
			if(++this._d.clientRandomSeedIndex>=this._d.clientRandomSeeds.length)
			{
				this._d.clientRandomSeedIndex=0;
			}
	
			return seed;
		}
		
		/** 获取下个客户端随机结果(ratio:千分位) */
		public clientRandomProb(prob:number,max:number):boolean
		{
			if(prob >= max)
			{
				return true;
			}
	
			if(prob<=0)
			{
				return false;
			}
	
			var seed:number=this.getNextSeed();
	
			return seed/100<prob / max;
		}
		
		public setOnline(value:boolean):void
		{
			this._isOnline=value;
		}
		
		/** 是否当前处于在线游戏状态 */
		public isOnline():boolean
		{
			return this._isOnline;
		}
		
		public clientRandomInt(range:number):number
		{
			return this.getNextSeed()*range/100;
		}
		
		/** 设置服务器时间 */
		public serServerTime(serveTime:number):void
		{
			this._d.serverTime=serveTime;
			DateControl.setCurrentTime(serveTime);

			this.me.dispatch(GameEventType.RefreshServerOffTime);
		}
		
	}
}
