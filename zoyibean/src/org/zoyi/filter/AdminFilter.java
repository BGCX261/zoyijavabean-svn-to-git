package org.zoyi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

import org.zoyi.vo.*;
import org.zoyi.adapter.StringAdapter;
import org.zoyi.jsf.JSFUtil;

public class AdminFilter implements Filter {
	
	public static boolean checkisAdmin(){
		HttpSession session = JSFUtil.getSession();
		int aid = StringAdapter.obj2Int(session.getAttribute("zoyiId"));
		String zoyiIdentity = StringAdapter.obj2str(session.getAttribute("zoyiIdentity"));
		Admininfo admin = (Admininfo)session.getAttribute("zoyiAdmin");
		if("admin".equalsIgnoreCase(zoyiIdentity) && admin!=null && aid>0)
			return true ;
		else
			return false ;
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpSession session = JSFUtil.getSession();
		int aid = StringAdapter.obj2Int(session.getAttribute("zoyiId"));
		String zoyiIdentity = StringAdapter.obj2str(session.getAttribute("zoyiIdentity"));
		Admininfo admin = (Admininfo)session.getAttribute("zoyiAdmin");
		if("admin".equalsIgnoreCase(zoyiIdentity) && admin!=null && aid>0){
			chain.doFilter(request,response) ;
		}else{
			JSFUtil.createMessage("您还没有登录或者您的权限不正确！");
			request.getRequestDispatcher("admin_login.jsp").forward(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	
}
