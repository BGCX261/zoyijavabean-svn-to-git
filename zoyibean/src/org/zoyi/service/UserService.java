package org.zoyi.service;

import java.util.List;

import org.zoyi.vo.Userinfo;

public interface UserService extends Base<Userinfo>{
	// give u username & password,u give me whole Userinfo or null
	public Userinfo login(String username, String pwd) throws Exception;
	public int getCount() throws Exception;
	public Userinfo getNewUser() throws Exception;
	public Userinfo getUserStar() throws Exception;
	public List<Object> queryByPage(int startRow,int pageSize) throws Exception;
	public int getApplidPeopleCountByBAId(int baid) throws Exception;
	public List<Object> queryApplidPeopleByBAId(int startRow,int pageSize,int baid) throws Exception;
	public List<Object> queryBySoft(int startRow,int pageSize) throws Exception;
	public boolean isRightPwd(String name,String codePwd) throws Exception;
	public String getCodePwd( String name) throws Exception;
	public Userinfo queryUserByName(String name) throws Exception;
	public String applyActivity(int userId, int baid) throws Exception;//
	public String applyGroup(int userId, int gid) throws Exception;//
	public Userinfo getFullUser(Userinfo userinfo) throws Exception;
	public String findIdent(String username) throws Exception;//如果是user就返回给我"user"，如果是"group"就返回给我"group"，否则返回给我null
	public List<Object> queryUserRankByCredit(int userId) throws Exception;//给我该user以及他的rank
}
