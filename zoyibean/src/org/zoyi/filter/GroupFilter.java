package org.zoyi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.zoyi.service.GroupService;
import org.zoyi.service.UserService;
import org.zoyi.service.impl.GroupServiceImpl;
import org.zoyi.service.impl.UserServiceImpl;
import org.zoyi.vo.*;
import org.zoyi.adapter.StringAdapter;

public class GroupFilter implements Filter {

	private static boolean doBeforeProcessing(ServletRequest request) {
		HttpSession session = ((HttpServletRequest) request).getSession(true);
		// 首先检查session，若已经登陆则直接忽略一下代码
		int uid = StringAdapter.obj2Int(session.getAttribute("zoyiId"));
		if (session.getAttribute("zoyiGroup") != null
				&& "group".equalsIgnoreCase(StringAdapter.obj2str(session
						.getAttribute("zoyiIdentity"))) && uid > 0) {
			return true;
		}
		Cookie[] cookies = ((HttpServletRequest) request).getCookies();
		String uchome_auth = null;
		String username = null;
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("uchome_loginuser")) {
					username = c.getValue();
					continue;
				}
				if (c.getName().equals("uchome_auth")) {
					uchome_auth = c.getValue();
				}
			}
			if (username != null && uchome_auth != null) {
				Group group = null;
				UserService userService = new UserServiceImpl();
				GroupService groupService = new GroupServiceImpl();
				try {
					if ("group".equalsIgnoreCase(userService
							.findIdent(username))) {
						group = groupService.queryByUsername(username);
						session.setAttribute("zoyiId", group.getId());
						session.setAttribute("zoyiIdentity", "group");
						session.setAttribute("zoyiGroup", group);
						return true;
					}
				} catch (Exception e) {
					e.printStackTrace();
					session.removeAttribute("zoyiGroup");
				}
			}
		}
		return false;
	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (doBeforeProcessing(request)) {
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("user_login.jsp").forward(request,
					response);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
