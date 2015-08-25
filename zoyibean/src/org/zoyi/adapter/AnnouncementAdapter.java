package org.zoyi.adapter;

public class AnnouncementAdapter {
    public static org.zoyi.vo.Announcement toVo(org.zoyi.po.ZoyiAnnouncement a){
    	org.zoyi.vo.Announcement ann = new org.zoyi.vo.Announcement();
    	ann.setAnnouncer(a.getAnnouncer());
    	ann.setClickCount(a.getClickcount());
    	ann.setContent(a.getContent());
    	ann.setCreateDate(a.getCreatedate());
    	ann.setId(a.getId());
    	ann.setLevel(a.getLevel());
    	ann.setStatus(a.getStatus().charAt(0));
    	ann.setTitle(a.getTitle());
    	return ann;
    }
    
    public static org.zoyi.po.ZoyiAnnouncement toPo(org.zoyi.vo.Announcement a){
    	org.zoyi.po.ZoyiAnnouncement ann = new org.zoyi.po.ZoyiAnnouncement();
    	ann.setAnnouncer(a.getAnnouncer());
    	ann.setClickcount(a.getClickCount());
    	ann.setContent(a.getContent());
    	ann.setCreatedate(a.getCreateDate());
    	ann.setId(a.getId());
    	ann.setLevel(a.getLevel());
    	ann.setStatus(String.valueOf(a.getStatus()));
    	ann.setTitle(a.getTitle());
    	return ann;
    }
}
