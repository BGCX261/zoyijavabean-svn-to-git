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

import org.zoyi.adapter.StringAdapter;
import org.zoyi.service.GroupService;
import org.zoyi.service.UserService;
import org.zoyi.service.impl.GroupServiceImpl;
import org.zoyi.service.impl.UserServiceImpl;
import org.zoyi.vo.Group;
import org.zoyi.vo.Userinfo;

public class EncodingFilter implements Filter {

	public void destroy() {
	}

	private static boolean doBeforeProcessing(ServletRequest request) {
		HttpSession session = ((HttpServletRequest) request).getSession(true);
		// 首先检查session，若已经登陆则直接忽略一下代码
		int uid = StringAdapter.obj2Int(session.getAttribute("zoyiId"));
		if (uid > 0) {
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
				Userinfo userinfo = null;
				UserService userService = new UserServiceImpl();
				GroupService groupService = new GroupServiceImpl();
				try {
					String userIdentity = userService.findIdent(username);
					if ("user".equalsIgnoreCase(userIdentity)) {
						userinfo = userService.queryUserByName(username);
						session.setAttribute("zoyiId", userinfo.getUserId());
						session.setAttribute("zoyiIdentity", "user");
						session.setAttribute("zoyiUser", userinfo);
						return true;
					} else if ("group".equalsIgnoreCase(userIdentity)) {
						group = groupService.queryByUsername(username);
						session.setAttribute("zoyiId", group.getId());
						session.setAttribute("zoyiIdentity", "group");
						session.setAttribute("zoyiGroup", group);
						return true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
		doBeforeProcessing(request);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

}
