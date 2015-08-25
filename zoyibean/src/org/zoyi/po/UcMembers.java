package org.zoyi.po;

import java.util.Date;

// default package

/**
 * UcMembers entity. @author MyEclipse Persistence Tools
 */

public class UcMembers implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String username;
	private String password;
	private String email;
	private String myid;
	private String myidkey;
	private String regip;
	private Integer regdate;
	private Integer lastloginip;
	private Integer lastlogintime;
	private String salt;
	private String secques;
	private String status;
	private String picture;
	private String index;
    private Integer credit;
    private Integer darkmind;
	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMyid() {
		return this.myid;
	}

	public void setMyid(String myid) {
		this.myid = myid;
	}

	public String getMyidkey() {
		return this.myidkey;
	}

	public void setMyidkey(String myidkey) {
		this.myidkey = myidkey;
	}

	public String getRegip() {
		return this.regip;
	}

	public void setRegip(String regip) {
		this.regip = regip;
	}

	public Integer getRegdate() {
		return this.regdate;
	}

	public void setRegdate(Integer regdate) {
		this.regdate = regdate;
	}

	public Integer getLastloginip() {
		return this.lastloginip;
	}

	public void setLastloginip(Integer lastloginip) {
		this.lastloginip = lastloginip;
	}

	public Integer getLastlogintime() {
		return this.lastlogintime;
	}

	public void setLastlogintime(Integer lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getSecques() {
		return this.secques;
	}

	public void setSecques(String secques) {
		this.secques = secques;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getIndex() {
		return this.index;
	}

	public void setIndex(String index) {
		this.index = index;
	}


	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public Integer getDarkmind() {
		return darkmind;
	}

	public void setDarkmind(Integer darkmind) {
		this.darkmind = darkmind;
	}

}