package org.zoyi.vo;

import java.util.Date;
import java.util.List;

public class UserActivity {

	public UserActivity() {
		// TODO Auto-generated constructor stub
	}

	private Userinfo userinfo ;
	private Group group ;
	private BenifitActivity benifitActivity ;
	private Date applyDate ;
	private String status ; //活动状态:参加、过期、报名、收藏 、退出、被拒绝、申请中
	private String nowAddress ;
	private int age ;
	private String email ;
	private String remark ;
	private String unit ; //所在单位
	private List<Object> relatedUser ;
	private List<Object> relatedActivity;
	
	public String getNowAddress() {
		return nowAddress;
	}
	public void setNowAddress(String nowAddress) {
		this.nowAddress = nowAddress;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public BenifitActivity getBenifitActivity() {
		return benifitActivity;
	}
	public void setBenifitActivity(BenifitActivity benifitActivity) {
		this.benifitActivity = benifitActivity;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	public Userinfo getUserinfo() {
		return userinfo;
	}
	public void setRelatedActivity(List<Object> relatedActivity) {
		this.relatedActivity = relatedActivity;
	}
	public List<Object> getRelatedActivity() {
		return relatedActivity;
	}
	public void setRelatedUser(List<Object> relatedUser) {
		this.relatedUser = relatedUser;
	}
	public List<Object> getRelatedUser() {
		return relatedUser;
	}
	
}
