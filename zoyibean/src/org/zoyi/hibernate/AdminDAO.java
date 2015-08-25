package org.zoyi.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.zoyi.po.UcAdmins;
import org.zoyi.po.UcMembers;
import org.zoyi.po.ZoyiAdmin;
import org.zoyi.util.MD5Generator;
import org.zoyi.vo.Admininfo;

public class AdminDAO {
	public void add(ZoyiAdmin a) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		a.setSalt(java.util.UUID.randomUUID().toString().substring(0, 6));
		String p = MD5Generator.MD5(a.getPwd());
		a.setPwd(MD5Generator.MD5(p + a.getSalt()));
		session.save(a);
		tx.commit();
	}

	public void update(ZoyiAdmin a) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(a);
		tx.commit();
	}

	public ZoyiAdmin get(int id) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		ZoyiAdmin z = (ZoyiAdmin) session.get(ZoyiAdmin.class, new Integer(id));
		tx.commit();
		return z;
	}

	public void delete(int id) {
		ZoyiAdmin z = this.get(id);
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.delete(z);
		tx.commit();
	}

	public Admininfo login(String username, String pwd) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from UcAdmins where username = ?");
		query.setString(0, username);
		UcAdmins z = (UcAdmins) query.uniqueResult();
		tx.commit();
		if (z != null) {
			UcMembers u = new UserInfoDAO().login(username, pwd);
			if (u != null) {
				Admininfo a = new Admininfo();
				a.setEmail(u.getEmail());
				a.setGender("");
				a.setIdentityCard("");
				a.setName(username);
				a.setInnerId(z.getUid());
				a.setMobilePhone("");
				a.setPwd(pwd);
				a.setStatus("1");
				return a;
			}
		}
		return null;
	}
}
