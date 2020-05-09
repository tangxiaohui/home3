namespace Shine
{
	/** 引导(generated by shine) */
	export class GuidePart extends PlayerBasePart
	{
		/** 数据 */
		private _d:GuidePartData;
		
		public setData(data:BaseData):void
		{
			super.setData(data);
			
			this._d=data as GuidePartData;
		}
		
		/** 获取数据 */
		public getPartData():GuidePartData
		{
			return this._d;
		}
		
		protected createPartData():BaseData
		{
			return new GuidePartData();
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
		
	}
}