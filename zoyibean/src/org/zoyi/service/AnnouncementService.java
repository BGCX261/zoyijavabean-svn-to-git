package org.zoyi.service;

import java.util.List;

import org.zoyi.vo.Announcement;

public interface AnnouncementService extends Base<Announcement> {
	public List<Object> queryByPage(int startRow,int pageSize) throws Exception;
	public int getCount() throws Exception;
	public String plusClick(int i,int announcementId) throws Exception ;//点击率+i
	//查询cond
	public List<Object> queryByCond(int startRow,int pageSize,String cond) throws Exception;
	public int getCountByCond(int startRow,int pageSize,String cond) throws Exception;
}