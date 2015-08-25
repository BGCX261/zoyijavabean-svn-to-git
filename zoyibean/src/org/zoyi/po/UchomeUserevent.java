package org.zoyi.po;

import java.util.Date;

/**
 * UchomeUserevent entity. @author MyEclipse Persistence Tools
 */

public class UchomeUserevent implements java.io.Serializable {

	// Fields

	private UchomeUsereventId id;
	private String username;
	private Integer dateline;
	private Short status;
	private Integer fellow;
	private String template;
	private Integer credit;
	private Integer darkmind;
	private Date getcreditdate;

	// Constructors

	/** default constructor */
	public UchomeUserevent() {
	}

	/** full constructor */
	public UchomeUserevent(UchomeUsereventId id, String username,
			Integer dateline, Short status, Integer fellow, String template,
			Integer credit, Integer darkmind) {
		this.id = id;
		this.username = username;
		this.dateline = dateline;
		this.status = status;
		this.fellow = fellow;
		this.template = template;
		this.credit = credit;
		this.darkmind = darkmind;
	}

	// Property accessors

	public UchomeUsereventId getId() {
		return this.id;
	}

	public void setId(UchomeUsereventId id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getDateline() {
		return this.dateline;
	}

	public void setDateline(Integer dateline) {
		this.dateline = dateline;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Integer getFellow() {
		return this.fellow;
	}

	public void setFellow(Integer fellow) {
		this.fellow = fellow;
	}

	public String getTemplate() {
		return this.template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public Integer getCredit() {
		return this.credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public Integer getDarkmind() {
		return this.darkmind;
	}

	public void setDarkmind(Integer darkmind) {
		this.darkmind = darkmind;
	}

	public Date getGetcreditdate() {
		return getcreditdate;
	}

	public void setGetcreditdate(Date getcreditdate) {
		this.getcreditdate = getcreditdate;
	}

}