package org.zoyi.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

import javax.faces.component.UIData;
import javax.faces.event.ActionEvent;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;
import org.zoyi.adapter.*;
import org.zoyi.jsf.JSFUtil;
import org.zoyi.service.*;
import org.zoyi.service.impl.*;
import org.zoyi.util.DataPage;
import org.zoyi.util.FileOper;
import org.zoyi.util.PagedListDataModel;
import org.zoyi.vo.*;

public class GroupBean implements ModelBase {
	private int scrollerPage = 1;
	private PagedListDataModel dataModel;
	private int pageSize = 10;
	private int id;
	private Group group;
	private String picture;
	private GroupService groupService = new GroupServiceImpl();
	private String cond;
	private String email;
	private String pwd;
	private String pwd2;
	private String txtCode;
	private List<Object> allGroup;
	private PagedListDataModel activityData = null;
	private List<Object> relatedActivity;
	private BenifitActivity benifitActivity;
	private PagedListDataModel relatedUserData;
	private List<Object> relatedUser;
	private PagedListDataModel appliedGroupData;
	private List<Object> allAppliedGroup;
	private AppliedGroupService appliedGroupService = new AppliedGroupServiceImpl();
	private BenifitActivityService benifitActivityService = new BenifitActivityServiceImpl();
	private List<Object> applyGroupUser;
	private PagedListDataModel applyGroupUserDate;
	private String errormsg;
	private Map<String, Integer> allGroupCategory;
	private GroupCategoryService groupCategoryService = new GroupCategoryServiceImpl();
	private UIData table;

	public UIData getTable() {
		return table;
	}

	public void setTable(UIData table) {
		this.table = table;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public String getTxtCode() {
		return txtCode;
	}

	public void setTxtCode(String txtCode) {
		this.txtCode = txtCode;
	}

	public List<Object> getAllGroup() {
		return allGroup;
	}

	public void setDataModel(PagedListDataModel dataModel) {
		this.dataModel = dataModel;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public GroupService getGroupService() {
		return groupService;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	public void setRelatedActivity(List<Object> relatedActivity) {
		this.relatedActivity = relatedActivity;
	}

	public List<Object> getRelatedActivity() {
		return relatedActivity;
	}

	public void setBenifitActivityService(
			BenifitActivityService benifitActivityService) {
		this.benifitActivityService = benifitActivityService;
	}

	public BenifitActivityService getBenifitActivityService() {
		return benifitActivityService;
	}

	public void setBenifitActivity(BenifitActivity benifitActivity) {
		this.benifitActivity = benifitActivity;
	}

	public BenifitActivity getBenifitActivity() {
		return benifitActivity;
	}

	public void setRelatedUser(List<Object> relatedUser) {
		this.relatedUser = relatedUser;
	}

	public List<Object> getRelatedUser() {
		return relatedUser;
	}

	public void setAppliedGroupData(PagedListDataModel appliedGroupData) {
		this.appliedGroupData = appliedGroupData;
	}

	public PagedListDataModel getAppliedGroupData() {
		return appliedGroupData;
	}

	public void setAllAppliedGroup(List<Object> allAppliedGroup) {
		this.allAppliedGroup = allAppliedGroup;
	}

	public List<Object> getAllAppliedGroup() {
		return allAppliedGroup;
	}

	public GroupBean() {
	}

	public void setAllGroup(List<Object> allGroup) {
		this.allGroup = allGroup;
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

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getPicture() {
		return picture;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Group getGroup() {
		int gid = StringAdapter.str2Int(JSFUtil.getRequest()
				.getParameter("gid"));
		if (group == null || group.getId() <= 0 || group.getId() != gid) {
			// System.out.println("中文文" + gid);
			if (gid > 0) {
				try {
					group = this.groupService.queryById(gid);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return group;
	}

	public void setApplyGroupUser(List<Object> applyGroupUser) {
		this.applyGroupUser = applyGroupUser;
	}

	public List<Object> getApplyGroupUser() {
		return applyGroupUser;
	}

	public void setApplyGroupUserDate(PagedListDataModel applyGroupUserDate) {
		this.applyGroupUserDate = applyGroupUserDate;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getCond() {
		return cond;
	}

	public void setCond(String cond) {
		this.cond = cond;
	}

	public String login() {
		if (!StringAdapter.isAvailableString(this.getEmail())
				|| !StringAdapter.isAvailableString(this.getPwd2())) {
			JSFUtil.createMessage("Email或密码错误");
			return "group_login";
		}
		try {
			Group group = this.getGroupService().login(this.getEmail(),
					this.getPwd2());
			// System.out.println(this.getEmail() + this.getPwd2());
			if (this.group != null) {
				group.setPwd(null);
				HttpSession session = JSFUtil.getSession();
				session.setAttribute("zoyiId", group.getId());
				session.setAttribute("zoyiIdentity", "group");
				session.setAttribute("zoyiGroup", group);

				HttpServletResponse response = JSFUtil.getResponse();
				this.removeCookie();
				Cookie zoyiEmailCookie = new Cookie("zoyiEmail", this
						.getEmail());
				Cookie zoyiPwdCookie = new Cookie("zoyiPwd", this
						.getGroupService().getCodePwd(this.getEmail()));
				Cookie zoyiIdent = new Cookie("zoyiIdent", "group");
				zoyiEmailCookie.setMaxAge(700000);
				zoyiPwdCookie.setMaxAge(700000);
				zoyiIdent.setMaxAge(700000);
				response.addCookie(zoyiEmailCookie);
				response.addCookie(zoyiPwdCookie);
				response.addCookie(zoyiIdent);
				return "index";
			} else {
				JSFUtil.createMessage("Email或密码错误");
				return "group_login";
			}
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.createMessage("出现错误！");
			return "group_login";
		}
	}

	public PagedListDataModel getRelatedUserData() {

		if (relatedUserData == null) {
			relatedUserData = new PagedListDataModel(pageSize) {
				// 查询分页函数
				public DataPage fetchPage(int startRow, int pageSize) {
					try {
						int gid = StringAdapter.obj2Int(JSFUtil.getSession()
								.getAttribute("zoyiId"));
						HttpServletRequest request = JSFUtil.getRequest();
						int baid = StringAdapter.str2Int(request
								.getParameter("baid"));
						int status = StringAdapter.str2Int(request
								.getParameter("status"));
						System.out.println(gid + ":" + baid + ":" + status);
						if (baid > 0 && status == 0) {
							relatedUser = benifitActivityService
									.queryUserByBAId(startRow, pageSize, baid);
							return new DataPage(benifitActivityService
									.getUserCountByBAId(baid), startRow,
									relatedUser);
						} else if (baid > 0 && status > 0) {
							relatedUser = benifitActivityService
									.queryUserByStatusBAId(startRow, pageSize,
											baid, status);
							return new DataPage(benifitActivityService
									.getUserCountByStatusBAId(baid, status),
									startRow, relatedUser);
						} else {
							relatedUser = groupService.queryApplyUserByGroupId(
									startRow, pageSize, gid);
							return new DataPage(groupService
									.getApplyUserCount(gid), startRow,
									relatedUser);
						}
					} catch (Exception e) {
						e.printStackTrace();
						JSFUtil.createMessage("查询失败！" + e);
						return new DataPage(0, startRow, relatedUser);
					}
				}
			};
		}
		return relatedUserData;
	}

	public PagedListDataModel getDataModel() {
		if (dataModel == null) {
			dataModel = new PagedListDataModel(pageSize) {
				// 查询分页函数
				public DataPage fetchPage(int startRow, int pageSize) {
					try {
						allGroup = groupService.queryBySoft(startRow, pageSize);
						return new DataPage(groupService.getCount(), startRow,
								allGroup);
					} catch (Exception e) {
						e.printStackTrace();
						JSFUtil.createMessage("查询失败！" + e);
						return new DataPage(0, startRow, allGroup);
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
					.str2Int(JSFUtil.getRequest().getParameter("gid"));
			if ("success".equalsIgnoreCase(this.groupService.deleteById(id))) {
				dataModel.refresh();
				this.errormsg = "删除成功！";
			}
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.createMessage("删除失败！" + e);
		}
		return "admin_manage_group";
	}

	public String adminPreModify() {
		try {
			id = StringAdapter
					.str2Int(JSFUtil.getRequest().getParameter("gid"));
			this.setGroup(this.groupService.queryById(id));
			System.out.println(id);
			System.out.println(this.group);
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.createMessage("系统错误！" + e);
		}
		return "admin_modify_group";
	}

	public String preModify() {
		try {
			id = StringAdapter
					.str2Int(JSFUtil.getRequest().getParameter("gid"));
			this.setGroup(this.groupService.queryById(id));
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.createMessage("系统错误！" + e);
			return "group_self_index";
		}
		return "group_self_modify";
	}

	@Override
	public String queryById() {
		try {
			id = StringAdapter
					.str2Int(JSFUtil.getRequest().getParameter("gid"));
			this.setGroup(this.groupService.queryById(id));
			return "group_content";
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.createMessage("系统错误，查无此人！" + e);
		}
		return "back";
	}

	public void ajaxDelete(ActionEvent event) {
		id = StringAdapter.str2Int(JSFUtil.getRequest().getParameter("gid"));
		try {
			if ("success".equalsIgnoreCase(this.groupService.deleteById(id))) {
				dataModel.refresh();
			}
		} catch (Exception e) {
			JSFUtil.createMessage("删除失败！");
			e.printStackTrace();
		}
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

	public PagedListDataModel getActivityData() {
		// System.out.println("中文中文"+
		// StringAdapter.obj2Int(JSFUtil.getSession().getAttribute("zoyiId")) +
		// ":"+ activityData);
		if (activityData == null) {
			activityData = new PagedListDataModel(pageSize) {
				// 查询分页函数
				public DataPage fetchPage(int startRow, int pageSize) {
					try {
						int id = StringAdapter.obj2Int(JSFUtil.getSession()
								.getAttribute("zoyiId"));
						// System.out.println("中文中文2" + id);
						if (id > 0) {
							relatedActivity = benifitActivityService
									.queryByGroupId(startRow, pageSize, id);
							// System.out.println(relatedActivity.size());
							return new DataPage(benifitActivityService
									.getCountByGroupId(id), startRow,
									relatedActivity);
						} else {
							relatedActivity = benifitActivityService
									.queryByPage(startRow, pageSize);
							return new DataPage(benifitActivityService
									.getCount(), startRow, relatedActivity);
						}
					} catch (Exception e) {
						e.printStackTrace();
						JSFUtil.createMessage("查询失败！" + e);
						return new DataPage(0, startRow, relatedActivity);
					}
				}
			};
		}
		return activityData;
	}

	public void ajaxRefuseUserApplyGroup(ActionEvent event) {
		int uid = StringAdapter.str2Int(JSFUtil.getRequest()
				.getParameter("uid"));
		try {
			id = StringAdapter.obj2Int(JSFUtil.getSession().getAttribute(
					"zoyiId"));
			this.groupService.refuseApplyGroupUser(uid, id);
		} catch (Exception e) {
			JSFUtil.createMessage("出现错误！" + e);
			e.printStackTrace();
		}
	}

	public void ajaxAcceptUserApplyGroup(ActionEvent event) {
		int uid = StringAdapter.str2Int(JSFUtil.getRequest()
				.getParameter("uid"));
		try {
			id = StringAdapter.obj2Int(JSFUtil.getSession().getAttribute(
					"zoyiId"));
			this.groupService.acceptApplyGroupUser(uid, id);
		} catch (Exception e) {
			JSFUtil.createMessage("出现错误！" + e);
			e.printStackTrace();
		}
	}

	public void groupAjaxRefuse(ActionEvent event) {
		int uid = StringAdapter.str2Int(JSFUtil.getRequest()
				.getParameter("uid"));
		int gid = StringAdapter.obj2Int(JSFUtil.getSession().getAttribute(
				"zoyiId"));
		try {
			this.groupService.refuseApplyGroupUser(uid, gid);
		} catch (Exception e) {
			JSFUtil.createMessage("出现错误！" + e);
			e.printStackTrace();
		}
	}

	public void ajaxAccept(ActionEvent event) {
		int id = StringAdapter
				.str2Int(JSFUtil.getRequest().getParameter("gid"));
		try {
			this.appliedGroupService.acceptGroup(id);
		} catch (Exception e) {
			JSFUtil.createMessage("出现错误！" + e);
			e.printStackTrace();
		}
	}

	public void ajaxModifyGroupPwd(ActionEvent event) {
		// System.out.println(pwd+""+pwd2);
		if (StringAdapter.isAvailableString(this.pwd)
				&& StringAdapter.isAvailableString(this.pwd2)
				&& pwd.endsWith(pwd2)) {
			int groupId = StringAdapter.obj2Int(JSFUtil.getSession()
					.getAttribute("zoyiId"));
			try {
				this.groupService.modifyGroupPwd(groupId, pwd);
			} catch (Exception e) {
				e.printStackTrace();
				this.setErrormsg("    密码修改失败！");
			}
			this.setErrormsg("    密码修改成功！");
		} else {
			this.setErrormsg("    密码修改失败！");
		}
	}

	public PagedListDataModel getApplyGroupUserDate() {

		if (applyGroupUserDate == null) {
			applyGroupUserDate = new PagedListDataModel(pageSize) {
				// 查询分页函数
				public DataPage fetchPage(int startRow, int pageSize) {
					try {
						id = ((Group) JSFUtil.getSession().getAttribute(
								"zoyiGroup")).getId();
						applyGroupUser = new GroupServiceImpl()
								.queryApplyUserByGroupId(startRow, pageSize, id);
						return new DataPage(groupService.getApplyUserCount(id),
								startRow, allGroup);
					} catch (Exception e) {
						e.printStackTrace();
						JSFUtil.createMessage("查询失败！" + e);
						return new DataPage(0, startRow, applyGroupUser);
					}
				}
			};
		}
		return applyGroupUserDate;
	}

	@Override
	public String modify() {
		try {
			/*
			 * System.out.println(this.group.getAddress());
			 * System.out.println(this.group.getAdPicture());
			 * System.out.println(this.group.getBirthCity());
			 * System.out.println(this.group.getBirthProvince());
			 * System.out.println(this.group.getCredit());
			 * System.out.println(this.group.getEmail());
			 * System.out.println(this.group.getFuture());
			 * System.out.println(this.group.getGroupName());
			 * System.out.println(this.group.getLinkman());
			 * System.out.println(this.group.getLogoPicture());
			 * System.out.println(this.group.getNature());
			 * System.out.println(this.group.getPwd());
			 * System.out.println(this.group.getScale());
			 * System.out.println(this.group.getBirthDay());
			 */
			this.group.setFuture(JSFUtil.getRequest().getParameter("future"));
			// picture =
			// this.getGroupService().queryPicById(this.group.getId());
			// 记得更改，将旧文件删除。
			if ("success"
					.equalsIgnoreCase(this.groupService.modify(this.group)))
				;
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.createMessage("修改失败！" + e);
			return "back";
		}
		return "admin_manage_group";
	}

	@Override
	public String add() {
		try {
			/*
			 * System.out.println(this.group.getAddress());
			 * System.out.println(this.group.getAdPicture());
			 * System.out.println(this.group.getBirthCity());
			 * System.out.println(this.group.getBirthProvince());
			 * System.out.println(this.group.getCredit());
			 * System.out.println(this.group.getEmail());
			 * System.out.println(this.group.getFuture());
			 * System.out.println(this.group.getGroupName());
			 * System.out.println(this.group.getLinkman());
			 * System.out.println(this.group.getLogoPicture());
			 * System.out.println(this.group.getNature());
			 * System.out.println(this.group.getPwd());
			 * System.out.println(this.group.getScale());
			 * System.out.println(this.group.getBirthDay());
			 */
			if ("success".equalsIgnoreCase(groupService.add(this.group)))
				;
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.createMessage("新增失败！" + e);
			return "admin_add_group";
		}
		return "admin_manage_group";
	}

	public void removeCookie() {
		Cookie cookie[] = JSFUtil.getRequest().getCookies();
		if (cookie != null && cookie.length > 0) {
			for (int i = 0; i < cookie.length; i++) {
				if (cookie[i].getName().equals("zoyiIdent")
						|| cookie[i].getName().equals("zoyiEmail")
						|| cookie[i].getName().equals("zoyiPwd")) {
					cookie[i].setMaxAge(0);
				}
			}
		}
	}

	public Map<String, Integer> getAllGroupCategory() {
		try {
			this.allGroupCategory = GroupCategoryCollectionAdapter
					.toMap(this.groupCategoryService.queryAll());
		} catch (Exception e) {
			errormsg = "提取组织分类出错了！";
			JSFUtil.createMessage("提取组织分类出错了！" + e);
			e.printStackTrace();
		}
		return allGroupCategory;
	}

}