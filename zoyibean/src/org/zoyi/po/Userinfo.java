package org.zoyi.po;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Userinfo {

	public Userinfo() {
		// TODO Auto-generated constructor stub
	}
	@GenericGenerator(name="generator", strategy="native")
	@Id
	@GeneratedValue(generator="generator")
	@Column
	private Integer innerId;
	@Column(nullable=false,length=50,unique=true)
	private String email;
	@Column(nullable=false,length=11,unique=true)
	private String mobilePhone;
	@Column(nullable=true,length=18,unique=true)
	private String identityCard;
	@Column(nullable=false,length=41)
	private String pwd;
	@Column(nullable=false,length=1)
	private String status;
	@Column(nullable=false,length=30)
	private String name;
	@Column(nullable=true,length=30)
	private String nickName;
	@Column(nullable=true)
	private Date birthDay;
	@Column(nullable=true,length=1)
	private String gender;
	@Column(nullable=true,length=2)
	private String nationility;
	@Column(nullable=true,length=2)
	private String province;
	@Column(nullable=true,length=2)
	private String city;
	@Column(nullable=true,length=6)
	private String postcode;
	@Column(nullable=true,length=100)
	private String address;
	@Column(nullable=true,length=100)
	private String university;
	@Column(nullable=true,length=30)
	private String college;
	@Column(nullable=true,length=50)
	private String hobby;
	@Column(nullable=true,length=13)
	private String qq;
	@Column(nullable=true,length=50)
	private String msn;
	@Column(nullable=true,length=100)
	private String homepage;
	@Column(nullable=false)
	private java.util.Date registerTime;
	@Column(nullable=false)
	private float money;
	@Column(nullable=false)
	private float credit;
	
	private Date registerDate ;
	private Date lastOnDate ;
	
	public Integer getInnerId() {
		return innerId;
	}
	public void setInnerId(Integer innerId) {
		this.innerId = innerId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String password) {
		this.pwd = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNationility() {
		return nationility;
	}
	public void setNationility(String nationility) {
		this.nationility = nationility;
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
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
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
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public java.util.Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(java.util.Date registerTime) {
		this.registerTime = registerTime;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public float getCredit() {
		return credit;
	}
	public void setCredit(float credit) {
		this.credit = credit;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setLastOnDate(Date lastOnDate) {
		this.lastOnDate = lastOnDate;
	}
	public Date getLastOnDate() {
		return lastOnDate;
	}
}