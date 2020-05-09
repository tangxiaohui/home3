package com.home.commonBase.config.game;
import com.home.commonBase.config.base.BaseConfig;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;

/** 玩家群职位表(generated by shine) */
public class RoleGroupTitleConfig extends BaseConfig
{
	/** 存储集合 */
	private static RoleGroupTitleConfig[] _dic;
	
	/** id */
	public int id;
	
	/** 是否可修改群名 */
	public boolean canChangeName;
	
	/** 最多数目 */
	public int num;
	
	/** 是否可处理申请 */
	public boolean canHandleApply;
	
	/** 可任命职位 */
	public int canSetTitle;
	
	/** 是否可修改群公告 */
	public boolean canChangeNotice;
	
	/** 是否可修改申请直接进入 */
	public boolean canChangeApplyInAbs;
	
	/** 可踢出职位 */
	public int canKickTitle;
	
	/** 获取 */
	public static RoleGroupTitleConfig get(int id)
	{
		return id>=0 && id<_dic.length ? _dic[id] : null;
	}
	
	/** 设置字典 */
	public static void setDic(RoleGroupTitleConfig[] dic)
	{
		_dic=dic;
	}
	
	/** 获取全部 */
	public static RoleGroupTitleConfig[] getDic()
	{
		return _dic;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.num=stream.readInt();
		
		this.canChangeName=stream.readBoolean();
		
		this.canChangeNotice=stream.readBoolean();
		
		this.canHandleApply=stream.readBoolean();
		
		this.canSetTitle=stream.readInt();
		
		this.canKickTitle=stream.readInt();
		
		this.canChangeApplyInAbs=stream.readBoolean();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeInt(this.num);
		
		stream.writeBoolean(this.canChangeName);
		
		stream.writeBoolean(this.canChangeNotice);
		
		stream.writeBoolean(this.canHandleApply);
		
		stream.writeInt(this.canSetTitle);
		
		stream.writeInt(this.canKickTitle);
		
		stream.writeBoolean(this.canChangeApplyInAbs);
		
	}
	
	/** 读完所有表后处理 */
	public static void afterReadConfigAll()
	{
		
	}
	
}