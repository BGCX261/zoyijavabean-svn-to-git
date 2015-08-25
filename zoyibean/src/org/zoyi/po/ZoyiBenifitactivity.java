package org.zoyi.po;

import java.sql.Timestamp;
import java.util.Date;

/**
 * ZoyiBenifitactivity entity. @author MyEclipse Persistence Tools
 */

public class ZoyiBenifitactivity implements java.io.Serializable {

	// Fields

	private Integer id;
	private String activityname;
	private String activityplace;
	private Date createtime;
	private Date begintime;
	private Date endingtime;
	private String picture;
	private String chiefpeople;
	private String linkman;
	private String phone;
	private String email;
	private String activitydescription;
	private String workdescription;
	private String remark;
	private Integer limitpeoplenum;
	private int groupId;
	private Date applydeadline;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public void setApplydeadline(Date applydeadline) {
		this.applydeadline = applydeadline;
	}

	private Integer applyingpeoplenum;
	private Integer acceptedpeoplenum;
	private String status;
	private String nature;

	// Constructors

	/** default constructor */
	public ZoyiBenifitactivity() {
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActivityname() {
		return this.activityname;
	}

	public void setActivityname(String activityname) {
		this.activityname = activityname;
	}

	public String getActivityplace() {
		return this.activityplace;
	}

	public void setActivityplace(String activityplace) {
		this.activityplace = activityplace;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getBegintime() {
		return this.begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	public Date getEndingtime() {
		return this.endingtime;
	}

	public void setEndingtime(Date endingtime) {
		this.endingtime = endingtime;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getChiefpeople() {
		return this.chiefpeople;
	}

	public void setChiefpeople(String chiefpeople) {
		this.chiefpeople = chiefpeople;
	}

	public String getLinkman() {
		return this.linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getActivitydescription() {
		return this.activitydescription;
	}

	public void setActivitydescription(String activitydescription) {
		this.activitydescription = activitydescription;
	}

	public String getWorkdescription() {
		return this.workdescription;
	}

	public void setWorkdescription(String workdescription) {
		this.workdescription = workdescription;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getLimitpeoplenum() {
		return this.limitpeoplenum;
	}

	public void setLimitpeoplenum(Integer limitpeoplenum) {
		this.limitpeoplenum = limitpeoplenum;
	}

	public Date getApplydeadline() {
		return this.applydeadline;
	}

	public void setApplydeadline(Timestamp applydeadline) {
		this.applydeadline = applydeadline;
	}

	public Integer getApplyingpeoplenum() {
		return this.applyingpeoplenum;
	}

	public void setApplyingpeoplenum(Integer applyingpeoplenum) {
		this.applyingpeoplenum = applyingpeoplenum;
	}

	public Integer getAcceptedpeoplenum() {
		return this.acceptedpeoplenum;
	}

	public void setAcceptedpeoplenum(Integer acceptedpeoplenum) {
		this.acceptedpeoplenum = acceptedpeoplenum;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNature() {
		return this.nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

}