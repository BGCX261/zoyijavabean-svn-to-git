package org.zoyi.po;

/**
 * ZoyiUserActivityId entity. @author MyEclipse Persistence Tools
 */

public class ZoyiUserActivityId implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Integer baId;

	// Constructors

	/** default constructor */
	public ZoyiUserActivityId() {
	}

	/** full constructor */
	public ZoyiUserActivityId(Integer userId, Integer baId) {
		this.userId = userId;
		this.baId = baId;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getBaId() {
		return this.baId;
	}

	public void setBaId(Integer baId) {
		this.baId = baId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ZoyiUserActivityId))
			return false;
		ZoyiUserActivityId castOther = (ZoyiUserActivityId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null
				&& castOther.getUserId() != null && this.getUserId().equals(
				castOther.getUserId())))
				&& ((this.getBaId() == castOther.getBaId()) || (this.getBaId() != null
						&& castOther.getBaId() != null && this.getBaId()
						.equals(castOther.getBaId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getBaId() == null ? 0 : this.getBaId().hashCode());
		return result;
	}

}