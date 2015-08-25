package org.zoyi.po;

/**
 * UchomeUsereventId entity. @author MyEclipse Persistence Tools
 */

public class UchomeUsereventId implements java.io.Serializable {

	// Fields

	private Integer eventid;
	private Integer uid;

	// Constructors

	/** default constructor */
	public UchomeUsereventId() {
	}

	/** full constructor */
	public UchomeUsereventId(Integer eventid, Integer uid) {
		this.eventid = eventid;
		this.uid = uid;
	}

	// Property accessors

	public Integer getEventid() {
		return this.eventid;
	}

	public void setEventid(Integer eventid) {
		this.eventid = eventid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UchomeUsereventId))
			return false;
		UchomeUsereventId castOther = (UchomeUsereventId) other;

		return ((this.getEventid() == castOther.getEventid()) || (this
				.getEventid() != null
				&& castOther.getEventid() != null && this.getEventid().equals(
				castOther.getEventid())))
				&& ((this.getUid() == castOther.getUid()) || (this.getUid() != null
						&& castOther.getUid() != null && this.getUid().equals(
						castOther.getUid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getEventid() == null ? 0 : this.getEventid().hashCode());
		result = 37 * result
				+ (getUid() == null ? 0 : this.getUid().hashCode());
		return result;
	}

}