package org.zoyi.service.impl;

import java.util.List;

import org.zoyi.adapter.UserinfoAdapter;
import org.zoyi.hibernate.BenifitActivityDAO;
import org.zoyi.hibernate.GroupDAO;
import org.zoyi.hibernate.UserInfoDAO;
import org.zoyi.service.UserService;
import org.zoyi.vo.Userinfo;

public class UserServiceImpl implements UserService {

	public UserServiceImpl() {

	}

	@Override
	public Userinfo login(String username, String pwd) throws Exception {
		return UserinfoAdapter.toVo(new UserInfoDAO().login(username, pwd));
	}

	@Override
	public String add(Userinfo t) throws Exception {
		try {
			new UserInfoDAO().add(UserinfoAdapter.toPo(t));
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String delete(List<Integer> id) throws Exception {
		try {
			for (Integer i : id) {
				new UserInfoDAO().delete(i);
			}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String deleteById(int id) throws Exception {
		try {
			new UserInfoDAO().delete(id);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String isExist(Userinfo t) throws Exception {
		return new UserInfoDAO().isExist(t.getName(), t.getPwd());
	}

	@Override
	public String isExist(int id) throws Exception {
		return null;
	}

	@Override
	public String modify(Userinfo t) throws Exception {
		try {
			new UserInfoDAO().update(t);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public Userinfo queryById(int id) throws Exception {
		return UserinfoAdapter.toVo(new UserInfoDAO().get(id));
	}

	@Override
	public int getCount() throws Exception {
		return new UserInfoDAO().getCount();
	}

	@Override
	public Userinfo getNewUser() throws Exception {
		return UserinfoAdapter.toVo(new UserInfoDAO().getNewUser());
	}

	@Override
	public Userinfo getUserStar() throws Exception {
		return UserinfoAdapter.toVo(new UserInfoDAO().getUserStar());
	}

	@Override
	public List<Object> queryByPage(int startRow, int pageSize)
			throws Exception {
		return null;
	}

	@Override
	public int getApplidPeopleCountByBAId(int baid) throws Exception {
		return new BenifitActivityDAO().getUserCountByStatusBAId(baid, 0);
	}

	@Override
	public List<Object> queryApplidPeopleByBAId(int startRow, int pageSize,
			int baid) throws Exception {
		return new BenifitActivityDAO().queryUserByStatusBAId(startRow,
				pageSize, baid, 0);
	}

	@Override
	public List<Object> queryBySoft(int startRow, int pageSize)
			throws Exception {
		return new UserInfoDAO().queryBySoft(startRow, pageSize);
	}

	@Override
	public boolean isRightPwd(String email, String pwd) throws Exception {
		return new UserInfoDAO().isRightPwd(email, pwd);
	}

	@Override
	public Userinfo queryUserByName(String name) throws Exception {
		return UserinfoAdapter.toVo(new UserInfoDAO().queryUserByName(name));
	}

	@Override
	public String getCodePwd(String name) throws Exception {
		return new UserInfoDAO().getCodePwd(name);
	}

	@Override
	public Userinfo getFullUser(Userinfo userinfo) throws Exception {
		return new UserInfoDAO().getFullUser(userinfo);
	}

	@Override
	public String findIdent(String username) throws Exception {
		return new UserInfoDAO().findIdent(username);
	}

	@Override
	public String applyActivity(int userId, int baid) throws Exception {
		return null;
	}

	@Override
	public String applyGroup(int userId, int gid) throws Exception {
		return null;
	}

	@Override
	public List<Object> queryUserRankByCredit(int userId) throws Exception {
		return new UserInfoDAO().queryUserRankByCredit(userId);
	}


}
