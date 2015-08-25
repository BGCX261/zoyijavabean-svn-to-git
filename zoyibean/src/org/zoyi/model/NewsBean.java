package org.zoyi.model;

import java.io.*;
import java.util.*;

import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;
import org.zoyi.service.*;
import org.zoyi.service.impl.*;
import org.zoyi.util.DataPage;
import org.zoyi.util.FileOper;
import org.zoyi.util.PagedListDataModel;
import org.zoyi.vo.*;
import org.zoyi.adapter.NewsCategoryCollectionAdapter;
import org.zoyi.adapter.StringAdapter;
import org.zoyi.jsf.*;

public class NewsBean implements ModelBase {
	private int scrollerPage = 1;
	private PagedListDataModel dataModel;
	private int pageSize = 20;
	private List<Object> allNews;
	private int id;
	private NewsService newsService = new NewsServiceImpl();
	private String txtCode;
	private News news;
	private String cond;
	private Map<String, Integer> allNewsCategory;
	private NewsCategoryService newsCategoryService = new NewsCategoryServiceImpl();
	private String errormsg;

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setDataModel(PagedListDataModel dataModel) {
		this.dataModel = dataModel;
	}

	public List<Object> getAllNews() {
		return allNews;
	}

	public void setAllNews(List<Object> allNews) {
		this.allNews = allNews;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
	}

	public int getScrollerPage() {
		return scrollerPage;
	}

	public NewsService getNewsService() {
		return newsService;
	}

	public void setCond(String cond) {
		this.cond = cond;
	}

	public String getCond() {
		return cond;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	/**
	 * 
	 */
	public NewsBean() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTxtCode() {
		return txtCode;
	}

	public void setTxtCode(String txtCode) {
		this.txtCode = txtCode;
	}

	public PagedListDataModel getDataModel() {
		if (dataModel == null) {
			dataModel = new PagedListDataModel(pageSize) {
				// 查询分页函数
				public DataPage fetchPage(int startRow, int pageSize) {
					int newsCategoryId = StringAdapter.str2Int(JSFUtil
							.getRequest().getParameter("ncid"));
					try {
						if (newsCategoryId > 0) {
							allNews = newsService.queryByNewsCategory(startRow,
									pageSize, newsCategoryId);
							return new DataPage(newsService
									.getNewsCountByCId(newsCategoryId),
									startRow, allNews);
						} else if (StringAdapter.isAvailableString(cond)) {
							allNews = newsService.queryByCond(startRow,
									pageSize, cond);
							return new DataPage(newsService
									.getCountByCond(cond), startRow, allNews);
						} else {
							allNews = newsService.queryByPage(startRow,
									pageSize);
							return new DataPage(newsService.getCount(),
									startRow, allNews);
						}
					} catch (Exception e) {
						errormsg = "出错了！";
						JSFUtil.createMessage("出错了！" + e);
						allNews = new ArrayList<Object>();
						e.printStackTrace();
					}
					return new DataPage(0, startRow, allNews);
				}
			};
		}
		return dataModel;
	}

	@Override
	public String deleteById() {
		id = StringAdapter.str2Int(JSFUtil.getRequest().getParameter("nid"));
		try {
			String picture = this.newsService.getNewsPicture(id);
			if ("success".equalsIgnoreCase(this.newsService.deleteById(id))) {
				new File(JSFUtil.getSession().getServletContext().getRealPath(
						File.separator)
						+ picture).delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
			errormsg = "删除新闻失败！";
			JSFUtil.createMessage("删除新闻失败！" + e);
			return "admin_manage_news";
		}
		return "admin_manage_news";
	}

	public String preModify() {
		id = StringAdapter.str2Int(JSFUtil.getRequest().getParameter("nid"));
		try {
			this.news = this.getNewsService().queryById(id);
			// System.out.println("中文" + news.getContent());
		} catch (Exception e) {
			e.printStackTrace();
			errormsg = "删除新闻失败！";
			JSFUtil.createMessage("失败！" + e);
			return "admin_manage_news";
		}
		return "admin_modify_news";
	}

	@Override
	public String modify() {
		/*
		 * System.out.println(news.getContent());
		 * System.out.println(news.getKeyword1());
		 * System.out.println(news.getPicture());
		 * System.out.println(news.getPublisherId());
		 * System.out.println(news.getTitle());
		 * System.out.println(news.getNewsCategory().getId());
		 */
		try {
			String content = StringAdapter.obj2str(JSFUtil.getRequest()
					.getParameter("content"));

			news.setContent(content);
			news.setReleasetime(new Date());
			news.setStatus("1");
			news.setRemark(news.getRemark()+StringAdapter.obj2str(JSFUtil.getSession()
					.getAttribute("zoyiId")));
			String picture = this.newsService.getNewsPicture(this.getNews()
					.getInnerId());
			if ("success".equalsIgnoreCase(this.newsService.modify(getNews()))) {
				errormsg = "修改新闻成功！！";
				sucGo("admin_manage_news.php", errormsg);
				return "success";
			}
			if (!(picture + "").equalsIgnoreCase(this.news.getPicture())) {
				if (StringAdapter.isAvailableString(this.news.getPicture())) {
					File f1 = new File(JSFUtil.getSession().getServletContext()
							.getRealPath(File.separator)
							+ picture);
					if (f1.isFile()) {
						f1.delete();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

			JSFUtil.createMessage("修改新闻失败！" + e);
		}
		return "admin_modify_news";
	}

	@Override
	public String queryById() {
		id = StringAdapter.str2Int(JSFUtil.getRequest().getParameter("nid"));
		try {
			this.news = this.getNewsService().queryById(id);
			// System.out.println(news.getInnerId());
		} catch (Exception e) {
			e.printStackTrace();
			errormsg = "修改新闻失败！";
			JSFUtil.createMessage("查找新闻失败！" + e);
			return "fail";
		}
		return "news_content";
	}

	@Override
	public String add() {
		/*
		 * System.out.println(news.getContent());
		 * System.out.println(news.getKeyword1());
		 */
		//System.out.println("newsadd");
		if (2 > 1) {
			String content = StringAdapter.obj2str(JSFUtil.getRequest()
					.getParameter("content"));
			news.setContent(content);
			id = StringAdapter.obj2Int(JSFUtil.getSession().getAttribute(
					"zoyiId"));
			try {
				this.news.setPublisherId(id);
				this.news.setReleasetime(new Date());
				if ("success".equalsIgnoreCase(this.newsService.add(getNews()))) {
					errormsg = "新增新闻成功！";
					sucGo("admin_manage_news.php", errormsg);
					return "success";
				}
			} catch (Exception e) {
				errormsg = "新增新闻失败！";
				JSFUtil.createMessage("新增新闻失败！" + e);
				e.printStackTrace();
			}
		}
		errormsg = "修改新闻失败！";
		return "admin_release_news.jsp";
	}

	public void ajaxDelete(ActionEvent event) {
		id = StringAdapter.str2Int(JSFUtil.getRequest().getParameter("nid"));
		try {
			String picture = this.newsService.getNewsPicture(id);
			if ("success".equalsIgnoreCase(this.newsService.deleteById(id))) {
				new File(JSFUtil.getSession().getServletContext().getRealPath(
						File.separator)
						+ picture).delete();
			}
		} catch (Exception e) {
			errormsg = "删除新闻失败！";
			JSFUtil.createMessage("删除失败！");
			e.printStackTrace();
		}
	}

	@SuppressWarnings( { "unchecked" })
	public void uploadListener(UploadEvent event) {
		System.out.println("walala");
		// 获取传过来的items,3.2.2之前版本不支持getUploadItems方法
		List itemList = event.getUploadItems();
		for (int i = 0; i < itemList.size(); i++) {
			try {
				UploadItem item = (UploadItem) itemList.get(i);
				String newFileName = UUID.randomUUID().toString() + "."
						+ FileOper.getFileExtName(item.getFileName());
				String newFilePath = "userfiles" + File.separator + "news"
						+ File.separator + new Date().getTime()
						+ File.separator + UUID.randomUUID().toString() + "."
						+ FileOper.getFileExtName(newFileName);
				if (this.news == null) {
					this.news = new News();
				} else if (StringAdapter.isAvailableString(this.news
						.getPicture())) {
					File f1 = new File(JSFUtil.getSession().getServletContext()
							.getRealPath(File.separator)
							+ this.news.getPicture());
					if (f1.isFile()) {
						f1.delete();
					}
				}
				news.setPicture(newFilePath);
				File file = new File(JSFUtil.getSession().getServletContext()
						.getRealPath(File.separator)
						+ news.getPicture());
				System.out.println(JSFUtil.getSession().getServletContext()
						.getRealPath(File.separator));
				System.out.println(news.getPicture());
				// 大小不能超过4M
				if (item.getFileSize() <= 4000000
						&& new File(file.getParent()).mkdirs()) {
					FileInputStream fis = new FileInputStream(item.getFile());
					FileOutputStream out = new FileOutputStream(file);
					int bytes = 0;
					byte[] bteFile = new byte[1024];
					while ((bytes = fis.read(bteFile)) != -1) {
						out.write(bteFile, 0, bytes);
					}
					fis.close();
					out.close();
				}
			} catch (Exception e) {
				errormsg = "上传失败！";
				JSFUtil.createMessage("上传失败！+e");
				e.printStackTrace();
			}
		}
	}

	public Map<String, Integer> getAllNewsCategory() {
		try {
			this.allNewsCategory = NewsCategoryCollectionAdapter
					.toMap(this.newsCategoryService.queryAll());
		} catch (Exception e) {
			errormsg = "提取新闻分类出错了！";
			JSFUtil.createMessage("提取新闻分类出错了！" + e);
			e.printStackTrace();
		}
		return allNewsCategory;
	}

	private static void sucGo(String url,String msg){
		HttpServletRequest request = JSFUtil.getRequest();
		request.setAttribute("url", url);
		request.setAttribute("message", msg);
	}
	
}