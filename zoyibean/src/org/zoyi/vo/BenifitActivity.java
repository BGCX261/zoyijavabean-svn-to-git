package org.zoyi.vo;

import java.util.Date;

public class BenifitActivity {

	public BenifitActivity() {
		// TODO Auto-generated constructor stub
	}
	private int id ;
	private String province;
	private String city;
	private String location;
	private String poster;
	private Date deadline;
	private Date starttime;
	private Date endtime;
	private Integer membernum;
	private Integer follownum;
	private Date updatetime;
	private String activityName ;
	private int uid ;//发起者
	private String detail ;
	private int limitnum ;
	private Group group ;
	private int allowfellow ;
	private int threadnum ;
	private BenifitActivityCategory benifitActivityCategory ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public Integer getMembernum() {
		return membernum;
	}
	public void setMembernum(Integer membernum) {
		this.membernum = membernum;
	}
	public Integer getFollownum() {
		return follownum;
	}
	public void setFollownum(Integer follownum) {
		this.follownum = follownum;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getLimitnum() {
		return limitnum;
	}
	public void setLimitnum(int limitnum) {
		this.limitnum = limitnum;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public int getAllowfellow() {
		return allowfellow;
	}
	public void setAllowfellow(int allowfellow) {
		this.allowfellow = allowfellow;
	}
	public int getThreadnum() {
		return threadnum;
	}
	public void setThreadnum(int threadnum) {
		this.threadnum = threadnum;
	}
	public BenifitActivityCategory getBenifitActivityCategory() {
		return benifitActivityCategory;
	}
	public void setBenifitActivityCategory(
			BenifitActivityCategory benifitActivityCategory) {
		this.benifitActivityCategory = benifitActivityCategory;
	}
	
}
