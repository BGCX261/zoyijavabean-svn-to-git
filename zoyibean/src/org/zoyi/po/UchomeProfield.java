package org.zoyi.po;

/**
 * UchomeProfield entity. @author MyEclipse Persistence Tools
 */

public class UchomeProfield implements java.io.Serializable {

	// Fields

	private Short fieldid;
	private String title;
	private String note;
	private String formtype;
	private Short inputnum;
	private String choice;
	private Short mtagminnum;
	private Short manualmoderator;
	private Short manualmember;
	private Short displayorder;

	// Constructors

	/** default constructor */
	public UchomeProfield() {
	}

	/** full constructor */
	public UchomeProfield(String title, String note, String formtype,
			Short inputnum, String choice, Short mtagminnum,
			Short manualmoderator, Short manualmember, Short displayorder) {
		this.title = title;
		this.note = note;
		this.formtype = formtype;
		this.inputnum = inputnum;
		this.choice = choice;
		this.mtagminnum = mtagminnum;
		this.manualmoderator = manualmoderator;
		this.manualmember = manualmember;
		this.displayorder = displayorder;
	}

	// Property accessors

	public Short getFieldid() {
		return this.fieldid;
	}

	public void setFieldid(Short fieldid) {
		this.fieldid = fieldid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getFormtype() {
		return this.formtype;
	}

	public void setFormtype(String formtype) {
		this.formtype = formtype;
	}

	public Short getInputnum() {
		return this.inputnum;
	}

	public void setInputnum(Short inputnum) {
		this.inputnum = inputnum;
	}

	public String getChoice() {
		return this.choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public Short getMtagminnum() {
		return this.mtagminnum;
	}

	public void setMtagminnum(Short mtagminnum) {
		this.mtagminnum = mtagminnum;
	}

	public Short getManualmoderator() {
		return this.manualmoderator;
	}

	public void setManualmoderator(Short manualmoderator) {
		this.manualmoderator = manualmoderator;
	}

	public Short getManualmember() {
		return this.manualmember;
	}

	public void setManualmember(Short manualmember) {
		this.manualmember = manualmember;
	}

	public Short getDisplayorder() {
		return this.displayorder;
	}

	public void setDisplayorder(Short displayorder) {
		this.displayorder = displayorder;
	}

}