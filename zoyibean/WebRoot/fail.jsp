<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body> 
  <f:view>
  <h:messages ></h:messages><br/>
   <h:messages globalOnly="true"></h:messages>
    失败！This is my JSP page. <br>zoyi12<h:outputLink value="suc.php">zoyi12</h:outputLink><br>
    <h:form>
    	<h:commandLink action="#{link.releaseJournal}">link.releaseJournal</h:commandLink><br/>
    	<h:commandLink action="#{announcementBean.preModify}">announcementBean.preModify</h:commandLink>
    </h:form>
    </f:view>
  </body>
</html>
