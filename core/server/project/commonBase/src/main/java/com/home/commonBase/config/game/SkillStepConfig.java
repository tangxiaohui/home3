package com.home.commonBase.config.game;
import com.home.commonBase.config.base.BaseConfig;
import com.home.commonBase.constlist.generate.SkillStepSwitchType;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.DIntData;
import com.home.shine.support.collection.LongObjectMap;
import com.home.shine.support.collection.SMap;

/** 技能步骤表(generated by shine) */
public class SkillStepConfig extends BaseConfig
{
	/** 存储集合 */
	private static LongObjectMap<SkillStepConfig> _dic;
	
	/** 技能id */
	public int id;
	
	/** 步骤 */
	public int step;
	
	/** 攻击组 */
	public DIntData[] attacks;
	
	/** 步骤时间(ms) */
	public int time;
	
	/** 子弹组 */
	public DIntData[] bullets;
	
	/** 是否滞空(对于空中动作) */
	public boolean isStayAir;
	
	/** 切换方式 */
	public int[] switchType;
	
	/** 获取 */
	public static SkillStepConfig get(int id,int step)
	{
		return _dic.get((long)id << 8 | (long)step);
	}
	
	/** 设置字典 */
	public static void setDic(LongObjectMap<SkillStepConfig> dic)
	{
		_dic=dic;
	}
	
	/** 获取全部 */
	public static LongObjectMap<SkillStepConfig> getDic()
	{
		return _dic;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.step=stream.readByte();
		
		int attacksLen=stream.readLen();
		if(this.attacks==null || this.attacks.length!=attacksLen)
		{
			this.attacks=new DIntData[attacksLen];
		}
		DIntData[] attacksT=this.attacks;
		for(int attacksI=0;attacksI<attacksLen;++attacksI)
		{
			DIntData attacksV;
			attacksV=new DIntData();
			attacksV.readBytesSimple(stream);
			
			attacksT[attacksI]=attacksV;
		}
		
		int bulletsLen=stream.readLen();
		if(this.bullets==null || this.bullets.length!=bulletsLen)
		{
			this.bullets=new DIntData[bulletsLen];
		}
		DIntData[] bulletsT=this.bullets;
		for(int bulletsI=0;bulletsI<bulletsLen;++bulletsI)
		{
			DIntData bulletsV;
			bulletsV=new DIntData();
			bulletsV.readBytesSimple(stream);
			
			bulletsT[bulletsI]=bulletsV;
		}
		
		this.time=stream.readInt();
		
		int switchTypeLen=stream.readLen();
		if(this.switchType==null || this.switchType.length!=switchTypeLen)
		{
			this.switchType=new int[switchTypeLen];
		}
		int[] switchTypeT=this.switchType;
		for(int switchTypeI=0;switchTypeI<switchTypeLen;++switchTypeI)
		{
			int switchTypeV;
			switchTypeV=stream.readInt();
			
			switchTypeT[switchTypeI]=switchTypeV;
		}
		
		this.isStayAir=stream.readBoolean();
		
	}
	
	/** 读完所有表后处理 */
	public static void afterReadConfigAll()
	{
		if(_dic==null)
			return;
		
		SkillStepConfig[] values;
		SkillStepConfig v;
		
		for(int i=(values=_dic.getValues()).length-1;i>=0;--i)
		{
			if((v=values[i])!=null)
			{
				//空的
				if(v.switchType==null || v.switchType.length==0)
				{
					//有下一个
					if(get(v.id,v.step+1)!=null)
					{
						v.switchType=new int[]{SkillStepSwitchType.Auto,v.step+1};
					}
					else
					{
						if(v.switchType==null)
						{
							v.switchType=new int[0];
						}
					}
				}
			}
		}
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeByte(this.step);
		
		if(this.attacks!=null)
		{
			DIntData[] attacksT=this.attacks;
			stream.writeLen(attacksT.length);
			for(int attacksVI=0,attacksVLen=attacksT.length;attacksVI<attacksVLen;++attacksVI)
			{
				DIntData attacksV=attacksT[attacksVI];
				if(attacksV!=null)
				{
					attacksV.writeBytesSimple(stream);
				}
				else
				{
					nullObjError("attacksV");
				}
				
			}
		}
		else
		{
			nullObjError("attacks");
		}
		
		if(this.bullets!=null)
		{
			DIntData[] bulletsT=this.bullets;
			stream.writeLen(bulletsT.length);
			for(int bulletsVI=0,bulletsVLen=bulletsT.length;bulletsVI<bulletsVLen;++bulletsVI)
			{
				DIntData bulletsV=bulletsT[bulletsVI];
				if(bulletsV!=null)
				{
					bulletsV.writeBytesSimple(stream);
				}
				else
				{
					nullObjError("bulletsV");
				}
				
			}
		}
		else
		{
			nullObjError("bullets");
		}
		
		stream.writeInt(this.time);
		
		if(this.switchType!=null)
		{
			int[] switchTypeT=this.switchType;
			stream.writeLen(switchTypeT.length);
			for(int switchTypeVI=0,switchTypeVLen=switchTypeT.length;switchTypeVI<switchTypeVLen;++switchTypeVI)
			{
				int switchTypeV=switchTypeT[switchTypeVI];
				stream.writeInt(switchTypeV);
				
			}
		}
		else
		{
			nullObjError("switchType");
		}
		
		stream.writeBoolean(this.isStayAir);
		
	}
	
}