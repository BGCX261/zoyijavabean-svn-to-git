package org.zoyi.service;

import java.util.List;

import org.zoyi.vo.*;;

public interface AppliedGroupService extends Base<AppliedGroup> {

	public List<Object> queryByPage(int startRow, int pageSize) throws Exception;
	public int getCount() throws Exception;
	public String acceptGroup(int id) throws Exception ;
	public String refuseGroup(int id) throws Exception ;
	public List<Object> queryByStatus(int status,int startRow, int pageSize) throws Exception;
	public int getCountByStatus(int status) throws Exception;
}
