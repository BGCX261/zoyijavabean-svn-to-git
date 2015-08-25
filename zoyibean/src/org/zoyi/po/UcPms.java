package org.zoyi.po;

/**
 * UcPms entity. @author MyEclipse Persistence Tools
 */

public class UcPms implements java.io.Serializable {

	// Fields

	private Integer pmid;
	private String msgfrom;
	private Integer msgfromid;
	private Integer msgtoid;
	private String folder;
	private Short new_;
	private String subject;
	private Integer dateline;
	private String message;
	private Short delstatus;
	private Integer related;
	private Short fromappid;

	// Constructors

	/** default constructor */
	public UcPms() {
	}

	/** full constructor */
	public UcPms(Integer pmid, String msgfrom, Integer msgfromid,
			Integer msgtoid, String folder, Short new_, String subject,
			Integer dateline, String message, Short delstatus,
			Integer related, Short fromappid) {
		this.pmid = pmid;
		this.msgfrom = msgfrom;
		this.msgfromid = msgfromid;
		this.msgtoid = msgtoid;
		this.folder = folder;
		this.new_ = new_;
		this.subject = subject;
		this.dateline = dateline;
		this.message = message;
		this.delstatus = delstatus;
		this.related = related;
		this.fromappid = fromappid;
	}

	// Property accessors

	public Integer getPmid() {
		return this.pmid;
	}

	public void setPmid(Integer pmid) {
		this.pmid = pmid;
	}

	public String getMsgfrom() {
		return this.msgfrom;
	}

	public void setMsgfrom(String msgfrom) {
		this.msgfrom = msgfrom;
	}

	public Integer getMsgfromid() {
		return this.msgfromid;
	}

	public void setMsgfromid(Integer msgfromid) {
		this.msgfromid = msgfromid;
	}

	public Integer getMsgtoid() {
		return this.msgtoid;
	}

	public void setMsgtoid(Integer msgtoid) {
		this.msgtoid = msgtoid;
	}

	public String getFolder() {
		return this.folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public Short getNew_() {
		return this.new_;
	}

	public void setNew_(Short new_) {
		this.new_ = new_;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getDateline() {
		return this.dateline;
	}

	public void setDateline(Integer dateline) {
		this.dateline = dateline;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Short getDelstatus() {
		return this.delstatus;
	}

	public void setDelstatus(Short delstatus) {
		this.delstatus = delstatus;
	}

	public Integer getRelated() {
		return this.related;
	}

	public void setRelated(Integer related) {
		this.related = related;
	}

	public Short getFromappid() {
		return this.fromappid;
	}

	public void setFromappid(Short fromappid) {
		this.fromappid = fromappid;
	}

}