package org.zoyi.po;

/**
 * UchomeTagspaceId entity. @author MyEclipse Persistence Tools
 */

public class UchomeTagspaceId implements java.io.Serializable {

	// Fields

	private Integer tagid;
	private Integer uid;

	// Constructors

	/** default constructor */
	public UchomeTagspaceId() {
	}

	/** full constructor */
	public UchomeTagspaceId(Integer tagid, Integer uid) {
		this.tagid = tagid;
		this.uid = uid;
	}

	// Property accessors

	public Integer getTagid() {
		return this.tagid;
	}

	public void setTagid(Integer tagid) {
		this.tagid = tagid;
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
		if (!(other instanceof UchomeTagspaceId))
			return false;
		UchomeTagspaceId castOther = (UchomeTagspaceId) other;

		return ((this.getTagid() == castOther.getTagid()) || (this.getTagid() != null
				&& castOther.getTagid() != null && this.getTagid().equals(
				castOther.getTagid())))
				&& ((this.getUid() == castOther.getUid()) || (this.getUid() != null
						&& castOther.getUid() != null && this.getUid().equals(
						castOther.getUid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTagid() == null ? 0 : this.getTagid().hashCode());
		result = 37 * result
				+ (getUid() == null ? 0 : this.getUid().hashCode());
		return result;
	}

}