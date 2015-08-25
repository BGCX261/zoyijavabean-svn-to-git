package org.zoyi.adapter;

public class NewsAdapter {
     public static org.zoyi.vo.News toVo(org.zoyi.po.ZoyiNews n){
    	 org.zoyi.vo.News news = new org.zoyi.vo.News();
    	 news.setContent(n.getContent());
    	 news.setInnerId(n.getId());
    	 news.setLevel(n.getLevel());
    	 news.setKeyword1(StringAdapter.obj2str(n.getKeyword1()));
    	 news.setKeyword2(StringAdapter.obj2str(n.getKeyword2()));
    	 news.setKeyword3(StringAdapter.obj2str(n.getKeyword3()));
    	 news.setKeyword4(StringAdapter.obj2str(n.getKeyword4()));
    	 news.setKeyword5(StringAdapter.obj2str(n.getKeyword5()));
    	 news.setKeyword6(StringAdapter.obj2str(n.getKeyword6()));
    	 news.setNewsCategory(NewsCategoryAdapter.toVo(n.getZoyiNewscategory()));
    	 news.setPicture(n.getPicture());
    	 news.setPublisherId(n.getPublisherid());
    	 news.setReleasetime(n.getReleasetime());
    	 news.setStatus(n.getStatus());
    	 news.setTitle(n.getTitle());
    	 return news;
     }
     
     public static org.zoyi.po.ZoyiNews toPo(org.zoyi.vo.News n){
    	 org.zoyi.po.ZoyiNews news = new org.zoyi.po.ZoyiNews();
    	 news.setZoyiNewscategory(NewsCategoryAdapter.toPo(n.getNewsCategory()));
    	 news.setContent(n.getContent());
    	 news.setId(n.getInnerId());
    	 news.setLevel(n.getLevel());
    	 news.setKeyword1(StringAdapter.obj2str(n.getKeyword1()));
    	 news.setKeyword2(StringAdapter.obj2str(n.getKeyword2()));
    	 news.setKeyword3(StringAdapter.obj2str(n.getKeyword3()));
    	 news.setKeyword4(StringAdapter.obj2str(n.getKeyword4()));
    	 news.setKeyword5(StringAdapter.obj2str(n.getKeyword5()));
    	 news.setKeyword6(StringAdapter.obj2str(n.getKeyword6()));
    	 news.setPicture(n.getPicture());
    	 news.setPublisherid(n.getPublisherId());
    	 news.setReleasetime(n.getReleasetime());
    	 news.setStatus(n.getStatus());
    	 news.setTitle(n.getTitle());
    	 return news;
     }
}
