package com.home.commonCenter.part.centerGlobal.part;
import com.home.commonBase.config.game.MailConfig;
import com.home.commonBase.config.game.RewardConfig;
import com.home.commonBase.data.item.ItemData;
import com.home.commonBase.data.mail.MailData;
import com.home.commonBase.global.BaseC;
import com.home.commonBase.part.centerGlobal.data.CenterMailPartData;
import com.home.commonCenter.global.CenterC;
import com.home.commonCenter.net.serverRequest.game.mail.SendMailToGameServerRequest;
import com.home.commonCenter.part.centerGlobal.base.CenterGlobalBasePart;
import com.home.shine.data.BaseData;
import com.home.shine.data.DIntData;
import com.home.shine.support.collection.SList;

/** 邮件数据(generated by shine) */
public class CenterMailPart extends CenterGlobalBasePart
{
	/** 数据 */
	private CenterMailPartData _d;
	
	/** 邮件序号 */
	private int _mailIndex;
	
	@Override
	public void setData(BaseData data)
	{
		super.setData(data);
		
		_d=(CenterMailPartData)data;
	}
	
	/** 获取数据 */
	public CenterMailPartData getPartData()
	{
		return _d;
	}
	
	@Override
	protected BaseData createPartData()
	{
		return new CenterMailPartData();
	}
	
	/** 构造函数(只在new后调用一次,再次从池中取出不会调用) */
	@Override
	public void construct()
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
		_mailIndex=_d.mails.isEmpty() ? 0 : _d.mails.get(_d.mails.size()-1).instanceID;
	}
	
	/** 新创建时(该主对象在服务器上第一次被创建时的动作(一生只一次),(只对数据赋值就好,自定义数据构造的部分写到afterReadData里,因为这个完事儿就会回调到)) */
	@Override
	public void onNewCreate()
	{
		
	}
	
	/** 构造数据前 */
	@Override
	protected void beforeMakeData()
	{
		
	}
	
	/** 添加邮件 */
	public void addMail(int id,String[] args,int itemID,int num)
	{
		addMail(id,args,new DIntData[]{DIntData.create(itemID,num)});
	}
	
	/** 添加邮件 */
	public void addMail(int id,String[] args,DIntData[] items)
	{
		MailConfig config=MailConfig.get(id);
		
		MailData data=BaseC.logic.createMailData(config.type);
		
		data.id=id;
		data.args=args;
		data.time=me.getTimeMillis();
		
		if(items!=null)
		{
			data.itemList=new SList<>();
			
			for(DIntData v:items)
			{
				data.itemList.add(BaseC.logic.createItem(v,me));
			}
		}
		
		//TODO:后面考虑换简版邮件
		
		addMail(data);
	}
	
	/** 添加邮键 */
	public void addMail(MailData data)
	{
		data.instanceID=++_mailIndex;
		
		//_d.mails.add(data);
		
		//目前直接广播到每个区服下
		CenterC.server.radioGames(SendMailToGameServerRequest.create(data));
	}
	
	/** 添加邮件GM指令 */
	public void addMailByGM(int id,SList<ItemData> list,String title,String content,String platform)
	{
		MailConfig config=MailConfig.get(id);
		
		MailData data=BaseC.logic.createMailData(config.type);
		
		data.id=id;
		
		String[] args=new String[2];
		args[0]=title;
		args[1]=content;
		
		data.args=args;
		data.time=me.getTimeMillis();
		data.itemList=list;
		data.platform=platform;
		addMail(data);
	}
	
	/** 为离线事务用 */
	public MailData createPlayerMailWithOffline(int id)
	{
		MailConfig config=MailConfig.get(id);
		MailData data=BaseC.logic.createMailData(config.type);
		data.id=id;
		return data;
	}
	
}