package org.zoyi.po;

import java.util.Date;



/**
 * ZoyiNewscategory entity. @author MyEclipse Persistence Tools
 */

public class ZoyiNewscategory  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String newscategoryname;
     private Date createdate;
     private String remark;


    // Constructors

    /** default constructor */
    public ZoyiNewscategory() {
    }

    
   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewscategoryname() {
        return this.newscategoryname;
    }
    
    public void setNewscategoryname(String newscategoryname) {
        this.newscategoryname = newscategoryname;
    }

    public Date getCreatedate() {
        return this.createdate;
    }
    
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

   








}