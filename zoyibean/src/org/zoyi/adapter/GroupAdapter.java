package org.zoyi.adapter;

import org.zoyi.hibernate.UserInfoDAO;

public class GroupAdapter {
	public static org.zoyi.po.UchomeMtag toPo(org.zoyi.vo.Group g) {
		if (g != null) {
			org.zoyi.po.UchomeMtag u = new org.zoyi.po.UchomeMtag();
			u.setAboutgroup(g.getAboutGroup());
			u.setAddress(g.getAddress());
			u.setBirthcity(g.getBirthCity());
			u.setBirthday(g.getBirthDay());
			u.setBirthprovince(g.getBirthProvince());
			u.setCredit(g.getCredit());
			u.setEmail(g.getEmail());
			u.setFuture(g.getFuture());
			u.setLinkman(g.getLinkman());
			u.setPhone(g.getPhone());
			u.setPic(g.getLogoPicture());
			u.setPwd(g.getPwd());
			u.setScale(g.getScale());
			u.setTagid(g.getId());
			u.setTagname(g.getGroupName());
			u.setUserindex(g.getIndex());
			u.setRemark(g.getRemark());
			return u;
		} else
			return null;
	}

	public static org.zoyi.vo.Group toVo(org.zoyi.po.UchomeMtag u) {
		if (u != null) {
			org.zoyi.vo.Group g = new org.zoyi.vo.Group();
			g.setAboutGroup(u.getAboutgroup());
			g.setAddress(u.getAddress());
			g.setBirthCity(u.getBirthcity());
			g.setBirthProvince(u.getBirthprovince());
			g.setCredit(u.getCredit());
			g.setEmail(u.getEmail());
			g.setFuture(u.getFuture());
			g.setGroupName(u.getTagname());
			g.setId(u.getTagid());
			g.setIndex(u.getUserindex());
			g.setLinkman(u.getLinkman());
			g.setLogoPicture(u.getPic());
			g.setPhone(u.getPhone());
			g.setBirthDay(u.getBirthday());
			g.setPwd(u.getPwd());
			g.setRemark(u.getRemark());
			g.setScale(u.getScale());
			g.setUserinfo(UserinfoAdapter.toVo(new UserInfoDAO()
					.queryUserByName(u.getLinkman())));
			return g;
		} else
			return null;
	}
}
