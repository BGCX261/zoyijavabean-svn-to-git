package org.zoyi.model.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.zoyi.jsf.JSFUtil;
import org.zoyi.service.impl.UserServiceImpl;

public class EmailValidator implements Validator {

	private String errorMessage;

	public EmailValidator() {
		// TODO Auto-generated constructor stub
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void validate(FacesContext context, UIComponent component,
			Object pvalue) throws ValidatorException {

		this.errorMessage = this.emailValidate(pvalue);
		if (this.errorMessage != null) {
			//System.out.println(errorMessage);
			throw new ValidatorException(JSFUtil.createMessage("错误了！" + this.errorMessage));
		} else {
			//System.out.println(errorMessage);
		}
	}
	
	public String emailValidate(Object pvalue) {
		String value = ("" + pvalue).toString().trim();
		String rEmail = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$";
		if (value.matches(rEmail)) {
			return null;
		} else {
			return "email拼写错误，请重新检查！";
		}
	}

}
