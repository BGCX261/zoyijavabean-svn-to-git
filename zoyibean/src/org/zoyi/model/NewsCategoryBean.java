package org.zoyi.model;

import java.util.*;

import javax.faces.event.ActionEvent;

import org.zoyi.service.*;
import org.zoyi.service.impl.*;
import org.zoyi.vo.*;
import org.zoyi.jsf.*;
import org.zoyi.adapter.*;

public class NewsCategoryBean implements ModelBase {

	private int id;
	private NewsCategoryService newsCategoryService = new NewsCategoryServiceImpl();
	private String cond;
	private NewsCategory newsCategory;
	private List<NewsCategory> allNewsCategory;
	private Map<String, Integer> mapNewsCategory;
	private int userId;
	private String errormsg;

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String getErrormsg() {
		return errormsg;
	}
	/**
	 * 
	 */
	public NewsCategoryBean() {

	}

	public NewsCategoryService getNewsCategoryService() {
		return newsCategoryService;
	}

	public void setNewsCategoryService(NewsCategoryService newsCategoryService) {
		this.newsCategoryService = newsCategoryService;
	}

	public NewsCategory getNewsCategory() {
		return newsCategory;
	}

	public void setNewsCategory(NewsCategory newsCategory) {
		this.newsCategory = newsCategory;
	}

	public List<NewsCategory> getAllNewsCategory() {
		try {
			this.allNewsCategory = this.newsCategoryService.queryAll();
		} catch (Exception e) {
			JSFUtil.createMessage("查找所有新闻分类失败！" + e);
			e.printStackTrace();
			return new ArrayList<NewsCategory>();
		}
		return allNewsCategory;
	}

	public void setMapNewsCategory(Map<String, Integer> mapNewsCategory) {
		this.mapNewsCategory = mapNewsCategory;
	}

	public Map<String, Integer> getMapNewsCategory() {
		try {
			this.mapNewsCategory = NewsCategoryCollectionAdapter
					.toMap(this.newsCategoryService.queryAll());
		} catch (Exception e) {
			errormsg = "提取新闻分类出错了！";
			JSFUtil.createMessage("提取新闻分类出错了！" + e);
			e.printStackTrace();
		}
		return mapNewsCategory;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String deleteById() {
		id = StringAdapter.str2Int(JSFUtil.getRequest().getParameter("ncid"));
		try {
			this.getNewsCategoryService().deleteById(id);
		} catch (Exception e) {
			JSFUtil.createMessage("删除出错了！" + e);
			e.printStackTrace();
		}
		return "back";
	}

	@Override
	public String modify() {
		try {
			this.getNewsCategoryService().modify(newsCategory);
		} catch (Exception e) {
			JSFUtil.createMessage("修改出错了！" + e);
			e.printStackTrace();
		}
		return "back";
	}

	@Override
	public String queryById() {
		id = StringAdapter.str2Int(JSFUtil.getRequest().getParameter("ncid"));
		try {
			this.getNewsCategoryService().queryById(id);
		} catch (Exception e) {
			JSFUtil.createMessage("查找出错了！" + e);
			e.printStackTrace();
		}
		return "back";
	}

	@Override
	public String add() {
		this.newsCategory.setCreateDate(new Date());
		try {
			this.newsCategoryService.add(getNewsCategory());
		} catch (Exception e) {
			JSFUtil.createMessage("新增新闻分类失败！" + e);
			e.printStackTrace();
		}
		return "suc";
	}

	public void ajaxDelete(ActionEvent event) {
		int ncid = StringAdapter.str2Int(JSFUtil.getRequest().getParameter(
				"ncid"));
		System.out.println(ncid);
		try {
			if (!"success".equalsIgnoreCase(this.getNewsCategoryService()
					.deleteById(ncid))) {
				JSFUtil.createMessage("删除新闻分类" + ncid + "失败！");
			}
		} catch (Exception e) {
			JSFUtil.createMessage("没有正确删除新闻分类！" + e);
			e.printStackTrace();
		}
	}

	public void ajaxModify(ActionEvent event) {
		int ncid = StringAdapter.str2Int(JSFUtil.getRequest().getParameter(
				"ncid"));
		if (ncid > 0) {
			this.getNewsCategory().setId(ncid);
			try {
				this.newsCategoryService.modify(getNewsCategory());
			} catch (Exception e) {
				JSFUtil.createMessage("新增新闻修改失败！" + e);
				e.printStackTrace();
			}
		} else {
			JSFUtil.createMessage("新增新闻修改失败！");
		}
	}

	public void ajaxAdd(ActionEvent event) {
		this.newsCategory.setCreateDate(new Date());
		try {
			this.newsCategoryService.add(getNewsCategory());
		} catch (Exception e) {
			JSFUtil.createMessage("新增新闻分类失败！" + e);
			e.printStackTrace();
		}
	}

	@Override
	public String preModify() {
		id = StringAdapter.str2Int(JSFUtil.getRequest().getParameter("ncid"));
		try {
			this.getNewsCategoryService().queryById(id);
		} catch (Exception e) {
			JSFUtil.createMessage("查找出错了！" + e);
			e.printStackTrace();
		}
		return "back";
	}

	public void setCond(String cond) {
		this.cond = cond;
	}

	public String getCond() {
		return cond;
	}

}
