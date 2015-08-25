package org.zoyi.hibernate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.zoyi.adapter.BenifitActivityAdapter;
import org.zoyi.adapter.StringAdapter;
import org.zoyi.adapter.UserinfoAdapter;
import org.zoyi.po.UcMembers;
import org.zoyi.po.UchomeEvent;
import org.zoyi.po.UchomeEventfield;
import org.zoyi.po.UchomeMtag;
import org.zoyi.po.UchomeUserevent;
import org.zoyi.po.UchomeUsereventId;
import org.zoyi.po.ZoyiBenifitactivity;
import org.zoyi.po.ZoyiUserActivity;
import org.zoyi.po.ZoyiUserActivityId;
import org.zoyi.vo.BenifitActivity;

public class BenifitActivityDAO {
	public UchomeEvent get(int id) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		UchomeEvent u = (UchomeEvent) session.get(UchomeEvent.class,
				new Integer(id));
		tx.commit();
		return u;
	}

	public UchomeEventfield getField(int id) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		UchomeEventfield u = (UchomeEventfield) session.get(
				UchomeEventfield.class, new Integer(id));
		tx.commit();
		return u;
	}

	public int getCount() {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeEvent.class);
		criteria.setProjection(Projections.rowCount());
		int i = StringAdapter.obj2Int(criteria.uniqueResult());
		tx.commit();
		return i;
	}

	public List<Object> queryByPage(int startRow, int pageSize) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeEvent.class);
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(pageSize);
		criteria.addOrder(Order.desc("endtime"));
		List<UchomeEvent> ue = criteria.list();
		tx.commit();
		List<Object> list = new ArrayList<Object>();
		if (ue != null) {
			for (UchomeEvent i : ue) {
				list.add(BenifitActivityAdapter.toVo(i));
			}
		}
		return list;
	}

	public List<Object> queryByEndtime(int startRow, int pageSize,
			Date endtime, int status) {
		int time = (int) (endtime.getTime() / 1000);
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeEvent.class);
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(pageSize);
		criteria.addOrder(Order.desc("endtime"));
		if (status == 1) {
			criteria.add(Restrictions.lt("endtime", time));
		} else if (status == 2) {
			criteria.add(Restrictions.gt("endtime", time));
		}
		List<UchomeEvent> ue = criteria.list();
		tx.commit();
		List<Object> list = new ArrayList<Object>();
		if (ue != null) {
			for (UchomeEvent i : ue) {
				list.add(BenifitActivityAdapter.toVo(i));
			}
		}
		return list;
	}

	public int getCountByEndtime(Date endtime, int status) throws Exception {
		int time = (int) (endtime.getTime() / 1000);
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeEvent.class);
		criteria.setProjection(Projections.rowCount());
		if (status == 1) {
			criteria.add(Restrictions.lt("endtime", time));
		} else if (status == 2) {
			criteria.add(Restrictions.gt("endtime", time));
		}
		int i = StringAdapter.obj2Int(criteria.uniqueResult());
		tx.commit();
		return i;
	}

	public List<Object> queryByGroupId(int startRow, int pageSize, int id) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeEvent.class);
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(pageSize);
		criteria.add(Restrictions.eq("tagid", id));
		List<UchomeEvent> ue = criteria.list();
		tx.commit();
		List<Object> list = new ArrayList<Object>();
		if (ue != null) {
			for (UchomeEvent i : ue) {
				list.add(BenifitActivityAdapter.toVo(i));
			}
		}
		return list;
	}

	public List<Object> queryBySoft(int startRow, int pageSize) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeEvent.class);
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(pageSize);
		criteria.addOrder(Order.desc("membernum"));
		List<UchomeEvent> ue = criteria.list();
		tx.commit();
		List<Object> list = new ArrayList<Object>();
		if (ue != null) {
			for (UchomeEvent i : ue) {
				list.add(BenifitActivityAdapter.toVo(i));
			}
		}
		return list;
	}

	public int getUserCountByStatusBAId(int baid, int status) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeUserevent.class);
		criteria.add(Restrictions.and(Restrictions.eq("id.eventid", baid),
				Restrictions.eq("status", status)));
		criteria.setProjection(Projections.rowCount());
		int i = StringAdapter.obj2Int(criteria.uniqueResult());
		tx.commit();
		return i;
	}

	public List<Object> queryByUserId(int startRow, int pageSize, int userid) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeEvent.class);
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(pageSize);
		criteria.add(Restrictions.in("eventid", session.createCriteria(
				UchomeUserevent.class).setProjection(
				Projections.property("id.eventid")).add(
				Restrictions.eq("id.uid", userid)).list()));
		try {
			List<UchomeEvent> ue = criteria.list();
			tx.commit();
			List<Object> list = new ArrayList<Object>();
			if (ue != null) {
				for (UchomeEvent i : ue) {
					list.add(BenifitActivityAdapter.toVo(i));
				}
			}
			return list;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			return new ArrayList<Object>();
		}
	}

	public List<Object> queryUserByBAId(int startRow, int pageSize, int baid) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UcMembers.class);
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(pageSize);
		criteria.add(Restrictions.in("uid", session.createCriteria(
				UchomeUserevent.class).setProjection(
				Projections.property("id.uid")).add(
				Restrictions.eq("id.eventid", baid)).list()));
		try {
			List<UcMembers> um = criteria.list();
			tx.commit();
			List<Object> list = new ArrayList<Object>();
			if (um != null) {
				for (UcMembers i : um) {
					list.add(UserinfoAdapter.toVo(i));
				}
			}
			return list;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			return new ArrayList<Object>();
		}
	}

	public List<Object> queryUserByStatusBAId(int startRow, int pageSize,
			int baid, int status) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UcMembers.class);
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(pageSize);
		criteria.add(Restrictions.in("uid", session.createCriteria(
				UchomeUserevent.class).setProjection(
				Projections.property("id.uid")).add(
				Restrictions.and(Restrictions.eq("id.eventid", baid),
						Restrictions.eq("status", status))).list()));
		try {
			List<UcMembers> um = criteria.list();
			tx.commit();
			List<Object> list = new ArrayList<Object>();
			if (um != null) {
				for (UcMembers i : um) {
					list.add(UserinfoAdapter.toVo(i));
				}
			}
			return list;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			return new ArrayList<Object>();
		}
	}

	public UchomeMtag getGroup(int id) {
		int tagid = this.get(id).getTagid();
		return new GroupDAO().get(tagid);
	}

	public int getActivityCountByUserIdStatus(int userId, short status) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeUserevent.class);
		criteria.add(Restrictions.and(Restrictions.eq("id.uid", userId),
				Restrictions.eq("status", status)));
		criteria.setProjection(Projections.rowCount());
		int i = StringAdapter.obj2Int(criteria.uniqueResult());
		tx.commit();
		return i;
	}

	public int getCountByUserId(int userid) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeUserevent.class);
		criteria.add(Restrictions.eq("id.uid", userid));
		criteria.setProjection(Projections.rowCount());
		int i = StringAdapter.obj2Int(criteria.uniqueResult());
		tx.commit();
		return i;
	}

	public int getCountByGroupId(int groupid) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeEvent.class);
		criteria.add(Restrictions.eq("tagid", groupid));
		criteria.setProjection(Projections.rowCount());
		int i = StringAdapter.obj2Int(criteria.uniqueResult());
		tx.commit();
		return i;
	}

	public int getUserCountByBAId(int baid) {
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

	public String isBAIdBelongtoGroupId(int baid, int groupid) {
		UchomeEvent ue = this.get(baid);
		if (ue.getTagid() == groupid)
			return "success";
		else
			return "fail";
	}

	public List<Object> queryActivityByUserIdStatus(int startRow, int pageSize,
			int userId, short status) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeEvent.class);
		criteria.add(Restrictions.in("eventid", session.createCriteria(
				UchomeUserevent.class).setProjection(
				Projections.property("id.eventid")).add(
				Restrictions.and(Restrictions.eq("id.uid", userId),
						Restrictions.eq("status", status))).list()));
		try {
			List<UchomeEvent> ue = criteria.list();
			tx.commit();
			List<Object> list = new ArrayList<Object>();
			if (ue != null) {
				for (UchomeEvent i : ue) {
					list.add(BenifitActivityAdapter.toVo(i));
				}
			}
			return list;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			return new ArrayList<Object>();
		}
	}

	public UchomeUserevent getUserevent(int baid, int userId) {
		UchomeUsereventId uui = new UchomeUsereventId(baid, userId);
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		UchomeUserevent uu = (UchomeUserevent) session.get(
				UchomeUserevent.class, uui);
		tx.commit();
		return uu;
	}

	public String addUserCredit(int credit, int darkmind, int userId, int baid) {
		UchomeUserevent uu = this.getUserevent(baid, userId);
		UcMembers um = new UserInfoDAO().get(userId);
		Calendar c = Calendar.getInstance();
		c.set(2099, 11, 31);
		if (uu.getGetcreditdate() == null
				|| uu.getGetcreditdate().after(c.getTime())) {
			UchomeUsereventId uui = new UchomeUsereventId(baid, userId);
			Session session = HibernateSessionFactoryUtil.getSessionFactory()
					.getCurrentSession();
			Transaction tx = session.beginTransaction();
			uu.setCredit(credit);
			uu.setDarkmind(darkmind);
			uu.setGetcreditdate(new java.util.Date());
			session.saveOrUpdate(uu);
			um.setCredit(um.getCredit() + credit);
			um.setDarkmind(um.getDarkmind() + darkmind);
			session.saveOrUpdate(um);
			tx.commit();
			return "success";
		}
		return "fail";
	}

	public String addAllUserCreditByBAId(int credit, int darkmind, int baid) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeUserevent.class);
		criteria.setProjection(Projections.property("id.uid"));
		criteria.add(Restrictions.eq("id.eventid", baid));
		List<Integer> list = criteria.list();
		StringBuffer s = new StringBuffer();
		if (list.size() > 0) {
			for (Integer i : list) {
				try {
					if ("fail".equals(this.addUserCredit(credit, darkmind, i,
							baid))) {
						s.append(i + "-已添加,");
					}
				} catch (Exception e) {
					s.append(i + "-添加失败,");
				}
			}
		}
		return s.toString();
	}
}
