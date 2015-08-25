package org.zoyi.service.impl;

import java.util.List;

import org.zoyi.adapter.*;
import org.zoyi.hibernate.BenifitActivityCategoryDAO;
import org.zoyi.service.BenifitActivityCategoryService;
import org.zoyi.vo.BenifitActivityCategory;
import org.zoyi.vo.Group;

public class BenifitActivityCategoryServiceImpl implements BenifitActivityCategoryService {

	public BenifitActivityCategoryServiceImpl() {
	}

	@Override
	public int getCount() throws Exception {
		return new BenifitActivityCategoryDAO().getCount();
	}

	@Override
	public List<Object> queryByPage(int startRow, int pageSize)
			throws Exception {
		return new BenifitActivityCategoryDAO().queryByPage(startRow, pageSize);
	}

	@Override
	public String add(BenifitActivityCategory t) throws Exception {
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
	public String isExist(BenifitActivityCategory t) throws Exception {
		return null;
	}

	@Override
	public String isExist(int id) throws Exception {
		return null;
	}

	@Override
	public String modify(BenifitActivityCategory t) throws Exception {
		return null;
	}

	@Override
	public BenifitActivityCategory queryById(int id) throws Exception {
		return BenifitActivityCategoryAdapter.toVo(new BenifitActivityCategoryDAO().get(id));
	}

	@Override
	public List<BenifitActivityCategory> queryAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
