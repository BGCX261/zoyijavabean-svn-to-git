package org.zoyi.hibernate;

import org.hibernate.*;
import org.zoyi.po.*;
public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		tx.commit();
	}

}
