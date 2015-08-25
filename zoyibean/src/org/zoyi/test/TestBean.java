package org.zoyi.test;

import org.zoyi.jsf.JSFUtil;

public class TestBean {

	public TestBean() {
		
	}
	public String show(){
		String s = JSFUtil.getRequest().getParameter("show");
		System.out.println(s);
		return "back" ;
	}
}
