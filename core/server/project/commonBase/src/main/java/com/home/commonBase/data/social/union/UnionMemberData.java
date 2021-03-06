package com.home.commonBase.data.social.union;
import com.home.commonBase.constlist.generate.BaseDataType;
import com.home.commonBase.data.social.roleGroup.RoleGroupMemberData;
import com.home.shine.bytes.BytesReadStream;
import com.home.shine.bytes.BytesWriteStream;
import com.home.shine.data.BaseData;

/** 工会成员数据(generated by shine) */
public class UnionMemberData extends RoleGroupMemberData
{
	/** 数据类型ID */
	public static final int dataID=BaseDataType.UnionMember;
	
	public UnionMemberData()
	{
		_dataID=BaseDataType.UnionMember;
	}
	
	/** 获取数据类名 */
	@Override
	public String getDataClassName()
	{
		return "UnionMemberData";
	}
	
	/** 读取字节流(完整版) */
	@Override
	protected void toReadBytesFull(BytesReadStream stream)
	{
		super.toReadBytesFull(stream);
		
		stream.startReadObj();
		
		stream.endReadObj();
	}
	
	/** 写入字节流(完整版) */
	@Override
	protected void toWriteBytesFull(BytesWriteStream stream)
	{
		super.toWriteBytesFull(stream);
		
		stream.startWriteObj();
		
		stream.endWriteObj();
	}
	
}
