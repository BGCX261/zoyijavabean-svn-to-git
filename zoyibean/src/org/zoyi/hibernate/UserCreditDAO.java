package org.zoyi.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.zoyi.adapter.StringAdapter;
import org.zoyi.adapter.UserCreditAdapter;
import org.zoyi.po.UchomeUserevent;

public class UserCreditDAO {

	public List<Object> queryRecordInDays(int userid, int day) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeUserevent.class);
		criteria.add(Restrictions.and(Restrictions.eq("id.uid", userid),
				Restrictions.between("getcreditdate", this
						.getDateDaysBefore(day), new Date())));
		criteria.addOrder(Order.desc("getcreditdate"));
		List<UchomeUserevent> ue = criteria.list();
		tx.commit();
		List<Object> list = new ArrayList<Object>();
		if (ue.size() > 0) {
			for (UchomeUserevent i : ue) {
				list.add(UserCreditAdapter.toVo(i));
			}
		}
		return list;
	}

	public int queryCreditCountInDays(int userid, int day) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeUserevent.class);
		criteria.add(Restrictions.and(Restrictions.eq("id.uid", userid),
				Restrictions.between("getcreditdate", this
						.getDateDaysBefore(day), new Date())));
		criteria.setProjection(Projections.sum("credit"));
		int i = StringAdapter.obj2Int(criteria.uniqueResult());
		tx.commit();
		return i;
	}

	public int queryDMCountInDays(int userid, int day) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeUserevent.class);
		criteria.add(Restrictions.and(Restrictions.eq("id.uid", userid),
				Restrictions.between("getcreditdate", this
						.getDateDaysBefore(day), new Date())));
		criteria.setProjection(Projections.sum("darkmind"));
		int i = StringAdapter.obj2Int(criteria.uniqueResult());
		tx.commit();
		return i;
	}

	public int queryCreditCount(int userid) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeUserevent.class);
		criteria.add(Restrictions.eq("id.uid", userid));
		criteria.setProjection(Projections.sum("credit"));
		int i = StringAdapter.obj2Int(criteria.uniqueResult());
		tx.commit();
		return i;
	}

	public int queryDMCount(int userid) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeUserevent.class);
		criteria.add(Restrictions.eq("id.uid", userid));
		criteria.setProjection(Projections.sum("darkmind"));
		int i = StringAdapter.obj2Int(criteria.uniqueResult());
		tx.commit();
		return i;
	}

	public List<Object> queryByBaid(int startRow, int pageSize, int baid) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeUserevent.class);
		criteria.add(Restrictions.eq("id.eventid", baid));
		criteria.addOrder(Order.desc("dateline"));
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(pageSize);
		List<UchomeUserevent> ue = criteria.list();
		tx.commit();
		List<Object> list = new ArrayList<Object>();
		if (ue.size() > 0) {
			for (UchomeUserevent i : ue) {
				list.add(UserCreditAdapter.toVo(i));
			}
		}
		return list;
	}

	public List<Object> queryByUserId(int startRow, int pageSize, int userid) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeUserevent.class);
		criteria.add(Restrictions.eq("id.uid", userid));
		criteria.addOrder(Order.desc("dateline"));
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(pageSize);
		List<UchomeUserevent> ue = criteria.list();
		tx.commit();
		List<Object> list = new ArrayList<Object>();
		if (ue.size() > 0) {
			for (UchomeUserevent i : ue) {
				list.add(UserCreditAdapter.toVo(i));
			}
		}
		return list;
	}

	public List<Object> queryByBaid(int baid) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeUserevent.class);
		criteria.add(Restrictions.eq("id.eventid", baid));
		criteria.addOrder(Order.desc("dateline"));
		List<UchomeUserevent> ue = criteria.list();
		tx.commit();
		List<Object> list = new ArrayList<Object>();
		if (ue.size() > 0) {
			for (UchomeUserevent i : ue) {
				list.add(UserCreditAdapter.toVo(i));
			}
		}
		return list;
	}

	public List<Object> queryByUserId(int userid) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeUserevent.class);
		criteria.add(Restrictions.eq("id.uid", userid));
		criteria.addOrder(Order.desc("dateline"));
		List<UchomeUserevent> ue = criteria.list();
		tx.commit();
		List<Object> list = new ArrayList<Object>();
		if (ue.size() > 0) {
			for (UchomeUserevent i : ue) {
				list.add(UserCreditAdapter.toVo(i));
			}
		}
		return list;
	}

	public int getCountByBaid(int baid) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeUserevent.class);
		criteria.add(Restrictions.eq("id.eventid", baid));
		criteria.setProjection(Projections.rowCount());
		int i = StringAdapter.obj2Int(criteria.uniqueResult());
		tx.commit();
		return i;
	}

	public int getCountByUserId(int id) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeUserevent.class);
		criteria.add(Restrictions.eq("id.uid", id));
		criteria.setProjection(Projections.rowCount());
		int i = StringAdapter.obj2Int(criteria.uniqueResult());
		tx.commit();
		return i;
	}

	private int getDaysBefore(int day) {
		return (int) (new Date().getTime() / 1000 - day * 86400);
	}

	private Date getDateDaysBefore(int day) {
		Date now = new Date();
		return new Date(now.getTime() - day * 86400000);
	}
}
