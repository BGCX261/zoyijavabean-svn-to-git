package org.zoyi.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.zoyi.adapter.AnnouncementAdapter;
import org.zoyi.adapter.NewsAdapter;
import org.zoyi.adapter.StringAdapter;
import org.zoyi.po.ZoyiAnnouncement;
import org.zoyi.po.ZoyiNews;
import org.zoyi.po.ZoyiNewscategory;

public class NewsDAO {
	public void add(ZoyiNews n) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		n.setClickcount(0);
		session.save(n);
		tx.commit();
	}

	public ZoyiNews get(int id) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		ZoyiNews n = (ZoyiNews) session.get(ZoyiNews.class, new Integer(id));
		tx.commit();
		return n;
	}

	public void delete(int id) {
		ZoyiNews n = this.get(id);
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.delete(n);
		tx.commit();
	}

	public void update(ZoyiNews n) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(n);
		tx.commit();
	}

	public int getCount() {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("select count(*) from ZoyiNews");
		int i = StringAdapter.obj2Int(query.uniqueResult());
		tx.commit();
		return i;
	}

	public List<Object> queryByPage(int startRow, int pageSize) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ZoyiNews.class);
		criteria.addOrder(Order.desc("releasetime"));
		criteria.setMaxResults(pageSize);
		criteria.setFirstResult(startRow);
		List<ZoyiNews> a = criteria.list();
		Hibernate.initialize(a);
		tx.commit();
		List<Object> ann = new ArrayList<Object>();
		if (a.size() > 0) {
			for (ZoyiNews i : a) {
				ann.add(NewsAdapter.toVo(i));
			}
		}
		return ann;
	}

	public List<Object> queryByNewsCategory(int startRow, int pageSize,
			int newsCategoryId) throws Exception {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ZoyiNews.class);
		ZoyiNewscategory z = new ZoyiNewscategory();
		z.setId(newsCategoryId);
		criteria.add(Restrictions.eq("zoyiNewscategory", z));
		criteria.addOrder(Order.desc("releasetime"));
		criteria.setMaxResults(pageSize);
		criteria.setFirstResult(startRow);
		List<ZoyiNews> a = criteria.list();
		tx.commit();
		List<Object> ann = new ArrayList<Object>();
		if (a.size() > 0) {
			for (ZoyiNews i : a) {
				ann.add(NewsAdapter.toVo(i));
			}
		}
		return ann;
	}

	public List<Object> getNewFocusNews(int count) throws Exception {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ZoyiNews.class);
		criteria.add(Restrictions.isNotNull("picture"));
		criteria.addOrder(Order.desc("releasetime"));
		criteria.setMaxResults(count);
		List<ZoyiNews> a = criteria.list();
		tx.commit();
		List<Object> ann = new ArrayList<Object>();
		if (a.size() > 0) {
			for (ZoyiNews i : a) {
				ann.add(NewsAdapter.toVo(i));
			}
		}
		return ann;

	}

	public String getNewsPicture(int newsId) throws Exception {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session
				.createSQLQuery("select picture from zoyi_news where id = ?");
		query.setInteger(0, newsId);
		String result = (String) query.uniqueResult();
		return result;
	}

	public void countPlus(int newsId) {
		ZoyiNews n = this.get(newsId);
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		n.setClickcount(n.getClickcount() + 1);
		session.saveOrUpdate(n);
		tx.commit();
	}

	public int getCountByCategory(int newsCategoryId) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session
				.createQuery("select count(*) from ZoyiNews where newscategoryid = ?");
		query.setInteger(0, newsCategoryId);
		int i = StringAdapter.obj2Int(query.uniqueResult());
		tx.commit();
		return i;
	}

	public List<Object> queryByCond(int startRow, int pageSize, String cond)
			throws Exception {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ZoyiNews.class);
		criteria.add(Restrictions.or(Restrictions.or(Restrictions.or(
				Restrictions.like("keyword1", "%" + cond + "%"), Restrictions
						.like("keyword2", "%" + cond + "%")), Restrictions.or(
				Restrictions.like("keyword3", "%" + cond + "%"), Restrictions
						.like("keyword4", "%" + cond + "%"))), Restrictions.or(
				Restrictions.or(
						Restrictions.like("keyword5", "%" + cond + "%"),
						Restrictions.like("keyword6", "%" + cond + "%")),
				Restrictions.like("title", "%" + cond + "%"))));
		criteria.addOrder(Order.desc("releasetime"));
		criteria.setMaxResults(pageSize);
		criteria.setFirstResult(startRow);
		List<ZoyiNews> news = criteria.list();
		tx.commit();
		List<Object> list = new ArrayList<Object>();
		if (news != null) {
			for (ZoyiNews i : news) {
				list.add(NewsAdapter.toVo(i));
			}
		}
		return list;
	}

	public int getCountByCond(String cond) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ZoyiNews.class);
		criteria.add(Restrictions.or(Restrictions.or(Restrictions.or(
				Restrictions.like("keyword1", "%" + cond + "%"), Restrictions
						.like("keyword2", "%" + cond + "%")), Restrictions.or(
				Restrictions.like("keyword3", "%" + cond + "%"), Restrictions
						.like("keyword4", "%" + cond + "%"))), Restrictions.or(
				Restrictions.or(
						Restrictions.like("keyword5", "%" + cond + "%"),
						Restrictions.like("keyword6", "%" + cond + "%")),
				Restrictions.like("title", "%" + cond + "%"))));
		criteria.setProjection(Projections.rowCount());
		int i = StringAdapter.obj2Int(criteria.uniqueResult());
		return i;
	}

	public List<String> getNewNewsPicture(int pictureCount) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ZoyiNews.class);
		criteria.addOrder(Order.desc("releasetime"));
		criteria.setMaxResults(pictureCount);
		criteria.setProjection(Projections.property("picture"));
		List<String> list = criteria.list();
		tx.commit();
		return list;
	}

	public List<Object> queryBySoft(int startRow, int pageSize) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(ZoyiNews.class);
		criteria.addOrder(Order.desc("clickcount"));
		criteria.setMaxResults(pageSize);
		criteria.setFirstResult(startRow);
		List<ZoyiNews> zn = criteria.list();
		tx.commit();
		List<Object> list = new ArrayList<Object>();
		if (zn.size() > 0) {
			for (ZoyiNews i : zn) {
				list.add(NewsAdapter.toVo(i));
			}
		}
		return list;
	}

	public static void main(String args[]) throws Exception {

		System.out.println(new NewsDAO().getNewsPicture(1));

	}
}
