package org.zoyi.adapter;

import org.zoyi.vo.GroupCategory;

public class AppliedGroupAdapter {
	public static org.zoyi.po.ZoyiAppliedgroup toPo(org.zoyi.vo.AppliedGroup ag) {
		if (ag != null) {
			org.zoyi.po.ZoyiAppliedgroup zag = new org.zoyi.po.ZoyiAppliedgroup(
					ag.getGroupName(), ag.getBirthProvince(),
					ag.getBirthCity(), ag.getPhone(), ag.getEmail(), ag
							.getAddress(), ag.getLinkman(), ag.getApplyDate(),
					ag.getApplyStatus(), ag.getPwd());
			zag.setId(ag.getId());
			zag.setFieldid((short) ag.getGroupCategory().getId());
			return zag;
		} else
			return null;
	}

	public static org.zoyi.vo.AppliedGroup toVo(org.zoyi.po.ZoyiAppliedgroup zag) {
		if (zag != null) {
			org.zoyi.vo.AppliedGroup ag = new org.zoyi.vo.AppliedGroup();
			ag.setAddress(zag.getAddress());
			ag.setApplyDate(zag.getApplydate());
			ag.setApplyStatus(zag.getApplystatus());
			ag.setBirthCity(zag.getBirthcity());
			ag.setBirthProvince(zag.getBirthprovince());
			ag.setEmail(zag.getEmail());
			ag.setGroupName(zag.getGroupname());
			ag.setId(zag.getId());
			ag.setLinkman(zag.getLinkman());
			ag.setPhone(zag.getPhone());
			ag.setPwd(zag.getPwd());
			GroupCategory gc = new GroupCategory();
			gc.setId(zag.getFieldid());
			ag.setGroupCategory(gc);
			return ag;
		} else
			return null;
	}
}
