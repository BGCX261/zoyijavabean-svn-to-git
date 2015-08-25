<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员登陆</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/edit.css" />
</head>
<body>
<f:view>
	<div id="logo"><img src="images/logo.gif" /><img
		src="images/banner.png" /></div>
	<ul id="menu">
		<li><h:outputLink value="index.php">首页</h:outputLink></li>
		<li><h:outputLink value="user_group_activity_list.php">公益活动库</h:outputLink></li>
		<li><h:outputLink value="news_list.php" >公益新闻库</h:outputLink></li>
		<li style="width: 200px"></li>
		<li class="assistnav"><h:outputLink value="http://localhost/cq/home/index.php">社区</h:outputLink></li>
		<li class="assistnav"><h:outputLink value="#">帮助</h:outputLink></li>
		<li class="assistnav"><h:outputLink value="#">高级搜索</h:outputLink></li>
	</ul>
	<div class="location">您的位置：登陆</div>
	<h:form id="adminLoginForm">
		<table width="900" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="400" align="center" valign="top" id="logintd">
				<div id="panel"><h:form id="adminLoginForm">
					<span>用户名：<h:inputText id="email" styleClass="login" maxlength="15"
						value="#{admininfo.name }" required="true" requiredMessage="请输入密码！"/> </span>
					<br />
					<span>密<img src="images/1.gif" width="7" />码：<h:inputSecret
						id="pwd" styleClass="login" value="#{admininfo.pwd}" maxlength="45"
						required="true" requiredMessage="请输入密码！"/></span>
					<br />
					<span>验证码：<h:inputText id="txtCode" styleClass="login" size="6" maxlength="4"
						value="#{adminmodelbean.txtCode}" required="true" requiredMessage="请输入验证码！"/> </span>
					<br />
					<span><a4j:outputPanel id="detail_media">
					<a4j:commandLink reRender="detail_media" ajaxSingle="true">刷新页面刷新
						<a4j:mediaOutput element="img" cacheable="false" session="false"
							rendered="true" createContent="#{validateCodeImageData.paint}"
							value="#{validateCodeImageData}" mimeType="image/jpeg" />
					</a4j:commandLink>
				</a4j:outputPanel></span>
					<br />
					<span > <h:commandButton id="adminLoginCommand" type="submit"
						value="登录" action="#{adminmodelbean.login}" /> <h:commandButton
						id="adminResetCommand" type="reset" value="重置" /> </span>
					<br />
					<span><h:outputText value="#{adminmodelbean.errormsg}"></h:outputText> <h:messages></h:messages>
					<br/>
					</span>
				</h:form></div>
				</td>
				
			</tr>
		</table>
	</h:form>
	<div id="hr">
	<hr />
	</div>
	<div id="footer">
	<div><h:outputLink value="#">联系我们</h:outputLink> | <h:outputLink value="#">关于我们</h:outputLink> | <h:outputLink value="#">网站地图</h:outputLink>
	| <h:outputLink value="#">友情连接</h:outputLink> | <h:outputLink value="#">网站律师</h:outputLink></div>
	<div>CopyRight 2003 © 东华大学旭日工商管理学院 版权所有</div>
	<div>地址：上海市延安西路1882号 邮编：200051</div>
	</div>
</f:view>
</body>
</html>