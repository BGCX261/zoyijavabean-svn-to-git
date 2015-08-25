package org.zoyi.model;

import java.util.List;

import org.zoyi.util.DataPage;
import org.zoyi.util.PagedListDataModel;
import org.zoyi.vo.*;
import org.zoyi.jsf.*;
import org.zoyi.adapter.*;
import org.zoyi.service.*;
import org.zoyi.service.impl.*;

public class GroupIndexBean {

	public GroupIndexBean() {
		// TODO Auto-generated constructor stub
	}

	private int scrollerPage = 1;
	private PagedListDataModel dataModel;
	private int pageSize = 10;
	private int id;
	private Group group;
	private List<Object> relatedActivities;
	private GroupService groupService = new GroupServiceImpl();
	private BenifitActivityService benifitActivityService = new BenifitActivityServiceImpl();
	private String errormsg;

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public List<Object> getRelatedActivities() {
		return relatedActivities;
	}

	public void setRelatedActivities(List<Object> relatedActivities) {
		this.relatedActivities = relatedActivities;
	}

	public BenifitActivityService getBenifitActivityService() {
		return benifitActivityService;
	}

	public void setBenifitActivityService(
			BenifitActivityService benifitActivityService) {
		this.benifitActivityService = benifitActivityService;
	}

	public PagedListDataModel getDataModel() {
		if (dataModel == null) {
			dataModel = new PagedListDataModel(pageSize) {
				// 查询分页函数
				public DataPage fetchPage(int startRow, int pageSize) {
					try {
						relatedActivities = benifitActivityService
								.queryByGroupId(startRow, pageSize, id);
						return new DataPage(groupService.getCount(), startRow,
								relatedActivities);
					} catch (Exception e) {
						e.printStackTrace();
						JSFUtil.createMessage("查询失败！" + e);
						return new DataPage(1, startRow, relatedActivities);
					}
				}
			};
		}
		return dataModel;
	}

	public int getScrollerPage() {
		return scrollerPage;
	}

	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
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

	public Group getGroup() {
		id = StringAdapter.str2Int(JSFUtil.getRequest().getParameter("id"));
		try {
			group = this.groupService.queryById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return group;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GroupService getGroupService() {
		return groupService;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}