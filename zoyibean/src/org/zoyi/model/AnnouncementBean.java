package org.zoyi.model;

import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import org.zoyi.adapter.*;
import org.zoyi.jsf.JSFUtil;
import org.zoyi.service.AnnouncementService;
import org.zoyi.service.impl.AnnouncementServiceImpl;
import org.zoyi.util.DataPage;
import org.zoyi.util.PagedListDataModel;
import org.zoyi.vo.Announcement;

public class AnnouncementBean implements ModelBase {
	private int scrollerPage = 1;
	private PagedListDataModel dataModel;
	private int pageSize = 20;
	private int id;
	private Announcement announcement;
	private AnnouncementService announcementService = new AnnouncementServiceImpl();
	private String txtCode;
	private List<Object> allAnnouncement;
	private String errormsg;

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public AnnouncementService getAnnouncementService() {
		return announcementService;
	}

	public void setAnnouncementService(AnnouncementService announcementService) {
		this.announcementService = announcementService;
	}

	public List<Object> getAllAnnouncement() {
		if (allAnnouncement != null) {
			return allAnnouncement;
		} else {
			return new java.util.ArrayList<Object>();
		}
	}

	public AnnouncementBean() {
	}

	public void setAllAnnouncement(List<Object> allAnnouncement) {
		this.allAnnouncement = allAnnouncement;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Announcement getAnnouncement() {
		int aid = StringAdapter.str2Int(JSFUtil.getRequest().getParameter(
		"aid"));
		if (announcement == null || announcement.getId()<=0 || announcement.getId()!=aid) {
			if (aid > 0) {
				try {
					announcement = this.announcementService.queryById(aid);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return announcement;
	}

	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}

	public String getTxtCode() {
		return txtCode;
	}

	public void setTxtCode(String txtCode) {
		this.txtCode = txtCode;
	}

	@Override
	public String add() {
		try {
			this.announcement.setContent(JSFUtil.getRequest().getParameter(
					"content"));
			/*
			 * System.out.println(this.announcement.getContent());
			 * System.out.println(this.announcement.getTitle());
			 * System.out.println(this.announcement.getLevel());
			 */
			this.announcement.setCreateDate(new Date());
			if ("success".equalsIgnoreCase(this.announcementService
					.add(this.announcement))) {
				errormsg = "新增公告成功！";
				sucGo("admin_release_announcement.php", errormsg);
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.createMessage("新增公告失败！" + e);
		}
		errormsg = "新增公告失败！";
		return "admin_release_announcement";
	}

	public PagedListDataModel getDataModel() {
		if (dataModel == null) {
			dataModel = new PagedListDataModel(pageSize) {
				public DataPage fetchPage(int startRow, int pageSize) {
					try {
						allAnnouncement = announcementService.queryByPage(
								startRow, pageSize);
						return new DataPage(announcementService.getCount(),
								startRow, allAnnouncement);
					} catch (Exception e) {
						e.printStackTrace();
						errormsg = "查询公告失败！";
						JSFUtil.createMessage("查询公告失败！" + e);
						return new DataPage(0, startRow, allAnnouncement);
					}
				}
			};
		}
		return dataModel;
	}

	@Override
	public String deleteById() {
		try {
			id = StringAdapter
					.str2Int(JSFUtil.getRequest().getParameter("aid"));
			if ("success".equalsIgnoreCase(this.announcementService
					.deleteById(id))) {
				errormsg = "删除成功！";
			}
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.createMessage("删除失败！");
		}
		errormsg = "删除公告失败！";
		return "admin_manage_announcement";
	}

	@Override
	public String modify() {
		try {
			this.announcement.setContent(JSFUtil.getRequest().getParameter(
					"content"));
			if (id > 0) {
				this.announcement.setLevel((short) 1);
				this.announcement.setCreateDate(new Date());
			}
			if ("success".equalsIgnoreCase(announcementService
					.modify(this.announcement))) {
				errormsg = "修改公告成功！";
				sucGo("admin_manage_announcement.php", errormsg);
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.createMessage("修改失败！" + e);
		}
		errormsg = "修改公告失败！";
		return "admin_modify_announcement";
	}

	public String preModify() {
		try {
			id = StringAdapter
					.str2Int(JSFUtil.getRequest().getParameter("aid"));
			this.announcement.setId(id);
			this.setAnnouncement(this.announcementService
					.queryById(this.announcement.getId()));
			return "admin_modify_announcement";
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.createMessage("系统错误，查无此公告！" + e);
		}
		errormsg = "系统错误，查无此公告！";
		return "admin_manage_announcement";
	}

	@Override
	public String queryById() {
		try {
			id = StringAdapter
					.str2Int(JSFUtil.getRequest().getParameter("aid"));
			this.announcement.setId(id);
			this.setAnnouncement(this.announcementService
					.queryById(this.announcement.getId()));
		} catch (Exception e) {
			e.printStackTrace();
			errormsg = "系统错误，查无公告！";
			JSFUtil.createMessage("系统错误，查无公告！" + e);
		}
		return "announcement_content";
	}

	public void ajaxDelete(ActionEvent event) {
		id = StringAdapter.str2Int(JSFUtil.getRequest().getParameter("aid"));
		try {
			if ("success".equalsIgnoreCase(this.announcementService
					.deleteById(id))) {
				dataModel.refresh();
			} else {
				errormsg = "删除失败！！";
			}
		} catch (Exception e) {
			JSFUtil.createMessage("删除失败！");
			e.printStackTrace();
		}
	}

	private static void sucGo(String url, String msg) {
		HttpServletRequest request = JSFUtil.getRequest();
		request.setAttribute("url", url);
		request.setAttribute("message", msg);
	}
}