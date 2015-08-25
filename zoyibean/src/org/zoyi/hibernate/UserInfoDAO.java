package org.zoyi.hibernate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.zoyi.adapter.StringAdapter;
import org.zoyi.adapter.UserinfoAdapter;
import org.zoyi.po.UcMembers;
import org.zoyi.po.UchomeSpace;
import org.zoyi.po.UchomeSpacefield;
import org.zoyi.util.MD5Generator;
import org.zoyi.vo.Userinfo;

public class UserInfoDAO {
	public void add(UcMembers u) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		u.setLastloginip(0);
		u.setLastlogintime(0);
		u.setSalt(java.util.UUID.randomUUID().toString().substring(0, 6));
		String p = MD5Generator.MD5(u.getPassword());
		u.setPassword(MD5Generator.MD5(p + u.getSalt()));
		u.setMyid("");
		u.setMyidkey("");
		u.setRegip("");
		java.util.Date date = new java.util.Date();
		u.setRegdate((int) (date.getTime() / 1000));
		u.setSecques("");
		session.saveOrUpdate(u);
		tx.commit();
		UcMembers um = this.queryUserByName(u.getUsername());
		UchomeSpace us = new UchomeSpace();
		UchomeSpacefield uf = new UchomeSpacefield();
		us.setAddfriend((short) 0);
		us.setAddfriendnum((short) 0);
		us.setAddsize(0);
		us.setAlbumnum((short) 0);
		us.setAttachsize(0);
		us.setAvatar((short) 0);
		us.setBlognum((short) 0);
		us.setCredit(0);
		us.setDateline(0);
		us.setDoingnum((short) 0);
		us.setDomain("");
		us.setEventinvitenum((short) 0);
		us.setEventnum((short) 0);
		us.setExperience(0);
		us.setFlag((short) 0);
		us.setFriendnum(0);
		us.setGroupid((short) 0);
		us.setIp(0);
		us.setLastlogin(um.getLastloginip());
		us.setLastpost(0);
		us.setLastsearch(0);
		us.setLastsend(0);
		us.setMood((short) 0);
		us.setMtaginvitenum((short) 0);
		us.setMyinvitenum((short) 0);
		us.setName(um.getUsername());
		us.setNamestatus((short) 0);
		us.setNewpm((short) 0);
		us.setNotenum(0);
		us.setPokenum((short) 0);
		us.setPollnum((short) 0);
		us.setRegip(um.getRegip());
		us.setSharenum((short) 0);
		us.setThreadnum((short) 0);
		us.setUid(um.getUid());
		us.setUpdatetime(0);
		us.setUsername(um.getUsername());
		us.setVideostatus((short) 0);
		us.setViewnum(0);
		uf.setAuthstr("");
		uf.setBirthcity("");
		uf.setBirthday((short) 1);
		uf.setBirthmonth((short) 1);
		uf.setBirthprovince("");
		uf.setBirthyear((short) 1900);
		uf.setBlood("");
		uf.setCss("");
		uf.setEmail(um.getEmail());
		uf.setEmailcheck((short) 0);
		uf.setFeedfriend("");
		uf.setFriend("");
		uf.setMagicexpire(0);
		uf.setMagicstar((short) 0);
		uf.setMarry((short) 0);
		uf.setMenunum((short) 0);
		uf.setMobile("");
		uf.setMsn("");
		uf.setMsncstatus((short) 0);
		uf.setMsnrobot("");
		uf.setNewemail("");
		uf.setNocss((short) 0);
		uf.setNote("");
		uf.setPrivacy("");
		uf.setQq("");
		uf.setResidecity("");
		uf.setResideprovince("");
		uf.setSendmail("");
		uf.setSex((short) 0);
		uf.setSpacenote("");
		uf.setTheme("");
		uf.setTimeoffset("");
		uf.setUid(um.getUid());
		uf.setVideopic("");
		Session session2 = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx2 = session2.beginTransaction();
		session2.save(us);
		session2.save(uf);
		tx2.commit();

	}

	public void update(Userinfo userInfo) {
		UcMembers u = this.get(userInfo.getUserId());
		u.setEmail(userInfo.getEmail());
		u.setUsername(userInfo.getName());
		u.setStatus(userInfo.getStatus());
		u.setPicture(userInfo.getPicture());
		u.setIndex(userInfo.getIndex());
		u.setCredit(userInfo.getCredit());
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(u);
		tx.commit();
	}

	public String isExist(String email, String pwd) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from UcMembers where username = ?");
		query.setString(0, email);
		UcMembers u = (UcMembers) query.uniqueResult();
		tx.commit();
		if (u != null) {
			String p = MD5Generator.MD5(pwd);
			String password = MD5Generator.MD5(p + u.getSalt());
			if (password.equals(u.getPassword())) {
				return "success";
			}
		}
		return "fail";
	}

	public void delete(int id) {
		UcMembers u = this.get(id);
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.delete(u);
		tx.commit();
	}

	public UcMembers get(int id) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		UcMembers u = (UcMembers) session.get(UcMembers.class, new Integer(id));
		tx.commit();
		return u;
	}

	public UcMembers login(String username, String pwd) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from UcMembers where username = ?");
		query.setString(0, username);
		UcMembers u = (UcMembers) query.uniqueResult();
		tx.commit();
		if (u != null) {
			String p = MD5Generator.MD5(pwd);
			String password = MD5Generator.MD5(p + u.getSalt());
			if (password.equals(u.getPassword())) {
				return u;
			}
		}
		return null;
	}

	public UcMembers getNewUser() {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UcMembers.class);
		criteria.addOrder(Order.desc("regdate"));
		criteria.setMaxResults(1);
		UcMembers u = (UcMembers) criteria.uniqueResult();
		tx.commit();
		return u;
	}

	public UcMembers getUserStar() {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UcMembers.class);
		criteria.addOrder(Order.desc("credit"));
		criteria.setMaxResults(1);
		UcMembers u = (UcMembers) criteria.uniqueResult();
		tx.commit();
		return u;
	}

	public void addCredit(int credit, int userId) {
		UcMembers u = this.get(userId);
		u.setCredit(u.getCredit() + credit);
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(u);
		tx.commit();
	}

	public static void main(String args[]) {
		System.out.println(java.util.UUID.randomUUID().toString().substring(0,
				6));
	}

	public UcMembers queryUserByName(String name) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from UcMembers where username = ?");
		query.setString(0, name);
		UcMembers u = (UcMembers) query.uniqueResult();
		tx.commit();
		return u;
	}

	public String getCodePwd(String name) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from UcMembers where username = ?");
		query.setString(0, name);
		UcMembers u = (UcMembers) query.uniqueResult();
		tx.commit();
		return MD5Generator.MD5(u.getPassword() + u.getSalt());
	}

	public boolean isRightPwd(String name, String codePwd) {
		if (codePwd.equals(this.getCodePwd(name)))
			return true;
		else
			return false;
	}

	public List<Object> queryBySoft(int startRow, int pageSize) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UcMembers.class);
		criteria.addOrder(Order.desc("credit"));
		criteria.setMaxResults(pageSize);
		criteria.setFirstResult(startRow);
		List<UcMembers> um = criteria.list();
		tx.commit();
		List<Object> list = new ArrayList<Object>();
		if (um != null) {
			for (UcMembers i : um) {
				list.add(UserinfoAdapter.toVo(i));
			}
		}
		return list;
	}

	public int getCount() {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UcMembers.class);
		criteria.setProjection(Projections.rowCount());
		int i = StringAdapter.obj2Int(criteria.uniqueResult());
		tx.commit();
		return i;

	}

	public Userinfo getFullUser(Userinfo userinfo) {
		int id = userinfo.getUserId();
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		UchomeSpace us = (UchomeSpace) session.get(UchomeSpace.class, id);
		UchomeSpacefield uf = (UchomeSpacefield) session.get(
				UchomeSpacefield.class, id);
		tx.commit();
		Calendar now = Calendar.getInstance();
		now.setTime(new java.util.Date());
		Calendar c = Calendar.getInstance();
		c.set(uf.getBirthyear(), uf.getBirthmonth() - 1, uf.getBirthday());
		userinfo.setAge(this.getAge(now, c));
		userinfo.setBirthCity(uf.getBirthcity());
		userinfo.setBirthday(c.getTime());
		userinfo.setBirthProvince(uf.getBirthprovince());
		userinfo.setGender(this.parseGender(uf.getSex()));
		userinfo.setNowAddress(uf.getResideprovince() + " "
				+ uf.getResidecity());
		userinfo.setPhone(uf.getMobile());
		userinfo.setBlood(uf.getBlood());
		userinfo.setName(us.getName());
		return userinfo;
	}

	public String findIdent(String username) {
		if (new GroupDAO().queryGroupByName(username) != null
				|| new AppliedGroupDAO().queryByName(username) != null) {
			return "group";
		} else if (this.queryUserByName(username) != null) {
			return "user";
		} else
			return null;
	}

	public List<Object> queryUserRankByCredit(int userId) {
		Userinfo u = new Userinfo();
		UcMembers um = this.get(userId);
		u.setUserId(um.getUid());
		u.setName(um.getUsername());
		int credit = um.getCredit();
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UcMembers.class);
		criteria.add(Restrictions.gt("credit", credit));
		criteria.setProjection(Projections.rowCount());
		int i = StringAdapter.obj2Int(criteria.uniqueResult());
		tx.commit();
		u.setRank(++i);
		List<Object> list = new ArrayList<Object>();
		list.add(u);
		return list;

	}

	private int getAge(Calendar now, Calendar birthDay) {
		int age = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
		if (now.get(Calendar.MONTH) < birthDay.get(Calendar.MONTH)) {
			age--;
		}
		if (now.get(Calendar.MONTH) == birthDay.get(Calendar.MONTH)
				&& now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
			age--;
		}
		return age;
	}

	private String parseGender(short i) {
		if (i == 1)
			return "男";
		else if (i == 2)
			return "女";
		else
			return "保密";
	}
}
