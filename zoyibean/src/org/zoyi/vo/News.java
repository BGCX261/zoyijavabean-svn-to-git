package org.zoyi.vo;

import java.util.Date;

public class News {

	public News() {
	}
	private int innerId;
	private Date releasetime;
	private int publisherId;
	private String keyword1;
	private String keyword2;
	private String keyword3;
	private String keyword4;
	private String keyword5;
	private String keyword6;
	private String content;
	private String status;
	private NewsCategory newsCategory;
	private String title;
	private String level;
	private String picture;
	private int clickCount;
	private String remark ;
	public String getKeyword1() {
		return keyword1;
	}

	public void setKeyword1(String keyword1) {
		this.keyword1 = keyword1;
	}

	public String getKeyword2() {
		return keyword2;
	}

	public void setKeyword2(String keyword2) {
		this.keyword2 = keyword2;
	}

	public String getKeyword3() {
		return keyword3;
	}

	public void setKeyword3(String keyword3) {
		this.keyword3 = keyword3;
	}

	public String getKeyword4() {
		return keyword4;
	}

	public void setKeyword4(String keyword4) {
		this.keyword4 = keyword4;
	}

	public String getKeyword5() {
		return keyword5;
	}

	public void setKeyword5(String keyword5) {
		this.keyword5 = keyword5;
	}

	public String getKeyword6() {
		return keyword6;
	}

	public void setKeyword6(String keyword6) {
		this.keyword6 = keyword6;
	}

	public int getInnerId() {
		return innerId;
	}

	public void setInnerId(int innerId) {
		this.innerId = innerId;
	}

	public Date getReleasetime() {
		return releasetime;
	}

	public void setReleasetime(Date releasetime) {
		this.releasetime = releasetime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public NewsCategory getNewsCategory() {
		return newsCategory;
	}

	public void setNewsCategory(NewsCategory newsCategory) {
		this.newsCategory = newsCategory;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}

	public int getClickCount() {
		return clickCount;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

}
