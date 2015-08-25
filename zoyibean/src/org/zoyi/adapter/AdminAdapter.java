package org.zoyi.adapter;

public class AdminAdapter {
     public static org.zoyi.vo.Admininfo toVo(org.zoyi.po.ZoyiAdmin z){
    	 org.zoyi.vo.Admininfo a = new org.zoyi.vo.Admininfo();
    	 a.setEmail(z.getEmail());
    	 a.setGender(z.getGender());
    	 a.setIdentityCard(z.getIdentycard());
    	 a.setInnerId(z.getId());
    	 a.setMobilePhone(z.getMobilephone());
    	 a.setName(z.getName());
    	 a.setPwd(z.getPwd());
    	 a.setStatus(z.getStatus());
    	 return a;
     }
     
     public static org.zoyi.po.ZoyiAdmin toPo(org.zoyi.vo.Admininfo a){
    	 org.zoyi.po.ZoyiAdmin z = new org.zoyi.po.ZoyiAdmin();
    	 z.setEmail(a.getEmail());
    	 z.setGender(a.getGender());
    	 z.setId(a.getInnerId());
    	 z.setIdentycard(a.getIdentityCard());
    	 z.setMobilephone(a.getMobilePhone());
    	 z.setName(a.getName());
    	 z.setPwd(a.getPwd());
    	 z.setStatus(a.getStatus());
    	 return z;
     }
}
