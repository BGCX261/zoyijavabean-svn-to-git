package org.zoyi.service.impl;

import java.util.List;

import org.zoyi.adapter.GroupCategoryAdapter;
import org.zoyi.hibernate.GroupCategoryDAO;
import org.zoyi.service.GroupCategoryService;
import org.zoyi.vo.GroupCategory;

public class GroupCategoryServiceImpl implements GroupCategoryService {

	@Override
	public List<GroupCategory> queryAll() throws Exception {
		return new GroupCategoryDAO().queryAll();
	}

	@Override
	public String add(GroupCategory t) throws Exception {
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
	public String isExist(GroupCategory t) throws Exception {
		return null;
	}

	@Override
	public String isExist(int id) throws Exception {
		return null;
	}

	@Override
	public String modify(GroupCategory t) throws Exception {
		return null;
	}

	@Override
	public GroupCategory queryById(int id) throws Exception {
		return GroupCategoryAdapter.toVo(new GroupCategoryDAO().get(id));
	}

}
