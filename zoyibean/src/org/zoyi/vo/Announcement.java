/**
 * 
 */
package org.zoyi.vo;

import java.util.Date;

/**
 * @author dhibmclub
 *
 */
public class Announcement {

	private int id ;
	private String title ;
	private String content ;
	private Date createDate ;
	private char status ;
	private short level ;
	private String announcer ;
	private int clickCount ;
	/**
	 * 
	 */
	public Announcement() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public short getLevel() {
		return level;
	}
	public void setLevel(short level) {
		this.level = level;
	}
	public String getAnnouncer() {
		return announcer;
	}
	public void setAnnouncer(String announcer) {
		this.announcer = announcer;
	}
	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}
	public int getClickCount() {
		return clickCount;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}

}
