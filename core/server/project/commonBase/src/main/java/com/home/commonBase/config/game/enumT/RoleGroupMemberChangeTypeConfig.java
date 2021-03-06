package com.home.commonBase.config.game.enumT;
import com.home.commonBase.config.base.BaseConfig;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;

/** 玩家群数据变更类型(generated by shine) */
public class RoleGroupMemberChangeTypeConfig extends BaseConfig
{
	/** 存储集合 */
	private static RoleGroupMemberChangeTypeConfig[] _dic;
	
	/** id */
	public int id;
	
	/** 是否立即推送客户端 */
	public boolean needSendClientAbs;
	
	/** 获取 */
	public static RoleGroupMemberChangeTypeConfig get(int id)
	{
		return id>=0 && id<_dic.length ? _dic[id] : null;
	}
	
	/** 设置字典 */
	public static void setDic(RoleGroupMemberChangeTypeConfig[] dic)
	{
		_dic=dic;
	}
	
	/** 获取全部 */
	public static RoleGroupMemberChangeTypeConfig[] getDic()
	{
		return _dic;
	}
	
	/** 读取字节流(简版) */
	@Override
	protected void toReadBytesSimple(BytesReadStream stream)
	{
		super.toReadBytesSimple(stream);
		
		this.id=stream.readInt();
		
		this.needSendClientAbs=stream.readBoolean();
		
	}
	
	/** 写入字节流(简版) */
	@Override
	protected void toWriteBytesSimple(BytesWriteStream stream)
	{
		super.toWriteBytesSimple(stream);
		
		stream.writeInt(this.id);
		
		stream.writeBoolean(this.needSendClientAbs);
		
	}
	
	/** 读完所有表后处理 */
	public static void afterReadConfigAll()
	{
		
	}
	
}
