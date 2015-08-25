package org.zoyi.vo;

import java.util.Date;

public class Userinfo {
	private int userId;
	private Date birthday;
	private String name;
	private String email;
	private String gender;
	private String pwd;
	private int age ;
	//所在院校或机构
	private String username;
	private String status;
	private String phone;
	private String birthProvince;
	private String birthCity;
	private String nowAddress;
	private String picture;
	private String unit ;
	private String index ;
	private int takeinGroupNum;//参加了几个组织
	private int takeinActivityNum;//参加了几个活动
	private Date applyDate;
	private String activityStatus ;
	private String groupStatus ;
	private int darkmind;
	private int credit;
	private int rank ;
	private String qq ;
	private String msn ;
	private String blood ;
	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	/*
	 * 相关活动状态，比如我调用benifitActivityService.queryByGroupId()等方法时，得到的是userinfo的一个LIST，但是我并不知道该用户对于这个活动的状态是什么啊
	 * 那么就应该在这给我
	 */
	public int getTakeinGroupNum() {
		return takeinGroupNum;
	}

	public void setTakeinGroupNum(int takeinGroupNum) {
		this.takeinGroupNum = takeinGroupNum;
	}

	public int getTakeinActivityNum() {
		return takeinActivityNum;
	}

	public void setTakeinActivityNum(int takeinActivityNum) {
		this.takeinActivityNum = takeinActivityNum;
	}

	public String getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}

	public String getGroupStatus() {
		return groupStatus;
	}

	public void setGroupStatus(String groupStatus) {
		this.groupStatus = groupStatus;
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

	public String getNowAddress() {
		return nowAddress;
	}

	public void setNowAddress(String nowAddress) {
		this.nowAddress = nowAddress;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	/**
	 * 
	 */
	public Userinfo() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getIndex() {
		return index;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setDarkmind(int darkmind) {
		this.darkmind = darkmind;
	}

	public int getDarkmind() {
		return darkmind;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getUnit() {
		return unit;
	}

}
