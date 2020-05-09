using ShineEngine;
using System.Text;

/// <summary>
/// 邮件(generated by shine)
/// </summary>
public class MailPart:PlayerBasePart
{
	/** 数据 */
	private MailPartData _d;
	
	/** 邮件组 */
	private SList<MailData> _mails;
	
	/** 新邮件数目 */
	private int _newNum=0;
	
	/** 红点数 */
	private int _redPointCount=0;
	
	/** 是否获取过邮件列表 */
	private bool _gotMails=false;
	
	public override void setData(BaseData data)
	{
		base.setData(data);
		
		_d=(MailPartData)data;
	}
	
	/// <summary>
	/// 获取数据
	/// </summary>
	public MailPartData getPartData()
	{
		return _d;
	}
	
	/// <summary>
	/// 构造函数(只在new后调用一次,再次从池中取出不会调用)
	/// </summary>
	public override void construct()
	{
		
	}
	
	/// <summary>
	/// 构造数据前
	/// </summary>
	protected override void beforeMakeData()
	{
		
	}
	
	/// <summary>
	/// 初始化(创建后刚调用,与dispose成对)
	/// </summary>
	public override void init()
	{
		
	}
	
	/// <summary>
	/// 析构(回池前调用,与init成对)
	/// </summary>
	public override void dispose()
	{
		
	}
	
	/// <summary>
	/// 从库中读完数据后(做数据的补充解析)(onNewCreate后也会调用一次)(主线程)
	/// </summary>
	public override void afterReadData()
	{
		_gotMails = false;
	}
	
	/// <summary>
	/// 功能开启(id:功能ID)
	/// </summary>
	public override void onFunctionOpen(int id)
	{
		
	}
	
	/// <summary>
	/// 功能关闭(id:功能ID)
	/// </summary>
	public override void onFunctionClose(int id)
	{

	}
	
	/// <summary>
	/// 是否为空
	/// </summary>
	public bool isEmpty()
	{
		return _mails==null || _mails.isEmpty();
	}
	
	/// <summary>
	/// 获取邮件列表(空为未收到服务器返回)
	/// </summary>
	public SList<MailData> getMailList()
	{
		return _mails;
	}
	
	/// <summary>
	/// 获取全部邮件内容
	/// </summary>
	public void getAllMails()
	{
		if(_gotMails)
			return;

		_gotMails=true;

		GetAllMailRequest.create().send();
	}
	
	/// <summary>
	/// 获取新邮件数目
	/// </summary>
	public int getNewNum()
	{
		return _newNum;
	}
	
	/** 删除邮件 */
	private void toDeleteMail(int index)
	{
		if(_mails==null)
		{
			me.warnLog("删除邮件时,没有邮件列表");
			return;
		}

		MailData data=_mails.remove(index);

		if(data==null)
			return;

		toRemoveRedPoint(data);

		if(!data.readed)
		{
			_newNum--;
			me.dispatch(GameEventType.RefreshNewMailNum);
		}

		MailData[] values=_mails.getValues();

		for(int i=index,len=_mails.size();i<len;i++)
		{
			values[i].index=i;
		}

		me.dispatch(GameEventType.DeleteOneMail,index);
	}
	
	private void toRemoveRedPoint(MailData data)
	{
		if(data.hasRedPoint)
		{
			data.hasRedPoint=false;
			_redPointCount--;
			GameC.redPoint.refreshOne(RedPointType.Mail);
		}
	}
	
	/// <summary>
	/// 标记某邮件已读
	/// </summary>
	public void mailReaded(int index)
	{
		MailData data=_mails.get(index);

		if(data==null)
		{
			me.warnLog("标记某邮件已读时,找不到邮件");
			return;
		}

		if(data.readed)
		{
			me.warnLog("标记某邮件已读时,邮件已读");
			return;
		}

		toRemoveRedPoint(data);

		data.readed=true;
		_newNum--;
		me.dispatch(GameEventType.RefreshNewMailNum);
		me.dispatch(GameEventType.RefreshOneMail,index);

		MailReadedRequest.create(index,data.instanceID).send();
	}
	
	/// <summary>
	/// 邮件移除红点
	/// </summary>
	public void mailRemoveRedPoint(int index)
	{
		MailData data=_mails.get(index);

		if(data==null)
		{
			me.warnLog("邮件移除红点时,找不到邮件");
			return;
		}

		if(!data.hasRedPoint)
		{
			me.warnLog("邮件移除红点时,没有红点");
			return;
		}

		toRemoveRedPoint(data);

		me.dispatch(GameEventType.RefreshOneMail,index);

		me.send(MailRemoveRedPointRequest.create(index));
	}
	
	/// <summary>
	/// 领取邮件
	/// </summary>
	public void takeMail(int index)
	{
		MailData data=_mails.get(index);

		if(data==null)
		{
			me.warnLog("领取邮件时,找不到邮件");
			return;
		}

		if (data.rewarded || data.itemList==null)
		{
			me.warnLog("领取邮件时,已经领取过或者没有奖励");
			return;
		}
		
		toRemoveRedPoint(data);

		if(!data.readed)
		{
			data.readed=true;
			_newNum--;
			me.dispatch(GameEventType.RefreshNewMailNum);
			me.dispatch(GameEventType.RefreshOneMail,index);
		}

		TakeMailRequest.create(index,data.instanceID).send();
	}
	
	/// <summary>
	/// 删除邮件
	/// </summary>
	public void deleteMail(int index)
	{
		MailData data=_mails.get(index);

		if(data==null)
		{
			me.warnLog("删除邮件时,找不到邮件");
			return;
		}

		DeleteMailRequest.create(index,data.instanceID).send();
	}
	
	/// <summary>
	/// 发送邮件
	/// </summary>
	public void sendMail(long playerID,MailData data)
	{
		me.send(ClientSendMailRequest.create(playerID,data));
	}
	
	/// <summary>
	/// 客户端主动发送邮件
	/// </summary>
	public void sendMail(long playerID,string[] args)
	{
		MailData data=new MailData();
		data.id=Global.playerMailID;
		data.args=args;
		data.itemList=null;

		sendMail(playerID,data);
	}
	
	/// <summary>
	/// 获取邮件内容
	/// </summary>
	public void onReGetAllMails(SList<MailData> mails)
	{
		_mails=mails;//直接赋值
		_newNum=0;
		_redPointCount=0;

		MailData[] values=mails.getValues();
		MailData v;

		//刷序号
		for(int i=0,len=mails.size();i<len;++i)
		{
			(v=values[i]).index=i;

			if(!v.readed)
			{
				_newNum++;
			}

			if(v.hasRedPoint)
			{
				_redPointCount++;
			}
		}

		me.dispatch(GameEventType.RefreshAllMails);

		GameC.redPoint.refreshOne(RedPointType.Mail);
	}
	
	/// <summary>
	/// 添加邮件
	/// </summary>
	public void onAddMail(MailData data)
	{
		if(_mails==null)
		{
			_newNum++;
			me.dispatch(GameEventType.RefreshNewMailNum);

			return;
		}

		//超了
		if(Global.mailSaveMaxNum>0 && _mails.size()==Global.mailSaveMaxNum)
		{
			toDeleteMail(0);
		}

		_mails.add(data);
		data.index=_mails.size()-1;//序号

		_newNum++;
		me.dispatch(GameEventType.RefreshNewMailNum);

		if(MailConfig.get(data.id).needRedPoint)
		{
			data.hasRedPoint=true;
			_redPointCount++;
			GameC.redPoint.refreshOne(RedPointType.Mail);
		}
		else
		{
			data.hasRedPoint=false;
		}

		me.dispatch(GameEventType.AddNewMail,_mails.size()-1);
		
		onAddMailForG(data);
	}
	
	/// <summary>
	/// 添加邮件
	/// </summary>
	public virtual void onAddMailForG(MailData data)
	{
		
	}
	
	/// <summary>
	/// 删除邮件
	/// </summary>
	public void onDeleteMail(int index)
	{
		toDeleteMail(index);
	}
	
	/// <summary>
	/// 领取邮件成功
	/// </summary>
	public void onTakeMail(int index)
	{
		if(_mails==null)
		{
			me.warnLog("领取邮件成功时,没有邮件列表");
			return;
		}

		MailData data=_mails.get(index);

		if(data==null)
		{
			me.warnLog("领取邮件成功时,找不到邮件");
			return;
		}

		data.rewarded = true;
		me.dispatch(GameEventType.RewardOneMail,index);
		if(!data.readed)
		{
			data.readed=true;
			
			_newNum--;
			me.dispatch(GameEventType.RefreshNewMailNum);
		}

		me.dispatch(GameEventType.RefreshOneMail,index);
	}
	
	/// <summary>
	/// 获取红点数
	/// </summary>
	public int getRedPointCount()
	{
		return _redPointCount;
	}
	
	/// <summary>
	/// 输出邮件组
	/// </summary>
	public void printMails()
	{
		if(isEmpty())
		{
			Ctrl.print("mail is empty");
			return;
		}

		ObjectUtils.printDataList(_mails);
	}
	
	protected override BaseData createPartData()
	{
		return new MailPartData();
	}
	
}