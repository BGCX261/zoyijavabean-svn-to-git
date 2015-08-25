package org.zoyi.po;



/**
 * UchomeEventfield entity. @author MyEclipse Persistence Tools
 */

public class UchomeEventfield  implements java.io.Serializable {


    // Fields    

     private Integer eventid;
     private String detail;
     private String template;
     private Integer limitnum;
     private Short verify;
     private Short allowpic;
     private Short allowpost;
     private Short allowinvite;
     private Short allowfellow;
     private String hotuser;


    // Constructors

    /** default constructor */
    public UchomeEventfield() {
    }

    
    /** full constructor */
    public UchomeEventfield(String detail, String template, Integer limitnum, Short verify, Short allowpic, Short allowpost, Short allowinvite, Short allowfellow, String hotuser) {
        this.detail = detail;
        this.template = template;
        this.limitnum = limitnum;
        this.verify = verify;
        this.allowpic = allowpic;
        this.allowpost = allowpost;
        this.allowinvite = allowinvite;
        this.allowfellow = allowfellow;
        this.hotuser = hotuser;
    }

   
    // Property accessors

    public Integer getEventid() {
        return this.eventid;
    }
    
    public void setEventid(Integer eventid) {
        this.eventid = eventid;
    }

    public String getDetail() {
        return this.detail;
    }
    
    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTemplate() {
        return this.template;
    }
    
    public void setTemplate(String template) {
        this.template = template;
    }

    public Integer getLimitnum() {
        return this.limitnum;
    }
    
    public void setLimitnum(Integer limitnum) {
        this.limitnum = limitnum;
    }

    public Short getVerify() {
        return this.verify;
    }
    
    public void setVerify(Short verify) {
        this.verify = verify;
    }

    public Short getAllowpic() {
        return this.allowpic;
    }
    
    public void setAllowpic(Short allowpic) {
        this.allowpic = allowpic;
    }

    public Short getAllowpost() {
        return this.allowpost;
    }
    
    public void setAllowpost(Short allowpost) {
        this.allowpost = allowpost;
    }

    public Short getAllowinvite() {
        return this.allowinvite;
    }
    
    public void setAllowinvite(Short allowinvite) {
        this.allowinvite = allowinvite;
    }

    public Short getAllowfellow() {
        return this.allowfellow;
    }
    
    public void setAllowfellow(Short allowfellow) {
        this.allowfellow = allowfellow;
    }

    public String getHotuser() {
        return this.hotuser;
    }
    
    public void setHotuser(String hotuser) {
        this.hotuser = hotuser;
    }
   








}