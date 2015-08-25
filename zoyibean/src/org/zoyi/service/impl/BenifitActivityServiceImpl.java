package org.zoyi.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zoyi.adapter.BenifitActivityAdapter;
import org.zoyi.hibernate.BenifitActivityDAO;
import org.zoyi.hibernate.UserInfoDAO;
import org.zoyi.service.BenifitActivityService;
import org.zoyi.vo.BenifitActivity;

public class BenifitActivityServiceImpl implements BenifitActivityService {

	public BenifitActivityServiceImpl() {

	}

	@Override
	public int getCount() throws Exception {
		return new BenifitActivityDAO().getCount();
	}

	@Override
	public List<Object> queryByPage(int startRow, int pageSize)
			throws Exception {
		return new BenifitActivityDAO().queryByPage(startRow, pageSize);
	}

	@Override
	public String add(BenifitActivity t) throws Exception {
		return null;
	}

	@Override
	public String delete(List<Integer> id) throws Exception {
		return null;
	}

	@Override
	public String deleteById(int id) throws Exception {
		return null;
	}

	@Override
	public String isExist(BenifitActivity t) throws Exception {
		return null;
	}

	@Override
	public String isExist(int id) throws Exception {
		return null;
	}

	@Override
	public String modify(BenifitActivity t) throws Exception {
		return null;
	}

	@Override
	public BenifitActivity queryById(int id) throws Exception {
		return BenifitActivityAdapter.toVo(new BenifitActivityDAO().get(id));
	}

	@Override
	public List<Object> queryByGroupId(int startRow, int pageSize, int id)
			throws Exception {
		return new BenifitActivityDAO().queryByGroupId(startRow, pageSize, id);
	}

	@Override
	public List<Object> queryBySoft(int startRow, int pageSize)
			throws Exception {
		return new BenifitActivityDAO().queryBySoft(startRow, pageSize);
	}

	@Override
	public int getUserCountByBAId(int baid) throws Exception {
		return new BenifitActivityDAO().getUserCountByBAId(baid);
	}

	@Override
	public int getUserCountByStatusBAId(int baid, int status) throws Exception {
		return new BenifitActivityDAO().getUserCountByStatusBAId(baid, status);
	}

	@Override
	public List<Object> queryByUserId(int startRow, int pageSize, int userid)
			throws Exception {
		return new BenifitActivityDAO().queryByUserId(startRow, pageSize,
				userid);
	}

	@Override
	public List<Object> queryUserByBAId(int startRow, int pageSize, int baid)
			throws Exception {
		return new BenifitActivityDAO().queryUserByBAId(startRow, pageSize,
				baid);
	}

	@Override
	public List<Object> queryUserByStatusBAId(int startRow, int pageSize,
			int baid, int status) throws Exception {
		return new BenifitActivityDAO().queryUserByStatusBAId(startRow,
				pageSize, baid, status);
	}

	@Override
	public int getActivityCountByUserIdStatus(int userId, short status)
			throws Exception {
		return new BenifitActivityDAO().getActivityCountByUserIdStatus(userId,
				status);
	}

	@Override
	public List<Object> queryActivityByUserIdStatus(int startRow, int pageSize,
			int userId, short status) throws Exception {
		return new BenifitActivityDAO().queryActivityByUserIdStatus(startRow,
				pageSize, userId, status);
	}

	@Override
	public int getCountByUserId(int userid) throws Exception {
		return new BenifitActivityDAO().getCountByUserId(userid);
	}

	@Override
	public int getCountByGroupId(int groupid) throws Exception {
		return new BenifitActivityDAO().getCountByGroupId(groupid);
	}

	@Override
	public int getUserCountByBAIdGroupId(int groupId, int baid)
			throws Exception {
		if ("success".equals(this.isBAIdBelongtoGroupId(baid, groupId)))
			return this.getUserCountByBAId(baid);
		else
			return 0;
	}

	@Override
	public int getUserCountByBAIdGroupIdStatus(int groupId, int baid, int status)
			throws Exception {
		if ("success".equals(this.isBAIdBelongtoGroupId(baid, groupId)))
			return this.getUserCountByStatusBAId(baid, status);
		else
			return 0;
	}

	@Override
	public String isBAIdBelongtoGroupId(int baid, int groupid) throws Exception {
		return new BenifitActivityDAO().isBAIdBelongtoGroupId(baid, groupid);
	}

	@Override
	public List<Object> queryUserByBAIdGroupId(int startRow, int pageSize,
			int groupId, int baid) throws Exception {
		if ("success".equals(this.isBAIdBelongtoGroupId(baid, groupId)))
			return this.queryUserByBAId(startRow, pageSize, baid);
		else
			return new ArrayList<Object>();
	}

	@Override
	public List<Object> queryUserByBAIdGroupIdStatus(int startRow,
			int pageSize, int groupId, int baid, int status) throws Exception {
		if ("success".equals(this.isBAIdBelongtoGroupId(baid, groupId)))
			return this.queryUserByStatusBAId(startRow, pageSize, baid, status);
		else
			return new ArrayList<Object>();
	}

	@Override
	public String acceptUser(int id, int baid) throws Exception {
		return null;
	}

	@Override
	public List<Object> queryByEndtime(int startRow, int pageSize,
			Date endtime, int status) throws Exception {
		return new BenifitActivityDAO().queryByEndtime(startRow, pageSize, endtime, status);
	}

	@Override
	public String quit(int id, int baid) throws Exception {
		return null;
	}

	@Override
	public String refuseUser(int id, int baid) throws Exception {
		return null;
	}

	@Override
	public int getCountByEndtime(Date endtime, int status) throws Exception {
		return new BenifitActivityDAO().getCountByEndtime(endtime, status);
	}

	@Override
	public String addUserCredit(int credit,int darkmind, int userId, int baid)
			throws Exception {
		return new BenifitActivityDAO().addUserCredit(credit, darkmind, userId, baid);
	}

	@Override
	public String addAllUserCreditByBAId(int credit, int darkmind, int baid)
			throws Exception {
		return new BenifitActivityDAO().addAllUserCreditByBAId(credit, darkmind, baid);
	}

}
