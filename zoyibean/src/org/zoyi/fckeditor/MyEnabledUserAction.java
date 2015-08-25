package org.zoyi.fckeditor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.zoyi.adapter.StringAdapter;

import net.fckeditor.requestcycle.UserAction;

/**
 * 2009-9-2
 * 
 * @author PengFei 此类可以从session中读取用户信息，判断是否有权限进行相关操作
 */
public class MyEnabledUserAction implements UserAction {

	// 权限--新建文件夹
	public boolean isCreateFolderEnabled(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int id = StringAdapter.obj2Int(session.getAttribute("zoyiId"));
		String identity = StringAdapter.obj2str(session
				.getAttribute("zoyiIdentity"));
		if (id > 0 && "admin".equals(identity)) {
			return true;
		}
		return false;
	}

	// 权限--浏览服务器上的文件列表
	public boolean isEnabledForFileBrowsing(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int id = StringAdapter.obj2Int(session.getAttribute("zoyiId"));
		String identity = StringAdapter.obj2str(session
				.getAttribute("zoyiIdentity"));
		if (id > 0
				&& ("group".equalsIgnoreCase(identity) || "admin"
						.equals(identity))) {
			return true;
		}
		return false;
	}

	// 权限--上传文件
	public boolean isEnabledForFileUpload(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int id = StringAdapter.obj2Int(session.getAttribute("zoyiId"));
		String identity = StringAdapter.obj2str(session
				.getAttribute("zoyiIdentity"));
		if (id > 0
				&& ("group".equalsIgnoreCase(identity) || "admin"
						.equals(identity))) {
			return true;
		}
		return false;
	}

}