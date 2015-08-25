package org.zoyi.test;

import org.zoyi.jsf.JSFUtil;

public class Link {

	public Link() {
		// TODO Auto-generated constructor stub
	}

	public String releaseJournal() {
		System.out.println(JSFUtil.getRequest().getParameter("content"));
		java.util.Map all = new java.util.HashMap();
		javax.servlet.http.HttpSession session = JSFUtil.getSession();
		all.put("1", "yi");
		all.put("2", "er");
		all.put("3", "san");
		all.put("4", "si");
		all.put("5", "wu");
		session.setAttribute("all", all);
		System.out.println(session.getAttribute("all"));
		return "user_release_journal.jsp";
	}

}
