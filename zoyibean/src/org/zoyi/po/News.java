package org.zoyi.po;

import java.util.Date;

/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News implements java.io.Serializable {

	// Fields

	private Integer id;
	private Date releasetime;
	private Integer publisher;
	private String content;
	private String status;
	private Integer categoryid;
	private String title;
	private String level;
	private String picture;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** full constructor */
	public News(Date releasetime, Integer publisher, String content,
			String status, Integer categoryid, String title, String level,
			String picture) {
		this.releasetime = releasetime;
		this.publisher = publisher;
		this.content = content;
		this.status = status;
		this.categoryid = categoryid;
		this.title = title;
		this.level = level;
		this.picture = picture;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getReleasetime() {
		return this.releasetime;
	}

	public void setReleasetime(Date releasetime) {
		this.releasetime = releasetime;
	}

	public Integer getPublisher() {
		return this.publisher;
	}

	public void setPublisher(Integer publisher) {
		this.publisher = publisher;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCategoryid() {
		return this.categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}