package org.zoyi.vo;

import java.util.Date;

public class AppliedGroup {

	public AppliedGroup() {
	}

	private int id;
	private String groupName;
	private String birthProvince;
	private String birthCity;
	private String phone;
	private String pwd ;
	private String email;
	private String address;
	private String linkman;//联系人
	private Date applyDate;//申请时间，当天
	private String applyStatus; //状态，0表示正在申请中，2表示通过申请，1表示拒绝申请
	private GroupCategory groupCategory;
	private Userinfo userinfo ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getBirthProvince() {
		return birthProvince;
	}
	public void setBirthProvince(String birthProvince) {
		this.birthProvince = birthProvince;
	}
	public String getBirthCity() {
		return birthCity;
	}
	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}
	public String getApplyStatus() {
		return applyStatus;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPwd() {
		return pwd;
	}
	public void setGroupCategory(GroupCategory groupCategory) {
		this.groupCategory = groupCategory;
	}
	public GroupCategory getGroupCategory() {
		return groupCategory;
	}
	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	public Userinfo getUserinfo() {
		return userinfo;
	}
}