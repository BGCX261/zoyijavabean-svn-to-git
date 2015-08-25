package org.zoyi.hibernate;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.zoyi.adapter.GroupAdapter;
import org.zoyi.adapter.StringAdapter;
import org.zoyi.adapter.UserinfoAdapter;
import org.zoyi.po.*;
import org.zoyi.util.MD5Generator;
import org.zoyi.vo.Group;

public class GroupDAO {
	public void add(UchomeMtag a) {
		a.setClose((short) 0);
		a.setCloseapply((short) 1);
		a.setRecommend((short) 0);
		a.setJoinperm((short) 2);
		a.setPostperm((short) 0);
		a.setThreadperm((short) 0);
		a.setViewperm((short) 0);
		a.setMembernum(0);
		a.setPostnum(0);
		a.setThreadnum(0);
		a.setFieldid((short) 0);
		a.setAnnouncement("");
		a.setModerator("");
		a.setBirthday(new java.util.Date());
		a.setSalt(java.util.UUID.randomUUID().toString().substring(0, 6));
		String p = MD5Generator.MD5(a.getPwd());
		a.setPwd(MD5Generator.MD5(p + a.getSalt()));
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(a);
		tx.commit();
	}

	public void update(Group g) {
		UchomeMtag u = this.get(g.getId());
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
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
		u.setScale(g.getScale());
		u.setTagname(g.getGroupName());
		u.setUserindex(g.getIndex());
		u.setRemark(g.getRemark());
		session.saveOrUpdate(u);
		tx.commit();
	}

	public void changePassword(int id, String password) {
		UchomeMtag u = this.get(id);
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		u.setSalt(java.util.UUID.randomUUID().toString().substring(0, 6));
		String p = MD5Generator.MD5(password);
		u.setPwd(MD5Generator.MD5(p + u.getSalt()));
		session.saveOrUpdate(u);
		tx.commit();
	}

	public UchomeMtag login(String name, String pwd) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from UchomeMtag where tagname = ?");
		query.setString(0, name);
		UchomeMtag u = (UchomeMtag) query.uniqueResult();
		tx.commit();
		if (u != null) {
			String p = MD5Generator.MD5(pwd);
			String password = MD5Generator.MD5(p + u.getSalt());
			if (password.equals(u.getPwd())) {
				return u;
			}
		}
		return null;
	}

	public UchomeMtag get(int i) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		UchomeMtag a = (UchomeMtag) session.get(UchomeMtag.class,
				new Integer(i));
		tx.commit();
		return a;
	}

	public void delete(int id) {
		UchomeMtag a = this.get(id);
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.delete(a);
		tx.commit();
	}

	public int getCount() {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("select count(*) from UchomeMtag");
		int i = StringAdapter.obj2Int(query.uniqueResult());
		tx.commit();
		return i;
	}

	public UchomeMtag getGroupStar() {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeMtag.class);
		criteria.addOrder(Order.desc("membernum"));
		criteria.setMaxResults(1);
		UchomeMtag u = (UchomeMtag) criteria.uniqueResult();
		tx.commit();
		return u;
	}

	public UchomeMtag getNewGroup() {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeMtag.class);
		criteria.addOrder(Order.desc("birthday"));
		criteria.setMaxResults(1);
		UchomeMtag u = (UchomeMtag) criteria.uniqueResult();
		tx.commit();
		return u;
	}

	public String getPic(int id) {
		return this.get(id).getPic();
	}

	public List<Object> queryByPage(int startRow, int pageSize) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeMtag.class);
		criteria.setMaxResults(pageSize);
		criteria.setFirstResult(startRow);
		criteria.addOrder(Order.desc("tagid"));
		List<UchomeMtag> zag = criteria.list();
		tx.commit();
		List<Object> list = new ArrayList<Object>();
		for (UchomeMtag i : zag) {
			list.add(GroupAdapter.toVo(i));
		}
		return list;
	}

	public List<Object> queryBySoft(int startRow, int pageSize) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeMtag.class);
		criteria.setMaxResults(pageSize);
		criteria.setFirstResult(startRow);
		criteria.addOrder(Order.desc("membernum"));
		List<UchomeMtag> zag = criteria.list();
		tx.commit();
		List<Object> list = new ArrayList<Object>();
		for (UchomeMtag i : zag) {
			list.add(GroupAdapter.toVo(i));
		}
		return list;
	}

	public String isExist(String name, String pwd) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from UchomeMtag where tagname = ?");
		query.setString(0, name);
		UchomeMtag u = (UchomeMtag) query.uniqueResult();
		tx.commit();
		if (u != null) {
			String p = MD5Generator.MD5(pwd);
			String password = MD5Generator.MD5(p + u.getSalt());
			if (password.equals(u.getPwd())) {
				return "success";
			}
		}
		return "fail";
	}

	public UchomeMtag queryGroupByName(String name) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from UchomeMtag where tagname = ?");
		query.setString(0, name);
		UchomeMtag u = (UchomeMtag) query.uniqueResult();
		tx.commit();
		return u;
	}

	public String getCodePwd(String name) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from UchomeMtag where tagname = ?");
		query.setString(0, name);
		UchomeMtag u = (UchomeMtag) query.uniqueResult();
		tx.commit();
		return MD5Generator.MD5(u.getPwd() + u.getSalt());
	}

	public boolean isRightPwd(String name, String codePwd) {
		if (codePwd.equals(this.getCodePwd(name)))
			return true;
		else
			return false;
	}

	public void applyGroup(int userId, int gid) {
		String name = new UserInfoDAO().get(userId).getUsername();
		UchomeTagspace u = new UchomeTagspace(
				new UchomeTagspaceId(gid, userId), name, (short) -2);
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(u);
		UchomeMtag m = (UchomeMtag) session.get(UchomeMtag.class, gid);
		m.setMembernum(m.getMembernum() + 1);
		session.saveOrUpdate(u);
		tx.commit();
	}

	public List<Object> getRelatedUser(int gid) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UcMembers.class);
		criteria.add(Restrictions.in("uid", session.createCriteria(
				UchomeTagspace.class).add(Restrictions.eq("id.tagid", gid))
				.list()));
		try {
			List<UcMembers> users = criteria.list();
			tx.commit();
			List<Object> list = new ArrayList<Object>();
			if (users.size() > 0) {
				for (UcMembers i : users) {
					list.add(UserinfoAdapter.toVo(i));
				}
			}
			return list;
		} catch (Exception e) {
			tx.rollback();
			return new ArrayList<Object>();
		}
	}
}
