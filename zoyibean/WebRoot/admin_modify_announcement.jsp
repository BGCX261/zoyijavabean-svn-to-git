<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改公告</title>
<style type="text/css">
<!--
body {
	background-color: #eee
}

#login {
	width: 720px;
	height: 450px;
	background: url(images/guanli.jpg) left top no-repeat;
	position: absolute;
	margin-left: -360px;
	left: 50%;
	top: 50%;
	margin-top: -225px;
}

#panel {
	width: 560px;
	height: 230px;
	margin: 110px auto
}

dl {
	margin: 20px auto 0;
	width: 200px;
	background: none;
	text-align: center;
}

dl dt {
	background: none;
	font-size: 13px;
	font-weight: bold;
	line-height: 30px;
}

dl dt a {
	display: block;
	width: 200px;
	color: #000;
	text-decoration: none;
	background: url(images/thispre.gif) no-repeat 36px 9px;
}

dl dt a:hover {
	background: url(images/this.gif) no-repeat 36px 9px;
	font-size: 14px;
}
//
-->
</style>
</head>
<body>
<f:view>
	<h1 align="center">修改公告</h1>
	<h:form id="modifyAnnouncement">
		<h:inputHidden value="#{announcementBean.announcement.clickCount}" />
		<h:inputHidden value="#{announcementBean.announcement.id}"
			required="true" />
		<table align="center">
			<tr>
				<td><h:outputLabel value="修改人：" for="announcer" /><h:inputText
					maxlength="20" requiredMessage="请输入您的姓名" id="announcer"
					required="true" value="#{announcementBean.announcement.announcer}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel for="title" value="公告标题：" /> <h:inputText
					title="公告标题" label="标题" id="title" maxlength="50"
					requiredMessage="您没有填写公告标题！"
					value="#{announcementBean.announcement.title}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel value="公告内容：" /><br />
				<FCK:editor instanceName="content" inputName="content"
					toolbarSet="Basic">
					<jsp:attribute name="value" trim="true">
						<c:out escapeXml="false"
							value="${announcementBean.announcement.content}" />
						</jsp:attribute>
					<jsp:body>
					<FCK:config />
				</jsp:body>
				</FCK:editor></td>
			</tr>
			<tr>
				<td><h:selectOneMenu id="announcementCategory" required="true" requiredMessage="请选择一个公告等级！"
					value="#{announcementBean.announcement.level}">
					<f:selectItem itemValue="0" itemLabel="公告等级" itemDisabled="true" />
					<f:selectItem itemValue="1" itemLabel="一" />
					<f:selectItem itemValue="2" itemLabel="二" />
					<f:selectItem itemValue="3" itemLabel="三" />
					<f:selectItem itemValue="4" itemLabel="四" />
				</h:selectOneMenu></td>
			</tr>
			<tr>
				<td><h:commandButton id="submit_modify_announcement"
					action="#{announcementBean.modify}" type="submit" value="修改" /> <h:commandButton
					id="reset_modify_announcement" type="reset" value="重置" /></td>
			</tr>
			<tr>
				<td><h:outputText id="errorinfo"
					value="#{announcementBean.errormsg}"></h:outputText><h:messages></h:messages>
				</td>
			</tr>
		</table>
	</h:form>
	<rich:spacer height="20" /><h:outputLink value="admin_release_announcement.php">新增公告</h:outputLink><br />
	<h:outputLink value="admin_manage_announcement.php">公告管理</h:outputLink><br />
	<h:outputLink value="admin_manage.php">管理首页</h:outputLink><br />
</f:view>
</body>
</html>