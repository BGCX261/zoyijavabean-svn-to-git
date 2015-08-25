package org.zoyi.po;

/**
 * UchomeAd entity. @author MyEclipse Persistence Tools
 */

public class UchomeAd implements java.io.Serializable {

	// Fields

	private Short adid;
	private Short available;
	private String title;
	private String pagetype;
	private String adcode;
	private Short system;

	// Constructors

	/** default constructor */
	public UchomeAd() {
	}

	/** full constructor */
	public UchomeAd(Short adid, Short available, String title,
			String pagetype, String adcode, Short system) {
		this.adid = adid;
		this.available = available;
		this.title = title;
		this.pagetype = pagetype;
		this.adcode = adcode;
		this.system = system;
	}

	// Property accessors

	public Short getAdid() {
		return this.adid;
	}

	public void setAdid(Short adid) {
		this.adid = adid;
	}

	public Short getAvailable() {
		return this.available;
	}

	public void setAvailable(Short available) {
		this.available = available;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPagetype() {
		return this.pagetype;
	}

	public void setPagetype(String pagetype) {
		this.pagetype = pagetype;
	}

	public String getAdcode() {
		return this.adcode;
	}

	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}

	public Short getSystem() {
		return this.system;
	}

	public void setSystem(Short system) {
		this.system = system;
	}

}