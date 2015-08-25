package org.zoyi.po;


import java.util.Date;

/**
 * Announcement entity. @author MyEclipse Persistence Tools
 */

public class Announcement implements java.io.Serializable {

	// Fields

	private Integer id;
	private String content;
	private String status;
	private Date createdate;
	private Short level;
	private String announcer;

	// Constructors

	/** default constructor */
	public Announcement() {
	}

	/** full constructor */

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
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

}