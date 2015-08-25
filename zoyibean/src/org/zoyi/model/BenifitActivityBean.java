package org.zoyi.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import org.zoyi.adapter.StringAdapter;
import org.zoyi.jsf.JSFUtil;
import org.zoyi.service.BenifitActivityService;
import org.zoyi.service.UserService;
import org.zoyi.service.impl.*;
import org.zoyi.util.DataPage;
import org.zoyi.util.PagedListDataModel;
import org.zoyi.vo.*;

public class BenifitActivityBean implements ModelBase {

	public BenifitActivityBean() {
	}

	private int id;
	private String txtCode;
	private String cond;
	private BenifitActivity benifitActivity;
	private List<Object> allBenifitActivity;
	private int scrollerPage = 1;
	private PagedListDataModel dataModel;
	private int pageSize = 10;
	private AppliedGroup appliedGroup;
	private UserService userService = new UserServiceImpl();
	private BenifitActivityService benifitActivityService = new BenifitActivityServiceImpl();
	private PagedListDataModel relatedUserData;
	private List<Object> relatedUser;
	private String errormsg;

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String getErrormsg() {
		return errormsg;
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

	public String getCond() {
		return cond;
	}

	public void setCond(String cond) {
		this.cond = cond;
	}

	public BenifitActivity getBenifitActivity() {
		return benifitActivity;
	}

	public void setBenifitActivity(BenifitActivity benifitActivity) {
		this.benifitActivity = benifitActivity;
	}

	public List<Object> getAllBenifitActivity() {
		return allBenifitActivity;
	}

	public void setRelatedUserData(PagedListDataModel relatedUserData) {
		this.relatedUserData = relatedUserData;
	}

	public void setRelatedUser(List<Object> relatedUser) {
		this.relatedUser = relatedUser;
	}

	public List<Object> getRelatedUser() {
		return relatedUser;
	}

	public void setAllBenifitActivity(List<Object> allBenifitActivity) {
		this.allBenifitActivity = allBenifitActivity;
	}

	public int getScrollerPage() {
		return scrollerPage;
	}

	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
	}

	public PagedListDataModel getDataModel() {
		if (dataModel == null) {
			dataModel = new PagedListDataModel(pageSize) {
				// 查询分页函数
				public DataPage fetchPage(int startRow, int pageSize) {
					try {
						allBenifitActivity = benifitActivityService
								.queryByPage(startRow, pageSize);
						return new DataPage(benifitActivityService.getCount(),
								startRow, allBenifitActivity);
					} catch (Exception e) {
						JSFUtil.createMessage("出错了！" + e);
						allBenifitActivity = new ArrayList<Object>();
						e.printStackTrace();
					}
					return new DataPage(0, startRow, allBenifitActivity);
				}
			};
		}
		return dataModel;
	}

	public void setDataModel(PagedListDataModel dataModel) {
		this.dataModel = dataModel;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public AppliedGroup getAppliedGroup() {
		return appliedGroup;
	}

	public void setAppliedGroup(AppliedGroup appliedGroup) {
		this.appliedGroup = appliedGroup;
	}

	public BenifitActivityService getBenifitActivityService() {
		return benifitActivityService;
	}

	public void setBenifitActivityService(
			BenifitActivityService benifitActivityService) {
		this.benifitActivityService = benifitActivityService;
	}

	@Override
	public String add() {
		// System.out.println(this.benifitActivity.getStatus());
		try {
			benifitActivity.setGroup((Group) JSFUtil.getSession().getAttribute(
					"zoyiGroup"));
			benifitActivity.setDetail(JSFUtil.getRequest().getParameter(
					"workDescription"));
			if (benifitActivity.getGroup() != null
					&& "success".equalsIgnoreCase(this.benifitActivityService
							.add(getBenifitActivity()))) {
				return "success";
			}
		} catch (Exception e) {
			errormsg = "添加失败！";
			JSFUtil.createMessage("添加失败！" + e);
			e.printStackTrace();
		}
		return "group_self_activity";
	}

	@Override
	public String deleteById() {
		id = StringAdapter.str2Int(JSFUtil.getRequest().getParameter("baid"));
		try {
			if ("success".equalsIgnoreCase(this.benifitActivityService
					.deleteById(id))) {
				dataModel.refresh();
				errormsg = "添加成功！";
			}
		} catch (Exception e) {
			errormsg = "添加失败！";
			JSFUtil.createMessage("删除失败！" + e);
			e.printStackTrace();
		}
		return "admin_manage_activity";
	}

	@Override
	public String modify() {
		try {
			if ("success".equalsIgnoreCase(this.benifitActivityService
					.modify(getBenifitActivity()))) {
				errormsg = "修改成功！";
				dataModel.refresh();
				return "group_self_activity";
			}
		} catch (Exception e) {

			JSFUtil.createMessage("修改失败！" + e);
			e.printStackTrace();
		}
		errormsg = "修改失败！";
		return "group_modify_activity";
	}

	public String groupPreModify() {
		id = StringAdapter.str2Int(JSFUtil.getRequest().getParameter("baid"));
		try {
			this.setBenifitActivity(this.benifitActivityService.queryById(id));
			return "group_manage_activity";
		} catch (Exception e) {

			JSFUtil.createMessage("查找失败！" + e);
			e.printStackTrace();

		}
		this.errormsg = "查找失败！";
		return "group_modify_activity";
	}

	@Override
	public String queryById() {
		id = StringAdapter.str2Int(JSFUtil.getRequest().getParameter("baid"));
		try {
			this.setBenifitActivity(this.benifitActivityService.queryById(id));
			return "user_group_activity";
		} catch (Exception e) {

			JSFUtil.createMessage("查找失败！" + e);
			e.printStackTrace();
		}
		this.errormsg = "查找失败！";
		return "admin_release_announcement";
	}

	public PagedListDataModel getRelatedUserData() {
		relatedUserData = new PagedListDataModel(pageSize) {
			// 查询分页函数
			public DataPage fetchPage(int startRow, int pageSize) {
				try {
					int aid = StringAdapter.obj2Int(JSFUtil.getSession()
							.getAttribute("zoyiId"));
					HttpServletRequest request = JSFUtil.getRequest();
					int baid = StringAdapter.str2Int(request
							.getParameter("baid"));
					// int status =
					// StringAdapter.str2Int(request.getParameter("status"));
					// System.out.println(aid + ":" + baid + ":" + aid);
					if (aid > 0) {
						if (baid > 0 && benifitActivity.getId() != baid) {
							benifitActivity = benifitActivityService
									.queryById(baid);
						}
						relatedUser = benifitActivityService.queryUserByBAId(
								startRow, pageSize, baid);
						return new DataPage(benifitActivityService
								.getUserCountByBAId(baid), startRow,
								relatedUser);
					}
				} catch (Exception e) {
					e.printStackTrace();
					JSFUtil.createMessage("查询失败！" + e);
				}
				return new DataPage(0, startRow, relatedUser);
			}
		};
		return relatedUserData;
	}

	@Override
	public String preModify() {
		id = StringAdapter.str2Int(JSFUtil.getRequest().getParameter("baid"));
		try {
			this.setBenifitActivity(this.benifitActivityService.queryById(id));
		} catch (Exception e) {
			JSFUtil.createMessage("添加失败！" + e);
			e.printStackTrace();
			return "group_self_activity";
		}
		return "group_modify_activity";
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void ajaxAccept(ActionEvent event) {
		int uid = StringAdapter.str2Int(JSFUtil.getRequest()
				.getParameter("uid"));
		int baid = StringAdapter.str2Int(JSFUtil.getRequest().getParameter(
				"baid"));
		try {
			if ("success".equalsIgnoreCase(this.benifitActivityService
					.acceptUser(uid, baid))) {
				relatedUserData.refresh();
			}
		} catch (Exception e) {
			JSFUtil.createMessage("出现错误！" + e);
			e.printStackTrace();
		}
	}

	public void noCredit(ActionEvent event) {
		int uid = StringAdapter.str2Int(JSFUtil.getRequest()
				.getParameter("uid"));
		int baid = StringAdapter.str2Int(JSFUtil.getRequest().getParameter(
				"baid"));
		if (uid > 0 && baid > 0) {
			try {

				this.benifitActivityService.addUserCredit(0, -1, uid, baid);
			} catch (Exception e) {
				JSFUtil.createMessage("出现错误！" + e);
				e.printStackTrace();
			}
		}
	}

	public void addCredit(ActionEvent event) {
		int uid = StringAdapter.str2Int(JSFUtil.getRequest()
				.getParameter("uid"));
		int baid = StringAdapter.str2Int(JSFUtil.getRequest().getParameter(
				"baid"));
		try {
			this.benifitActivityService.addUserCredit(1, 0, uid, baid);
		} catch (Exception e) {
			JSFUtil.createMessage("出现错误！" + e);
			e.printStackTrace();
		}
	}

	public void ajaxRefuse(ActionEvent event) {
		int uid = StringAdapter.str2Int(JSFUtil.getRequest()
				.getParameter("uid"));
		int baid = StringAdapter.str2Int(JSFUtil.getRequest().getParameter(
				"baid"));
		try {
			if ("success".equalsIgnoreCase(this.benifitActivityService
					.refuseUser(uid, baid))) {
				relatedUserData.refresh();
			}
		} catch (Exception e) {
			JSFUtil.createMessage("出现错误！" + e);
			e.printStackTrace();
		}
	}
	
	public String addAllCredit(){
		int baid = StringAdapter.str2Int(JSFUtil.getRequest().getParameter(
		"baid"));
		System.out.println(baid);
		try {
			this.errormsg = ""+this.benifitActivityService.addAllUserCreditByBAId(1, 0, baid);
		} catch (Exception e) {
			JSFUtil.createMessage(""+errormsg);
			e.printStackTrace();
		}
		return "admin_manage_activityusercredit";
	}

}