package org.zoyi.adapter;

import org.zoyi.hibernate.UserInfoDAO;

public class UserinfoAdapter {
	public static org.zoyi.po.UcMembers toPo(org.zoyi.vo.Userinfo userInfo) {
		org.zoyi.po.UcMembers u = new org.zoyi.po.UcMembers();
		u.setEmail(userInfo.getEmail());
		u.setUsername(userInfo.getName());
		u.setPassword(userInfo.getPwd());
		u.setUid(userInfo.getUserId());
		u.setStatus(userInfo.getStatus());
		u.setPicture(userInfo.getPicture());
		u.setIndex(userInfo.getIndex());
		u.setCredit(userInfo.getCredit());
		u.setDarkmind(userInfo.getDarkmind());
		return u;
	}

	public static org.zoyi.vo.Userinfo toVo(org.zoyi.po.UcMembers u) {
		if (u != null) {
			org.zoyi.vo.Userinfo userInfo = new org.zoyi.vo.Userinfo();
			userInfo.setEmail(u.getEmail());
			userInfo.setPwd(u.getPassword());
			userInfo.setUserId(u.getUid());
			userInfo.setCredit(u.getCredit());
			userInfo.setDarkmind(u.getDarkmind());
			userInfo.setIndex(u.getIndex());
			userInfo.setPicture(u.getPicture());
			userInfo.setStatus(u.getStatus());
			userInfo.setCredit(u.getCredit());
			userInfo.setDarkmind(u.getDarkmind());
			return new UserInfoDAO().getFullUser(userInfo);
		} else {
			return null;
		}
	}
}
