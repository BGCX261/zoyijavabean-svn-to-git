package org.zoyi.vo;

import java.util.Date;

public class UserCredit {

	public UserCredit() {
		// TODO Auto-generated constructor stub
	}

	private int id;
	private Userinfo userinfo;
	private Date getCreditDate;
	private BenifitActivity benifitActivity;
	private int credit;
	private int darkmind;
	private int uid;
	private int baid;

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public Date getGetCreditDate() {
		return getCreditDate;
	}

	public void setGetCreditDate(Date getCreditDate) {
		this.getCreditDate = getCreditDate;
	}

	public BenifitActivity getBenifitActivity() {
		return benifitActivity;
	}

	public void setBenifitActivity(BenifitActivity benifitActivity) {
		this.benifitActivity = benifitActivity;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getCredit() {
		return credit;
	}

	public void setDarkmind(int darkmind) {
		this.darkmind = darkmind;
	}

	public int getDarkmind() {
		return darkmind;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getUid() {
		return uid;
	}

	public void setBaid(int baid) {
		this.baid = baid;
	}

	public int getBaid() {
		return baid;
	}
}
