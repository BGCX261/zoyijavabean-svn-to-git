package org.zoyi.validator;

import org.zoyi.vo.Userinfo;

public class EmailValidator{

	public EmailValidator() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String errorMessage ;
	private Userinfo userinfo;
	
	public void processAjax(){
		this.setErrorMessage(null);
		String value = (""+getUserinfo().getEmail()).toString().trim();
		String rEmail = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$";
		//System.out.println(this.getUserinfo().getEmail());
		if(value.matches(rEmail)){
			this.setErrorMessage("\\(^o^)/YES！");
		}else{
			this.setErrorMessage("email拼写错误哦，请重新检查！");
		}
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public Userinfo getUserinfo() {
		return userinfo;
	}
	
}
