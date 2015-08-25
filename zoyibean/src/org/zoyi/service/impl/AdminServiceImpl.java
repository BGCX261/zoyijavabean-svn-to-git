package org.zoyi.service.impl;

import java.util.List;

import org.zoyi.adapter.AdminAdapter;
import org.zoyi.hibernate.AdminDAO;
import org.zoyi.service.AdminService;
import org.zoyi.vo.Admininfo;

public class AdminServiceImpl implements AdminService{

	@Override
	public Admininfo login(String username, String pwd) throws Exception {
		return new AdminDAO().login(username, pwd);
	}

	@Override
	public String add(Admininfo t) throws Exception {
		try {
			new AdminDAO().add(AdminAdapter.toPo(t));
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
				new AdminDAO().delete(i);
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
			new AdminDAO().delete(id);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String isExist(Admininfo t) throws Exception {
		return null;
	}

	@Override
	public String isExist(int id) throws Exception {
		return null;
	}

	@Override
	public String modify(Admininfo t) throws Exception {
		try {
			new AdminDAO().update(AdminAdapter.toPo(t));
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public Admininfo queryById(int id) throws Exception {
		return AdminAdapter.toVo(new AdminDAO().get(id));
	}

}
