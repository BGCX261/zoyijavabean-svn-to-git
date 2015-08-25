package org.zoyi.po;

/**
 * UchomeEventclass entity. @author MyEclipse Persistence Tools
 */

public class UchomeEventclass implements java.io.Serializable {

	// Fields

	private Short classid;
	private String classname;
	private Short poster;
	private String template;
	private Integer displayorder;

	// Constructors

	/** default constructor */
	public UchomeEventclass() {
	}

	/** full constructor */
	public UchomeEventclass(String classname, Short poster, String template,
			Integer displayorder) {
		this.classname = classname;
		this.poster = poster;
		this.template = template;
		this.displayorder = displayorder;
	}

	// Property accessors

	public Short getClassid() {
		return this.classid;
	}

	public void setClassid(Short classid) {
		this.classid = classid;
	}

	public String getClassname() {
		return this.classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public Short getPoster() {
		return this.poster;
	}

	public void setPoster(Short poster) {
		this.poster = poster;
	}

	public String getTemplate() {
		return this.template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public Integer getDisplayorder() {
		return this.displayorder;
	}

	public void setDisplayorder(Integer displayorder) {
		this.displayorder = displayorder;
	}

}