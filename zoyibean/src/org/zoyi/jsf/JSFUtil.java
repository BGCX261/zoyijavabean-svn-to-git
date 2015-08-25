package org.zoyi.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author xuechangfeng
 */
public class JSFUtil {
    public static HttpSession getSession(){
        HttpSession hs=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        return hs;
    }
    public static ServletContext getApplication(){
        ServletContext sc=(ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
        return sc;
    }
    public static HttpServletRequest getRequest(){
        HttpServletRequest hsr=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return hsr;
    }
    public static HttpServletResponse getResponse(){
    	HttpServletResponse resp=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        return resp;
    }
    public static void log(){
    	//getSession().getValueNames();
        //FacesContext.getCurrentInstance().getExternalContext().log("########################");    
    }
    public static void log(Exception e){
        //FacesContext.getCurrentInstance().getExternalContext().log("########################"+e.getMessage());
        //FacesContext.getCurrentInstance().getExternalContext().log("########################"+e.getCause());
    }
    public static void log(String s){
        //FacesContext.getCurrentInstance().getExternalContext().log("########################"+s);
    }
    public static FacesMessage createMessage(String message){
        return new FacesMessage(FacesMessage.SEVERITY_ERROR,message,message);
    }
    public static void addSystemMessage(String message){
        FacesContext fc=FacesContext.getCurrentInstance();
        fc.addMessage(null,createMessage(message));
    }
    public static void addComponentMessage(FacesContext fc,UIComponent c,String message){
        if(fc!=null){
            fc.addMessage(c.getClientId(fc),createMessage(message));
        }else{
            fc=FacesContext.getCurrentInstance();
            fc.addMessage(c.getClientId(fc),createMessage(message));
        }
    }
}
