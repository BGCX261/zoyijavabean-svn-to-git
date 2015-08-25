package org.zoyi.adapter;

public class BenifitActivityCategoryAdapter {
	public static org.zoyi.po.UchomeEventclass toPo(
			org.zoyi.vo.BenifitActivityCategory b) {
		org.zoyi.po.UchomeEventclass u = new org.zoyi.po.UchomeEventclass();
		u.setClassid(b.getId() != 0 ? (short) b.getId() : null);
		u.setClassname(b.getBenifitActivityCategoryName());
		return u;
	}

	public static org.zoyi.vo.BenifitActivityCategory toVo(
			org.zoyi.po.UchomeEventclass u) {
		org.zoyi.vo.BenifitActivityCategory b = new org.zoyi.vo.BenifitActivityCategory();
		b.setId(u.getClassid());
		b.setBenifitActivityCategoryName(u.getClassname());
		return b;
	}
}
