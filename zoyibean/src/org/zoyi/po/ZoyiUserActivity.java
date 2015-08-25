package org.zoyi.po;

/**
 * ZoyiUserActivity entity. @author MyEclipse Persistence Tools
 */

public class ZoyiUserActivity implements java.io.Serializable {

	// Fields

	private ZoyiUserActivityId id;
	private Integer status;

	// Constructors

	/** default constructor */
	public ZoyiUserActivity() {
	}

	/** full constructor */
	public ZoyiUserActivity(ZoyiUserActivityId id, Integer status) {
		this.id = id;
		this.status = status;
	}

	// Property accessors

	public ZoyiUserActivityId getId() {
		return this.id;
	}

	public void setId(ZoyiUserActivityId id) {
		this.id = id;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}