package org.zoyi.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.zoyi.adapter.BenifitActivityCategoryAdapter;
import org.zoyi.adapter.StringAdapter;
import org.zoyi.po.UchomeEventclass;

public class BenifitActivityCategoryDAO {
	public void add(UchomeEventclass u) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		u.setDisplayorder(0);
		u.setPoster((short) 0);
		u.setTemplate("");
		session.save(u);
		tx.commit();
	}

	public List<Object> queryByPage(int startRow, int pageSize) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeEventclass.class);
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(pageSize);
		List<UchomeEventclass> u = criteria.list();
		tx.commit();
		List<Object> list = new ArrayList<Object>();
		if (u != null) {
			for (UchomeEventclass i : u) {
				list.add(BenifitActivityCategoryAdapter.toVo(i));
			}
		}
		return list;
	}

	public UchomeEventclass get(int id) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		UchomeEventclass u = (UchomeEventclass) session.get(
				UchomeEventclass.class, (short)id);
		tx.commit();
		return u;
	}

	public int getCount() {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UchomeEventclass.class);
		criteria.setProjection(Projections.rowCount());
		int i = StringAdapter.obj2Int(criteria.uniqueResult());
		tx.commit();
		return i;

	}
}
