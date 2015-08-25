package org.zoyi.po;

import java.util.Date;

/**
 * UchomeMtag entity. @author MyEclipse Persistence Tools
 */

public class UchomeMtag implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1352753030356820150L;
	private Integer tagid;
	private String tagname;
	private Short fieldid;
	private Integer membernum;
	private Integer threadnum;
	private Integer postnum;
	private Short close;
	private String announcement;
	private String pic;
	private Short closeapply;
	private Short joinperm;
	private Short viewperm;
	private Short threadperm;
	private Short postperm;
	private Short recommend;
	private String moderator;
	private String pwd;
	private String userindex;
	private String aboutgroup;
	private Integer credit;
	private String birthprovince;
	private String birthcity;
	private String email;
	private String address;
	private String scale;
	private String remark;
	private Date birthday;
	private String future;
	private String linkman;
	private String phone;
    private String salt;
	// Constructors

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	/** default constructor */
	public UchomeMtag() {
	}

	/** minimal constructor */
	public UchomeMtag(String tagname, Short fieldid, Integer membernum,
			Integer threadnum, Integer postnum, Short close,
			String announcement, String pic, Short closeapply,
			Short joinperm, Short viewperm, Short threadperm,
			Short postperm, Short recommend, String moderator) {
		this.tagname = tagname;
		this.fieldid = fieldid;
		this.membernum = membernum;
		this.threadnum = threadnum;
		this.postnum = postnum;
		this.close = close;
		this.announcement = announcement;
		this.pic = pic;
		this.closeapply = closeapply;
		this.joinperm = joinperm;
		this.viewperm = viewperm;
		this.threadperm = threadperm;
		this.postperm = postperm;
		this.recommend = recommend;
		this.moderator = moderator;
	}

	// Property accessors

	public Integer getTagid() {
		return this.tagid;
	}

	public void setTagid(Integer tagid) {
		this.tagid = tagid;
	}

	public String getTagname() {
		return this.tagname;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

	public Short getFieldid() {
		return this.fieldid;
	}

	public void setFieldid(Short fieldid) {
		this.fieldid = fieldid;
	}

	public Integer getMembernum() {
		return this.membernum;
	}

	public void setMembernum(Integer membernum) {
		this.membernum = membernum;
	}

	public Integer getThreadnum() {
		return this.threadnum;
	}

	public void setThreadnum(Integer threadnum) {
		this.threadnum = threadnum;
	}

	public Integer getPostnum() {
		return this.postnum;
	}

	public void setPostnum(Integer postnum) {
		this.postnum = postnum;
	}

	public Short getClose() {
		return this.close;
	}

	public void setClose(Short close) {
		this.close = close;
	}

	public String getAnnouncement() {
		return this.announcement;
	}

	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Short getCloseapply() {
		return this.closeapply;
	}

	public void setCloseapply(Short closeapply) {
		this.closeapply = closeapply;
	}

	public Short getJoinperm() {
		return this.joinperm;
	}

	public void setJoinperm(Short joinperm) {
		this.joinperm = joinperm;
	}

	public Short getViewperm() {
		return this.viewperm;
	}

	public void setViewperm(Short viewperm) {
		this.viewperm = viewperm;
	}

	public Short getThreadperm() {
		return this.threadperm;
	}

	public void setThreadperm(Short threadperm) {
		this.threadperm = threadperm;
	}

	public Short getPostperm() {
		return this.postperm;
	}

	public void setPostperm(Short postperm) {
		this.postperm = postperm;
	}

	public Short getRecommend() {
		return this.recommend;
	}

	public void setRecommend(Short recommend) {
		this.recommend = recommend;
	}

	public String getModerator() {
		return this.moderator;
	}

	public void setModerator(String moderator) {
		this.moderator = moderator;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUserindex() {
		return this.userindex;
	}

	public void setUserindex(String userindex) {
		this.userindex = userindex;
	}

	public String getAboutgroup() {
		return this.aboutgroup;
	}

	public void setAboutgroup(String aboutgroup) {
		this.aboutgroup = aboutgroup;
	}

	public Integer getCredit() {
		return this.credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public String getBirthprovince() {
		return this.birthprovince;
	}

	public void setBirthprovince(String birthprovince) {
		this.birthprovince = birthprovince;
	}

	public String getBirthcity() {
		return this.birthcity;
	}

	public void setBirthcity(String birthcity) {
		this.birthcity = birthcity;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getScale() {
		return this.scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getFuture() {
		return this.future;
	}

	public void setFuture(String future) {
		this.future = future;
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

}