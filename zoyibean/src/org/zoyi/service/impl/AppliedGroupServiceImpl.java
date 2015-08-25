package org.zoyi.service.impl;

import java.util.List;

import org.zoyi.adapter.AppliedGroupAdapter;
import org.zoyi.hibernate.AppliedGroupDAO;
import org.zoyi.service.AppliedGroupService;
import org.zoyi.vo.AppliedGroup;

public class AppliedGroupServiceImpl implements AppliedGroupService {

	public AppliedGroupServiceImpl() {

	}

	@Override
	public String add(AppliedGroup t) throws Exception {

		return new AppliedGroupDAO().add(AppliedGroupAdapter.toPo(t));

	}

	@Override
	public String delete(List<Integer> id) throws Exception {
		try {
			for (Integer i : id) {
				new AppliedGroupDAO().delete(i);
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
			new AppliedGroupDAO().delete(id);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String isExist(AppliedGroup t) throws Exception {
		return null;
	}

	@Override
	public String isExist(int id) throws Exception {
		return null;
	}

	@Override
	public String modify(AppliedGroup t) throws Exception {
		try {
			new AppliedGroupDAO().update(AppliedGroupAdapter.toPo(t));
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public AppliedGroup queryById(int id) throws Exception {
		return AppliedGroupAdapter.toVo(new AppliedGroupDAO().get(id));
	}

	@Override
	public int getCount() throws Exception {
		return new AppliedGroupDAO().getCount();
	}

	@Override
	public List<Object> queryByPage(int startRow, int pageSize)
			throws Exception {
		return new AppliedGroupDAO().queryByPage(startRow, pageSize);

	}

	@Override
	public String acceptGroup(int id) throws Exception {
		try {
			new AppliedGroupDAO().accept(id);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String refuseGroup(int id) throws Exception {
		try {
			new AppliedGroupDAO().refuse(id);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public int getCountByStatus(int status) throws Exception {
		return new AppliedGroupDAO().countByStatus(status);
	}

	@Override
	public List<Object> queryByStatus(int status, int startRow, int pageSize)
			throws Exception {
		return new AppliedGroupDAO().queryByStatus(status, startRow, pageSize);
	}

}
