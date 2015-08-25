package org.zoyi.service.impl;

import java.util.List;

import org.zoyi.hibernate.UserCreditDAO;
import org.zoyi.service.UserCreditService;
import org.zoyi.vo.UserCredit;

public class UserCreditServiceImpl implements UserCreditService {

	@Override
	public int getCountByBaid(int baid) throws Exception {
		return new UserCreditDAO().getCountByBaid(baid);
	}

	@Override
	public int getCountByUserId(int id) throws Exception {
		return new UserCreditDAO().getCountByUserId(id);
	}

	@Override
	public List<Object> queryByBaid(int startRow, int pageSize, int baid)
			throws Exception {
		return new UserCreditDAO().queryByBaid(startRow, pageSize, baid);
	}

	@Override
	public List<Object> queryByUserId(int startRow, int pageSize, int userid)
			throws Exception {
		return new UserCreditDAO().queryByUserId(startRow, pageSize, userid);
	}

	@Override
	public UserCredit queryByUserIdStatus(int userid, int status)
			throws Exception {// 状态就是1、最近一周，2、最近1个月，3、最近6个月，0总共
		UserCredit u = new UserCredit();
		u.setUid(userid);
		switch (status) {
		case 0:
			u.setCredit(new UserCreditDAO().queryCreditCount(userid));
			u.setDarkmind(new UserCreditDAO().queryDMCount(userid));
			break;
		case 1:
			u.setCredit(new UserCreditDAO().queryCreditCountInDays(userid, 7));
			u.setDarkmind(new UserCreditDAO().queryDMCountInDays(userid, 7));
			break;
		case 2:
			u.setCredit(new UserCreditDAO().queryCreditCountInDays(userid, 30));
			u.setDarkmind(new UserCreditDAO().queryDMCountInDays(userid, 30));
			break;
		case 3:
			u
					.setCredit(new UserCreditDAO().queryCreditCountInDays(
							userid, 180));
			u.setDarkmind(new UserCreditDAO().queryDMCountInDays(userid, 180));
			break;
		default:
		}
		return u;
	}

	@Override
	public String add(UserCredit t) throws Exception {
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
	public String isExist(UserCredit t) throws Exception {
		return null;
	}

	@Override
	public String isExist(int id) throws Exception {
		return null;
	}

	@Override
	public String modify(UserCredit t) throws Exception {
		return null;
	}

	@Override
	public UserCredit queryById(int id) throws Exception {
		return null;
	}

	@Override
	public List<Object> queryByBaid(int baid) throws Exception {
		return new UserCreditDAO().queryByBaid(baid);
	}

	@Override
	public List<Object> queryByUserId(int userid) throws Exception {
		return new UserCreditDAO().queryByUserId(userid);
	}
}
