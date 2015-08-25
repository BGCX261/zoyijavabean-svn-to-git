package org.zoyi.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.*;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;
import org.zoyi.util.*;
import org.zoyi.vo.BenifitActivity;
import org.zoyi.vo.Group;
import org.zoyi.vo.UserCredit;
import org.zoyi.vo.Userinfo;
import org.zoyi.adapter.StringAdapter;
import org.zoyi.jsf.JSFUtil;
import org.zoyi.service.*;
import org.zoyi.service.impl.*;

public class UserinfoBean implements ModelBase {
	private int id;
	private String username;
	private String pwd2;
	private UserService userService = new UserServiceImpl();
	private BenifitActivityService benifitActivityService = new BenifitActivityServiceImpl();
	private GroupService groupService = new GroupServiceImpl();
	private String txtCode;
	private String cond;
	private Group group;
	private List<Object> allUserinfo;
	private Userinfo userinfo;
	private BenifitActivity benifitActivity;
	private int scrollerPage = 1;
	private String picture;
	private PagedListDataModel dataModel;
	private int pageSize = 20;
	private PagedListDataModel applyingActivity, activityData;
	private List<Object> allActivity;
	private UserCredit userCredit;
	private UserCreditService userCreditService = new UserCreditServiceImpl();
	private List<Object> allUserCredit;
	private PagedListDataModel userCreditData;
	private UserCredit timeCredit1, timeCredit2, timeCredit3, timeCredit0;

	public UserCredit getTimeCredit1() {

		int uid = StringAdapter.obj2Int(JSFUtil.getSession().getAttribute(
				"zoyiId"));
		if (uid > 0)
			try {
				timeCredit1 = this.userCreditService
						.queryByUserIdStatus(uid, 1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return timeCredit1;
	}

	public UserCredit getTimeCredit2() {
		int uid = StringAdapter.obj2Int(JSFUtil.getSession().getAttribute(
				"zoyiId"));
		if (uid > 0)
			try {
				timeCredit2 = this.userCreditService
						.queryByUserIdStatus(uid, 2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return timeCredit2;
	}

	public UserCredit getTimeCredit3() {
		int uid = StringAdapter.obj2Int(JSFUtil.getSession().getAttribute(
				"zoyiId"));
		if (uid > 0)
			try {
				timeCredit3 = this.userCreditService
						.queryByUserIdStatus(uid, 3);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return timeCredit3;
	}

	public UserCredit getTimeCredit0() {
		int uid = StringAdapter.obj2Int(JSFUtil.getSession().getAttribute(
				"zoyiId"));
		if (uid > 0)
			try {
				timeCredit0 = this.userCreditService
						.queryByUserIdStatus(uid, 0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return timeCredit0;
	}

	public List<Object> getAllUserCredit() {
		return allUserCredit;
	}

	public void setAllUserCredit(List<Object> allUserCredit) {
		this.allUserCredit = allUserCredit;
	}

	public PagedListDataModel getUserCreditData() {
		System.out.println("zhixingle");
		System.out.println(userCreditData);
		if (userCreditData == null) {
			userCreditData = new PagedListDataModel(pageSize) {
				public DataPage fetchPage(int startRow, int pageSize) {
					try {
						int uid = StringAdapter.obj2Int(JSFUtil.getSession()
								.getAttribute("zoyiId"));
						System.out.println(":::::::::" + uid);
						if (uid > 0) {
							allUserCredit = userCreditService.queryByUserId(
									startRow, pageSize, uid);
							return new DataPage(userCreditService
									.getCountByUserId(uid), startRow,
									allUserCredit);
						}
					} catch (Exception e) {
						JSFUtil.createMessage("不好意思，出错了！" + e);
						e.printStackTrace();
					}
					return new DataPage(0, startRow, allUserCredit);
				}
			};
		}
		return userCreditData;
	}

	public void setUserCreditData(PagedListDataModel userCreditData) {
		this.userCreditData = userCreditData;
	}

	public GroupService getGroupService() {
		return groupService;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	public UserCredit getUserCredit() {
		return userCredit;
	}

	public void setUserCredit(UserCredit userCredit) {
		this.userCredit = userCredit;
	}

	public UserCreditService getUserCreditService() {
		return userCreditService;
	}

	public void setUserCreditService(UserCreditService userCreditService) {
		this.userCreditService = userCreditService;
	}

	public void setApplyingActivity(PagedListDataModel applyingActivity) {
		this.applyingActivity = applyingActivity;
	}

	private String errormsg;

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public String getPicture() {
		return picture;
	}

	/**
	 * 
	 */
	public UserinfoBean() {

	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setDataModel(PagedListDataModel dataModel) {
		this.dataModel = dataModel;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Group getGroup() {
		return group;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public String getPwd2() {
		return pwd2;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<Object> getAllUserinfo() {
		return allUserinfo;
	}

	public void setAllUserinfo(List<Object> allUserinfo) {
		this.allUserinfo = allUserinfo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setBenifitActivity(BenifitActivity benifitActivity) {
		this.benifitActivity = benifitActivity;
	}

	public BenifitActivity getBenifitActivity() {
		return benifitActivity;
	}

	public void setCond(String cond) {
		this.cond = cond;
	}

	public String getCond() {
		return cond;
	}

	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
	}

	public void setBenifitActivityService(
			BenifitActivityService benifitActivityService) {
		this.benifitActivityService = benifitActivityService;
	}

	public BenifitActivityService getBenifitActivityService() {
		return benifitActivityService;
	}

	public int getScrollerPage() {
		return scrollerPage;
	}

	public void setAllActivity(List<Object> allActivity) {
		this.allActivity = allActivity;
	}

	public List<Object> getAllActivity() {
		return allActivity;
	}

	public void setActivityData(PagedListDataModel activityData) {
		this.activityData = activityData;
	}

	public void setTxtCode(String txtCode) {
		this.txtCode = txtCode;
	}

	public String getTxtCode() {
		return txtCode;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public Userinfo getUserinfo() {
		int uid = StringAdapter.str2Int(JSFUtil.getRequest()
				.getParameter("uid"));
		if (userinfo == null || userinfo.getUserId() <= 0
				|| userinfo.getUserId() != uid) {
			if (uid > 0) {
				try {
					userinfo = this.userService.queryById(uid);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return userinfo;
	}

	public String applyActivity() {
		int baid = StringAdapter.str2Int(JSFUtil.getRequest().getParameter(
				"baid"));
		id = StringAdapter.obj2Int(JSFUtil.getSession().getAttribute("zoyiId"));
		try {
			if (id > 0
					&& "success".equalsIgnoreCase(this.getUserService()
							.applyActivity(id, baid))) {
				sucGo("user_self_index.php", "报名成功！");
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "user_self_index";
	}

	public String userApplyGroup() {
		String sure = JSFUtil.getRequest().getParameter("sure");
		int baid = StringAdapter.str2Int(JSFUtil.getRequest().getParameter(
				"baid"));
		id = StringAdapter.obj2Int(JSFUtil.getSession().getAttribute("zoyiId"));
		if ("ture".equalsIgnoreCase(sure)) {
			try {
				if ("success".equalsIgnoreCase(this.getUserService()
						.applyActivity(id, baid))) {
					;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// System.out.println();
		}
		return "back";
	}

	public String userApplyActivity() {
		return "back";
	}

	@SuppressWarnings( { "unchecked" })
	public void uploadListener(UploadEvent event) {
		// 获取传过来的items,3.2.2之前版本不支持getUploadItems方法
		List itemList = event.getUploadItems();
		for (int i = 0; i < itemList.size(); i++) {
			try {
				UploadItem item = (UploadItem) itemList.get(i);
				String newFileName = UUID.randomUUID().toString() + "."
						+ FileOper.getFileExtName(item.getFileName());
				String newFilePath = "userfiles" + File.separator + "group"
						+ File.separator
						+ JSFUtil.getSession().getAttribute("zoyiId")
						+ File.separator + UUID.randomUUID().toString() + "."
						+ FileOper.getFileExtName(newFileName);
				if (picture != null) {
					File oldFile = new File(JSFUtil.getSession()
							.getServletContext().getRealPath(File.separator)
							+ picture);
					if (oldFile.isFile()) {
						oldFile.delete();
					}
				}
				picture = JSFUtil.getRequest().getContextPath().substring(1)
						+ newFilePath;
				File file = new File(JSFUtil.getSession().getServletContext()
						.getRealPath(File.separator)
						+ picture);
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
				} else {
					JSFUtil.createMessage("上传文件过大或出错了，请重新上传");
					System.out.println("出错了！");
				}
			} catch (Exception e) {
				e.printStackTrace();
				JSFUtil.createMessage("上传失败！" + e);
			}
		}
	}

	public PagedListDataModel getApplyingActivity() {
		if (applyingActivity == null) {
			applyingActivity = new PagedListDataModel(pageSize) {
				public DataPage fetchPage(int startRow, int pageSize) {
					try {
						return new DataPage(userService.getCount(), startRow,
								allUserinfo);
					} catch (Exception e) {
						JSFUtil.createMessage("不好意思，出错了！" + e);
						e.printStackTrace();
					}
					return new DataPage(0, startRow, allUserinfo);
				}
			};
		}
		return applyingActivity;
	}

	public PagedListDataModel getDataModel() {
		if (dataModel == null) {
			dataModel = new PagedListDataModel(pageSize) {
				public DataPage fetchPage(int startRow, int pageSize) {
					try {
						allUserinfo = userService.queryBySoft(startRow,
								pageSize);
						return new DataPage(userService.getCount(), startRow,
								allUserinfo);
					} catch (Exception e) {
						JSFUtil.createMessage("不好意思，出错了！" + e);
						e.printStackTrace();
					}
					return new DataPage(0, startRow, allUserinfo);
				}
			};
		}
		return dataModel;
	}

	public String login() {
		if (!StringAdapter.isAvailableString(this.getUsername())
				|| !StringAdapter.isAvailableString(this.getPwd2())) {
			JSFUtil.createMessage("Email或密码错误");
		} else
			try {
				Userinfo userinfo = this.getUserService().login(
						this.getUsername(), this.getPwd2());
				System.out.println(this.getUsername() + this.getPwd2()
						+ userinfo + ":" + userinfo.getUserId());
				// System.out.println((userinfo==null &&
				// userinfo.getUserId()>0)+""+(userinfo !=
				// null)+""+(this.userinfo.getUserId()>0));
				if (userinfo != null && userinfo.getUserId() > 0) {
					userinfo.setPwd("");
					HttpSession session = JSFUtil.getSession();
					session.setAttribute("zoyiId", userinfo.getUserId());
					session.setAttribute("zoyiIdentity", "user");
					session.setAttribute("zoyiUser", userinfo);

					return "index";
				} else {
					JSFUtil.createMessage("Email或密码错误");
				}
			} catch (Exception e) {
				e.printStackTrace();
				JSFUtil.createMessage("出现错误！");
			}
		return "user_login";
	}

	public String register() {
		if (this.txtCode.equalsIgnoreCase((String) JSFUtil.getSession()
				.getAttribute("code"))) {
			if (this.pwd2.endsWith(this.getUserinfo().getPwd())) {
				/*
				 * System.out.println(this.getUserinfo().getEmail());
				 * System.out.println(this.getUserinfo().getName());
				 * System.out.println(this.getUserinfo().getPwd());
				 * System.out.println(this.getPwd2());
				 * System.out.println(JSFUtil
				 * .getSession().getAttribute("code"));
				 */
				try {
					String rs = this.getUserService().add(this.getUserinfo());
					if ("success".equalsIgnoreCase(rs)) {
						HttpSession session = JSFUtil.getSession();
						this.userinfo = this.userService.login(getUserinfo()
								.getUsername(), this.getUserinfo().getPwd());
						session.setAttribute("zoyiUser", this.getUserinfo());
						session.setAttribute("zoyiIdentity", "user");
						session.setAttribute("zoyiId", this.getUserinfo()
								.getUserId());

						return "index";
					} else {
						JSFUtil.createMessage("用户名或邮箱重复，请重新输入！");
					}
				} catch (Exception e) {
					JSFUtil.createMessage("注册失败！" + e);
					e.printStackTrace();
				}
			} else {
				JSFUtil.createMessage("两次密码输入不一致，请重新输入！");
			}
		} else {
			JSFUtil.createMessage("验证码输入错误，请重新输入！");
		}
		return "user_register";
	}

	@Override
	public String add() {

		try {
			if ("success".equalsIgnoreCase(this.getUserService().add(
					getUserinfo())))
				;
		} catch (Exception e) {
			JSFUtil.createMessage("错误！" + e);
			e.printStackTrace();
		}
		return "back";
	}

	@Override
	public String deleteById() {
		id = StringAdapter.str2Int(JSFUtil.getRequest().getParameter("uid"));
		try {
			this.getUserService().deleteById(id);
		} catch (Exception e) {
			JSFUtil.createMessage("错误！" + e);
			e.printStackTrace();
		}
		return "back";
	}

	@Override
	public String modify() {
		try {
			if ("success".equalsIgnoreCase(this.getUserService().modify(
					getUserinfo())))
				;
		} catch (Exception e) {
			JSFUtil.createMessage("错误！" + e);
			e.printStackTrace();
		}
		return "back";
	}

	@Override
	public String queryById() {
		id = StringAdapter.str2Int(JSFUtil.getRequest().getParameter("uid"));
		try {
			this.setUserinfo(this.getUserService().queryById(id));
		} catch (Exception e) {
			JSFUtil.createMessage("错误！" + e);
			e.printStackTrace();
		}
		return "user_index";
	}

	public String getLogout() {
		JSFUtil.getSession().removeAttribute("zoyiId");
		JSFUtil.getSession().removeAttribute("zoyiUser");
		JSFUtil.getSession().removeAttribute("zoyiIdentity");
		this.removeCookie();
		return "index";
	}

	@Override
	public String preModify() {
		id = StringAdapter.str2Int(JSFUtil.getRequest().getParameter("uid"));
		try {
			if ("success"
					.equalsIgnoreCase(this.getUserService().deleteById(id)))
				;
		} catch (Exception e) {
			JSFUtil.createMessage("错误！" + e);
			e.printStackTrace();
		}
		return "back";
	}

	public String userPreModify() {
		id = StringAdapter.str2Int(JSFUtil.getRequest().getParameter("uid"));
		try {
			this.setUserinfo(this.getUserService().queryById(id));
		} catch (Exception e) {
			JSFUtil.createMessage("错误！" + e);
			e.printStackTrace();
			return "user_self_index";
		}
		return "user_self_modify";
	}

	public PagedListDataModel getActivityData() {
		if (activityData == null) {
			activityData = new PagedListDataModel(pageSize) {
				// 查询分页函数
				public DataPage fetchPage(int startRow, int pageSize) {
					try {
						allUserinfo = benifitActivityService.queryByUserId(
								startRow, pageSize, userinfo.getUserId());
					} catch (Exception e) {
						JSFUtil.createMessage("不好意思，出错了！" + e);
						e.printStackTrace();
					}
					try {
						return new DataPage(benifitActivityService
								.getCountByUserId(userinfo.getUserId()),
								startRow, allActivity);
					} catch (Exception e) {
						JSFUtil.createMessage("不好意思，出错了！" + e);
						e.printStackTrace();
					}
					return new DataPage(0, startRow, allActivity);
				}
			};
		}
		return activityData;
	}

	public void removeCookie() {
		Cookie cookie[] = JSFUtil.getRequest().getCookies();
		if (cookie != null && cookie.length > 0) {
			for (int i = 0; i < cookie.length; i++) {
				if (cookie[i].getName().equals("uchome_loginuser")
						|| cookie[i].getName().equals("uchome_auth")) {
					cookie[i].setValue(null);
					cookie[i].setMaxAge(0);
					JSFUtil.getResponse().addCookie(cookie[i]);
				}
			}
		}
	}

	public boolean comparePwd(String username, String codePwd) {
		if (StringAdapter.isAvailableString(username)
				&& StringAdapter.isAvailableString(codePwd)) {
			try {
				if (this.userService.isRightPwd(username, codePwd)) {
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public String preApply() {
		id = StringAdapter.obj2Int(JSFUtil.getSession().getAttribute("zoyiId"));
		try {
			this.userinfo = this.getUserService().queryById(id);
			return "user_apply_activity";
		} catch (Exception e) {
			e.printStackTrace();
			return "back";
		}
	}

	public String checkCookie() {
		Cookie cookie[] = JSFUtil.getRequest().getCookies();
		String uchome_auth = null;
		if (cookie != null && cookie.length > 0) {
			for (int i = 0; i < cookie.length; i++) {
				if (cookie[i].getName().equals("uchome_loginuser")) {
					username = cookie[i].getValue();
					continue;
				}
				if (cookie[i].getName().equals("uchome_auth")) {
					uchome_auth = cookie[i].getValue();
					continue;
				}
			}
			try {
				HttpSession session = JSFUtil.getSession();
				String indent = this.userService.findIdent(username);
				if (!StringAdapter.isAvailableString(username)
						&& !StringAdapter.isAvailableString(uchome_auth)
						&& "user".equalsIgnoreCase(indent)) {
					userinfo = this.userService.queryUserByName(username);
					session.setAttribute("zoyiId", userinfo.getUserId());
					session.setAttribute("zoyiIdentity", "user");
					session.setAttribute("zoyiUser", userinfo);
					return "user";
				} else if (!StringAdapter.isAvailableString(username)
						&& this.groupService.isGroup(username)
						&& "group".equalsIgnoreCase(indent)) {
					setGroup(this.groupService.queryByUsername(username));
					session.setAttribute("zoyiId", group.getId());
					session.setAttribute("zoyiIdentity", "group");
					session.setAttribute("zoyiGroup", group);
					return "group";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		removeCookie();
		this.errormsg = "请重新登陆！";
		return null;
	}

	public String querySelfCredit() {
		return "user_manage_credit";
	}

	private static void sucGo(String url, String msg) {
		HttpServletRequest request = JSFUtil.getRequest();
		request.setAttribute("url", url);
		request.setAttribute("message", msg);
	}
}