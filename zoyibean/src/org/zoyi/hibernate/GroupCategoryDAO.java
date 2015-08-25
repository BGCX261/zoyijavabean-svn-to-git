package org.zoyi.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.zoyi.adapter.GroupCategoryAdapter;
import org.zoyi.po.UchomeProfield;
import org.zoyi.vo.GroupCategory;

public class GroupCategoryDAO {
	public UchomeProfield get(int id) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		UchomeProfield u = (UchomeProfield) session.get(UchomeProfield.class,
				new Integer(id));
		tx.commit();
		return u;
	}

	public List<GroupCategory> queryAll() {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from UchomeProfield");
		List<UchomeProfield> u = query.list();
		tx.commit();
		List<GroupCategory> list = new ArrayList<GroupCategory>();
		if (u.size() > 0) {
			for (UchomeProfield i : u) {
				list.add(GroupCategoryAdapter.toVo(i));
			}
		}
		return list;
	}
}
