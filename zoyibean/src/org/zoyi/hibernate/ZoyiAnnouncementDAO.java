package org.zoyi.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.zoyi.adapter.AnnouncementAdapter;
import org.zoyi.adapter.StringAdapter;
import org.zoyi.po.ZoyiAnnouncement;
import org.zoyi.po.ZoyiNews;

public class ZoyiAnnouncementDAO {
	public void add(ZoyiAnnouncement a) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		a.setCreatedate(new java.util.Date());
		session.save(a);
		tx.commit();
	}

	public ZoyiAnnouncement get(int id) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		ZoyiAnnouncement a = (ZoyiAnnouncement) session.get(
				ZoyiAnnouncement.class, new Integer(id));
		tx.commit();
		return a;
	}

	public void update(ZoyiAnnouncement a) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		a.setCreatedate(new java.util.Date());
		session.saveOrUpdate(a);
		tx.commit();
	}

	public void delete(int id) {
		ZoyiAnnouncement a = this.get(id);
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.delete(a);
		tx.commit();
	}

	public List<Object> queryByPage(int startRow, int pageSize) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ZoyiAnnouncement.class);
		criteria.setMaxResults(pageSize);
		criteria.setFirstResult(startRow);
		List<ZoyiAnnouncement> a = criteria.list();
		tx.commit();
		List<Object> ann = new ArrayList<Object>();
		if (a.size() > 0) {
			for (ZoyiAnnouncement i : a) {
				ann.add(AnnouncementAdapter.toVo(i));
			}
		}
		return ann;
	}

	public int getCount() {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session
				.createQuery("select count(*) from ZoyiAnnouncement");
		int i = StringAdapter.obj2Int(query.uniqueResult());
		tx.commit();
		return i;
	}

	public void plusClick(int i, int id) {
		ZoyiAnnouncement z = this.get(id);
		z.setClickcount(z.getClickcount() + i);
		this.update(z);
	}

	public List<Object> queryByCond(int startRow, int pageSize, String cond) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ZoyiAnnouncement.class);
		criteria.add(Restrictions.or(Restrictions.like("title", "%" + cond
				+ "%"), Restrictions.or(Restrictions.like("announcer", "%"
				+ cond + "%"), Restrictions
				.like("createdate", "%" + cond + "%"))));
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(pageSize);
		criteria.addOrder(Order.desc("createdate"));
		List<ZoyiAnnouncement> announcement = criteria.list();
		tx.commit();
		List<Object> list = new ArrayList<Object>();
		if (announcement != null) {
			for (ZoyiAnnouncement i : announcement) {
				list.add(AnnouncementAdapter.toVo(i));
			}
		}
		return list;
	}

	public int countByCond(String cond) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ZoyiAnnouncement.class);
		criteria.add(Restrictions.or(Restrictions.like("title", "%" + cond
				+ "%"), Restrictions.or(Restrictions.like("announcer", "%"
				+ cond + "%"), Restrictions
				.like("createdate", "%" + cond + "%"))));
		criteria.setProjection(Projections.rowCount());
		int i = StringAdapter.obj2Int(criteria.uniqueResult());
		tx.commit();
		return i;
	}
}
