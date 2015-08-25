package org.zoyi.po;

/**
 * UchomeEvent entity. @author MyEclipse Persistence Tools
 */

public class UchomeEvent implements java.io.Serializable {

	// Fields

	private Integer eventid;
	private Integer topicid;
	private Integer uid;
	private String username;
	private Integer dateline;
	private String title;
	private Short classid;
	private String province;
	private String city;
	private String location;
	private String poster;
	private Short thumb;
	private Short remote;
	private Integer deadline;
	private Integer starttime;
	private Integer endtime;
	private Short public_;
	private Integer membernum;
	private Integer follownum;
	private Integer viewnum;
	private Short grade;
	private Integer recommendtime;
	private Integer tagid;
	private Integer picnum;
	private Integer threadnum;
	private Integer updatetime;
	private Integer hot;

	// Constructors

	/** default constructor */
	public UchomeEvent() {
	}

	/** full constructor */
	public UchomeEvent(Integer topicid, Integer uid, String username,
			Integer dateline, String title, Short classid, String province,
			String city, String location, String poster, Short thumb,
			Short remote, Integer deadline, Integer starttime,
			Integer endtime, Short public_, Integer membernum,
			Integer follownum, Integer viewnum, Short grade,
			Integer recommendtime, Integer tagid, Integer picnum,
			Integer threadnum, Integer updatetime, Integer hot) {
		this.topicid = topicid;
		this.uid = uid;
		this.username = username;
		this.dateline = dateline;
		this.title = title;
		this.classid = classid;
		this.province = province;
		this.city = city;
		this.location = location;
		this.poster = poster;
		this.thumb = thumb;
		this.remote = remote;
		this.deadline = deadline;
		this.starttime = starttime;
		this.endtime = endtime;
		this.public_ = public_;
		this.membernum = membernum;
		this.follownum = follownum;
		this.viewnum = viewnum;
		this.grade = grade;
		this.recommendtime = recommendtime;
		this.tagid = tagid;
		this.picnum = picnum;
		this.threadnum = threadnum;
		this.updatetime = updatetime;
		this.hot = hot;
	}

	// Property accessors

	public Integer getEventid() {
		return this.eventid;
	}

	public void setEventid(Integer eventid) {
		this.eventid = eventid;
	}

	public Integer getTopicid() {
		return this.topicid;
	}

	public void setTopicid(Integer topicid) {
		this.topicid = topicid;
	}

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

	public Integer getDateline() {
		return this.dateline;
	}

	public void setDateline(Integer dateline) {
		this.dateline = dateline;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Short getClassid() {
		return this.classid;
	}

	public void setClassid(Short classid) {
		this.classid = classid;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPoster() {
		return this.poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Short getThumb() {
		return this.thumb;
	}

	public void setThumb(Short thumb) {
		this.thumb = thumb;
	}

	public Short getRemote() {
		return this.remote;
	}

	public void setRemote(Short remote) {
		this.remote = remote;
	}

	public Integer getDeadline() {
		return this.deadline;
	}

	public void setDeadline(Integer deadline) {
		this.deadline = deadline;
	}

	public Integer getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Integer starttime) {
		this.starttime = starttime;
	}

	public Integer getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Integer endtime) {
		this.endtime = endtime;
	}

	public short getPublic_() {
		return this.public_;
	}

	public void setPublic_(short public_) {
		this.public_ = public_;
	}

	public Integer getMembernum() {
		return this.membernum;
	}

	public void setMembernum(Integer membernum) {
		this.membernum = membernum;
	}

	public Integer getFollownum() {
		return this.follownum;
	}

	public void setFollownum(Integer follownum) {
		this.follownum = follownum;
	}

	public Integer getViewnum() {
		return this.viewnum;
	}

	public void setViewnum(Integer viewnum) {
		this.viewnum = viewnum;
	}

	public short getGrade() {
		return this.grade;
	}

	public void setGrade(short grade) {
		this.grade = grade;
	}

	public Integer getRecommendtime() {
		return this.recommendtime;
	}

	public void setRecommendtime(Integer recommendtime) {
		this.recommendtime = recommendtime;
	}

	public Integer getTagid() {
		return this.tagid;
	}

	public void setTagid(Integer tagid) {
		this.tagid = tagid;
	}

	public Integer getPicnum() {
		return this.picnum;
	}

	public void setPicnum(Integer picnum) {
		this.picnum = picnum;
	}

	public Integer getThreadnum() {
		return this.threadnum;
	}

	public void setThreadnum(Integer threadnum) {
		this.threadnum = threadnum;
	}

	public Integer getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Integer updatetime) {
		this.updatetime = updatetime;
	}

	public Integer getHot() {
		return this.hot;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
	}

}