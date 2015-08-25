package org.zoyi.vo;

import java.util.Date;
import java.util.List;

@SuppressWarnings("unchecked")
public class Group {
	
	public Group() {
		// TODO Auto-generated constructor stub
	}
	private int id ;
	private String groupName ;
	//组织LOGO
	private String logoPicture ;
	private String pwd ;
	//那些会员
	private List relatedUser ;
	//组织首页
	private String index ;
	//组织介绍
	private String aboutGroup ;
	//组织信用
	private int credit ;
	//省
	private String birthProvince ;
	//组织海报
	private String adPicture ;
	//城市
	private String birthCity ;
	//EMAIL
	private String email ;
	//详细地址
	private String address ;
	//规模
	private String scale ;
	//备注
	private String remark ;
	//组织成立日期
	private Date birthDay ;
	//组织性质
	private String nature ;
	//未来展望
	private String future ;
	//联系人
	private String linkman ;
	private Userinfo userinfo ;
	//电话
	private String phone ;
	private GroupCategory groupCategory;
	
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getAboutGroup() {
		return aboutGroup;
	}
	public void setAboutGroup(String aboutGroup) {
		this.aboutGroup = aboutGroup;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAdPicture() {
		return adPicture;
	}
	public void setAdPicture(String adPicture) {
		this.adPicture = adPicture;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getLogoPicture() {
		return logoPicture;
	}
	public void setLogoPicture(String logoPicture) {
		this.logoPicture = logoPicture;
	}
	public List getRelatedUser() {
		return relatedUser;
	}
	public void setRelatedUser(List relatedUser) {
		this.relatedUser = relatedUser;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getBirthProvince() {
		return birthProvince;
	}
	public void setBirthProvince(String birthProvince) {
		this.birthProvince = birthProvince;
	}
	public String getBirthCity() {
		return birthCity;
	}
	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public String getFuture() {
		return future;
	}
	public void setFuture(String futrue) {
		this.future = futrue;
	}
	public void setGroupCategory(GroupCategory groupCategory) {
		this.groupCategory = groupCategory;
	}
	public GroupCategory getGroupCategory() {
		return groupCategory;
	}
	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	public Userinfo getUserinfo() {
		return userinfo;
	}
	
}
