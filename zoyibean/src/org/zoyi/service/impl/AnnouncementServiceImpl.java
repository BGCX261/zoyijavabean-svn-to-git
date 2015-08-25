package org.zoyi.service.impl;

import java.util.List;
import org.zoyi.service.AnnouncementService;
import org.zoyi.vo.Announcement;
import org.zoyi.adapter.AnnouncementAdapter;
import org.zoyi.hibernate.ZoyiAnnouncementDAO;

public class AnnouncementServiceImpl implements AnnouncementService {

	public AnnouncementServiceImpl() {

	}

	@Override
	public String add(Announcement t) throws Exception {
		try {
			new ZoyiAnnouncementDAO().add(AnnouncementAdapter.toPo(t));
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	public String delete(List<Integer> id) throws Exception {
		try {
			for (Integer i : id) {
				this.deleteById(i);
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
			new ZoyiAnnouncementDAO().delete(id);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String isExist(Announcement t) throws Exception {
		return this.isExist(t.getId());
	}

	@Override
	public String isExist(int id) throws Exception {
		if(new ZoyiAnnouncementDAO().get(id)!=null){
			return "success";
		}else{
			return "fail";
		}
	}

	@Override
	public String modify(Announcement t) throws Exception {
		try {
			new ZoyiAnnouncementDAO().update(AnnouncementAdapter.toPo(t));
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public Announcement queryById(int id) throws Exception {
		return AnnouncementAdapter.toVo(new ZoyiAnnouncementDAO().get(id));
	}

	public List<Object> queryByPage(int startRow, int pageSize) {
		return new ZoyiAnnouncementDAO().queryByPage(startRow, pageSize);
	}

	@Override
	public int getCount() {
		return new ZoyiAnnouncementDAO().getCount();
	}

	@Override
	public String plusClick(int i,int announcementId) throws Exception {
		try {
			new ZoyiAnnouncementDAO().plusClick(i, announcementId);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public int getCountByCond(int startRow, int pageSize, String cond)
			throws Exception {
		return new ZoyiAnnouncementDAO().countByCond(cond);
	}

	@Override
	public List<Object> queryByCond(int startRow, int pageSize, String cond)
			throws Exception {
		return new ZoyiAnnouncementDAO().queryByCond(startRow, pageSize, cond);
	}

}
