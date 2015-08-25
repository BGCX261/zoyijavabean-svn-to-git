package org.zoyi.fckeditor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.zoyi.adapter.StringAdapter;

import net.fckeditor.requestcycle.impl.ContextPathBuilder;

/**
 * 2009-9-2
 * 
 * @author PengFei 路径
 */
public class MyContextPathBuilder extends ContextPathBuilder {

	@Override
	public String getUserFilesPath(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int id = StringAdapter.obj2Int(session.getAttribute("zoyiId"));
		String identity = StringAdapter.obj2str(session
				.getAttribute("zoyiIdentity"));
		String s = super.getUserFilesPath(request);
		if (id > 0 && StringAdapter.isAvailableString(identity)) {
			s = s + "/" + identity + "/" + id;
		} else {
			s = s + "/userpath";
		}
		return s;
	}

	@Override
	public String getUserFilesAbsolutePath(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int id = StringAdapter.obj2Int(session.getAttribute("zoyiId"));
		String identity = StringAdapter.obj2str(session
				.getAttribute("zoyiIdentity"));
		String s = super.getUserFilesAbsolutePath(request);
		if (id > 0 && StringAdapter.isAvailableString(identity)) {
			s = s + "/" + identity + "/" + id;
		} else {
			s = s + "/userpath";
		}
		return s;
	}
}