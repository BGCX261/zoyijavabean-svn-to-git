package org.zoyi.service;

import java.util.Date;
import java.util.List;

import org.zoyi.vo.*;

public interface BenifitActivityService extends Base<BenifitActivity> {
	public int getCount() throws Exception;

	public List<Object> queryByPage(int startRow, int pageSize)
			throws Exception;

	public List<Object> queryByGroupId(int startRow, int pageSize, int id)
			throws Exception;

	public String quit(int id, int baid) throws Exception;

	public List<Object> queryBySoft(int startRow, int pageSize)
			throws Exception;

	public String refuseUser(int id, int baid) throws Exception;

	public String acceptUser(int id, int baid) throws Exception;

	public List<Object> queryByUserId(int startRow, int pageSize, int userid)
			throws Exception;

	public int getCountByUserId(int userid) throws Exception;

	public List<Object> queryUserByBAId(int startRow, int pageSize, int baid)
			throws Exception;

	public int getUserCountByBAId(int baid) throws Exception;

	public List<Object> queryUserByStatusBAId(int startRow, int pageSize,
			int baid, int status) throws Exception;

	public int getUserCountByStatusBAId(int baid, int status) throws Exception;

	public int getActivityCountByUserIdStatus(int userId, short status)
			throws Exception;

	public List<Object> queryActivityByUserIdStatus(int startRow, int pageSize,
			int userId, short status) throws Exception;

	public int getCountByGroupId(int groupid) throws Exception;

	public List<Object> queryUserByBAIdGroupId(int startRow, int pageSize,
			int groupId, int baid) throws Exception;

	public int getUserCountByBAIdGroupId(int groupId, int baid)
			throws Exception;

	public List<Object> queryUserByBAIdGroupIdStatus(int startRow,
			int pageSize, int groupId, int baid, int status) throws Exception;

	public int getUserCountByBAIdGroupIdStatus(int groupId, int baid, int status)
			throws Exception;

	public String isBAIdBelongtoGroupId(int baid, int groupid) throws Exception;// 判断相应baid的活动是不是groupid组织举办的，是返回success,否返回fail

	public List<Object> queryByEndtime(int startRow, int pageSize,
			Date endtime, int status) throws Exception;// status为0则调用queryByPage,status为1则查找endtime以前的，status为2则查找endtime以后的

	public int getCountByEndtime(Date endtime, int status) throws Exception;

	public String addUserCredit(int credit, int darkmind, int userId, int baid)
			throws Exception;

	public String addAllUserCreditByBAId(int credit, int darkmind, int baid)
			throws Exception;
}