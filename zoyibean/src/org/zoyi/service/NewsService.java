package org.zoyi.service;

import java.util.List;

import org.zoyi.vo.*;

public interface NewsService extends Base<News> {
	public List<String> getNewNewsPicture(int pictureCount) throws Exception;
	public List<Object> queryByPage(int startRow,int pageSize) throws Exception;
	public int getCount() throws Exception;
	public List<Object> queryByNewsCategory(int startRow,int pageSize,int newsCategoryId) throws Exception;
	public List<Object> queryByCond(int startRow,int pageSize,String cond) throws Exception;	//从title,keyword里面找
	public int getCountByCond(String cond) throws Exception;
	public List<Object> getNewFocusNews(int Count) throws Exception ;
	public String getNewsPicture(int newsId) throws Exception ;
	public String plusClick(int i,int newsId) throws Exception ;//给newsId的新闻增加i的点击率
	public int getNewsCountByCId(int newsCategoryId) throws Exception ;
	public List<Object> queryBySoft(int startRow,int pageSize) throws Exception;//按照点击率
}