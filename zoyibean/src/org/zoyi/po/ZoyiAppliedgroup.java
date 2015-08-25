package org.zoyi.po;

import java.util.Date;

/**
 * ZoyiAppliedgroup entity. @author MyEclipse Persistence Tools
 */

public class ZoyiAppliedgroup implements java.io.Serializable {

	// Fields

	private Integer id;
	private String groupname;
	private String birthprovince;
	private String birthcity;
	private String phone;
	private String email;
	private String address;
	private String linkman;
	private Date applydate;
	private String applystatus;
	private String pwd;
	private Short fieldid;

	// Constructors

	public Short getFieldid() {
		return fieldid;
	}

	public void setFieldid(Short fieldid) {
		this.fieldid = fieldid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/** default constructor */
	public ZoyiAppliedgroup() {
	}

	/** full constructor */
	public ZoyiAppliedgroup(String groupname, String birthprovince,
			String birthcity, String phone, String email, String address,
			String linkman, Date applydate, String applystatus, String pwd) {
		this.groupname = groupname;
		this.birthprovince = birthprovince;
		this.birthcity = birthcity;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.linkman = linkman;
		this.applydate = applydate;
		this.applystatus = applystatus;
		this.pwd = pwd;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroupname() {
		return this.groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
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

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLinkman() {
		return this.linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public Date getApplydate() {
		return this.applydate;
	}

	public void setApplydate(Date applydate) {
		this.applydate = applydate;
	}

	public String getApplystatus() {
		return this.applystatus;
	}

	public void setApplystatus(String applystatus) {
		this.applystatus = applystatus;
	}

}