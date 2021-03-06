package com.home.commonBase.data.scene.fight;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.constlist.generate.SkillTargetType;
import com.home.commonBase.data.scene.base.DirData;
import com.home.commonBase.data.scene.base.PosData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;
import com.home.shine.support.DataWriter;
import com.home.shine.support.pool.DataPool;

/** 技能目标数据(generated by shine) */
public class SkillTargetData extends BaseData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.SkillTarget;
	
	/** 目标类型 */
	public int type;
	
	/** 目标流水ID */
	public int targetInstanceID=-1;
	
	/** 目标朝向 */
	public DirData dir;
	
	/** 携带参数 */
	public int arg;
	
	/** 目标位置 */
	public PosData pos;
	
	public SkillTargetData()
	{
		_dataID=BaseDataType.SkillTarget;
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		stream.startReadObj();
		
		this.type=stream.readInt();
		
		this.targetInstanceID=stream.readInt();
		
		if(stream.readBoolean())
		{
			this.pos=new PosData();
			this.pos.readBytesFull(stream);
		}
		else
		{
			this.pos=null;
		}
		
		if(stream.readBoolean())
		{
			this.dir=new DirData();
			this.dir.readBytesFull(stream);
		}
		else
		{
			this.dir=null;
		}
		
		this.arg=stream.readInt();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		stream.startWriteObj();
		
		stream.writeInt(this.type);
		
		stream.writeInt(this.targetInstanceID);
		
		if(this.pos!=null)
		{
			stream.writeBoolean(true);
			this.pos.writeBytesFull(stream);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.dir!=null)
		{
			stream.writeBoolean(true);
			this.dir.writeBytesFull(stream);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeInt(this.arg);
		
		stream.endWriteObj();
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		this.type=stream.readInt();
		
		this.targetInstanceID=stream.readInt();
		
		if(stream.readBoolean())
		{
			this.pos=new PosData();
			this.pos.readBytesSimple(stream);
		}
		else
		{
			this.pos=null;
		}
		
		if(stream.readBoolean())
		{
			this.dir=new DirData();
			this.dir.readBytesSimple(stream);
		}
		else
		{
			this.dir=null;
		}
		
		this.arg=stream.readInt();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		stream.writeInt(this.type);
		
		stream.writeInt(this.targetInstanceID);
		
		if(this.pos!=null)
		{
			stream.writeBoolean(true);
			this.pos.writeBytesSimple(stream);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		if(this.dir!=null)
		{
			stream.writeBoolean(true);
			this.dir.writeBytesSimple(stream);
		}
		else
		{
			stream.writeBoolean(false);
		}
		
		stream.writeInt(this.arg);
		
	}
	
	/** 复制(潜拷贝) */
	@Override
	protected void toShadowCopy(BaseData data)
	{
		if(!(data instanceof SkillTargetData))
			return;
		
		SkillTargetData mData=(SkillTargetData)data;
		
		this.type=mData.type;
		this.targetInstanceID=mData.targetInstanceID;
		this.pos=mData.pos;
		this.dir=mData.dir;
		this.arg=mData.arg;
	}
	
	/** 复制(深拷贝) */
	@Override
	protected void toCopy(BaseData data)
	{
		if(!(data instanceof SkillTargetData))
			return;
		
		SkillTargetData mData=(SkillTargetData)data;
		
		this.type=mData.type;
		
		this.targetInstanceID=mData.targetInstanceID;
		
		if(mData.pos!=null)
		{
			this.pos=new PosData();
			this.pos.copy(mData.pos);
		}
		else
		{
			this.pos=null;
		}
		
		if(mData.dir!=null)
		{
			this.dir=new DirData();
			this.dir.copy(mData.dir);
		}
		else
		{
			this.dir=null;
		}
		
		this.arg=mData.arg;
		
	}
	
	/** 是否数据一致 */
	@Override
	protected boolean toDataEquals(BaseData data)
	{
		SkillTargetData mData=(SkillTargetData)data;
		if(this.type!=mData.type)
			return false;
		
		if(this.targetInstanceID!=mData.targetInstanceID)
			return false;
		
		if(mData.pos!=null)
		{
			if(this.pos==null)
				return false;
			if(!this.pos.dataEquals(mData.pos))
				return false;
		}
		else
		{
			if(this.pos!=null)
				return false;
		}
		
		if(mData.dir!=null)
		{
			if(this.dir==null)
				return false;
			if(!this.dir.dataEquals(mData.dir))
				return false;
		}
		else
		{
			if(this.dir!=null)
				return false;
		}
		
		if(this.arg!=mData.arg)
			return false;
		
		return true;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "SkillTargetData";
	}
	
	/** 转文本输出 */
	@Override
	protected void toWriteDataString(DataWriter writer)
	{
		writer.writeTabs();
		writer.sb.append("type");
		writer.sb.append(':');
		writer.sb.append(this.type);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("targetInstanceID");
		writer.sb.append(':');
		writer.sb.append(this.targetInstanceID);
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("pos");
		writer.sb.append(':');
		if(this.pos!=null)
		{
			this.pos.writeDataString(writer);
		}
		else
		{
			writer.sb.append("PosData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("dir");
		writer.sb.append(':');
		if(this.dir!=null)
		{
			this.dir.writeDataString(writer);
		}
		else
		{
			writer.sb.append("DirData=null");
		}
		
		writer.writeEnter();
		writer.writeTabs();
		writer.sb.append("arg");
		writer.sb.append(':');
		writer.sb.append(this.arg);
		
		writer.writeEnter();
	}
	
	/** 判断两个目标是否相等 */
	public boolean isEquals(SkillTargetData data)
	{
		int t;
		
		if((t=type)!=data.type)
		{
			return false;
		}
		
		switch(t)
		{
			case SkillTargetType.Single:
			{
				return targetInstanceID==data.targetInstanceID;
			}
			case SkillTargetType.Ground:
			{
				return pos.isEquals(data.pos);
			}
			case SkillTargetType.Direction:
			{
				return dir.isEquals(data.dir);
			}
		}
		
		return true;
	}
	
	/** 通过目标流水ID创建(单体类型) */
	public static SkillTargetData createByTargetUnit(int instanceID)
	{
		SkillTargetData re=new SkillTargetData();
		re.type=SkillTargetType.Single;
		re.targetInstanceID=instanceID;
		return re;
	}
	
	/** 通过空目标创建 */
	public static SkillTargetData createByNone()
	{
		SkillTargetData re=new SkillTargetData();
		re.type=SkillTargetType.None;
		return re;
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
		this.type=0;
		this.targetInstanceID=0;
		this.pos=null;
		this.dir=null;
		this.arg=0;
	}
	
}
