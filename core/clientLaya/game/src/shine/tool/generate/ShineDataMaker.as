package shine.tool.generate
{
	import .DIntData;
	import .DateData;
	import .SecondPassData;
	import .TimePassData;
	import .TriggerBooleanData;
	import .TriggerConfigData;
	import .TriggerFloatData;
	import .TriggerFuncData;
	import .TriggerFuncListData;
	import .TriggerIntData;
	import .TriggerListData;
	import .TriggerLongData;
	import .TriggerObjData;
	import .TriggerStringData;
	import .UIObjectData;
	import com.home.shine.data.BaseData;
	import com.home.shine.tool.DataMaker;
	import shine.constlist.generate.ShineDataType;

	/** (generated by shine) */
	public class ShineDataMaker extends DataMaker
	{
		public function ShineDataMaker()
		{
			offSet=ShineDataType.off;
			list=new Vector.<Function>(ShineDataType.count-offSet);
			list[ShineDataType.TriggerConfig-offSet]=createTriggerConfigData;
			list[ShineDataType.TriggerList-offSet]=createTriggerListData;
			list[ShineDataType.TriggerBoolean-offSet]=createTriggerBooleanData;
			list[ShineDataType.TriggerFunc-offSet]=createTriggerFuncData;
			list[ShineDataType.TriggerInt-offSet]=createTriggerIntData;
			list[ShineDataType.TriggerFloat-offSet]=createTriggerFloatData;
			list[ShineDataType.TriggerString-offSet]=createTriggerStringData;
			list[ShineDataType.TriggerLong-offSet]=createTriggerLongData;
			list[ShineDataType.TriggerObj-offSet]=createTriggerObjData;
			list[ShineDataType.TriggerFuncList-offSet]=createTriggerFuncListData;
			list[ShineDataType.Date-offSet]=createDateData;
			list[ShineDataType.TimePass-offSet]=createTimePassData;
			list[ShineDataType.UIObject-offSet]=createUIObjectData;
			list[ShineDataType.SecondPass-offSet]=createSecondPassData;
			list[ShineDataType.DInt-offSet]=createDIntData;
		}
		
		private function createTriggerConfigData():BaseData
		{
			return new TriggerConfigData();
		}
		
		private function createTriggerListData():BaseData
		{
			return new TriggerListData();
		}
		
		private function createTriggerBooleanData():BaseData
		{
			return new TriggerBooleanData();
		}
		
		private function createTriggerFuncData():BaseData
		{
			return new TriggerFuncData();
		}
		
		private function createTriggerIntData():BaseData
		{
			return new TriggerIntData();
		}
		
		private function createTriggerFloatData():BaseData
		{
			return new TriggerFloatData();
		}
		
		private function createTriggerStringData():BaseData
		{
			return new TriggerStringData();
		}
		
		private function createTriggerLongData():BaseData
		{
			return new TriggerLongData();
		}
		
		private function createTriggerObjData():BaseData
		{
			return new TriggerObjData();
		}
		
		private function createTriggerFuncListData():BaseData
		{
			return new TriggerFuncListData();
		}
		
		private function createDateData():BaseData
		{
			return new DateData();
		}
		
		private function createTimePassData():BaseData
		{
			return new TimePassData();
		}
		
		private function createUIObjectData():BaseData
		{
			return new UIObjectData();
		}
		
		private function createSecondPassData():BaseData
		{
			return new SecondPassData();
		}
		
		private function createDIntData():BaseData
		{
			return new DIntData();
		}
		
	}
}
