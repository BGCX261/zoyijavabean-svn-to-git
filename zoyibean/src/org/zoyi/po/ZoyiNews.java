package org.zoyi.po;

import java.util.Date;


/**
 * ZoyiNews entity. @author MyEclipse Persistence Tools
 */

public class ZoyiNews  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private ZoyiNewscategory zoyiNewscategory;
     private Date releasetime;
     private Integer publisherid;
     private String keyword1;
     private String keyword2;
     private String keyword3;
     private String keyword4;
     private String keyword5;
     private String keyword6;
     private String content;
     private String status;
     private String title;
     private String level;
     private String picture;
     private Integer clickcount;


    // Constructors

    /** default constructor */
    public ZoyiNews() {
    }


   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public ZoyiNewscategory getZoyiNewscategory() {
        return this.zoyiNewscategory;
    }
    
    public void setZoyiNewscategory(ZoyiNewscategory zoyiNewscategory) {
        this.zoyiNewscategory = zoyiNewscategory;
    }

    public Date getReleasetime() {
        return this.releasetime;
    }
    
    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public Integer getPublisherid() {
        return this.publisherid;
    }
    
    public void setPublisherid(Integer publisherid) {
        this.publisherid = publisherid;
    }

    public String getKeyword1() {
        return this.keyword1;
    }
    
    public void setKeyword1(String keyword1) {
        this.keyword1 = keyword1;
    }

    public String getKeyword2() {
        return this.keyword2;
    }
    
    public void setKeyword2(String keyword2) {
        this.keyword2 = keyword2;
    }

    public String getKeyword3() {
        return this.keyword3;
    }
    
    public void setKeyword3(String keyword3) {
        this.keyword3 = keyword3;
    }

    public String getKeyword4() {
        return this.keyword4;
    }
    
    public void setKeyword4(String keyword4) {
        this.keyword4 = keyword4;
    }

    public String getKeyword5() {
        return this.keyword5;
    }
    
    public void setKeyword5(String keyword5) {
        this.keyword5 = keyword5;
    }

    public String getKeyword6() {
        return this.keyword6;
    }
    
    public void setKeyword6(String keyword6) {
        this.keyword6 = keyword6;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getLevel() {
        return this.level;
    }
    
    public void setLevel(String level) {
        this.level = level;
    }

    public String getPicture() {
        return this.picture;
    }
    
    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getClickcount() {
        return this.clickcount;
    }
    
    public void setClickcount(Integer clickcount) {
        this.clickcount = clickcount;
    }
   








}