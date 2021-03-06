package com.home.commonClient.part.player.part;
import com.home.commonBase.constlist.generate.GameEventType;
import com.home.commonBase.data.social.RoleSocialData;
import com.home.commonBase.global.BaseC;
import com.home.commonBase.part.player.clientData.SocialClientPartData;
import com.home.commonClient.net.request.social.UpdateRoleSocialDataRequest;
import com.home.commonClient.part.player.base.PlayerBasePart;
import com.home.shine.data.BaseData;
import com.home.shine.support.collection.LongObjectMap;

/** 社交(generated by shine) */
public class SocialPart extends PlayerBasePart
{
	/** 数据 */
	private SocialClientPartData _d;
	
	/** 角色社交数据(自己需要的所有角色社交数据)(不存库) */
	private LongObjectMap<RoleSocialData> _roleSocialDic=new LongObjectMap<>(k->new RoleSocialData[k]);
	
	@Override
	public void setData(BaseData data)
	{
		super.setData(data);
		
		_d=(SocialClientPartData)data;
	}
	
	/** 获取数据 */
	public SocialClientPartData getPartData()
	{
		return _d;
	}
	
	/** 构造函数(只在new后调用一次,再次从池中取出不会调用) */
	@Override
	public void construct()
	{
		
	}
	
	/** 构造数据前 */
	@Override
	protected void beforeMakeData()
	{
		
	}
	
	/** 初始化(创建后刚调用,与dispose成对) */
	@Override
	public void init()
	{
		
	}
	
	/** 析构(回池前调用,与init成对) */
	@Override
	public void dispose()
	{
		
	}
	
	/** 从库中读完数据后(做数据的补充解析)(onNewCreate后也会调用一次)(主线程) */
	@Override
	public void afterReadData()
	{
		
	}
	
	/** 功能开启(id:功能ID) */
	@Override
	public void onFunctionOpen(int id)
	{
		
	}
	
	/** 功能关闭(id:功能ID) */
	@Override
	public void onFunctionClose(int id)
	{
		
	}
	
	/** 创建角色社交数据 */
	public RoleSocialData createRoleSocialData()
	{
		RoleSocialData re= BaseC.factory.createRoleSocialData();
		makeRoleSocialData(re);
		return re;
	}
	
	/** 构造角色社交数据 */
	public void makeRoleSocialData(RoleSocialData data)
	{
		if(data.showData!=null)
		{
			me.role.makeRoleShowData(data.showData);
		}
		else
		{
			data.showData=me.role.createRoleShowData();
		}
		
		data.isOnline=true;
		
		data.lastOnlineTime=me.getTimeSeconds();
	}
	
	/** 添加角色社交数据 */
	public RoleSocialData addPlayerRoleSocial(long playerID,RoleSocialData data)
	{
		RoleSocialData oldData;
		
		if((oldData=_roleSocialDic.get(playerID))!=null)
		{
			oldData.copy(data);
			return oldData;
		}
		else
		{
			_roleSocialDic.put(playerID,data);
			return data;
		}
	}
	
	/** 移除角色社交数据 */
	public void removePlayerRoleSocial(long playerID)
	{
		_roleSocialDic.remove(playerID);
	}
	
	/** 更新全部社交数据组(客户端调用) */
	public void updateRoleSocialDatas()
	{
		me.send(new UpdateRoleSocialDataRequest());
	}
	
	/** 更新社交数据组返回 */
	public void onUpdateRoleSocialDatas(LongObjectMap<RoleSocialData> dic)
	{
		if(!dic.isEmpty())
		{
			long[] keys=dic.getKeys();
			RoleSocialData[] values=dic.getValues();
			long fv=dic.getFreeValue();
			long k;
			RoleSocialData v;
			
			for(int i=keys.length-1;i>=0;--i)
			{
				if((k=keys[i])!=fv)
				{
					v=values[i];
					
					addPlayerRoleSocial(k,v);
				}
			}
			
			me.dispatch(GameEventType.UpdateSocialData);
		}
	}
	
	@Override
	protected BaseData createPartData()
	{
		return new SocialClientPartData();
	}
	
}
