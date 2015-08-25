package org.zoyi.service.impl;

import java.util.List;

import org.zoyi.adapter.NewsAdapter;
import org.zoyi.hibernate.NewsDAO;
import org.zoyi.service.NewsService;
import org.zoyi.vo.News;

public class NewsServiceImpl implements NewsService {

	@Override
	public String add(News t) throws Exception {
		try {
			new NewsDAO().add(NewsAdapter.toPo(t));
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String delete(List<Integer> id) throws Exception {
		try {
			for (Integer i : id) {
				new NewsDAO().delete(i);
			}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String deleteById(int id) throws Exception {
		try {
			new NewsDAO().delete(id);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String isExist(News t) throws Exception {
		if (new NewsDAO().get(t.getInnerId()) != null) {
			return "success";
		} else {
			return "fail";
		}
	}

	@Override
	public String isExist(int id) throws Exception {
		try {
			if((new NewsDAO().get(id))!=null);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String modify(News t) throws Exception {
		try {
			new NewsDAO().update(NewsAdapter.toPo(t));
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public News queryById(int id) throws Exception {
		return NewsAdapter.toVo(new NewsDAO().get(id));
	}

	@Override
	public int getCount() throws Exception {
		return new NewsDAO().getCount();
	}

	@Override
	public List<String> getNewNewsPicture(int pictureCount) throws Exception {
		return new NewsDAO().getNewNewsPicture(pictureCount);
	}

	@Override
	public List<Object> queryByPage(int startRow, int pageSize)
			throws Exception {
		return new NewsDAO().queryByPage(startRow, pageSize);
	}

	@Override
	public List<Object> queryByNewsCategory(int startRow, int pageSize,
			int newsCategoryId) throws Exception {
		return new NewsDAO().queryByNewsCategory(startRow, pageSize, newsCategoryId);
	}

	@Override
	public List<Object> queryByCond(int startRow, int pageSize, String cond)
			throws Exception {
		return new NewsDAO().queryByCond(startRow, pageSize, cond);
	}

	@Override
	public List<Object> getNewFocusNews(int count) throws Exception {
		return new NewsDAO().getNewFocusNews(count);
	}

	@Override
	public String getNewsPicture(int newsId) throws Exception {
		return new NewsDAO().getNewsPicture(newsId);
	}

	@Override
	public String plusClick(int i,int newsId) throws Exception {
		try {
			new NewsDAO().countPlus(newsId);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public List<Object> queryBySoft(int startRow, int pageSize)
			throws Exception {
		return new NewsDAO().queryBySoft(startRow, pageSize);
	}

	@Override
	public int getCountByCond(String cond) throws Exception {
		return new NewsDAO().getCountByCond(cond);
	}

	@Override
	public int getNewsCountByCId(int newsCategoryId) throws Exception {
		return  new NewsDAO().getCountByCategory(newsCategoryId);
	}
}
