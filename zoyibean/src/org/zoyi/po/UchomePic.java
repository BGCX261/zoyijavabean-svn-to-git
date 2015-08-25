package org.zoyi.po;

/**
 * UchomePic entity. @author MyEclipse Persistence Tools
 */

public class UchomePic implements java.io.Serializable {

	// Fields

	private Integer picid;
	private Integer albumid;
	private Integer topicid;
	private Integer uid;
	private String username;
	private Integer dateline;
	private String postip;
	private String filename;
	private String title;
	private String type;
	private Integer size;
	private String filepath;
	private Short thumb;
	private Short remote;
	private Integer hot;
	private Short click6;
	private Short click7;
	private Short click8;
	private Short click9;
	private Short click10;
	private Short magicframe;

	// Constructors

	/** default constructor */
	public UchomePic() {
	}

	/** full constructor */
	public UchomePic(Integer picid, Integer albumid, Integer topicid,
			Integer uid, String username, Integer dateline, String postip,
			String filename, String title, String type, Integer size,
			String filepath, Short thumb, Short remote, Integer hot,
			Short click6, Short click7, Short click8, Short click9,
			Short click10, Short magicframe) {
		this.picid = picid;
		this.albumid = albumid;
		this.topicid = topicid;
		this.uid = uid;
		this.username = username;
		this.dateline = dateline;
		this.postip = postip;
		this.filename = filename;
		this.title = title;
		this.type = type;
		this.size = size;
		this.filepath = filepath;
		this.thumb = thumb;
		this.remote = remote;
		this.hot = hot;
		this.click6 = click6;
		this.click7 = click7;
		this.click8 = click8;
		this.click9 = click9;
		this.click10 = click10;
		this.magicframe = magicframe;
	}

	// Property accessors

	public Integer getPicid() {
		return this.picid;
	}

	public void setPicid(Integer picid) {
		this.picid = picid;
	}

	public Integer getAlbumid() {
		return this.albumid;
	}

	public void setAlbumid(Integer albumid) {
		this.albumid = albumid;
	}

	public Integer getTopicid() {
		return this.topicid;
	}

	public void setTopicid(Integer topicid) {
		this.topicid = topicid;
	}

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

	public Integer getDateline() {
		return this.dateline;
	}

	public void setDateline(Integer dateline) {
		this.dateline = dateline;
	}

	public String getPostip() {
		return this.postip;
	}

	public void setPostip(String postip) {
		this.postip = postip;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getSize() {
		return this.size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getFilepath() {
		return this.filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public Short getThumb() {
		return this.thumb;
	}

	public void setThumb(Short thumb) {
		this.thumb = thumb;
	}

	public Short getRemote() {
		return this.remote;
	}

	public void setRemote(Short remote) {
		this.remote = remote;
	}

	public Integer getHot() {
		return this.hot;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
	}

	public Short getClick6() {
		return this.click6;
	}

	public void setClick6(Short click6) {
		this.click6 = click6;
	}

	public Short getClick7() {
		return this.click7;
	}

	public void setClick7(Short click7) {
		this.click7 = click7;
	}

	public Short getClick8() {
		return this.click8;
	}

	public void setClick8(Short click8) {
		this.click8 = click8;
	}

	public Short getClick9() {
		return this.click9;
	}

	public void setClick9(Short click9) {
		this.click9 = click9;
	}

	public Short getClick10() {
		return this.click10;
	}

	public void setClick10(Short click10) {
		this.click10 = click10;
	}

	public Short getMagicframe() {
		return this.magicframe;
	}

	public void setMagicframe(Short magicframe) {
		this.magicframe = magicframe;
	}

}