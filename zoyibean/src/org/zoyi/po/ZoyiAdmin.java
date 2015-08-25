package org.zoyi.po;

/**
 * ZoyiAdmin entity. @author MyEclipse Persistence Tools
 */

public class ZoyiAdmin implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String email;
	private String gender;
	private String pwd;
	private String identycard;
	private String mobilephone;
	private String status;
    private String salt;
	// Constructors

	/** default constructor */
	public ZoyiAdmin() {
	}

	/** full constructor */
	public ZoyiAdmin(String name, String email, String gender, String pwd,
			String identycard, String mobilephone, String status) {
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.pwd = pwd;
		this.identycard = identycard;
		this.mobilephone = mobilephone;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getIdentycard() {
		return this.identycard;
	}

	public void setIdentycard(String identycard) {
		this.identycard = identycard;
	}

	public String getMobilephone() {
		return this.mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}