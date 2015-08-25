package org.zoyi.adapter;

public class NewsCategoryAdapter {
     public static org.zoyi.vo.NewsCategory toVo(org.zoyi.po.ZoyiNewscategory zn){
    	 org.zoyi.vo.NewsCategory nc = new org.zoyi.vo.NewsCategory();
    	 nc.setCreateDate(zn.getCreatedate());
    	 nc.setId(zn.getId());
    	 nc.setNewsCategoryName(zn.getNewscategoryname());
    	 nc.setRemark(zn.getRemark());
    	 return nc;
     }
     
     public static org.zoyi.po.ZoyiNewscategory toPo(org.zoyi.vo.NewsCategory nc){
    	 org.zoyi.po.ZoyiNewscategory zn = new org.zoyi.po.ZoyiNewscategory();
    	 zn.setCreatedate(nc.getCreateDate());
    	 zn.setId(nc.getId());
    	 zn.setNewscategoryname(nc.getNewsCategoryName());
    	 zn.setRemark(nc.getRemark());
    	 return zn;
     }
}
