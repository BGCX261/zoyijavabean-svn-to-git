package org.zoyi.service;

import org.zoyi.vo.Admininfo;

public interface AdminService extends Base<Admininfo>{
	// give u username & password,u give me string "success" or "fail"
	public Admininfo login(String email, String pwd) throws Exception;
}