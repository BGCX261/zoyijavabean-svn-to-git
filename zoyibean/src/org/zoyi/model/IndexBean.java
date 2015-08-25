package org.zoyi.model;

import java.util.ArrayList;
import java.util.List;


import org.zoyi.jsf.JSFUtil;
import org.zoyi.service.*;
import org.zoyi.service.impl.*;
import org.zoyi.vo.*;

public class IndexBean {
	private List<Object> newAnnouncement;
	private int groupCount;
	private int userCount;
	private Group newGroup;
	private Group groupStar;
	private Userinfo userStar;
	private List<Object> focusNews;
	private Userinfo newUser;
	private List<Object> newNews;
	private List<Object> allBenifitActivity;
	private AnnouncementService announcementService = new AnnouncementServiceImpl();
	private GroupService groupService = new GroupServiceImpl();
	private UserService userService = new UserServiceImpl();
	private NewsService newsService = new NewsServiceImpl();
	private List<Object> softAcitity;
	private List<Object> softGroup;
	private List<Object> softUser;
	private List<Object> softNews;
	private BenifitActivityService benifitActivityService = new BenifitActivityServiceImpl();
	private String errormsg;

	public void setSoftUser(List<Object> softUser) {
		this.softUser = softUser;
	}

	public void setSoftNews(List<Object> softNews) {
		this.softNews = softNews;
	}

	static{
		//System.out.println(JSFUtil.getSession().getCreationTime()+"adf爱上对方就爱上的发生的发生法撒旦法上的发生地方");
	}
	
	public String init(){
		return "index";
	}
	
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

	public void setBenifitActivityService(
			BenifitActivityService benifitActivityService) {
		this.benifitActivityService = benifitActivityService;
	}

	public BenifitActivityService getBenifitActivityService() {
		return benifitActivityService;
	}

	public GroupService getGroupService() {
		return groupService;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	public UserService getUserService() {

		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public NewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public List<Object> getNewAnnouncement() {
		try {
			this.newAnnouncement = announcementService.queryByPage(0, 10);
			// System.out.println(((Announcement)this.newAnnouncement.get(0)).getTitle());
		} catch (Exception e) {
			this.newAnnouncement = new ArrayList<Object>();
			e.printStackTrace();
		}
		return newAnnouncement;
	}

	public int getGroupCount() {
		try {
			//System.out.println("hi");
			this.groupCount = this.groupService.getCount();
			//System.out.println(this.groupService.getCount());
		} catch (Exception e) {
			userCount = 0;
			e.printStackTrace();
		}
		return groupCount;
	}

	public int getUserCount() {
		try {
			this.userCount = this.userService.getCount();
		} catch (Exception e) {
			userCount = 0;
			e.printStackTrace();
		}
		return userCount;
	}

	public Group getNewGroup() {
		try {
			this.newGroup = this.groupService.getNewGroup();
		} catch (Exception e) {
			this.newGroup = new Group();
			e.printStackTrace();
		}
		return newGroup;
	}

	public Group getGroupStar() {
		try {
			this.groupStar = this.groupService.getGroupStar();
		} catch (Exception e) {
			this.groupStar = new Group();
			e.printStackTrace();
		}
		return groupStar;
	}

	public Userinfo getUserStar() {
		try {
			userStar = this.userService.getUserStar();
		} catch (Exception e) {
			this.userStar = new Userinfo();
			e.printStackTrace();
		}
		return userStar;
	}

	public Userinfo getNewUser() {
		try {
			List<Object> u = this.userService.queryByPage(0, 1);
			if(u!=null)
				newUser = (Userinfo) u.get(0);
			else
				newUser = null;
		} catch (Exception e) {
			this.newUser = new Userinfo();
			e.printStackTrace();
		}
		return newUser;
	}

	public List<Object> getNewNews() {
		try {
			newNews = this.newsService.queryByPage(0, 7);
			// System.out.println(newNews.size());
		} catch (Exception e) {
			this.newNews = new ArrayList<Object>();
			e.printStackTrace();
		}
		return newNews;
	}

	public List<Object> getAllBenifitActivity() {
		try {
			allBenifitActivity = this.getBenifitActivityService().queryByPage(
					0, 5);
		} catch (Exception e) {
			allBenifitActivity = new ArrayList<Object>();
			e.printStackTrace();
		}
		return allBenifitActivity;
	}

	public List<Object> getFocusNews() {
		try {
			this.focusNews = this.getNewsService().getNewFocusNews(4);
			// System.out.println("::" + focusNews.size());
		} catch (Exception e) {
			JSFUtil.createMessage("" + e);
			e.printStackTrace();
		}
		return this.focusNews;
	}

	public List<Object> getSoftGroup() {
		try {
			softGroup = this.getGroupService().queryBySoft(0, 10);
			// System.out.println("::"+focusNews.size());
		} catch (Exception e) {
			JSFUtil.createMessage("" + e);
			e.printStackTrace();
		}
		return softGroup;
	}

	public List<Object> getSoftUser() {
		try {
			this.softUser = this.getUserService().queryBySoft(0, 10);
			// System.out.println("::"+focusNews.size());
		} catch (Exception e) {
			this.errormsg = "查找新闻出错了！";
			JSFUtil.createMessage("" + e);
			e.printStackTrace();
		}
		return this.softUser;
	}

	public List<Object> getSoftAcitity() {
		try {
			softAcitity = this.getBenifitActivityService().queryBySoft(0, 10);
			// System.out.println("::"+focusNews.size());
		} catch (Exception e) {
			JSFUtil.createMessage("" + e);
			e.printStackTrace();
		}
		return softAcitity;
	}

	public List<Object> getSoftNews() {
		try {
			softNews = this.getNewsService().queryBySoft(0, 10);
			// System.out.println("::"+focusNews.size());
		} catch (Exception e) {
			JSFUtil.createMessage("" + e);
			e.printStackTrace();
		}
		return softNews;
	}
}