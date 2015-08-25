package org.zoyi.vo;

import java.util.Date;

public class NewsCategory {

	private String newsCategoryName;
	private int id;
	private Date createDate;
	private String remark ;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public NewsCategory() {
	}

	public void setNewsCategoryName(String newsCategoryName) {
		this.newsCategoryName = newsCategoryName;
	}

	public String getNewsCategoryName() {
		return newsCategoryName;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

}
