package org.zoyi.adapter;

public class GroupCategoryAdapter {
	public static org.zoyi.vo.GroupCategory toVo(org.zoyi.po.UchomeProfield u) {
		org.zoyi.vo.GroupCategory g = new org.zoyi.vo.GroupCategory();
		if (u != null) {
			g.setChoice(u.getChoice());
			g.setId(u.getFieldid());
			g.setInputnum(u.getInputnum());
			g.setNote(u.getNote());
			g.setTitle(u.getTitle());
			return g;
		}
		return null;
	}

	public static org.zoyi.po.UchomeProfield toPo(org.zoyi.vo.GroupCategory g) {
		org.zoyi.po.UchomeProfield u = new org.zoyi.po.UchomeProfield();
		u.setChoice(g.getChoice());
		u.setFieldid(g.getId() == 0 ? (short) g.getId() : null);
		u.setInputnum((short) g.getInputnum());
		u.setNote(g.getNote());
		u.setTitle(g.getTitle());
		return u;
	}
}
