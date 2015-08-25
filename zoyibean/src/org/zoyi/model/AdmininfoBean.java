package org.zoyi.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.zoyi.adapter.StringAdapter;
import org.zoyi.jsf.JSFUtil;
import org.zoyi.service.*;
import org.zoyi.service.impl.AdminServiceImpl;
import org.zoyi.service.impl.BenifitActivityServiceImpl;
import org.zoyi.util.DataPage;
import org.zoyi.util.PagedListDataModel;
import org.zoyi.vo.*;

public class AdmininfoBean implements ModelBase {
	private int id;
	private Admininfo admininfo;
	private String pwd2;
	private String txtCode;
	private AdminService adminService = new AdminServiceImpl();
	private String errormsg;
	private int scrollerPage = 1;
	private String cond;
	private int pageSize = 10;
	private BenifitActivityService benifitActivityService = new BenifitActivityServiceImpl();
	private PagedListDataModel endDataModel;
	private BenifitActivity benifitActivity;
	private List<Object> allBenifitActivity;

	public void setEndDataModel(PagedListDataModel endDataModel) {
		this.endDataModel = endDataModel;
	}

	public int getScrollerPage() {
		return scrollerPage;
	}

	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
	}

	public String getCond() {
		return cond;
	}

	public void setCond(String cond) {
		this.cond = cond;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public BenifitActivityService getBenifitActivityService() {
		return benifitActivityService;
	}

	/**
	 * 
	 */
	public AdmininfoBean() {
		super();
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public void setTxtCode(String txtCode) {
		this.txtCode = txtCode;
	}

	public String getTxtCode() {
		return txtCode;
	}

	public void setAdmininfo(Admininfo admininfo) {
		this.admininfo = admininfo;
	}

	public Admininfo getAdmininfo() {
		return admininfo;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setBenifitActivityService(
			BenifitActivityService benifitActivityService) {
		this.benifitActivityService = benifitActivityService;
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

	public void setAllBenifitActivity(List<Object> allBenifitActivity) {
		this.allBenifitActivity = allBenifitActivity;
	}

	public PagedListDataModel getEndDataModel() {
		if (endDataModel == null) {
			endDataModel = new PagedListDataModel(pageSize) {
				// 查询分页函数
				public DataPage fetchPage(int startRow, int pageSize) {
					try {
						int status = StringAdapter.str2Int(JSFUtil.getRequest()
								.getParameter("status"));
						java.util.Date date = new java.util.Date();
						allBenifitActivity = benifitActivityService
								.queryByEndtime(startRow, pageSize, date,
										status);
						return new DataPage(benifitActivityService
								.getCountByEndtime(date, status), startRow,
								allBenifitActivity);
					} catch (Exception e) {
						JSFUtil.createMessage("出错了！" + e);
						allBenifitActivity = new ArrayList<Object>();
						e.printStackTrace();
					}
					return new DataPage(0, startRow, allBenifitActivity);
				}
			};
		}
		return endDataModel;
	}

	public String login() {
		if (this.txtCode.equals(StringAdapter.obj2str(JSFUtil.getSession()
				.getAttribute("code")))) {
			try {
				Admininfo admininfo = this.getAdminService().login(
						this.admininfo.getName(), this.admininfo.getPwd());
				// System.out.println(admininfo.getInnerId()+":"+admininfo);
				if (admininfo == null || admininfo.getInnerId() <= 0) {
					errormsg = "登陆出错了！";
					JSFUtil.createMessage("登陆出错了！");
				} else {
					JSFUtil.getSession().setAttribute("zoyiAdmin", admininfo);
					JSFUtil.getSession().setAttribute("zoyiIdentity", "admin");
					JSFUtil.getSession().setAttribute("zoyiId",
							admininfo.getInnerId());
					errormsg = "欢迎您的到来！";
					sucGo("admin_manage.php", errormsg);
					return "success";
				}
			} catch (Exception e) {
				setErrormsg("登录出错");
				JSFUtil.createMessage("登录出错！" + e);
				e.printStackTrace();
			}
		} else {
			setErrormsg("登录出错验证码出错！");
			JSFUtil.createMessage("验证码出错！");
		}
		return "admin_login";
	}

	@Override
	public String add() {
		try {
			if ("success".equalsIgnoreCase(this.getAdminService().add(
					getAdmininfo()))) {
				errormsg = "新增管理员成功！";
				sucGo("admin_manage_admin.php", errormsg);
				return "success";
			}
		} catch (Exception e) {
			JSFUtil.createMessage("新增管理员失败！" + e);
			e.printStackTrace();
		}
		errormsg = "新增管理员失败！";
		return "admin_add_admin";
	}

	@Override
	public String deleteById() {
		id = StringAdapter.str2Int(JSFUtil.getRequest().getParameter("aid"));
		try {
			if ("success".equalsIgnoreCase(this.getAdminService()
					.deleteById(id))) {
				;
			}
		} catch (Exception e) {
			errormsg = "删除管理员失败！";
			JSFUtil.createMessage("删除管理员失败！" + e);
			e.printStackTrace();
		}
		return "admin_manage_admin";
	}

	@Override
	public String preModify() {
		id = StringAdapter.str2Int(JSFUtil.getRequest().getParameter("aid"));
		try {
			this.admininfo = this.getAdminService().queryById(getId());
		} catch (Exception e) {
			errormsg = "查找管理员失败！";
			JSFUtil.createMessage("查找管理员失败！" + e);
			e.printStackTrace();
			return "admin_modify_admin";
		}
		return "admin_manage_admin";
	}

	@Override
	public String modify() {
		try {
			if (!"success".equalsIgnoreCase(this.getAdminService().modify(
					getAdmininfo()))) {
				return "admin_modify_admin";
			}
		} catch (Exception e) {
			errormsg = "修改管理员失败！";
			JSFUtil.createMessage("修改管理员失败！" + e);
			e.printStackTrace();
			return "admin_manage_admin";
		}
		return "admin_modify_admin";
	}

	@Override
	public String queryById() {
		id = StringAdapter.str2Int(JSFUtil.getRequest().getParameter("aid"));
		try {
			this.admininfo = this.getAdminService().queryById(getId());
		} catch (Exception e) {
			errormsg = "查找管理员失败！";
			JSFUtil.createMessage("查找管理员失败！" + e);
			e.printStackTrace();
			return "fail";
		}
		return "admin_manage_admin";
	}

	public boolean isAdmin(Admininfo admininfo) {
		try {
			this.getAdminService().isExist(admininfo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private static void sucGo(String url, String msg) {
		HttpServletRequest request = JSFUtil.getRequest();
		request.setAttribute("url", url);
		request.setAttribute("message", msg);
	}
}
