package org.zoyi.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.zoyi.adapter.AppliedGroupAdapter;
import org.zoyi.adapter.StringAdapter;
import org.zoyi.po.UcMembers;
import org.zoyi.po.UchomeMtag;
import org.zoyi.po.UchomeTagspace;
import org.zoyi.po.UchomeTagspaceId;
import org.zoyi.po.ZoyiAnnouncement;
import org.zoyi.po.ZoyiAppliedgroup;
import org.zoyi.po.ZoyiNews;
import org.zoyi.util.MD5Generator;

public class AppliedGroupDAO {
	public String add(ZoyiAppliedgroup a) {
		a.setApplystatus("0");
		a.setApplydate(new java.util.Date());
		if (new UserInfoDAO().queryUserByName(a.getLinkman()) == null
				&& new GroupDAO().queryGroupByName(a.getGroupname()) == null
				&& this.queryByName(a.getGroupname()) == null) {
			Session session = HibernateSessionFactoryUtil.getSessionFactory()
					.getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.save(a);
			tx.commit();
			UcMembers u = new UcMembers();
			u.setEmail(a.getEmail());
			u.setUsername(a.getLinkman());
			u.setPassword("");
			u.setStatus("");
			u.setPicture("");
			u.setIndex("");
			u.setCredit(0);
			u.setDarkmind(0);
			Session session2 = HibernateSessionFactoryUtil.getSessionFactory()
					.getCurrentSession();
			Transaction tx2 = session2.beginTransaction();
			u.setLastloginip(0);
			u.setLastlogintime(0);
			u.setSalt(java.util.UUID.randomUUID().toString().substring(0, 6));
			u.setMyid("");
			u.setMyidkey("");
			u.setRegip("");
			u.setRegdate(0);
			u.setSecques("");
			session2.save(u);
			tx2.commit();
			return "success";
		}
		return "fail";
	}

	public void update(ZoyiAppliedgroup a) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(a);
		tx.commit();
	}

	public ZoyiAppliedgroup get(int id) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		ZoyiAppliedgroup a = (ZoyiAppliedgroup) session.get(
				ZoyiAppliedgroup.class, new Integer(id));
		tx.commit();
		return a;
	}

	public void delete(int id) {
		ZoyiAppliedgroup a = this.get(id);
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.delete(a);
		tx.commit();
	}

	public void refuse(int id) {
		ZoyiAppliedgroup a = this.get(id);
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		a.setApplystatus("1");
		session.saveOrUpdate(a);
		tx.commit();
	}

	public void accept(int id) {
		ZoyiAppliedgroup a = this.get(id);
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		a.setApplystatus("2");
		session.saveOrUpdate(a);
		UchomeMtag u = new UchomeMtag();
		u.setAboutgroup("");
		u.setAddress(a.getAddress());
		u.setAnnouncement("");
		u.setBirthcity(a.getBirthcity());
		u.setBirthday(a.getApplydate());
		u.setBirthprovince(a.getBirthprovince());
		u.setCredit(0);
		u.setEmail(a.getEmail());
		u.setFuture("");
		u.setLinkman(a.getLinkman());
		u.setPhone(a.getPhone());
		u.setPic("");
		u.setPwd(a.getPwd());
		u.setRemark("");
		u.setScale("");
		u.setTagname(a.getGroupname());
		u.setFieldid(a.getFieldid());
		u.setUserindex("");
		tx.commit();
		new GroupDAO().add(u);
		UchomeMtag group = new GroupDAO().queryGroupByName(a.getGroupname());
		UserInfoDAO usrd = new UserInfoDAO();
		UcMembers um = usrd.queryUserByName(a.getLinkman());
		um.setPassword(a.getPwd());
		usrd.add(um);
		UchomeTagspace ut = new UchomeTagspace(new UchomeTagspaceId(group
				.getTagid(), um.getUid()), um.getUsername(), (short) 9);
		Session session2 = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx2 = session2.beginTransaction();
		session2.save(ut);
		tx2.commit();

	}

	public List<Object> queryByPage(int startRow, int pageSize)
			throws Exception {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ZoyiAppliedgroup.class);
		criteria.setMaxResults(pageSize);
		criteria.setFirstResult(startRow);
		List<ZoyiAppliedgroup> zag = criteria.list();
		tx.commit();
		List<Object> list = new ArrayList<Object>();
		for (ZoyiAppliedgroup i : zag) {
			list.add(AppliedGroupAdapter.toVo(i));
		}
		return list;
	}

	public int getCount() {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session
				.createSQLQuery("select count(*) from zoyi_appliedgroup");
		int i = StringAdapter.obj2Int(query.uniqueResult());
		tx.commit();
		return i;
	}

	public List<Object> queryByStatus(int status, int startRow, int pageSize) {
		String s = String.valueOf(status);
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ZoyiAppliedgroup.class);
		criteria.add(Restrictions.eq("status", s));
		criteria.setMaxResults(pageSize);
		criteria.setFirstResult(startRow);
		criteria.addOrder(Order.asc("applydate"));
		List<ZoyiAppliedgroup> groups = criteria.list();
		tx.commit();
		List<Object> list = new ArrayList<Object>();
		if (groups.size() > 0) {
			for (ZoyiAppliedgroup i : groups) {
				list.add(AppliedGroupAdapter.toVo(i));
			}
		}
		return list;
	}

	public int countByStatus(int status) {
		String s = String.valueOf(status);
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ZoyiAppliedgroup.class);
		criteria.add(Restrictions.eq("status", s));
		criteria.setProjection(Projections.rowCount());
		int i = StringAdapter.obj2Int(criteria.uniqueResult());
		tx.commit();
		return i;
	}

	public ZoyiAppliedgroup queryByName(String name) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session
				.createQuery("from ZoyiAppliedgroup where groupname = ?");
		query.setString(0, name);
		ZoyiAppliedgroup u = (ZoyiAppliedgroup) query.uniqueResult();
		tx.commit();
		return u;
	}
}
