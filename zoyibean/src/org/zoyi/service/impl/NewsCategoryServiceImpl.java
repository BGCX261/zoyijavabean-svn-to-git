package org.zoyi.service.impl;

import java.util.List;

import org.zoyi.adapter.AnnouncementAdapter;
import org.zoyi.adapter.NewsCategoryAdapter;
import org.zoyi.hibernate.NewsCategoryDAO;
import org.zoyi.hibernate.ZoyiAnnouncementDAO;
import org.zoyi.service.NewsCategoryService;
import org.zoyi.vo.NewsCategory;

public class NewsCategoryServiceImpl implements NewsCategoryService {

	@Override
	public List<NewsCategory> queryAll() throws Exception {
		return new NewsCategoryDAO().queryAll();
	}

	@Override
	public String add(NewsCategory t) throws Exception {
		try {
			new NewsCategoryDAO().add(NewsCategoryAdapter.toPo(t));
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
				this.deleteById(i);
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
			new NewsCategoryDAO().delete(id);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String isExist(NewsCategory t) throws Exception {
		if (new NewsCategoryDAO().get(t.getId()) != null) {
			return "success";
		} else {
			return "fail";
		}
	}

	@Override
	public String isExist(int id) throws Exception {
		if (new NewsCategoryDAO().get(id) != null) {
			return "success";
		} else {
			return "fail";
		}
	}

	@Override
	public String modify(NewsCategory t) throws Exception {
		try {
			new NewsCategoryDAO().update(NewsCategoryAdapter.toPo(t));
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public NewsCategory queryById(int id) throws Exception {
		return NewsCategoryAdapter.toVo(new NewsCategoryDAO().get(id));
	}

}
