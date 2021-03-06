package com.home.commonBase.data.scene.unit;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.scene.base.DirData;
import com.home.commonBase.data.scene.base.DriveData;
import com.home.commonBase.data.scene.base.PosData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.control.BytesControl;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.collection.SList;
import com.home.shine.support.pool.DataPool;

/** 单位移动数据(generated by shine) */
public class UnitMoveData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.UnitMove;
	
	/** 基元移动状态(见UnitBaseMoveState) */
	public int baseMoveState;
	
	/** 当前移动类型(见MoveType) */
	public int moveType;
	
	/** 基元移动点位置 */
	public PosData baseMovePos;
	
	/** 剩余移动点组 */
	public SList<PosData> moveList;
	
	/** 当前特殊移动ID(如没有为-1) */
	public int specialMoveID;
	
	/** 特殊移动参数组 */
	public int[] specialMoveArgs;
	
	/** 当前骑乘载具id */
	public int vehicleInstanceID;
	
	/** 驾驶数据 */
	public DriveData driveData;
	
	/** 实际移动方向(moveDir类型有效) */
	public DirData realMoveDir;
	
	/** 实际移动方向速度比率(x100值)(默认-1)(moveDir类型有效) */
	public int realMoveSpeedRatio=-1;
	
	/** 特殊移动剩余时间 */
	public int specialMoveLastTime;
	
	public UnitMoveData()
	{
		_dataID=BaseDataType.UnitMove;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "UnitMoveData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.baseMoveState=stream.readInt();
		
		this.moveType=stream.readInt();
		
		if(stream.readBoolean())
		{
			this.baseMovePos=new PosData();
			this.baseMovePos.readBytesFull(stream);
		}
		else
		{
			this.baseMovePos=null;
		}
		
		if(stream.readBoolean())
		{
			int moveListLen=stream.readLen();
			if(this.moveList!=null)
			{
				this.moveList.clear();
				this.moveList.ensureCapacity(moveListLen);
			}
			else
			{
				this.moveList=new SList<PosData>(PosData[]::new,moveListLen);
			}
			
			SList<PosData> moveListT=this.moveList;
			for(int moveListI=moveListLen-1;moveListI>=0;--moveListI)
			{
				PosData moveListV;
				if(stream.readBoolean())
				{
					moveListV=new PosData();
					moveListV.readBytesFull(stream);
				}
				else
				{
					moveListV=null;
				}
				
				moveListT.add(moveListV);
			}
		}
		else
		{
			this.moveList=null;
		}
		
		this.specialMoveID=stream.readInt();
		
		if(stream.readBoolean())
		{
			int specialMoveArgsLen=stream.readLen();
			if(this.specialMoveArgs==null || this.specialMoveArgs.length!=specialMoveArgsLen)
			{
				this.specialMoveArgs=new int[specialMoveArgsLen];
			}
			int[] specialMoveArgsT=this.specialMoveArgs;
			for(int specialMoveArgsI=0;specialMoveArgsI<specialMoveArgsLen;++specialMoveArgsI)
			{
				int specialMoveArgsV;
				specialMoveArgsV=stream.readInt();
				
				specialMoveArgsT[specialMoveArgsI]=specialMoveArgsV;
			}
		}
		else
		{
			this.specialMoveArgs=null;
		}
		
		this.specialMoveLastTime=stream.readInt();
		
		this.vehicleInstanceID=stream.readInt();
		
		if(stream.readBoolean())
		{
			BaseData driveDataT=stream.readDataFullNotNull();
			if(driveDataT!=null)
			{
				if(driveDataT instanceof DriveData)
				{
					this.driveData=(DriveData)driveDataT;
				}
				else
				{
					this.driveData=new DriveData();
					if(!(driveDataT.getClass().isAssignableFrom(DriveData.class)))
					{
						stream.throwTypeReadError(DriveData.class,driveDataT.getClass());
					}
					this.driveData.shadowCopy(driveDataT);
				}
			}
			else
			{
				this.driveData=null;
			}
		}
		else
		{
			this.driveData=null;
		}
		
		if(stream.readBoolean())
		{
			this.realMoveDir=new DirData();
			this.realMoveDir.readBytesFull(stream);
		}
		else
		{
			this.realMoveDir=null;
		}
		
		this.realMoveSpeedRatio=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.baseMoveState);
		
		stream.writeInt(this.moveType);
		
		if(this.baseMovePos!=null)
		{
			stream.writeBoolean(true);
			this.baseMovePos.writeBytesFull(stream);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.moveList!=null)
		{
			stream.writeBoolean(true);
			stream.writeLen(this.moveList.size());
			if(!this.moveList.isEmpty())
			{
				Object[] moveListVValues=this.moveList.getValues();
				for(int moveListVI=0,moveListVLen=this.moveList.length();moveListVI<moveListVLen;++moveListVI)
				{
					PosData moveListV=(PosData)moveListVValues[moveListVI];
					if(moveListV!=null)
					{
						stream.writeBoolean(true);
						moveListV.writeBytesFull(stream);
					}
					else
					{
						stream.writeBoolean(false);
					}
					
				}
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeInt(this.specialMoveID);
		
		if(this.specialMoveArgs!=null)
		{
			stream.writeBoolean(true);
			int[] specialMoveArgsT=this.specialMoveArgs;
			stream.writeLen(specialMoveArgsT.length);
			for(int specialMoveArgsVI=0,specialMoveArgsVLen=specialMoveArgsT.length;specialMoveArgsVI<specialMoveArgsVLen;++specialMoveArgsVI)
			{
				int specialMoveArgsV=specialMoveArgsT[specialMoveArgsVI];
				stream.writeInt(specialMoveArgsV);
				
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeInt(this.specialMoveLastTime);
		
		stream.writeInt(this.vehicleInstanceID);
		
		if(this.driveData!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataFullNotNull(this.driveData);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.realMoveDir!=null)
		{
			stream.writeBoolean(true);
			this.realMoveDir.writeBytesFull(stream);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeInt(this.realMoveSpeedRatio);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.baseMoveState=stream.readInt();
		
		this.moveType=stream.readInt();
		
		if(stream.readBoolean())
		{
			this.baseMovePos=new PosData();
			this.baseMovePos.readBytesSimple(stream);
		}
		else
		{
			this.baseMovePos=null;
		}
		
		if(stream.readBoolean())
		{
			int moveListLen=stream.readLen();
			if(this.moveList!=null)
			{
				this.moveList.clear();
				this.moveList.ensureCapacity(moveListLen);
			}
			else
			{
				this.moveList=new SList<PosData>(PosData[]::new,moveListLen);
			}
			
			SList<PosData> moveListT=this.moveList;
			for(int moveListI=moveListLen-1;moveListI>=0;--moveListI)
			{
				PosData moveListV;
				if(stream.readBoolean())
				{
					moveListV=new PosData();
					moveListV.readBytesSimple(stream);
				}
				else
				{
					moveListV=null;
				}
				
				moveListT.add(moveListV);
			}
		}
		else
		{
			this.moveList=null;
		}
		
		this.specialMoveID=stream.readInt();
		
		if(stream.readBoolean())
		{
			int specialMoveArgsLen=stream.readLen();
			if(this.specialMoveArgs==null || this.specialMoveArgs.length!=specialMoveArgsLen)
			{
				this.specialMoveArgs=new int[specialMoveArgsLen];
			}
			int[] specialMoveArgsT=this.specialMoveArgs;
			for(int specialMoveArgsI=0;specialMoveArgsI<specialMoveArgsLen;++specialMoveArgsI)
			{
				int specialMoveArgsV;
				specialMoveArgsV=stream.readInt();
				
				specialMoveArgsT[specialMoveArgsI]=specialMoveArgsV;
			}
		}
		else
		{
			this.specialMoveArgs=null;
		}
		
		this.specialMoveLastTime=stream.readInt();
		
		this.vehicleInstanceID=stream.readInt();
		
		if(stream.readBoolean())
		{
			this.driveData=(DriveData)stream.readDataSimpleNotNull();
		}
		else
		{
			this.driveData=null;
		}
		
		if(stream.readBoolean())
		{
			this.realMoveDir=new DirData();
			this.realMoveDir.readBytesSimple(stream);
		}
		else
		{
			this.realMoveDir=null;
		}
		
		this.realMoveSpeedRatio=stream.readInt();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.baseMoveState);
		
		stream.writeInt(this.moveType);
		
		if(this.baseMovePos!=null)
		{
			stream.writeBoolean(true);
			this.baseMovePos.writeBytesSimple(stream);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.moveList!=null)
		{
			stream.writeBoolean(true);
			stream.writeLen(this.moveList.size());
			if(!this.moveList.isEmpty())
			{
				Object[] moveListVValues=this.moveList.getValues();
				for(int moveListVI=0,moveListVLen=this.moveList.length();moveListVI<moveListVLen;++moveListVI)
				{
					PosData moveListV=(PosData)moveListVValues[moveListVI];
					if(moveListV!=null)
					{
						stream.writeBoolean(true);
						moveListV.writeBytesSimple(stream);
					}
					else
					{
						stream.writeBoolean(false);
					}
					
				}
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeInt(this.specialMoveID);
		
		if(this.specialMoveArgs!=null)
		{
			stream.writeBoolean(true);
			int[] specialMoveArgsT=this.specialMoveArgs;
			stream.writeLen(specialMoveArgsT.length);
			for(int specialMoveArgsVI=0,specialMoveArgsVLen=specialMoveArgsT.length;specialMoveArgsVI<specialMoveArgsVLen;++specialMoveArgsVI)
			{
				int specialMoveArgsV=specialMoveArgsT[specialMoveArgsVI];
				stream.writeInt(specialMoveArgsV);
				
			}
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeInt(this.specialMoveLastTime);
		
		stream.writeInt(this.vehicleInstanceID);
		
		if(this.driveData!=null)
		{
			stream.writeBoolean(true);
			stream.writeDataSimpleNotNull(this.driveData);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.realMoveDir!=null)
		{
			stream.writeBoolean(true);
			this.realMoveDir.writeBytesSimple(stream);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeInt(this.realMoveSpeedRatio);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof UnitMoveData))
			return;
		
		UnitMoveData mData=(UnitMoveData)data;
		
		this.baseMoveState=mData.baseMoveState;
		this.moveType=mData.moveType;
		this.baseMovePos=mData.baseMovePos;
		this.moveList=mData.moveList;
		this.specialMoveID=mData.specialMoveID;
		this.specialMoveArgs=mData.specialMoveArgs;
		this.specialMoveLastTime=mData.specialMoveLastTime;
		this.vehicleInstanceID=mData.vehicleInstanceID;
		this.driveData=mData.driveData;
		this.realMoveDir=mData.realMoveDir;
		this.realMoveSpeedRatio=mData.realMoveSpeedRatio;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof UnitMoveData))
			return;
		
		UnitMoveData mData=(UnitMoveData)data;
		
		this.baseMoveState=mData.baseMoveState;
		
		this.moveType=mData.moveType;
		
		if(mData.baseMovePos!=null)
		{
			this.baseMovePos=new PosData();
			this.baseMovePos.copy(mData.baseMovePos);
		}
		else
		{
			this.baseMovePos=null;
		}
		
		if(mData.moveList!=null)
		{
			if(this.moveList!=null)
			{
				this.moveList.clear();
				this.moveList.ensureCapacity(mData.moveList.size());
			}
			else
			{
				this.moveList=new SList<PosData>(PosData[]::new,mData.moveList.size());
			}
			
			SList<PosData> moveListT=this.moveList;
			if(!mData.moveList.isEmpty())
			{
				Object[] moveListVValues=mData.moveList.getValues();
				for(int moveListVI=0,moveListVLen=mData.moveList.length();moveListVI<moveListVLen;++moveListVI)
				{
					PosData moveListV=(PosData)moveListVValues[moveListVI];
					PosData moveListU;
					if(moveListV!=null)
					{
						moveListU=new PosData();
						moveListU.copy(moveListV);
					}
					else
					{
						moveListU=null;
					}
					
					moveListT.add(moveListU);
				}
			}
		}
		else
		{
			this.moveList=null;
		}
		
		this.specialMoveID=mData.specialMoveID;
		
		if(mData.specialMoveArgs!=null)
		{
			int[] specialMoveArgsR=mData.specialMoveArgs;
			int specialMoveArgsLen=specialMoveArgsR.length;
			if(this.specialMoveArgs==null || this.specialMoveArgs.length!=specialMoveArgsLen)
			{
				this.specialMoveArgs=new int[specialMoveArgsLen];
			}
			BytesControl.arrayCopy(mData.specialMoveArgs,this.specialMoveArgs,specialMoveArgsLen);
		}
		else
		{
			this.specialMoveArgs=null;
		}
		
		this.specialMoveLastTime=mData.specialMoveLastTime;
		
		this.vehicleInstanceID=mData.vehicleInstanceID;
		
		if(mData.driveData!=null)
		{
			this.driveData=(DriveData)mData.driveData.clone();
		}
		else
		{
			this.driveData=null;
		}
		
		if(mData.realMoveDir!=null)
		{
			this.realMoveDir=new DirData();
			this.realMoveDir.copy(mData.realMoveDir);
		}
		else
		{
			this.realMoveDir=null;
		}
		
		this.realMoveSpeedRatio=mData.realMoveSpeedRatio;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		UnitMoveData mData=(UnitMoveData)data;
		if(this.baseMoveState!=mData.baseMoveState)
			return false;
		
		if(this.moveType!=mData.moveType)
			return false;
		
		if(mData.baseMovePos!=null)
		{
			if(this.baseMovePos==null)
				return false;
			if(!this.baseMovePos.dataEquals(mData.baseMovePos))
				return false;
		}
		else
		{
			if(this.baseMovePos!=null)
				return false;
		}
		
		if(mData.moveList!=null)
		{
			if(this.moveList==null)
				return false;
			if(this.moveList.size()!=mData.moveList.size())
				return false;
			SList<PosData> moveListT=this.moveList;
			SList<PosData> moveListR=mData.moveList;
			int moveListLen=moveListT.size();
			for(int moveListI=0;moveListI<moveListLen;++moveListI)
			{
				PosData moveListU=moveListT.get(moveListI);
				PosData moveListV=moveListR.get(moveListI);
				if(moveListV!=null)
				{
					if(moveListU==null)
						return false;
					if(!moveListU.dataEquals(moveListV))
						return false;
				}
				else
				{
					if(moveListU!=null)
						return false;
				}
				
			}
		}
		else
		{
			if(this.moveList!=null)
				return false;
		}
		
		if(this.specialMoveID!=mData.specialMoveID)
			return false;
		
		if(mData.specialMoveArgs!=null)
		{
			if(this.specialMoveArgs==null)
				return false;
			if(this.specialMoveArgs.length!=mData.specialMoveArgs.length)
				return false;
			int[] specialMoveArgsT=this.specialMoveArgs;
			int[] specialMoveArgsR=mData.specialMoveArgs;
			int specialMoveArgsLen=specialMoveArgsT.length;
			for(int specialMoveArgsI=0;specialMoveArgsI<specialMoveArgsLen;++specialMoveArgsI)
			{
				int specialMoveArgsU=specialMoveArgsT[specialMoveArgsI];
				int specialMoveArgsV=specialMoveArgsR[specialMoveArgsI];
				if(specialMoveArgsU!=specialMoveArgsV)
					return false;
				
			}
		}
		else
		{
			if(this.specialMoveArgs!=null)
				return false;
		}
		
		if(this.specialMoveLastTime!=mData.specialMoveLastTime)
			return false;
		
		if(this.vehicleInstanceID!=mData.vehicleInstanceID)
			return false;
		
		if(mData.driveData!=null)
		{
			if(this.driveData==null)
				return false;
			if(!this.driveData.dataEquals(mData.driveData))
				return false;
		}
		else
		{
			if(this.driveData!=null)
				return false;
		}
		
		if(mData.realMoveDir!=null)
		{
			if(this.realMoveDir==null)
				return false;
			if(!this.realMoveDir.dataEquals(mData.realMoveDir))
				return false;
		}
		else
		{
			if(this.realMoveDir!=null)
				return false;
		}
		
		if(this.realMoveSpeedRatio!=mData.realMoveSpeedRatio)
			return false;
		
		return true;
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("baseMoveState");
		writer.sb.append(':');
		writer.sb.append(this.baseMoveState);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("moveType");
		writer.sb.append(':');
		writer.sb.append(this.moveType);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("baseMovePos");
		writer.sb.append(':');
		if(this.baseMovePos!=null)
		{
			this.baseMovePos.writeDataString(writer);
		}
		else
		{
			writer.sb.append("PosData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("moveList");
		writer.sb.append(':');
		writer.sb.append("List<PosData>");
		if(this.moveList!=null)
		{
			SList<PosData> moveListT=this.moveList;
			int moveListLen=moveListT.size();
			writer.sb.append('(');
			writer.sb.append(moveListLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int moveListI=0;moveListI<moveListLen;++moveListI)
			{
				PosData moveListV=moveListT.get(moveListI);
				writer.writeTabs();
				writer.sb.append(moveListI);
				writer.sb.append(':');
				if(moveListV!=null)
				{
					moveListV.writeDataString(writer);
				}
				else
				{
					writer.sb.append("PosData=null");
				}
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("specialMoveID");
		writer.sb.append(':');
		writer.sb.append(this.specialMoveID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("specialMoveArgs");
		writer.sb.append(':');
		writer.sb.append("Array<int>");
		if(this.specialMoveArgs!=null)
		{
			int[] specialMoveArgsT=this.specialMoveArgs;
			int specialMoveArgsLen=specialMoveArgsT.length;
			writer.sb.append('(');
			writer.sb.append(specialMoveArgsLen);
			writer.sb.append(')');
			writer.writeEnter();
			writer.writeLeftBrace();
			for(int specialMoveArgsI=0;specialMoveArgsI<specialMoveArgsLen;++specialMoveArgsI)
			{
				int specialMoveArgsV=specialMoveArgsT[specialMoveArgsI];
				writer.writeTabs();
				writer.sb.append(specialMoveArgsI);
				writer.sb.append(':');
				writer.sb.append(specialMoveArgsV);
				
				writer.writeEnter();
			}
			writer.writeRightBrace();
		}
		else
		{
			writer.sb.append("=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("specialMoveLastTime");
		writer.sb.append(':');
		writer.sb.append(this.specialMoveLastTime);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("vehicleInstanceID");
		writer.sb.append(':');
		writer.sb.append(this.vehicleInstanceID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("driveData");
		writer.sb.append(':');
		if(this.driveData!=null)
		{
			this.driveData.writeDataString(writer);
		}
		else
		{
			writer.sb.append("DriveData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("realMoveDir");
		writer.sb.append(':');
		if(this.realMoveDir!=null)
		{
			this.realMoveDir.writeDataString(writer);
		}
		else
		{
			writer.sb.append("DirData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("realMoveSpeedRatio");
		writer.sb.append(':');
		writer.sb.append(this.realMoveSpeedRatio);
		
		writer.writeEnter();
	}
	
	/** 初始化初值 */
	@Override
	public void initDefault()
	{
		
	}
	
	/** 回池 */
	@Override
	protected void toRelease(DataPool pool)
	{
		this.baseMoveState=0;
		this.moveType=0;
		this.baseMovePos=null;
		this.moveList=null;
		this.specialMoveID=0;
		this.specialMoveArgs=null;
		this.specialMoveLastTime=0;
		this.vehicleInstanceID=0;
		this.driveData=null;
		this.realMoveDir=null;
		this.realMoveSpeedRatio=0;
	}
	
}
