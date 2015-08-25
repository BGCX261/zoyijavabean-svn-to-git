package org.zoyi.service.impl;

import java.util.List;
import org.zoyi.adapter.GroupAdapter;
import org.zoyi.hibernate.BenifitActivityDAO;
import org.zoyi.hibernate.GroupDAO;
import org.zoyi.service.GroupService;
import org.zoyi.vo.Group;

public class GroupServiceImpl implements GroupService {

	public GroupServiceImpl() {
	}

	@Override
	public String add(Group t) throws Exception {
		try {
			new GroupDAO().add(GroupAdapter.toPo(t));
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
				new GroupDAO().delete(i);
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
			new GroupDAO().delete(id);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String isExist(Group t) throws Exception {
		if (new GroupDAO().get(t.getId()) != null) {
			return "success";
		} else {
			return "fail";
		}
	}

	@Override
	public String isExist(int id) throws Exception {
		if (new GroupDAO().get(id) != null) {
			return "success";
		} else {
			return "fail";
		}
	}

	@Override
	public String modify(Group t) throws Exception {
		try {
			new GroupDAO().update(t);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public Group queryById(int id) throws Exception {
		return GroupAdapter.toVo(new GroupDAO().get(id));
	}

	@Override
	public int getCount() throws Exception {
		return new GroupDAO().getCount();
	}

	@Override
	public Group getGroupStar() throws Exception {
		return GroupAdapter.toVo(new GroupDAO().getGroupStar());
	}

	@Override
	public Group getNewGroup() throws Exception {
		return GroupAdapter.toVo(new GroupDAO().getNewGroup());
	}

	@Override
	public List<Object> queryByPage(int startRow, int pageSize)
			throws Exception {
		return new GroupDAO().queryByPage(startRow, pageSize);
	}

	@Override
	public String queryPicById(int id) throws Exception {
		return new GroupDAO().getPic(id);
	}

	@Override
	public List<Object> queryBySoft(int startRow, int pageSize)
			throws Exception {
		return new GroupDAO().queryBySoft(startRow, pageSize);
	}

	public List<Object> queryApplyUserByGroupId(int startRow, int pageSize,
			int id) throws Exception {
		return null;
	}

	@Override
	public int getApplyUserCount(int groupId) throws Exception {
		return 0;
	}

	@Override
	public String acceptApplyGroupUser(int uid, int id) throws Exception {
		return null;
	}

	@Override
	public String refuseApplyGroupUser(int userId, int groupId)
			throws Exception {
		return null;
	}

	@Override
	public Group login(String email, String pwd) throws Exception {
		return GroupAdapter.toVo(new GroupDAO().login(email, pwd));
	}

	@Override
	public String modifyGroupPwd(int groupId, String pwd) throws Exception {
		try {
			new GroupDAO().changePassword(groupId, pwd);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public boolean isRightPwd(String name, String codePwd) throws Exception {
		return new GroupDAO().isRightPwd(name, codePwd);
	}

	@Override
	public String getCodePwd(String name) throws Exception {
		return new GroupDAO().getCodePwd(name);
	}

	@Override
	public Group queryGroupByBAId(String baid) throws Exception {
		return GroupAdapter.toVo(new BenifitActivityDAO().getGroup(Integer
				.parseInt(baid)));
	}

	@Override
	public boolean isGroup(String username) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Group queryByUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		return GroupAdapter.toVo(new GroupDAO().queryGroupByName(username));
	}

	@Override
	public Group queryGroupByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
