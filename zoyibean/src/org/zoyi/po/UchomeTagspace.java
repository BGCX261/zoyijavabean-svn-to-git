package org.zoyi.po;

/**
 * UchomeTagspace entity. @author MyEclipse Persistence Tools
 */

public class UchomeTagspace implements java.io.Serializable {

	// Fields

	private UchomeTagspaceId id;
	private String username;
	private Short grade;

	// Constructors

	/** default constructor */
	public UchomeTagspace() {
	}

	/** full constructor */
	public UchomeTagspace(UchomeTagspaceId id, String username, Short grade) {
		this.id = id;
		this.username = username;
		this.grade = grade;
	}

	// Property accessors

	public UchomeTagspaceId getId() {
		return this.id;
	}

	public void setId(UchomeTagspaceId id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Short getGrade() {
		return this.grade;
	}

	public void setGrade(Short grade) {
		this.grade = grade;
	}

}