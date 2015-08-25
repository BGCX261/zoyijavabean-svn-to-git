package org.zoyi.po;

import java.util.Date;

/**
 * ZoyiAnnouncement entity. @author MyEclipse Persistence Tools
 */

public class ZoyiAnnouncement implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String content;
	private Date createdate;
	private String status;
	private Short level;
	private String announcer;
	private Integer clickcount;

	// Constructors

	/** default constructor */
	public ZoyiAnnouncement() {
	}


	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Short getLevel() {
		return this.level;
	}

	public void setLevel(Short level) {
		this.level = level;
	}

	public String getAnnouncer() {
		return this.announcer;
	}

	public void setAnnouncer(String announcer) {
		this.announcer = announcer;
	}

	public Integer getClickcount() {
		return this.clickcount;
	}

	public void setClickcount(Integer clickcount) {
		this.clickcount = clickcount;
	}

}