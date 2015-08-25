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

import org.zoyi.service.UserService;
import org.zoyi.service.impl.UserServiceImpl;
import org.zoyi.vo.Userinfo;
import org.zoyi.adapter.StringAdapter;

public class UserFilter implements Filter {
	private static boolean doBeforeProcessing(ServletRequest request) {
		HttpSession session = ((HttpServletRequest) request).getSession(true);
		// 首先检查session，若已经登陆则直接忽略一下代码
		int uid = StringAdapter.obj2Int(session.getAttribute("zoyiId"));
		if (session.getAttribute("zoyiUser") != null
				&& "user".equalsIgnoreCase(StringAdapter.obj2str(session
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
				Userinfo userinfo = null;
				UserService userService = new UserServiceImpl();
				try {
					if ("user"
							.equalsIgnoreCase(userService.findIdent(username))) {
						userinfo = userService.queryUserByName(username);
						session.setAttribute("zoyiId", userinfo.getUserId());
						session.setAttribute("zoyiIdentity", "user");
						session.setAttribute("zoyiUser", userinfo);
						return true;
					}
				} catch (Exception e) {
					e.printStackTrace();
					session.removeAttribute("zoyiUser");
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
