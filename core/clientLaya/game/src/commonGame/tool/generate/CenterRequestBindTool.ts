namespace Shine
{
	/** (generated by shine) */
	export class CenterRequestBindTool extends MessageBindTool
	{
		constructor()
		{
			super();
			this.offSet=CenterRequestType.off;
			this.list=new Array<number[]>(CenterRequestType.count-this.offSet);
		}
		
	}
}
