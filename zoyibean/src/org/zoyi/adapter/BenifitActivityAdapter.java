package org.zoyi.adapter;

import org.zoyi.hibernate.BenifitActivityCategoryDAO;
import org.zoyi.hibernate.BenifitActivityDAO;
import org.zoyi.hibernate.GroupDAO;
import org.zoyi.hibernate.UserInfoDAO;
import org.zoyi.po.UchomeEventfield;

public class BenifitActivityAdapter {
    /*
	public static org.zoyi.vo.BenifitActivity toVo(
			org.zoyi.po.ZoyiBenifitactivity z) {
		if (z != null) {
			org.zoyi.vo.BenifitActivity b = new org.zoyi.vo.BenifitActivity();
			
			 * b.setAcceptedPeopleNum(z.getAcceptedpeoplenum());
			 * b.setActivityDescription(z.getActivitydescription());
			 * b.setActivityName(z.getActivityname());
			 * b.setActivityPlace(z.getActivityplace());
			 * b.setApplyDeadline(z.getApplydeadline());
			 * b.setApplyingPeopleNum(z.getApplyingpeoplenum());
			 * b.setBeginTime(z.getBegintime());
			 * b.setChiefPeople(z.getChiefpeople());
			 * b.setCreateTime(z.getCreatetime()); b.setEmail(z.getEmail());
			 * b.setEndingTime(z.getEndingtime());
			 * b.setGroup(GroupAdapter.toVo(new
			 * GroupDAO().get(z.getGroupId()))); b.setId(z.getId());
			 * b.setLimitPeopleNum(z.getLimitpeoplenum());
			 * b.setLinkman(z.getLinkman()); b.setNature(z.getNature());
			 * b.setPhone(z.getPhone()); b.setPicture(z.getPicture());
			 * b.setRemark(z.getRemark()); b.setStatus(z.getStatus());
			 * b.setWorkDescription(z.getWorkdescription());

			return b;
		} else
			return null;
	}

	public static org.zoyi.po.ZoyiBenifitactivity toPo(
			org.zoyi.vo.BenifitActivity b) {
		if (b != null) {
			org.zoyi.po.ZoyiBenifitactivity z = new org.zoyi.po.ZoyiBenifitactivity();

			 * z.setAcceptedpeoplenum(b.getAcceptedPeopleNum());
			 * z.setActivitydescription(b.getActivityDescription());
			 * z.setActivityname(b.getActivityName());
			 * z.setActivityplace(b.getActivityPlace());
			 * z.setApplydeadline(b.getApplyDeadline());
			 * z.setApplyingpeoplenum(b.getApplyingPeopleNum());
			 * z.setBegintime(b.getBeginTime());
			 * z.setChiefpeople(b.getChiefPeople());
			 * z.setCreatetime(b.getCreateTime()); z.setEmail(b.getEmail());
			 * z.setEndingtime(b.getEndingTime());
			 * z.setGroupId(b.getGroup().getId()); z.setId(b.getId());
			 * z.setLimitpeoplenum(b.getLimitPeopleNum());
			 * z.setLinkman(b.getLinkman()); z.setNature(b.getNature());
			 * z.setPhone(b.getPhone()); z.setPicture(b.getPicture());
			 * z.setRemark(b.getRemark()); z.setStatus(b.getRemark());
			 * z.setWorkdescription(b.getWorkDescription());
			 *
			return z;
		} else
			return null;
	}
             */
	public static org.zoyi.po.UchomeEvent toPo(org.zoyi.vo.BenifitActivity b) {
		org.zoyi.po.UchomeEvent u = new org.zoyi.po.UchomeEvent();
		u.setCity(b.getCity());
		u.setClassid((short) b.getBenifitActivityCategory().getId());
		u.setDateline((int) (new java.util.Date().getTime() / 1000));
		u.setDeadline((int) (b.getDeadline().getTime() / 1000));
		u.setEndtime((int) (b.getEndtime().getTime() / 1000));
		u.setEventid(b.getId());
		u.setFollownum(b.getFollownum());
		u.setGrade((short) 1);
		u.setHot(0);
		u.setLocation(b.getLocation());
		u.setMembernum(b.getMembernum());
		u.setPicnum(0);
		u.setPoster(b.getPoster());
		u.setProvince(b.getProvince());
		u.setPublic_((short) 0);
		u.setRecommendtime((int) (b.getDeadline().getTime() / 1000));
		u.setRemote((short) 0);
		u.setStarttime((int) (b.getStarttime().getTime() / 1000));
		u.setTagid(b.getGroup().getId());
		u.setThreadnum(b.getThreadnum());
		u.setThumb((short) 0);
		u.setTitle(b.getActivityName());
		u.setTopicid(0);
		u.setUid(b.getUid());
		u.setUpdatetime((int) (b.getUpdatetime().getTime() / 1000));
		u.setUsername(new UserInfoDAO().get(b.getUid()).getUsername());
		u.setViewnum(0);
		return u;
	}

	public static org.zoyi.vo.BenifitActivity toVo(org.zoyi.po.UchomeEvent u) {
		org.zoyi.vo.BenifitActivity b = new org.zoyi.vo.BenifitActivity();
		UchomeEventfield uf = new BenifitActivityDAO().getField(u.getEventid());
		b.setActivityName(u.getTitle());
		b.setAllowfellow(uf.getAllowfellow());
		b.setBenifitActivityCategory(BenifitActivityCategoryAdapter
				.toVo(new BenifitActivityCategoryDAO().get(u.getClassid())));
		b.setCity(u.getCity());
		b.setDeadline(new java.util.Date((long) u.getDateline() * 1000));
		b.setDetail(uf.getDetail());
		b.setEndtime(new java.util.Date((long) u.getEndtime() * 1000));
		b.setFollownum(u.getFollownum());
		b.setGroup(GroupAdapter.toVo(new GroupDAO().get(u.getTagid())));
		b.setId(u.getEventid());
		b.setLimitnum(uf.getLimitnum());
		b.setLocation(u.getLocation());
		b.setMembernum(u.getMembernum());
		b.setPoster(u.getPoster());
		b.setProvince(u.getProvince());
		b.setStarttime(new java.util.Date((long) u.getStarttime() * 1000));
		b.setThreadnum(u.getThreadnum());
		b.setUid(u.getUid());
		b.setUpdatetime(new java.util.Date((long) u.getUpdatetime() * 1000));
		return b;
	}
}
