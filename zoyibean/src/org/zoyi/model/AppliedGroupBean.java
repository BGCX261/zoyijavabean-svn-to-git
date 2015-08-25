package org.zoyi.model;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import org.zoyi.adapter.*;
import org.zoyi.jsf.JSFUtil;
import org.zoyi.service.AppliedGroupService;
import org.zoyi.service.impl.AppliedGroupServiceImpl;
import org.zoyi.util.DataPage;
import org.zoyi.util.PagedListDataModel;
import org.zoyi.vo.*;

public class AppliedGroupBean implements ModelBase {
	private int scrollerPage = 1;
	private PagedListDataModel dataModel;
	private int pageSize = 10;
	private int id;
	private AppliedGroup appliedGroup;
	private AppliedGroupService appliedGroupService = new AppliedGroupServiceImpl();
	private String txtCode;
	private String cond;
	private List<Object> allAppliedGroup;
	private String errormsg;

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public String accept() {
		id = StringAdapter.str2Int(JSFUtil.getRequest().getParameter("agid"));
		try {
			appliedGroupService.acceptGroup(id);
		} catch (Exception e) {
			JSFUtil.createMessage("出现错误！" + e);
			e.printStackTrace();
		}
		return "admin_manage_appliedGroup";
	}

	public AppliedGroupService getAppliedGroupService() {
		return appliedGroupService;
	}

	public void setAppliedGroupService(AppliedGroupService appliedGroupService) {
		this.appliedGroupService = appliedGroupService;
	}

	public AppliedGroupBean() {
	}

	public void setAllAppliedGroup(List<Object> allAppliedGroup) {
		this.allAppliedGroup = allAppliedGroup;
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

	public PagedListDataModel getDataModel() {
		if (dataModel == null) {
			dataModel = new PagedListDataModel(pageSize) {
				// 查询分页函数
				public DataPage fetchPage(int startRow, int pageSize) {
					try {
						allAppliedGroup = appliedGroupService.queryByPage(
								startRow, pageSize);
						return new DataPage(appliedGroupService.getCount(),
								startRow, allAppliedGroup);
					} catch (Exception e) {
						e.printStackTrace();
						JSFUtil.createMessage("查询失败！" + e);
						return new DataPage(0, startRow, allAppliedGroup);
					}
				}
			};
		}
		return dataModel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AppliedGroup getAppliedGroup() {
		return appliedGroup;
	}

	public void setAppliedGroup(AppliedGroup appliedGroup) {
		this.appliedGroup = appliedGroup;
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
			if (StringAdapter.isAvailableString(txtCode)
					&& this.txtCode
							.equalsIgnoreCase(StringAdapter.obj2str(JSFUtil
									.getSession().getAttribute("code")))
					&& "success".equalsIgnoreCase(appliedGroupService
							.add(this.appliedGroup))) {
				sucGo("index.php", "申请成功！请等待管理员审批。会以邮件的形式通知您，请即时查收。");
				return "success";
			} else {
				this.errormsg = "验证码输入错误！";
				JSFUtil.createMessage("验证码输入错误！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.errormsg = "申请失败！请联系管理员。";
			JSFUtil.createMessage("申请失败！" + e);
		}
		return "group_apply.jsp";
	}

	@Override
	public String deleteById() {
		try {
			id = StringAdapter.str2Int(JSFUtil.getRequest()
					.getParameter("agid"));
			this.appliedGroupService.deleteById(id);
			dataModel.refresh();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.createMessage("删除失败！");
		}
		return "admin_manage_appliedGroup";
	}

	@Override
	public String modify() {
		try {
			if (this.appliedGroup != null
					&& "success".equalsIgnoreCase(appliedGroupService
							.modify(this.appliedGroup)))
				return "admin_manage_appliedGroup";
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.createMessage("修改失败！" + e);
		}
		return "admin_modify_appliedGroup";
	}

	public String preModify() {
		try {
			id = StringAdapter.str2Int(JSFUtil.getRequest()
					.getParameter("agid"));
			this.setAppliedGroup(this.appliedGroupService.queryById(id));
			// System.out.println(this.getAppliedGroup().getEmail()+":"+this.getAppliedGroup().getPwd());
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.createMessage("系统错误，查无此组织！" + e);
			return "admin_manage_appliedGroup";
		}
		return "admin_modify_appliedGroup";
	}

	@Override
	public String queryById() {
		try {
			id = StringAdapter.str2Int(JSFUtil.getRequest()
					.getParameter("agid"));
			this.setAppliedGroup(this.appliedGroupService.queryById(id));
			// System.out.println("::" + this.appliedGroupService.queryById(
			// this.appliedGroup.getId()).getGroupName());
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.createMessage("系统错误，查无此人！" + e);
			return "appliedGroup_content";
		}
		return "appliedGroup_content";
	}

	public void ajaxDelete(ActionEvent event) {
		id = StringAdapter.str2Int(JSFUtil.getRequest().getParameter("agid"));
		try {
			if ("success".equalsIgnoreCase(this.appliedGroupService
					.deleteById(id))) {
				dataModel.refresh();
			} else {
				JSFUtil.createMessage("删除失败！");
			}
		} catch (Exception e) {
			JSFUtil.createMessage("删除失败！" + e);
			e.printStackTrace();
		}
	}

	public void ajaxAccept(ActionEvent event) {
		int id = StringAdapter.str2Int(JSFUtil.getRequest()
				.getParameter("agid"));
		String status = JSFUtil.getRequest().getParameter("status");
		if (!"2".equals(status)) {
			try {
				if ("success".equalsIgnoreCase(this.appliedGroupService
						.acceptGroup(id))
						&& !"2".equals(status)) {
					dataModel.refresh();
				}
			} catch (Exception e) {
				JSFUtil.createMessage("出错了！" + e);
				e.printStackTrace();
			}
		} else {
			this.errormsg = "当前状态不支持此操作！";
		}
	}

	public void ajaxRefuse(ActionEvent event) {
		int id = StringAdapter.str2Int(JSFUtil.getRequest()
				.getParameter("agid"));
		String status = JSFUtil.getRequest().getParameter("status");
		if ("0".equals(status)) {
			try {
				"success".equalsIgnoreCase(this.appliedGroupService
						.refuseGroup(id));
				dataModel.refresh();
			} catch (Exception e) {
				JSFUtil.createMessage("出错了！" + e);
				e.printStackTrace();
			}
		} else {
			this.errormsg = "当前状态不支持此操作！";
		}
	}

	public String apply() {
		// System.out.println(appliedGroup.getGroupCategory().getId());
		try {
			if (this.txtCode.equalsIgnoreCase(StringAdapter.obj2str(JSFUtil
					.getSession().getAttribute("code")))) {
				"success".equalsIgnoreCase(appliedGroupService
						.add(this.appliedGroup));
				sucGo("index.php", "申请成功！请等待管理员审批。会以邮件的形式通知您，请即时查收。");
				return "success";
			} else {
				JSFUtil.createMessage("验证码输入错误！");
				this.setErrormsg("验证码输入错误！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.createMessage("申请失败！" + e);
			this.setErrormsg("申请失败！");
		}
		return "group_apply";
	}

	public void setCond(String cond) {
		this.cond = cond;
	}

	public String getCond() {
		return cond;
	}

	private static void sucGo(String url, String msg) {
		HttpServletRequest request = JSFUtil.getRequest();
		request.setAttribute("url", url);
		request.setAttribute("message", msg);
	}
}