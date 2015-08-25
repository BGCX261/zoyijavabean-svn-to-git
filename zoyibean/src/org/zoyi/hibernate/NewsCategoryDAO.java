package org.zoyi.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.zoyi.adapter.NewsCategoryAdapter;
import org.zoyi.po.ZoyiNewscategory;
import org.zoyi.vo.NewsCategory;

public class NewsCategoryDAO {
	public void add(ZoyiNewscategory n) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(n);
		tx.commit();
	}

	public ZoyiNewscategory get(int id) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		ZoyiNewscategory n = (ZoyiNewscategory) session.get(ZoyiNewscategory.class, new Integer(id));
		tx.commit();
		return n;
	}

	public void delete(int id) {
		ZoyiNewscategory n = this.get(id);
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.delete(n);
		tx.commit();
	}

	public void update(ZoyiNewscategory n) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(n);
		tx.commit();
	}
	
	public List<NewsCategory> queryAll(){
		List<ZoyiNewscategory> list = new ArrayList<ZoyiNewscategory>();
		List<NewsCategory> vlist = new ArrayList<NewsCategory>();
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session
				.createQuery("from ZoyiNewscategory order by createdate desc");
		list = query.list();
		tx.commit();
		for (ZoyiNewscategory c : list) {
			vlist.add(NewsCategoryAdapter.toVo(c));
		}
		return vlist;
	}
}
