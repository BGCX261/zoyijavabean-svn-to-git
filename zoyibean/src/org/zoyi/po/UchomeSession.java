package org.zoyi.po;

/**
 * UchomeSession entity. @author MyEclipse Persistence Tools
 */

public class UchomeSession implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String username;
	private String password;
	private Integer lastactivity;
	private Integer ip;
	private Short magichidden;

	// Constructors

	/** default constructor */
	public UchomeSession() {
	}

	/** full constructor */
	public UchomeSession(Integer uid, String username, String password,
			Integer lastactivity, Integer ip, Short magichidden) {
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.lastactivity = lastactivity;
		this.ip = ip;
		this.magichidden = magichidden;
	}

	// Property accessors

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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getLastactivity() {
		return this.lastactivity;
	}

	public void setLastactivity(Integer lastactivity) {
		this.lastactivity = lastactivity;
	}

	public Integer getIp() {
		return this.ip;
	}

	public void setIp(Integer ip) {
		this.ip = ip;
	}

	public Short getMagichidden() {
		return this.magichidden;
	}

	public void setMagichidden(Short magichidden) {
		this.magichidden = magichidden;
	}

}