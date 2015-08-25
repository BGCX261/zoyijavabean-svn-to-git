package org.zoyi.po;

import java.util.Date;

/**
 * Group entity. @author MyEclipse Persistence Tools
 */

public class Group implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer loginid;
	private Integer userid;
	private String password;
	private String status;
	private Integer adminid;
	private String name;
	private String nationility;
	private String province;
	private String city;
	private String postcode;
	private String address;
	private Date createdate;
	private Date registDate;
	private Float money;
	private Float credit;

	// Constructors

	/** default constructor */
	public Group() {
	}

	/** full constructor */
	public Group(Integer loginid, Integer userid, String password,
			String status, Integer adminid, String name, String nationility,
			String province, String city, String postcode, String address,
			Date createdate, Date registDate, Float money, Float credit) {
		this.loginid = loginid;
		this.userid = userid;
		this.password = password;
		this.status = status;
		this.adminid = adminid;
		this.name = name;
		this.nationility = nationility;
		this.province = province;
		this.city = city;
		this.postcode = postcode;
		this.address = address;
		this.createdate = createdate;
		this.registDate = registDate;
		this.money = money;
		this.credit = credit;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLoginid() {
		return this.loginid;
	}

	public void setLoginid(Integer loginid) {
		this.loginid = loginid;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getAdminid() {
		return this.adminid;
	}

	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationility() {
		return this.nationility;
	}

	public void setNationility(String nationility) {
		this.nationility = nationility;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getRegistDate() {
		return this.registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	public Float getMoney() {
		return this.money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

	public Float getCredit() {
		return this.credit;
	}

	public void setCredit(Float credit) {
		this.credit = credit;
	}

}